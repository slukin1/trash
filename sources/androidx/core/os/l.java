package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
public final class l {

    public static class a<T> implements Parcelable.ClassLoaderCreator<T> {

        /* renamed from: a  reason: collision with root package name */
        public final m<T> f8413a;

        public a(m<T> mVar) {
            this.f8413a = mVar;
        }

        public T createFromParcel(Parcel parcel) {
            return this.f8413a.createFromParcel(parcel, (ClassLoader) null);
        }

        public T[] newArray(int i11) {
            return this.f8413a.newArray(i11);
        }

        public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.f8413a.createFromParcel(parcel, classLoader);
        }
    }

    @Deprecated
    public static <T> Parcelable.Creator<T> a(m<T> mVar) {
        return new a(mVar);
    }
}
