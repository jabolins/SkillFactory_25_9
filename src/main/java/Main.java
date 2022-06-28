import comparators.StudentsComparator;
import comparators.UniversitiesComparator;
import comparators.comperatorEnums.StudentComparatorTypes;
import comparators.comperatorEnums.UniversityComparatorTypes;
import models.Statistics;
import models.Student;
import models.University;
import services.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = XlsReader.StudentsFromXls();
        StudentsComparator studentsComparator =
                PickComparator.getStudentComparator(StudentComparatorTypes.AVG_EXAM_SCORE);
        students.sort(studentsComparator);

        //В методе main выполнить сериализацию коллекций, вывести получившиеся JSON-строки в консоль.
        String studentsToJson = JsonUtil.studentsListToJson(students);
        System.out.println(studentsToJson);

        //В методе main выполнить десериализацию полученных строк, сохранить результаты в новые коллекции.
        ArrayList<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsToJson);

        //Сравнить количество элементов в исходной и в десериализованной коллекциях, чтобы убедиться
        // , что десериализация выполняется корректно.
        System.out.println("are the sizes of the students collections the same- "
                + (studentsFromJson.size() == students.size()));

        //С помощью Java Stream API выполнить для исходных коллекций сериализацию отдельных элементов.
        //Там же внутри стрима выводить получающиеся JSON-строки.
        //Там же внутри стрима десериализовывать объекты из полученных JSON-строк.
        //Там же внутри стрима выводить десериализованные объекты на печать, чтобы убедиться в корректности операции.
        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            System.out.println(studentFromJson);
        });

        ArrayList<University> universities = XlsReader.UniversitiesFromXls();
        UniversitiesComparator universitiesComparator =
                PickComparator.getUniversityComparator(UniversityComparatorTypes.UNIVERSITY_YEAR_OF_FOUNDATION);
        universities.sort(universitiesComparator);

        //В методе main выполнить сериализацию коллекций, вывести получившиеся JSON-строки в консоль.
        String universitiesToJson = JsonUtil.universitiesListToJson(universities);
        System.out.println(universitiesToJson);

        //В методе main выполнить десериализацию полученных строк, сохранить результаты в новые коллекции.
        ArrayList<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesToJson);

        //Сравнить количество элементов в исходной и в десериализованной коллекциях, чтобы убедиться
        // , что десериализация выполняется корректно.
        System.out.println("are the sizes of the universities collections the same- "
                + (universitiesFromJson.size() == universities.size()));

        //С помощью Java Stream API выполнить для исходных коллекций сериализацию отдельных элементов.
        //Там же внутри стрима выводить получающиеся JSON-строки.
        //Там же внутри стрима десериализовывать объекты из полученных JSON-строк.
        //Там же внутри стрима выводить десериализованные объекты на печать, чтобы убедиться в корректности операции.
        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            System.out.println(universityFromJson);
        });

        ArrayList<Statistics> statistics = StatisticUtil.generateStatistic(students, universities);

        XlsWriter.createStatisticReport(statistics, "src/main/resources/statisticReport.xlsx");
    }
}
