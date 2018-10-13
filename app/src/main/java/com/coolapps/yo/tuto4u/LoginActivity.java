package com.coolapps.yo.tuto4u;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.coolapps.yo.tuto4u.com.coolapps.yo.tuto4u.util.TutoTextUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends BaseActivity {
    private FirebaseAuth mFirebaseAuth = FirebaseManager.getFirebaseAuth();

    private Button mSignUpButton;
    private Button mSignInButton;
    private EditText mEmailEditText;
    private EditText mPasswordEditText;

    private View.OnClickListener mSignInClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CharSequence email = mEmailEditText.getText();
            CharSequence password = mPasswordEditText.getText();

            mEmailEditText.setText(null);
            mPasswordEditText.setText(null);

            hideKeyboard(v);

            if (TutoTextUtils.isNonEmpty(email) && TutoTextUtils.isNonEmpty(password)) {
                final String emailString = email.toString().trim().toLowerCase();
                String passwordString = password.toString();

                hideKeyboard(v);
                showProgressDialog();

                mFirebaseAuth.signInWithEmailAndPassword(emailString, passwordString)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(LoginActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();

                                    SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                                    SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
                                    prefsEditor.putString(TutoConstants.LOGGED_IN_USER, emailString);
                                    prefsEditor.apply();

                                    startActivity(HomeActivity.class);
                                    finish();

                                } else {
                                    Toast.makeText(LoginActivity.this, "Sign in failed", Toast.LENGTH_SHORT).show();
                                }
                                hideProgressDialog();
                            }
                        });
            } else {
                Toast.makeText(LoginActivity.this, "Username or password should not be empty", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private View.OnClickListener mSignUpClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(RegisterActivity.class);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
        if (firebaseUser != null) {
            String firebaseUserEmail = firebaseUser.getEmail();
            if (firebaseUserEmail != null &&
                    firebaseUserEmail.equals(sharedPreferences.getString(TutoConstants.LOGGED_IN_USER, null))) {
                startActivity(HomeActivity.class);
                finish();
            }
        }

        setContentView(R.layout.activity_login);

        mSignUpButton = findViewById(R.id.sign_up);
        mSignUpButton.setOnClickListener(mSignUpClickListener);

        mSignInButton = findViewById(R.id.sign_in);
        mSignInButton.setOnClickListener(mSignInClickListener);

        mEmailEditText = findViewById(R.id.user_name);
        mPasswordEditText = findViewById(R.id.password);
    }

    private void startActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
