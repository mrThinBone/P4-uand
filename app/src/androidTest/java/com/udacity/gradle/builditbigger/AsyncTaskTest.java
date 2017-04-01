package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import vinhtv.android.builditbigger.backend.myApi.MyApi;

import static org.junit.Assert.*;

/**
 * Created by DELL-INSPIRON on 4/1/2017.
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    @Test
    public void testResult() {
        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                        request.setDisableGZipContent(true);
                    }
                });
        MyApi mApiService = builder.build();

        String response = null;
        try {
            response = mApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertFalse(TextUtils.isEmpty(response));
    }
}
