package dorian.example.flashcardapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.answer).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
                // Do something here
            }
        });
        findViewById(R.id.imageButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                startActivityForResult(intent, 100);
            }
        });
        findViewById(R.id.eye_toggle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.answer_choice1).setVisibility(View.VISIBLE);
                findViewById(R.id.answer_choice2).setVisibility(View.VISIBLE);
                findViewById(R.id.answer_choice3).setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.answer_choice1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.answer_choice1).setBackgroundColor(getResources().getColor(R.color.my_red_color));
                findViewById(R.id.answer_choice3).setBackgroundColor(getResources().getColor(R.color.my_green_color));
            }
        });
        findViewById(R.id.answer_choice2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.answer_choice2).setBackgroundColor(getResources().getColor(R.color.my_red_color));
                findViewById(R.id.answer_choice3).setBackgroundColor(getResources().getColor(R.color.my_green_color));
            }
        });
        findViewById(R.id.answer_choice3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.answer_choice3).setBackgroundColor(getResources().getColor(R.color.my_green_color));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode==RESULT_OK){ // this 100 needs to match the 100 we used when we called startActivityForResult!
            String new_question = data.getExtras().getString("question"); // 'string1' needs to match the key we used when we put the string in the Intent
            String new_answer = data.getExtras().getString("answer");
            ((TextView)findViewById(R.id.flashcard_question)).setText(new_question);
            ((TextView)findViewById(R.id.answer)).setText(new_answer);
        }
    }
}
