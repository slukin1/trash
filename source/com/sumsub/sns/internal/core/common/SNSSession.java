package com.sumsub.sns.internal.core.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u000eHÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001cJj\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010,J\t\u0010-\u001a\u00020\u000eHÖ\u0001J\u0013\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u000eHÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001J\u0019\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u000eHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012¨\u00068"}, d2 = {"Lcom/sumsub/sns/internal/core/common/SNSSession;", "Landroid/os/Parcelable;", "sessionId", "Ljava/util/UUID;", "url", "", "accessToken", "locale", "Ljava/util/Locale;", "isDebug", "", "packageName", "versionName", "versionCode", "", "theme", "(Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/util/Locale;ZLjava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "()Z", "getLocale", "()Ljava/util/Locale;", "getPackageName", "getSessionId", "()Ljava/util/UUID;", "getTheme", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUrl", "getVersionCode", "()I", "getVersionName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/util/Locale;ZLjava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)Lcom/sumsub/sns/internal/core/common/SNSSession;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public final class SNSSession implements Parcelable {
    public static final Parcelable.Creator<SNSSession> CREATOR = new a();
    private String accessToken;
    private final boolean isDebug;
    private final Locale locale;
    private final String packageName;
    private final UUID sessionId;
    private final Integer theme;
    private final String url;
    private final int versionCode;
    private final String versionName;

    public static final class a implements Parcelable.Creator<SNSSession> {
        /* renamed from: a */
        public final SNSSession createFromParcel(Parcel parcel) {
            return new SNSSession((UUID) parcel.readSerializable(), parcel.readString(), parcel.readString(), (Locale) parcel.readSerializable(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* renamed from: a */
        public final SNSSession[] newArray(int i11) {
            return new SNSSession[i11];
        }
    }

    public SNSSession(UUID uuid, String str, String str2, Locale locale2, boolean z11, String str3, String str4, int i11, Integer num) {
        this.sessionId = uuid;
        this.url = str;
        this.accessToken = str2;
        this.locale = locale2;
        this.isDebug = z11;
        this.packageName = str3;
        this.versionName = str4;
        this.versionCode = i11;
        this.theme = num;
    }

    public static /* synthetic */ SNSSession copy$default(SNSSession sNSSession, UUID uuid, String str, String str2, Locale locale2, boolean z11, String str3, String str4, int i11, Integer num, int i12, Object obj) {
        SNSSession sNSSession2 = sNSSession;
        int i13 = i12;
        return sNSSession.copy((i13 & 1) != 0 ? sNSSession2.sessionId : uuid, (i13 & 2) != 0 ? sNSSession2.url : str, (i13 & 4) != 0 ? sNSSession2.accessToken : str2, (i13 & 8) != 0 ? sNSSession2.locale : locale2, (i13 & 16) != 0 ? sNSSession2.isDebug : z11, (i13 & 32) != 0 ? sNSSession2.packageName : str3, (i13 & 64) != 0 ? sNSSession2.versionName : str4, (i13 & 128) != 0 ? sNSSession2.versionCode : i11, (i13 & 256) != 0 ? sNSSession2.theme : num);
    }

    public final UUID component1() {
        return this.sessionId;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.accessToken;
    }

    public final Locale component4() {
        return this.locale;
    }

    public final boolean component5() {
        return this.isDebug;
    }

    public final String component6() {
        return this.packageName;
    }

    public final String component7() {
        return this.versionName;
    }

    public final int component8() {
        return this.versionCode;
    }

    public final Integer component9() {
        return this.theme;
    }

    public final SNSSession copy(UUID uuid, String str, String str2, Locale locale2, boolean z11, String str3, String str4, int i11, Integer num) {
        return new SNSSession(uuid, str, str2, locale2, z11, str3, str4, i11, num);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SNSSession)) {
            return false;
        }
        SNSSession sNSSession = (SNSSession) obj;
        return x.b(this.sessionId, sNSSession.sessionId) && x.b(this.url, sNSSession.url) && x.b(this.accessToken, sNSSession.accessToken) && x.b(this.locale, sNSSession.locale) && this.isDebug == sNSSession.isDebug && x.b(this.packageName, sNSSession.packageName) && x.b(this.versionName, sNSSession.versionName) && this.versionCode == sNSSession.versionCode && x.b(this.theme, sNSSession.theme);
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final Locale getLocale() {
        return this.locale;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final UUID getSessionId() {
        return this.sessionId;
    }

    public final Integer getTheme() {
        return this.theme;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public int hashCode() {
        int hashCode = ((((((this.sessionId.hashCode() * 31) + this.url.hashCode()) * 31) + this.accessToken.hashCode()) * 31) + this.locale.hashCode()) * 31;
        boolean z11 = this.isDebug;
        if (z11) {
            z11 = true;
        }
        int hashCode2 = (((((((hashCode + (z11 ? 1 : 0)) * 31) + this.packageName.hashCode()) * 31) + this.versionName.hashCode()) * 31) + this.versionCode) * 31;
        Integer num = this.theme;
        return hashCode2 + (num == null ? 0 : num.hashCode());
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    public final void setAccessToken(String str) {
        this.accessToken = str;
    }

    public String toString() {
        return "SNSSession(sessionId=" + this.sessionId + ", url=" + this.url + ", accessToken=" + this.accessToken + ", locale=" + this.locale + ", isDebug=" + this.isDebug + ", packageName=" + this.packageName + ", versionName=" + this.versionName + ", versionCode=" + this.versionCode + ", theme=" + this.theme + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int i12;
        parcel.writeSerializable(this.sessionId);
        parcel.writeString(this.url);
        parcel.writeString(this.accessToken);
        parcel.writeSerializable(this.locale);
        parcel.writeInt(this.isDebug ? 1 : 0);
        parcel.writeString(this.packageName);
        parcel.writeString(this.versionName);
        parcel.writeInt(this.versionCode);
        Integer num = this.theme;
        if (num == null) {
            i12 = 0;
        } else {
            parcel.writeInt(1);
            i12 = num.intValue();
        }
        parcel.writeInt(i12);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSSession(UUID uuid, String str, String str2, Locale locale2, boolean z11, String str3, String str4, int i11, Integer num, int i12, r rVar) {
        this((i12 & 1) != 0 ? UUID.randomUUID() : uuid, str, str2, locale2, z11, str3, str4, i11, num);
    }
}
