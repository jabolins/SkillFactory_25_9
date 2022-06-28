package services;

import models.Statistics;
import models.Student;
import models.StudyProfile;
import models.University;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticUtil {
    private StatisticUtil() {
    }

    public static ArrayList<Statistics> generateStatistic(ArrayList<Student> students, ArrayList<University>universities){
        ArrayList<Statistics> statisticsList= new ArrayList<>();

        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setStudyProfile(profile);

        List<String> profileUniversityIds = universities.stream()
                .filter(university -> university.getMainProfile().equals(profile))
                .map(University::getId)
                .collect(Collectors.toList());
        statistics.setNumberOfUniversitiesProfile(profileUniversityIds.size());
        statistics.setUniversityName(StringUtils.EMPTY);

        universities.stream()
                .filter(university -> profileUniversityIds.contains(university.getId()))
                .map(University::getFullName)
                .forEach(fullNameUniversity -> statistics.setUniversityName(
                        statistics.getUniversityName() + fullNameUniversity + ";"));

        List<Student> profileStudents = students.stream()
                .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                .collect(Collectors.toList());
        statistics.setNumberOfStudentsProfile(profileStudents.size());
        OptionalDouble avgExamScore = profileStudents.stream()
                .mapToDouble(Student::getAvgExamScore)
                .average();
        statistics.setAvgExamScore(0);
        avgExamScore.ifPresent(value -> statistics.setAvgExamScore(
                (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
    });

        return statisticsList;
    }
}
