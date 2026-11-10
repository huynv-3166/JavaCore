package com.example.practice2;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Practice2Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice2Application.class, args);

        LocalDate today = LocalDate.of(2026, 11, 10);
        GoodsInventory inventory = new GoodsInventory(10);

        Goods food = new Food(
                "F01", "Milk", 5, 20_000,
                LocalDate.of(2026, 10, 1),
                LocalDate.of(2026, 11, 1),
                "Farm A");

        Goods electronics = new Electronics(
                "E01", "Fan", 2, 500_000, 12, 0.08);

        Goods crockery = new Crockery(
                "C01", "Plate", 60, 30_000,
                "Factory B", LocalDate.of(2026, 10, 20));

        System.out.println("Add food: " + inventory.addGoods(food));
        System.out.println("Add electronics: " + inventory.addGoods(electronics));
        System.out.println("Add crockery: " + inventory.addGoods(crockery));
        System.out.println("Add duplicate F01: " + inventory.addGoods(food));

        for (Goods item : new Goods[]{food, electronics, crockery}) {
            System.out.println(item.getName()
                    + " | VAT/unit: " + item.getVatPerUnit()
                    + " | Sales: " + item.evaluateSales(today));
        }

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    Goods newGoods = GoodsInput.read(scanner);

                    if (newGoods == null) {
                        break; // Người dùng chọn 0
                    }

                    if (inventory.addGoods(newGoods)) {
                        System.out.println("Đã thêm: " + newGoods.getName());
                        System.out.println("VAT/đơn vị: " + newGoods.getVatPerUnit());
                        System.out.println("Đánh giá: "
                                + newGoods.evaluateSales(LocalDate.now()));
                    } else {
                        System.out.println("Không thêm được: mã trùng hoặc mảng đầy");
                    }
                } catch (NoSuchElementException e) {
                    break; // Không có dữ liệu nhập, ví dụ khi chạy Docker không mở stdin
                } catch (RuntimeException e) {
                    System.out.println("Dữ liệu không hợp lệ: " + e.getMessage());
                }
            }
        }

        System.out.println("Food quantity: "
                + inventory.getTotalQuantity(Food.class));
        System.out.println("Electronics quantity: "
                + inventory.getTotalQuantity(Electronics.class));
        System.out.println("Crockery quantity: "
                + inventory.getTotalQuantity(Crockery.class));
    }

}
