package com.alihs.files;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;
import java.text.SimpleDateFormat;

import java.util.Scanner;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
//LOMBOK
@Data
@ToString
@Getter
@Setter
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
        this.url = this.fileDirectoryName.concat("\\Users.txt");
        this.file = new File(this.url);
    }

    @Override
    public String logLocalDateTime() {

        Locale locale = Locale.of("tr","TR");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale); //pattern: zzzz => time zone.
        Date date = new Date();

        return sdf.format(date);
    }

    @Override
    public void logFileInfo() {
        Scanner sc = new Scanner(System.in);
        logFileList();
        System.out.print("Please insert the name of the file you want to get info of: ");
        String fileNameInfo = sc.nextLine().concat(".txt");
        String url = fileDirectoryName.concat("\\"+fileNameInfo);
        System.out.println("File Directory: "+url);
        File info = new File(url);
        System.out.println("Can be executed: "+info.canExecute());
        System.out.println("Can be read: "+info.canRead());
        System.out.println("Can be wrote: "+info.canWrite());
        System.out.println("Is a file: "+info.isFile());
        System.out.println("Is a directory: "+info.isDirectory());
        System.out.println("Parent: "+info.getParent());
        System.out.println("Is hidden: "+info.isHidden());
        System.out.println("Is free HDD: "+info.getFreeSpace());
        System.out.println("Last modified: "+ new Date(info.lastModified()));
    }

    @Override
    public File logFileCreator(String url) {
        File newFile = new File(url);
        try {

            if (newFile.exists()){
                System.out.println(newFile.getName()+" file already exists!");
                return newFile;
            }

            else if(newFile.createNewFile()){
                System.out.println("The file has been created!");
                return newFile;
            }

            else{
                System.out.println("The file has not been created!");
                return null;
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
    public void logFileWriter(String username, String password) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
            String nowDate = logLocalDateTime();
            String value = "["+nowDate+"] "+username+" "+password;
            bw.write(value+"\n");
            System.out.println("Text has been added!");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String logFileReader() {
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
    public void logFileDeleter() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert the file name: ");
        String fileName = sc.nextLine().concat(".txt");
        System.out.print("Are you sure about deleting \""+fileName+"\"? Y/N: ");
        char sure = sc.nextLine().charAt(0);
        if (sure == 'y' || sure == 'Y'){
            try {
                File Delete = new File(this.fileDirectoryName.concat("\\"+fileName));
                if (Delete.exists()){
                    if (Delete.delete()){
                        System.out.println("The file has been deleted!");
                    } else{
                        System.out.println("The file has not been deleted!");
                    }
                }else {
                    System.out.println(fileName+" does already not exist!");
                }
            }catch (Exception e){
                throw new RuntimeException();
            }
        }
    }
    //Test


}
