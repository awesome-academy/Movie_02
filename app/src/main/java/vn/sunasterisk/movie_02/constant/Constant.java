package vn.sunasterisk.movie_02.constant;

import vn.sunasterisk.movie_02.BuildConfig;

public class Constant {
    public static final String REQUEST_METHOD_GET = "GET";
    public static final int CONNECT_TIME_OUT = 5000;
    public static final int READ_TIME_OUT = 5000;
    public static final String BREAK_LINE = "\n";
    public static final String KEY_API = BuildConfig.API_KEY;
    public static final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    public static final String URL_POPULAR = "popular?api_key=";
}
