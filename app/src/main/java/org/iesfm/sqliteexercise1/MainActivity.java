package org.iesfm.sqliteexercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private DBHelper dbHelper;

    private String database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void crearBaseDatos(View v) {
        EditText etDatosIntroducidos = (EditText) findViewById(R.id.etBaseDatosIntroducidos);
        database = etDatosIntroducidos.getText().toString();
        dbHelper = new DBHelper(this, database + ".sqlite", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.close();
    }

    public void crearTabla(View v) {
        EditText etTabla = (EditText) findViewById(R.id.etCrearTabla);

        String error = "La sentencia se ha ejecutado correctamente.";
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        try {
            db.execSQL(etTabla.getText().toString());
        } catch (SQLiteException e) {
            error = e.getMessage();
        }

        etTabla.setText("");
    }
}