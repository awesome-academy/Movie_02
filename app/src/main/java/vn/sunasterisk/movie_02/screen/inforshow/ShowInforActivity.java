package vn.sunasterisk.movie_02.screen.inforshow;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.base.BaseActivity;
import vn.sunasterisk.movie_02.constant.MovieEntity;

public class ShowInforActivity extends BaseActivity {
    private CollapsingToolbarLayout mLayout;
    private TextView mTextTitle;
    private TextView mTextVote;
    private TextView mTextDate;
    private TextView mTextOverView;
    private ImageView mImageMovie;

    @Override
    protected void registerListener() {

    }

    @Override
    protected void initComponents() {
        mLayout = findViewById(R.id.layout_collapsing);
        mTextTitle = findViewById(R.id.text_title_infor);
        mTextVote = findViewById(R.id.text_vote);
        mTextDate = findViewById(R.id.text_date);
        mTextOverView = findViewById(R.id.over_view);
        mImageMovie = findViewById(R.id.back_drop_image);

        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        mLayout.setTitleEnabled(true);
        mLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);

        receiveInformation();
    }

    private void receiveInformation() {
        Intent intent = getIntent();
        String title = intent.getStringExtra(MovieEntity.TITLE);
        String vote = intent.getStringExtra(MovieEntity.VOTEAVERAGE);
        String date = intent.getStringExtra(MovieEntity.RELEASEDATE);
        String overView = intent.getStringExtra(MovieEntity.OVERVIEW);
        String imageURL = intent.getStringExtra(MovieEntity.BACKDROPPATH);

        mLayout.setTitle(title);
        mTextTitle.setText(title);
        mTextVote.setText(vote);
        mTextDate.setText(date);
        mTextOverView.setText(overView);
        Glide.with(ShowInforActivity.this).load(imageURL)
                .placeholder(R.drawable.loading_shape).into(mImageMovie);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_infor;
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, ShowInforActivity.class);
        return intent;
    }
}
