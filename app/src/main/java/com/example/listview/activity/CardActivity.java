package com.example.listview.activity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import com.example.listview.R;
import com.example.listview.dto.Topic;

public class CardActivity extends AppCompatActivity {

    private AnimatorSet frontAnimatorSet;
    private AnimatorSet backAnimatorSet;
    private boolean isFront = true;
    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        Topic topic = (Topic)getIntent().getSerializableExtra("TOPIC_KEY");
        TextView textViewBack = findViewById(R.id.textViewBack);
        textViewBack.setText(topic.getDescription());

        Float scale = getApplicationContext().getResources().getDisplayMetrics().density;
        CardView cardFront = findViewById(R.id.cardFront);
        CardView cardBack = findViewById(R.id.cardBack);
        cardFront.setCameraDistance(8000*scale);
        cardBack.setCameraDistance(8000*scale);

        // set front and back animation
        frontAnimatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),R.animator.front_animator);
        backAnimatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),R.animator.back_animator);

        btnContinue = findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(v->{
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