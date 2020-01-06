package vn.sunasterisk.movie_02.constant;

import androidx.annotation.StringDef;

@StringDef({UpComingEntity.UPCOMING, UpComingEntity.POPULARITY,
        UpComingEntity.VIDEO, UpComingEntity.POSTERPATH,
        UpComingEntity.ID, UpComingEntity.BACKDROPPATH,
        UpComingEntity.TITLE, UpComingEntity.VOTEAVERAGE,
        UpComingEntity.OVERVIEW, UpComingEntity.RELEASEDATE})
public @interface UpComingEntity {
    String UPCOMING = "results";
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
