package vn.sunasterisk.movie_02.data.source;

import java.util.List;

public interface MovieDataSource {
    interface OnFetchDataListener<T> {
        void onFetchDataSuccess(List<T> data);

        void onFetchDataFailure(Exception e);
    }

    interface FetchGenresDataSoure {
        void getNowPlayingData(MovieDataSource.OnFetchDataListener listener);

        void getTopRateData(MovieDataSource.OnFetchDataListener listener);

        void getUpComingData(MovieDataSource.OnFetchDataListener listener);

        void getPopularData(MovieDataSource.OnFetchDataListener listener);
    }
}
