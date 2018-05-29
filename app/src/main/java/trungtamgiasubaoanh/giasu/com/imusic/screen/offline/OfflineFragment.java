package trungtamgiasubaoanh.giasu.com.imusic.screen.offline;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import trungtamgiasubaoanh.giasu.com.imusic.BaseFragment;
import trungtamgiasubaoanh.giasu.com.imusic.R;
import trungtamgiasubaoanh.giasu.com.imusic.data.repository.SongReponsitory;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.SongDataSource;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.local.SongLocalDataSource;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.remote.SongRemoteDataSource;
import trungtamgiasubaoanh.giasu.com.imusic.screen.offline.adapter.AlbumOfflineAdapter;
import trungtamgiasubaoanh.giasu.com.imusic.screen.offline.adapter.ArtistOfflineAdapter;
import trungtamgiasubaoanh.giasu.com.imusic.screen.offline.adapter.SongOfflineAdapter;

/**
 * Created by Admin on 18-May-18.
 */

public class OfflineFragment extends BaseFragment implements OfflineConstract.View {
    private OfflineConstract.Presenter mPresenter;
    private RecyclerView recyclerAllSong;
    private RecyclerView recyclerAlbum;
    private RecyclerView recyclerArtist;

    @Override
    public int getLayoutResouce() {
        return R.layout.fragment_offline;
    }

    @Override
    public void initVariables(View viewRoot, Bundle saveInstanceState) {
        recyclerAllSong = viewRoot.findViewById(R.id.recycler_all_music_offline);
        recyclerAlbum = viewRoot.findViewById(R.id.recycler_album);
        recyclerArtist = viewRoot.findViewById(R.id.recycler_artist);
    }

    @Override
    public void initData(Bundle saveInstanceState) {
        SongLocalDataSource local = SongLocalDataSource.getInstance(getActivity());
        SongRemoteDataSource remote = SongRemoteDataSource.getInstance();
        mPresenter = new OfflinePresenter(SongReponsitory.getInstance(remote, local));
        mPresenter.setView(this);
        mPresenter.getListAllSong();
        mPresenter.getListALlAlbum();
        mPresenter.getListArtist();
    }

    @Override
    public void initRecyclerViewAllSong(List data) {
        SongOfflineAdapter songOfflineAdapter = new SongOfflineAdapter(getActivity(), data);
        initRecyclerView(recyclerAllSong, songOfflineAdapter);
    }

    @Override
    public void initRecyclerViewAllAlbym(List data) {
        AlbumOfflineAdapter albumOfflineAdapter = new AlbumOfflineAdapter(getActivity(), data);
        initRecyclerView(recyclerAlbum, albumOfflineAdapter);
    }

    @Override
    public void initRecyclerViewArtist(List data) {
        ArtistOfflineAdapter artistOfflineAdapter = new ArtistOfflineAdapter(getActivity(), data);
        initRecyclerView(recyclerArtist, artistOfflineAdapter);

    }

    private void initRecyclerView(RecyclerView recycler, RecyclerView.Adapter adapter) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerArtist.setLayoutManager(layoutManager);
        recyclerArtist.setAdapter(adapter);
    }
}


