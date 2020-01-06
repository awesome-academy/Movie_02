package vn.sunasterisk.movie_02.screen.genres.tablayout.toprate;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.base.BaseFragment;
import vn.sunasterisk.movie_02.constant.Constant;
import vn.sunasterisk.movie_02.data.model.TopRate;
import vn.sunasterisk.movie_02.data.source.MovieDataSource;
import vn.sunasterisk.movie_02.data.source.remote.FetchTopRateFromURL;

public class TopRateFragment extends BaseFragment implements MovieDataSource.OnFetchDataListener<TopRate> {
    private RecyclerView mRecyclerView;
    private TopRateAdapter mAdapter;

    @Override
    protected void registerListener() {

    }

    @Override
    protected void initCoponents(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_top_rate);

        FetchTopRateFromURL fetchTopRateFromURL = new FetchTopRateFromURL();
        fetchTopRateFromURL.setListener(this);
        fetchTopRateFromURL.execute(Constant.BASE_URL + Constant.URL_TOP_RATE + Constant.KEY_API);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_top_rate;
    }

    @Override
    public void onFetchDataSuccess(List<TopRate> data) {
        mAdapter = new TopRateAdapter(data);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFetchDataFailure(Exception e) {

    }
}
