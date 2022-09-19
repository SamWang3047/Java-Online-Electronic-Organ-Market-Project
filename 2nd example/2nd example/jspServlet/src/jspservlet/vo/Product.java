package jspservlet.vo;

public class Product {

    private int itemID;
    private String iName;
    private double iPrice;
    private String iDate;
    private int number_Purchase;
    private String description;

    public Product(String iName,int itemID){
        super();
        this.iName = iName;
        this.itemID = itemID;
    }

    public Product() {

    }

    public Product(String iName, double iPrice, int itemID) {
        super();
        this.iName = iName;
        this.iPrice = iPrice;
        this.itemID = itemID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public double getiPrice() {
        return iPrice;
    }

    public void setiPrice(double iPrice) {
        this.iPrice = iPrice;
    }

    public String getiDate() {
        return iDate;
    }

    public void setiDate(String iDate) {
        this.iDate = iDate;
    }

    public int getNumber_Purchase() {
        return number_Purchase;
    }

    public void setNumber_Purchase(int number_Purchase) {
        this.number_Purchase = number_Purchase;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
