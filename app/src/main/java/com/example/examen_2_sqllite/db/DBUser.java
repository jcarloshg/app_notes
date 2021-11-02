package com.example.examen_2_sqllite.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.security.keystore.StrongBoxUnavailableException;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.examen_2_sqllite.entities.User;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

public class DBUser extends DB {

    private Context context;

    public DBUser(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insert_user(User user) {
        long user_id = -1;

        try {
            DB db = new DB(this.context);
            SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(DB.USER_NICKNAME, user.getNick_name());
            contentValues.put(DB.USER_PASSWORD, user.getPassword());
            contentValues.put(DB.USER_NAME, user.getName());

            user_id = sqLiteDatabase.insert(DB.TABLE_USER, null, contentValues);

        } catch (Exception e) {
            Log.e("[insert_user] ", " ", e);
        }

        return user_id;
    }

    public User get_user(String name, String password) {

        User user = null;

        try {
            DB db = new DB(this.context);
            SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

            Cursor cursor = sqLiteDatabase.rawQuery(
                    "SELECT * FROM " + DB.TABLE_USER + " WHERE " + DB.USER_NICKNAME + " = '" + name + "' AND " + DB.USER_PASSWORD + " = '" + password + "';",
                    null
            );

            if (cursor.moveToFirst()) {
                final int column_user_id = cursor.getColumnIndex(DB.USER_ID);
                final int column_user_nickName = cursor.getColumnIndex(DB.USER_NICKNAME);
                final int column_user_password = cursor.getColumnIndex(DB.USER_PASSWORD);
                final int column_user_name = cursor.getColumnIndex(DB.USER_NAME);

                user = new User
                        (
                                cursor.getInt(column_user_id),
                                cursor.getString(column_user_nickName),
                                cursor.getString(column_user_password),
                                cursor.getString(column_user_name)
                        );
            }

        } catch (Exception e) {
            Log.e("[insert_user] ", " ", e);
        }

        return user;
    }
}
