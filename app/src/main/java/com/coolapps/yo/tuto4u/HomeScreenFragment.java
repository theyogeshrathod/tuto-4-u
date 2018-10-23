package com.coolapps.yo.tuto4u;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.coolapps.yo.tuto4u.tutor.TutorAdapter;
import com.coolapps.yo.tuto4u.tutor.TutorModel;
import com.coolapps.yo.tuto4u.tutor.TutorPresenter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.GetTokenResult;

import java.util.List;

/**
 * A Home screen fragment displayed as a main fragment of the app after login.
 */
public class HomeScreenFragment extends Fragment implements TutorAdapter.OnTutorItemClickListener {
    private static final String TAG = "HomeScreenFragment";

    private HomeScreenFragment mHomeScreenFragment;
    private RecyclerView mTutorRecyclerView;
    private Context mContext;

    interface OnTutorItemSelectedListener {
        void onTutorItemSelected(String emailId);
    }

    public HomeScreenFragment newInstance() {
        if (mHomeScreenFragment == null) {
            mHomeScreenFragment = new HomeScreenFragment();
        }

        return mHomeScreenFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTutorRecyclerView = view.findViewById(R.id.tutor_list);

        List<TutorModel> tutorModels = new TutorPresenter().getMockListOfAllTutors();
        TutorAdapter tutorAdapter = new TutorAdapter(tutorModels, this);
        mTutorRecyclerView.setAdapter(tutorAdapter);
        mTutorRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mTutorRecyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));

        view.findViewById(R.id.test_auth_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseManager.getFirebaseAuth().getAccessToken(true).addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
                    @Override
                    public void onComplete(@NonNull Task<GetTokenResult> task) {
                        if (task.isSuccessful()) {
                            String idToken = task.getResult().getToken();
                            Log.v(TAG, "getAccessToken() successful: " + idToken);

                            TutoApiRequests.newInstance(mContext).getAllTutors(idToken);

                        } else {
                            Log.e(TAG, "getAccessToken() failed");
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onTutorItemClicked(String emailId) {
        if (getActivity() instanceof OnTutorItemSelectedListener) {
            ((OnTutorItemSelectedListener) getActivity()).onTutorItemSelected(emailId);
        } else {
            Toast.makeText(getContext(), "Error opening details", Toast.LENGTH_SHORT).show();
        }
    }
}
