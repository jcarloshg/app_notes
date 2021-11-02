package com.example.examen_2_sqllite.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.examen_2_sqllite.entities.Article;

import java.util.ArrayList;

public class DBArticle extends DB {

    private Context context;

    public DBArticle(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insert_article(com.example.examen_2_sqllite.entities.Article article) {
        long id_insert = -1;

        try {
            DB db = new DB(context);
            SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(DB.ARTICLE_NAME, article.getName());
            contentValues.put(DB.ARTICLE_BRAND, article.getBrand());
            contentValues.put(DB.ARTICLE_COST, article.getCost());
            contentValues.put(DB.ARTICLE_AMOUNT, article.getAmount());

            id_insert = sqLiteDatabase.insert(DB.TABLE_ARTICLE, null, contentValues);
        } catch (Exception e) {
            Log.e("[insert_article] ", "insert_article: ", e);
        }

        return id_insert;
    }

    public ArrayList<Article> get_articles() {
        ArrayList<Article> list_articles = new ArrayList<>();

        try {
            DB db = new DB(this.context);
            SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + DB.TABLE_ARTICLE, null);

            int column_id = cursor.getColumnIndex(DB.ARTICLE_ID);
            int column_name = cursor.getColumnIndex(DB.ARTICLE_NAME);
            int column_brand = cursor.getColumnIndex(DB.ARTICLE_BRAND);
            int column_cost = cursor.getColumnIndex(DB.ARTICLE_COST);
            int column_amount = cursor.getColumnIndex(DB.ARTICLE_AMOUNT);

            if (cursor.moveToFirst()) {
                do {
                    Article article = new Article(
                            cursor.getInt(column_id),
                            cursor.getString(column_name),
                            cursor.getString(column_brand),
                            cursor.getFloat(column_cost),
                            cursor.getInt(column_amount)
                    );
                    list_articles.add(article);
                } while (cursor.moveToNext());
            }

        } catch (Exception e) {
            Log.e("[get_articles] ", "", e);
        }

        return list_articles;
    }

    public ArrayList<Article> get_articles_by_name(String name) {
        ArrayList<Article> list_articles = new ArrayList<>();

        try {
            DB db = new DB(this.context);
            SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

            Cursor cursor = sqLiteDatabase.rawQuery(
                    "SELECT * " +
                            " FROM " + DB.TABLE_ARTICLE +
                            " WHERE " + DB.ARTICLE_NAME + " LIKE '%" + name + "%';",
                    null);

            int column_id = cursor.getColumnIndex(DB.ARTICLE_ID);
            int column_name = cursor.getColumnIndex(DB.ARTICLE_NAME);
            int column_brand = cursor.getColumnIndex(DB.ARTICLE_BRAND);
            int column_cost = cursor.getColumnIndex(DB.ARTICLE_COST);
            int column_amount = cursor.getColumnIndex(DB.ARTICLE_AMOUNT);
            if (cursor.moveToFirst()) {
                do {
                    Article article = new Article(
                            cursor.getInt(column_id),
                            cursor.getString(column_name),
                            cursor.getString(column_brand),
                            cursor.getFloat(column_cost),
                            cursor.getInt(column_amount)
                    );
                    list_articles.add(article);
                } while (cursor.moveToNext());
            }

        } catch (Exception e) {
            Log.e("[get_article_by_name] ", " ", e);
        }

        return list_articles;
    }

    public Article get_article_by_id(int article_id) {
        Article article = null;

        try {
            DB db = new DB(this.context);
            SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

            Cursor cursor = sqLiteDatabase.rawQuery(
                    "SELECT * " +
                            " FROM " + DB.TABLE_ARTICLE +
                            " WHERE " + DB.ARTICLE_ID + " = " + article_id + " ;",
                    null);

            if (cursor.moveToFirst()) {
                int column_id = cursor.getColumnIndex(DB.ARTICLE_ID);
                int column_name = cursor.getColumnIndex(DB.ARTICLE_NAME);
                int column_brand = cursor.getColumnIndex(DB.ARTICLE_BRAND);
                int column_cost = cursor.getColumnIndex(DB.ARTICLE_COST);
                int column_amount = cursor.getColumnIndex(DB.ARTICLE_AMOUNT);

                article =
                        new Article(
                                cursor.getInt(column_id),
                                cursor.getString(column_name),
                                cursor.getString(column_brand),
                                cursor.getFloat(column_cost),
                                cursor.getInt(column_amount)
                        );
            }

        } catch (Exception e) {
            Log.e("[get_article_by_id] ", " ", e);
        }

        return article;
    }



}
