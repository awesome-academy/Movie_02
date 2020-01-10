package vn.sunasterisk.movie_02.data.source.remote;

import vn.sunasterisk.movie_02.constant.Constant;
import vn.sunasterisk.movie_02.data.source.MovieDataSource;
import vn.sunasterisk.movie_02.utils.StringUtils;

public class GenresMovieDataSource implements MovieDataSource.FetchGenresDataSoure {
    private static GenresMovieDataSource sInstance;

    private GenresMovieDataSource() {
    }

    public static GenresMovieDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new GenresMovieDataSource();
        }
        return sInstance;
    }

    @Override
    public void getNowPlayingData(MovieDataSource.OnFetchDataListener listener) {
        FetchGenresFromURL fetchGenresMovieFromUrl = new FetchGenresFromURL(listener);
        fetchGenresMovieFromUrl.execute(StringUtils.getDataFromURL(Constant.URL_NOW_PLAYING));
    }

    @Override
    public void getTopRateData(MovieDataSource.OnFetchDataListener listener) {
        FetchGenresFromURL fetchGenresMovieFromUrl = new FetchGenresFromURL(listener);
        fetchGenresMovieFromUrl.execute(StringUtils.getDataFromURL(Constant.URL_TOP_RATE));
    }

    @Override
    public void getUpComingData(MovieDataSource.OnFetchDataListener listener) {
        FetchGenresFromURL fetchGenresMovieFromUrl = new FetchGenresFromURL(listener);
        fetchGenresMovieFromUrl.execute(StringUtils.getDataFromURL(Constant.URL_UP_COMING));
    }

    @Override
    public void getPopularData(MovieDataSource.OnFetchDataListener listener) {
        FetchGenresFromURL fetchGenresMovieFromUrl = new FetchGenresFromURL(listener);
        fetchGenresMovieFromUrl.execute(StringUtils.getDataFromURL(Constant.URL_POPULAR));
    }
}
