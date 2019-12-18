package vn.sunasterisk.movie_02.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        initComponents();
        registerListener();
    }

    protected abstract void registerListener();

    protected abstract void initComponents();

    protected abstract int getLayoutId();
}
