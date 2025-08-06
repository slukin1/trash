package lj;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import pro.huobi.R;

public class l extends k {
    public static final f.i H = null;
    public static final SparseIntArray I;
    public long G;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        I = sparseIntArray;
        sparseIntArray.put(R.id.vTopBar, 1);
        sparseIntArray.put(R.id.vp_main, 2);
        sparseIntArray.put(R.id.tab_line, 3);
        sparseIntArray.put(R.id.main_tab, 4);
    }

    public l(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 5, H, I));
    }

    public void i() {
        synchronized (this) {
            this.G = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.G != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.G = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public l(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[4], objArr[0], objArr[3], objArr[1], objArr[2]);
        this.G = -1;
        this.C.setTag((Object) null);
        G(view);
        t();
    }
}
