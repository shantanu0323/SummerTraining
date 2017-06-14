package shantanu.summertraining;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by SHAAN on 13-06-17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "COURSES";

    public DatabaseHelper(Context context) {
        super(context, "DATABASE", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                "id INTEGER PRIMARY KEY, " +
                "title TEXT, " +
                "price INTEGER, " +
                "hours INTEGER) ");

        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (101, 'Android', 7000, 69);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (201, 'BigData', 10000, 75);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES (301, 'Web development', 6000, 56);");

    }

    public void createNewDatabase(Course courses) throws Exception {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("title", courses.getTitle());
        cv.put("price", courses.getPrice());
        cv.put("hours", courses.getHours());
        try {
            db.insert(TABLE_NAME, null, cv);
        } catch (Exception e) {
            throw e;
        }
        Log.i(TAG, "createNewDatabase: DataInserted");
        db.close();
    }

    public ArrayList<Course> getAllCourses() {
        ArrayList<Course> courses = null;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, title, price, hours FROM " + TABLE_NAME + ";",
                null);
        if (cursor.moveToFirst()) {
            courses = new ArrayList<>();
            do {
                courses.add(new Course(cursor.getString(1), cursor.getInt(2), cursor.getInt(3)));
            } while (cursor.moveToNext());
        }

        return courses;
    }

    public Course getCourse(String title) {
        Course course = null;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, title, price, hrs FROM " + TABLE_NAME + " WHERE " +
                "title=?;", new String[]{title});
        if (cursor.moveToFirst()) {
            course = new Course(cursor.getInt(0), cursor.getString(1), cursor.getInt(2),
                    cursor.getInt(3));
        }
        return course;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
