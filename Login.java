package project;

import java.io.*;
import java.util.Scanner;

class Login extends Website {
    Scanner sc = new Scanner(System.in);
    String credentials = "";
    String content = "";
    //    SIGNUP code
    @Override
    void signUp(){
        try {
            FileWriter fw = new FileWriter("user.txt", true);
            BufferedWriter bf = new BufferedWriter(fw);
            String temp = content;
            System.out.print("Enter Full Name: ");
            content = "\n" + sc.nextLine() + "\n";

            System.out.print("Enter Email-Address: ");
            content += sc.nextLine() + "\n";

            content += temp;
            System.out.print("Enter Username: ");
            content += sc.nextLine() + " ";

            System.out.print("Enter Password: ");
            content += sc.nextLine() + "\n\n";

            bf.write(content);
            bf.close();

            System.out.println("Signup successfully!");
        }
        catch (IOException e) {
            System.out.println("Error: Signup Failed !");
            e.printStackTrace();
        }
    }

    //    LOGIN code
    boolean login(String username, String password){
        boolean flag = true;
        try {
            FileReader myFile = new FileReader("user.txt");
            Scanner scan = new Scanner(myFile);         // scan object will scan text from myFile
            credentials = credentials + username + " " + password;

            while (scan.hasNextLine()) {
                if (scan.nextLine().equals(credentials)) { // checking for username
                    credentials = "";
                    return true;
                }
            }
        }
        catch (IOException e) {
            System.out.println("Unable to Read File, Check path again");
            e.printStackTrace();
        }
        credentials = "";
        return false;
    }
}

class AdminLogin extends Login{
    void adminSignup(){
        System.out.println("Enter admin id:");
        super.content = super.content + sc.nextLine();
        super.signUp();
    }

    boolean adminLogin(int id, String username, String password){
        super.credentials = super.credentials + id;
        return super.login(username, password);
    }

    void product(){
        try {
            FileWriter f = new FileWriter("products.txt", true);
            BufferedWriter b = new BufferedWriter(f);
            String s = "";

            System.out.print("Enter Product-Id: ");
            s = "\nProduct-Id: " + sc.nextLine() + " / ";

            System.out.print("Enter Product-name: ");
            s += "Product-name: " + sc.nextLine() + " / ";

            System.out.println("Enter Price: ");
            s += "Price: " + sc.nextLine() + "\n\n";

            b.write(s);
            b.close();
        } catch (IOException e) {
            System.out.println("Unable to Read File, Check path again");
            e.printStackTrace();
        }
    }
}