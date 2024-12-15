package com.alihs.controller;

import com.alihs.dao.RegisterDao;
import com.alihs.files.FilePathDataImplements;

import java.util.Scanner;

public class RegisterController {
    boolean loggedIn = false;
    public void login(){
        Scanner sc1 = new Scanner(System.in);
        String defaultEmail = "alihsancbn@gmail.com";
        String defaultPassword = "123456";
        System.out.println("Login");
        for (int i = 1;i<=3;i++){
            System.out.print("Insert e-mail: ");
            String email = sc1.next();
            System.out.print("Insert pasword: ");
            String password = sc1.next();
            if (email.equals(defaultEmail) && password.equals(defaultPassword)){
                loggedIn = true;
                while (loggedIn){
                    allProcess();
                }
                System.out.print("Do you want to re-login? Y/N: ");
                char choice = sc1.next().charAt(0);
                if (choice == 'n'||choice == 'N'){
                    System.exit(0);
                }
            }else {
                if (i!=3) {
                    System.out.println("Access denied, you have "+(3 - i)+" tries left!");
                }else {
                    System.out.println("Out of tries, system locked, unable to log in!");
                }
            }
        }
    }

    private final RegisterDao regDao = new RegisterDao();

    private void allProcess(){
        FilePathDataImplements fpdi = new FilePathDataImplements();
        Scanner sc = new Scanner(System.in);


        while (loggedIn) {
            System.out.println("""
                Please make a choice:
                1-) File Information
                2-) List File
                3-) Create File
                4-) Write File
                5-) Read File
                6-) Delete File
                7-) Log Out
                """);
            int insideAppChoice = sc.nextInt();
            switch (insideAppChoice) {
                case 1:
                    regDao.information();
                    break;
                case 2:
                    regDao.fileList();
                    break;
                case 3:
                    Scanner sc2 = new Scanner(System.in);
                    System.out.print("Insert name to create file: ");
                    String fileName = sc2.nextLine();
                    String url = fpdi.getFileDirectoryName().concat("\\"+fileName+".txt");
                    fpdi.setFile(regDao.fileCreate(url));
                    break;
                case 4:
                    Scanner sc3 = new Scanner(System.in);
                    System.out.print("Please insert username: ");
                    String username = sc3.nextLine();
                    System.out.print("Please insert password: ");
                    String password = sc3.nextLine();
                    regDao.fileWrite(username, password);
                    break;
                case 5:
                    regDao.fileRead();
                    break;
                case 6:
                    regDao.fileDelete();
                    break;
                case 7:
                    System.out.println("Logging out...");
                    loggedIn = false;
                    break;

            }
        }
    }
}
