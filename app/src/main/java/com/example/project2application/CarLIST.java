package com.example.project2application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

import javax.annotation.Nullable;

public class CarLIST extends AppCompatActivity {
        ImageView mCar1, mCar2, mCar3, mCar4;
        TextView mOwner1, mOwner2, mOwner3, mOwner4;
        TextView mPlateno1, mPlateno2, mPlateno3, mPlateno4;
        TextView mEmirate1, mEmirate2, mEmirate3, mEmirate4;
        TextView mPhonenum1, mPhonenum2, mPhonenum3, mPhonenum4;
        TextView mColor1, mColor2, mColor3, mColor4;
        TextView mInsurance1, mInsurance2, mInsurance3, mInsurance4;
        FirebaseFirestore fStore;
        FirebaseStorage storage = FirebaseStorage.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);
        mCar1 = findViewById(R.id.car1);
        mCar2 = findViewById(R.id.car2);
        mCar3 = findViewById(R.id.car3);
        mCar4 = findViewById(R.id.car4);
        mPlateno1 = findViewById(R.id.Plateno1);
        mPlateno2 = findViewById(R.id.Plateno2);
        mPlateno3 = findViewById(R.id.Plateno3);
        mPlateno4 = findViewById(R.id.Plateno4);
        mOwner1 = findViewById(R.id.Owner1);
        mOwner2 = findViewById(R.id.Owner2);
        mOwner3 = findViewById(R.id.Owner3);
        mOwner4 = findViewById(R.id.Owner4);
        //mEmirate1 = findViewById(R.id.Emirate1);
        //mEmirate2 = findViewById(R.id.Emirate2);
        //mEmirate3 = findViewById(R.id.Emirate3);
        //mEmirate4 = findViewById(R.id.Emirate4);
        mPhonenum1 = findViewById(R.id.Phonenum1);
        mPhonenum2 = findViewById(R.id.Phonenum2);
        mPhonenum3 = findViewById(R.id.Phonenum3);
        mPhonenum4 = findViewById(R.id.Phonenum4);
        //mColor1 = findViewById(R.id.Color1);
        //mColor2 = findViewById(R.id.Color2);
        //mColor3 = findViewById(R.id.Color3);
        //mColor4 = findViewById(R.id.Color4);
        //mInsurance1 = findViewById(R.id.Insurance1);
        //mInsurance2 = findViewById(R.id.Insurance2);
        //mInsurance3 = findViewById(R.id.Insurance3);
        //mInsurance4 = findViewById(R.id.Insurance4);

        fStore = FirebaseFirestore.getInstance();

        mCar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Car1.class));
            }
        });

        final DocumentReference documentReference1 = fStore.collection("Vehicles").document("29940");
        final DocumentReference documentReference2 = fStore.collection("Vehicles").document("29941");
        final DocumentReference documentReference3 = fStore.collection("Vehicles").document("28011");
        final DocumentReference documentReference4 = fStore.collection("Vehicles").document("27175");
        documentReference1.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                mOwner1.setText(documentSnapshot.getString("Vehicle Owner"));
                //mEmirate1.setText(documentSnapshot.getString("Issuing Emirate"));
                mPhonenum1.setText(documentSnapshot.getString("Phone Number"));
                //mColor1.setText(documentSnapshot.getString("Color"));
                //mInsurance1.setText(documentSnapshot.getString("Insurance Company"));
                mPlateno1.setText(documentSnapshot.getString("Plate Number"));

                StorageReference storageref1 = storage.getReferenceFromUrl("gs://project2application.appspot.com/uploads/0566234464.jpg");
                try {
                    final File file = File.createTempFile("image", "jpg");
                    storageref1.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                            mCar1.setImageBitmap(bitmap);
                        }
                    });
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });
        documentReference2.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                mOwner2.setText(documentSnapshot.getString("Vehicle Owner"));
                //mEmirate2.setText(documentSnapshot.getString("Issuing Emirate"));
                mPhonenum2.setText(documentSnapshot.getString("Phone Number"));
                //mColor2.setText(documentSnapshot.getString("Color"));
                //mInsurance2.setText(documentSnapshot.getString("Insurance Company"));
                mPlateno2.setText(documentSnapshot.getString("Plate Number"));

                StorageReference storageref2 = storage.getReferenceFromUrl("gs://project2application.appspot.com/uploads/0509518842.jpg");
                try {
                    final File file = File.createTempFile("image", "jpg");
                    storageref2.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                            mCar2.setImageBitmap(bitmap);
                        }
                    });
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        documentReference3.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                mOwner3.setText(documentSnapshot.getString("Vehicle Owner"));
                //mEmirate3.setText(documentSnapshot.getString("Issuing Emirate"));
                mPhonenum3.setText(documentSnapshot.getString("Phone Number"));
                //mColor3.setText(documentSnapshot.getString("Color"));
                //mInsurance3.setText(documentSnapshot.getString("Insurance Company"));
                mPlateno3.setText(documentSnapshot.getString("Plate Number"));

                StorageReference storageref3 = storage.getReferenceFromUrl("gs://project2application.appspot.com/uploads/0555253343.jpg");
                try {
                    final File file = File.createTempFile("image", "jpg");
                    storageref3.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                            mCar3.setImageBitmap(bitmap);
                        }
                    });
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        documentReference4.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                mOwner4.setText(documentSnapshot.getString("Vehicle Owner"));
                //mEmirate4.setText(documentSnapshot.getString("Issuing Emirate"));
                mPhonenum4.setText(documentSnapshot.getString("Phone Number"));
                //mColor4.setText(documentSnapshot.getString("Color"));
                //mInsurance4.setText(documentSnapshot.getString("Insurance Company"));
                mPlateno4.setText(documentSnapshot.getString("Plate Number"));

                StorageReference storageref4 = storage.getReferenceFromUrl("gs://project2application.appspot.com/uploads/055555555.jpg");
                try {
                    final File file = File.createTempFile("image", "jpg");
                    storageref4.getFile(file).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                            mCar4.setImageBitmap(bitmap);
                        }
                    });
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });


    }
}
