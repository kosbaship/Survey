package com.example.kosba.techawysurvey;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView mainText = findViewById(R.id.mainText);
        final TextView nameText = findViewById(R.id.nameText);
        final TextView careerText = findViewById(R.id.careerText);
        final TextView collageText = findViewById(R.id.collageText);
        final TextView ageText = findViewById(R.id.ageText);
        final TextView phoneText = findViewById(R.id.phoneText);

        final Button nextButton = findViewById(R.id.next_one);

        final EditText userName = findViewById(R.id.usr_name);
        final EditText userField = findViewById(R.id.usr_field);
        final EditText userCollage = findViewById(R.id.usr_collage);
        final EditText userPhone = findViewById(R.id.usr_phone);
        final EditText userAge = findViewById(R.id.usr_age);

        Typeface changeMainFont = Typeface.createFromAsset(getAssets(), "Tajawal-ExtraLight.ttf");
        Typeface changeFont = Typeface.createFromAsset(getAssets(), "Tajawal-Light.ttf");
        Typeface changeEnglishFont = Typeface.createFromAsset(getAssets(), "MarckScript-Regular.ttf");

        mainText.setTypeface(changeMainFont);
        mainText.setTextSize(32);

        nextButton.setTypeface(changeFont);
        careerText.setTypeface(changeFont);
        collageText.setTypeface(changeFont);
        ageText.setTypeface(changeFont);
        phoneText.setTypeface(changeFont);
        nameText.setTypeface(changeFont);

        userName.setTypeface(changeEnglishFont );
        userField.setTypeface(changeEnglishFont );
        userAge.setTypeface(changeEnglishFont );
        userCollage.setTypeface(changeEnglishFont );
        userPhone.setTypeface(changeEnglishFont );


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), survay.class);

                String message = "Delegate Name Is:  " + userName.getText().toString() + ".";
                message+= "\nDelegate attend at:  " + userField.getText().toString() + ".";
                message+= "\nHis Faculty Is: " + userCollage.getText().toString() + ".";
                message+= "\nHe Is: " + userAge.getText().toString() + " years Old.";
                message+= "\nPhone Number: " + userPhone.getText().toString() + ".";

                i.putExtra("massageToSend", message);
                startActivity(i);
            }
        });
    }
}
