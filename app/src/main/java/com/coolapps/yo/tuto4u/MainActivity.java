package com.coolapps.yo.tuto4u;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.coolapps.yo.tuto4u.com.coolapps.yo.tuto4u.util.HomeActivity;
import com.coolapps.yo.tuto4u.com.coolapps.yo.tuto4u.util.TutoTextUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends BaseActivity {
    private FirebaseAuth mAuth;

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
                String emailString = email.toString().trim();
                String passwordString = password.toString();

                hideKeyboard(v);
                showProgressDialog();

                mAuth.signInWithEmailAndPassword(emailString, passwordString)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                                    startActivity(HomeActivity.class);

                                } else {
                                    Toast.makeText(MainActivity.this, "Sign in failed", Toast.LENGTH_SHORT).show();
                                }
                                hideProgressDialog();
                            }
                        });
            } else {
                Toast.makeText(MainActivity.this, "Username or password should not be empty", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        mSignUpButton = findViewById(R.id.sign_up);

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
