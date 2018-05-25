package trungtamgiasubaoanh.giasu.com.imusic.data.source.remote.fetch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import trungtamgiasubaoanh.giasu.com.imusic.Utils.Utils;
import trungtamgiasubaoanh.giasu.com.imusic.data.model.Song;
import trungtamgiasubaoanh.giasu.com.imusic.data.source.OnFetchDataListener;

/**
 * Created by Admin on 22-May-18.
 */

public class RequestSongData extends BaseRequestData<Song> {
    private int mRequestCode;
    private String mGenre;
    private int mLitmit;
    private int mOffset;

    public RequestSongData(int requestCode, OnFetchDataListener<Song> onFetchDataListener) {
        super(onFetchDataListener);
        setRequestCode(requestCode);
    }

    @Override
    public List<Song> parserJSON(String jsonString) throws JSONException {
        ArrayList listSong = new ArrayList();
        JSONObject object = new JSONObject(jsonString);
        JSONArray collectionArray = object.getJSONArray(Song.SongEntry.COLLECTION);
        int countSong = collectionArray.length();
        for (int i = 0; i < countSong; i++) {
            JSONObject songObj = collectionArray.optJSONObject(i);
            JSONObject trackObj = songObj.optJSONObject(Song.SongEntry.TRACK);
            String artWorkURL = trackObj.optString(Song.SongEntry.ARTWORK_URL);
            boolean downloadable = trackObj.optBoolean(Song.SongEntry.DOWNLOADABLE);
            String downloadURL = trackObj.optString(Song.SongEntry.DOWNLOAD_URL);
            long duration = trackObj.optLong(Song.SongEntry.DURATION);
            String title = trackObj.optString(Song.SongEntry.TITLE);
            String uri = trackObj.optString(Song.SongEntry.URI);
            JSONObject userObj = trackObj.optJSONObject(Song.SongEntry.USER);
            String userName = userObj.optString(Song.SongEntry.USER_NAME);
            Song song = new Song.Builder()
                    .artWorkUrl(artWorkURL)
                    .downloadable(downloadable)
                    .dowloadURL(downloadURL)
                    .duration(duration)
                    .title(title)
                    .uri(uri)
                    .userName(userName).build();
            listSong.add(song);
        }
        return listSong;
    }
}
