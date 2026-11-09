# Practice 1 – Shape và kế thừa

Dự án dùng Java 25 và Spring Boot 4 để thực hành kế thừa.

- `Shape` lưu `width` và `height`.
- `Rectangle extends Shape`: tính diện tích và chu vi hình chữ nhật.
- `Circle extends Shape`: tính diện tích và chu vi hình tròn. Trong bài này, `width` và `height` của `Circle` đều bằng đường kính.

## Yêu cầu

Docker và Docker Compose đang chạy. Không cần cài Java hoặc Maven trên máy.

## Chạy

Từ thư mục `practice1`:

```bash
docker compose up --build
```

Chương trình in thông tin ba đối tượng:

```text
Shape: width=2.0, height=3.0
Rectangle: width=4.0, height=6.0, area=24.0, perimeter=20.0
Circle: diameter=10.0, area=78.53981633974483, circumference=31.400000000000002
```