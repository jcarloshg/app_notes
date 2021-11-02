package com.example.examen_2_sqllite.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.examen_2_sqllite.R;
import com.example.examen_2_sqllite.adapter.AdapterArticle;
import com.example.examen_2_sqllite.db.DB;
import com.example.examen_2_sqllite.db.DBArticle;
import com.example.examen_2_sqllite.db.DBNote;
import com.example.examen_2_sqllite.entities.Article;

import java.util.ArrayList;

public class CreateNote extends AppCompatActivity {

    SearchView searchView_article;
    Button button_save, button_reload, button_add;
    RecyclerView recycler_view_articles;

    private long note_id = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        init_components();

        // momentaneo
        init_button_save();
        init_button_reload();
        init_searchView_article();
        init_button_add();

        // create note
        DBNote dbNote = new DBNote(getApplicationContext());
        note_id = dbNote.create_note();
        Toast.makeText(
                this,
                "Nota con ID: " + note_id + " a sido creada",
                Toast.LENGTH_LONG).show();
    }

    private void init_button_add() {
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String article_name = searchView_article.getQuery().toString();

                DBArticle dbArticle = new DBArticle(getApplicationContext());
                ArrayList<Article> list_article = dbArticle.get_articles_by_name(article_name);
                Article article = list_article.get(0); // get only article


            }
        });
    }

    private void init_searchView_article() {
        searchView_article.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            DBArticle dbArticle = new DBArticle(getApplicationContext());

            @Override
            public boolean onQueryTextSubmit(String s) {
                ArrayList<Article> list_article = dbArticle.get_articles_by_name(s);
                AdapterArticle adapterArticle = new AdapterArticle(list_article);
                recycler_view_articles.setAdapter(adapterArticle);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<Article> list_article = dbArticle.get_articles_by_name(s);
                AdapterArticle adapterArticle = new AdapterArticle(list_article);
                recycler_view_articles.setAdapter(adapterArticle);
                return false;
            }
        });

    }


    private void init_button_reload() {
        button_reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBArticle dbArticle = new DBArticle(v.getContext());
                ArrayList<Article> list_article = dbArticle.get_articles();
                AdapterArticle adapterArticle = new AdapterArticle(list_article);
                recycler_view_articles.setAdapter(adapterArticle);
            }
        });
    }

    private void init_button_save() {
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restore_data(v);
            }
        });
    }

    private void init_components() {
        button_save = findViewById(R.id.button_save);
        button_reload = findViewById(R.id.button_reload);
        button_add = findViewById(R.id.button_add);

        searchView_article = findViewById(R.id.searchView_article);
        searchView_article.onActionViewExpanded();
        searchView_article.setIconified(true);

        // add this to fix -> "E/RecyclerView: No adapter attached; skipping layout"
        recycler_view_articles = findViewById(R.id.recycler_view_articles);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recycler_view_articles.setLayoutManager(manager);
        recycler_view_articles.setHasFixedSize(true);
    }


    private void restore_data(View v) {

        // delete and rebuilt DB ================================================
        DB db = new DB(v.getContext());
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        db.onUpgrade(sqLiteDatabase, db.DATABASE_VERSION, db.DATABASE_VERSION + 1);

        // insert articles ================================================
        ArrayList<Article> list_article = new ArrayList<>();
        list_article.add(new Article(1, "Huawei Y9 pro", "Huawei", (float) 5000.0, 12));
        list_article.add(new Article(2, "Mouse G90K", "Logitech", (float) 500.0, 3));
        list_article.add(new Article(3, "Laptop Mate Book", "HP", (float) 14000, 4));
        list_article.add(new Article(4, "Monitor KL50", "SAMGUNG", (float) 6400.0, 5));
        list_article.add(new Article(5, "USB-C 20cm", "Terch", (float) 50, 8));
        list_article.add(new Article(6, "Taza para cafe", "Lument", (float) 90, 13));
        list_article.add(new Article(7, "Audifinos inalambricos", "Firstop", (float) 120, 12));
        list_article.add(new Article(8, "Lappara de mesa", "Fersh", (float) 150, 3));
        list_article.add(new Article(9, "Keyboard 60%", "REDDRAGON", (float) 1300, 1));
        list_article.add(new Article(0, "Tapete mouse pad", "GORILLAZ", (float) 200, 7));

        DBArticle dbArticle = new DBArticle(v.getContext());
        for (Article article : list_article)
            dbArticle.insert_article(article);

        // insert users ================================================


    }

}