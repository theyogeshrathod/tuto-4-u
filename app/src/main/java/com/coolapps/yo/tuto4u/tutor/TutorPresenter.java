package com.coolapps.yo.tuto4u.tutor;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class TutorPresenter {

    public List<TutorModel> getMockListOfAllTutors() {
        List<TutorModel> tutors = new ArrayList<>();

        List<RatingsModel> ratingsModels = new ArrayList<>();
        ratingsModels.add(new RatingsModel("DBMS", 4.5f, 8f));
        ratingsModels.add(new RatingsModel("OS", 4.0f, 4f));
        ratingsModels.add(new RatingsModel("JAVA", 4.5f, 10f));
        tutors.add(createTutorModel("Alex Janson", "alex@gmail.com",
                "9023991525", "B.E. IT", ratingsModels));

        ratingsModels = new ArrayList<>();
        ratingsModels.add(new RatingsModel("C", 3.5f, 3f));
        ratingsModels.add(new RatingsModel("C++", 3.4f, 2f));
        tutors.add(createTutorModel("Reid Baker", "reid@gmail.com",
                "9021273425", "B.E. COMP", ratingsModels));

        ratingsModels = new ArrayList<>();
        ratingsModels.add(new RatingsModel("JAVA", 4f, 4.5f));
        ratingsModels.add(new RatingsModel("ANDROID", 3.4f, 2f));
        tutors.add(createTutorModel("Hannah", "hannah@gmail.com",
                "7276822812", "B.Tech. COMP", ratingsModels));

        ratingsModels = new ArrayList<>();
        ratingsModels.add(new RatingsModel("PYTHON", 4.5f, 4.3f));
        ratingsModels.add(new RatingsModel("SELENIAM", 4f, 3f));
        ratingsModels.add(new RatingsModel("JENKINS", 4.3f, 2f));
        tutors.add(createTutorModel("Kishor Lahoti", "kishor@gmail.com",
                "7276882123", "B.Tech. COMP", ratingsModels));

        ratingsModels = new ArrayList<>();
        ratingsModels.add(new RatingsModel("BIG DATA", 4f, 4.5f));
        tutors.add(createTutorModel("Akshay Munde", "akshay@gmail.com",
                "9882173622", "B.Tech. COMP", ratingsModels));

        ratingsModels = new ArrayList<>();
        ratingsModels.add(new RatingsModel("AUTOMATION", 4.7f, 4.1f));
        tutors.add(createTutorModel("Pratik Black", "pratik@gmail.com",
                "9987651234", "B.Tech. COMP", ratingsModels));

        return tutors;
    }

    private TutorModel createTutorModel(@NonNull String name, @NonNull String email,
            @NonNull String contactNumber, @NonNull String qualification,
            @NonNull List<RatingsModel> ratingsModels) {
        return new TutorModel(name, email, contactNumber, qualification, ratingsModels);
    }
}
