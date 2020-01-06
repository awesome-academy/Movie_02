package vn.sunasterisk.movie_02.constant;

import androidx.annotation.StringDef;

@StringDef({NowPlayingEntity.NOWPLAYING, NowPlayingEntity.POPULARITY,
        NowPlayingEntity.VIDEO, NowPlayingEntity.POSTERPATH,
        NowPlayingEntity.ID, NowPlayingEntity.BACKDROPPATH,
        NowPlayingEntity.TITLE, NowPlayingEntity.VOTEAVERAGE,
        NowPlayingEntity.OVERVIEW, NowPlayingEntity.RELEASEDATE})
public @interface NowPlayingEntity {
    String NOWPLAYING = "results";
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
