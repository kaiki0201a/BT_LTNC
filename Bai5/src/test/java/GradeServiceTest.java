
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GradeServiceTest {
    @Test
    void testAllGrades() {
        GradeService service = new GradeService();

        // Test tất cả các nhánh để JaCoCo không báo lỗi 80%
        assertEquals("A", service.getGrade(9.0));
        assertEquals("B", service.getGrade(7.5));
        assertEquals("C", service.getGrade(4.0));
        assertEquals("Invalid", service.getGrade(11.0));
        assertEquals("Invalid", service.getGrade(-1.0));
    }
}