package br.edu.utfpr.magnocarvalho.prova.prova1turma2magno;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "br.edu.utfpr.magnocarvalho.prova.prova1turma2magno.MESSAGE";
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String check = "checkKey";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    TextView textView;
    RadioGroup rb;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        lerPreferencias();

        rb = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.textView);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);

//        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
//
//        setSupportActionBar(myToolbar);
//
//        ActionBar ab = getSupportActionBar();

        // Enable the Up button
//        ab.setDisplayHomeAsUpEnabled(true);
    }

//    public void lerPreferencias()
//    {
//        SharedPreferences shared =
//                getSharedPreferences(MyPREFERENCES,
//                        Context.MODE_PRIVATE);
//
//        String test = shared.getString(Name, null);
//        Integer id = shared.getInt(check, 0);
//        if(test != "" && id != 0 && test != null){
//            if(id == 1)
//            {
//                radioButton1.setChecked(true);
//            }
//            else
//            if(id == 2)
//            {
//                radioButton3.setChecked(true);
//            }
//            else
//            if(id == 3)
//            {
//                radioButton3.setChecked(true);
//            }
//                textView.setText(test);
//        }
//    }



    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DicaActivity.class);

        EditText editText = (EditText) findViewById(R.id.editTextNome);

        String message = "";
        boolean rb1 = radioButton1.isChecked();
        boolean rb2 = radioButton2.isChecked();
        boolean rb3 = radioButton3.isChecked();
        Integer idRadio = 0;
        if(rb1)
        {   message = "Parabéns ";
            idRadio = 1;
        }
        else
            if(rb2)
        {
            message = "Não se preocupe  ";
            idRadio = 2;
        }
        else
            if(rb3)
        {
            message = "Que vida boa ";
            idRadio = 3;
        }
        message += editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message + '!');

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(Name, editText.getText().toString());
        editor.putInt(check, idRadio);
        editor.commit();


        this.onPause();
        startActivity(intent);

    }
        // public boolean onCreateOptionsMenu(Menu menu) {
         //   MenuInflater inflater = getMenuInflater();
         //  inflater.inflate(R.menu.game_menu, menu);
          //   return true;

    public void limparPrincipal(View view){

        Intent intent = new Intent(this, MainActivity.class);
        final EditText nome = (EditText) findViewById(R.id.editTextNome);
        //final  RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton);
        //final  RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        //final  RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        nome.setText("");
        rg.clearCheck();

        startActivity(intent);
       // super.onRestart();
    }


    public void abrirAjuda(View view)
    {
        Intent intent = new Intent(this, AjudaActivity.class);
        this.onPause();
        startActivity(intent);
    }





}
