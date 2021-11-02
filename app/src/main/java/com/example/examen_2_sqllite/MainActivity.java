package com.example.examen_2_sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examen_2_sqllite.db.DB;

public class MainActivity extends AppCompatActivity {

    private Button button_ingresar;
    private EditText editText_user, editText_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();

        init_elements();
        init_control_ingresar();

        try {
            // create database
            DB db = new DB(this);
            SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
            if (sqLiteDatabase != null)
                Toast.makeText(this, "DB created", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "DB not created", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Log.e("[create data base] ", "onCreate: ", e );
        }

    }

    private void init_elements() {
        button_ingresar = findViewById(R.id.button_ingresar);
        editText_user = findViewById(R.id.editText_user);
        editText_password = findViewById(R.id.editText_password);
    }

    private void init_control_ingresar() {
        button_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_principal = new Intent(MainActivity.this, MenuPrincipal.class);
                startActivity(menu_principal);
            }
        });
    }

}