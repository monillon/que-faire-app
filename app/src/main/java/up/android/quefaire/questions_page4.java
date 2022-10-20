package up.android.quefaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;

public class questions_page4 extends AppCompatActivity {

    private HashMap<String, String> savedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_page4);


        // Récupération des informations de l'activité précédente
        savedData = new HashMap<>();
        if (getIntent().getExtras().containsKey("mood")) {
            savedData.put("mood", getIntent().getStringExtra("mood"));
        }
        if (getIntent().getExtras().containsKey("age")) {
            savedData.put("age", String.valueOf(getIntent().getIntExtra("age", -1)));
        }
        if (getIntent().getExtras().containsKey("payante")) {
            savedData.put("payante", String.valueOf(getIntent().getBooleanExtra("payante", false)));
        }

        // récupération des informations des acitivités avant
        if (getIntent().getExtras().containsKey("interetCulture")) {
            savedData.put("interetCulture", getIntent().getStringExtra("interetCulture"));
        }
        if (getIntent().getExtras().containsKey("typeCulture")) {
            savedData.put("typeCulture", getIntent().getStringExtra("typeCulture"));
        }
        if (getIntent().getExtras().containsKey("sortirCeSoir")) {
            savedData.put("sortirCeSoir", getIntent().getStringExtra("sortirCeSoir"));
        }
        if (getIntent().getExtras().containsKey("nbPersonne")) {
            savedData.put("nbPersonne", getIntent().getStringExtra("nbPersonne"));
        }
        if (getIntent().getExtras().containsKey("aimerNature")) {
            savedData.put("aimerNature", getIntent().getStringExtra("aimerNature"));
        }


    }

    public void next(View v){
        Intent intent = new Intent(this, questions_page5.class);
        startActivity(intent);
    }

    //TODO: faire on save
    //TODO: faire on restore
    //TODO: envoyer les données
    //TODO: toutes les questions doivent avoir une réponse

    public void back(View v){
        finish();
    }
}