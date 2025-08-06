package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.r;

@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new b();
    public static final c Companion = new c((r) null);
    private final Intent fillInIntent;
    private final int flagsMask;
    private final int flagsValues;
    private final IntentSender intentSender;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final IntentSender f3708a;

        /* renamed from: b  reason: collision with root package name */
        public Intent f3709b;

        /* renamed from: c  reason: collision with root package name */
        public int f3710c;

        /* renamed from: d  reason: collision with root package name */
        public int f3711d;

        public a(IntentSender intentSender) {
            this.f3708a = intentSender;
        }

        public final IntentSenderRequest a() {
            return new IntentSenderRequest(this.f3708a, this.f3709b, this.f3710c, this.f3711d);
        }

        public final a b(Intent intent) {
            this.f3709b = intent;
            return this;
        }

        public final a c(int i11, int i12) {
            this.f3711d = i11;
            this.f3710c = i12;
            return this;
        }
    }

    public static final class b implements Parcelable.Creator<IntentSenderRequest> {
        /* renamed from: a */
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        /* renamed from: b */
        public IntentSenderRequest[] newArray(int i11) {
            return new IntentSenderRequest[i11];
        }
    }

    public static final class c {
        public c() {
        }

        public /* synthetic */ c(r rVar) {
            this();
        }
    }

    public IntentSenderRequest(IntentSender intentSender2, Intent intent, int i11, int i12) {
        this.intentSender = intentSender2;
        this.fillInIntent = intent;
        this.flagsMask = i11;
        this.flagsValues = i12;
    }

    public int describeContents() {
        return 0;
    }

    public final Intent getFillInIntent() {
        return this.fillInIntent;
    }

    public final int getFlagsMask() {
        return this.flagsMask;
    }

    public final int getFlagsValues() {
        return this.flagsValues;
    }

    public final IntentSender getIntentSender() {
        return this.intentSender;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(this.intentSender, i11);
        parcel.writeParcelable(this.fillInIntent, i11);
        parcel.writeInt(this.flagsMask);
        parcel.writeInt(this.flagsValues);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IntentSenderRequest(IntentSender intentSender2, Intent intent, int i11, int i12, int i13, r rVar) {
        this(intentSender2, (i13 & 2) != 0 ? null : intent, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    public IntentSenderRequest(Parcel parcel) {
        this((IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader()), (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }
}
