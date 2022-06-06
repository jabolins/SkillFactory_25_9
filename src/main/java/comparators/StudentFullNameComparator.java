package comparators;

import models.Student;
import org.apache.commons.lang3.StringUtils;

public class StudentFullNameComparator implements StudentsComparator{
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getFullName(),o2.getFullName());
    }
}
