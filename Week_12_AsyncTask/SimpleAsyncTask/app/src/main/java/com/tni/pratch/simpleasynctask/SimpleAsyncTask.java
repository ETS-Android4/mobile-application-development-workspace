package com.tni.pratch.simpleasynctask;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Integer, String> {
    private WeakReference<TextView> mTextView;
    private WeakReference<ProgressBar> mProgressBar;
    private static final int CHUNK_SIZE = 10;

    SimpleAsyncTask(TextView tv, ProgressBar pb) {
        mTextView = new WeakReference<>(tv);
        mProgressBar = new WeakReference<>(pb);
    }

    @Override
    protected String doInBackground(Void... voids) {
        // Generate a random number between 0 and 10
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running
        int s = n * 200;

        int chunkSize = s / CHUNK_SIZE;
        for (int i = 0; i < CHUNK_SIZE; ++i){
            try {
                Thread.sleep(chunkSize);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            publishProgress(s, ((i + 1) * 100) / CHUNK_SIZE);
        }

        // Return a String result
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        String remain = "Remaining... " + values[0] + " milliseconds";
        mTextView.get().setText(remain);
        mProgressBar.get().setProgress(values[1]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mTextView.get().setText(s);
    }
}
