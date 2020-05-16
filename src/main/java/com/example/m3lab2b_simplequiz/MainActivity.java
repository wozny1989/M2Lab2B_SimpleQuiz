package com.example.m3lab2b_simplequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

  CheckBox q1a1;
  CheckBox q1a2;
  CheckBox q1a3;

  CheckBox q2a1;
  CheckBox q2a2;
  CheckBox q2a3;

  RadioButton q3a1;
  RadioButton q3a2;
  RadioButton q3a3;

  RadioButton q4a1;
  RadioButton q4a2;
  RadioButton q4a3;

  ToggleButton q5;

  Switch q6;

  Button submitButton;

  TextView scoreText;
  ProgressBar progressBar;

  int sumPoints;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    q1a1 = (CheckBox) findViewById(R.id.q1a1); // Good answer
    q1a2 = (CheckBox) findViewById(R.id.q1a2); // Good answer
    q1a3 = (CheckBox) findViewById(R.id.q1a3);

    q2a1 = (CheckBox) findViewById(R.id.q2a1); // Good answer
    q2a2 = (CheckBox) findViewById(R.id.q2a2);
    q2a3 = (CheckBox) findViewById(R.id.q2a3); // Good answer

    q3a1 = (RadioButton) findViewById(R.id.q3a1);
    q3a2 = (RadioButton) findViewById(R.id.q3a2); // Good answer
    q3a3 = (RadioButton) findViewById(R.id.q3a3);

    q4a1 = (RadioButton) findViewById(R.id.q4a1);
    q4a2 = (RadioButton) findViewById(R.id.q4a2);
    q4a3 = (RadioButton) findViewById(R.id.q4a3); // Good answer

    q5 = (ToggleButton) findViewById(R.id.toggleButton);

    q6 = (Switch) findViewById(R.id.switch1);

    submitButton = (Button) findViewById(R.id.submitButton);

    scoreText = (TextView) findViewById((R.id.scoreText));
    progressBar = (ProgressBar) findViewById((R.id.progressBar));

    submitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        final String checkAnswerText = getResources().getString(R.string.checkAnswer);
        final String clearQuizText = getResources().getString(R.string.clearQuiz);
//        submitButton.setText(submitButton.getText().equals(checkAnswer) ? clearQuiz : checkAnswer);
        if (submitButton.getText().equals(checkAnswerText)) {
          submitButton.setText(clearQuizText);
          checkAnswers();
        } else {
          submitButton.setText(checkAnswerText);
          clearQuiz();
        }
      }
    });
  }

  public void checkAnswers() {
    sumPoints = 0;
    if (q1a1.isChecked()) { sumPoints++; }
    if (q1a2.isChecked()) { sumPoints++; }

    if (q2a1.isChecked()) { sumPoints++; }
    if (q2a3.isChecked()) { sumPoints++; }

    if (q3a2.isChecked()) { sumPoints++; }

    if (q4a3.isChecked()) { sumPoints++; }

    if (!q5.isChecked()) { sumPoints++; }

    if (!q6.isChecked()) { sumPoints++; }
    enableElements(false);

    scoreText.setVisibility(View.VISIBLE);
    progressBar.setVisibility(View.VISIBLE);
    scoreText.setText(sumPoints + "/8");
    progressBar.setProgress(sumPoints);
  }

  public void clearQuiz() {
    q1a1.setChecked(false);
    q1a2.setChecked(false);
    q1a3.setChecked(false);

    q2a1.setChecked(false);
    q2a2.setChecked(false);
    q2a3.setChecked(false);

    q3a1.setChecked(false);
    q3a2.setChecked(false);
    q3a3.setChecked(false);

    q4a1.setChecked(false);
    q4a2.setChecked(false);
    q4a3.setChecked(false);

    q5.setChecked(false);

    q6.setChecked(false);

    scoreText.setVisibility(View.GONE);
    progressBar.setVisibility(View.GONE);
    enableElements(true);
  }

  public void enableElements(boolean enabled) {
    q1a1.setEnabled(enabled);
    q1a2.setEnabled(enabled);
    q1a3.setEnabled(enabled);

    q2a1.setEnabled(enabled);
    q2a2.setEnabled(enabled);
    q2a3.setEnabled(enabled);

    q3a1.setEnabled(enabled);
    q3a2.setEnabled(enabled);
    q3a3.setEnabled(enabled);

    q4a1.setEnabled(enabled);
    q4a2.setEnabled(enabled);
    q4a3.setEnabled(enabled);

    q5.setEnabled(enabled);

    q6.setEnabled(enabled);
  }
}
