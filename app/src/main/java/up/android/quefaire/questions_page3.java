package up.android.quefaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.HashMap;

public class questions_page3 extends AppCompatActivity {

    private HashMap<String, String> savedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_page3);

        //récupération des données de l'activité précédente
        savedData = new HashMap<>();
        if (getIntent().getExtras().containsKey("interetCulture")) {
            savedData.put("interetCulture", String.valueOf(getIntent().getBooleanExtra("interetCulture", false)));
        }

        if (getIntent().getExtras().containsKey("typeCulture")) {
            savedData.put("typeCulture", getIntent().getStringExtra("typeCulture"));
        }

        //récupération des données des activités d'avant
        if (getIntent().getExtras().containsKey("sortirCeSoir")) {
            savedData.put("sortirCeSoir", getIntent().getStringExtra("sortirCeSoir"));
        }
        if (getIntent().getExtras().containsKey("nbPersonne")) {
            savedData.put("nbPersonne", getIntent().getStringExtra("nbPersonne"));
        }
        if (getIntent().getExtras().containsKey("aimerNature")) {
            savedData.put("aimerNature", getIntent().getStringExtra("aimerNature"));
        }

        savedData.forEach((key, value) -> {
            Log.i(MainActivity.TAG, "key = " + key + " value = " + value);
        });



    }

    //TODO : faire on save instance
    //TODO : faire on restore instance
    //TODO : envoyer les informations

    public void next(View v){
        Intent intent = new Intent(this, questions_page4.class);
        startActivity(intent);
    }

    public void back(View v){
        finish();
    }
}