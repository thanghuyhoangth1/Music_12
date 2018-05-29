package trungtamgiasubaoanh.giasu.com.imusic.data.model;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Admin on 25-May-18.
 */

public class SongLocalEntry {
    public static final int REQUEST_MUSIC = 1;
    public static final int REQUEST_ALBUM = 2;
    public static final int REQUEST_ARTIST = 3;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({REQUEST_MUSIC, REQUEST_ALBUM, REQUEST_ARTIST})
    public @interface RequestLocalAnotation {
    }
}
