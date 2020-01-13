package vn.sunasterisk.movie_02.constant;

import androidx.annotation.IntDef;
import androidx.annotation.StringDef;

import java.security.Key;

@StringDef({MovieEntity.MOVIE, MovieEntity.POPULARITY,
        MovieEntity.VIDEO, MovieEntity.POSTERPATH,
        MovieEntity.ID, MovieEntity.BACKDROPPATH,
        MovieEntity.TITLE, MovieEntity.VOTEAVERAGE,
        MovieEntity.OVERVIEW, MovieEntity.RELEASEDATE})
@IntDef({MovieEntity.REQUEST_RESULT})
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

    int REQUEST_RESULT = 1;
}
