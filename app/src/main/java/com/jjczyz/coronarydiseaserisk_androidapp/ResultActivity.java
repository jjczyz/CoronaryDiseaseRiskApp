package com.jjczyz.coronarydiseaserisk_androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent i = getIntent();
        ResultInSCORE score = (ResultInSCORE) i.getSerializableExtra("SCORE");

        TextView result = (TextView) findViewById(R.id.risk_textview);
        result.setText(score.getResult()+"%");
    }

    public void backToMain(View view) {

        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

    public void showInfo(View view) {

        Intent i = new Intent(this, InfoActivity.class);
        int textToShow = 0;
        switch(view.getId()) {
            case R.id.cardio_risk_info_button:
                textToShow = 0;
                break;
            case R.id.diet_info_button:
                textToShow = 1;
                break;
            case R.id.weight_info_button:
                textToShow = 2;
                break;
        }
        i.putExtra("shownText",textToShow);
        startActivity(i);

    }
}
