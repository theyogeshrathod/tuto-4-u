package com.coolapps.yo.tuto4u;

import com.coolapps.yo.tuto4u.tutor.TutorModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TutorModelsList {

    @SerializedName("tutors")
    private List<TutorModel> mTutorModels;
}
