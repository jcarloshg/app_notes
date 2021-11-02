package com.example.examen_2_sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.examen_2_sqllite.screens.ConsultNote;
import com.example.examen_2_sqllite.screens.CreateNote;
import com.example.examen_2_sqllite.screens.DeleteNote;

public class MenuPrincipal extends AppCompatActivity {

    Button button_create_note, button_consult_note, button_delete_note;
    TextView textView_nameEmploye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        init_components();

        init_button_create_note();
        init_button_consult_note();
        init_button_delete_note();

    }

    private void init_button_delete_note() {
        button_delete_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent delelte_note = new Intent(MenuPrincipal.this, DeleteNote.class);
                startActivity(delelte_note);
            }
        });
    }

    private void init_button_consult_note() {
        button_consult_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consult_note = new Intent(MenuPrincipal.this, ConsultNote.class);
                startActivity(consult_note);
            }
        });
    }

    private void init_button_create_note() {
        button_create_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create_note = new Intent(MenuPrincipal.this, CreateNote.class);
                startActivity(create_note);
            }
        });
    }

    private void init_components() {
        textView_nameEmploye = findViewById(R.id.textView_nameEmploye);

        final String user_name = getIntent().getStringExtra("user_name");
        textView_nameEmploye.setText(user_name);

        button_create_note = findViewById(R.id.button_create_note);
        button_consult_note = findViewById(R.id.button_consult_note);
        button_delete_note = findViewById(R.id.button_delete_note);
    }
}