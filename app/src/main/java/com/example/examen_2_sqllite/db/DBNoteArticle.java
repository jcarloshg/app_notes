package com.example.examen_2_sqllite.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.examen_2_sqllite.entities.Article;

import java.util.ArrayList;

public class DBNoteArticle extends DB {

    private Context context;

    public DBNoteArticle(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insert_note_and_article(int note_id, int article_id) {
        long note_article_id = -1;

        try {
            DB db = new DB(context);
            SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(DB.ARTICLE_NOTE_NOTE_ID, note_id);
            contentValues.put(DB.ARTICLE_NOTE_ARTICLE_ID, article_id);

            note_article_id = sqLiteDatabase.insert(DB.TABLE_ARTICLE_NOTE, null, contentValues);

        } catch (Exception e) {
            Log.e("[insert_note_and_article] ", " ", e);
        }

        return note_article_id;
    }

    public ArrayList<Article> get_note_by_id(int note_id) {
        ArrayList<Article> list_article = new ArrayList<>();

        try {
            DB db = new DB(context);
            SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

            Cursor cursor = sqLiteDatabase.rawQuery(
                    "SELECT * " +
                            " FROM " + DB.TABLE_ARTICLE_NOTE +
                            " WHERE " + DB.ARTICLE_NOTE_NOTE_ID + " = " + note_id + " ;",
                    null);

            // Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + DB.TABLE_ARTICLE_NOTE, null);

            if (cursor.moveToFirst()) {

                DBArticle dbArticle = new DBArticle(this.context);

                do {
                    final int column_article_id = cursor.getColumnIndex(DB.ARTICLE_NOTE_ARTICLE_ID);
                    final int article_id = cursor.getInt(column_article_id);

                    Article article = dbArticle.get_article_by_id(article_id);
                    list_article.add(article);

                } while (cursor.moveToNext());
            }

        } catch (Exception e) {
            Log.e("[get_note_by_id] ", " ", e);
        }

        return list_article;
    }

    public boolean delete_note(int note_id){
        boolean is_remove = false;

        DB db = new DB(this.context);
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

        try {
            String whereClause = DB.ARTICLE_NOTE_NOTE_ID + " = ?";
            String[] whereArgs = new String[] { String.valueOf(note_id) };
            sqLiteDatabase.delete(DB.TABLE_ARTICLE_NOTE, whereClause, whereArgs);
            is_remove = true;
        } catch (Exception ex) {
            Log.e("[remove_row]", ex.toString());
        }

        return  is_remove;
    }

}
