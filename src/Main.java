import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] arrayOfCity = {"Ashdod" , " Tel-Aviv", "Eilat" ,"Ashkelon","Jerusalem","Rehovot","Haifa" ,"Bat-Yam" , "Baer-Sheva","Sderot"};
        String[] arrayOfStreets = {"Rimon street" , "Narkis street", "Rotem street" ,"Golani street","Givati street","Oliy Agardom street","Dov Brayer street" ,"Kalanit street" , "Tamar street","Africa street"};
        String[] arrayOfArea = {"south", "midland", "north" ,"sharon" ,"negev" };
        Scanner scanner= new Scanner(System.in);
        User user1 =new User("dan", "2" ,"051111111" ,false);
        City ashdod = new City(arrayOfCity[0],arrayOfArea[0],arrayOfStreets );
        Property a = new Property(ashdod , user1);
        a.setStreet("Rimon street");
        a.setFloor(0);
        a.setAmountOfRooms(3);
        a.setHouseNumber(6);
        a.setPrice(1000000);
        a.setType(1);
        System.out.println(a);
        RealEstate real = new RealEstate( user1 ,  ashdod);

    }

    public static void menu(int userChoose){
        do {
            if (userChoose==1){
                createAccount();
            } else if (userChoose==2) {
                login();
            }else if (userChoose==3) {
                break;
            }
        }while (userChoose < 0||userChoose>3);
    }
    public static void createAccount (){

    }
    public static void login(){

    }
}
