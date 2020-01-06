package vn.sunasterisk.movie_02.screen.genres.tablayout.nowplaying;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.base.BaseFragment;
import vn.sunasterisk.movie_02.constant.Constant;
import vn.sunasterisk.movie_02.data.model.NowPlaying;
import vn.sunasterisk.movie_02.data.source.MovieDataSource;
import vn.sunasterisk.movie_02.data.source.remote.FetchNowPlayingFromURL;
import vn.sunasterisk.movie_02.screen.genres.tablayout.nowplaying.NowPlayingAdapter;

public class NowPlayingFragment extends BaseFragment implements MovieDataSource.OnFetchDataListener<NowPlaying> {
    private RecyclerView mRecyclerView;
    private NowPlayingAdapter mAdapter;

    @Override
    protected void registerListener() {

    }

    @Override
    protected void initCoponents(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_now_playing);

        FetchNowPlayingFromURL fetchNowPlayingFromURL = new FetchNowPlayingFromURL();
        fetchNowPlayingFromURL.setListener(this);
        fetchNowPlayingFromURL.execute(Constant.BASE_URL + Constant.URL_NOW_PLAYING + Constant.KEY_API);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_now_playing;
    }

    @Override
    public void onFetchDataSuccess(List<NowPlaying> data) {
        mAdapter = new NowPlayingAdapter(data);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFetchDataFailure(Exception e) {

    }
}
