package trungtamgiasubaoanh.giasu.com.imusic.data.source.local;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import trungtamgiasubaoanh.giasu.com.imusic.data.model.Song;
import trungtamgiasubaoanh.giasu.com.imusic.data.model.SongLocalEntry;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.OnFetchDataListener;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.SongDataSource;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.local.fetch.FetchDataSongLocal;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.remote.SongRemoteDataSource;

/**
 * Created by Admin on 23-May-18.
 */

public class SongLocalDataSource implements SongDataSource.LocalDataSource {
    private static SongLocalDataSource sSongLocalDataSource;
    private Context mContext;

    private SongLocalDataSource(Context context) {
        mContext = context;
    }

    public static SongLocalDataSource getInstance(Context context) {
        if (sSongLocalDataSource == null) {
            sSongLocalDataSource = new SongLocalDataSource(context);
        }
        return sSongLocalDataSource;
    }

    @Override
    public void getAllMusicOffline(@SongLocalEntry.RequestLocalAnotation int requestCode,
                                   OnFetchDataListener songOnFetchDataListener) {
        FetchDataSongLocal fetchDataSongLocal = new FetchDataSongLocal(mContext,
                requestCode, songOnFetchDataListener);

    }
}