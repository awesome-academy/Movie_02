package vn.sunasterisk.movie_02.constant;

import androidx.annotation.StringDef;

@StringDef({PopularEntity.POPULAR, PopularEntity.POPULARITY,
        PopularEntity.VIDEO, PopularEntity.POSTERPATH,
        PopularEntity.ID, PopularEntity.BACKDROPPATH,
        PopularEntity.TITLE, PopularEntity.VOTEAVERAGE,
        PopularEntity.OVERVIEW, PopularEntity.RELEASEDATE})

public @interface PopularEntity {
    String POPULAR = "results";
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
