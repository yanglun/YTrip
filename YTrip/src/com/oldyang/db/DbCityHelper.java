
package com.oldyang.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.oldyang.R;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

public class DbCityHelper
{
    private final int BUFFER_SIZE = 400000;
    public static final String DB_NAME = "city.db"; //保存的数据库文件
    public static final String DB_PATH = "/data" + Environment.getDataDirectory().getAbsolutePath() + "/";
    //在手机里存放数据库的位置
    private SQLiteDatabase database;
    private Context context;

    public DbCityHelper(Context context)
    {
        this.context = context;
    }

    public void openDatabase()
    {
        String packageName = context.getPackageName();
        this.database = this.openDatabase(DB_PATH + packageName + "/" + DB_NAME);
    }

    private SQLiteDatabase openDatabase(String dbfile)
    {
        try
        {
            if (!(new File(dbfile).exists()))
            {
                //判断数据库文件是否存在，若不存在则执行导入，否则直接打开数据
                InputStream is = this.context.getResources().openRawResource(R.raw.city); //欲导入的数据
                FileOutputStream fos = new FileOutputStream(dbfile);
                byte[] buffer = new byte[BUFFER_SIZE];
                int count = 0;
                while ((count = is.read(buffer)) > 0)
                {
                    fos.write(buffer, 0, count);
                }
                fos.close();
                is.close();
            }
            SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbfile, null);
            return db;
        }
        catch (FileNotFoundException e)
        {
            Log.e("Database", "File not found");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            Log.e("Database", "IO exception");
            e.printStackTrace();
        }
        return null;
    }

    //do something else here<br>
    public void closeDatabase()
    {
        this.database.close();
    }

    public ArrayList<String> getCity()
    {
       String sql = 
        "select city from \"city\" order by firstpy";
        Cursor cur = database.rawQuery(sql, null);
        if (cur != null)
        {
            int NUM_CITY = cur.getCount();
            ArrayList<String> taxicity = new ArrayList<String>();
            if (cur.moveToFirst())
            {
                do
                {
                    String name = cur.getString(cur.getColumnIndex("city"));
                    taxicity.add(name);
                }
                while (cur.moveToNext());
            }
            return taxicity;
        }
        else
        {
            return null;
        }
    }
}