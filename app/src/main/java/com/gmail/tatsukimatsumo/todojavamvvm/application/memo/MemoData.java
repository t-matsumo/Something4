package com.gmail.tatsukimatsumo.todojavamvvm.application.memo;

import android.os.Parcel;
import android.os.Parcelable;

import com.gmail.tatsukimatsumo.todojavamvvm.domain.memo.Memo;

public class MemoData implements Parcelable {
    public final String content;

    public MemoData(Memo memo) {
        this.content = memo.getContent();
    }

    protected MemoData(Parcel in) {
        content = in.readString();
    }

    public static final Creator<MemoData> CREATOR = new Creator<MemoData>() {
        @Override
        public MemoData createFromParcel(Parcel in) {
            return new MemoData(in);
        }

        @Override
        public MemoData[] newArray(int size) {
            return new MemoData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(content);
    }
}
