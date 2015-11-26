package com.example.kallen.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.Formatter;
import java.util.Vector;

/**
 * Created by Kallen on 11/25/2015.
 */
public class DBAdapter extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dragon_slayer";
    private static final String TABLE_NAME = "user_data";
    private static final int DATABASE_VERSION = 2;
    public Vector<String[]> attributes = makeAttributes();
    public String str = createTableCommand();

    public DBAdapter(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(createTableCommand());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v("USER", "Table refreshed");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    long addNewEntry(Vector<String[]> updateAttributes) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        for (int i = 0; i < updateAttributes.size(); i++) {
            values.put(updateAttributes.get(i)[0], updateAttributes.get(i)[1]);
        }

        long id = db.insert(TABLE_NAME, null, values);
        db.close();
        return id;
    }

    /**
     * Make the table's attributes.
     * @return Make the table's attributes.
     */

    private Vector<String[]> makeAttributes(){
        Vector<String[]> attributes = new Vector<String[]>();
        attributes.add(new String[]{"_id", "INTEGER PRIMARY KEY AUTOINCREMENT"});
        attributes.add(new String[]{"_name", "TEXT"});
        attributes.add(new String[]{"_password", "TEXT"});
        attributes.add(new String[]{"_occupation", "TEXT"});
        attributes.add(new String[]{"_experience", "INTEGER"});
        attributes.add(new String[]{"_skills", "TEXT"});
        attributes.add(new String[]{"_fame", "TEXT"});
        attributes.add(new String[]{"_guild", "TEXT"});
        return attributes;
    }

    /**
     * Make create table command.
     * @return Create table command.
     */
    private String createTableCommand(){
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("CREATE TABLE %s ( ", TABLE_NAME);
        for (int i = 0; i < attributes.size(); i++) {
            formatter.format("%s %s, ", attributes.get(i)[0], attributes.get(i)[1]);
        }
        if (attributes.size() != 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
        formatter.format(" );");
        formatter.close();
        return sb.toString();
    }
}
