public class Property {

    final private City city;
    final private String area;
    private String street;
    private int amountOfRooms;
    private double price;
    private int type;
    private boolean isForRenting;
    private int houseNumber;
    private int floor;
    final private String sellerName;
    final private String phoneNumber;
    final private boolean isBrokers;

    public Property(City city, User user) {
        this.city = city;
        this.area = city.getArea();
        this.sellerName = user.getUserName();
        this.phoneNumber = user.getPhoneNumber();
        this.isBrokers = user.getIsBrokers();
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmountOfRooms(int amountOfRooms) {
        this.amountOfRooms = amountOfRooms;
    }

    public void setForRenting(boolean forRenting) {
        isForRenting = forRenting;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getArea() {
        return area;
    }

    public boolean isForRenting() {
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


