import java.util.Arrays;
import java.util.Scanner;

public class RealEstate {
  int counter=0;
  public User[] usersArray = new User[counter];
  private Property[] properties;
  public City[] cities;//=new City[10]

  public RealEstate() {
    matchArea();
  }
  public void setUsersArray(User[] usersArray) {
    this.usersArray = usersArray;
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
    boolean alreadyUsed;
    if (usersArray != null) {
      do {
        username = scanner.nextLine();
        alreadyUsed = false;
        for (int i = 0; i < usersArray.length; i++) {
          if (username.equals(usersArray[i].getUserName())) {
            alreadyUsed = true;
            System.out.println("this username is already taken, please choose another username");
            username = scanner.nextLine();
            break;
          }
        }
      } while (alreadyUsed);
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
    addUser(newUser);
  /*
    User[] tempUsers = new User[countOfUsers+1];
    int i=0;
    for (i = 0; i < usersArray.length; i++) {
      tempUsers[i]= usersArray[i];
    }
    tempUsers[countOfUsers-1] = newUser;
    usersArray = Arrays.copyOf(tempUsers,usersArray.length+1);*/
    System.out.println(Arrays.toString(usersArray));
    Main.menu();
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
    User loginInfoValid = null;
    for (int i = 0; i <= usersArray.length; i++) {

      if (usersArray[i].getUserName().equals(usernameLogin)) {
        isUsernameValid = true;
        if (usersArray[i].getPassword().equals(passwordLogin)) {
          isPasswordValid = true;
          if (isUsernameValid && isPasswordValid) {
            loginInfoValid = usersArray[i];
          }else {
            System.out.println("incorrect username or password");
          }
        }
      }
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
      String streetOfNewProperty = null;
      boolean isPropertyForRent = false;
      int floorNumber = 0;
      int typeOfHouse = 0;
      int numberOfRooms =0;
      int priceOfProperty=0;
      int numberOfProperty = 0;
      if (cityOfNewProperty.equals(cities[i].getCityName())) {
        System.out.println(cities[i].getListOfStreets());
        System.out.println("please enter the street name of your new property:");
        streetOfNewProperty = scanner.nextLine();
        if (streetOfNewProperty.equals(cities[i].getListOfStreets())) {
          System.out.println("please choose which type of house u have: " + "\n enter 1 to an apartment" + "\n enter 2 to a penthouse" + "\n enter 3 to a detachment home");
          typeOfHouse = scanner.nextInt();
          if (typeOfHouse != 1 || typeOfHouse != 2 || typeOfHouse != 3) {
            System.out.println("please enter an option between 1-3!");
            return false;
          } else {
            if (typeOfHouse == 1) {
              System.out.println("please enter the floor number of your property");
              floorNumber = scanner.nextInt();
              System.out.println("How much rooms are there in this property");
              numberOfRooms = scanner.nextInt();
              System.out.println("Please enter the number of the property: ");
              numberOfProperty = scanner.nextInt();
              System.out.println("If the property is for rent enter 1 if it for sale enter 2");
              int forRentOrForSale = scanner.nextInt();
              while (forRentOrForSale != 1 && forRentOrForSale != 2) {
                System.out.println("If for rent enter 1 - if for sale enter 2");
                forRentOrForSale = scanner.nextInt();
              }
              isPropertyForRent = false;
              if (forRentOrForSale == 1) {
                isPropertyForRent = true;
              }
              System.out.println("Please enter the price of the property: ");
              priceOfProperty = scanner.nextInt();
            }
            if (typeOfHouse == 2) {
              System.out.println("How much rooms are there in this property");
              numberOfRooms = scanner.nextInt();
              System.out.println("Please enter the number of the property: ");
              numberOfProperty = scanner.nextInt();
              System.out.println("If the property is for rent enter 1 if it for sale enter 2");
              int forRentOrForSale = scanner.nextInt();
              while (forRentOrForSale != 1 && forRentOrForSale != 2) {
                System.out.println("If for rent enter 1 - if for sale enter 2");
                forRentOrForSale = scanner.nextInt();
              }
              isPropertyForRent = false;
              if (forRentOrForSale == 1) {
                isPropertyForRent = true;
              }
              System.out.println("Please enter the price of the property: ");
              priceOfProperty = scanner.nextInt();
            }
            if (typeOfHouse == 3) {
              System.out.println("How much rooms are there in this property");
              numberOfRooms = scanner.nextInt();
              System.out.println("Please enter the number of the property: ");
              numberOfProperty = scanner.nextInt();
              System.out.println("If the property is for rent enter 1 if it for sale enter 2");
              int forRentOrForSale = scanner.nextInt();
              while (forRentOrForSale != 1 && forRentOrForSale != 2) {
                System.out.println("If for rent enter 1 - if for sale enter 2");
                forRentOrForSale = scanner.nextInt();
              }
              isPropertyForRent = false;
              if (forRentOrForSale == 1) {
                isPropertyForRent = true;
              }
              System.out.println("Please enter the price of the property: ");
              priceOfProperty = scanner.nextInt();
            }
          }
        } else {
          System.out.println("your property is not in our system database ");
          return false;
        }
      } else if (counterOfCities == cities.length) {
        System.out.println("your property is not in our system database ");
        return false;
      } else {
        counterOfCities++;
      }
      properties[i] = new Property(cities[i], streetOfNewProperty, user.getUserName(),
              isPropertyForRent, user.getPhoneNumber(), user.getIsBrokers(), floorNumber, typeOfHouse, numberOfRooms,priceOfProperty,numberOfProperty );
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
    final int IGNORE = -999;
    Scanner scanner = new Scanner(System.in);
    System.out.println(" hello welcome to the search panel please make sure to put the right values, if u want to not use one of the filter write -999! ");
    System.out.println("please choose which type of house u want: "+"\n enter 1 to an apartment"+"\n enter 2 to a penthouse"+"\n enter 3 to a detachment home");
    int typeOfHouse= scanner.nextInt();
    if (typeOfHouse != 1 || typeOfHouse != 2 || typeOfHouse != 3||typeOfHouse != -999) {
      System.out.println("please enter an option between 1-3!");
      typeOfHouse= scanner.nextInt();
    }
    System.out.println("please enter which house condition u desire (for rent or for sell) for rent, enter 'rent', or for sell, enter 'sell'");
    String sellOrRent = scanner.nextLine();
    boolean isForRent = false;
    if(sellOrRent.equals("rent")){
      isForRent = true;
    }else if(sellOrRent.equals("-999")){
      sellOrRent = String.valueOf(IGNORE);
    }
    else {
      while ((!sellOrRent.equals("rent") || !sellOrRent.equals("sell"))&& !sellOrRent.equals("-999")) {
        System.out.println("u putted unmatched context , please try again  ");
        sellOrRent = scanner.nextLine();
      }
    }
    System.out.println("Please enter the amount of rooms in the house");
    int amountOfRooms = scanner.nextInt();
    while(amountOfRooms <=0 && amountOfRooms != IGNORE){
      System.out.println("Please try again, enter a number which is bigger than 0, or -999");
      amountOfRooms = scanner.nextInt();
    }
    System.out.println("Please enter the range of prices you want to choose by (now enter minimum): ");
    int minPrice = scanner.nextInt();
    int maxPrice=0;
    if(minPrice != IGNORE) {
      System.out.println("now enter maximum: ");
      maxPrice = scanner.nextInt();
      while (maxPrice < minPrice && maxPrice != IGNORE) {
        System.out.println("minimum bigger then maximum ");
        System.out.println("enter again the maximum price: ");
        maxPrice = scanner.nextInt();
      }
    }
    int counter = 0;
    int[] index =new int[properties.length];
    for (int i = 0; i < properties.length; i++) {
      index[i] = i ;
    }
    if (!sellOrRent.equals(String.valueOf(IGNORE))){
      int[] tempIndex = new int[properties.length];
      for (int i = 0; i < index.length; i++) {
        if(properties[i].getIsForRenting() == isForRent) {
          tempIndex[counter] = i;
          counter++;
        }
      }
      for (int j = 0; j < counter ; j++) {
        index = Arrays.copyOf(tempIndex,counter);
        counter=0;
      }
    }
    if (!(typeOfHouse == IGNORE)){
      int[] tempIndex = new int[properties.length];
      for (int i = 0; i < index.length; i++) {
        if(properties[i].getType() == typeOfHouse) {
          tempIndex[counter] = i;
          counter++;
        }
      }
      for (int j = 0; j < counter ; j++) {
        index = Arrays.copyOf(tempIndex,counter);
        counter=0;
      }
    }
    if (!(amountOfRooms == IGNORE)){
      int[] tempIndex = new int[properties.length];
      for (int i = 0; i < index.length; i++) {
        if(properties[i].getAmountOfRooms() == amountOfRooms) {
          tempIndex[counter] = i;
          counter++;
        }
      }
      for (int j = 0; j < counter ; j++) {
        index = Arrays.copyOf(tempIndex,counter);
        counter=0;
      }
    }
    if (!(maxPrice == IGNORE)){
      int[] tempIndex = new int[properties.length];
      for (int i = 0; i < index.length; i++) {
        if(properties[i].getPrice() <= typeOfHouse) {
          tempIndex[counter] = i;
          counter++;
        }
      }
      for (int j = 0; j < counter ; j++) {
        index = Arrays.copyOf(tempIndex,counter);
        counter=0;
      }
    }
    if (!(minPrice == IGNORE)){
      int[] tempIndex = new int[properties.length];
      for (int i = 0; i < index.length; i++) {
        if(properties[i].getPrice() >= typeOfHouse) {
          tempIndex[counter] = i;
          counter++;
        }
      }
      for (int j = 0; j < counter ; j++) {
        index = Arrays.copyOf(tempIndex,counter);
        counter=0;
      }
    }
    Property[] filteredProperties = new Property[index.length];
    for (int i = 0; i < index.length ; i++) {
      filteredProperties[index[counter]] = properties[i];
      counter++;
    }
    return filteredProperties;
  }
  public void addUser(User user){
    User[] users = new User[usersArray.length+1];
    if(usersArray.length == 0){
      users[0] = user;
    }
    else {
      for (int i = 0; i <= users.length; i++) {
        if (i == users.length) {
          users[i] = user;
        } else {
          usersArray[i] = users[i] ;
        }
      }
    }
    setUsersArray(users);
    counter++;
  }
  public User[] getUsersArray() {
    return usersArray;
  }
}