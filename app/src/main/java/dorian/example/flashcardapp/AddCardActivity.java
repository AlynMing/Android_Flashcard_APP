package dorian.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        findViewById(R.id.imageButton_Cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.imageButton_Save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String grab_question= ((EditText)findViewById(R.id.editText_Question)).getText().toString();
              String grab_answer= ((EditText)findViewById(R.id.editText_Answer)).getText().toString();
              String grab_answer_choice1= ((EditText)findViewById(R.id.editText_Answer_choice1)).getText().toString();
              String grab_answer_choice2= ((EditText)findViewById(R.id.editText_Answer_choice2)).getText().toString();
              String grab_answer_choice3= ((EditText)findViewById(R.id.editText_Answer_choice3)).getText().toString();
              Intent intent= new Intent();
              intent.putExtra("question", grab_question);
              intent.putExtra("answer",grab_answer);
              intent.putExtra("answer choice 1",grab_answer_choice1);
              intent.putExtra("answer choice 2",grab_answer_choice2);
              intent.putExtra("answer choice 3",grab_answer_choice3);
              setResult(RESULT_OK, intent);
              Toast.makeText(getApplicationContext(),"Card has been created",Toast.LENGTH_SHORT).show();
              finish();
            }
        });
    }
}
