package com.tni.pratch.howfastareyou;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;
import java.util.Random;

public class startCountingTask extends AsyncTask<Void, Integer, Void> {

    private static final int NOT_GENERATE = 99;
    // Weak ref
    private WeakReference<ProgressBar> pb;
    private WeakReference<Button> start_btn;
    private WeakReference<ImageView> im1, im2, im3, im4, im5;

    // Update every 100 ms
    private static final int CHUNK_SIZE = 100;
    // random generate img for 300 ms
    private static final int generateTime = 300;

    public startCountingTask(ProgressBar pb, Button start_btn,
                             ImageView im1, ImageView im2, ImageView im3, ImageView im4, ImageView im5) {
        this.pb = new WeakReference<>(pb);
        this.start_btn = new WeakReference<>(start_btn);
        this.im1 = new WeakReference<>(im1);
        this.im2 = new WeakReference<>(im2);
        this.im3 = new WeakReference<>(im3);
        this.im4 = new WeakReference<>(im4);
        this.im5 = new WeakReference<>(im5);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        // count value
        int countDown = 5000;

        Random r = new Random();

        int chunkSize = countDown / CHUNK_SIZE;
        for (int i = 0; i < chunkSize; ++i){
            try {
                Thread.sleep(CHUNK_SIZE);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            if (i % (generateTime / CHUNK_SIZE) == 0)
                publishProgress(((i + 1) * 100) / chunkSize, r.nextInt(5) + 1);
            else
                publishProgress(((i + 1) * 100) / chunkSize, NOT_GENERATE);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        pb.get().setProgress(values[0]);
        switch (values[1]) {
            case 1:
                im1.get().setVisibility(View.VISIBLE);
                break;
            case 2:
                im2.get().setVisibility(View.VISIBLE);
                break;
            case 3:
                im3.get().setVisibility(View.VISIBLE);
                break;
            case 4:
                im4.get().setVisibility(View.VISIBLE);
                break;
            case 5:
                im5.get().setVisibility(View.VISIBLE);
                break;
            case NOT_GENERATE:
                break;
        }
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        start_btn.get().setVisibility(View.VISIBLE);
        im1.get().setVisibility(View.INVISIBLE);
        im2.get().setVisibility(View.INVISIBLE);
        im3.get().setVisibility(View.INVISIBLE);
        im4.get().setVisibility(View.INVISIBLE);
        im5.get().setVisibility(View.INVISIBLE);
    }
}
