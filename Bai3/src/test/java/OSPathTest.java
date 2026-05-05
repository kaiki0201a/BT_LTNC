import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

public class OSPathTest {
"""
    @Test
    void testFileAccessWithHardcodedPath() {
        // Sử dụng dấu "/" - Chạy tốt trên Mac
        // Nhưng sẽ gây vấn đề trên Windows nếu logic xử lý không linh hoạt
        String path = "target/test-config.txt";

        // Giả sử yêu cầu nghiệp vụ: đường dẫn phải chứa dấu gạch chéo xuôi
        // Đây là lỗi logic thường gặp khi dev chỉ dùng Mac/Linux
        assertTrue(path.contains("/"), "Lỗi: Đường dẫn không đúng định dạng Unix!");

        File file = new File(path);
        System.out.println("Đang kiểm tra file tại: " + file.getAbsolutePath());
    }
"""

}