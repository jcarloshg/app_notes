package com.example.examen_2_sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.examen_2_sqllite.screens.CreateNote;

public class MenuPrincipal extends AppCompatActivity {

    Button button_create_note, button_consult_note, button_delete_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        init_components();
        init_button_create_note();
    }

    private void init_button_create_note() {
        button_create_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("[init_button_create_note] ", "askdf;asldjfl;asjd;flaskjdf;alsdfjas;ldfj;lkasjdh");
                Intent create_note = new Intent(MenuPrincipal.this, CreateNote.class);
                startActivity(create_note);
            }
        });
    }

    private void init_components() {
        button_create_note = findViewById(R.id.button_create_note);
        button_consult_note = findViewById(R.id.button_consult_note);
        button_delete_note = findViewById(R.id.button_delete_note);
    }
}