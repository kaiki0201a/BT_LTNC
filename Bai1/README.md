# Báo cáo Bài 1: Quản lý Dependency với Maven

## 1. Mô tả dự án
Dự án **MathUtils** đã được chuyển đổi từ cấu hình quản lý thư viện thủ công (legacy) sang sử dụng công cụ tự động hóa **Maven**. Mục tiêu của việc nâng cấp này là chuẩn hóa môi trường phát triển, tích hợp hệ thống logging có cấu trúc và thiết lập nền tảng lưu trữ dữ liệu cho tương lai.

## 2. Cấu hình Dependency (pom.xml)
Các thư viện sau đã được tích hợp thành công vào tệp `pom.xml`, giải quyết hoàn toàn các xung đột trong quá trình Build:

*   **Logback Classic (Phiên bản 1.4.11):** Thư viện cốt lõi để triển khai Structured Logging (ghi log có cấu trúc) thông qua SLF4J API.
*   **Hibernate Core (Phiên bản 6.2.0.Final):** Framework ORM (Object-Relational Mapping) được thêm vào để hỗ trợ nhu cầu lưu trữ dữ liệu bền vững (persistence) vào cơ sở dữ liệu trong các giai đoạn phát triển tiếp theo.
*   **JUnit Jupiter (Phiên bản 5.9.2):** Phiên bản hiện đại nhất của JUnit 5, được thiết lập làm công cụ kiểm thử (testing framework) duy nhất của toàn bộ dự án.

## 3. Giải thích giải pháp cấu hình
Quá trình cấu hình và giải quyết xung đột được thực hiện dựa trên các nguyên tắc sau:

*   **Tối ưu hóa Logging:** Thay thế hoàn toàn các lệnh `System.out.println` thủ công bằng Logback. Giải pháp này giúp phân loại log theo cấp độ (INFO, DEBUG, ERROR), tự động gắn luồng (thread) và thời gian thực thi, giúp việc giám sát và truy vết lỗi (debug) trên môi trường thực tế trở nên chuyên nghiệp và hiệu quả hơn.
*   **Loại bỏ xung đột thư viện (Dependency Hell):** Để đảm bảo JUnit Jupiter là công cụ kiểm thử duy nhất, toàn bộ các phụ thuộc liên quan đến JUnit 4 (nếu có) đã được gỡ bỏ. Điều này ngăn chặn tình trạng lẫn lộn các annotation (như `@Test`) giữa hai phiên bản, đảm bảo tính nhất quán cho mã nguồn.
*   **Tích hợp Maven Surefire Plugin:** Việc khai báo `maven-surefire-plugin` (phiên bản 3.1.2) trong phần `<build>` là bắt buộc để Maven có thể nhận diện đúng engine của JUnit 5 (JUnit Platform) và thực thi tự động các bài kiểm thử khi chạy lệnh build.

## 4. Hướng dẫn thực thi và Kiểm tra
Yêu cầu hệ thống: Máy tính đã cài đặt Java và Maven.
