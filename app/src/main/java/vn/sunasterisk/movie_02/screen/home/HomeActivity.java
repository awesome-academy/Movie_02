package vn.sunasterisk.movie_02.screen.home;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import vn.sunasterisk.movie_02.R;
import vn.sunasterisk.movie_02.base.BaseActivity;
import vn.sunasterisk.movie_02.screen.favorite.FavoriteFragment;
import vn.sunasterisk.movie_02.screen.genres.GenresFragment;

public class HomeActivity extends BaseActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView mBottomNavigationView;
    private FavoriteFragment mFavoriteFragment;
    private HomeFragment mHomeFragment;
    private GenresFragment mGenresFragment;

    @Override
    protected void registerListener() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void initComponents() {
        mBottomNavigationView = findViewById(R.id.navigation_view);
        FragmentManager manager = getSupportFragmentManager();
        mHomeFragment = new HomeFragment();
        manager.beginTransaction()
                .replace(R.id.frame_container, mHomeFragment)
                .addToBackStack(null).commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.nav_farvorite:
                openFavoriteScreen();
                return true;
            case R.id.nav_home:
                openHomeScreen();
                return true;
            case R.id.nav_genres:
                openMenuScreen();
                return true;
            default:
                return false;
        }
    }

    private void openMenuScreen() {
        mGenresFragment = new GenresFragment();
        addFragment(mGenresFragment);
    }

    private void openHomeScreen() {
        mHomeFragment = new HomeFragment();
        addFragment(mHomeFragment);
    }

    private void openFavoriteScreen() {
        mFavoriteFragment = new FavoriteFragment();
        addFragment(mFavoriteFragment);
    }

    private void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().
                replace(R.id.frame_container, fragment).
                addToBackStack(null).commit();
    }
}
