package com.example.ratestar.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private int mId;
    private int mImage;
    private String mName;
    private String mInfo;
    private float mRating;

    public User(int id, int image, String name, String info, float rating) {
        mId = id;
        mImage = image;
        mName = name;
        mInfo = info;
        mRating = rating;
    }

    public int getId() {
        return mId;
    }

    public int getImage() {
        return mImage;
    }

    public String getName() {
        return mName;
    }

    public String getInfo() {
        return mInfo;
    }

    public float getRating() {
        return mRating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mId);
        parcel.writeInt(mImage);
        parcel.writeString(mName);
        parcel.writeString(mInfo);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };

    private User(Parcel in) {
        mId = in.readInt();
        mImage = in.readInt();
        mName = in.readString();
        mInfo = in.readString();
    }

    public static class UserBuilder {
        private int mId;
        private int mImage;
        private String mName;
        private String mInfo;
        private float mRating;

        public UserBuilder() {
        }

        public UserBuilder id(int id) {
            this.mId = id;
            return this;
        }

        public UserBuilder image(int image) {
            this.mImage = image;
            return this;
        }

        public UserBuilder name(String name) {
            this.mName = name;
            return this;
        }

        public UserBuilder info(String info) {
            this.mInfo = info;
            return this;
        }

        public UserBuilder rating(float rating) {
            this.mRating = rating;
            return this;
        }

        public User build() {
            User user = new User(this.mId, this.mImage, this.mName, this.mInfo, this.mRating);
            return user;
        }
    }
}