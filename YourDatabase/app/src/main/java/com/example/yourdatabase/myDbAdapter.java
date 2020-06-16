package com.example.yourdatabase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.IDN;


public class myDbAdapter {
    myDbHelper myhelper;
    public myDbAdapter(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String ID, String Name, String Email, String Mobile)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.ID, ID);
        contentValues.put(myDbHelper.NAME, Name);
        contentValues.put(myDbHelper.EMAIL, Email);
        contentValues.put(myDbHelper.MOBILE, Mobile);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    public String getData()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID,myDbHelper.ID,myDbHelper.NAME,myDbHelper.EMAIL,myDbHelper.MOBILE};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String idty =cursor.getString(cursor.getColumnIndex(myDbHelper.ID));
            String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            String email =cursor.getString(cursor.getColumnIndex(myDbHelper.EMAIL));
            String mobile =cursor.getString(cursor.getColumnIndex(myDbHelper.MOBILE));
            buffer.append(idty + "   " + name + "   " + email + "   " + mobile +" \n");
        }
        return buffer.toString();
    }

    public  int delete(String identit)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] whereArgs ={identit};

        int count =db.delete(myDbHelper.TABLE_NAME ,myDbHelper.ID+" = ?",whereArgs);
        return  count;
    }

    public int updateName(String oldName , String newName)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME,newName);
        String[] whereArgs= {oldName};
        int count =db.update(myDbHelper.TABLE_NAME,contentValues, myDbHelper.NAME+" = ?",whereArgs );
        return count;
    }

    public String getres(String value) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID, myDbHelper.ID, myDbHelper.NAME, myDbHelper.EMAIL, myDbHelper.MOBILE};
        Cursor cursor = db.query(myDbHelper.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
            int cid = cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String idty = cursor.getString(cursor.getColumnIndex(myDbHelper.ID));
            String name = cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            String email = cursor.getString(cursor.getColumnIndex(myDbHelper.EMAIL));
            String mobile = cursor.getString(cursor.getColumnIndex(myDbHelper.MOBILE));
            if(idty.equals(value)) {
                buffer.append(idty + "   " + name + "   " + email + "   " + mobile + " \n");
            }
        }
        return buffer.toString();
    }


  /*  public int updateName(String oldName , String newName)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME,newName);
        String[] whereArgs= {oldName};
        int count =db.update(myDbHelper.TABLE_NAME,contentValues, myDbHelper.NAME+" = ?",whereArgs );
        return count;
    }
    public int updateName(String oldName , String newName)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME,newName);
        String[] whereArgs= {oldName};
        int count =db.update(myDbHelper.TABLE_NAME,contentValues, myDbHelper.NAME+" = ?",whereArgs );
        return count;
    }*/

    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "myDatabase";    // Database Name
        private static final String TABLE_NAME = "myTable";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String UID="_id";
        private static final String ID="Id";     // Column I (Primary Key)
        private static final String NAME = "Name";    //Column II
        private static final String EMAIL= "Email";     // Column III
        private static final String MOBILE= "Mobile";   //  Column IV
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ ID+" INTEGER  , "+ NAME+" VARCHAR(255) ,"+ EMAIL+" VARCHAR(225),"+ MOBILE+" INTEGER(10));";

        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }
    }
}