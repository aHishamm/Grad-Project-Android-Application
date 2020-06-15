package com.example.project2application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sndCommandsPage extends AppCompatActivity {
    private static final String TAG = "TAG";
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
        EditText mspeedLimit, mNWLAT, mNWLNG, mNELAT, mNELNG, mSWLAT, mSWLNG, mSELAT, mSELNG;
        Button mspeedLimitsnd, mNWLATsnd, mNWLNGsnd, mNELATsnd, mNELNGsnd, mSWLATsnd, mSWLNGsnd, mSELATsnd, mSELNGsnd;
        Button mproceedtoMap;
        final String phoneNumbertest = "0566234464";
        public static String mNWLATT, mNWLNGG, mNELATT, mNELNGG, mSWLATT, mSWLNGG, mSELATT, mSELNGG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snd_commands_page);
        mspeedLimit = findViewById(R.id.speedLimit);
        mNWLAT = findViewById(R.id.NWLAT);
        mNWLNG = findViewById(R.id.NWLNG);
        mNELAT = findViewById(R.id.NELAT);
        mNELNG = findViewById(R.id.NELNG);
        mSWLAT = findViewById(R.id.SWLAT);
        mSWLNG = findViewById(R.id.SWLNG);
        mSELAT = findViewById(R.id.SELAT);
        mSELNG = findViewById(R.id.SELNG);

        mspeedLimitsnd = findViewById(R.id.speedlimitsnd);
        mNWLATsnd = findViewById(R.id.NWLATsnd);
        mNWLNGsnd = findViewById(R.id.NWLNGsnd);
        mNELATsnd = findViewById(R.id.NELATsnd);
        mNELNGsnd = findViewById(R.id.NELNGsnd);
        mSWLATsnd = findViewById(R.id.SWLATsnd);
        mSWLNGsnd = findViewById(R.id.SWLNGsnd);
        mSELATsnd = findViewById(R.id.SELATsnd);
        mSELNGsnd = findViewById(R.id.SELNGsnd);
        mproceedtoMap = findViewById(R.id.proceedtoMap);
        final int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        checkForSmsPermission();
        mspeedLimitsnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String speedLimit = "SPDD" + mspeedLimit.getText().toString().trim();
                    if (!mspeedLimit.getText().toString().equals("")) {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(phoneNumbertest, null, speedLimit, null, null);
                    }

            }
        });
        mNWLATsnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NWLAT = "NWLA"+ mNWLAT.getText().toString().trim();
                mNWLATT = mNWLAT.getText().toString().trim();
                if (!mNWLAT.getText().toString().equals("")) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumbertest, null, NWLAT, null, null);
                }
            }
        });
        mNWLNGsnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NWLNG = "NWLN" + mNWLNG.getText().toString().trim();
                mNWLNGG = mNWLNG.getText().toString().trim();
                if (!mNWLNG.getText().toString().equals("")) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumbertest, null, NWLNG, null, null);
                }
            }
        });
        mNELATsnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NELAT = "NELA"+ mNELAT.getText().toString().trim();
                mNELATT = mNELAT.getText().toString().trim();
                if (!mNELAT.getText().toString().equals("")) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumbertest, null, NELAT, null, null);
                }
            }
        });
        mNELNGsnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NELNG = "NELN"+ mNELNG.getText().toString().trim();
                mNELNGG = mNELNG.getText().toString().trim();
                if (!mNELNG.getText().toString().equals("")) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumbertest, null, NELNG, null, null);
                }
            }
        });
        mSWLATsnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String SWLAT = "SWLA"+ mSWLAT.getText().toString().trim();
                mSWLATT = mSWLAT.getText().toString().trim();
                if (!mSWLAT.getText().toString().equals("")) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumbertest, null, SWLAT, null, null);
                }
            }
        });
        mSWLNGsnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String SWLNG = "SWLN"+mSWLNG.getText().toString().trim();
                mSWLNGG = mSWLNG.getText().toString().trim();
                if (!mSWLNG.getText().toString().equals("")) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumbertest, null, SWLNG, null, null);
                }
            }
        });
        mSELATsnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String SELAT = "SELA"+mSELAT.getText().toString().trim();
                mSELATT = mSELAT.getText().toString().trim();
                if (!mSELAT.getText().toString().equals("")) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumbertest, null, SELAT, null, null);
                }
            }
        });
        mSELNGsnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String SELNG = "SELN"+mSELNG.getText().toString().trim();
                mSELNGG = mSELNG.getText().toString().trim();
                if (!mSELNG.getText().toString().equals("")) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumbertest, null, SELNG, null, null);
                }
            }
        });

        mproceedtoMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ViewMap.class));
            }
        });
    }
    public void checkForSmsPermission() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS) !=
                PackageManager.PERMISSION_GRANTED) {
            //Log.d(TAG, getString(R.string.permission_not_granted));
            // Permission not yet granted. Use requestPermissions().
            // MY_PERMISSIONS_REQUEST_SEND_SMS is an
            // app-defined int constant. The callback method gets the
            // result of the request.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    MY_PERMISSIONS_REQUEST_SEND_SMS);
        }

    }
    public static String getmNWLATT(){
        return mNWLATT;
    }
    public static String getmNWLNGG(){
        return mNWLNGG;
    }
    public static String getmNELATT(){
        return mNELATT;
    }
    public static String getmNELNGG(){
        return mNELNGG;
    }
    public static String getmSWLATT(){
        return mSWLATT;
    }
    public static String getmSWLNGG(){
        return mSWLNGG;
    }
    public static String getmSELATT(){
        return mSELATT;
    }
    public static String getmSELNGG(){
        return mSELNGG;
    }
}
