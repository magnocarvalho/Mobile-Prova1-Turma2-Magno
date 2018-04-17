package br.edu.utfpr.magnocarvalho.prova.prova1turma2magno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "br.edu.utfpr.magnocarvalho.prova.prova1turma2magno.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DicaActivity.class);

        EditText editText = (EditText) findViewById(R.id.editTextNome);
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        String message = "";
        boolean rb1 = radioButton1.isChecked();
        boolean rb2 = radioButton2.isChecked();
        boolean rb3 = radioButton3.isChecked();
        if(rb1)
        {   message = "Parabéns ";

        }
        else
            if(rb2)
        {
            message = "Não se preocupe  ";

        }
        else
            if(rb3)
        {
            message = "Que vida boa ";

        }
        message += editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message + '!');
        startActivity(intent);

    }
    public void limparPrincipal(View view){

        final EditText nome = (EditText) findViewById(R.id.editTextNome);
        //final  RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton);
        //final  RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        //final  RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);

        nome.setText("");
        rg.clearCheck();




       // super.onRestart();
    }
}
