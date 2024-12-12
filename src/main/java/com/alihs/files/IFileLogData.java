package com.alihs.files;

import java.util.List;

public interface IFileLogData {

    public String logLocalDateTime();

    public String logFileInfo();

    public String logFileCreator(String fileName);

    public List<String> logFileList();

    public void logFileWriter(String username, String password);

    public void logFileReader();

    public String logFileDeleter();





}
