package jspservlet.vo;

public class Order {
    private int orderID;
    private double oPrice;
    private String address;
    private String date;
    private int User_userID;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public double getoPrice() {
        return oPrice;
    }

    public void setoPrice(double oPrice) {
        this.oPrice = oPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUser_userID() {
        return User_userID;
    }

    public void setUser_userID(int user_userID) {
        User_userID = user_userID;
    }
}
