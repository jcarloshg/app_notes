package com.example.examen_2_sqllite.db;

import android.content.Context;

import androidx.annotation.Nullable;

public class Article extends DB{

    private Context context;

    public Article(@Nullable Context context) {
        super(context);
        this.context = context;
    }


}
