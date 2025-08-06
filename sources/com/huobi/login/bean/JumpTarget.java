package com.huobi.login.bean;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import com.business.common.red_packet.RedPacketManager;

public class JumpTarget implements kn.a, Parcelable {
    public static String BUSINESS_TYPE_KEY = "businessType";
    public static String BUSINESS_TYPE_RED_PACKET = "businessTypeRedPacket";
    public static String BUSINESS_TYPE_VALUE_KEY = "businessTypeValue";
    public static final Parcelable.Creator<JumpTarget> CREATOR = new a();
    private Intent backIntent;
    private String expandData;
    private Intent showIntent;

    public class a implements Parcelable.Creator<JumpTarget> {
        /* renamed from: a */
        public JumpTarget createFromParcel(Parcel parcel) {
            return new JumpTarget(parcel);
        }

        /* renamed from: b */
        public JumpTarget[] newArray(int i11) {
            return new JumpTarget[i11];
        }
    }

    public JumpTarget(Intent intent, Intent intent2) {
        this.showIntent = intent;
        this.backIntent = intent2;
    }

    public boolean allowTrader() {
        return false;
    }

    public void back(Context context) {
        Intent intent = this.backIntent;
        if (intent != null) {
            context.startActivity(intent);
        }
    }

    public int describeContents() {
        return 0;
    }

    public Intent getBackIntent() {
        return this.backIntent;
    }

    public String getExpandData() {
        return this.expandData;
    }

    public Intent getShowIntent() {
        return this.showIntent;
    }

    public void setExpandData(String str) {
        this.expandData = str;
    }

    public void show(Context context) {
        Intent intent = this.showIntent;
        if (intent != null) {
            String stringExtra = intent.getStringExtra(BUSINESS_TYPE_KEY);
            if (stringExtra == null) {
                context.startActivity(this.showIntent);
            } else if (stringExtra.equals(BUSINESS_TYPE_RED_PACKET) && (context instanceof FragmentActivity)) {
                String stringExtra2 = this.showIntent.getStringExtra(BUSINESS_TYPE_VALUE_KEY);
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                if (stringExtra2 == null) {
                    stringExtra2 = "";
                }
                RedPacketManager.d(fragmentActivity, stringExtra2);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(this.showIntent, i11);
        parcel.writeParcelable(this.backIntent, i11);
        parcel.writeString(this.expandData);
    }

    public JumpTarget(Parcel parcel) {
        this.showIntent = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.backIntent = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.expandData = parcel.readString();
    }
}
