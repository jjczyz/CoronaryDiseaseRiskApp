package com.jjczyz.coronarydiseaserisk_androidapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgWuwuzela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void startQuestions(View view)
    {
        ResultInSCORE score = new ResultInSCORE();
        score.createQuestions(this);
        Intent i = new Intent(this, QuestionActivity.class);
        i.putExtra("SCORE", score);
        startActivity(i);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // ignore orientation/keyboard change
        super.onConfigurationChanged(newConfig);
    }

    public void showAbout(View view) {
        Intent i = new Intent(this, AboutActivity.class);
        startActivity(i);
    }
}
