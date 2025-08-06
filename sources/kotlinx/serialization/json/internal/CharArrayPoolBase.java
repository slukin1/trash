package kotlinx.serialization.json.internal;

import kotlin.Unit;
import kotlin.collections.ArrayDeque;

public class CharArrayPoolBase {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayDeque<char[]> f57867a = new ArrayDeque<>();

    /* renamed from: b  reason: collision with root package name */
    public int f57868b;

    public final void a(char[] cArr) {
        synchronized (this) {
            if (this.f57868b + cArr.length < g.f57902a) {
                this.f57868b += cArr.length;
                this.f57867a.addLast(cArr);
            }
            Unit unit = Unit.f56620a;
        }
    }

    public final char[] b(int i11) {
        char[] l11;
        synchronized (this) {
            l11 = this.f57867a.l();
            if (l11 != null) {
                this.f57868b -= l11.length;
            } else {
                l11 = null;
            }
        }
        return l11 == null ? new char[i11] : l11;
    }
}
