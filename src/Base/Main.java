package Base;

import Admin.AdminRole;
import Admin.EmployeeUser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       // go all out, good luck
        boolean active = true;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the password if you're an admin(press enter if you,re not):");
        if(scanner.nextLine().equals("admin")){
            AdminRole admin = new AdminRole();
            while(active){
                System.out.println("1- Add employee");
                System.out.println("2- List all employees");
                System.out.println("3- remove employee");
                int choice = scanner.nextInt();
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
                        }break;

                    case 3:
                        System.out.print("Enter employee id:");
                        id = scanner.nextLine();
                        admin.removeEmployee(id);
                        break;

                    default:
                        admin.logout();
                }
            }

        }
        else
            System.out.println("boooo");
    }
}