package trungtamgiasubaoanh.giasu.com.imusic.screen.online;

import android.util.Log;

import java.util.List;

import trungtamgiasubaoanh.giasu.com.imusic.Utils.Constants;
import trungtamgiasubaoanh.giasu.com.imusic.data.model.GenreSongEntry;
import trungtamgiasubaoanh.giasu.com.imusic.data.model.Song;
import trungtamgiasubaoanh.giasu.com.imusic.data.repository.SongReponsitory;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.OnFetchDataListener;

/**
 * Created by Admin on 22-May-18.
 */

public class OnlinePresenter implements OnlineConstract.Presenter, OnFetchDataListener<Song> {
    private OnlineConstract.View mView;
    private SongReponsitory mSongReponsitory;

    public OnlinePresenter(SongReponsitory songReponsitory) {
        mSongReponsitory = songReponsitory;
    }

    @Override
    public void setView(OnlineConstract.View view) {
        mView = view;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void getListAllMusic() {
        mSongReponsitory.getMusicRemote(GenreSongEntry.REQUEST_ALLMUSIC,
                GenreSongEntry.ALL_MUSIC, Constants.REQUEST_LIMIT,
                Constants.REQUEST_OFFSET,
                this);
    }

    @Override
    public void getListAllAudio() {
        mSongReponsitory.getMusicRemote(GenreSongEntry.REQUEST_ALLAUDIO,
                GenreSongEntry.ALL_AUDIO,
                Constants.REQUEST_LIMIT, Constants.REQUEST_OFFSET,
                this);
    }

    @Override
    public void getListAlternativerock() {
        mSongReponsitory.getMusicRemote(GenreSongEntry.REQUEST_ALTERNATIVEROCK,
                GenreSongEntry.ALTERNATIVEROCK,
                Constants.REQUEST_LIMIT,
                Constants.REQUEST_OFFSET,
                this);
    }

    @Override
    public void getListAmbiant() {
        mSongReponsitory.getMusicRemote(GenreSongEntry.REQUEST_AMBIENT,
                GenreSongEntry.AMBIENT,
                Constants.REQUEST_LIMIT,
                Constants.REQUEST_OFFSET,
                this);
    }

    @Override
    public void getListClassical() {
        mSongReponsitory.getMusicRemote(GenreSongEntry.REQUEST_CLASSICAL,
                GenreSongEntry.CLASSICAL, Constants.REQUEST_LIMIT,
                Constants.REQUEST_OFFSET,
                this);
    }

    @Override
    public void getListCoutry() {
        mSongReponsitory.getMusicRemote(GenreSongEntry.REQUEST_COUNTRY,
                GenreSongEntry.COUNTRY, Constants.REQUEST_LIMIT,
                Constants.REQUEST_OFFSET,
                this);
    }

    @Override
    public void onSuccess(int requestCode, List<Song> data) {
        switch (requestCode) {
            case GenreSongEntry.REQUEST_ALLMUSIC:
                mView.initRecyclerAllMusic(data);
                break;
            case GenreSongEntry.REQUEST_ALLAUDIO:
                mView.initRecyclerAllAudio(data);
                break;
            case GenreSongEntry.REQUEST_ALTERNATIVEROCK:
                mView.initRecyclerAlternativerock(data);
                break;
            case GenreSongEntry.REQUEST_AMBIENT:
                mView.initRecyclerAmbiant(data);
                break;
            case GenreSongEntry.REQUEST_CLASSICAL:
                mView.initRecyclerClassical(data);
                break;
            case GenreSongEntry.REQUEST_COUNTRY:
                mView.initRecyclerCountry(data);
                break;
        }
    }

    @Override
    public void onSuccess(List<Song> data) {
    }

    @Override
    public void onFailure(Exception e) {
        e.printStackTrace();
    }
}
