package trungtamgiasubaoanh.giasu.com.imusic.data.source.local;

import trungtamgiasubaoanh.giasu.com.imusic.data.source.SongDataSource;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.remote.SongRemoteDataSource;

/**
 * Created by Admin on 23-May-18.
 */

public class SongLocalDataSource implements SongDataSource.LocalDataSource {
    private static SongLocalDataSource sSongLocalDataSource;

    private SongLocalDataSource() {
    }

    public static SongLocalDataSource getInstance() {
        if (sSongLocalDataSource == null) {
            sSongLocalDataSource = new SongLocalDataSource();
        }
        return sSongLocalDataSource;
    }

}
