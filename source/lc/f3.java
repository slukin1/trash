package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;

public class f3 extends e3 {
    public static final f.i Z;

    /* renamed from: a0  reason: collision with root package name */
    public static final SparseIntArray f19167a0;
    public long Y;

    static {
        f.i iVar = new f.i(23);
        Z = iVar;
        iVar.a(0, new String[]{"item_community_feed_comment", "item_community_feed_reply_comment"}, new int[]{1, 2}, new int[]{R$layout.item_community_feed_comment, R$layout.item_community_feed_reply_comment});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f19167a0 = sparseIntArray;
        sparseIntArray.put(R$id.imageHeader, 3);
        sparseIntArray.put(R$id.tvNickName, 4);
        sparseIntArray.put(R$id.tvDateTime, 5);
        sparseIntArray.put(R$id.btnAttention, 6);
        sparseIntArray.put(R$id.imageAttentionPlus, 7);
        sparseIntArray.put(R$id.tvARAction, 8);
        sparseIntArray.put(R$id.tvTitle, 9);
        sparseIntArray.put(R$id.tvContent, 10);
        sparseIntArray.put(R$id.imageLayout, 11);
        sparseIntArray.put(R$id.tv_topic, 12);
        sparseIntArray.put(R$id.rlShare, 13);
        sparseIntArray.put(R$id.imageShare, 14);
        sparseIntArray.put(R$id.rlCommon, 15);
        sparseIntArray.put(R$id.imageCommon, 16);
        sparseIntArray.put(R$id.tvCommon, 17);
        sparseIntArray.put(R$id.rlLike, 18);
        sparseIntArray.put(R$id.imageLike, 19);
        sparseIntArray.put(R$id.tvLike, 20);
        sparseIntArray.put(R$id.imageMore, 21);
        sparseIntArray.put(R$id.lineView, 22);
    }

    public f3(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 23, Z, f19167a0));
    }

    public final boolean K(c3 c3Var, int i11) {
        if (i11 != BR.f17724a) {
            return false;
        }
        synchronized (this) {
            this.Y |= 1;
        }
        return true;
    }

    public final boolean L(g3 g3Var, int i11) {
        if (i11 != BR.f17724a) {
            return false;
        }
        synchronized (this) {
            this.Y |= 2;
        }
        return true;
    }

    public void i() {
        synchronized (this) {
            this.Y = 0;
        }
        f.k(this.C);
        f.k(this.D);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r4.D.r() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
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
            long r0 = r4.Y     // Catch:{ all -> 0x0021 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0021 }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x0021 }
            lc.c3 r0 = r4.C
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            lc.g3 r0 = r4.D
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
        throw new UnsupportedOperationException("Method not decompiled: lc.f3.r():boolean");
    }

    public void t() {
        synchronized (this) {
            this.Y = 4;
        }
        this.C.t();
        this.D.t();
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        if (i11 == 0) {
            return K((c3) obj, i12);
        }
        if (i11 != 1) {
            return false;
        }
        return L((g3) obj, i12);
    }

    public f3(b bVar, View view, Object[] objArr) {
        super(bVar, view, 2, objArr[6], objArr[1], objArr[2], objArr[0], objArr[7], objArr[16], objArr[3], objArr[11], objArr[19], objArr[21], objArr[14], objArr[22], objArr[15], objArr[18], objArr[13], objArr[8], objArr[17], objArr[10], objArr[5], objArr[20], objArr[4], objArr[9], objArr[12]);
        this.Y = -1;
        E(this.C);
        E(this.D);
        this.E.setTag((Object) null);
        G(view);
        t();
    }
}
