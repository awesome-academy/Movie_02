package vn.sunasterisk.movie_02.constant;

import androidx.annotation.StringDef;

@StringDef({MovieEntity.MOVIE, MovieEntity.POPULARITY,
        MovieEntity.VIDEO, MovieEntity.POSTERPATH,
        MovieEntity.ID, MovieEntity.BACKDROPPATH,
        MovieEntity.TITLE, MovieEntity.VOTEAVERAGE,
        MovieEntity.OVERVIEW, MovieEntity.RELEASEDATE})

public @interface MovieEntity {
    String MOVIE = "results";
    String POPULARITY = "popularity";
    String VIDEO = "video";
    String POSTERPATH = "poster_path";
    String ID = "id";
    String BACKDROPPATH = "backdrop_path";
    String TITLE = "title";
    String VOTEAVERAGE = "vote_average";
    String OVERVIEW = "overview";
    String RELEASEDATE = "release_date";
}
