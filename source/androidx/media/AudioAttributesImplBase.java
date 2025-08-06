package androidx.media;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import java.util.Arrays;

class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    public int f10086a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f10087b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f10088c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f10089d = -1;

    public int a() {
        return this.f10087b;
    }

    public int b() {
        int i11 = this.f10088c;
        int c11 = c();
        if (c11 == 6) {
            i11 |= 4;
        } else if (c11 == 7) {
            i11 |= 1;
        }
        return i11 & TUIMessageBean.MSG_STATUS_READ;
    }

    public int c() {
        int i11 = this.f10089d;
        if (i11 != -1) {
            return i11;
        }
        return AudioAttributesCompat.a(false, this.f10088c, this.f10086a);
    }

    public int d() {
        return this.f10086a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f10087b == audioAttributesImplBase.a() && this.f10088c == audioAttributesImplBase.b() && this.f10086a == audioAttributesImplBase.d() && this.f10089d == audioAttributesImplBase.f10089d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f10087b), Integer.valueOf(this.f10088c), Integer.valueOf(this.f10086a), Integer.valueOf(this.f10089d)});
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("AudioAttributesCompat:");
        if (this.f10089d != -1) {
            sb2.append(" stream=");
            sb2.append(this.f10089d);
            sb2.append(" derived");
        }
        sb2.append(" usage=");
        sb2.append(AudioAttributesCompat.b(this.f10086a));
        sb2.append(" content=");
        sb2.append(this.f10087b);
        sb2.append(" flags=0x");
        sb2.append(Integer.toHexString(this.f10088c).toUpperCase());
        return sb2.toString();
    }
}
