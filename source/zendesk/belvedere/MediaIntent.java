package zendesk.belvedere;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import f30.d;
import f30.e;
import java.util.ArrayList;
import java.util.List;

public class MediaIntent implements Parcelable {
    public static final Parcelable.Creator<MediaIntent> CREATOR = new a();
    public static final int TARGET_CAMERA = 2;
    public static final int TARGET_DOCUMENT = 1;
    private final Intent intent;
    private final boolean isAvailable;
    private final String permission;
    private final int requestCode;
    private final int target;

    public static class a implements Parcelable.Creator<MediaIntent> {
        /* renamed from: a */
        public MediaIntent createFromParcel(Parcel parcel) {
            return new MediaIntent(parcel);
        }

        /* renamed from: b */
        public MediaIntent[] newArray(int i11) {
            return new MediaIntent[i11];
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final e f62245a;

        /* renamed from: b  reason: collision with root package name */
        public final d f62246b;

        /* renamed from: c  reason: collision with root package name */
        public final int f62247c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f62248d = false;

        public b(int i11, e eVar, d dVar) {
            this.f62247c = i11;
            this.f62245a = eVar;
            this.f62246b = dVar;
        }

        public MediaIntent a() {
            androidx.core.util.c<MediaIntent, MediaResult> c11 = this.f62245a.c(this.f62247c);
            MediaIntent mediaIntent = (MediaIntent) c11.f8468a;
            MediaResult mediaResult = (MediaResult) c11.f8469b;
            if (mediaIntent.isAvailable()) {
                this.f62246b.e(this.f62247c, mediaResult);
            }
            return mediaIntent;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final e f62249a;

        /* renamed from: b  reason: collision with root package name */
        public final int f62250b;

        /* renamed from: c  reason: collision with root package name */
        public String f62251c = "*/*";

        /* renamed from: d  reason: collision with root package name */
        public List<String> f62252d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        public boolean f62253e = false;

        public c(int i11, e eVar) {
            this.f62249a = eVar;
            this.f62250b = i11;
        }

        public c a(boolean z11) {
            this.f62253e = z11;
            return this;
        }

        public MediaIntent b() {
            return this.f62249a.f(this.f62250b, this.f62251c, this.f62253e, this.f62252d);
        }

        public c c(String str) {
            this.f62251c = str;
            this.f62252d = new ArrayList();
            return this;
        }
    }

    public MediaIntent(int i11, Intent intent2, String str, boolean z11, int i12) {
        this.requestCode = i11;
        this.intent = intent2;
        this.permission = str;
        this.isAvailable = z11;
        this.target = i12;
    }

    public static MediaIntent notAvailable() {
        return new MediaIntent(-1, (Intent) null, (String) null, false, -1);
    }

    public int describeContents() {
        return 0;
    }

    public Intent getIntent() {
        return this.intent;
    }

    public String getPermission() {
        return this.permission;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    public int getTarget() {
        return this.target;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void open(Fragment fragment) {
        fragment.startActivityForResult(this.intent, this.requestCode);
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.requestCode);
        parcel.writeParcelable(this.intent, i11);
        parcel.writeString(this.permission);
        parcel.writeBooleanArray(new boolean[]{this.isAvailable});
        parcel.writeInt(this.target);
    }

    public void open(Activity activity) {
        activity.startActivityForResult(this.intent, this.requestCode);
    }

    public MediaIntent(Parcel parcel) {
        this.requestCode = parcel.readInt();
        this.intent = (Intent) parcel.readParcelable(MediaIntent.class.getClassLoader());
        this.permission = parcel.readString();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.isAvailable = zArr[0];
        this.target = parcel.readInt();
    }
}
