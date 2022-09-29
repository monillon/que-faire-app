package up.android.quefaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    public void restart(View v){
        Intent intent = new Intent(this, QuestionsPage1.class);
        startActivity(intent);
    }

    public void back(View v){finish();}
}