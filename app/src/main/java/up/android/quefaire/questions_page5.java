package up.android.quefaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;

public class questions_page5 extends AppCompatActivity {

    private HashMap<String, String> savedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_page5);


        //récupération des informations de l'activité précédente
        if (getIntent().getExtras().containsKey("answer9Drink")) {
            savedData.put("answer9Drink", String.valueOf(getIntent().getBooleanExtra("answer9Drink", true)));
        }
        if (getIntent().getExtras().containsKey("answer9Sport")) {
            savedData.put("answer9Sport", String.valueOf(getIntent().getBooleanExtra("answer9Sport", true)));
        }
        if (getIntent().getExtras().containsKey("answer9Walking")) {
            savedData.put("answer9Walking", String.valueOf(getIntent().getBooleanExtra("answer9Walking", true)));
        }
        if (getIntent().getExtras().containsKey("answer9ThemePark")) {
            savedData.put("answer9ThemePark", String.valueOf(getIntent().getBooleanExtra("answer9ThemePark", true)));
        }
        if (getIntent().getExtras().containsKey("answer9EscapeGame")) {
            savedData.put("answer9EscapeGame", String.valueOf(getIntent().getBooleanExtra("answer9EscapeGame", true)));
        }
        if (getIntent().getExtras().containsKey("answer9Shooping")) {
            savedData.put("answer9Shooping", String.valueOf(getIntent().getBooleanExtra("answer9Shooping", true)));
        }
        if (getIntent().getExtras().containsKey("answer9Cinema")) {
            savedData.put("answer9Cinema", String.valueOf(getIntent().getBooleanExtra("answer9Cinema", true)));
        }
        if (getIntent().getExtras().containsKey("answer9VideoGame")) {
            savedData.put("answer9VideoGame", String.valueOf(getIntent().getBooleanExtra("answer9VideoGame", true)));
        }
        if (getIntent().getExtras().containsKey("answer9BoardGame")) {
            savedData.put("answer9BoardGame", String.valueOf(getIntent().getBooleanExtra("answer9BoardGame", true)));
        }
        if (getIntent().getExtras().containsKey("answer9Netflix")) {
            savedData.put("answer9Netflix", String.valueOf(getIntent().getBooleanExtra("answer9Netflix", true)));
        }
        if (getIntent().getExtras().containsKey("answer9Read")) {
            savedData.put("answer9Read", String.valueOf(getIntent().getBooleanExtra("answer9Read", true)));
        }
        if (getIntent().getExtras().containsKey("answer9Eat")) {
            savedData.put("answer9Eat", String.valueOf(getIntent().getBooleanExtra("answer9Eat", true)));
        }
        if (getIntent().getExtras().containsKey("answer9sleep")) {
            savedData.put("answer9sleep", String.valueOf(getIntent().getBooleanExtra("answer9sleep", true)));
        }
        if (getIntent().getExtras().containsKey("answer9Museum")) {
            savedData.put("answer9Museum", String.valueOf(getIntent().getBooleanExtra("answer9Museum", true)));
        }


        // récupération des informations précédentes
        if (getIntent().getExtras().containsKey("mood")) {
            savedData.put("mood", getIntent().getStringExtra("mood"));
        }
        if (getIntent().getExtras().containsKey("age")) {
            savedData.put("age", getIntent().getStringExtra("age"));
        }
        if (getIntent().getExtras().containsKey("payante")) {
            savedData.put("payante", getIntent().getStringExtra("payante"));
        }
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




    }

    public void next(View v){
        Intent intent = new Intent(this, Result.class);
        startActivity(intent);
    }

    //TODO: faire on save
    //TODO: faire on restore
    //TODO: toutes les questions doivent avoir une réponse
    //TODO: envoyer les informations au suivant

    public void back(View v){
        finish();
    }
}


