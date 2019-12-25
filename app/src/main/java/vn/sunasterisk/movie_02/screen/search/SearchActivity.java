package vn.sunasterisk.movie_02.screen.search;

import android.content.Context;
import android.content.Intent;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.base.BaseActivity;

public class SearchActivity extends BaseActivity {
    @Override
    protected void registerListener() {

    }

    @Override
    protected void initComponents() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        return intent;
    }
}
