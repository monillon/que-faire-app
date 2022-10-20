package up.android.quefaire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import java.util.HashMap;
import java.util.Map;

public class questions_page4 extends AppCompatActivity {

    private HashMap<String, String> savedData;

    private HashMap<String, CheckBox> answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_page4);

        answers = new HashMap<>();
        answers.put("answer9Drink", findViewById(R.id.answer9Drink));
        answers.put("answer9Sport", findViewById(R.id.answer9Sport));
        answers.put("answer9Walking", findViewById(R.id.answer9Walking));
        answers.put("answer9ThemePark", findViewById(R.id.answer9ThemePark));
        answers.put("answer9EscapeGame", findViewById(R.id.answer9EscapeGame));
        answers.put("answer9Shooping", findViewById(R.id.answer9Shooping));
        answers.put("answer9Cinema", findViewById(R.id.answer9Cinema));
        answers.put("answer9VideoGame", findViewById(R.id.answer9VideoGame));
        answers.put("answer9BoardGame", findViewById(R.id.answer9BoardGame));
        answers.put("answer9Netflix", findViewById(R.id.answer9Netflix));
        answers.put("answer9Read", findViewById(R.id.answer9Read));
        answers.put("answer9Eat", findViewById(R.id.answer9Eat));
        answers.put("answer9sleep", findViewById(R.id.answer9sleep));
        answers.put("answer9Museum", findViewById(R.id.answer9Museum));


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
        boolean nothingCheked = true;

        Intent intent = new Intent(this, questions_page5.class);

        for (Map.Entry<String, CheckBox> i : answers.entrySet()) {
            CheckBox value = i.getValue();
            if (value.isChecked()) {
                nothingCheked = false;
            }
            break;
        }

        if (nothingCheked) {
            MainActivity.toast(this, "Vous devez remplir tous les champs");
            MainActivity.vibrate(this, 300);
        } else {
            // sauvegarde des données


            startActivity(intent);
        }


    }

    //TODO: envoyer les données


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        savedData.forEach((key, value) -> {
            outState.putString(key, value);
        });

        answers.forEach((key, value) -> {
            outState.putBoolean(key, value.isChecked());
        });
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        answers.forEach((key, value) -> {
            if (savedInstanceState.containsKey(key)) {
                value.setChecked(savedInstanceState.getBoolean(key));
            }
        });

        if (savedInstanceState.containsKey("mood")) {
            savedData.put("mood", savedInstanceState.getString("mood"));
        }
        if (savedInstanceState.containsKey("age")) {
            savedData.put("age", savedInstanceState.getString("age"));
        }
        if (savedInstanceState.containsKey("payante")) {
            savedData.put("payante", savedInstanceState.getString("payante"));
        }
        if (savedInstanceState.containsKey("interetCulture")) {
            savedData.put("interetCulture", savedInstanceState.getString("interetCulture"));
        }
        if (savedInstanceState.containsKey("sortirCeSoir")) {
            savedData.put("sortirCeSoir", savedInstanceState.getString("sortirCeSoir"));
        }
        if (savedInstanceState.containsKey("nbPersonne")) {
            savedData.put("nbPersonne", savedInstanceState.getString("nbPersonne"));
        }
        if (savedInstanceState.containsKey("aimerNature")) {
            savedData.put("aimerNature", savedInstanceState.getString("aimerNature"));
        }
    }

    public void back(View v){
        finish();
    }
}




