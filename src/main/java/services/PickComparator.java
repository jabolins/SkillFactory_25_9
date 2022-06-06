package services;

import comparators.*;
import comparators.comperatorEnums.StudentComparatorTypes;
import comparators.comperatorEnums.UniversityComparatorTypes;

public class PickComparator {

    private PickComparator() {
    }

    public static StudentsComparator getStudentComparator(StudentComparatorTypes comparatorTypes) {
        switch (comparatorTypes) {
           case FULL_NAME:
               return new StudentFullNameComparator();
            case UNIVERSITY_ID:
                return new StudentUniversityIdComparator();
            case CURRENT_COURSE:
                return new StudentCurrentCourseComparator();
            case AVG_EXAM_SCORE:
                return new StudentAvgExamScoreComparator();
            default:
                return null;
        }
    }

    public static UniversitiesComparator getUniversityComparator(UniversityComparatorTypes comparatorTypes){
        switch (comparatorTypes){
            case UNIVERSITY_FULL_NAME:
                return new UniversityFullNameComparator();
            case UNIVERSITY_ID:
                return new UniversityIdComparator();
            case UNIVERSITY_MAIN_PROFILE:
                return new UniversityMainProfileComparator();
            case UNIVERSITY_SHORT_NAME:
                return new UniversityShortNameComparator();
            case UNIVERSITY_YEAR_OF_FOUNDATION:
                return new UniversityYearOfFoundationComparator();
            default:
                return null;
        }
    }
}