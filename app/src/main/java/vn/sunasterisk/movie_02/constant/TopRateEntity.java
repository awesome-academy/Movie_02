package vn.sunasterisk.movie_02.constant;

import androidx.annotation.StringDef;

@StringDef({TopRateEntity.TOPRATE, TopRateEntity.POPULARITY,
        TopRateEntity.VIDEO, TopRateEntity.POSTERPATH,
        TopRateEntity.ID, TopRateEntity.BACKDROPPATH,
        TopRateEntity.TITLE, TopRateEntity.VOTEAVERAGE,
        TopRateEntity.OVERVIEW, TopRateEntity.RELEASEDATE})
public @interface TopRateEntity {
    String TOPRATE = "results";
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
