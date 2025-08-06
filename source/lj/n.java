package lj;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import pro.huobi.R;

public class n extends m {
    public static final f.i L = null;
    public static final SparseIntArray M;
    public long K;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        M = sparseIntArray;
        sparseIntArray.put(R.id.vTopBar, 1);
        sparseIntArray.put(R.id.fl_navRoot, 2);
        sparseIntArray.put(R.id.ll_title, 3);
        sparseIntArray.put(R.id.iv_left_icon, 4);
        sparseIntArray.put(R.id.tv_title, 5);
        sparseIntArray.put(R.id.iv_right_icon, 6);
        sparseIntArray.put(R.id.tvRightBtn, 7);
        sparseIntArray.put(R.id.llContent, 8);
    }

    public n(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 9, L, M));
    }

    public void i() {
        synchronized (this) {
            this.K = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.K != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.K = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[2], objArr[4], objArr[6], objArr[8], objArr[3], objArr[0], objArr[7], objArr[5], objArr[1]);
        this.K = -1;
        this.G.setTag((Object) null);
        G(view);
        t();
    }
}
