package vn.sunasterisk.movie_02.data.source;

import java.util.List;

public interface PopularDataSource {
    interface OnFetchDataListener<T> {
        void onFetchDataSuccess(List<T> data);

        void onFetchDataFailure(Exception e);
    }
}
