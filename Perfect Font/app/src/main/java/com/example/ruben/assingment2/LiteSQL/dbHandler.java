package com.example.ruben.assingment2.LiteSQL;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ruben.assingment2.LiteSQL.Comment;

public class dbHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ccommentDB.db";
    public static final String TABLE_COMMENTS = "comments";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_COMMENT = "comment";

    public dbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_COMMENTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_COMMENT + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(db);
    }

    public void addComment(Comment comment){
        ContentValues values = new ContentValues();
        values.put(COLUMN_COMMENT, comment.getComments());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_COMMENTS, null, values);
        db.close();
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_COMMENTS + " WHERE 1";

        Cursor recordSet = db.rawQuery(query, null);
        recordSet.moveToFirst();

        while (!recordSet.isAfterLast()) {
            if (recordSet.getString(recordSet.getColumnIndex("comment")) != null) {
                dbString += recordSet.getString(recordSet.getColumnIndex("comment"));
                dbString += "\n";
            }
            recordSet.moveToNext();
        }
        db.close();
        return dbString;
    }
}
