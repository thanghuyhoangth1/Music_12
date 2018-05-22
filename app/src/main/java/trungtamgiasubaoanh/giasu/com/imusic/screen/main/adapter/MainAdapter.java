package trungtamgiasubaoanh.giasu.com.imusic.screen.main.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import trungtamgiasubaoanh.giasu.com.imusic.R;
import trungtamgiasubaoanh.giasu.com.imusic.screen.offline.OfflineFragment;
import trungtamgiasubaoanh.giasu.com.imusic.screen.online.OnlineFragment;

/**
 * Created by Admin on 18-May-18.
 */

public class MainAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private List<Fragment> mListFragment;
    private List<String> mListTitleTab;

    public MainAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        initListFragment();
        initListTitleTab();
    }

    private void initListTitleTab() {
        mListTitleTab = new ArrayList<>();
        String titleTabOnline = mContext.getString(R.string.title_tab_online);
        String titleTabOffline = mContext.getString(R.string.title_tab_offline);
        mListTitleTab.add(titleTabOnline);
        mListTitleTab.add(titleTabOffline);
    }

    private void initListFragment() {
        mListFragment = new ArrayList<>();
        OnlineFragment onlineFragment = new OnlineFragment();
        OfflineFragment offlineFragment = new OfflineFragment();
        mListFragment.add(onlineFragment);
        mListFragment.add(offlineFragment);
    }

    @Override
    public Fragment getItem(int position) {
        return mListFragment.get(position);
    }

    @Override
    public int getCount() {
        return mListFragment == null ? 0 : mListFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mListTitleTab.get(position);
    }
}
