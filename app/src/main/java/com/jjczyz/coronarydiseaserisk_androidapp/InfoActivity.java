package com.jjczyz.coronarydiseaserisk_androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class InfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent i = getIntent();
        int shownText = i.getIntExtra("shownText", 0);
        TextView view = (TextView) findViewById(R.id.infoTextView);
        switch(shownText){
            case 0:         //cardiovascular info
                view.setText(getResources().getString(R.string.cardiovascular_info));
                break;
            case 1:         //diet info
                view.setText(getResources().getString(R.string.diet_info));
                break;
            case 2:         //weight info
                view.setText(getResources().getString(R.string.weight_info));
                break;
        }

    }

}
