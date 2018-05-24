package trungtamgiasubaoanh.giasu.com.imusic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Admin on 18-May-18.
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(getLayoutResouce(), container, false);
        initVariables(viewRoot, savedInstanceState);
        initData(savedInstanceState);
        return viewRoot;
    }

    public abstract int getLayoutResouce();

    public abstract void initVariables(View viewRoot, Bundle saveInstanceState);

    public abstract void initData(Bundle saveInstanceState);
}
