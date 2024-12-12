package com.alihs.files;

import lombok.Data;
import lombok.ToString;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

//LOMBOK

@Data
@ToString

public class FilePathDataImplements implements IFileLogData {
    //Variables

    private String id;
    private String filePathName;
    private String fileDirectoryName;
    private String url;
    private File file;
    private Date systemCreatedDate;

    public FilePathDataImplements() {
        this.id = UUID.randomUUID().toString();
        this.systemCreatedDate = new Date(System.currentTimeMillis());
        this.fileDirectoryName = FilePathUrl.MY_FILES_PATH;

    }

    @Override
    public String logLocalDateTime() {

        Locale locale = Locale.of("tr","TR");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale); //pattern: zzzz => time zone.
        Date date = new Date();

        return sdf.format(date);
    }

    @Override
    public String logFileInfo() {
        return "";
    }

    @Override
    public void logFileCreator(String fileName) {
        this.filePathName = "\\"+fileName+".txt";
        this.url = fileDirectoryName.concat(filePathName);
        this.file = new File(url);
        try {

            if (file.exists()){
                System.out.println(fileName+" file already exists!");
            }

            else if(file.createNewFile()){
                System.out.println("The file has been created!");
            }

            else{
                System.out.println("The file has not been created!");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public File[] logFileList() {
        File[] fileList = new File(this.fileDirectoryName).listFiles();

        assert fileList != null;
        return fileList;
    }

    @Override
    public void logFileWriter(File file, String text) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
            String nowDate = logLocalDateTime();
            String value = "["+nowDate+"] "+text;
            bw.write(value+"\n");
            System.out.println("Text has been added!");
            bw.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String logFileReader(File file) {
        String rows; //the row being read
        StringBuilder builder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            while ((rows = br.readLine()) != null){
                builder.append(rows).append("\n");
            }

            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String logFileDeleter() {
        return "";
    }
    //Test

    public static void main(String[] args) {
        FilePathDataImplements fpdi = new FilePathDataImplements();

        fpdi.logFileCreator("car");
        fpdi.logFileCreator("weapons");

        File weapons = new File(fpdi.fileDirectoryName.concat("\\weapons.txt"));
        File car = new File(fpdi.fileDirectoryName.concat("\\car.txt"));

        fpdi.logFileWriter(weapons,"M4A1-S");
        fpdi.logFileWriter(weapons,"AK-47");
        fpdi.logFileWriter(car,"BMW M3 E46 GTR");
        fpdi.logFileWriter(car,"TOYOTA SUPRA");

        System.out.println("ALL FİLES AND THEİR CONTENTS");
        System.out.println("----------------------------------------------");

        for (File file: fpdi.logFileList()){
            System.out.println(file.getName());
            System.out.println("-----------");
            System.out.println(fpdi.logFileReader(file));
            System.out.println("-------------------------");
        }

    }

}
