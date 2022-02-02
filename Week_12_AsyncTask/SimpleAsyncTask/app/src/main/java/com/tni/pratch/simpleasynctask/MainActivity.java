package com.tni.pratch.simpleasynctask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * The SimpleAsyncTask app contains a button that launches an AsyncTask
 * which sleeps in the asynchronous thread for a random amount of time.
 */
public class MainActivity extends AppCompatActivity {
    // Key for saving the state of the TextView
    private static final String TEXT_STATE = "currentText";
    // The TextView where we will show results
    private TextView mTextView;
    // The progress bar there we will show the progress status
    private ProgressBar mProgressBar;

    // Initializes the activity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize mTextView
        mTextView = findViewById(R.id.textView1);
        // Initialize mProgressBar
        mProgressBar = findViewById(R.id.progressBar);

        // Restore TextView if there is a savedInstanceState
        if (savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    // Handles the onCLick for the "Start Task" button. Launches the
    // AsyncTask which performs work off of the UI thread.
    public void startTask(View view) {
        // Put a message in the text view
        mTextView.setText(R.string.napping);
        // Start the AsyncTask.
        new SimpleAsyncTask(mTextView, mProgressBar).execute();
    }

    // Saves the contents of the TextView to restore on configuration
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the state of the TextView
        outState.putString(TEXT_STATE, mTextView.getText().toString());
    }
}