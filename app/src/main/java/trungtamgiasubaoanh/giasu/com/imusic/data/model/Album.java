package trungtamgiasubaoanh.giasu.com.imusic.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.StringDef;

/**
 * Created by Admin on 25-May-18.
 */

public class Album implements Parcelable {
    private int mID;
    private String mArtist;
    private String mArt;
    private String mTitle;

    private Album(Builder builder) {
        mID = builder.mID;
        mArtist = builder.mArtist;
        mArt = builder.mArt;
        mTitle = builder.mTitle;
    }

    protected Album(Parcel in) {
        mID = in.readInt();
        mArtist = in.readString();
        mArt = in.readString();
        mTitle = in.readString();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    public int getID() {
        return mID;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getArt() {
        return mArt;
    }

    public String getTitle() {
        return mTitle;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mID);
        dest.writeString(mArtist);
        dest.writeString(mArt);
        dest.writeString(mTitle);
    }

    public static class Builder {
        private int mID;
        private String mArtist;
        private String mArt;
        private String mTitle;

        public Builder id(int id) {
            mID = id;
            return this;
        }

        public Builder artist(String artist) {
            mArtist = artist;
            return this;
        }

        public Builder art(String art) {
            mArt = art;
            return this;
        }

        public Builder title(String title) {
            mTitle = title;
            return this;
        }

        public Album build() {
            return new Album(this);
        }
    }
}
