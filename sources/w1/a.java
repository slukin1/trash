package w1;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;
import java.lang.reflect.Method;

public class a extends VersionedParcel {

    /* renamed from: d  reason: collision with root package name */
    public final SparseIntArray f16729d;

    /* renamed from: e  reason: collision with root package name */
    public final Parcel f16730e;

    /* renamed from: f  reason: collision with root package name */
    public final int f16731f;

    /* renamed from: g  reason: collision with root package name */
    public final int f16732g;

    /* renamed from: h  reason: collision with root package name */
    public final String f16733h;

    /* renamed from: i  reason: collision with root package name */
    public int f16734i;

    /* renamed from: j  reason: collision with root package name */
    public int f16735j;

    /* renamed from: k  reason: collision with root package name */
    public int f16736k;

    public a(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    public void A(byte[] bArr) {
        if (bArr != null) {
            this.f16730e.writeInt(bArr.length);
            this.f16730e.writeByteArray(bArr);
            return;
        }
        this.f16730e.writeInt(-1);
    }

    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f16730e, 0);
    }

    public void E(int i11) {
        this.f16730e.writeInt(i11);
    }

    public void G(Parcelable parcelable) {
        this.f16730e.writeParcelable(parcelable, 0);
    }

    public void I(String str) {
        this.f16730e.writeString(str);
    }

    public void a() {
        int i11 = this.f16734i;
        if (i11 >= 0) {
            int i12 = this.f16729d.get(i11);
            int dataPosition = this.f16730e.dataPosition();
            this.f16730e.setDataPosition(i12);
            this.f16730e.writeInt(dataPosition - i12);
            this.f16730e.setDataPosition(dataPosition);
        }
    }

    public VersionedParcel b() {
        Parcel parcel = this.f16730e;
        int dataPosition = parcel.dataPosition();
        int i11 = this.f16735j;
        if (i11 == this.f16731f) {
            i11 = this.f16732g;
        }
        int i12 = i11;
        return new a(parcel, dataPosition, i12, this.f16733h + "  ", this.f12009a, this.f12010b, this.f12011c);
    }

    public boolean g() {
        return this.f16730e.readInt() != 0;
    }

    public byte[] i() {
        int readInt = this.f16730e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f16730e.readByteArray(bArr);
        return bArr;
    }

    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f16730e);
    }

    public boolean m(int i11) {
        while (this.f16735j < this.f16732g) {
            int i12 = this.f16736k;
            if (i12 == i11) {
                return true;
            }
            if (String.valueOf(i12).compareTo(String.valueOf(i11)) > 0) {
                return false;
            }
            this.f16730e.setDataPosition(this.f16735j);
            int readInt = this.f16730e.readInt();
            this.f16736k = this.f16730e.readInt();
            this.f16735j += readInt;
        }
        if (this.f16736k == i11) {
            return true;
        }
        return false;
    }

    public int o() {
        return this.f16730e.readInt();
    }

    public <T extends Parcelable> T q() {
        return this.f16730e.readParcelable(getClass().getClassLoader());
    }

    public String s() {
        return this.f16730e.readString();
    }

    public void w(int i11) {
        a();
        this.f16734i = i11;
        this.f16729d.put(i11, this.f16730e.dataPosition());
        E(0);
        E(i11);
    }

    public void y(boolean z11) {
        this.f16730e.writeInt(z11 ? 1 : 0);
    }

    public a(Parcel parcel, int i11, int i12, String str, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.f16729d = new SparseIntArray();
        this.f16734i = -1;
        this.f16735j = 0;
        this.f16736k = -1;
        this.f16730e = parcel;
        this.f16731f = i11;
        this.f16732g = i12;
        this.f16735j = i11;
        this.f16733h = str;
    }
}
