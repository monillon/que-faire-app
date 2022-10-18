package up.android.quefaire;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuestionsPage1 extends AppCompatActivity {

    private RadioButton answer1yes; // oui envie de sortir
    private RadioButton answer1no; // non envie de sortir

    private TextView answer2; // nb personne

    private RadioButton answer3yes; // oui aimer la nature
    private RadioButton answer3no; // non aimer la nature

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_page1);

        this.answer1yes = findViewById(R.id.answer1yes);
        this.answer1no = findViewById(R.id.answer1no);
        this.answer2 = findViewById(R.id.answer2);
        this.answer3yes = findViewById(R.id.answer3yes);
        this.answer3no = findViewById(R.id.answer3no);

    }

    public void next(View v){
        boolean erreurSaisie = false;

        Intent intent = new Intent(this, questions_page2.class);

        // toutes les questions doivent avoir une réponse
        if (!answer1yes.isChecked() && !answer1no.isChecked()) {
            erreurSaisie = true;
        }

        if (answer2.getText().toString().isEmpty()) {
            erreurSaisie = true;
        }

        if (!answer3yes.isChecked() && !answer3no.isChecked()) {
            erreurSaisie = true;
        }

        if (erreurSaisie) {
            MainActivity.toast(this, "Vous devez remplir tous les champs");
            MainActivity.vibrate(this, 300);
        } else {

            intent.putExtra("sortirCeSoir", (answer1yes.isChecked()));
            intent.putExtra("nbPersonne", Integer.parseInt(answer2.getText().toString()));
            intent.putExtra("aimerNature", answer3yes.isChecked());

            startActivity(intent);
        }

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // sauvegarde des données en cas de onStop
        outState.putString("answer1yesBool", String.valueOf(answer1yes.isChecked()));
        outState.putString("answer1noBool", String.valueOf(answer1no.isChecked()));
        outState.putString("answer2", answer2.getText().toString());
        outState.putString("answer3yesBool", String.valueOf(answer3yes.isChecked()));
        outState.putString("answer3noBool", String.valueOf(answer3no.isChecked()));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("answer1yesBool")) {
            answer3yes.setChecked(Boolean.parseBoolean(savedInstanceState.getString("answer1yesBool")));
        }

        if (savedInstanceState.containsKey("answer1noBool")) {
            answer1no.setChecked(Boolean.parseBoolean(savedInstanceState.getString("answer1noBool")));
        }

        if (savedInstanceState.containsKey("answer2")) {
            answer2.setText(savedInstanceState.getString("answer2"));
        }

        if (savedInstanceState.containsKey("answer3yesBool")) {
            answer3yes.setChecked(Boolean.parseBoolean(savedInstanceState.getString("answer3yesBool")));
        }

        if (savedInstanceState.containsKey("answer3noBool")) {
            answer3no.setChecked(Boolean.parseBoolean(savedInstanceState.getString("answer3noBool")));
        }

    }


    public void back(View v){
        finish();
    }
}