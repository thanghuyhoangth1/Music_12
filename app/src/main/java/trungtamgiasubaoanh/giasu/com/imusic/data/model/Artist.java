package trungtamgiasubaoanh.giasu.com.imusic.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 26-May-18.
 */

public class Artist implements Parcelable {
    private int mID;
    private int mNumberTrack;
    private String mName;

    public Artist(Builder builder) {
        mID = builder.mID;
        mNumberTrack = builder.mNumberTrack;
        mName = builder.mName;
    }

    protected Artist(Parcel in) {
        mID = in.readInt();
        mNumberTrack = in.readInt();
        mName = in.readString();
    }

    public static final Creator<Artist> CREATOR = new Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };

    public int getID() {
        return mID;
    }

    public int getNumberTrack() {
        return mNumberTrack;
    }

    public String getName() {
        return mName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mID);
        dest.writeInt(mNumberTrack);
        dest.writeString(mName);
    }

    public static class Builder {
        private int mID;
        private int mNumberTrack;
        private String mName;

        public Builder id(int id) {
            mID = id;
            return this;
        }

        public Builder numberOfTrack(int numberTrack) {
            mNumberTrack = numberTrack;
            return this;
        }

        public Builder name(String name) {
            mName = name;
            return this;
        }

        public Artist build() {
            return new Artist(this);
        }
    }
}
