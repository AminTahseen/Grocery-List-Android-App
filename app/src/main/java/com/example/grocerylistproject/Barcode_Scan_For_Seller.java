package com.example.grocerylistproject;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Barcode_Scan_For_Seller extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;

    public static final int PERMISSION_REQUEST_CAMERA = 1;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mScannerView = new ZXingScannerView(this); // Programmatically initialize the scanner view
        setContentView(mScannerView); // Set the scanner view as the content view

        // Request permission. This does it asynchronously so we have to wait for onRequestPermissionResult before trying to open the camera.
        if (!haveCameraPermission())
            requestPermissions(new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
    }
    private boolean haveCameraPermission()
    {
        if (Build.VERSION.SDK_INT < 23)
            return true;
        return checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults)
    {
        // This is because the dialog was cancelled when we recreated the activity.
        if (permissions.length == 0 || grantResults.length == 0)
            return;

        switch (requestCode)
        {
            case PERMISSION_REQUEST_CAMERA:
            {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    startCamera();
                }
                else
                {
                    finish();
                }
            }
            break;
        }
    }

    public void startCamera()
    {
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    public void stopCamera()
    {
        mScannerView.stopCamera();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        startCamera();
    }

    @Override
    public void onPause()
    {
        super.onPause();
        stopCamera();
    }

    @Override
    public void handleResult(Result result)
    {
        String code=result.getText();
        mScannerView.resumeCameraPreview(this);
        Intent Scanned=new Intent(getApplicationContext(),Scanned_Product.class);
        Scanned.putExtra("Code",code);
        Intent intent=getIntent();
        String uid=intent.getStringExtra("user_ID");
        Scanned.putExtra("user_ID",uid);
        startActivity(Scanned);
    }
}
