package jspservlet.vo;

public class Detail_Order {
    private int detailed_orderID;
    private int number;
    private double dPrice;
    private String status;
    private int Order_orderID;
    private int Product_itemID;
    private int Official_user_official_userID;


    public int getDetailed_orderID() {
        return detailed_orderID;
    }

    public void setDetailed_orderID(int detailed_orderID) {
        this.detailed_orderID = detailed_orderID;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getdPrice() {
        return dPrice;
    }

    public void setdPrice(double dPrice) {
        this.dPrice = dPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrder_orderID() {
        return Order_orderID;
    }

    public void setOrder_orderID(int order_orderID) {
        Order_orderID = order_orderID;
    }

    public int getProduct_itemID() {
        return Product_itemID;
    }

    public void setProduct_itemID(int product_itemID) {
        Product_itemID = product_itemID;
    }

    public int getOfficial_user_official_userID() {
        return Official_user_official_userID;
    }

    public void setOfficial_user_official_userID(int official_user_official_userID) {
        Official_user_official_userID = official_user_official_userID;
    }


}
