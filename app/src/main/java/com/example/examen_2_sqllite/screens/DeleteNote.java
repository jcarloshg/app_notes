package com.example.examen_2_sqllite.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examen_2_sqllite.R;
import com.example.examen_2_sqllite.db.DBNote;
import com.example.examen_2_sqllite.db.DBNoteArticle;

public class DeleteNote extends AppCompatActivity {

    Button button_delete_note;
    EditText editText_id_note_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);

        init_component();

        init_button_delete_note();
    }

    private void init_button_delete_note() {
        button_delete_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBNote dbNote = new DBNote(getApplicationContext());
                DBNoteArticle dbNoteArticle = new DBNoteArticle(getApplicationContext());

                final String note = editText_id_note_delete.getText().toString();
                final int note_id = Integer.parseInt(note);

                final boolean is_delelte_note =
                        dbNote.delete_note(note_id) && dbNoteArticle.delete_note(note_id);

                if (is_delelte_note) {
                    Toast.makeText
                            (
                                    getApplicationContext(),
                                    "se a eliminado correctamente la nota: " + note_id,
                                    Toast.LENGTH_LONG
                            ).show();
                } else {
                    Toast.makeText
                            (
                                    getApplicationContext(),
                                    "No existe la nota",
                                    Toast.LENGTH_LONG
                            ).show();
                }
            }
        });
    }

    private void init_component() {
        button_delete_note = findViewById(R.id.button_delete_note);
        editText_id_note_delete = findViewById(R.id.editText_id_note_delete);
    }


}