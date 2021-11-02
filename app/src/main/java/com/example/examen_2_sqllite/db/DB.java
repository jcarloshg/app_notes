package com.example.examen_2_sqllite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "EXAM.db";

    // article
    public static final String TABLE_ARTICLE = "TABLE_ARTICLE";
    public static final String ARTICLE_ID = "ARTICLE_ID";
    public static final String ARTICLE_NAME = "ARTICLE_NAME";
    public static final String ARTICLE_BRAND = "ARTICLE_BRAND";
    public static final String ARTICLE_COST = "ARTICLE_COST";
    public static final String ARTICLE_AMOUNT = "ARTICLE_AMOUNT";

    // note
    public static final String TABLE_NOTE = "TABLE_NOTE";
    public static final String NOTE_ID = "NOTE_ID";
    public static final String NOTE_WORD_AUX = "NOTE_WORD_AUX";

    // ARTICLE_NOTE
    public static final String TABLE_ARTICLE_NOTE = "TABLE_ARTICLE_NOTE";
    public static final String ARTICLE_NOTE_ID = "ARTICLE_NOTE_ID";
    public static final String ARTICLE_NOTE_ARTICLE_ID = "ARTICLE_NOTE_ARTICLE_ID";
    public static final String ARTICLE_NOTE_NOTE_ID = "ARTICLE_NOTE_NOTE_ID";

    // USER
    public static final String TABLE_USER = "TABLE_USER";
    public static final String USER_ID = "USER_ID";
    public static final String USER_NAME = "USER_NAME";
    public static final String USER_PASSWORD = "USER_PASSWORD";

    public DB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_ARTICLE +
                        " (" +
                        ARTICLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        ARTICLE_NAME + " TEXT NOT NULL, " +
                        ARTICLE_BRAND + " TEXT NOT NULL, " +
                        ARTICLE_COST + " FLOAT NOT NULL, " +
                        ARTICLE_AMOUNT + " INT NOT NULL " +
                        ")"
        );

        db.execSQL(
                "CREATE TABLE " + TABLE_NOTE +
                        " (" +
                        NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        NOTE_WORD_AUX + " TEXT NOT NULL " +
                        ")"
        );

        db.execSQL(
                "CREATE TABLE " + TABLE_ARTICLE_NOTE +
                        " (" +
                        ARTICLE_NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        ARTICLE_NOTE_NOTE_ID + " INTEGER NOT NULL, " +
                        ARTICLE_NOTE_ARTICLE_ID + " INTEGER NOT NULL " +
                        ")"
        );

        db.execSQL(
                "CREATE TABLE " + TABLE_USER +
                        " (" +
                        USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        USER_NAME + " TEXT NOT NULL, " +
                        USER_PASSWORD + " TEXT NOT NULL " +
                        ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_ARTICLE);
        db.execSQL("DROP TABLE " + TABLE_NOTE);
        db.execSQL("DROP TABLE " + TABLE_ARTICLE_NOTE);
        db.execSQL("DROP TABLE " + TABLE_USER);

        onCreate(db);
    }
}
