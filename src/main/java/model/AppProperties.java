package model;

import java.io.*;
import java.util.HashMap;
import java.util.List;
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

    /* Current directories */
    public static String getCurrentWorkdir() {
        return appProperties.getProperty("current.workdir");
    }

    public static void setCurrentWorkdir(String workDir) {
        appProperties.setProperty("current.workdir", workDir);

        String propertiesPath = AppProperties.class.getResource("/properties/app.properties").getPath();
        System.out.println(propertiesPath);
        try {
            appProperties.store(new FileOutputStream(new File(propertiesPath)), "update properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDefaultWorkdir() {
        return appProperties.getProperty("default.workdir");
    }

    public static void setDefaultWorkdir(String workDir) {
        appProperties.setProperty("default.workdir", workDir);
        String propertiesPath = AppProperties.class.getResource("/properties/app.properties").getPath();
        System.out.println(propertiesPath);
        try {
            appProperties.store(new FileOutputStream(new File(propertiesPath)), "update properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Settings */

    private static HashMap<File, String> encryptWindowFiles;
    private static HashMap<File, String> decryptWindowFiles;
    private static List<String> encryptWindowLabels;
    private static List<String> decryptWindowLabels;
//    private static File currentWorkDir;
    private static File defaultTargerDir;
    private static File recentTargerDir;
    private static File selectedTargerDir;

    public static HashMap<File, String> getEncryptWindowFiles() {
        return encryptWindowFiles;
    }

    public static void setEncryptWindowFiles(HashMap<File, String> encryptWindowFiles) {
        AppProperties.encryptWindowFiles = encryptWindowFiles;
    }

    public static HashMap<File, String> getDecryptWindowFiles() {
        return decryptWindowFiles;
    }

    public static void setDecryptWindowFiles(HashMap<File, String> decryptWindowFiles) {
        AppProperties.decryptWindowFiles = decryptWindowFiles;
    }

    public static List<String> getEncryptWindowLabels() {
        return encryptWindowLabels;
    }

    public static void setEncryptWindowLabels(List<String> encryptWindowLabels) {
        AppProperties.encryptWindowLabels = encryptWindowLabels;
    }

    public static List<String> getDecryptWindowLabels() {
        return decryptWindowLabels;
    }

    public static void setDecryptWindowLabels(List<String> decryptWindowLabels) {
        AppProperties.decryptWindowLabels = decryptWindowLabels;
    }

//    public static File getCurrentWorkDir() {
//        return currentWorkDir;
//    }

//    public static void setCurrentWorkDir(File currentWorkDir) {
//        AppState.currentWorkDir = currentWorkDir;
//    }

    public static File getDefaultTargerDir() {
        return defaultTargerDir;
    }

    public static void setDefaultTargerDir(File defaultTargerDir) {
        AppProperties.defaultTargerDir = defaultTargerDir;
    }

    public static File getRecentTargerDir() {
        return recentTargerDir;
    }

    public static void setRecentTargerDir(File recentTargerDir) {
        AppProperties.recentTargerDir = recentTargerDir;
    }
}
