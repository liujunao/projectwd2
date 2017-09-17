package com.commons;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by lenovo on 2017/7/7.
 */
public class GetDes {

    public String GetDesKey() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/DesKey.properties");
        Properties properties = new Properties();
        String value = null;

        try {
            properties.load(inputStream);
            value = properties.getProperty("key");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream != null){
                inputStream.close();
            }
        }
        return value;
    }
}
