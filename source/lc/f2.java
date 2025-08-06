package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;

public class f2 extends e2 {
    public static final f.i L;
    public static final SparseIntArray M;
    public final CollapsingToolbarLayout J;
    public long K;

    static {
        f.i iVar = new f.i(9);
        L = iVar;
        iVar.a(1, new String[]{"item_live_banner"}, new int[]{2}, new int[]{R$layout.item_live_banner});
        SparseIntArray sparseIntArray = new SparseIntArray();
        M = sparseIntArray;
        sparseIntArray.put(R$id.coordinator, 3);
        sparseIntArray.put(R$id.appBarLayout, 4);
        sparseIntArray.put(R$id.coIndicator, 5);
        sparseIntArray.put(R$id.vLine, 6);
        sparseIntArray.put(R$id.nestLay, 7);
        sparseIntArray.put(R$id.vpContent, 8);
    }

    public f2(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 9, L, M));
    }

    public final boolean M(q4 q4Var, int i11) {
        if (i11 != BR.f17724a) {
            return false;
        }
        synchronized (this) {
            this.K |= 1;
        }
        return true;
    }

    public void i() {
        synchronized (this) {
            this.K = 0;
        }
        f.k(this.C);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.C.r() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean r() {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.K     // Catch:{ all -> 0x0018 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            lc.q4 r0 = r4.C
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lc.f2.r():boolean");
    }

    public void t() {
        synchronized (this) {
            this.K = 2;
        }
        this.C.t();
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        if (i11 != 0) {
            return false;
        }
        return M((q4) obj, i12);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f2(b bVar, View view, Object[] objArr) {
        super(bVar, view, 1, objArr[4], objArr[2], objArr[5], objArr[3], objArr[7], objArr[0], objArr[6], objArr[8]);
        this.K = -1;
        E(this.C);
        CollapsingToolbarLayout collapsingToolbarLayout = objArr[1];
        this.J = collapsingToolbarLayout;
        collapsingToolbarLayout.setTag((Object) null);
        this.G.setTag((Object) null);
        View view2 = view;
        G(view);
        t();
    }
}
