package models;

public class Statistics {
    private StudyProfile studyProfile;
    private float avgExamScore;
    private int numberOfStudentsProfile;
    private int numberOfUniversitiesProfile;
    private String universityName;

    public Statistics(StudyProfile studyProfile, float avgExamScore, int numberOfStudentsProfile, int numberOfUniversitiesProfile, String universityName) {
        this.studyProfile = studyProfile;
        this.avgExamScore = avgExamScore;
        this.numberOfStudentsProfile = numberOfStudentsProfile;
        this.numberOfUniversitiesProfile = numberOfUniversitiesProfile;
        this.universityName = universityName;
    }

    public Statistics() {
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public Statistics setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Statistics setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public int getNumberOfStudentsProfile() {
        return numberOfStudentsProfile;
    }

    public Statistics setNumberOfStudentsProfile(int numberOfStudentsProfile) {
        this.numberOfStudentsProfile = numberOfStudentsProfile;
        return this;
    }

    public int getNumberOfUniversitiesProfile() {
        return numberOfUniversitiesProfile;
    }

    public Statistics setNumberOfUniversitiesProfile(int numberOfUniversitiesProfile) {
        this.numberOfUniversitiesProfile = numberOfUniversitiesProfile;
        return this;
    }

    public String getUniversityName() {
        return universityName;
    }

    public Statistics setUniversityName(String universityName) {
        this.universityName = universityName;
        return this;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "studyProfile=" + studyProfile +
                ", avgExamScore=" + avgExamScore +
                ", numberOfStudentsProfile=" + numberOfStudentsProfile +
                ", numberOfUniversitiesProfile=" + numberOfUniversitiesProfile +
                ", universityName='" + universityName + '\'' +
                '}';
    }
}
