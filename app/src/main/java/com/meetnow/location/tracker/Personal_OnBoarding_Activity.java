package com.meetnow.location.tracker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Personal_OnBoarding_Activity extends AppCompatActivity {

    ImageView Personalimage;
    TextView pnextTV, ptermsconditionTV;
    View pview1, pview2, pview3;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_on_boarding_activity);

        PersonalinitViews();

        Spannable spannable = new SpannableString("Terms & Condition");
//        spannable.setSpan(new ForegroundColorSpan(Color.BLUE), 15, 30, );
        ptermsconditionTV.setText(spannable);

        ptermsconditionTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Personal_OnBoarding_Activity.this, Personal_Policy_Activity.class));
            }
        });

        pnextTV.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                if (i == 0) {
                    i++;
                    pview1.setBackgroundColor(Color.parseColor("#979A9A"));
                    pview2.setBackgroundColor(Color.parseColor("#1583F7"));
                    Personalimage.setImageResource(R.drawable.ic_2);
                } else if (i == 1) {
                    i++;
                    pview1.setBackgroundColor(Color.parseColor("#979A9A"));
                    pview2.setBackgroundColor(Color.parseColor("#979A9A"));
                    pview3.setBackgroundColor(Color.parseColor("#1583F7"));
                    Personalimage.setImageResource(R.drawable.ic_3);
                    pnextTV.setText("Finish");
                } else {
                    PersonalSharedPreferencesManager.LocatorsetKeyIsDisplayOnboarding(false);
                    finish();
                }
            }
        });
    }

    private void PersonalinitViews() {

        Personalimage = (ImageView) findViewById(R.id.image);
        pnextTV = (TextView) findViewById(R.id.nextTV);
        ptermsconditionTV = (TextView) findViewById(R.id.termsconditionTV);
        pview1 = (View) findViewById(R.id.view1);
        pview2 = (View) findViewById(R.id.view2);
        pview3 = (View) findViewById(R.id.view3);
    }
}