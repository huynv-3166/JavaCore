package com.example.practice2;

import java.time.LocalDate;
import java.util.Scanner;

public final class GoodsInput {
    private GoodsInput() {
    }

    public static Goods read(Scanner scanner) {
        String type = ask(scanner,
                "Chọn loại (1=Thực phẩm, 2=Điện tử, 3=Sành sứ, 0=Thoát): ");

        if (type.equals("0")) {
            return null;
        }
        if (!type.equals("1") && !type.equals("2") && !type.equals("3")) {
            throw new IllegalArgumentException("Loại hàng không hợp lệ");
        }

        String code = ask(scanner, "Mã hàng: ");
        String name = ask(scanner, "Tên hàng: ");
        int quantity = Integer.parseInt(ask(scanner, "Số lượng tồn: "));
        double unitPrice = Double.parseDouble(ask(scanner, "Đơn giá: "));

        return switch (type) {
            case "1" -> new Food(
                    code, name, quantity, unitPrice,
                    LocalDate.parse(ask(scanner, "Ngày sản xuất (yyyy-MM-dd): ")),
                    LocalDate.parse(ask(scanner, "Hạn sử dụng (yyyy-MM-dd): ")),
                    ask(scanner, "Nhà cung cấp: "));
            case "2" -> new Electronics(
                    code, name, quantity, unitPrice,
                    Integer.parseInt(ask(scanner, "Bảo hành (tháng): ")),
                    Double.parseDouble(ask(scanner, "Công suất (kW): ")));
            case "3" -> new Crockery(
                    code, name, quantity, unitPrice,
                    ask(scanner, "Nhà sản xuất: "),
                    LocalDate.parse(ask(scanner, "Ngày nhập kho (yyyy-MM-dd): ")));
            default -> throw new IllegalStateException("Unexpected type");
        };
    }

    private static String ask(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}