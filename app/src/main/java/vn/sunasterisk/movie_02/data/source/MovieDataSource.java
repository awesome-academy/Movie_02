package vn.sunasterisk.movie_02.data.source;

import java.util.List;

public interface MovieDataSource {
    interface OnFetchDataListener<T> {
        void onFetchDataSuccess(List<T> data);

        void onFetchDataFailure(Exception e);
    }
}
