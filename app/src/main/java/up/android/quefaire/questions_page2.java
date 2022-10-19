package up.android.quefaire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.HashMap;

public class questions_page2 extends AppCompatActivity {

    private HashMap<String, String> savedData;

    private RadioButton answer4yes;
    private RadioButton answer4no;

    private Spinner answer5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_page2);

        answer4yes = findViewById(R.id.answer4yes);
        answer4no = findViewById(R.id.answer4no);
        answer5 = findViewById(R.id.answer5);


        // création d'un listener sur l'action de sélection no
        answer4no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer5.setEnabled(false);
            }
        });

        answer4yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer5.setEnabled(true);
            }
        });

        answer5.setEnabled(false);



        // récupération des valeurs de l'activité précédente et stockage dans une HashMap
        savedData = new HashMap<>();
        if (getIntent().getExtras().containsKey("sortirCeSoir")) {
            savedData.put("sortirCeSoir", String.valueOf(getIntent().getBooleanExtra("sortirCeSoir", false)));
        }

        if (getIntent().getExtras().containsKey("nbPersonne")) {
            savedData.put("nbPersonne", String.valueOf(getIntent().getIntExtra("nbPersonne", 1)));
        }

        if (getIntent().getExtras().containsKey("aimerNature")) {
            savedData.put("aimerNature", String.valueOf(getIntent().getBooleanExtra("aimerNature", false)));
        }

    }

    public void next(View v){
        Intent intent = new Intent(this, questions_page3.class);

        // toutes les questions doivents avoir une réponse
        if (!answer4yes.isChecked() && !answer4no.isChecked()) {
            MainActivity.toast(this, "Vous devez remplir tous les champs");
            MainActivity.vibrate(this, 300);
        } else {
            intent.putExtra("interetCulture", answer4yes.isChecked());
            if (answer4yes.isChecked()) {
                intent.putExtra("typeCulture", answer5.getSelectedItem().toString());
            } else {
                intent.putExtra("typeCulture", "NA");
            }

            savedData.forEach((key, value) -> {
                intent.putExtra(key, value);
            });

            startActivity(intent);
        }

    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        savedData.forEach((key, value) -> {
            outState.putString(key, value);
        });

        outState.putBoolean("answer4yes", answer4yes.isChecked());
        outState.putBoolean("answer4no", answer4no.isChecked());
        outState.putInt("answer5", answer5.getSelectedItemPosition());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.containsKey("answer4yes")) {
            answer4yes.setChecked(savedInstanceState.getBoolean("answer4yes"));
        }
        if (savedInstanceState.containsKey("answer4no")) {
            answer4yes.setChecked(savedInstanceState.getBoolean("answer4no"));
        }
        if (savedInstanceState.containsKey("answer5")) {
            answer5.setSelection(savedInstanceState.getInt("answer5"));
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

    public void back(View v){
        finish();
    }
}