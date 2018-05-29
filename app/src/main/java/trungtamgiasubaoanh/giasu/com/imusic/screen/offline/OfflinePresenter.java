package trungtamgiasubaoanh.giasu.com.imusic.screen.offline;

import java.util.List;

import trungtamgiasubaoanh.giasu.com.imusic.data.model.Song;
import trungtamgiasubaoanh.giasu.com.imusic.data.model.SongLocalEntry;
import trungtamgiasubaoanh.giasu.com.imusic.data.repository.SongReponsitory;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.OnFetchDataListener;

/**
 * Created by Admin on 25-May-18.
 */

public class OfflinePresenter implements OfflineConstract.Presenter, OnFetchDataListener<Song> {
    private OfflineConstract.View mView;
    private SongReponsitory mSongReponsitory;

    public OfflinePresenter(SongReponsitory songReponsitory) {
        mSongReponsitory = songReponsitory;
    }

    @Override
    public void setView(OfflineConstract.View view) {
        mView = view;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
    }

    @Override
    public void getListAllSong() {
        mSongReponsitory.getAllMusicOffline(
                SongLocalEntry.REQUEST_MUSIC,
                this);
    }

    @Override
    public void getListALlAlbum() {
        mSongReponsitory.getAllMusicOffline(
                SongLocalEntry.REQUEST_ALBUM,
                this);

    }

    @Override
    public void getListArtist() {
        mSongReponsitory.getAllMusicOffline(
                SongLocalEntry.REQUEST_ARTIST,
                this);
    }

    @Override
    public void onSuccess(int requestCode, List data) {
        switch (requestCode) {
            case SongLocalEntry.REQUEST_MUSIC:
                mView.initRecyclerViewAllSong(data);
                break;
            case SongLocalEntry.REQUEST_ALBUM:
                mView.initRecyclerViewAllAlbym(data);
                break;
            case SongLocalEntry.REQUEST_ARTIST:
                mView.initRecyclerViewArtist(data);
                break;
        }
    }

    @Override
    public void onSuccess(List<Song> data) {
    }

    @Override
    public void onFailure(Exception e) {
    }
}
