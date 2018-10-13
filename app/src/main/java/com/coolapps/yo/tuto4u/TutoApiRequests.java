package com.coolapps.yo.tuto4u;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.coolapps.yo.tuto4u.com.coolapps.yo.tuto4u.util.TutoTextUtils;
import com.google.gson.Gson;

public class TutoApiRequests {
    private static final String TAG = "TutoApiRequests";

    private RequestQueue mQueue;
    private Gson mGson = new Gson();

    private static TutoApiRequests mTutoApiRequests;

    public static TutoApiRequests newInstance(Context context) {
        if (mTutoApiRequests == null) {
            mTutoApiRequests = new TutoApiRequests(context);
        }
        return mTutoApiRequests;
    }

    private TutoApiRequests(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    public void sendTestRequest(String idToken) {
        String url = "";
        if (TutoTextUtils.isNonEmpty(idToken)) {
            url = TutoConstants.FIREBASE_DATABASE_HOST + "users.json?auth=" + idToken;
        }

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Volley response error: " + error);
            }
        });

        mQueue.add(stringRequest);
    }

    public void getAllTutors(String idToken) {
        String url = "";
        if (TutoTextUtils.isNonEmpty(idToken)) {
            url = TutoConstants.FIREBASE_DATABASE_HOST + TutoConstants.FIREBASE_TUTORS_ENDPOINT + "?auth=" + idToken;
        }

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                TutorModelsList tutorModels = mGson.fromJson(response, TutorModelsList.class);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Volley response error: " + error);
            }
        });

        mQueue.add(stringRequest);

    }
}
