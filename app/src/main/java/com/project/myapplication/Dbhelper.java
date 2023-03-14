package com.project.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class Dbhelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "amigos.db";
    public static final String TABLE_AMIGOS = "amigos";

    private static final String COLUMN_ID = "_id";

    private static final String COLUMN_NAME =  "nombre";

    private static final String COLUMN_AGE =  "edad";

    private static final String COLUMN_CIUDAD =  "ciudad";
    private final Context context;


    public Dbhelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_AMIGOS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME + " TEXT NOT NULL," +
                COLUMN_AGE + " TEXT NOT NULL," +
                COLUMN_CIUDAD + "TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_AMIGOS);
        onCreate(sqLiteDatabase);

    }

    void addFriend(String nombre, String edad, String ciudad){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, nombre);
        cv.put(COLUMN_AGE, ageFactorial(edad));
        cv.put(COLUMN_CIUDAD, ciudad);


        long result  = db.insert(TABLE_AMIGOS, null, cv);
        if(result == -1){

            Toast.makeText(context, "Error agregando amigo.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "amigo agregado exitosamente.", Toast.LENGTH_SHORT).show();
        }
    }

    public static int ageFactorial(String edad){
        int num = Integer.parseInt(edad);
        if (num == 0){
            return 1;
        }
        else {
            return num * ageFactorial(Integer.toString(num-1));
        }
    }
}
