package com.example.nipunarora.dufeed;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nipunarora on 16/02/17.
 */
public class NewsDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Du_Feed";
    private static final String TABLE_NEWS = "News";

    /************************** DEFINING COLUMNS FOR DATABASE ********************/
    private static final String KEY_TITLE = "Title";
    private static final String KEY_NEWSURL = "News url";
    private static final String KEY_IMAGEURL="Image url";
    /*************************** END OF COLUMN DEFINATION **********************/

    //Constructor
    public NewsDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NEWS + "("
                + KEY_TITLE + " TEXT," + KEY_NEWSURL + " TEXT," + KEY_IMAGEURL + " TEXT"+")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NEWS);

        // Create tables again
        onCreate(db);
    }
}
