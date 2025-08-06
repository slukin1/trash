package cn.sharesdk.line.utils;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class LineAuthenticationParams implements Parcelable {
    public static final Parcelable.Creator<LineAuthenticationParams> CREATOR = new Parcelable.Creator<LineAuthenticationParams>() {
        /* renamed from: a */
        public LineAuthenticationParams createFromParcel(Parcel parcel) {
            return new LineAuthenticationParams(parcel);
        }

        /* renamed from: a */
        public LineAuthenticationParams[] newArray(int i11) {
            return new LineAuthenticationParams[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final List<e> f13650a;

    /* renamed from: b  reason: collision with root package name */
    private final a f13651b;

    public enum a {
        normal,
        aggressive
    }

    public static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public List<e> f13655a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public a f13656b;

        public b a(List<e> list) {
            this.f13655a = list;
            return this;
        }

        public b a(a aVar) {
            this.f13656b = aVar;
            return this;
        }

        public LineAuthenticationParams a() {
            return new LineAuthenticationParams(this);
        }
    }

    public List<e> a() {
        return this.f13650a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeStringList(e.c(this.f13650a));
        d.a(parcel, this.f13651b);
    }

    private LineAuthenticationParams(b bVar) {
        this.f13650a = bVar.f13655a;
        this.f13651b = bVar.f13656b;
    }

    private LineAuthenticationParams(Parcel parcel) {
        this.f13650a = e.b(parcel.createStringArrayList());
        this.f13651b = (a) d.a(parcel, a.class);
    }
}
