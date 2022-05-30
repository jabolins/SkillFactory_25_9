package models;

public enum StudyProfile {
    PHYSICS("физика")
    , ECONOMIC("экономика")
    , LINGUISTICS("лингвистика")
    , MEDICINE("медицина")
    , MATHEMATICS("математика")
    , DEFAULT( "по умолчанию");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }

    @Override
    public String toString() {
        return "StudyProfile{" +
                "profileName='" + profileName + '\'' +
                '}';
    }
}
