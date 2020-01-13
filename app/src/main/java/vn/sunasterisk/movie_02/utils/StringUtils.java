package vn.sunasterisk.movie_02.utils;

import vn.sunasterisk.movie_02.BuildConfig;
import vn.sunasterisk.movie_02.constant.Constant;

public class StringUtils {
    public static String getImageApi(String path) {
        return String.format("%s%s", Constant.BASE_URL_IMAGE, path);
    }
    public static String getDataFromURL(String path){
        return String.format("%s%s%s", Constant.BASE_URL,path, BuildConfig.API_KEY);
    }
}
