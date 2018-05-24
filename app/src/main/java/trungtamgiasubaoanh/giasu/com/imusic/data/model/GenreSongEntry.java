package trungtamgiasubaoanh.giasu.com.imusic.data.model;

import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Admin on 23-May-18.
 */

public class GenreSongEntry {
    public static final String ALL_MUSIC = "all-music";
    public static final String ALL_AUDIO = "all-audio";
    public static final String ALTERNATIVEROCK = "alternativerock";
    public static final String AMBIENT = "ambient";
    public static final String CLASSICAL = "classical";
    public static final String COUNTRY = "country";
    public static final int REQUEST_ALLMUSIC = 1;
    public static final int REQUEST_ALLAUDIO = 2;
    public static final int REQUEST_ALTERNATIVEROCK = 3;
    public static final int REQUEST_AMBIENT = 4;
    public static final int REQUEST_CLASSICAL = 5;
    public static final int REQUEST_COUNTRY = 6;

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({ALL_MUSIC, ALL_AUDIO, ALTERNATIVEROCK, AMBIENT, CLASSICAL, COUNTRY})
    public @interface GenreAnotation {
    }

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({REQUEST_ALLMUSIC, REQUEST_ALLAUDIO, REQUEST_ALTERNATIVEROCK,
            REQUEST_AMBIENT, REQUEST_CLASSICAL, REQUEST_COUNTRY})
    public @interface RequestGenreAnotation {
    }
}
