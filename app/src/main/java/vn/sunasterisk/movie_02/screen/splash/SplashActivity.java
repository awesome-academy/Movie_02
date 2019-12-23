package vn.sunasterisk.movie_02.screen.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.IntDef;
import androidx.annotation.Nullable;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.base.BaseActivity;
import vn.sunasterisk.movie_02.screen.home.HomeActivity;

public class SplashActivity extends BaseActivity {
    private static final long DELAY_TIME = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, DELAY_TIME);
    }

    @Override
    protected void registerListener() {

    }

    @Override
    protected void initComponents() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }
}
