package es.pue.android.mymaps;

import android.os.Parcel;
import android.os.Parcelable;

public class GeoCoord implements Parcelable {
    private String latitude;
    private String longitude;

    public GeoCoord(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    protected GeoCoord(Parcel in) {
        latitude = in.readString();
        longitude = in.readString();
    }

    public static final Creator<GeoCoord> CREATOR = new Creator<GeoCoord>() {
        @Override
        public GeoCoord createFromParcel(Parcel in) {
            return new GeoCoord(in);
        }

        @Override
        public GeoCoord[] newArray(int size) {
            return new GeoCoord[size];
        }
    };

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(latitude);
        dest.writeString(longitude);
    }
}
