package jspservlet.vo;

public class Cart {

    private int cartID;
    private double cPrice; //������Ʒ�۸�
    private int cNumber;
    private int Product_itemID;
    private int User_userID;//�߼���һ��userid�¶��cartid��һ��cart������һ��itemid��һ��itemid�ж�Ӧ��number��price����Ǯ��

    public Cart(){
        //TODO generate constructor
    }
    //�ṹ��1
    public Cart(int cartID,double cPrice,int cNumber,int Product_itemID,int User_userID){
        super();
        this.cartID=cartID;
        this.User_userID=User_userID;
        this.Product_itemID=Product_itemID;
        this.cNumber=cNumber;
        this.cPrice=cPrice;
    }
    //�ṹ��2,����������Ʒ
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

