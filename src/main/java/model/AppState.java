package model;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class AppState {
    private static HashMap<File, String> encryptWindowFiles;
    private static HashMap<File, String> decryptWindowFiles;
    private static List<String> encryptWindowLabels;
    private static List<String> decryptWindowLabels;
    private static File currentWorkDir;
    private static File defaultTargerDir;
    private static File recentTargerDir;
    private static File selectedTargerDir;

    public static HashMap<File, String> getEncryptWindowFiles() {
        return encryptWindowFiles;
    }

    public static void setEncryptWindowFiles(HashMap<File, String> encryptWindowFiles) {
        AppState.encryptWindowFiles = encryptWindowFiles;
    }

    public static HashMap<File, String> getDecryptWindowFiles() {
        return decryptWindowFiles;
    }

    public static void setDecryptWindowFiles(HashMap<File, String> decryptWindowFiles) {
        AppState.decryptWindowFiles = decryptWindowFiles;
    }

    public static List<String> getEncryptWindowLabels() {
        return encryptWindowLabels;
    }

    public static void setEncryptWindowLabels(List<String> encryptWindowLabels) {
        AppState.encryptWindowLabels = encryptWindowLabels;
    }

    public static List<String> getDecryptWindowLabels() {
        return decryptWindowLabels;
    }

    public static void setDecryptWindowLabels(List<String> decryptWindowLabels) {
        AppState.decryptWindowLabels = decryptWindowLabels;
    }

    public static File getCurrentWorkDir() {
        return currentWorkDir;
    }

    public static void setCurrentWorkDir(File currentWorkDir) {
        AppState.currentWorkDir = currentWorkDir;
    }

    public static File getDefaultTargerDir() {
        return defaultTargerDir;
    }

    public static void setDefaultTargerDir(File defaultTargerDir) {
        AppState.defaultTargerDir = defaultTargerDir;
    }

    public static File getRecentTargerDir() {
        return recentTargerDir;
    }

    public static void setRecentTargerDir(File recentTargerDir) {
        AppState.recentTargerDir = recentTargerDir;
    }
}
