package up.android.quefaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class questions_page5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_page5);
    }

    public void next(View v){
        Intent intent = new Intent(this, QuestionsPage1.class);
        startActivity(intent);
    }

    public void back(View v){
        finish();
    }
}