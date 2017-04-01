package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.lang.ref.WeakReference;

import vinhtv.android.builditbigger.backend.myApi.MyApi;

/**
 * Created by DELL-INSPIRON on 4/1/2017.
 */

public class FetchJokeStoryTask extends AsyncTask<Void, Void, String> {

    private static MyApi mApiService;
    private WeakReference<OnTaskDoneListener> mListener;

    public FetchJokeStoryTask(OnTaskDoneListener listener) {
        mListener = new WeakReference<>(listener);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(mApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            mApiService = builder.build();
        }
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            return mApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    protected void onPostExecute(String data) {
        super.onPostExecute(data);
        OnTaskDoneListener listener = mListener.get();
        if(listener!=null) listener.onDone(data);
    }

    interface OnTaskDoneListener {
        void onDone(String data);
    }
}
