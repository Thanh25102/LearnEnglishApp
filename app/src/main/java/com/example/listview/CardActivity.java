package com.example.listview;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;

public class CardActivity extends AppCompatActivity {

    private AnimatorSet frontAnimatorSet;
    private AnimatorSet backAnimatorSet;
    private boolean isFront = true;

    private Button btnCountinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        Float scale = getApplicationContext().getResources().getDisplayMetrics().density;
        CardView cardFront = findViewById(R.id.cardFront);
        CardView cardBack = findViewById(R.id.cardBack);
        cardFront.setCameraDistance(8000*scale);
        cardBack.setCameraDistance(8000*scale);

        // set front and back animation
        frontAnimatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),R.animator.front_animator);
        backAnimatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),R.animator.back_animator);

        btnCountinue = findViewById(R.id.btnCountinue);
        btnCountinue.setOnClickListener(v->{
            if(isFront){
                frontAnimatorSet.setTarget(cardFront);
                backAnimatorSet.setTarget(cardBack);
                frontAnimatorSet.start();
                backAnimatorSet.start();
                isFront = false;
            }else{
                frontAnimatorSet.setTarget(cardBack);
                backAnimatorSet.setTarget(cardFront);
                backAnimatorSet.start();
                frontAnimatorSet.start();
                isFront = true;
            }
        });
    }
}