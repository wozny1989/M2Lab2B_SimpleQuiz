package com.example.m3lab2b_simplequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
  int sumPoints;
  TextView scoreText;
  ProgressBar progressBar;
  Button submitButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_result);

    final Intent intent = new Intent(this, MainActivity.class);
    submitButton = (Button) findViewById(R.id.submitButton);

    Bundle extras = getIntent().getExtras();

    if (extras != null) {
      sumPoints = extras.getInt("sumPoints");
    }

    scoreText = (TextView) findViewById((R.id.scoreText));
    progressBar = (ProgressBar) findViewById((R.id.progressBar));

    scoreText.setText(sumPoints + "/8");
    progressBar.setProgress(sumPoints);

    submitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(intent);
      }
    });
  }
}
