package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;

public class x4 extends w4 {
    public static final f.i V = null;
    public static final SparseIntArray W;
    public long U;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        W = sparseIntArray;
        sparseIntArray.put(R$id.ll_live_hint, 3);
        sparseIntArray.put(R$id.iv_live_playing, 4);
        sparseIntArray.put(R$id.tv_live_type, 5);
        sparseIntArray.put(R$id.tv_play_time, 6);
        sparseIntArray.put(R$id.rl_title, 7);
        sparseIntArray.put(R$id.iv_icon, 8);
        sparseIntArray.put(R$id.tv_name, 9);
        sparseIntArray.put(R$id.llCountDown, 10);
        sparseIntArray.put(R$id.tvDay, 11);
        sparseIntArray.put(R$id.tvHour, 12);
        sparseIntArray.put(R$id.tvMinute, 13);
        sparseIntArray.put(R$id.tvSecond, 14);
        sparseIntArray.put(R$id.ll_into, 15);
        sparseIntArray.put(R$id.tv_prepare, 16);
        sparseIntArray.put(R$id.iv_into, 17);
    }

    public x4(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 18, V, W));
    }

    public void M(LiveDetailBean liveDetailBean) {
        this.T = liveDetailBean;
        synchronized (this) {
            this.U |= 1;
        }
        notifyPropertyChanged(BR.f17725b);
        super.B();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i() {
        /*
            r9 = this;
            monitor-enter(r9)
            long r0 = r9.U     // Catch:{ all -> 0x002f }
            r2 = 0
            r9.U = r2     // Catch:{ all -> 0x002f }
            monitor-exit(r9)     // Catch:{ all -> 0x002f }
            r4 = 0
            com.hbg.lib.network.hbg.core.bean.LiveDetailBean r5 = r9.T
            r6 = 3
            long r0 = r0 & r6
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            if (r0 == 0) goto L_0x001f
            int r4 = com.hbg.module.content.R$drawable.icon_image_default_big
            if (r5 == 0) goto L_0x001f
            java.lang.String r1 = r5.title
            java.lang.String r2 = r5.coverImageUrl
            r8 = r2
            r2 = r1
            r1 = r8
            goto L_0x0020
        L_0x001f:
            r2 = r1
        L_0x0020:
            if (r0 == 0) goto L_0x002e
            android.widget.ImageView r0 = r9.C
            r3 = 1090519040(0x41000000, float:8.0)
            he.b.o(r0, r1, r3, r4)
            android.widget.TextView r0 = r9.M
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r2)
        L_0x002e:
            return
        L_0x002f:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x002f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lc.x4.i():void");
    }

    public boolean r() {
        synchronized (this) {
            if (this.U != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.U = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public x4(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[0], objArr[1], objArr[8], objArr[17], objArr[4], objArr[10], objArr[15], objArr[3], objArr[7], objArr[11], objArr[12], objArr[2], objArr[5], objArr[13], objArr[9], objArr[6], objArr[16], objArr[14]);
        this.U = -1;
        this.B.setTag((Object) null);
        this.C.setTag((Object) null);
        this.M.setTag((Object) null);
        G(view);
        t();
    }
}
