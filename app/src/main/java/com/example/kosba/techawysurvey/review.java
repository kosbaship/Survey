package com.example.kosba.techawysurvey;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class review extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);
        final TextView showText = findViewById(R.id.mainText);
        final Button sendEmail = findViewById(R.id.send_btn);
        final Button previouseButton = findViewById(R.id.previouse);

        Typeface changeFont = Typeface.createFromAsset(getAssets(), "Tajawal-ExtraLight.ttf");
        showText.setTypeface(changeFont);
        showText.setTextSize(32);
        previouseButton.setTypeface(changeFont);
        sendEmail.setTypeface(changeFont);



        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_SENDTO);

                Intent lastPageMessage = getIntent();
                String message = lastPageMessage.getStringExtra("massageToSend");

                i.setData(Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_CC, "mohamed.kosba96@gmail.com");
                i.putExtra(Intent.EXTRA_SUBJECT, "Techawy FeedBack.");
                i.putExtra(Intent.EXTRA_TEXT,  message);
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivity(i);
                }

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