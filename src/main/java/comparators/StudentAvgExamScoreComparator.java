package comparators;

import models.Student;

public class StudentAvgExamScoreComparator implements StudentsComparator{
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o1.getAvgExamScore(), o2.getAvgExamScore());
    }
}
