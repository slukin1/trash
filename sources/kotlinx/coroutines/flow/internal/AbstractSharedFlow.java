package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.j1;

public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {

    /* renamed from: b  reason: collision with root package name */
    public S[] f57232b;

    /* renamed from: c  reason: collision with root package name */
    public int f57233c;

    /* renamed from: d  reason: collision with root package name */
    public int f57234d;

    /* renamed from: e  reason: collision with root package name */
    public o f57235e;

    public final j1<Integer> e() {
        o oVar;
        synchronized (this) {
            oVar = this.f57235e;
            if (oVar == null) {
                oVar = new o(this.f57233c);
                this.f57235e = oVar;
            }
        }
        return oVar;
    }

    public final S h() {
        S s11;
        o oVar;
        synchronized (this) {
            S[] sArr = this.f57232b;
            if (sArr == null) {
                sArr = j(2);
                this.f57232b = sArr;
            } else if (this.f57233c >= sArr.length) {
                S[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                this.f57232b = (AbstractSharedFlowSlot[]) copyOf;
                sArr = (AbstractSharedFlowSlot[]) copyOf;
            }
            int i11 = this.f57234d;
            do {
                s11 = sArr[i11];
                if (s11 == null) {
                    s11 = i();
                    sArr[i11] = s11;
                }
                i11++;
                if (i11 >= sArr.length) {
                    i11 = 0;
                }
            } while (!s11.a(this));
            this.f57234d = i11;
            this.f57233c++;
            oVar = this.f57235e;
        }
        if (oVar != null) {
            oVar.Z(1);
        }
        return s11;
    }

    public abstract S i();

    public abstract S[] j(int i11);

    public final void k(S s11) {
        o oVar;
        int i11;
        c[] b11;
        synchronized (this) {
            int i12 = this.f57233c - 1;
            this.f57233c = i12;
            oVar = this.f57235e;
            if (i12 == 0) {
                this.f57234d = 0;
            }
            b11 = s11.b(this);
        }
        for (c cVar : b11) {
            if (cVar != null) {
                Result.a aVar = Result.Companion;
                cVar.resumeWith(Result.m3072constructorimpl(Unit.f56620a));
            }
        }
        if (oVar != null) {
            oVar.Z(-1);
        }
    }

    public final int l() {
        return this.f57233c;
    }

    public final S[] m() {
        return this.f57232b;
    }
}
