package up.android.quefaire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.HashMap;

public class questions_page3 extends AppCompatActivity {

    private HashMap<String, String> savedData;

    private Spinner answer6;
    private EditText answer7;
    private RadioButton answer8yes;
    private RadioButton answer8no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_page3);

        answer6 = findViewById(R.id.answer6);
        answer7 = findViewById(R.id.answer7);
        answer8yes = findViewById(R.id.answer8yes);
        answer8no = findViewById(R.id.answer8no);

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

    //TODO : faire on restore instance
    //TODO : envoyer les informations

    public void next(View v){
        Intent intent = new Intent(this, questions_page4.class);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        savedData.forEach((key, value) -> {
            outState.putString(key, value);
        });

        outState.putInt("answer6", answer6.getSelectedItemPosition());
        outState.putString("answer7", answer7.getText().toString());
        outState.putBoolean("answer8yes", answer8yes.isChecked());
        outState.putBoolean("answer8no", answer8no.isChecked());
    }

    public void back(View v){
        finish();
    }
}