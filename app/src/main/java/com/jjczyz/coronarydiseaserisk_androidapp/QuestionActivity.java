package com.jjczyz.coronarydiseaserisk_androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import javax.xml.transform.Result;
import java.io.Serializable;

public class QuestionActivity extends Activity{

    Question currentQuestion;
    ResultInSCORE score;
    int questionNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent i = getIntent();
        score = (ResultInSCORE) i.getSerializableExtra("SCORE");
        questionNum = i.getIntExtra("questionNum", 0);

        currentQuestion = score.getQuestion(questionNum);
        TextView view = (TextView) findViewById(R.id.question_text);
        view.setText(currentQuestion.getQuestionText());
        addRadioButtons(currentQuestion.getAnswers());

    }

    public void addRadioButtons(String[] text)
    {
            RadioGroup ll = (RadioGroup)findViewById(R.id.answer_buttons);

            for (int i = 0; i < text.length; i++)
            {
                RadioButton radioBtn = new RadioButton(this);
                radioBtn.setId(i);
                radioBtn.setText(text[i]);
                ll.addView(radioBtn);
            }
    }

    public void nextQuestion(View view) {
        RadioGroup ll = (RadioGroup) findViewById(R.id.answer_buttons);
        int checkedRadioButtonId = ll.getCheckedRadioButtonId();
        if (checkedRadioButtonId == -1)
        {
            // No item selected
        }
        else
        {
            for(int j=0; j<currentQuestion.getAnswers().length; j++)
            {
                if(checkedRadioButtonId == j)
                {
                    currentQuestion.setSelectedAnswerNum(j);

                    if(questionNum+1 != score.getQuestionsSize() )
                    {
                        Intent i = new Intent(this, QuestionActivity.class);
                        i.putExtra("SCORE", score);
                        i.putExtra("questionNum", questionNum+1);
                        startActivity(i);
                    }
                    else
                    {
                        Intent i = new Intent(this, ResultActivity.class);
                        i.putExtra("SCORE", score);
                        startActivity(i);
                    }

                }
            }
        }
    }
}
