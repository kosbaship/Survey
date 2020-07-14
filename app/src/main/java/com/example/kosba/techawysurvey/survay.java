package com.example.kosba.techawysurvey;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class survay extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survay);

        final TextView firstText = findViewById(R.id.firstText );
        final TextView secondText = findViewById(R.id.secondText);
        final TextView thirdText = findViewById(R.id.thirdText);

        final Button nextButton = findViewById(R.id.next_one);
        final Button previouseButton = findViewById(R.id.previouse);

        final EditText teachEvaluate = findViewById(R.id.evluat_teach_btn);
        final EditText organizeEvaluate  = findViewById(R.id.evluat_organize_btn);
        final EditText comment = findViewById(R.id.comment_btn);

        Typeface changeMainFont = Typeface.createFromAsset(getAssets(), "Tajawal-ExtraLight.ttf");
        Typeface changeFont = Typeface.createFromAsset(getAssets(), "Tajawal-Light.ttf");


        firstText.setTypeface(changeMainFont);
        secondText.setTypeface(changeMainFont);
        thirdText.setTypeface(changeMainFont);
        firstText.setTextSize(32);
        secondText.setTextSize(32);
        thirdText.setTextSize(32);

        teachEvaluate.setTypeface(changeFont );
        organizeEvaluate.setTypeface(changeFont );
        comment.setTypeface(changeFont );

        nextButton.setTypeface(changeMainFont);
        previouseButton.setTypeface(changeMainFont);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), review.class);

                Intent lastPageMessage = getIntent();

                String message = lastPageMessage.getStringExtra("massageToSend");
                message+=" \n\n His Evaluation about the Instructor: \n  " + teachEvaluate.getText().toString() + ".";
                message+=" \n\n His Evaluation about the Orgenizers: \n  " +  organizeEvaluate.getText().toString() + ".";
                message+=" \n\n His Extra Comment: \n  " +  comment.getText().toString() + ".";

                i.putExtra("massageToSend", message);
                startActivity(i);
            }
        });

        previouseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
