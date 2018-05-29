package trungtamgiasubaoanh.giasu.com.imusic.data.repository;

import android.content.Context;

import trungtamgiasubaoanh.giasu.com.imusic.data.model.GenreSongEntry;
import trungtamgiasubaoanh.giasu.com.imusic.data.model.Song;
import trungtamgiasubaoanh.giasu.com.imusic.data.model.SongLocalEntry;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.OnFetchDataListener;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.SongDataSource;

/**
 * Created by Admin on 22-May-18.
 */

public class SongReponsitory implements SongDataSource.RemoteDataSource, SongDataSource.LocalDataSource {
    private static SongReponsitory sSongReponsitory;
    private SongDataSource.RemoteDataSource mRemoteDataSource;
    private SongDataSource.LocalDataSource mLocalDataSource;

    public static SongReponsitory getInstance(SongDataSource.RemoteDataSource remote,
                                              SongDataSource.LocalDataSource local) {
        if (sSongReponsitory == null) {
            sSongReponsitory = new SongReponsitory(remote, local);
        }
        return sSongReponsitory;
    }

    private SongReponsitory(SongDataSource.RemoteDataSource remote, SongDataSource.LocalDataSource local) {
        mRemoteDataSource = remote;
        mLocalDataSource = local;
    }

    @Override
    public void getMusicRemote(@GenreSongEntry.RequestGenreAnotation int requesCode,
                               @GenreSongEntry.GenreAnotation String genre,
                               int litmit,
                               int offset,
                               OnFetchDataListener<Song> listener) {
        if (mRemoteDataSource != null) {
            mRemoteDataSource.getMusicRemote(requesCode, genre, litmit, offset, listener);
        }
    }

    @Override
    public void getAllMusicOffline(@SongLocalEntry.RequestLocalAnotation int requestCode, OnFetchDataListener songOnFetchDataListener) {
        if (mLocalDataSource != null) {
            mLocalDataSource.getAllMusicOffline(requestCode, songOnFetchDataListener);
        }
    }
}
