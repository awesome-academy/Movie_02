package vn.sunasterisk.movie_02.screen.genres.tablayout.popular;

import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.base.BaseFragment;
import vn.sunasterisk.movie_02.data.model.TrailerMovie;
import vn.sunasterisk.movie_02.data.repository.GenresReponsitory;
import vn.sunasterisk.movie_02.screen.genres.tablayout.GenresAdapter;
import vn.sunasterisk.movie_02.screen.genres.GenresContact;
import vn.sunasterisk.movie_02.screen.genres.GenresPresenter;

public class PopularFragment extends BaseFragment
        implements GenresContact.view, GenresAdapter.OnClickPoplarsListener {
    private RecyclerView mRecyclerPopular;
    private GenresAdapter mAdapter;
    private GenresPresenter mPresenter;

    @Override
    protected void registerListener() {

    }

    @Override
    protected void initCoponents(View view) {
        mRecyclerPopular = view.findViewById(R.id.recycler_popular);

        mAdapter = new GenresAdapter(this);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        mRecyclerPopular.setLayoutManager(manager);
        mRecyclerPopular.setAdapter(mAdapter);

        mPresenter = new GenresPresenter(this, GenresReponsitory.getInstance());
        mPresenter.getPopularMovie();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_popular;
    }

    @Override
    public void onPoplarsClickListener(TrailerMovie popular) {

    }

    @Override
    public void onMovieSucces(List<TrailerMovie> movies) {
        mAdapter.setData(movies);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onMovieFailure(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
