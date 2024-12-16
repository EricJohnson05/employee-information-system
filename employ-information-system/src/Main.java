import javax.management.Query;
import javax.swing.*;
import java.util.Scanner;
/*
     The system can perform the following operations :
     Initial menu:selection mode including admin and user,when you choose admin the origin password is 123456
     Admin:(1)input employee identity information
           (2)delete employee identity information
           (3)Query employee identity information
           (4)Change employee identification information, such as position and phonenumber
           (5)Print the list of required employee information
           (6)Release tasks to employees
           (7)Change your password
           (8)Back to main menu
           (9)Exit
     User: (1)Query published tasks
           (2)View personal information
           (3)Back to main menu
           (4)Exit
*/
public class Main {
    public dataBase ourcompany=new dataBase();//Add an object called ourcompany to the database
    public admin admin=new admin();//Add an object called admin to the admin
    public Scanner input=new Scanner(System.in);
    int count =0;//This parameter is used to determine whether the administrator mode is entered for the first time
    public static void main(String[] args) {
        System.out.println("Welcome to the company's employee identity information data processing system");
        Main driver=new Main();//Add a driver object to main to prevent stack overflow due to too many methods
        driver.initialize();
        driver.setup();
    }
    public void initialize(){
        admin.setPassword(String.valueOf(123456));//set origin password

    }
    public int mainMenu(){
        System.out.println("(1)input employee identity information");
        System.out.println("(2)delete employee identity information");
        System.out.println("(3)Query employee identity information");
        System.out.println("(4)Change employee identification information, such as position and phonenumber");
        System.out.println("(5)Print the list of required employee information ");
        System.out.println("(6)Release tasks to employees");
        System.out.println("(7)Change your password");
        System.out.println("(8)Back to main menu");
        System.out.println("(9)Exit");
        System.out.println("Please enter the action options you want to perform");
        int option=input.nextInt();
        return option;
    }
    private void runMenu(){
        int option=mainMenu();
        while (option!=0){
            switch (option){
                case 1 -> inputEmployee();
                case 2 -> deleteEmployee();
                case 3 -> queryEmployee();
                case 4 -> changeEmployeeInformation();
                case 5 -> printlist();
                case 6 -> releaseTask();
                case 7 -> Changepassword();
                case 8 -> Backmenu();
                case 9 -> exit();
                default -> System.out.println("Invalid option entered"+option);
            }
            System.out.println("Press enter key to continue");
            input.nextLine();
            input.nextLine();
            option=mainMenu();
        }
        System.out.println("exiting,bye!");
        System.exit(0);
    }//Execute method according to user input information
    public void setup(){
        System.out.println("What is your login method? user/admin");
        String loginMethod =input.next();
        if(loginMethod.equals("user")){
            user();
        }
        if(loginMethod.equals("admin")){
            check();
        }
    }//Opening guidance
    //admin
    public void exit () {
        System.out.println("See you next time");
        System.exit(0);
    }
    public void inputEmployee(){
        input.nextLine();
        System.out.println("enter the employ's name");
        String name=input.nextLine();
        System.out.println("enter the gender");
        String gender=input.nextLine();
        System.out.println("enter the ID");
        String ID=input.next();
        System.out.println("enter the dateOfBirth");
        String dateOfBirth=input.next();
        System.out.println("enter the thing position");
        String position=input.next();
        System.out.println("enter the phoneNumber");
        String phoneNumber=input.next();
        employ temp=new employ(name,gender,ID,dateOfBirth,phoneNumber,position);
        boolean isadded=ourcompany.add(temp);
        if(isadded){
            System.out.println("Employee information entered successfully");
        }
        else {
            System.out.println("No employee information entered");
        }
    }//Employee information is entered into an array of the ourcompany object and checked for success
    public void printlist(){
        System.out.println("employees are");
        System.out.println(ourcompany.list());
    }
    public void deleteEmployee(){
        System.out.println("enter the ID you want to delete");
        String ID=input.next();
        ourcompany.deleteEmployee(ID);
    }
    private void queryEmployee(){
        input.nextLine();
        System.out.println("enter a employ's ID");
        String ID=input.nextLine();
        employ queryEmployee = ourcompany.find(ID);
        if(queryEmployee==null){
            System.out.println("There are no employ with the ID [" + ID + "] in the system.");
        }
    }//Query employee information by id and detect
    public void changeEmployeeInformation(){
        System.out.println("enter the ID of the employee you want to change");
        String ID=input.next();
        if(ourcompany.changeInformation(ID)) {
            System.out.println("What information do you want to change? ");
            System.out.println("1. Phone number");
            System.out.println("2. Position");
            int choice = input.nextInt();
            while (choice != 0) {
                switch (choice) {
                    case 1 -> changePhonenumber();
                    case 2 -> changePosition();
                    default -> System.out.println("Invalid choice entered" + choice);
                }
            }
        }
        else {
            System.out.println("what you want to change doesn't exist");
        }
    }//Change employee information and reference different methods through the switch method
    public void changePhonenumber(){
        System.out.println("Enter your new phone number");
        String phonenumber=input.next();
        ourcompany.changephnumber(phonenumber);

    }
    public void changePosition(){
        System.out.println("Enter your new Position");
        String position=input.next();
        ourcompany.changeposition(position);

    }
    public void releaseTask(){
        System.out.println("Enter the ID of who you want to release the task to");
        String employeeID =input.next();
        employ IDtask = ourcompany.taskIDtest(employeeID);
        if(IDtask==null){
            System.out.println("There are no employ with the ID [" + employeeID + "] in the system.");
            System.out.println("Please try again");
            releaseTask();
        }
        System.out.println("Enter the task you want to release");
        String tasks =input.next();
        ourcompany.release(tasks,employeeID);
    }//release task
    public void Changepassword(){
        System.out.println("Enter your new password");
        String newpwd =input.next();
        admin.change(newpwd);
    }// change a password, is a method in the admin object
    public void check(){
        System.out.println("You have 3 chances to enter the password");
        System.out.println("//tip: Initial password: 123456, the administrator can change after entering the system");
        int chance =3;
        for (int i = 0; i < 3; i++) {
            System.out.println("Please enter the administrator password");
            String password = input.next();
            if(admin.test(password)){
                System.out.println("Password correct, login successful");
                if(count==0) {
                    System.out.println("How many employee information do you want to store?");
                    int num = input.nextInt();
                    ourcompany.system(num);
                    String task ="无";
                    admindo origin = new admindo(task);
                    ourcompany.update(origin);
                    count++;
                    runMenu();
                }
                runMenu();
            }
            else{
                chance--;
                System.out.println("You still have "+chance+" more chances");
            }
            System.out.println("Failed login");
            setup();
        }
    }//Password verification and executive admin menu
    public void Backmenu(){
        setup();
    }//Return to the main menu and select a new mode
    //user
    public void user(){
        System.out.println("What do you want to do? ");
        System.out.println("1. Query published tasks");
        System.out.println("2. View personal information");
        System.out.println("3. Back to main menu");
        System.out.println("4. Exit");
        int choice = input.nextInt();
        while (choice != 0) {
            switch (choice) {
                case 1 -> task();
                case 2 -> view();
                case 3 -> Backmenu();
                case 4 -> exit();
                default -> System.out.println("Invalid choice entered" + choice);
            }
        }
    }
    public void task(){
        System.out.println("enter your ID");
        String ID=input.next();
        admindo queryEmployee = ourcompany.taskquery(ID);
        if(queryEmployee==null){
            System.out.println("There are no employ with the ID [" + ID + "] in the system.");
            user();
        }
        else{
            user();
        }
    }//Task query, and detect whether there is this for the employee, if not then call the user method to redo
    public void view(){
        input.nextLine();
        System.out.println("enter your ID");
        String ID=input.nextLine();
        employ queryEmployee = ourcompany.find(ID);
        user();
        if(queryEmployee==null){
            System.out.println("There are no employ with the ID [" + ID + "] in the system.");
            user();
        }
    }
}