package Lib;

import java.util.List;

public class ShoppingCartCalculator {

     /**
     * เขียน Javadoc ที่นี่เพื่ออธิบายกฎการทำงานและกรณีพิเศษ:
     * - จะทำอย่างไรถ้า items เป็น null หรือ empty?
     *      แสดง Null cart should return 0.0 หรือ  Empty cart should return 0.0
     * - จะทำอย่างไรถ้า CartItem มี price หรือ quantity ติดลบ?
     *      บังคับค่า = 0
     * - กฎส่วนลด BOGO (ซื้อ 1 แถม 1)
     *      เฉพาะของกินที่ร่วมรายการ
     * - กฎส่วนลด BULK (ซื้อ >= 6 ชิ้น ลด 10%)
     *      เฉพาะของใช้ที่ร่วมรายการ
     */
    public static double calculateTotalPrice(List<CartItem> items) {
        if (items == null || items.isEmpty()) return 0.0;

        double total = 0.0;
        for (CartItem item : items) {
            double price = Math.max(0, item.price());
            int quantity = Math.max(0, item.quantity());
            double subtotal;
            switch (item.sku()) {
                case "WARE":
                    int paidUnits = (quantity + 1) / 2;
                    subtotal = paidUnits * price;
                    break;
                case "FOOD":
                    subtotal = quantity >= 6 ? quantity * price * 0.9 : quantity * price;
                    break;
                default:
                    subtotal = quantity * price;
            }
            total += subtotal;
        }
        return total;
    }
}