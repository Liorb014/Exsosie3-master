public class Property {

    final private City city;
    private String street;
    private int amountOfRooms;
    private int price;
    private int type;
    private boolean isForRenting;
    private int houseNumber;
    private int floor;
    final private String sellerName;
    final private String phoneNumber;
    final private boolean isBrokers;

    public Property(City city,String street, String userName, boolean isForRenting, String phoneNumber,boolean isBroker,int floor, int type, int amountOfRooms, int price, int houseNumber) {
        this.city = city;
        this.street = street;
        this.sellerName = userName;
        this.phoneNumber = phoneNumber;
        this.isBrokers = isBroker;
        this.type = type;
        this.floor = floor;
        this.amountOfRooms = amountOfRooms;
        this.price =  price;
        this.houseNumber = houseNumber;
        this.isForRenting = isForRenting;

     }
    public double getPrice() {
        return price;
    }

    public int getAmountOfRooms() {
        return amountOfRooms;
    }

    public int getFloor() {
        return floor;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getCity() {
        return city.getCityName();
    }

    public String getStreet() {
        return street;
    }

    public String getSellerName() {
        return sellerName;
    }

    public int getType() {
        return type;
    }

    public boolean getIsForRenting() {
        return isForRenting;
    }

    public String toString() {
        String broker;
        if (isBrokers) {
            broker = "(real estate agent)";
        } else broker = "(not an agent)";
        String floorNumber;
        if (type == 3) {
            floorNumber = "";
        } else {
            floorNumber = "floor" + floor;
        }

        String houseType=null;
        if (type == 3) {
            houseType = "detached home";
        } else if (type == 1) {
            houseType = "apartment ";
        } else if (type == 2) {
            houseType = "penthouse";
        }

        String forRent ;
        if (isForRenting){
forRent = "for renting";
        }else {
forRent = "for selling";
        }

        return getCity() + "  - " + street + " " + houseNumber + "." + "\n" + houseType + " - " + forRent + ": " + amountOfRooms + " rooms ,  " + floorNumber +
                "\nPrice: " + price + "$\nContact info: " + sellerName + " " + phoneNumber + " " + broker;
    }
}


