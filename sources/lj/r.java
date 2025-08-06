package lj;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.b;
import androidx.databinding.f;
import pro.huobi.R;

public class r extends q {
    public static final f.i K = null;
    public static final SparseIntArray L;
    public final LinearLayoutCompat I;
    public long J;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        L = sparseIntArray;
        sparseIntArray.put(R.id.vTopBar, 1);
        sparseIntArray.put(R.id.rl_top_bar, 2);
        sparseIntArray.put(R.id.iv_message_back, 3);
        sparseIntArray.put(R.id.coIndicator, 4);
        sparseIntArray.put(R.id.iv_message_clear, 5);
        sparseIntArray.put(R.id.iv_more, 6);
        sparseIntArray.put(R.id.vp_message, 7);
    }

    public r(b bVar, View view) {
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

    public r(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[4], objArr[3], objArr[5], objArr[6], objArr[2], objArr[1], objArr[7]);
        this.J = -1;
        LinearLayoutCompat linearLayoutCompat = objArr[0];
        this.I = linearLayoutCompat;
        linearLayoutCompat.setTag((Object) null);
        G(view);
        t();
    }
}
