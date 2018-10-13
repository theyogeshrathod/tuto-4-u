package com.coolapps.yo.tuto4u.tutor;

import android.support.annotation.NonNull;

import java.util.Objects;

public class RatingsModel {
    @NonNull
    private String mSubject;

    private float mRating;
    private float mNumberOfYearsExperience;

    @NonNull
    public String getSubject() {
        return mSubject;
    }

    public RatingsModel(@NonNull String subject, float rating, float numberOfYearsExperience) {
        mSubject = subject;
        mRating = rating;
        mNumberOfYearsExperience = numberOfYearsExperience;
    }

    public float getNumberOfYearsExperience() {
        return mNumberOfYearsExperience;
    }

    public void setNumberOfYearsExperience(float numberOfYearsExperience) {
        mNumberOfYearsExperience = numberOfYearsExperience;
    }

    public void setSubject(@NonNull String subject) {
        mSubject = subject;
    }

    public float getRating() {
        return mRating;
    }

    public void setRating(float rating) {
        mRating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingsModel that = (RatingsModel) o;
        return Float.compare(that.mRating, mRating) == 0 &&
                Float.compare(that.mNumberOfYearsExperience, mNumberOfYearsExperience) == 0 &&
                Objects.equals(mSubject, that.mSubject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mSubject, mRating, mNumberOfYearsExperience);
    }
}
