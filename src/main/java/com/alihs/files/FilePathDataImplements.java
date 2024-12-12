package com.alihs.files;

import lombok.Data;
import lombok.ToString;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

//LOMBOK

@Data
@ToString

public class FilePathDataImplements implements IFileLogData {
    //Variables - Değişkenler

    private String id;
    private String filePathName;
    private String fileDirectoryName;
    private String url;
    private File file;
    private Date systemCreatedDate;

    public FilePathDataImplements() {
        this.id = UUID.randomUUID().toString();
        this.systemCreatedDate = new Date(System.currentTimeMillis());
        this.filePathName = "\\car.txt";
        this.fileDirectoryName = FilePathUrl.MY_CAR_FILE_PATH_URL;
        this.url = fileDirectoryName.concat(filePathName);
        this.file = new File(url);
        //İlgili dosya yoksa yeni bir tane oluştur. Varsa mevcut dosyayı kullan.
        try {
            if (file.exists()){
                System.out.println(url+" dosyası mevcut, yeni dosya oluşturulmadı.");
            }else{
                file.createNewFile();
                System.out.println("Dosya oluşturuldu.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String logLocalDateTime() {

        Locale locale = new Locale("tr","TR");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale); //pattern: zzzz => time zone.
        Date date = new Date();
        String changeDate = sdf.format(date);
        return changeDate;
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
    public void logFileWriter(String username, String password) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
            String nowDate = logLocalDateTime();
            String value = "["+nowDate+"]"+ username+" "+password;
            bw.write(value+"\n");
            System.out.println("Eklendi");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void logFileReader() {
        String rows; //okunan satır
        StringBuilder builder = new StringBuilder();
        String builderToString;
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            while ((rows = br.readLine()) != null){
                builder.append(rows).append("\n");
            }
            builderToString = builder.toString();
            System.out.println("LOGLAMA: \n"+builderToString);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
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
        fpdi.logFileWriter("alihsan", "12345");
        fpdi.logFileWriter("KaiserWII", "kfseqo");
        fpdi.logFileReader();

    }

}
