package project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Login li = new Login();
        Admin al = new Admin();
        Product product = new Product();
        String userName, password;
        boolean flag = true;
        boolean flag1;
        boolean check;

        menu: while(flag) {
            System.out.println("--------------------Menu--------------------");
            System.out.println("1. SignUp");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.println("--------------------------------------------");
            System.out.println("Enter your choice: ");
            byte n = sc.nextByte();

            if(n == 1) {
                System.out.println("------------------Sign-Up-------------------");
                System.out.println("1. User Sign-up");
                System.out.println("2. Admin Sign-up");
                System.out.println("3. Exit");
                System.out.println("--------------------------------------------");
                System.out.println("Enter your choice: ");
                byte c = sc.nextByte();

                if(c == 1) {
                    li.signUp();
                }
                else if(c == 2){
                    al.adminSignup();
                }
            }
            else if(n == 2) {
                System.out.println("-------------------Login--------------------");
                System.out.println("1. User Login");
                System.out.println("2. Admin Login");
                System.out.println("3. Exit");
                System.out.println("--------------------------------------------");
                System.out.println("Enter your choice: ");
                byte number = sc.nextByte();

                System.out.print("Enter Username: ");
                userName = sc.next();
                System.out.print("Enter Password: ");
                password = sc.next();

                if(number == 1) {
                    check = li.login(userName, password);
                    shop: while (true){
                        if(check){
                            product.shop();
                            System.out.println("1. Add to cart");
                            System.out.println("2. View cart");
                            System.out.println("3. Logout");
                            System.out.println("--------------------------------------------\n\n");
                            byte num = sc.nextByte();

                            switch(num){
                                case 1:
                                    product.add(userName);
                                    System.out.println("--------------------------------------------\n\n");
                                    System.out.println("1. View cart");
                                    System.out.println("2. Logout");
                                    System.out.println("--------------------------------------------\n\n");
                                    num = sc.nextByte();
                                    if(num == 1){
                                        flag1 = product.view(userName);
                                        if(flag1) {
                                            System.out.println("--------------------------------------------\n\n");
                                            System.out.println("1. Buy");
                                            System.out.println("2. Logout");
                                            System.out.println("--------------------------------------------\n\n");
                                            num = sc.nextByte();
                                            if (num == 1) {
                                                System.out.println("Products purchased successfully!");
                                                product.Delete(userName);
                                                break;
                                            } else {
                                                break shop;
                                            }
                                        }
                                        else{
                                            System.out.println("Cart is empty!");
                                            System.out.println("--------------------------------------------\n\n");
                                            break;
                                        }
                                    }
                                    else{
                                        break shop;
                                    }

                                case 2:
                                    flag1 = product.view(userName);
                                    if(flag1) {
                                        System.out.println("--------------------------------------------\n\n");
                                        System.out.println("1. Buy");
                                        System.out.println("2. Logout");
                                        System.out.println("--------------------------------------------\n\n");
                                        num = sc.nextByte();
                                        if (num == 1) {
                                            System.out.println("Products purchased successfully!");
                                            product.Delete(userName);
                                            break;
                                        } else {
                                            break shop;
                                        }
                                    }
                                    else{
                                        System.out.println("Cart is empty!");
                                        System.out.println("--------------------------------------------\n\n");
                                        break;
                                    }

                                case 3:
                                    break shop;

                                default:
                                    break;
                            }
                        }

                        else{
                            System.out.println("Invalid credentials!");
                            break;
                        }
                    }
                }

                else if(number == 2){
                    System.out.println("Enter admin id:");
                    int id = sc.nextInt();
                    check = al.adminLogin(id, userName, password);

                    product: while (true) {
                        if(check){
                            System.out.println("--------------------------------------------\n\n");
                            System.out.println("1. Add product");
                            System.out.println("2. View all products");
                            System.out.println("3. Logout");
                            System.out.println("--------------------------------------------\n\n");
                            byte a = sc.nextByte();

                            switch (a){
                                case 1:
                                    al.product();
                                    break;
                                case 2:
                                    product.shop();
                                    break ;
                                case 3:
                                    break product;
                                default:
                                    break;
                            }
                        }
                    }
                }
            }

            else if(n == 3){
                break;
            }
            else{
                System.out.println("Invalid choice!");
            }
        }
    }
}
