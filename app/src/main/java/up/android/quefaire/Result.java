package up.android.quefaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Result extends AppCompatActivity {

    private HashMap<String, String> savedData;

    private TextView ResultOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        savedData = new HashMap<>();
        //récupérer les informations précédentes
        if (getIntent().getExtras().containsKey("mouille")) {
            savedData.put("mouille", String.valueOf(getIntent().getIntExtra("mouille", 0)));
        }
        if (getIntent().getExtras().containsKey("sensation")) {
            savedData.put("sensation", String.valueOf(getIntent().getIntExtra("sensation", 0)));
        }
        if (getIntent().getExtras().containsKey("animaux")) {
            savedData.put("animaux", getIntent().getStringExtra("animaux"));
        }

        //récupérer les informations avant
        if (getIntent().getExtras().containsKey("answer9Drink")) {
            savedData.put("answer9Drink", getIntent().getStringExtra("answer9Drink"));
        }
        if (getIntent().getExtras().containsKey("answer9Sport")) {
            savedData.put("answer9Sport", getIntent().getStringExtra("answer9Sport"));
        }
        if (getIntent().getExtras().containsKey("answer9Walking")) {
            savedData.put("answer9Walking", getIntent().getStringExtra("answer9Walking"));
        }
        if (getIntent().getExtras().containsKey("answer9ThemePark")) {
            savedData.put("answer9ThemePark", getIntent().getStringExtra("answer9ThemePark"));
        }
        if (getIntent().getExtras().containsKey("answer9EscapeGame")) {
            savedData.put("answer9EscapeGame", getIntent().getStringExtra("answer9EscapeGame"));
        }
        if (getIntent().getExtras().containsKey("answer9Shooping")) {
            savedData.put("answer9Shooping", getIntent().getStringExtra("answer9Shooping"));
        }
        if (getIntent().getExtras().containsKey("answer9Cinema")) {
            savedData.put("answer9Cinema", getIntent().getStringExtra("answer9Cinema"));
        }
        if (getIntent().getExtras().containsKey("answer9VideoGame")) {
            savedData.put("answer9VideoGame", getIntent().getStringExtra("answer9VideoGame"));
        }
        if (getIntent().getExtras().containsKey("answer9BoardGame")) {
            savedData.put("answer9BoardGame", getIntent().getStringExtra("answer9BoardGame"));
        }
        if (getIntent().getExtras().containsKey("answer9Netflix")) {
            savedData.put("answer9Netflix", getIntent().getStringExtra("answer9Netflix"));
        }
        if (getIntent().getExtras().containsKey("answer9Read")) {
            savedData.put("answer9Read", getIntent().getStringExtra("answer9Read"));
        }
        if (getIntent().getExtras().containsKey("answer9Eat")) {
            savedData.put("answer9Eat", getIntent().getStringExtra("answer9Eat"));
        }
        if (getIntent().getExtras().containsKey("answer9sleep")) {
            savedData.put("answer9sleep", getIntent().getStringExtra("answer9sleep"));
        }
        if (getIntent().getExtras().containsKey("answer9Museum")) {
            savedData.put("answer9Museum", getIntent().getStringExtra("answer9Museum"));
        }
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


        write_answers_in_file();
    }

    public void restart(View v){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void partager(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        String texte = new String();

        for (Map.Entry<String, String> entry : savedData.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            texte += key + " : " + value + "\n";
        }


        intent.putExtra(Intent.EXTRA_TEXT, "Voilà mes résulats à l'activité que faire \n" + texte);
        startActivity(Intent.createChooser(intent, "Share"));
    }

    public void back(View v){finish();}

    public void write_answers_in_file() {
        MainActivity.toast(this, "Les données ont été sauvegardées dans le dossier Téléchargements");
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File fileout = new File(folder, "answers.txt");
        try (FileOutputStream fos = new FileOutputStream(fileout, true)) {
            PrintStream ps = new PrintStream(fos);
            ps.println("Start of my historic of " + Calendar.getInstance().getTime());

            // TODO: YOU MUST COMPLETE ICI
            String texte = new String();

            for (Map.Entry<String, String> entry : savedData.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                texte += key + " : " + value + "\n";
            }

            ps.println(texte);

            ps.close();
        } catch (FileNotFoundException e) {
            Log.e(MainActivity.TAG,"File not found",e);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(MainActivity.TAG,"Error I/O",e);
        }

    }

}