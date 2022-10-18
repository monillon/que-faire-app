package up.android.quefaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.HashMap;

public class questions_page2 extends AppCompatActivity {

    private HashMap<String, String> savedData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_page2);

        // récupération des valeurs de l'activité précédente et stockage dans une HashMap
        savedData = new HashMap<>();
        if (getIntent().getExtras().containsKey("sortirCeSoir")) {
            savedData.put("sortirCeSoir", String.valueOf(getIntent().getBooleanExtra("sortirCeSoir", false)));
        }

        if (getIntent().getExtras().containsKey("nbPersonne")) {
            savedData.put("nbPersonne", String.valueOf(getIntent().getBooleanExtra("nbPersonne", false)));
        }

        if (getIntent().getExtras().containsKey("aimerNature")) {
            savedData.put("aimerNature", String.valueOf(getIntent().getBooleanExtra("aimerNature", false)));
        }

    }

    public void next(View v){
        Intent intent = new Intent(this, questions_page3.class);
        startActivity(intent);
    }

    public void back(View v){
        finish();
    }
}