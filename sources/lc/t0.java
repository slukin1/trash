package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class t0 extends s0 {
    public static final f.i K = null;
    public static final SparseIntArray L;
    public final LinearLayout I;
    public long J;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        L = sparseIntArray;
        sparseIntArray.put(R$id.vEmpty, 1);
        sparseIntArray.put(R$id.ivBack, 2);
        sparseIntArray.put(R$id.etSearch, 3);
        sparseIntArray.put(R$id.ivClose, 4);
        sparseIntArray.put(R$id.tvSearch, 5);
        sparseIntArray.put(R$id.loadingLayout, 6);
        sparseIntArray.put(R$id.rvContent, 7);
    }

    public t0(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 8, K, L));
    }

    public void i() {
        synchronized (this) {
            this.J = 0;
        }
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
            this.J = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public t0(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[3], objArr[2], objArr[4], objArr[6], objArr[7], objArr[5], objArr[1]);
        this.J = -1;
        LinearLayout linearLayout = objArr[0];
        this.I = linearLayout;
        linearLayout.setTag((Object) null);
        G(view);
        t();
    }
}
