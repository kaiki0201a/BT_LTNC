import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount account;

    // Yêu cầu 2: Khởi tạo số dư 500 trước mỗi bài test
    @BeforeEach
    void setUp() {
        account = new BankAccount("12345", "Nguyen Thanh Hieu", 500.0);
    }

    // --- TEST DEPOSIT ---
    // EP
    @Test
    void testDepositValid() {
        account.deposit(100.0);
        assertEquals(600.0, account.getBalance());
    }

    @Test
    void testDepositInvalid() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50));
    }
    // BVA
    // Tai 0
    @Test
    void testBVA0minus_deposit(){
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-0.1));
    }
    @Test
    void testBVA0_deposit(){
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0.0));
    }
    @Test
    void testBVA0Plus_deposit(){
        account.deposit(0.1);
        assertEquals(500.1, account.getBalance(), 0.001);
    }


    // --- TEST WITHDRAW ---
    // BVA
    @Test
    void testBVA0minus_withDraw(){
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-0.1));
    }
    @Test
    void testBVA0_withDraw(){
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));
    }
    @Test
    void testBVA0Plus_withDraw(){
        assertTrue(account.withdraw(0.1));
        assertEquals(499.9, account.getBalance(), 0.001);
    }
    @Test
    void testBVA500Plus_withDraw(){
        assertFalse(account.withdraw(600.0));
    }
    @Test
    void testBVA500_withDraw(){
        assertTrue(account.withdraw(500.0));
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    // EP
    @Test
    void testWithdrawSuccess() {
        assertTrue(account.withdraw(200.0));
        assertEquals(300.0, account.getBalance());
    }

    @Test
    void testWithdrawFailInsufficientBalance() {
        assertFalse(account.withdraw(600.0));
        assertEquals(500.0, account.getBalance()); // Số dư không đổi
    }
    @Test
    void testWithdraw_0Minus() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-50.0);
        });
    }
    // Yêu cầu 3: Kiểm tra tính nhất quán theo kịch bản
    @Test
    void testConsistencyScenario() {
        // Khởi tạo tài khoản mới với số dư 0
        BankAccount scenarioAcc = new BankAccount("999", "Tester", 0.0);

        // 1. Nạp 500
        scenarioAcc.deposit(500.0);

        // 2. Rút 200 (thành công)
        assertTrue(scenarioAcc.withdraw(200.0));

        // 3. Rút 400 (thất bại vì lúc này chỉ còn 300)
        assertFalse(scenarioAcc.withdraw(400.0));

        // 4. Kiểm tra số dư cuối cùng phải là 300
        assertEquals(300.0, scenarioAcc.getBalance());
    }
}