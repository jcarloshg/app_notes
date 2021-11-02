package com.example.examen_2_sqllite.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;


public class DBNote extends DB {

    private Context context;

    public DBNote(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long create_note() {
        long note_id = -1;

        try {
            DB db = new DB(context);
            SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(DB.NOTE_WORD_AUX, DB.NOTE_WORD_AUX);

            note_id = sqLiteDatabase.insert(DB.TABLE_NOTE, null, contentValues);

        } catch (Exception e) {
            Log.e("[create_note] ", " ", e);
        }
        return note_id;
    }

    public boolean delete_note(int note_id){
        boolean is_remove = false;

        DB db = new DB(this.context);
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

        try {
            String whereClause = DB.NOTE_ID + " = ?";
            String[] whereArgs = new String[] { String.valueOf(note_id) };
            sqLiteDatabase.delete(DB.TABLE_NOTE, whereClause, whereArgs);
            is_remove = true;
        } catch (Exception ex) {
            Log.e("[remove_row]", ex.toString());
        }

        return  is_remove;
    }
}
