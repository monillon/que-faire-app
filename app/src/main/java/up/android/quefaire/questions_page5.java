package up.android.quefaire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;

import java.util.HashMap;

public class questions_page5 extends AppCompatActivity {

    private HashMap<String, String> savedData;

    private SeekBar answer10;
    private RatingBar answer11;
    private Spinner answer12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_page5);

        answer10 = findViewById(R.id.answer10);
        answer11 = findViewById(R.id.answer11);
        answer12 = findViewById(R.id.answer12);

        savedData = new HashMap<>();
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

        savedData.forEach((key, value) -> {
            intent.putExtra(key, value);
        });

        intent.putExtra("mouille", answer10.getProgress());
        intent.putExtra("sensation", answer11.getProgress());
        intent.putExtra("animaux", answer12.getSelectedItem().toString());

        startActivity(intent);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        savedData.forEach((key, value) -> {
            outState.putString(key, value);
        });

        outState.putInt("answer10", answer10.getProgress());
        outState.putInt("answer11", answer11.getProgress());
        outState.putInt("answer12", answer12.getSelectedItemPosition());
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        
        if (savedInstanceState.containsKey("answer10")) {
            answer10.setProgress(savedInstanceState.getInt("answer10"));
        }
        if (savedInstanceState.containsKey("answer11")) {
            answer11.setProgress(savedInstanceState.getInt("answer11"));
        }
        if (savedInstanceState.containsKey("answer12")) {
            answer12.setSelection(savedInstanceState.getInt("answer12"));
        }


        if (savedInstanceState.containsKey("answer9Drink")) {
            savedData.put("answer9Drink", savedInstanceState.getString("answer9Drink"));
        }
        if (savedInstanceState.containsKey("answer9Sport")) {
            savedData.put("answer9Sport", savedInstanceState.getString("answer9Sport"));
        }
        if (savedInstanceState.containsKey("answer9Walking")) {
            savedData.put("answer9Walking", savedInstanceState.getString("answer9Walking"));
        }
        if (savedInstanceState.containsKey("answer9ThemePark")) {
            savedData.put("answer9ThemePark", savedInstanceState.getString("answer9ThemePark"));
        }
        if (savedInstanceState.containsKey("answer9EscapeGame")) {
            savedData.put("answer9EscapeGame", savedInstanceState.getString("answer9EscapeGame"));
        }
        if (savedInstanceState.containsKey("answer9Shooping")) {
            savedData.put("answer9Shooping", savedInstanceState.getString("answer9Shooping"));
        }
        if (savedInstanceState.containsKey("answer9Cinema")) {
            savedData.put("answer9Cinema", savedInstanceState.getString("answer9Cinema"));
        }
        if (savedInstanceState.containsKey("answer9VideoGame")) {
            savedData.put("answer9VideoGame", savedInstanceState.getString("answer9VideoGame"));
        }
        if (savedInstanceState.containsKey("answer9BoardGame")) {
            savedData.put("answer9BoardGame", savedInstanceState.getString("answer9BoardGame"));
        }
        if (savedInstanceState.containsKey("answer9Netflix")) {
            savedData.put("answer9Netflix", savedInstanceState.getString("answer9Netflix"));
        }
        if (savedInstanceState.containsKey("answer9Read")) {
            savedData.put("answer9Read", savedInstanceState.getString("answer9Read"));
        }
        if (savedInstanceState.containsKey("answer9Eat")) {
            savedData.put("answer9Eat", savedInstanceState.getString("answer9Eat"));
        }
        if (savedInstanceState.containsKey("answer9sleep")) {
            savedData.put("answer9sleep", savedInstanceState.getString("answer9sleep"));
        }
        if (savedInstanceState.containsKey("answer9Museum")) {
            savedData.put("answer9Museum", savedInstanceState.getString("answer9Museum"));
        }



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


