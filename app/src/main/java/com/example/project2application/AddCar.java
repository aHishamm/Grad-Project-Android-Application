package com.example.project2application;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class AddCar extends AppCompatActivity {
    public static final String TAG = "TAG";
        Button mUploadCar, mSubmit;
        EditText mPlateNo, mColor, mIssuingEmirate, mPhoneNumber, mOwner, mInsuranceComp;
        ImageView mImageView2;
        StorageReference mStorageref;
        DatabaseReference mDatabaseref;
        FirebaseFirestore fStore;
        DocumentReference documentreference;
        //FirebaseStorage fStorage;
        private static final int PICK_IMAGE_REQUEST = 1;
        private Uri mImageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        mImageView2 = findViewById(R.id.imageView2);
        mUploadCar = findViewById(R.id.uploadCar);
        mSubmit = findViewById(R.id.submit);
        mPlateNo = findViewById(R.id.plateNo);
        //mColor = findViewById(R.id.color);
        //mIssuingEmirate = findViewById(R.id.issuingEmirate);
        mPhoneNumber = findViewById(R.id.phoneNumber);
        mOwner = findViewById(R.id.owner);
        //mInsuranceComp = findViewById(R.id.insuranceComp);

        fStore = FirebaseFirestore.getInstance();
        mStorageref = FirebaseStorage.getInstance().getReference("uploads");
        mDatabaseref = FirebaseDatabase.getInstance().getReference("uploads");


        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String plateNo = mPlateNo.getText().toString().trim();
                //final String Color = mColor.getText().toString().trim();
                //final String IssuingEmirate = mIssuingEmirate.getText().toString().trim();
                final String PhoneNumber = mPhoneNumber.getText().toString().trim();
                final String Owner = mOwner.getText().toString().trim();
                //final String InsuranceComp = mInsuranceComp.getText().toString().trim();

                if(TextUtils.isEmpty(plateNo) || TextUtils.isEmpty(PhoneNumber) || TextUtils.isEmpty(Owner)){
                    mSubmit.setError("Provide the full information.");
                    return;
                }
                //submitting the car information to the firestore database
                documentreference = fStore.collection("Vehicles").document(plateNo);
                Map<String, Object> vehicle = new HashMap<>();
                vehicle.put("Plate Number", plateNo);
                //vehicle.put("Color", Color);
                //vehicle.put("Issuing Emirate", IssuingEmirate);
                vehicle.put("Phone Number", PhoneNumber);
                vehicle.put("Vehicle Owner", Owner);
                //vehicle.put("Insurance Company", InsuranceComp);

                documentreference.set(vehicle).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "onSuccess: Vehicle profile is created for "+plateNo);
                    }
                });

                //uploading the picture to the firebase storage and the firebase database through the uploadFile() method
                uploadFile();
                //go to the previous selection page
                startActivity(new Intent(getApplicationContext(), CarMenu.class));
            }
        });

        mUploadCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFileChooser();
            }
        });
    }
    private void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode  == RESULT_OK && data != null && data.getData() != null){
            mImageUri = data.getData();
            Picasso.with(this).load(mImageUri).into(mImageView2);
        }
    }
    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }
    private void uploadFile(){
        final String PhoneNumber = mPhoneNumber.getText().toString().trim();
        if(mImageUri != null ){
            //StorageReference fileReference = mStorageref.child(System.currentTimeMillis() + "." + getFileExtension(mImageUri));
            StorageReference fileReference = mStorageref.child(PhoneNumber + "." + getFileExtension(mImageUri));
            fileReference.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(AddCar.this, "Upload Successful", Toast.LENGTH_SHORT).show();
                }
            });
        } else{
            Toast.makeText(this, "No File Selected", Toast.LENGTH_SHORT).show();
        }
    }
}
