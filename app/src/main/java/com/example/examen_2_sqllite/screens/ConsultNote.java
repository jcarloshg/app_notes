package com.example.examen_2_sqllite.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.bluetooth.le.AdvertisingSetParameters;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.examen_2_sqllite.R;
import com.example.examen_2_sqllite.adapter.AdapterArticle;
import com.example.examen_2_sqllite.db.DBNoteArticle;
import com.example.examen_2_sqllite.entities.Article;

import java.util.ArrayList;

public class ConsultNote extends AppCompatActivity {

    Button button_search_note;
    EditText editText_id_note;
    RecyclerView recyclerView_articles_consult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_note);

        init_components();
        init_button_search_note();
    }

    private void init_button_search_note() {
        button_search_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String note = editText_id_note.getText().toString();
                final int note_id = Integer.parseInt(note);

                DBNoteArticle dbNoteArticle = new DBNoteArticle(getApplicationContext());
                ArrayList<Article> list_article = dbNoteArticle.get_note_by_id(note_id);

                AdapterArticle adapterArticle = new AdapterArticle(list_article);
                recyclerView_articles_consult.setAdapter(adapterArticle);
            }
        });
    }

    private void init_components() {
        button_search_note = findViewById(R.id.button_search_note);
        editText_id_note = findViewById(R.id.editText_id_note);

        // add this to fix -> "E/RecyclerView: No adapter attached; skipping layout"
        recyclerView_articles_consult = findViewById(R.id.recyclerView_articles_consult);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recyclerView_articles_consult.setLayoutManager(manager);
        recyclerView_articles_consult.setHasFixedSize(true);
    }
}