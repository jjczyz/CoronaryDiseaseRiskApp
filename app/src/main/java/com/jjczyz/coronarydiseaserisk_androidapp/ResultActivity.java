package com.jjczyz.coronarydiseaserisk_androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
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
        TextView description = (TextView) findViewById(R.id.result_description_textview);
    }

}
