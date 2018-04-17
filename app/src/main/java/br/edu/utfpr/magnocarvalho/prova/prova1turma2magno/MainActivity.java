package br.edu.utfpr.magnocarvalho.prova.prova1turma2magno;

import android.support.constraint.ConstraintLayout;
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
     private ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (ConstraintLayout) findViewById(R.id.layoutCont);
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
        // public boolean onCreateOptionsMenu(Menu menu) {
         //   MenuInflater inflater = getMenuInflater();
         //  inflater.inflate(R.menu.game_menu, menu);
          //   return true;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }
    public void salvar(MenuItem item){
        Toast.makeText(this, "Salvar", Toast.LENGTH_SHORT).show();
    }

    public void usarDados(MenuItem item){
        item.setChecked(!item.isChecked());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        item.setChecked(true);

        switch(item.getItemId()){
            case R.id.menuItemAjuda:
                setContentView(R.layout.activity_ajuda);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
