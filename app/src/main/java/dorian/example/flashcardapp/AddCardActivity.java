package dorian.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
              Intent intent= new Intent();
              intent.putExtra("question", grab_question);
              intent.putExtra("answer",grab_answer);
              setResult(RESULT_OK, intent);
              finish();
            }
        });
    }
}
