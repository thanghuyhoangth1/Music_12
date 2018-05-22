package trungtamgiasubaoanh.giasu.com.imusic.screen.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import trungtamgiasubaoanh.giasu.com.imusic.BaseActivity;
import trungtamgiasubaoanh.giasu.com.imusic.R;
import trungtamgiasubaoanh.giasu.com.imusic.screen.main.adapter.MainAdapter;

public class MainActivity extends BaseActivity {
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    public int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    public void initVariable(Bundle savedInstanceState) {
        //find view
        mToolbar = findViewById(R.id.tool_bar);
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);
        //set up view
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        MainAdapter tabLayoutAdapter = new MainAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(tabLayoutAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        
    }
}
