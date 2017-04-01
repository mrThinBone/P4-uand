package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import vinhtv.android.app.androidlib.ShowJokeActivity;
import vinhtv.android.builditbigger.backend.myApi.MyApi;


public class MainActivity extends AppCompatActivity implements FetchJokeStoryTask.OnTaskDoneListener {

    MainActivityFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragment = (MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        mFragment.showLoadingProgress();
        new FetchJokeStoryTask(this).execute();
    }

    public void doNothing(View view) {}

    @Override
    public void onDone(String data) {
        mFragment.dismissLoadingProgress();
        if(!TextUtils.isEmpty(data)) {
            Intent showStory = new Intent(MainActivity.this, ShowJokeActivity.class);
            Bundle extras = new Bundle();
            extras.putString(Intent.EXTRA_TEXT, data);
            showStory.putExtras(extras);
            startActivity(showStory);
        }
    }
}
