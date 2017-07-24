package com.forste.manicure.data;

import android.support.annotation.NonNull;

import com.forste.manicure.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by sergejkozin on 7/3/17.
 */

public class AuthorizationDataSource implements AuthorizationBaseDataSource {
    private FirebaseAuth mAuth;

    @Override
    public void userVerification(User user, final CallBackVerification callBack) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            callBack.onFailure();
                        } else {
                            callBack.onSuccess(task.getResult().getUser().getUid());
                        }
                    }
                });
    }
}
