package com.alihs.files;

import lombok.Data;

import java.io.File;
import java.util.Date;
import java.util.List;

//LOMBOK

@Data
public class FilePathDataImplementsFile implements IFileLogData {
    //Variables - Değişkenler

    private String id;
    private String filePathName;
    private String fileDirectoryName;
    private String url;
    private File file;
    private Date systemCreatedDate;


    @Override
    public String logLocalDateTime() {
        return "";
    }

    @Override
    public String logFileInfo() {
        return "";
    }

    @Override
    public String logFileCreator(String fileName) {
        return "";
    }

    @Override
    public List<String> logFileList() {
        return List.of();
    }

    @Override
    public String logFileWriter() {
        return "";
    }

    @Override
    public String logFileReader() {
        return "";
    }

    @Override
    public String logFileDeleter() {
        return "";
    }
}
