import java.lang.reflect.Array;
import java.util.Arrays;

public class StudentGrade {

}

class StudentDetail {
    public String name;
    public int[] marks;
    public int total;
    public double percentage;
    public char grade;

    public StudentDetail(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        this.total = Arrays.stream(marks).sum();
        this.percentage = total / 5;
        this.grade = calcGrade();
    }

    char calcGrade() {
        if (percentage >= 90)
            return 'A';
        else if (percentage >= 80)
            return 'B';
        else if (percentage >= 70)
            return 'C';
        else if (percentage >= 60)
            return 'D';
        else
            return 'F';
    }

    boolean hasFailed() {
        return Arrays.stream(marks).anyMatch(m -> m < 40);
    }
}