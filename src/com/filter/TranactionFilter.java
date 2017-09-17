package com.filter;

import com.commons.ConnectionContext;
import com.db.JDBCUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by lenovo on 2017/7/16.
 */
@WebFilter(filterName = "TranactionFilter",urlPatterns = "/*")
public class TranactionFilter implements Filter {

    JDBCUtils jdbcUtils = new JDBCUtils();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Connection connection = null;

        try {
            connection = jdbcUtils.getConnection();
            //开启事务
            connection.setAutoCommit(false);
            //利用ThreadLocal把连接和当前线程绑定
            ConnectionContext.getInstance().bind(connection);
            //把请求转给目标 Servlet
            chain.doFilter(req, resp);
            //提交事务
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();

            //回滚事务
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) resp;
            response.sendRedirect(request.getContextPath() + "error.jsp");
        }finally {
            //解除绑定
            ConnectionContext.getInstance().remove();
            jdbcUtils.closeAll(connection,null,null);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
