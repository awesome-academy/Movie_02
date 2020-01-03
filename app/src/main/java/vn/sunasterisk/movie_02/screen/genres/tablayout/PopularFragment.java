package vn.sunasterisk.movie_02.screen.genres.tablayout;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.base.BaseFragment;
import vn.sunasterisk.movie_02.constant.Constant;
import vn.sunasterisk.movie_02.data.model.Popular;
import vn.sunasterisk.movie_02.data.source.MovieDataSource;
import vn.sunasterisk.movie_02.data.source.remote.FetchPopularFromURL;

public class PopularFragment extends BaseFragment
        implements MovieDataSource.OnFetchDataListener<Popular> {
    private RecyclerView mRecyclerPopular;
    private PopularAdapter mAdapter;

    @Override
    protected void registerListener() {

    }

    @Override
    protected void initCoponents(View view) {
        mRecyclerPopular = view.findViewById(R.id.recycler_popular);

        FetchPopularFromURL fetchPopularFromURL = new FetchPopularFromURL();
        fetchPopularFromURL.setListener(this);
        fetchPopularFromURL.execute(Constant.BASE_URL + Constant.URL_POPULAR + Constant.KEY_API);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_popular;
    }

    @Override
    public void onFetchDataSuccess(List<Popular> populars) {
        mAdapter = new PopularAdapter(populars);
        LinearLayoutManager manager = new LinearLayoutManager(
                getContext(),
                RecyclerView.VERTICAL,
                false
        );
        mRecyclerPopular.setLayoutManager(manager);
        mRecyclerPopular.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFetchDataFailure(Exception e) {

    }
}
