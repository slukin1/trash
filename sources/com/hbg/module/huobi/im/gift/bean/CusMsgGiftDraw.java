package com.hbg.module.huobi.im.gift.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class CusMsgGiftDraw implements Parcelable {
    public static final Parcelable.Creator<CusMsgGiftDraw> CREATOR = new Creator();
    private String nickname;
    private String text;

    public static final class Creator implements Parcelable.Creator<CusMsgGiftDraw> {
        /* renamed from: a */
        public final CusMsgGiftDraw createFromParcel(Parcel parcel) {
            return new CusMsgGiftDraw(parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final CusMsgGiftDraw[] newArray(int i11) {
            return new CusMsgGiftDraw[i11];
        }
    }

    public CusMsgGiftDraw() {
        this((String) null, (String) null, 3, (r) null);
    }

    public CusMsgGiftDraw(String str, String str2) {
        this.nickname = str;
        this.text = str2;
    }

    public static /* synthetic */ CusMsgGiftDraw copy$default(CusMsgGiftDraw cusMsgGiftDraw, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cusMsgGiftDraw.nickname;
        }
        if ((i11 & 2) != 0) {
            str2 = cusMsgGiftDraw.text;
        }
        return cusMsgGiftDraw.copy(str, str2);
    }

    public final String component1() {
        return this.nickname;
    }

    public final String component2() {
        return this.text;
    }

    public final CusMsgGiftDraw copy(String str, String str2) {
        return new CusMsgGiftDraw(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CusMsgGiftDraw)) {
            return false;
        }
        CusMsgGiftDraw cusMsgGiftDraw = (CusMsgGiftDraw) obj;
        return x.b(this.nickname, cusMsgGiftDraw.nickname) && x.b(this.text, cusMsgGiftDraw.text);
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.nickname;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.text;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public String toString() {
        return "CusMsgGiftDraw(nickname=" + this.nickname + ", text=" + this.text + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.nickname);
        parcel.writeString(this.text);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CusMsgGiftDraw(String str, String str2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }
}
