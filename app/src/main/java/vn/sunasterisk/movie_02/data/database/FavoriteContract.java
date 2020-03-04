package vn.sunasterisk.movie_02.data.database;

import android.provider.BaseColumns;

public final class FavoriteContract {
    private FavoriteContract() {

    }

    public static class FavoriteEntry implements BaseColumns {
        public static final String TABLE_NAME = "favorite";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_TITLE = "tittle";
        public static final String COLUMN_POSTER_PATH = "poster";
    }
}
