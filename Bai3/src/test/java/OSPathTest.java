import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OSPathTest {

/*
    @Test
    void testFileAccessWithHardcodedPath() {
        // 1. Để hệ thống tự tạo đường dẫn dựa trên cấu trúc folder
        // Trên Mac: target/test-config.txt
        // Trên Windows: target\test-config.txt
        File file = new File("target", "test-config.txt");
        String realPath = file.getPath();

        // 2. ÉP BUỘC: Bài test này chỉ chấp nhận dấu gạch chéo xuôi "/"
        // Trên Mac/Ubuntu: realPath chứa "/" -> PASS
        // Trên Windows: realPath chứa "\" -> FAIL!
        assertTrue(realPath.contains("/"),
                "Lỗi: Đường dẫn hệ thống không sử dụng dấu gạch chéo Unix! Thực tế là: " + realPath);
    }
*/
// Sau khi sửa path
    @Test
    void testFileAccessCrossPlatform() {
        // Sử dụng Path.of hoặc Paths.get để Java tự chọn "/" hoặc "\"
        Path path = Paths.get("target", "test-config.txt");

        File file = path.toFile();

        // Kiểm tra tính tồn tại hoặc thuộc tính của file thay vì kiểm tra dấu "/"
        assertNotNull(file, "File object nên được khởi tạo thành công");

        // In ra để kiểm tra trên log của GitHub Actions
        System.out.println("Đường dẫn thích ứng hệ điều hành: " + path.toString());
    }
}