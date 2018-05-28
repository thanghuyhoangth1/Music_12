package trungtamgiasubaoanh.giasu.com.imusic.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 21-May-18.
 */

public class Song implements Parcelable {
    private String mTitle;
    private String mArtWorkUrl;
    private boolean mDownloadable;
    private String mDownloadURL;
    private long mDuration;
    private String mUri;
    private String mUserName;

    public String getTitle() {
        return mTitle;
    }

    public String getArtWorkUrl() {
        return mArtWorkUrl;
    }

    public boolean isDownloadable() {
        return mDownloadable;
    }

    public String getDownloadURL() {
        return mDownloadURL;
    }

    public long getDuration() {
        return mDuration;
    }

    public String getUri() {
        return mUri;
    }

    public String getUserName() {
        return mUserName;
    }

    public static Creator<Song> getCREATOR() {
        return CREATOR;
    }

    protected Song(Parcel in) {
        mTitle = in.readString();
        mArtWorkUrl = in.readString();
        mDownloadable = in.readByte() != 0;
        mDownloadURL = in.readString();
        mDuration = in.readLong();
        mUri = in.readString();
        mUserName = in.readString();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mArtWorkUrl);
        dest.writeByte((byte) (mDownloadable ? 1 : 0));
        dest.writeString(mDownloadURL);
        dest.writeLong(mDuration);
        dest.writeString(mUri);
        dest.writeString(mUserName);
    }

    private Song(Builder builder) {
        mTitle = builder.mTitle;
        mArtWorkUrl = builder.mArtWorkUrl;
        mDownloadable = builder.mDownloadable;
        mDownloadURL = builder.mDownloadURL;
        mDuration = builder.mDuration;
        mUri = builder.mUri;
        mUserName = builder.mUserName;
    }

    public static class Builder {
        private String mTitle;
        private String mArtWorkUrl;
        private boolean mDownloadable;
        private String mDownloadURL;
        private long mDuration;
        private String mUri;
        private String mUserName;

        public Builder title(String title) {
            mTitle = title;
            return this;
        }

        public Builder artWorkUrl(String artWorkUrl) {
            mArtWorkUrl = artWorkUrl;
            return this;
        }

        public Builder downloadable(Boolean downloadable) {
            mDownloadable = downloadable;
            return this;
        }

        public Builder dowloadURL(String downloadURL) {
            mDownloadURL = downloadURL;
            return this;
        }

        public Builder duration(long durartion) {
            mDuration = durartion;
            return this;
        }

        public Builder uri(String uri) {
            mUri = uri;
            return this;
        }

        public Builder userName(String userName) {
            mUserName = userName;
            return this;
        }

        public Song build() {
            return new Song(this);
        }
    }

    public class SongEntry {
        public static final String COLLECTION = "collection";
        public static final String TRACK = "track";
        public static final String ARTWORK_URL = "artwork_url";
        public static final String DOWNLOADABLE = "downloadable";
        public static final String DOWNLOAD_URL = "download_url";
        public static final String DURATION = "duration";
        public static final String TITLE = "title";
        public static final String URI = "uri";
        public static final String USER_NAME = "username";
        public static final String USER = "user";
    }
}
