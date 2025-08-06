package cn.sharesdk.line.utils;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class LineAuthenticationConfig implements Parcelable {
    public static final Parcelable.Creator<LineAuthenticationConfig> CREATOR = new Parcelable.Creator<LineAuthenticationConfig>() {
        /* renamed from: a */
        public LineAuthenticationConfig createFromParcel(Parcel parcel) {
            return new LineAuthenticationConfig(parcel);
        }

        /* renamed from: a */
        public LineAuthenticationConfig[] newArray(int i11) {
            return new LineAuthenticationConfig[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private static int f13636a = 1;

    /* renamed from: b  reason: collision with root package name */
    private static int f13637b = 2;

    /* renamed from: c  reason: collision with root package name */
    private final String f13638c;

    /* renamed from: d  reason: collision with root package name */
    private final Uri f13639d;

    /* renamed from: e  reason: collision with root package name */
    private final Uri f13640e;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f13641f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f13642g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f13643h;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f13644a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Uri f13645b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Uri f13646c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public Uri f13647d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f13648e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public boolean f13649f;

        public a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f13644a = str;
                this.f13646c = Uri.parse("https://api.line.me/");
                this.f13647d = Uri.parse("https://access.line.me/oauth2/v2.1/login");
                return;
            }
            throw new IllegalArgumentException("channelId is empty.");
        }

        public a a(Uri uri) {
            this.f13645b = (Uri) c.a(uri, Uri.parse("https://access.line.me/.well-known/openid-configuration"));
            return this;
        }

        public a b(Uri uri) {
            this.f13646c = (Uri) c.a(uri, Uri.parse("https://api.line.me/"));
            return this;
        }

        public a c(Uri uri) {
            this.f13647d = (Uri) c.a(uri, Uri.parse("https://access.line.me/oauth2/v2.1/login"));
            return this;
        }

        public a a() {
            this.f13648e = true;
            return this;
        }

        public LineAuthenticationConfig b() {
            return new LineAuthenticationConfig(this);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LineAuthenticationConfig lineAuthenticationConfig = (LineAuthenticationConfig) obj;
        if (this.f13642g == lineAuthenticationConfig.f13642g && this.f13643h == lineAuthenticationConfig.f13643h && this.f13638c.equals(lineAuthenticationConfig.f13638c) && this.f13639d.equals(lineAuthenticationConfig.f13639d) && this.f13640e.equals(lineAuthenticationConfig.f13640e)) {
            return this.f13641f.equals(lineAuthenticationConfig.f13641f);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.f13638c.hashCode() * 31) + this.f13639d.hashCode()) * 31) + this.f13640e.hashCode()) * 31) + this.f13641f.hashCode()) * 31) + (this.f13642g ? 1 : 0)) * 31) + (this.f13643h ? 1 : 0);
    }

    public String toString() {
        return "LineAuthenticationConfig{channelId='" + this.f13638c + '\'' + ", openidDiscoveryDocumentUrl=" + this.f13639d + ", apiBaseUrl=" + this.f13640e + ", webLoginPageUrl=" + this.f13641f + ", isLineAppAuthenticationDisabled=" + this.f13642g + ", isEncryptorPreparationDisabled=" + this.f13643h + '}';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f13638c);
        parcel.writeParcelable(this.f13639d, i11);
        parcel.writeParcelable(this.f13640e, i11);
        parcel.writeParcelable(this.f13641f, i11);
        int i12 = 0;
        int i13 = (this.f13642g ? f13636a : 0) | 0;
        if (this.f13643h) {
            i12 = f13637b;
        }
        parcel.writeInt(i13 | i12);
    }

    private LineAuthenticationConfig(a aVar) {
        this.f13638c = aVar.f13644a;
        this.f13639d = aVar.f13645b;
        this.f13640e = aVar.f13646c;
        this.f13641f = aVar.f13647d;
        this.f13642g = aVar.f13648e;
        this.f13643h = aVar.f13649f;
    }

    private LineAuthenticationConfig(Parcel parcel) {
        this.f13638c = parcel.readString();
        this.f13639d = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f13640e = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f13641f = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        int readInt = parcel.readInt();
        boolean z11 = true;
        this.f13642g = (f13636a & readInt) > 0;
        this.f13643h = (readInt & f13637b) <= 0 ? false : z11;
    }
}
