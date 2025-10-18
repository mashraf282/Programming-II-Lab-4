package Base;

import Admin.AdminRole;
import Admin.EmployeeUser;
import Employee.CustomerProduct;
import Employee.EmployeeRole;
import Employee.Product;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       // go all out, good luck
        boolean active = true;
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the password if you're an admin(press enter if you,re not):");
        if(scanner.nextLine().equals("admin")){
            AdminRole admin = new AdminRole();
            while(active){
                System.out.println("1- Add employee");
                System.out.println("2- List all employees");
                System.out.println("3- remove employee");
                System.out.println("else exit");
                choice = scanner.nextInt();
                switch(choice){
                    case 1:
                        System.out.print("enter employee ID:");
                        String id = scanner.nextLine();
                        System.out.print("enter employee name:");
                        String name = scanner.nextLine();
                        System.out.print("enter employee email:");
                        String email = scanner.nextLine();
                        System.out.print("enter employee address:");
                        String address = scanner.nextLine();
                        System.out.print("enter employee phone number:");
                        String phone_num = scanner.nextLine();
                        admin.addEmployee(id, name, email, address, phone_num);
                        break;

                    case 2:
                        EmployeeUser[] employees = admin.getListOfEmployees();
                        for(EmployeeUser employee: employees){
                            employee.lineRepresentation();
                            System.out.println();
                        }break;

                    case 3:
                        System.out.print("Enter employee id:");
                        id = scanner.nextLine();
                        admin.removeEmployee(id);
                        break;

                    default:
                        admin.logout();
                        active = false;
                        break;
                }
            }
        }
        //comment for good luck
        else {
            EmployeeRole emp = new EmployeeRole();
            while(active){
                System.out.println("1- add product");
                System.out.println("2- list all products");
                System.out.println("3- purchase history");
                System.out.println("4- make purchase");
                System.out.println("5- refund purchase");
                System.out.println("else exit");
                choice = scanner.nextInt();
                switch(choice) {
                    case 1:
                        System.out.print("enter product id:");
                        String id = scanner.nextLine();
                        System.out.print("enter product name:");
                        String name = scanner.nextLine();
                        System.out.print("enter supplier name:");
                        String supp_name = scanner.nextLine();
                        System.out.print("enter manufacturer name:");
                        String man_name = scanner.nextLine();
                        System.out.print("enter product quantity:");
                        int quan = scanner.nextInt();
                        emp.addProduct(id, name, man_name, supp_name, quan);
                        break;

                    case 2:
                        Product[] products = emp.getListOfProducts();
                        for (Product product : products) {
                            product.lineRepresentation();
                            System.out.println();
                        }

                    case 3:
                        CustomerProduct[] purchases = emp.getListOfPurchasingOperations();
                        for (CustomerProduct purchase : purchases) {
                            purchase.lineRepresentation();
                            System.out.println();
                        }

                    case 4:
                        System.out.print("enter customer ssn:");
                        String ssn = scanner.nextLine();
                        System.out.print("enter product id:");
                        id = scanner.nextLine();
                        LocalDate date = LocalDate.now();

                        if (emp.purchaseProduct(ssn, id, date))
                            if (emp.applyPayment(ssn, date))
                                System.out.println("purchase successful");

                            else
                                System.out.println("out of stock");

                    case 5:
                        System.out.print("enter customer ssn:");
                        ssn = scanner.nextLine();
                        System.out.print("enter product id:");
                        id = scanner.nextLine();
                        CustomerProduct[] history = emp.getListOfPurchasingOperations();
                        for(CustomerProduct purchase : history){
                            if(purchase.getCustomerSSN().equals(ssn) && purchase.getProductID().equals(id)) {
                                Double return_price = emp.returnProduct(purchase.getCustomerSSN(), purchase.getProductID(), purchase.getPurchaseDate(), LocalDate.now());
                                System.out.println("refunded product's price: " + return_price);
                            }
                        }

                    default:
                        emp.logout();
                        active = false;
                        break;
                }
            }
        }
    }
}