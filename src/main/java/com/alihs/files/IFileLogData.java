package com.alihs.files;

import java.io.File;


public interface IFileLogData {

    String logLocalDateTime();

    void logFileInfo();

    File logFileCreator(String url);

    File[] logFileList();

    void logFileWriter(String username, String password);

    String logFileReader();

    void logFileDeleter();





}
