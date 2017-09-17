package com.commons;

import java.sql.Connection;

/**
 * Created by lenovo on 2017/7/16.
 */
public class ConnectionContext {

    public ConnectionContext() {
    }
    private static ConnectionContext instance = new ConnectionContext();

    public static ConnectionContext getInstance(){
        return instance;
    }

    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    public void bind(Connection connection){
        connectionThreadLocal.set(connection);
    }

    public Connection get(){
        return connectionThreadLocal.get();
    }

    public void remove(){
        connectionThreadLocal.remove();
    }
}
