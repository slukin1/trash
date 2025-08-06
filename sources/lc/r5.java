package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.SisterBean;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$id;

public class r5 extends q5 {
    public static final f.i J = null;
    public static final SparseIntArray K;
    public long I;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        K = sparseIntArray;
        sparseIntArray.put(R$id.vLeft, 2);
        sparseIntArray.put(R$id.ivCircle, 3);
        sparseIntArray.put(R$id.tvNum, 4);
        sparseIntArray.put(R$id.vRight, 5);
    }

    public r5(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 6, J, K));
    }

    public void M(SisterBean sisterBean) {
        this.H = sisterBean;
        synchronized (this) {
            this.I |= 1;
        }
        notifyPropertyChanged(BR.f17725b);
        super.B();
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.I;
            this.I = 0;
        }
        String str = null;
        int i11 = 0;
        SisterBean sisterBean = this.H;
        int i12 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        if (i12 != 0) {
            i11 = R$drawable.icon_default_avatar;
            if (sisterBean != null) {
                str = sisterBean.avatar;
            }
        }
        if (i12 != 0) {
            he.b.p(this.B, str, i11);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.I != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.I = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public r5(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[1], objArr[3], objArr[0], objArr[4], objArr[2], objArr[5]);
        this.I = -1;
        this.B.setTag((Object) null);
        this.D.setTag((Object) null);
        G(view);
        t();
    }
}
