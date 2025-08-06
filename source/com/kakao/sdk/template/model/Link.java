package com.kakao.sdk.template.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.kakao.sdk.common.json.MapToQueryAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BO\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003JQ\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR$\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006!"}, d2 = {"Lcom/kakao/sdk/template/model/Link;", "Landroid/os/Parcelable;", "webUrl", "", "mobileWebUrl", "androidExecutionParams", "", "iosExecutionParams", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getAndroidExecutionParams", "()Ljava/util/Map;", "getIosExecutionParams", "getMobileWebUrl", "()Ljava/lang/String;", "getWebUrl", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Link implements Parcelable {
    public static final Parcelable.Creator<Link> CREATOR = new Creator();
    @SerializedName("android_execution_params")
    @JsonAdapter(MapToQueryAdapter.class)
    private final Map<String, String> androidExecutionParams;
    @SerializedName("ios_execution_params")
    @JsonAdapter(MapToQueryAdapter.class)
    private final Map<String, String> iosExecutionParams;
    private final String mobileWebUrl;
    private final String webUrl;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Link> {
        /* renamed from: a */
        public final Link createFromParcel(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            LinkedHashMap linkedHashMap2 = null;
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int readInt = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
            }
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                linkedHashMap2 = new LinkedHashMap(readInt2);
                for (int i12 = 0; i12 != readInt2; i12++) {
                    linkedHashMap2.put(parcel.readString(), parcel.readString());
                }
            }
            return new Link(readString, readString2, linkedHashMap, linkedHashMap2);
        }

        /* renamed from: b */
        public final Link[] newArray(int i11) {
            return new Link[i11];
        }
    }

    public Link() {
        this((String) null, (String) null, (Map) null, (Map) null, 15, (r) null);
    }

    public Link(String str) {
        this(str, (String) null, (Map) null, (Map) null, 14, (r) null);
    }

    public Link(String str, String str2) {
        this(str, str2, (Map) null, (Map) null, 12, (r) null);
    }

    public Link(String str, String str2, Map<String, String> map) {
        this(str, str2, map, (Map) null, 8, (r) null);
    }

    public Link(String str, String str2, Map<String, String> map, Map<String, String> map2) {
        this.webUrl = str;
        this.mobileWebUrl = str2;
        this.androidExecutionParams = map;
        this.iosExecutionParams = map2;
    }

    public static /* synthetic */ Link copy$default(Link link, String str, String str2, Map<String, String> map, Map<String, String> map2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = link.webUrl;
        }
        if ((i11 & 2) != 0) {
            str2 = link.mobileWebUrl;
        }
        if ((i11 & 4) != 0) {
            map = link.androidExecutionParams;
        }
        if ((i11 & 8) != 0) {
            map2 = link.iosExecutionParams;
        }
        return link.copy(str, str2, map, map2);
    }

    public final String component1() {
        return this.webUrl;
    }

    public final String component2() {
        return this.mobileWebUrl;
    }

    public final Map<String, String> component3() {
        return this.androidExecutionParams;
    }

    public final Map<String, String> component4() {
        return this.iosExecutionParams;
    }

    public final Link copy(String str, String str2, Map<String, String> map, Map<String, String> map2) {
        return new Link(str, str2, map, map2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Link)) {
            return false;
        }
        Link link = (Link) obj;
        return x.b(this.webUrl, link.webUrl) && x.b(this.mobileWebUrl, link.mobileWebUrl) && x.b(this.androidExecutionParams, link.androidExecutionParams) && x.b(this.iosExecutionParams, link.iosExecutionParams);
    }

    public final Map<String, String> getAndroidExecutionParams() {
        return this.androidExecutionParams;
    }

    public final Map<String, String> getIosExecutionParams() {
        return this.iosExecutionParams;
    }

    public final String getMobileWebUrl() {
        return this.mobileWebUrl;
    }

    public final String getWebUrl() {
        return this.webUrl;
    }

    public int hashCode() {
        String str = this.webUrl;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.mobileWebUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, String> map = this.androidExecutionParams;
        int hashCode3 = (hashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, String> map2 = this.iosExecutionParams;
        if (map2 != null) {
            i11 = map2.hashCode();
        }
        return hashCode3 + i11;
    }

    public String toString() {
        return "Link(webUrl=" + this.webUrl + ", mobileWebUrl=" + this.mobileWebUrl + ", androidExecutionParams=" + this.androidExecutionParams + ", iosExecutionParams=" + this.iosExecutionParams + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.webUrl);
        parcel.writeString(this.mobileWebUrl);
        Map<String, String> map = this.androidExecutionParams;
        if (map == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeString((String) next.getValue());
            }
        }
        Map<String, String> map2 = this.iosExecutionParams;
        if (map2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(map2.size());
        for (Map.Entry next2 : map2.entrySet()) {
            parcel.writeString((String) next2.getKey());
            parcel.writeString((String) next2.getValue());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Link(String str, String str2, Map map, Map map2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : map, (i11 & 8) != 0 ? null : map2);
    }
}
