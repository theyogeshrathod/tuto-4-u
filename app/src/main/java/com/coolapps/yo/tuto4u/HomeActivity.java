package com.coolapps.yo.tuto4u;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class HomeActivity extends BaseActivity implements HomeScreenFragment.OnTutorItemSelectedListener {
    private static final String HOME_SCREEN_FRAGMENT_TAG = "home_screen_fragment_tag";
    private static final String TUTOR_DETAIL_FRAGMENT_TAG = "tutor_detail_fragment_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addHomeScreenFragment();
    }

    private void addHomeScreenFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (!(fragmentManager.findFragmentByTag(HOME_SCREEN_FRAGMENT_TAG) instanceof HomeScreenFragment)) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.container, new HomeScreenFragment().newInstance(), HOME_SCREEN_FRAGMENT_TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onTutorItemSelected(String emailId) {
        addTutorDetailsFragment(emailId);
    }

    private void addTutorDetailsFragment(String emailId) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (!(fragmentManager.findFragmentByTag(TUTOR_DETAIL_FRAGMENT_TAG) instanceof HomeScreenFragment)) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, new TutorDetailsFragment(), TUTOR_DETAIL_FRAGMENT_TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentById(R.id.container) instanceof HomeScreenFragment) {
            finish();
        }
        super.onBackPressed();
    }
}
