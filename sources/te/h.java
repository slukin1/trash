package te;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.libkt.BR;
import com.hbg.module.libkt.R$id;
import com.hbg.module.libkt.R$layout;

public class h extends g {
    public static final f.i N;
    public static final SparseIntArray O;
    public long M;

    static {
        f.i iVar = new f.i(11);
        N = iVar;
        iVar.a(0, new String[]{"feed_vod_loading", "feed_vod_load_error"}, new int[]{1, 2}, new int[]{R$layout.feed_vod_loading, R$layout.feed_vod_load_error});
        SparseIntArray sparseIntArray = new SparseIntArray();
        O = sparseIntArray;
        sparseIntArray.put(R$id.txCloudView, 3);
        sparseIntArray.put(R$id.rlTopShape, 4);
        sparseIntArray.put(R$id.ivMute, 5);
        sparseIntArray.put(R$id.ivPlayControl, 6);
        sparseIntArray.put(R$id.llSeek, 7);
        sparseIntArray.put(R$id.tvPlayTime, 8);
        sparseIntArray.put(R$id.mSeekBar, 9);
        sparseIntArray.put(R$id.tvAllTime, 10);
    }

    public h(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 11, N, O));
    }

    public final boolean M(e eVar, int i11) {
        if (i11 != BR.f24495a) {
            return false;
        }
        synchronized (this) {
            this.M |= 2;
        }
        return true;
    }

    public final boolean N(c cVar, int i11) {
        if (i11 != BR.f24495a) {
            return false;
        }
        synchronized (this) {
            this.M |= 1;
        }
        return true;
    }

    public void i() {
        synchronized (this) {
            this.M = 0;
        }
        f.k(this.K);
        f.k(this.L);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r4.L.r() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.K.r() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean r() {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.M     // Catch:{ all -> 0x0021 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0021 }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x0021 }
            te.e r0 = r4.K
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            te.c r0 = r4.L
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x001f
            return r1
        L_0x001f:
            r0 = 0
            return r0
        L_0x0021:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0021 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: te.h.r():boolean");
    }

    public void t() {
        synchronized (this) {
            this.M = 4;
        }
        this.K.t();
        this.L.t();
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        if (i11 == 0) {
            return N((c) obj, i12);
        }
        if (i11 != 1) {
            return false;
        }
        return M((e) obj, i12);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(b bVar, View view, Object[] objArr) {
        super(bVar, view, 2, objArr[0], objArr[5], objArr[6], objArr[7], objArr[9], objArr[4], objArr[10], objArr[8], objArr[3], objArr[1], objArr[2]);
        this.M = -1;
        this.B.setTag((Object) null);
        E(this.K);
        E(this.L);
        G(view);
        t();
    }
}
