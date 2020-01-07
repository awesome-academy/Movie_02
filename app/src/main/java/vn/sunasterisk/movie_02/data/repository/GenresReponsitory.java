package vn.sunasterisk.movie_02.data.repository;

import vn.sunasterisk.movie_02.data.source.MovieDataSource;
import vn.sunasterisk.movie_02.data.source.remote.GenresMovieDataSource;

public class GenresReponsitory {
    private static GenresReponsitory sInstance;
    private GenresMovieDataSource mGenresMovieDataSource;

    public GenresReponsitory(GenresMovieDataSource genresMovieDataSource) {
        mGenresMovieDataSource = genresMovieDataSource;
    }

    public static GenresReponsitory getInstance() {
        if (sInstance == null) {
            sInstance = new GenresReponsitory(GenresMovieDataSource.getInstance());
        }
        return sInstance;
    }

    public void getNowPlayingMovieList(MovieDataSource.OnFetchDataListener listener) {
        mGenresMovieDataSource.getNowPlayingData(listener);
    }

    public void getPopularMovieList(MovieDataSource.OnFetchDataListener listener) {
        mGenresMovieDataSource.getPopularData(listener);
    }

    public void getTopRateMovieList(MovieDataSource.OnFetchDataListener listener) {
        mGenresMovieDataSource.getTopRateData(listener);
    }

    public void getUpComingMovieList(MovieDataSource.OnFetchDataListener listener) {
        mGenresMovieDataSource.getUpComingData(listener);
    }
}
