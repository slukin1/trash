package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.LivePlayingData;
import com.hbg.module.content.BR;

public class v5 extends u5 {
    public static final f.i G = null;
    public static final SparseIntArray H = null;
    public final LinearLayout C;
    public final ImageView D;
    public final TextView E;
    public long F;

    public v5(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 3, G, H));
    }

    public void M(LivePlayingData.FloatMsg floatMsg) {
        this.B = floatMsg;
        synchronized (this) {
            this.F |= 1;
        }
        notifyPropertyChanged(BR.f17725b);
        super.B();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i() {
        /*
            r8 = this;
            monitor-enter(r8)
            long r0 = r8.F     // Catch:{ all -> 0x002a }
            r2 = 0
            r8.F = r2     // Catch:{ all -> 0x002a }
            monitor-exit(r8)     // Catch:{ all -> 0x002a }
            com.hbg.lib.network.hbg.core.bean.LivePlayingData$FloatMsg r4 = r8.B
            r5 = 0
            r6 = 3
            long r0 = r0 & r6
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            if (r0 == 0) goto L_0x001c
            int r5 = com.hbg.module.content.R$drawable.icon_community_user_header
            if (r4 == 0) goto L_0x001c
            java.lang.String r1 = r4.avatar
            java.lang.String r2 = r4.text
            goto L_0x001d
        L_0x001c:
            r2 = r1
        L_0x001d:
            if (r0 == 0) goto L_0x0029
            android.widget.ImageView r0 = r8.D
            he.b.p(r0, r1, r5)
            android.widget.TextView r0 = r8.E
            androidx.databinding.adapters.TextViewBindingAdapter.c(r0, r2)
        L_0x0029:
            return
        L_0x002a:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x002a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lc.v5.i():void");
    }

    public boolean r() {
        synchronized (this) {
            if (this.F != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.F = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public v5(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0);
        this.F = -1;
        LinearLayout linearLayout = objArr[0];
        this.C = linearLayout;
        linearLayout.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.D = imageView;
        imageView.setTag((Object) null);
        TextView textView = objArr[2];
        this.E = textView;
        textView.setTag((Object) null);
        G(view);
        t();
    }
}
