package lj;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import pro.huobi.R;

public class h extends g {
    public static final f.i K = null;
    public static final SparseIntArray L;
    public final LinearLayout I;
    public long J;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        L = sparseIntArray;
        sparseIntArray.put(R.id.vTopBar, 1);
        sparseIntArray.put(R.id.tvTitle, 2);
        sparseIntArray.put(R.id.ivBack, 3);
        sparseIntArray.put(R.id.ivRight, 4);
        sparseIntArray.put(R.id.edgeTop, 5);
        sparseIntArray.put(R.id.tabLayout, 6);
        sparseIntArray.put(R.id.viewPager, 7);
    }

    public h(b bVar, View view) {
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

    public h(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[5], objArr[3], objArr[4], objArr[6], objArr[2], objArr[1], objArr[7]);
        this.J = -1;
        LinearLayout linearLayout = objArr[0];
        this.I = linearLayout;
        linearLayout.setTag((Object) null);
        G(view);
        t();
    }
}
