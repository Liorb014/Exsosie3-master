import java.util.Scanner;

public class RealEstate {
  private User[] usersArray;
  private Property[] properties;
  private City[] cities;


  public RealEstate(User user, City city) {
    matchArea();
  }

  private void matchArea() {
    String[] arrayOfCity = {"Ashdod", "Tel-Aviv", "Eilat", "Ashkelon", "Jerusalem", "Rehovot", "Haifa", "Bat-Yam", "Baer-Sheva", "Herzelia"};
    String[] arrayOfStreets = {"Rimon street", "Narkis street", "Rotem street", "Golani street", "Givati street", "Oliy Agardom street", "Dov Brayer street", "Kalanit street", "Tamar street", "Africa street"};
    String[] arrayOfArea = {"south", "midland", "north", "sharon", "negev"};

    if (cities != null) {
      for (int i = 0; i < arrayOfCity.length; i++) {
        if (arrayOfCity[i].equals("Ashdod") || arrayOfCity[i].equals("Ashkelon")) {
          cities[i] = new City(arrayOfCity[i], arrayOfArea[0], arrayOfStreets);
        }
        if (arrayOfCity[i].equals("Tel-Aviv") || arrayOfCity[i].equals("Jerusalem") || arrayOfCity[i].equals("Rehovot") || arrayOfCity[i].equals("Bat-Yam")) {
          cities[i] = new City(arrayOfCity[i], arrayOfArea[1], arrayOfStreets);
        }
        if (arrayOfCity[i].equals("Haifa")) {
          cities[i] = new City(arrayOfCity[i], arrayOfArea[2], arrayOfStreets);
        }
        if (arrayOfCity[i].equals("Herzelia")) {
          cities[i] = new City(arrayOfCity[i], arrayOfArea[3], arrayOfStreets);
        }
        if (arrayOfCity[i].equals("Eilat") || arrayOfCity[i].equals("Baer-Sheva")) {
          cities[i] = new City(arrayOfCity[i], arrayOfArea[4], arrayOfStreets);
        }
      }
    }
  }

  public void createUser() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("please enter a user name: ");
    String username;
    boolean alreadyUse;
    if (usersArray[0] != null) {
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
    } else {
      username = scanner.nextLine();

    }
    System.out.println("please enter a password that contains at least one number or one of the next signs:($,%,_) and have a length of 5 digits: ");
    String password = scanner.nextLine();
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
    boolean broker = false;
    while (!isBroker.equals("y") && !isBroker.equals("n")) {
      System.out.println("please enter only 'y' or 'n'!");
      isBroker = scanner.nextLine();
    }
    if (isBroker.equals("y")) {
      broker = true;
    }
    if (isBroker.equals("n")) {
      broker = false;
    }
    User newUser = new User(username, password, phoneNumber, broker);
    for (int i = 0; i < usersArray.length; i++) {
      if (usersArray[i] == null) {
        usersArray[i] = newUser;
      }
    }
  }

  private static boolean isValidPassword(String password) {
    boolean isValid = true;
    if (password.length() > 5 && (password.contains("%") || password.contains("$") || password.contains("-"))
            && (password.contains("1") || password.contains("2") || password.contains("3") || password.contains("4") ||
            password.contains("5") || password.contains("6") || password.contains("7") || password.contains("8") ||
            password.contains("9"))) {
      isValid = false;
    }
    return isValid;
  }

  private static boolean validPhoneNumber(String phoneNumber) {
    boolean isValid = true;
    if ((phoneNumber.startsWith("05")) && (phoneNumber.length() == 10) && (phoneNumber.contains("1") || phoneNumber.contains("2") || phoneNumber.contains("3")
            || phoneNumber.contains("4") || phoneNumber.contains("5") || phoneNumber.contains("6")
            || phoneNumber.contains("7") || phoneNumber.contains("8") || phoneNumber.contains("9") || phoneNumber.contains("0"))) {
      isValid = false;
    }
    return isValid;
  }

  User login() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("please enter your username: ");
    String usernameLogin = scanner.next();
    System.out.println("please enter your password: ");
    String passwordLogin = scanner.next();
    boolean isUsernameValid = false;
    boolean isPasswordValid = false;
    int count = 0;
    for (int i = 0; i < usersArray.length; i++) {
      if (usersArray[i].getUserName().equals(usernameLogin)) {
        isUsernameValid = true;
        count = i;
        break;
      }
    }
    if (usersArray[count].getPassword().equals(passwordLogin)) {
      isPasswordValid = true;
    }
    User loginInfoValid = null;
    if (isUsernameValid && isPasswordValid) {
      loginInfoValid = usersArray[count];
    }
    return loginInfoValid;
  }

  int postCount = 0;
  boolean postNewProperty(User user) {
    int counterOfCities=0;
    Scanner scanner = new Scanner(System.in);
    if ((user.getIsBrokers() && postCount == 5) || (!user.getIsBrokers() && postCount == 2)) {
      return false;
    }
    for (int i = 0; i < cities.length; i++) {
      System.out.println(cities[i].getCityName());
      System.out.println("please enter your city of your property: ");
      String cityOfNewProperty = scanner.nextLine();
      if (cityOfNewProperty.equals(cities[i].getCityName())) {
        System.out.println(cities[i].getListOfStreets());
        System.out.println("please enter the street name of your new property:");
        String streetOfNewProperty =scanner.nextLine();
        if (streetOfNewProperty.equals(cities[i].getListOfStreets())){
          System.out.println("please choose which type of house u have: "+"\n enter 1 to an apartment"+"\n enter 2 to a penthouse"+"\n enter 3 to a detachment home");
          int typeOfHouse= scanner.nextInt();
          if (typeOfHouse != 1 || typeOfHouse != 2 || typeOfHouse != 3) {
            System.out.println("please enter an option between 1-3!");
            return false;
          }else {
            if(typeOfHouse==1){
              System.out.println("please enter the floor number of your property");
              int floorNumber =scanner.nextInt();
              propertyOfUserInfo();
            }
            if(typeOfHouse==2){
              propertyOfUserInfo();
            }
            if(typeOfHouse==3){
              propertyOfUserInfo();
            }
          }
        }else {
          System.out.println("your property is not in our system database ");
          return false;
        }
      } else if (counterOfCities==cities.length) {
        System.out.println("your property is not in our system database ");
        return false;
      } else {
        counterOfCities++;
      }
      properties[i]= new Property(cities[i],usersArray[i]);
    }
    return true;
  }
  private static void propertyOfUserInfo(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("How much rooms are there in this property");
    double numberOfRooms = scanner.nextDouble();
    System.out.println("Please enter the number of the property: ");
    int numberOfProperty = scanner.nextInt();
    System.out.println("If the property is for rent enter 1 if it for sale enter 2");
    int forRentOrForSale = scanner.nextInt();
    while(forRentOrForSale!= 1 && forRentOrForSale != 2){
      System.out.println("If for rent enter 1 - if for sale enter 2");
      forRentOrForSale = scanner.nextInt();
    }
    boolean isPropertyForRent = false;
    if(forRentOrForSale == 1){
      isPropertyForRent = true;
    }
    System.out.println("Please enter the price of the property: ");
    int priceOfProperty = scanner.nextInt();

  }

  void removeProperty(User user) {
    Scanner scanner = new Scanner(System.in);
    boolean existProperty = false;
    int counter = 1;
    for (int i = 0; i < properties.length; i++) {
      if (user.getUserName().equals(properties[i].getSellerName())) {
        existProperty = true;
        System.out.println("press " + counter + " to delete: " + properties[i]);
        counter++;
      }
      if (!existProperty) {
        System.out.println("you dont have any post");
      } else {
        int indexFromUser;
        do {
          indexFromUser = scanner.nextInt();
          if (indexFromUser >= 1 && indexFromUser <= counter) {
            System.out.println("try again");
          }
        } while (indexFromUser >= 1 && indexFromUser <= counter);
        int toEqualCounter = 1;
        int saveIndexToRemove;
        for (int j = 0; j < properties.length; j++) {
          if (user.getUserName().equals(properties[j].getSellerName())){
            if(counter == toEqualCounter){
              properties[j] = null;
              saveIndexToRemove = j;
              break;
            }
            toEqualCounter++;
          }
        }
        Property tempProperty[] = new Property[properties.length - 1];
        for (int j = 0; j < properties.length - 1; j++) {
          if(j < indexFromUser){
            tempProperty[j] = properties[j];
          }
          else{
            tempProperty[j] = properties[j + 1];
          }
        }
        properties = tempProperty;
        System.out.println("property removed");
      }
    }
  }
  void printAllProperties(){

    for (int i = 0; i < properties.length; i++) {
      System.out.println(properties[i]);
    }
  }
  void printProperties (User user){
    for (int i = 0; i < properties.length; i++) {
      if (user.getUserName()==properties[i].getSellerName()){
        System.out.println(properties[i]);
      }
    }
  }
  Property[] search (){
    Scanner scanner = new Scanner(System.in);
    System.out.println("please choose which type of house u have: "+"\n enter 1 to an apartment"+"\n enter 2 to a penthouse"+"\n enter 3 to a detachment home");
    int typeOfHouse= scanner.nextInt();
    if (typeOfHouse != 1 || typeOfHouse != 2 || typeOfHouse != 3) {
      System.out.println("please enter an option between 1-3!");
    System.out.println("for rent or for sell");
    String sellOrRent = scanner.nextLine();
    if (sellOrRent.contains("rent") || sellOrRent.contains("sell")){

    }
    System.out.println();
    System.out.println();
    System.out.println();
    return new Property[0];
  }
}