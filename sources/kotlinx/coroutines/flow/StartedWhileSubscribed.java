package kotlinx.coroutines.flow;

import com.fluttercandies.photo_manager.core.entity.a;
import d10.l;
import java.util.List;
import kotlin.coroutines.c;

public final class StartedWhileSubscribed implements i1 {

    /* renamed from: b  reason: collision with root package name */
    public final long f57205b;

    /* renamed from: c  reason: collision with root package name */
    public final long f57206c;

    public StartedWhileSubscribed(long j11, long j12) {
        this.f57205b = j11;
        this.f57206c = j12;
        boolean z11 = true;
        if (j11 >= 0) {
            if (!(j12 < 0 ? false : z11)) {
                throw new IllegalArgumentException(("replayExpiration(" + j12 + " ms) cannot be negative").toString());
            }
            return;
        }
        throw new IllegalArgumentException(("stopTimeout(" + j11 + " ms) cannot be negative").toString());
    }

    public d<SharingCommand> a(j1<Integer> j1Var) {
        return f.s(f.u(f.c0(j1Var, new StartedWhileSubscribed$command$1(this, (c<? super StartedWhileSubscribed$command$1>) null)), new StartedWhileSubscribed$command$2((c<? super StartedWhileSubscribed$command$2>) null)));
    }

    public boolean equals(Object obj) {
        if (obj instanceof StartedWhileSubscribed) {
            StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) obj;
            return this.f57205b == startedWhileSubscribed.f57205b && this.f57206c == startedWhileSubscribed.f57206c;
        }
    }

    public int hashCode() {
        return (a.a(this.f57205b) * 31) + a.a(this.f57206c);
    }

    public String toString() {
        List d11 = CollectionsKt__CollectionsJVMKt.d(2);
        if (this.f57205b > 0) {
            d11.add("stopTimeout=" + this.f57205b + "ms");
        }
        if (this.f57206c < Long.MAX_VALUE) {
            d11.add("replayExpiration=" + this.f57206c + "ms");
        }
        List a11 = CollectionsKt__CollectionsJVMKt.a(d11);
        return "SharingStarted.WhileSubscribed(" + CollectionsKt___CollectionsKt.k0(a11, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 63, (Object) null) + ')';
    }
}
