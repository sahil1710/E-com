package project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Admin extends Login{
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
