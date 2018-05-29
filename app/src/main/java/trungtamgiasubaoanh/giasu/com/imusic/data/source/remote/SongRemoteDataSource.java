package trungtamgiasubaoanh.giasu.com.imusic.data.source.remote;

import trungtamgiasubaoanh.giasu.com.imusic.Utils.Utils;
import trungtamgiasubaoanh.giasu.com.imusic.data.model.Song;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.OnFetchDataListener;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.SongDataSource;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.remote.fetch.RequestSongData;

/**
 * Created by Admin on 22-May-18.
 */

public class SongRemoteDataSource implements SongDataSource.RemoteDataSource {
    private static SongRemoteDataSource sSongRemoteDataSource;

    private SongRemoteDataSource() {
    }

    public static SongRemoteDataSource getInstance() {
        if (sSongRemoteDataSource == null) {
            sSongRemoteDataSource = new SongRemoteDataSource();
        }
        return sSongRemoteDataSource;
    }

    @Override
    public void getMusicRemote(int requesCode, String genre, int litmit, int offset, OnFetchDataListener listener) {
        String url = Utils.createURL(genre, litmit, offset);
        RequestSongData requestSongData = new RequestSongData(requesCode, listener);
        requestSongData.execute(url);
    }
}
