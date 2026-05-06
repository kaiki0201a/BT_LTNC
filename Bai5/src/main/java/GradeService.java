public class GradeService {
    double Diem_SO;  // cố tình viết sai
    public String getGrade(double score) {
        if (score < 0 || score > 10) {
            return "Invalid"; // Nhánh 1
        }
        if (score >= 8.5) {
            return "A";       // Nhánh 2
        } else if (score >= 7.0) {
            return "B";       // Nhánh 3
        } else {
            return "C";       // Nhánh 4
        }
    }
}