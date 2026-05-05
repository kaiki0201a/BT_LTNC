import org.slf4j.Logger;
import  org.slf4j.LoggerFactory;

public class BankAccount {
    private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);

    private final String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (initialBalance < 0) {
            logger.warn("Số dư ban đầu không hợp lệ. Gán mặc định là 0.");
            this.balance = 0.0;
        } else {
            this.balance = initialBalance;
            logger.info("Khởi tạo thành công tài khoản {} với số dư {}", accountNumber, initialBalance);
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền nạp phải lớn hơn 0.");
        }
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền rút phải lớn hơn 0.");
        }
        if (amount > this.balance) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
}
