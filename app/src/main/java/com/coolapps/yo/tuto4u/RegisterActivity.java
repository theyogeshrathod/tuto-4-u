package com.coolapps.yo.tuto4u;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.coolapps.yo.tuto4u.com.coolapps.yo.tuto4u.util.TutoTextUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends BaseActivity {
    private FirebaseAuth mAuth;

    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mSubmitButton;

    private View.OnClickListener mSignUpClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CharSequence email = mEmailEditText.getText();
            CharSequence password = mPasswordEditText.getText();

            mEmailEditText.setText(null);
            mPasswordEditText.setText(null);

            hideKeyboard(v);

            if (TutoTextUtils.isNonEmpty(email) && TutoTextUtils.isNonEmpty(password)) {
                String emailString = email.toString().trim().toLowerCase();
                String passwordString = password.toString();

                showProgressDialog();

                mAuth.createUserWithEmailAndPassword(emailString, passwordString)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, "Sign up successful", Toast.LENGTH_SHORT).show();
                                    finish();
                                } else {
                                    Exception e = task.getException();
                                    if (e != null) {
                                        Toast.makeText(RegisterActivity.this, "Sign up failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(RegisterActivity.this, "Sign up failed: ", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                hideProgressDialog();
                            }
                        });

            } else {
                Toast.makeText(RegisterActivity.this, "Username or password should not be empty", Toast.LENGTH_SHORT).show();
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        mEmailEditText = findViewById(R.id.user_name);
        mPasswordEditText = findViewById(R.id.password);

        mSubmitButton = findViewById(R.id.submit);
        mSubmitButton.setOnClickListener(mSignUpClickListener);
    }
}
