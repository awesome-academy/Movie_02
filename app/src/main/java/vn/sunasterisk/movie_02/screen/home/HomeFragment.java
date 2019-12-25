package vn.sunasterisk.movie_02.screen.home;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.base.BaseFragment;
import vn.sunasterisk.movie_02.screen.search.SearchActivity;

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private ImageView mImageSearch;

    @Override
    protected void registerListener() {
        mImageSearch.setOnClickListener(this);
    }

    @Override
    protected void initCoponents(View view) {
        mImageSearch = view.findViewById(R.id.image_home_search);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_home_search:
                Intent intent = SearchActivity.getIntent(getContext());
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
