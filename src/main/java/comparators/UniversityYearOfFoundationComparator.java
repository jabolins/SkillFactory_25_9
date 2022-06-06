package comparators;

import models.University;

public class UniversityYearOfFoundationComparator implements UniversitiesComparator{
    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
    }
}
