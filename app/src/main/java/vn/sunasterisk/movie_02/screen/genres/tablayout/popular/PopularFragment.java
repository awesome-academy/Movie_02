package vn.sunasterisk.movie_02.screen.genres.tablayout.popular;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.base.BaseFragment;
import vn.sunasterisk.movie_02.constant.MovieEntity;
import vn.sunasterisk.movie_02.data.model.TrailerMovie;
import vn.sunasterisk.movie_02.data.repository.GenresReponsitory;
import vn.sunasterisk.movie_02.screen.genres.GenresContact;
import vn.sunasterisk.movie_02.screen.genres.GenresPresenter;
import vn.sunasterisk.movie_02.screen.genres.tablayout.GenresAdapter;
import vn.sunasterisk.movie_02.screen.inforshow.ShowInforActivity;

public class PopularFragment extends BaseFragment
        implements GenresContact.view, GenresAdapter.OnClickGenresListener {
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
    public void onMovieSucces(List<TrailerMovie> movies) {
        mAdapter.setData(movies);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onMovieFailure(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickGenresListener(TrailerMovie genres) {
        Intent intent = ShowInforActivity.getIntent(getContext());
        intent.putExtra(MovieEntity.TITLE, genres.getTitle());
        intent.putExtra(MovieEntity.VOTEAVERAGE, genres.getVoteAverage());
        intent.putExtra(MovieEntity.POPULARITY,genres.getPopularity());
        intent.putExtra(MovieEntity.RELEASEDATE, genres.getReleaseDate());
        intent.putExtra(MovieEntity.OVERVIEW, genres.getOverView());
        intent.putExtra(MovieEntity.BACKDROPPATH, genres.getMovieImageBackDropApi());
        startActivity(intent);
    }
}
