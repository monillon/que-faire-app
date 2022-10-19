package up.android.quefaire;

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

        // toutes les questions doivents avoir une réponse
        if (!answer4yes.isChecked() && !answer4no.isChecked()) {
            MainActivity.toast(this, "Vous devez remplir tous les champs");
            MainActivity.vibrate(this, 300);
        }


        startActivity(intent);
    }

    //TODO : faire un on save
    //TODO : faire un on restore
    //TODO: envoyer toutes les informations à l'activiée suivante

    public void back(View v){
        finish();
    }
}