package project;

import java.io.*;
import java.util.Scanner;
import java.io.IOException;

class Product {
    private int total = 0;
    File myFile = new File("products.txt");
    Scanner sc_1 = new Scanner(System.in);

    void shop(){
        Scanner scan = null;
        {
            try {
                scan = new Scanner(myFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println("------------------Products------------------\n");
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            String[] productData = line.split(" / ");
            for (String x: productData) {
                System.out.println(x);
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------\n\n");
    }

    void add(String credentials){
        String c = credentials + ".txt";
        File f = new File(c);
        boolean flag = true;
        FileWriter fw = null;
        try {
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner sc = null;
        StringBuilder content = new StringBuilder("User: " + credentials + ">");
        try {
            sc = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int count = 1;
        int id;
        int quantity;
        boolean check;

        while (flag){
            check = false;
            System.out.println("Enter id of the product and quantity:");
            id = sc_1.nextInt();
            quantity = sc_1.nextInt();
            String Id = "Product-Id: " + id;

            if (sc != null) {
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    if (line.contains(Id)) {
                        content.append("Product-").append(count).append(": / ").append(line).append(">");
                        content.append("Quantity: ").append(quantity).append(">");
                        String[] s = line.split(" ");
                        total = total + Integer.parseInt(s[s.length - 1])*quantity;
                        check = true;
                        count++;
                        break;
                    }
                }

                if(!check){
                    System.out.println("Product not found!\n");
                }

                try {
                    sc = new Scanner(myFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                System.out.println("do you want to add more items? [Y/n]");
                char ch = sc_1.next().charAt(0);
                if(ch!='Y'){
                    flag = false;
                }
            }
            else{
                System.out.println("Error!");
            }
        }

        content.append("Total: ").append(total).append("\n\n");
        try {
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean view(String credentials) {
        String str = credentials + ".txt";
        File cart = new File(str);
        boolean check = false;
        Scanner s = null;
        try {
            s = new Scanner(cart);
        } catch (FileNotFoundException e) {
            System.out.println("File not Found!");
        }

        try {
            System.out.println("--------------------Cart--------------------");
            if(!cart.createNewFile()) {
                credentials = "User: " + credentials;

                int num;

                while (s.hasNextLine()) {
                    String l = s.nextLine();

                    if (l.startsWith(credentials)) {

                        String[] data = l.split(">");
                        num = data.length;
                        System.out.println(data[0]);

                        for (int i = 1; i <= num - 2; i++) {
                            if (i % 2 == 0) {
                                System.out.println(data[i]);
                                System.out.println();
                            } else {
                                String[] product = data[i].split(" / ");
                                for (String x : product) {
                                    System.out.println(x);
                                }
                            }
                        }
                        System.out.println(data[num - 1]);
                        check = true;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return check;
    }

    void Delete(String username){
        total = 0;
        File f = new File(username + ".txt");
        boolean b = f.delete();
        if(b){
            f = new File(username + ".txt");
        }
    }

    void total(){
        System.out.println(total);
    }
}