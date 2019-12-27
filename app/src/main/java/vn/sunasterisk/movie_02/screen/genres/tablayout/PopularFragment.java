package vn.sunasterisk.movie_02.screen.genres.tablayout;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.base.BaseFragment;
import vn.sunasterisk.movie_02.constant.Constant;
import vn.sunasterisk.movie_02.data.model.Popular;
import vn.sunasterisk.movie_02.data.source.PopularDataSource;
import vn.sunasterisk.movie_02.data.source.remote.FetchPopularFromURL;

public class PopularFragment extends BaseFragment
        implements PopularDataSource.OnFetchDataListener<Popular> {
    private RecyclerView mRecyclerPopular;

    @Override
    protected void registerListener() {

    }

    @Override
    protected void initCoponents(View view) {
        mRecyclerPopular = view.findViewById(R.id.recycler_popular);
        FetchPopularFromURL fetchPopularFromURL = new FetchPopularFromURL();
        fetchPopularFromURL.setListener(this);
        fetchPopularFromURL.execute(Constant.BASE_URL);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_popular;
    }

    @Override
    public void onFetchDataSuccess(List<Popular> populars) {

    }

    @Override
    public void onFetchDataFailure(Exception e) {

    }
}
