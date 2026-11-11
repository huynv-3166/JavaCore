# Practice 3 – Quản lý phương tiện

Dự án dùng Java 25 và Spring Boot 4 để quản lý ô tô, xe máy, xe tải và chủ sở hữu.

- `Owner`: số giấy tờ, họ tên, email.
- `Vehicle`: class cha chứa thông tin chung và kiểm tra mã xe, hãng, năm sản xuất.
- `Car`, `Motorbike`, `Truck`: các loại xe với thuộc tính riêng.
- `VehicleRegistry`: thêm xe không trùng mã, giữ số giấy tờ gắn với cùng một chủ, tìm xe, xóa theo hãng, xác định hãng nhiều xe nhất, sắp xếp hãng theo số xe giảm dần và thống kê từng loại xe.

Cách hiểu được dùng cho yêu cầu sắp xếp: **sắp xếp các hãng theo số phương tiện đang quản lý, từ nhiều đến ít**.

## Yêu cầu

Docker và Docker Compose đang chạy. Không cần cài Java hoặc Maven trên máy.

## Chạy

Từ thư mục `practice3`:

```bash
docker compose up --build
```

Chương trình chạy với dữ liệu mẫu và in kết quả cho từng chức năng. Kết quả chính:

```text
Add duplicate number: false
Found C0001: Toyota
Vehicles of An: 2
Manufacturer with most vehicles: Honda
Manufacturers by vehicle count: [Honda, Toyota, Suzuki]
Cars: 1
Motorbikes: 2
Trucks: 1
Removed Honda vehicles: 2
```
