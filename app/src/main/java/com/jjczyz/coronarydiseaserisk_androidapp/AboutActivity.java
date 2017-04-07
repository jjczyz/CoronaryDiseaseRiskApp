package com.jjczyz.coronarydiseaserisk_androidapp;

import android.os.Bundle;
import android.app.Activity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView t = (TextView) findViewById(R.id.aboutTextView);
        t.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
