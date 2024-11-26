package com.alihs.files;

import java.util.List;

public interface IFileLogData {

    public String logLocalDateTime();

    public String logFileInfo();

    public String logFileCreator(String fileName);

    public List<String> logFileList();

    public String logFileWriter();

    public String logFileReader();

    public String logFileDeleter();





}
