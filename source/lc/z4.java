package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;

public class z4 extends y4 {
    public static final f.i K = null;
    public static final SparseIntArray L;
    public final ImageView H;
    public final TextView I;
    public long J;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        L = sparseIntArray;
        sparseIntArray.put(R$id.tv_live_type, 3);
        sparseIntArray.put(R$id.tvPlayTime, 4);
        sparseIntArray.put(R$id.ivIcon, 5);
        sparseIntArray.put(R$id.tvName, 6);
    }

    public z4(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 7, K, L));
    }

    public void M(LiveDetailBean liveDetailBean) {
        this.G = liveDetailBean;
        synchronized (this) {
            this.J |= 1;
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
            long r0 = r9.J     // Catch:{ all -> 0x002f }
            r2 = 0
            r9.J = r2     // Catch:{ all -> 0x002f }
            monitor-exit(r9)     // Catch:{ all -> 0x002f }
            r4 = 0
            com.hbg.lib.network.hbg.core.bean.LiveDetailBean r5 = r9.G
            r6 = 3
            long r0 = r0 & r6
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            if (r0 == 0) goto L_0x001f
            int r4 = com.hbg.module.content.R$drawable.icon_image_default
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
            android.widget.ImageView r0 = r9.H
            r3 = 1090519040(0x41000000, float:8.0)
            he.b.o(r0, r1, r3, r4)
            android.widget.TextView r0 = r9.I
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r2)
        L_0x002e:
            return
        L_0x002f:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x002f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lc.z4.i():void");
    }

    public boolean r() {
        synchronized (this) {
            if (this.J != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.J = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public z4(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[0], objArr[5], objArr[3], objArr[6], objArr[4]);
        this.J = -1;
        this.B.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.H = imageView;
        imageView.setTag((Object) null);
        TextView textView = objArr[2];
        this.I = textView;
        textView.setTag((Object) null);
        G(view);
        t();
    }
}
