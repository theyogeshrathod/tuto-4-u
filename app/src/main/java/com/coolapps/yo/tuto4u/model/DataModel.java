package com.coolapps.yo.tuto4u.model;

public class DataModel {
    private static DataModel sDataModel;
    private static final Object mLock = new Object();

    public static DataModel getInstance() {
        synchronized (mLock) {
            if (sDataModel == null) {
                sDataModel = new DataModel();
            }
            return sDataModel;
        }
    }
}
