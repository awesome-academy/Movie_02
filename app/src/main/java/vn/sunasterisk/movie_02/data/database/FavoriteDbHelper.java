package vn.sunasterisk.movie_02.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import vn.sunasterisk.movie_02.data.model.TrailerMovie;

public class FavoriteDbHelper extends SQLiteOpenHelper {
    private Context mContext;
    private static final String DATABASE_NAME = "favorite.db";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_ENTRIES = " CREATE TABLE " + FavoriteContract.FavoriteEntry.TABLE_NAME + "(" +
            FavoriteContract.FavoriteEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FavoriteContract.FavoriteEntry.COLUMN_ID + " INTEGER," +
            FavoriteContract.FavoriteEntry.COLUMN_TITLE + " TEXT," +
            FavoriteContract.FavoriteEntry.COLUMN_POSTER_PATH + " TEXT NOT NULL"
            + ")";
    private static final String SQL_DELETE_ENTRIES = " DROP TABLE IF EXISTS " + FavoriteContract.FavoriteEntry.TABLE_NAME;

    public FavoriteDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void insertTrailer(TrailerMovie trailerMovie) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FavoriteContract.FavoriteEntry.COLUMN_ID, trailerMovie.getId());
        values.put(FavoriteContract.FavoriteEntry.COLUMN_TITLE, trailerMovie.getTitle());
        values.put(FavoriteContract.FavoriteEntry.COLUMN_POSTER_PATH, trailerMovie.getPosterPath());
        long newRowID = database.insert(FavoriteContract.FavoriteEntry.TABLE_NAME, null, values);

        if (newRowID == -1) {
            Toast.makeText(mContext, "Insert Failure", Toast.LENGTH_SHORT).show();
        } else Toast.makeText(mContext, "Insert Success", Toast.LENGTH_SHORT).show();
        database.close();
    }

    public void deleteTrailer(int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(FavoriteContract.FavoriteEntry.TABLE_NAME, FavoriteContract.FavoriteEntry.COLUMN_ID + "=" + id, null);
    }
}
