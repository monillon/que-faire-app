package up.android.quefaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class questions_page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_page2);
    }

    public void next(View v){
        Intent intent = new Intent(this, questions_page3.class);
        startActivity(intent);
    }

    public void back(View v){
        finish();
    }
}