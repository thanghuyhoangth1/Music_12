package trungtamgiasubaoanh.giasu.com.imusic.data.source;

import android.content.Context;

import java.util.List;

import trungtamgiasubaoanh.giasu.com.imusic.data.model.GenreSongEntry;
import trungtamgiasubaoanh.giasu.com.imusic.data.model.Song;
import trungtamgiasubaoanh.giasu.com.imusic.data.model.SongLocalEntry;

/**
 * Created by Admin on 22-May-18.
 */

public interface SongDataSource {
    interface RemoteDataSource {
        void getMusicRemote(@GenreSongEntry.RequestGenreAnotation int requesCode,
                            @GenreSongEntry.GenreAnotation String genre,
                            int litmit,
                            int offset,
                            OnFetchDataListener<Song> listener);
    }

    interface LocalDataSource {
        void getAllMusicOffline(@SongLocalEntry.RequestLocalAnotation int requestCode,
                                OnFetchDataListener songOnFetchDataListener);
    }
}
