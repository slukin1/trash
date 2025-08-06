package xe;

import com.hbg.module.libkt.utils.event.bean.GiftBean;
import java.util.Arrays;
import kotlin.jvm.internal.x;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public GiftBean f26374a;

    /* renamed from: b  reason: collision with root package name */
    public int f26375b;

    /* renamed from: c  reason: collision with root package name */
    public int f26376c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f26377d;

    public h(GiftBean giftBean, int i11, int i12, int[] iArr) {
        this.f26374a = giftBean;
        this.f26375b = i11;
        this.f26376c = i12;
        this.f26377d = iArr;
    }

    public final GiftBean a() {
        return this.f26374a;
    }

    public final int[] b() {
        return this.f26377d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return x.b(this.f26374a, hVar.f26374a) && this.f26375b == hVar.f26375b && this.f26376c == hVar.f26376c && x.b(this.f26377d, hVar.f26377d);
    }

    public int hashCode() {
        return (((((this.f26374a.hashCode() * 31) + this.f26375b) * 31) + this.f26376c) * 31) + Arrays.hashCode(this.f26377d);
    }

    public String toString() {
        return "RewardGiftEvent(gift=" + this.f26374a + ", type=" + this.f26375b + ", combo=" + this.f26376c + ", location=" + Arrays.toString(this.f26377d) + ')';
    }
}
