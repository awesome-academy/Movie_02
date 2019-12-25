package vn.sunasterisk.movie_02.screen.genres;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.base.BaseFragment;
import vn.sunasterisk.movie_02.screen.genres.tablayout.NowPlayingFragment;
import vn.sunasterisk.movie_02.screen.genres.tablayout.PopularFragment;
import vn.sunasterisk.movie_02.screen.genres.tablayout.TopRateFragment;
import vn.sunasterisk.movie_02.screen.genres.tablayout.UpcomingFragment;
import vn.sunasterisk.movie_02.screen.genres.tablayout.ViewPagerAdapter;
import vn.sunasterisk.movie_02.screen.search.SearchActivity;

public class GenresFragment extends BaseFragment
        implements View.OnClickListener {
    private ImageView mImageSearch;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void registerListener() {
        mImageSearch.setOnClickListener(this);
    }

    @Override
    protected void initCoponents(View view) {
        mImageSearch = view.findViewById(R.id.image_genres_search);

        mViewPager = view.findViewById(R.id.view_pager);
        setUpViewPager(mViewPager);

        mTabLayout = view.findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_popular);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_now_playing);
        mTabLayout.getTabAt(2).setIcon(R.drawable.ic_upcoming);
        mTabLayout.getTabAt(3).setIcon(R.drawable.ic_top_rate);
    }

    private void setUpViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new PopularFragment(), getString(R.string.text_popular));
        adapter.addFragment(new NowPlayingFragment(), getString(R.string.text_now_playing));
        adapter.addFragment(new UpcomingFragment(), getString(R.string.text_upcoming));
        adapter.addFragment(new TopRateFragment(), getString(R.string.text_top_rate));
        mViewPager.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_genres;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_genres_search:
                Intent intent = SearchActivity.getIntent(getContext());
                startActivity(intent);
            default:
                break;
        }
    }
}
