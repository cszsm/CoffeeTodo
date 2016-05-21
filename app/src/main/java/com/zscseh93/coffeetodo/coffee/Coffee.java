package com.zscseh93.coffeetodo.coffee;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Coffee implements Parcelable {

    public static final String KEY = "coffees";

    public static final Parcelable.Creator CREATOR = new Creator() {
        @Override
        public Coffee createFromParcel(Parcel source) {
            return new Coffee(source);
        }

        @Override
        public Coffee[] newArray(int size) {
            return new Coffee[size];
        }
    };

    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("kitchen")
    private Kitchen mKitchen;
    @SerializedName("cup")
    private Cup mCup;

    public Coffee() {
    }

    public Coffee(String id, String name, Kitchen kitchen, Cup cup) {
        mId = id;
        mName = name;
        mKitchen = kitchen;
        mCup = cup;
    }

    public Coffee(Parcel parcel) {
        mId = parcel.readString();
        mName = parcel.readString();
        mKitchen = (Kitchen) parcel.readSerializable();
        mCup = (Cup) parcel.readSerializable();
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public Kitchen getKitchen() {
        return mKitchen;
    }

    public Cup getCup() {
        return mCup;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
        dest.writeString(mName);
        dest.writeSerializable(mKitchen);
        dest.writeSerializable(mCup);
    }
}
