package vn.sunasterisk.movie_02.screen.genres;

import java.util.List;

import vn.sunasterisk.movie_02.data.repository.GenresReponsitory;
import vn.sunasterisk.movie_02.data.source.MovieDataSource;

public class GenresPresenter implements GenresContact.genresPresenter,MovieDataSource.OnFetchDataListener {
    private GenresContact.view mView;
    private GenresReponsitory mReponsitory;

    public GenresPresenter(GenresContact.view view, GenresReponsitory genresMovieReponsitory) {
        mView = view;
        mReponsitory = genresMovieReponsitory;
    }

    @Override
    public void getNowPlayingMovie() {
        mReponsitory.getNowPlayingMovieList(this);
    }

    @Override
    public void getPopularMovie() {
        mReponsitory.getPopularMovieList(this);
    }

    @Override
    public void getUpComingMovie() {
        mReponsitory.getUpComingMovieList(this);
    }

    @Override
    public void getTopRateMovie() {
        mReponsitory.getTopRateMovieList(this);
    }

    @Override
    public void onFetchDataSuccess(List data) {
        mView.onMovieSucces(data);
    }

    @Override
    public void onFetchDataFailure(Exception e) {
        mView.onMovieFailure(e.getMessage());
    }
}
