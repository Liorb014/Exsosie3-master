
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(RealEstate realEstate){

        Scanner scanner = new Scanner(System.in);
        int userChoose;
        do {
            System.out.println("welcome to 'yad 2' \n please choose : \n  1  - to create user \n 2 - to login \n 3 - to exit ");
            userChoose=scanner.nextInt();
        }while (userChoose<1|| userChoose>3);
        if (userChoose==1){
            realEstate.createUser();
        } else if (userChoose==2) {
            User user =realEstate.login();
            if (user==null){
                menu(realEstate);
            }else {
                subMenu(user);
            }
        }else if (userChoose==3) {
        }
    }
    public static void subMenu(User user){
        Scanner scanner = new Scanner(System.in);
        RealEstate realEstate = new RealEstate();
        System.out.println("press 1 to make new post");
        System.out.println("press 2 to remove post");
        System.out.println("press 3 to to see all the properties");
        System.out.println("press 4 to to see all your properties");
        System.out.println("press 5 to to search for properties");
        System.out.println("press 6 to to search for properties");
        int userChoose;
        do {
            userChoose= scanner.nextInt();
        }while (userChoose<1 || userChoose>6);
        if(userChoose == 1){
            realEstate.postNewProperty(user);
            subMenu(user);
        }
        else if(userChoose == 2){
            realEstate.removeProperty(user);
            subMenu(user);
        }
        else if(userChoose == 3){
            realEstate.printAllProperties();
            subMenu(user);
        }
        else if(userChoose == 4){
            realEstate.printProperties(user);
            subMenu(user);
        }
        else if(userChoose == 5){
            realEstate.search();
            subMenu(user);
        }
        else if(userChoose == 6){
            System.out.println("back to the main");
        }
    }
}
