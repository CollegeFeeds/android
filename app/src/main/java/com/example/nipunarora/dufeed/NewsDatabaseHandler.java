package com.example.nipunarora.dufeed;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

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

    /********************** Data Insertion,Deletion and Extraction  Methods *********************************/

    //Insertion
    public void addBanner(NewsBanner banner)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_TITLE,banner.title);
        values.put(KEY_IMAGEURL,banner.image_url);
        values.put(KEY_NEWSURL,banner.news_url);
        db.insert(TABLE_NEWS, null, values);
        db.close();

    }
    //Getter
    public NewsBanner getBanner(String title)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NEWS, new String[]{KEY_TITLE,
                        KEY_IMAGEURL, KEY_NEWSURL},  KEY_TITLE + "=?",
                new String[] { title }, null, null, null, null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            return new NewsBanner(cursor.getString(0),cursor.getString(1),cursor.getString(2));
        }
        else
        {
            return null;
        }
    }

    //Get all the banners in an arraylist
    public ArrayList<NewsBanner> getBannerList()
    {
        ArrayList<NewsBanner> QuerySet=new ArrayList<NewsBanner>();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NEWS, new String[]{KEY_TITLE,
                        KEY_IMAGEURL, KEY_NEWSURL}, null,
                null, null, null, null, null);
        //Check for null cursor
        if (cursor!=null)
        {
            cursor.moveToFirst();
            int row_count = cursor.getCount();
            for(int i=0;i<row_count;++i)
            {
                QuerySet.add(new NewsBanner(cursor.getString(0),cursor.getString(1),cursor.getString(2)));
                cursor.moveToNext();
                //The above method invocation may reach null at the end of a particular iteration
            }
            return QuerySet;
        }

        else {
            return null;
        }
    }

    //End of Getter

    //Deletion
    public void deleteBanner(NewsBanner banner) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NEWS, KEY_TITLE + " = ?",
                new String[]{banner.title});
        db.close();
    }


    /////////////////No need of update function in the given case///////////////
   /* public int updateHeadline(NewsBanner banner, String title) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE,title);

        // updating row
        Integer status= db.update(TABLE_USERINFO, values, KEY_LINKEDINKEY + " = ?",
                new String[]{userInfoDb.getLinkedinkey()});
        db.close();
        return status;
    }*/


}
