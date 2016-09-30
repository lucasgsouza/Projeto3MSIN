package com.example.lucassouza.myprojectapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheCurso extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_curso);

        Intent intent = getIntent();
        String nomecurso = "Curso: "+intent.getStringExtra("nome");

        TextView tv_nome = (TextView) findViewById(R.id.tv_nomeCurso);
        tv_nome.setText(nomecurso);
    }

}
