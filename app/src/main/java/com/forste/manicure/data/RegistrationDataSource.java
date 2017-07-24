package com.forste.manicure.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.forste.manicure.model.Constant;
import com.forste.manicure.model.Person;
import com.forste.manicure.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;

/**
 * Created by sergejkozin on 7/3/17.
 */

public class RegistrationDataSource implements RegistrationBaseDataSource {

    private FirebaseAuth mAuth;


    @Override
    public void userRegistration(User user, final CallBackUserRegistration callBack) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            callBack.onFailureRegistrationUser();
                        } else {
                            callBack.onSuccessRegistrationUser();
                        }
                    }
                });
    }

    @Override
    public void userAdditionalRegistration(Person person, String token, CallBackPersonRegistration callBack) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference();
        DatabaseReference usersRef = ref.child(Constant.USER).child(token);
        try {
            usersRef.setValue(person);
        } catch (DatabaseException e) {
            callBack.onFailureRegistrationPerson();
        }
        callBack.onSuccessRegistrationPerson();
    }

    @Override
    public void addUserPhoto(Context context, Person person, String token, final CallBackPhoto callBack) {
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child(Constant.IMAGE).child(token);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        person.getPhoto().compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();

        UploadTask uploadTask = storageReference.putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                callBack.onFailurePhoto();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                callBack.onSuccessPhoto();
            }
        });
    }
}
