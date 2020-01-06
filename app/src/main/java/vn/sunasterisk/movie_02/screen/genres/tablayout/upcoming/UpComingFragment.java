package vn.sunasterisk.movie_02.screen.genres.tablayout.upcoming;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.base.BaseFragment;
import vn.sunasterisk.movie_02.constant.Constant;
import vn.sunasterisk.movie_02.data.model.UpComing;
import vn.sunasterisk.movie_02.data.source.MovieDataSource;
import vn.sunasterisk.movie_02.data.source.remote.FetchUpComingFromURL;

public class UpComingFragment extends BaseFragment implements MovieDataSource.OnFetchDataListener<UpComing> {
    private RecyclerView mRecyclerView;
    private UpComingAdapter mAdapter;

    @Override
    protected void registerListener() {

    }

    @Override
    protected void initCoponents(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_up_coming);

        FetchUpComingFromURL fetchUpComingFromURL = new FetchUpComingFromURL();
        fetchUpComingFromURL.setListener(this);
        fetchUpComingFromURL.execute(Constant.BASE_URL + Constant.URL_UP_COMING + Constant.KEY_API);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_upcoming;
    }

    @Override
    public void onFetchDataSuccess(List<UpComing> data) {
        mAdapter = new UpComingAdapter(data);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFetchDataFailure(Exception e) {

    }
}
