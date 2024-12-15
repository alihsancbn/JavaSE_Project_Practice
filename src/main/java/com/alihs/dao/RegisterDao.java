package com.alihs.dao;

import com.alihs.files.FilePathDataImplements;
import com.alihs.files.FilePathUrl;

import java.io.File;

public class RegisterDao implements IDaoGenerics {

    public FilePathDataImplements fpdi = new FilePathDataImplements();


    @Override
    public void information() {
        fpdi.logFileInfo();
    }

    @Override
    public void fileList() {
        for (File file: fpdi.logFileList()){
            System.out.println(file.getName());
        }

    }

    @Override
    public File fileCreate(String url) {
       return fpdi.logFileCreator(url);
    }

    @Override
    public void fileWrite(String username, String password) {
        fpdi.logFileWriter(username, password);
    }

    @Override
    public void fileRead() {
        System.out.println(fpdi.logFileReader());
    }

    @Override
    public void fileDelete() {
        fpdi.logFileDeleter();
    }

}
