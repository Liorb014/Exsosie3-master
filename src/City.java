import java.util.Arrays;
public class City {
    private final String cityName;
    private final String area;
    private final String[] listOfStreets;

    public City(String cityName,String area,String[] listOfStreets){
        this.cityName = cityName;
        this.area = area;
        this.listOfStreets = listOfStreets;
    }
    public String getCityName(){
        return this.cityName;
    }
    public String getArea(){
        return area;
    }
    public String getListOfStreets(){
        return Arrays.toString(listOfStreets);
    }
    public String toString(){
        return "City name : " + cityName + "\nArea : " + area +"\n List of streets :" + getListOfStreets() ;
    }
}
// I think this file is completed


