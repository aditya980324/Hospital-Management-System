package hc.hms.config;


import com.aventstack.extentreports.Status;
import hc.hms.thread.ThreadLocalUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
    private static final String path = "./src/main/resources/configFiles/hmsConfig.properties";
    private String data="";
    public String getPropertyData(String key) {
        try(FileInputStream fis = new FileInputStream(path)) {
            Properties pObj = new Properties();
            pObj.load(fis);
            data=pObj.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //ThreadLocalUtility.getTest().log(Status.INFO,"Data fetched from Property file is "+data);
        return data;
    }
}
