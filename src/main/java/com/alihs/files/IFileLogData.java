package com.alihs.files;

import java.io.File;


public interface IFileLogData {

    String logLocalDateTime();

    String logFileInfo();

    void logFileCreator(String fileName);

    File[] logFileList();

    void logFileWriter(File file, String text);

    String logFileReader(File file);

    String logFileDeleter();





}
