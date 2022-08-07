package com.example.morsecodeapp;

import android.app.Activity;
import android.util.Log;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class lifecycleloggingactivity extends AppCompatActivity
{
    protected final String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null)
        {
            Log.d(TAG,"onCreate() - activity recreated");
        }
        else
        {
            Log.d(TAG,"onCreate() - activity created new");
        }
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(TAG,"onResume() - activity resumed");
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d(TAG,"onStart() - activity started");
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d(TAG,"onPause() - activity paused");
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d(TAG,"onStop() - activity stopped");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG,"onDestroy() - activity destroyed");
    }
}
