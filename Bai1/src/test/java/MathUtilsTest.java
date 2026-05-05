import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test; // Thay cho org.junit.Test
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals; // Assertions của JUnit 5
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathUtilsTest {
    // Khởi tạo Logger cho lớp này
    private static final Logger logger = LoggerFactory.getLogger(MathUtilsTest.class);

    /*
    phải dùng static vì lúc đó chưa có đối tượng nào được tạo ra, nếu muồn phương thức chạy thì phải là gọi từ chính lớp đó
     */
    @BeforeAll
    static void initAll() {
        logger.info("=== Bắt đầu chạy MathUtilsTest ===");
    }
    @AfterAll
    static void tearDownAll() {
        logger.info("=== Kết thúc ===");
    }

    // A. Test cho max(int a, int b)
    // A_1. Dùng EP
    @Test
    @DisplayName("Test max với a > b")
    void testMaxALargerThanB() {
        assertEquals(10, MathUtils.max(10, 5));
    }

    @Test
    @DisplayName("Test max với a = b")
    void testMaxAEqualB() {
        assertEquals(5, MathUtils.max(5,5));
    }

    @Test
    @DisplayName("Test max với a < b")
    void testMaxALessThanB() {
        assertEquals(5, MathUtils.max(4,5));
    }
    // A_2. Dùng BVA
    @Test
    void testMax_BVA_MinValue() {
        assertEquals(Integer.MIN_VALUE + 1, MathUtils.max(Integer.MIN_VALUE, Integer.MIN_VALUE + 1));
    }

    @Test
    void testMax_BVA_MaxValue() {
        assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, Integer.MAX_VALUE - 1));
    }

    // B. Test cho divide(int a, int b)
    // B_1. EP: (b > 0, b < 0, b = 0)
    @Test
    void testDivide_BlessThan0() {
        assertEquals(-2, MathUtils.divide(5, -2));
    }
    @Test
    void testDivide_BHigherThan0() {
        assertEquals(2, MathUtils.divide(5, 2));
    }
    @Test
    void testDivide_BEquals0(){
        assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.divide(10, 0);
        });
    }
}
