package Lib;

import java.util.ArrayList;

public class ShoppingCartManualTest {

    // Static Initializer Block
    static {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---\n");

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));  // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }

        // Test 4: ติดลบบังคับ 0
        ArrayList<CartItem> invalidCart = new ArrayList<>();
        invalidCart.add(new CartItem("NORMAL", "BuggyItem", -100.0, -2)); // ควรคิดเป็น 0
        double total4 = ShoppingCartCalculator.calculateTotalPrice(invalidCart);
        if (total4 == 0.0) {
            System.out.println("PASSED: Invalid item handled correctly (0.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Invalid item expected 0.0 but got " + total4);
            failedCount++;
        }

        // Test 5: BOGO 1 แถม 1
        ArrayList<CartItem> bogoCart = new ArrayList<>();
        bogoCart.add(new CartItem("WARE", "Shampoo", 10.0, 3)); 
        double total5 = ShoppingCartCalculator.calculateTotalPrice(bogoCart);
        if (total5 == 20.0) {
            System.out.println("PASSED: BOGO cart total is correct (20.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: BOGO cart expected 20.0 but got " + total5);
            failedCount++;
        }

        // Test 6: BULK >= 6 ลด 10%
        ArrayList<CartItem> bulkCart = new ArrayList<>();
        bulkCart.add(new CartItem("FOOD", "Pork", 5.0, 6)); 
        double total6 = ShoppingCartCalculator.calculateTotalPrice(bulkCart);
        if (total6 == 27.0) {
            System.out.println("PASSED: Bulk cart total is correct (27.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Bulk cart expected 27.0 but got " + total6);
            failedCount++;
        }


        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}
