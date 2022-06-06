import comparators.StudentsComparator;
import comparators.UniversitiesComparator;
import comparators.comperatorEnums.StudentComparatorTypes;
import comparators.comperatorEnums.UniversityComparatorTypes;
import models.Student;
import models.University;
import services.PickComparator;
import services.ReadXls;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = ReadXls.StudentsFromXls();
        StudentsComparator studentsComparator =
                PickComparator.getStudentComparator(StudentComparatorTypes.AVG_EXAM_SCORE);
        students.stream()
                .sorted(studentsComparator)
                .forEach(System.out::println);


        ArrayList<University> universities = ReadXls.UniversitiesFromXls();
        UniversitiesComparator universitiesComparator =
                PickComparator.getUniversityComparator(UniversityComparatorTypes.UNIVERSITY_YEAR_OF_FOUNDATION);
        universities.stream()
                .sorted(universitiesComparator)
                .forEach(System.out::println);
    }
}
