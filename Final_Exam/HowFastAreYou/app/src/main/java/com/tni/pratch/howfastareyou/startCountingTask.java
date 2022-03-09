package com.tni.pratch.howfastareyou;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;

public class startCountingTask extends AsyncTask<Void, Integer, Void> {

    // Weak ref
    private WeakReference<ProgressBar> pb;
    private WeakReference<Button> start_btn;
    private WeakReference<Button> click_me_btn;

    // Update every 100 ms
    private static final int CHUNK_SIZE = 100;

    public startCountingTask(ProgressBar pb, Button start_btn, Button click_me_btn) {
        this.pb = new WeakReference<>(pb);
        this.start_btn = new WeakReference<>(start_btn);
        this.click_me_btn = new WeakReference<>(click_me_btn);
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

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        start_btn.get().setVisibility(View.VISIBLE);
        click_me_btn.get().setVisibility(View.GONE);
    }
}
