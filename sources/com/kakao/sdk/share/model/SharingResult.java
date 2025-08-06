package com.kakao.sdk.share.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J?\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/kakao/sdk/share/model/SharingResult;", "Landroid/os/Parcelable;", "intent", "Landroid/content/Intent;", "warningMsg", "", "", "argumentMsg", "(Landroid/content/Intent;Ljava/util/Map;Ljava/util/Map;)V", "getArgumentMsg", "()Ljava/util/Map;", "getIntent", "()Landroid/content/Intent;", "getWarningMsg", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "share_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SharingResult implements Parcelable {
    public static final Parcelable.Creator<SharingResult> CREATOR = new Creator();
    private final Map<String, String> argumentMsg;
    private final Intent intent;
    private final Map<String, String> warningMsg;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SharingResult> {
        /* renamed from: a */
        public final SharingResult createFromParcel(Parcel parcel) {
            Intent intent = (Intent) parcel.readParcelable(SharingResult.class.getClassLoader());
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i11 = 0; i11 != readInt; i11++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            int readInt2 = parcel.readInt();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(readInt2);
            for (int i12 = 0; i12 != readInt2; i12++) {
                linkedHashMap2.put(parcel.readString(), parcel.readString());
            }
            return new SharingResult(intent, linkedHashMap, linkedHashMap2);
        }

        /* renamed from: b */
        public final SharingResult[] newArray(int i11) {
            return new SharingResult[i11];
        }
    }

    public SharingResult(Intent intent2, Map<String, String> map, Map<String, String> map2) {
        this.intent = intent2;
        this.warningMsg = map;
        this.argumentMsg = map2;
    }

    public static /* synthetic */ SharingResult copy$default(SharingResult sharingResult, Intent intent2, Map<String, String> map, Map<String, String> map2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            intent2 = sharingResult.intent;
        }
        if ((i11 & 2) != 0) {
            map = sharingResult.warningMsg;
        }
        if ((i11 & 4) != 0) {
            map2 = sharingResult.argumentMsg;
        }
        return sharingResult.copy(intent2, map, map2);
    }

    public final Intent component1() {
        return this.intent;
    }

    public final Map<String, String> component2() {
        return this.warningMsg;
    }

    public final Map<String, String> component3() {
        return this.argumentMsg;
    }

    public final SharingResult copy(Intent intent2, Map<String, String> map, Map<String, String> map2) {
        return new SharingResult(intent2, map, map2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SharingResult)) {
            return false;
        }
        SharingResult sharingResult = (SharingResult) obj;
        return x.b(this.intent, sharingResult.intent) && x.b(this.warningMsg, sharingResult.warningMsg) && x.b(this.argumentMsg, sharingResult.argumentMsg);
    }

    public final Map<String, String> getArgumentMsg() {
        return this.argumentMsg;
    }

    public final Intent getIntent() {
        return this.intent;
    }

    public final Map<String, String> getWarningMsg() {
        return this.warningMsg;
    }

    public int hashCode() {
        return (((this.intent.hashCode() * 31) + this.warningMsg.hashCode()) * 31) + this.argumentMsg.hashCode();
    }

    public String toString() {
        return "SharingResult(intent=" + this.intent + ", warningMsg=" + this.warningMsg + ", argumentMsg=" + this.argumentMsg + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(this.intent, i11);
        Map<String, String> map = this.warningMsg;
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
        Map<String, String> map2 = this.argumentMsg;
        parcel.writeInt(map2.size());
        for (Map.Entry next2 : map2.entrySet()) {
            parcel.writeString((String) next2.getKey());
            parcel.writeString((String) next2.getValue());
        }
    }
}
