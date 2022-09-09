package config;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

public class AppProperties {
    private static Properties appProperties;

    /* Load properties file */

    static {
        InputStream propertiesStream = AppProperties.class.getResourceAsStream("/properties/app.properties");
        Properties properties = new Properties();
        try {
            properties.load(propertiesStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        AppProperties.appProperties = properties;
    }

    /* Current directory */

    public static void setCurrentWorkdir(String workDir) {
        appProperties.setProperty("dir.current", workDir);
        storeProperties();
    }

    public static String getCurrentWorkdir() {
        return appProperties.getProperty("dir.current");
    }

    /* Settings */

    //saving options
    public enum SaveOption {
        saveInCurrentDir,
        saveInDefaultDir;
    }

    public static void saveIn(SaveOption option) {
        switch (option) {
            case saveInCurrentDir -> {
                appProperties.setProperty("savein.currentdir", "true");
                appProperties.setProperty("savein.defaultdir", "false");
            }
            case saveInDefaultDir -> {
                appProperties.setProperty("savein.currentdir", "false");
                appProperties.setProperty("savein.defaultdir", "true");
            }
        }
        storeProperties();
    }

    public static SaveOption getSaveSetting(){
        return appProperties.getProperty("savein.defaultdir").equals("true") ?
                SaveOption.saveInDefaultDir : SaveOption.saveInCurrentDir;
    }

    // default directory
    public static void setDefaultDir(String path) {
        appProperties.setProperty("dir.default", path);
        storeProperties();
    }

    public static String getDefaultDir() {
        return appProperties.getProperty("dir.default");
    }

    /* Store properties */

    public static void storeProperties() {
        String propertiesPath = Objects.requireNonNull(AppProperties.class
                        .getResource("/properties/app.properties"))
                .getPath();
        try {
            appProperties.store(new FileOutputStream(new File(propertiesPath)), "update properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}