package com.example.project2application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class Car1 extends AppCompatActivity {
    ImageView mCarView;
    TextView mPlateno, mmOwner, mEmirate, mPhoneNum, mColor, mInsurance;
    Button mctrlvehicle;
    FirebaseFirestore fStore;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car1);
        mCarView = findViewById(R.id.carView);
        mPlateno = findViewById(R.id.Platenomber);
        mmOwner = findViewById(R.id.mOwner);
        //mEmirate = findViewById(R.id.Emirate);
        mPhoneNum = findViewById(R.id.PhoneNum);
        //mColor = findViewById(R.id.Color);
        //mInsurance = findViewById(R.id.Insurance);
        mctrlvehicle = findViewById(R.id.ctrlvehicle);


        fStore = FirebaseFirestore.getInstance();
        mctrlvehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), sndCommandsPage.class));
            }
        });


        final DocumentReference documentRef = fStore.collection("Vehicles").document("29940");

        documentRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                mmOwner.setText(documentSnapshot.getString("Vehicle Owner"));
                //mEmirate.setText(documentSnapshot.getString("Issuing Emirate"));
                mPhoneNum.setText(documentSnapshot.getString("Phone Number"));
                //mColor.setText(documentSnapshot.getString("Color"));
               //mInsurance.setText(documentSnapshot.getString("Insurance Company"));
                mPlateno.setText(documentSnapshot.getString("Plate Number"));

                StorageReference storagerefff = storage.getReferenceFromUrl("gs://project2application.appspot.com/uploads/0566234464.jpg");
                try {
                    final File test = File.createTempFile("image", "jpg");
                    storagerefff.getFile(test).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap = BitmapFactory.decodeFile(test.getAbsolutePath());
                            mCarView.setImageBitmap(bitmap);
                        }
                    });
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

    }
}
