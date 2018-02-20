package com.codename26.juniortestapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class LogData implements Parcelable {
    private String date;
    private String log;
    private String general;
    private String docs;
    private String dvir;

    public LogData(String date, String log, String general, String docs, String dvir){
        this.date = date;
        this.log = log;
        this.docs = docs;
        this.general = general;
        this.dvir = dvir;
    }

    public String getLog() {
        return log;
    }

    public String getGeneral() {
        return general;
    }

    public String getDocs() {
        return docs;
    }

    public String getDvir() {
        return dvir;
    }

    public String getDate() {
        return date;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.date);
        dest.writeString(this.log);
        dest.writeString(this.general);
        dest.writeString(this.docs);
        dest.writeString(this.dvir);
    }

    protected LogData(Parcel in) {
        this.date = in.readString();
        this.log = in.readString();
        this.general = in.readString();
        this.docs = in.readString();
        this.dvir = in.readString();
    }

    public static final Creator<LogData> CREATOR = new Creator<LogData>() {
        @Override
        public LogData createFromParcel(Parcel source) {
            return new LogData(source);
        }

        @Override
        public LogData[] newArray(int size) {
            return new LogData[size];
        }
    };
}
