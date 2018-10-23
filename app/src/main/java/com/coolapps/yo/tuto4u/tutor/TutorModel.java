package com.coolapps.yo.tuto4u.tutor;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class TutorModel {

    @NonNull
    @SerializedName("name")
    private String mName;

    @NonNull
    @SerializedName("email")
    private String mEmailId;

    @NonNull
    @SerializedName("contact_no")
    private String mContactNumber;

    @NonNull
    private List<RatingsModel> mRatingsModels;

    @NonNull
    @SerializedName("qualification")
    private String mQualification;

    TutorModel(@NonNull String name, @NonNull String email, @NonNull String contactNumber,
               @NonNull String qualification, @NonNull List<RatingsModel> ratingsModel) {
        mName = name;
        mEmailId = email;
        mContactNumber = contactNumber;
        // TODO: mRatingsModels = ratingsModel;
        mQualification = qualification;
    }

    @NonNull
    public String getName() {
        return mName;
    }

    public void setName(@NonNull String name) {
        mName = name;
    }

    @NonNull
    public String getEmailId() {
        return mEmailId;
    }

    public void setEmailId(@NonNull String email) {
        mEmailId = email;
    }

    @NonNull
    public String getContactNumber() {
        return mContactNumber;
    }

    public void setContactNumber(@NonNull String contactNumber) {
        mContactNumber = contactNumber;
    }

    @NonNull
    public List<RatingsModel> getRatingsModels() {
        return mRatingsModels;
    }

    public void setRatingsModel(@NonNull List<RatingsModel> ratingsModels) {
        mRatingsModels = ratingsModels;
    }

    @NonNull
    public String getQualification() {
        return mQualification;
    }

    public void setQualification(@NonNull String qualification) {
        mQualification = qualification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TutorModel that = (TutorModel) o;
        return Objects.equals(mName, that.mName) &&
                Objects.equals(mEmailId, that.mEmailId) &&
                Objects.equals(mContactNumber, that.mContactNumber) &&
                // TODO: Objects.equals(mRatingsModels, that.mRatingsModels) &&
                Objects.equals(mQualification, that.mQualification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mName, mEmailId, mContactNumber, /* TODO: mRatingsModels,*/ mQualification);
    }
}
