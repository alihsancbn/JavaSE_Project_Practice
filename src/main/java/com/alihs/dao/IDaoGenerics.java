package com.alihs.dao;

import java.io.File;

//DAO GENERICS
public interface IDaoGenerics {

    void information();
    void fileList();
    File fileCreate(String url);
    void fileWrite(String username, String password);
    void fileRead();
    void fileDelete();




}
