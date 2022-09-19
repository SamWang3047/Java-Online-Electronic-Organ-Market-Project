package jspservlet.vo;

public class Cart {

    private int cartID;
    private double cPrice; //单件商品价格
    private int cNumber;
    private int Product_itemID;
    private int User_userID;//逻辑：一个userid下多个cartid，一个cart里面有一个itemid，一个itemid有对应的number，price单价钱。

    public Cart(){
        //TODO generate constructor
    }
    //结构体1
    public Cart(int cartID,double cPrice,int cNumber,int Product_itemID,int User_userID){
        super();
        this.cartID=cartID;
        this.User_userID=User_userID;
        this.Product_itemID=Product_itemID;
        this.cNumber=cNumber;
        this.cPrice=cPrice;
    }
    //结构体2,用于增加商品
    public Cart(double cPrice,int cNumber,int Product_itemID,int User_userID){
        super();
        this.User_userID=User_userID;
        this.Product_itemID=Product_itemID;
        this.cNumber=cNumber;
        this.cPrice=cPrice;
    }
    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public double getcPrice() {
        return cPrice;
    }

    public void setcPrice(double cPrice) {
        this.cPrice = cPrice;
    }

    public int getcNumber() {
        return cNumber;
    }

    public void setcNumber(int cNumber) {
        this.cNumber = cNumber;
    }

    public int getProduct_itemID() {
        return Product_itemID;
    }

    public void setProduct_itemID(int product_itemID) {
        Product_itemID = product_itemID;
    }

    public int getUser_userID() {
        return User_userID;
    }

    public void setUser_userID(int user_userID) {
        User_userID = user_userID;
    }



}

