package vn.sunasterisk.movie_02.data.model;

import vn.sunasterisk.movie_02.utils.StringUtils;

public class TrailerMovie {
    private String mPopularity;
    private String mVideo;
    private String mPosterPath;
    private String mId;
    private String mBackdropPath;
    private String mTitle;
    private String mVoteAverage;
    private String mOverView;
    private String mReleaseDate;

    public TrailerMovie() {
    }

    public TrailerMovie(String popularity, String video, String posterPath, String id,
                        String backdropPath, String title, String voteAverage, String overView,
                        String releaseDate) {
        mPopularity = popularity;
        mVideo = video;
        mPosterPath = posterPath;
        mId = id;
        mBackdropPath = backdropPath;
        mTitle = title;
        mVoteAverage = voteAverage;
        mOverView = overView;
        mReleaseDate = releaseDate;
    }

    public String getMovieImageApi() {
        return StringUtils.getImageApi(mPosterPath);
    }

    public String getMovieImageBackDropApi() {
        return StringUtils.getImageApi(mBackdropPath);
    }

    public String getPopularity() {
        return mPopularity;
    }

    public void setPopularity(String popularity) {
        mPopularity = popularity;
    }

    public String getVideo() {
        return mVideo;
    }

    public void setVideo(String video) {
        mVideo = video;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        mBackdropPath = backdropPath;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        mVoteAverage = voteAverage;
    }

    public String getOverView() {
        return mOverView;
    }

    public void setOverView(String overView) {
        mOverView = overView;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }
}
