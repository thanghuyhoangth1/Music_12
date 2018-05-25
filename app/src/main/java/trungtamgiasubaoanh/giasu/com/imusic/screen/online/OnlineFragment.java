package trungtamgiasubaoanh.giasu.com.imusic.screen.online;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import trungtamgiasubaoanh.giasu.com.imusic.BaseFragment;
import trungtamgiasubaoanh.giasu.com.imusic.R;
import trungtamgiasubaoanh.giasu.com.imusic.data.model.Song;
import trungtamgiasubaoanh.giasu.com.imusic.data.repository.SongReponsitory;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.SongDataSource;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.local.SongLocalDataSource;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.remote.SongRemoteDataSource;

/**
 * Created by Admin on 18-May-18.
 */

public class OnlineFragment extends BaseFragment implements OnlineConstract.View {
    private RecyclerView mRecyclerAllMusic;
    private RecyclerView mRecyclerAllAudio;
    private RecyclerView mRecyclerAlternativerock;
    private RecyclerView mRecyclerAmbian;
    private RecyclerView mRecyclerClassical;
    private RecyclerView mRecyclerCountry;
    private OnlineConstract.Presenter mPresenter;

    @Override
    public int getLayoutResouce() {
        return R.layout.fragment_online;
    }

    @Override
    public void initVariables(View viewRoot, Bundle saveInstanceState) {
        mRecyclerAllMusic = viewRoot.findViewById(R.id.recycler_all_music);
        mRecyclerAllAudio = viewRoot.findViewById(R.id.recycler_all_audio);
        mRecyclerAlternativerock = viewRoot.findViewById(R.id.recycler_alternativerock);
        mRecyclerAmbian = viewRoot.findViewById(R.id.recycler_ambiant);
        mRecyclerClassical = viewRoot.findViewById(R.id.recycler_classcical);
        mRecyclerCountry = viewRoot.findViewById(R.id.recycler_country);
    }

    @Override
    public void initData(Bundle saveInstanceState) {
        mPresenter = new OnlinePresenter(SongReponsitory.getInstance(SongRemoteDataSource.getInstance(), SongLocalDataSource.getInstance()));
        mPresenter.setView(this);
        mPresenter.getListAllMusic();
        mPresenter.getListAllAudio();
        mPresenter.getListAlternativerock();
        mPresenter.getListAmbiant();
        mPresenter.getListClassical();
        mPresenter.getListCoutry();
    }

    @Override
    public void initRecyclerAllMusic(List<Song> listSong) {
        setDataRecyclerView(mRecyclerAllMusic, listSong);
    }

    @Override
    public void initRecyclerAllAudio(List<Song> listSong) {
        setDataRecyclerView(mRecyclerAllAudio, listSong);
    }

    @Override
    public void initRecyclerAlternativerock(List<Song> listSong) {
        setDataRecyclerView(mRecyclerAlternativerock, listSong);
    }

    @Override
    public void initRecyclerAmbiant(List<Song> listSong) {
        setDataRecyclerView(mRecyclerAmbian, listSong);
    }

    @Override
    public void initRecyclerClassical(List<Song> listSong) {
        setDataRecyclerView(mRecyclerClassical, listSong);
    }

    @Override
    public void initRecyclerCountry(List<Song> listSong) {
        setDataRecyclerView(mRecyclerCountry, listSong);
    }

    private void setDataRecyclerView(RecyclerView recycler, List<Song> listSong) {
        OnlineFragmentAdapter adapter = new OnlineFragmentAdapter(getActivity(), listSong);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(layoutManager);
    }
}
