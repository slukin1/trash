package v1;

import android.view.View;
import android.view.WindowId;

public class c0 implements d0 {

    /* renamed from: a  reason: collision with root package name */
    public final WindowId f16637a;

    public c0(View view) {
        this.f16637a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof c0) && ((c0) obj).f16637a.equals(this.f16637a);
    }

    public int hashCode() {
        return this.f16637a.hashCode();
    }
}
