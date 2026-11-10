# Practice 2 – Quản lý hàng hóa siêu thị

Dự án dùng Java 25 và Spring Boot 4 để quản lý thực phẩm, hàng điện tử và sành sứ.

- `Goods` là class cha chứa thông tin chung.
- `Food`, `Electronics`, `Crockery` kế thừa `Goods` và tự tính VAT, đánh giá tình trạng bán.
- `GoodsInventory` lưu hàng bằng mảng, cộng số lượng tồn theo loại và từ chối mã trùng.
- `GoodsInput` cho phép chọn loại hàng và nhập thông tin từ Terminal.

VAT được tính **trên một đơn vị hàng**: thực phẩm 5%, điện tử và sành sứ 10%.

## Yêu cầu

Docker và Docker Compose đang chạy. Không cần cài Java hoặc Maven trên máy.

## Chạy

Từ thư mục `practice2`:

```bash
docker compose run --build --rm practice2
```

Chọn `1` để thêm thực phẩm, `2` để thêm điện tử, `3` để thêm sành sứ, hoặc `0` để thoát và xem tổng số lượng tồn.

Chương trình tạo sẵn ba mã để minh họa: `F01` (Milk), `E01` (Fan), `C01` (Plate). Khi nhập hàng mới, dùng mã khác các mã này. Ngày nhập theo dạng `yyyy-MM-dd`, ví dụ `2026-11-10`.

Dữ liệu chỉ lưu trong bộ nhớ trong lúc chương trình chạy; chạy lại sẽ bắt đầu từ ba mặt hàng mẫu.