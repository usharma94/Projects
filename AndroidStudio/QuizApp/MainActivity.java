/*
   Programmer: Upma Sharma
   Date: October 5 2018
   Program: A simple true and false quiz App using an arrayList. Maintains orientation changes
   uses parcelable. Buttons and image view are custom and available in drawable.
*/
package com.example.upmasharma.quiztruefalse;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.upmasharma.quiztruefalse.model.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends Activity {

    //declared view data fields
    private TextView txtQuestion;
    private TextView txtResult;
    private Button btnStartNext;
    private Button btnTrue;
    private Button btnFalse;

    //declared a counter for score and questions to keep track of them
    private int questionCounter = 0;
    private double scoreCounter = 0;

    //created arraylist that is used to access questions from Question class
    private ArrayList<Question> questionArray = new ArrayList<>();

    //declare keys of variables and fields to handle orientation changes
    private static final String QUESTION_INFO = "questionInfo";
    private static final String RESULT_INFO = "resultInfo";
    private static final String NEXT_BUTTON = "buttonName";
    private static final String BTN_TRUE = "truePress";
    private static final String BTN_FALSE = "falsePress";
    private static final String SCORE = "score";
    private static final String QUESTION_COUNTER = "questionCounter";
    private static final String QUESTION_ARRAYLIST = "arrayList";


    /* stores the values of the fields into a bundle for orientation changes
    uses keys to do so */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String questionInfo = txtQuestion.getText().toString();
        String resultInfo = txtResult.getText().toString();
        String buttonName = btnStartNext.getText().toString();

        boolean truePress = btnTrue.isEnabled();
        boolean falsePress = btnFalse.isEnabled();

        outState.putDouble(SCORE, scoreCounter);
        outState.putInt(QUESTION_COUNTER, questionCounter);
        outState.putString(QUESTION_INFO, questionInfo);
        outState.putString(RESULT_INFO, resultInfo);
        outState.putString(NEXT_BUTTON, buttonName);
        outState.putBoolean(BTN_TRUE, truePress);
        outState.putBoolean(BTN_FALSE, falsePress);

        //Parcelable array allows access to the current arraylist
        outState.putParcelableArrayList(QUESTION_ARRAYLIST, questionArray);

    }

    /* restores the values put into onSaveInstance bundle to allow for activity
    to maintain it's state */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String questionInfo = savedInstanceState.getString(QUESTION_INFO);
        String resultInfo = savedInstanceState.getString(RESULT_INFO);
        String buttonInfo = savedInstanceState.getString(NEXT_BUTTON);
        txtQuestion.setText(questionInfo);
        txtResult.setText(resultInfo);
        btnStartNext.setText(buttonInfo);

        boolean truePress = savedInstanceState.getBoolean(BTN_TRUE);
        boolean falsePress = savedInstanceState.getBoolean(BTN_FALSE);

        btnTrue.setEnabled(truePress);
        btnFalse.setEnabled(falsePress);
        scoreCounter = savedInstanceState.getDouble(SCORE);
        questionCounter = savedInstanceState.getInt(QUESTION_COUNTER);
        questionArray = savedInstanceState.getParcelableArrayList(QUESTION_ARRAYLIST);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //access TextViews from UI
        txtQuestion = findViewById(R.id.txt_question);
        txtResult = findViewById(R.id.txt_result);

        //set up buttons
        setupButtons();

        //retrieve questions from Question Class
        questionArray = Question.getQuestions();
        shuffleQuestionsRandom();

        //end of onCreate
    }

    //method retrieves and handles buttons
    private void setupButtons() {

        btnStartNext = findViewById(R.id.btn_next);
        btnTrue = findViewById(R.id.btn_true);
        btnFalse = findViewById(R.id.btn_false);

        //create button handler
        ButtonHandler ButtonHandler = new ButtonHandler();

        //setOnClickListeners are implemented by buttonHandler
        btnTrue.setOnClickListener(ButtonHandler);
        btnFalse.setOnClickListener(ButtonHandler);
        btnStartNext.setOnClickListener(ButtonHandler);

    }

    //class handles button clicks implements OnClickListener
    private class ButtonHandler implements OnClickListener {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn_next:
                    nextQuestion();
                    break;
                case R.id.btn_true:
                    checkAnswer(true);
                    break;
                case R.id.btn_false:
                    checkAnswer(false);
                    break;

            }

        }
    }

    //method that handles next button clicks
    private void nextQuestion() {

        /* conditional checks if question counter exceeds arraylist size, if so
        it prints score and restarts the game */
        if (questionCounter > (questionArray.size() - 1)) {
            percentScore();
            restartGame();
            return;
        }
        //on first click changes button Start text to Next Question
        btnStartNext.setText(R.string.next_question);

        //get index of first question
        txtQuestion.setText(questionArray.get(questionCounter).getQuestion());

        //enables and diables buttons based on answer clicks
        btnStartNext.setEnabled(false);
        buttonEnable(true);

        txtResult.setText(null);

        //increments the counter
        questionCounter++;

    }

    //method shuffles the arraylist at random using Collections shuffle and random method
    private void shuffleQuestionsRandom() {

        Random randIndex = new Random();
        //shuffle arraylist Randomly each time
        Collections.shuffle(questionArray, randIndex);

    }

    //method resets counter and shuffles questions to restart the game
    private void restartGame() {
        scoreCounter = 0;
        questionCounter = 0;
        shuffleQuestionsRandom();

    }
    //method calculates the user score of the quiz and changes next button text

    private void percentScore() {

        //score is calculated based on final scoreCounter and size of array
        double score = ((scoreCounter / questionArray.size()) * 100);

        String scoreString = Double.toString(score);
        String counterString = Integer.toString((int) scoreCounter);

        //get string formatting from String resources
        String displayString = getString(R.string.final_score_text);

        //sets text views to show quiz is finished and final score.
        txtQuestion.setText(R.string.finished_quiz);
        txtResult.setText(String.format(displayString, counterString, questionArray.size(), scoreString));

        //changes next button text to start over
        btnStartNext.setText(R.string.btn_text_start_over);
    }

    //method checks the answer the user selected with answer in Array. Prints if they are correct or incorrect
    private void checkAnswer(boolean userAnswer) {

        //accesses the answer of the question at current index in Question array
        boolean answer = questionArray.get(questionCounter - 1).isAnswer();

        //conditional crosschecks user answer with array
        if (userAnswer == answer) {

            //correct answer text
            txtResult.setText(R.string.correct_answer);
            //increments score counter if correct
            scoreCounter++;
        } else {
            txtResult.setText(R.string.incorrect_answer);
        }

        //disables True and false button, enables next
        buttonEnable(false);
        btnStartNext.setEnabled(true);

        //conditional disables true and false buttons at the end of arraylist
        if (questionCounter >= questionArray.size()) {
            buttonEnable(false);
            btnStartNext.setEnabled(true);

        }

    }

    //method handles enabling the true and false button
    private void buttonEnable(boolean enabler) {
        btnFalse.setEnabled(enabler);
        btnTrue.setEnabled(enabler);
    }

}



