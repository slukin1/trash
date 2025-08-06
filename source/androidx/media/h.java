package androidx.media;

import android.text.TextUtils;
import androidx.core.util.b;

public class h implements f {

    /* renamed from: a  reason: collision with root package name */
    public String f10191a;

    /* renamed from: b  reason: collision with root package name */
    public int f10192b;

    /* renamed from: c  reason: collision with root package name */
    public int f10193c;

    public h(String str, int i11, int i12) {
        this.f10191a = str;
        this.f10192b = i11;
        this.f10193c = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (TextUtils.equals(this.f10191a, hVar.f10191a) && this.f10192b == hVar.f10192b && this.f10193c == hVar.f10193c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return b.b(this.f10191a, Integer.valueOf(this.f10192b), Integer.valueOf(this.f10193c));
    }
}
