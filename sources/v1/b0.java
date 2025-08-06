package v1;

import android.os.IBinder;

public class b0 implements d0 {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f16636a;

    public b0(IBinder iBinder) {
        this.f16636a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof b0) && ((b0) obj).f16636a.equals(this.f16636a);
    }

    public int hashCode() {
        return this.f16636a.hashCode();
    }
}
