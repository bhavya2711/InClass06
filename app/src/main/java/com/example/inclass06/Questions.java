package com.example.inclass06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Questions extends AppCompatActivity {
    int questionId=0;
    double score=0.0;
    TextView questionTextView,low,high;
    Button next;
    RadioGroup group;;
    Response[] ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

         ans=new Response[]{
                new Response(R.string.Question1,0),
                new Response(R.string.Question2,0),
                new Response(R.string.Question3,0),
                new Response(R.string.Question4,0),
                new Response(R.string.Question5,0),
                new Response(R.string.Question6,0),
                new Response(R.string.Question7,0),

        };



        questionTextView=findViewById(R.id.question);
        low=findViewById(R.id.low);
        high=findViewById(R.id.high);
        next=findViewById(R.id.next);
        group=findViewById(R.id.radioGroup);
        //submit=findViewById(R.id.submit);
        setUI();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedRadioButtonID = group.getCheckedRadioButtonId();

                // If nothing is selected from Radio Group, then it return -1
                if (selectedRadioButtonID != -1) {

                    RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
                    String selectedRadioButtonText = selectedRadioButton.getText().toString();
                     questionId++;
                     score+=Double.parseDouble(selectedRadioButtonText)+1;
                     if(questionId<=6)
                     setUI();
                     else
                     {
                         Toast.makeText(getApplicationContext(),"Total Score"+score,Toast.LENGTH_SHORT).show();
                     }
                }
                else{
                    Toast.makeText(getApplicationContext(),"No option selected",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void setUI()
    {

        group.clearCheck();

            //next.setEnabled(false);
            int Question=ans[questionId].getQuestionId();
            questionTextView.setText(Question);

    }
}
