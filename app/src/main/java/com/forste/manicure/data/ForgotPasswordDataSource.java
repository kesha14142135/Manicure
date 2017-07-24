package com.forste.manicure.data;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by sergejkozin on 7/3/17.
 */

public class ForgotPasswordDataSource implements ForgotPasswordBaseDataSource {

    @Override
    public void sandMail(String mail, final CallBackMailSand callBack) {

        FirebaseAuth.getInstance().sendPasswordResetEmail(mail)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            callBack.onSuccess();
                        } else {
                            callBack.onFailure();
                        }
                    }
                });
    }
}
