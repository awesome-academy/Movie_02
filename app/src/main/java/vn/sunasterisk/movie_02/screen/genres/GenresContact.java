package vn.sunasterisk.movie_02.screen.genres;

import java.util.List;

import vn.sunasterisk.movie_02.data.model.TrailerMovie;

public interface GenresContact {
    interface view {
        void onMovieSucces(List<TrailerMovie> movies);

        void onMovieFailure(String message);
    }

    interface genresPresenter {
        void getNowPlayingMovie();

        void getPopularMovie();

        void getUpComingMovie();

        void getTopRateMovie();
    }
}
