package com.tni.pratch.howfastareyou;

import android.os.AsyncTask;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;

public class startCountingTask extends AsyncTask<Void, Integer, Void> {

    // Weak ref
    private WeakReference<ProgressBar> pb;

    // Update every 100 ms
    private static final int CHUNK_SIZE = 100;

    public startCountingTask(ProgressBar pb) {
        this.pb = new WeakReference<>(pb);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        // count value
        int countDown = 1000;

        int chunkSize = countDown / CHUNK_SIZE;
        for (int i = 0; i < chunkSize; ++i){
            try {
                Thread.sleep(CHUNK_SIZE);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            publishProgress(((i + 1) * 100) / chunkSize);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        pb.get().setProgress(values[0]);
    }
}
