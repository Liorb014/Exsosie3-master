import java.util.Scanner;

public class RealEstate {
  private  User[] usersArray;
  private Property[] properties;
  private City[] cities;
  int postCount = 0 ;

  public RealEstate(User user , City city){
   // cities = new City[10];
    String[] arrayOfCity = {"Ashdod" , " Tel-Aviv", "Eilat" ,"Ashkelon","Jerusalem","Rehovot","Haifa" ,"Bat-Yam" , "Baer-Sheva","Sderot"};
    String[] arrayOfStreets = {"Rimon street" , "Narkis street", "Rotem street" ,"Golani street","Givati street","Oliy Agardom street","Dov Brayer street" ,"Kalanit street" , "Tamar street","Africa street"};
    String[] arrayOfArea = {"south", "midland", "north" ,"sharon" ,"negev" };
    for (int i = 0; i <arrayOfCity.length ; i++) {
      if (arrayOfCity[i]=="Ashdod"||arrayOfCity[i]=="Ashkelon")
      cities[i] = new City(arrayOfCity[i], arrayOfArea[2] ,arrayOfStreets);

    }
  }
  private static String machArea (String[] listOfCities) {
    for (int i = 0; i <listOfCities.length; i++) {
      if (listOfCities[i] == "Ashdod" || listOfCities[i] == "Ashkelon") {
      }
    }
    return "hey";
  }
  public void createUser(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("please enter a user name: ");
    String username ;
    boolean alreadyUse;
    if(usersArray[0]!=null) {
      do {
        username = scanner.nextLine();
        alreadyUse = false;
        for (int i = 0; i < usersArray.length; i++) {
          if (username.equals(usersArray[i].getUserName())) {
            alreadyUse = true;
            System.out.println("this username is already taken, please choose another username");
            username = scanner.nextLine();
            break;
          }
        }
      } while (alreadyUse);
    }else {
      username = scanner.nextLine();

    }
    System.out.println("please enter a password that contains at least one number or one of the next signs:($,%,_) and have a length of 5 digits: ");
    String password=scanner.nextLine();
    while (isValidPassword(password)) {
      System.out.println("this password is not strong enough please try again and make sure you doing it in the right demands  ");
      password = scanner.nextLine();
    }
    System.out.println("please enter your phone number (only 10 digits without '-' or pre number(972) and is an israeli number)");
    String phoneNumber = scanner.nextLine();
    while (validPhoneNumber(phoneNumber)) {
      System.out.println("number invalid");
      System.out.println("enter correct phone number");
      phoneNumber = scanner.nextLine();
    }
    System.out.println("are u a broker Y/N?");
    String isBroker = scanner.nextLine();
    boolean broker=false;
    while (!isBroker.equals("y") && !isBroker.equals("n")){
      System.out.println("please enter only 'y' or 'n'!");
      isBroker=scanner.nextLine();
    }
    if (isBroker.equals("y")) {
      broker = true;
    }
    if (isBroker.equals("n")){
      broker = false;
    }
    User newUser= new User(username,password,phoneNumber, broker);
    for (int i = 0; i < usersArray.length; i++) {
      if(usersArray[i]==null){
        usersArray[i]=newUser;
      }
    }
  }

  private static boolean isValidPassword(String password) {
    boolean isValid = true;
    if (password.length()>5 && (password.contains("%") || password.contains("$") || password.contains("-"))
            && (password.contains("1") || password.contains("2") || password.contains("3") || password.contains("4") ||
            password.contains("5") || password.contains("6") || password.contains("7") || password.contains("8") ||
            password.contains("9"))){
      isValid =false;
    }
    return isValid;
  }
  private static boolean validPhoneNumber (String phoneNumber) {
    boolean isValid = true;
    if ((phoneNumber.startsWith("05"))&&(phoneNumber.length() == 10) &&( phoneNumber.contains("1") || phoneNumber.contains("2") || phoneNumber.contains("3")
            || phoneNumber.contains("4") || phoneNumber.contains("5") || phoneNumber.contains("6")
            || phoneNumber.contains("7")|| phoneNumber.contains("8")|| phoneNumber.contains("9")|| phoneNumber.contains("0"))){
      isValid =false;
    }
    return isValid;
  }

  User login(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("please enter your username: ");
    String usernameLogin = scanner.next();
    System.out.println("please enter your password: ");
    String passwordLogin = scanner.next();
    boolean isUsernameValid = false;
    boolean isPasswordValid = false;
    int count =0 ;
    for (int i = 0 ; i < usersArray.length ; i++) {
      if(usersArray[i].getUserName().equals(usernameLogin)){
        isUsernameValid = true;
        count = i;
        break;
      }
    }
    if(usersArray[count].getPassword().equals(passwordLogin)){
      isPasswordValid = true;
    }
    User loginInfoValid = null;
    if(isUsernameValid && isPasswordValid){
      loginInfoValid =usersArray[count];
    }
    return loginInfoValid;
  }

  boolean postNewProperty(User user){

    if(( user.getIsBrokers() && postCount==5 ) || ( !user.getIsBrokers() && postCount==2 )){
      return false;
    }
    System.out.println(cities);


    return true;
  }
  void removeProperty(User use){

  }
  void printAllProperties(){

  }
  void printProperties (User user){

  }
  Property[] search (){

    return new Property[0];
  }

}