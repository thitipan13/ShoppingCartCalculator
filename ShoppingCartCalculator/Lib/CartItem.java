package Lib;

public record CartItem(String sku, String name, double price, int quantity) {

    
    //คืนค่าราคาที่ถูกต้อง ถ้าน้อยกว่า 0 จะคืน 0
    public double getSafePrice() {
        return Math.max(0, price);
    }
    
    //คืนค่าจำนวนสินค้าที่ถูกต้อง ถ้าน้อยกว่า 0 จะคืน 0
    public int getSafeQuantity() {
        return Math.max(0, quantity);
    }
}
