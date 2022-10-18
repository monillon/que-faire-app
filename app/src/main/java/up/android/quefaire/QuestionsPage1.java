package up.android.quefaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
            startActivity(intent);
        }

    }

    //TODO: Faire on save instance
    //TODO: Faire on restaure
    //TODO: Faire intent pour activity suivante
    //TODO: Faire en sorte que les questions soient répondu pour passer aux suivants

    public void back(View v){
        finish();
    }
}