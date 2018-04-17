package br.edu.utfpr.magnocarvalho.prova.prova1turma2magno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AjudaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajuda);
    }

    public void voltarPrincipal(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

    }

}
