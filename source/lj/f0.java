package lj;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import pro.huobi.R;

public class f0 extends e0 {
    public static final f.i O = null;
    public static final SparseIntArray P;
    public final FrameLayout M;
    public long N;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        P = sparseIntArray;
        sparseIntArray.put(R.id.ivIcon, 1);
        sparseIntArray.put(R.id.tvSymbol, 2);
        sparseIntArray.put(R.id.tvLever, 3);
        sparseIntArray.put(R.id.tvMarginMode, 4);
        sparseIntArray.put(R.id.tvPosSide, 5);
        sparseIntArray.put(R.id.tvSz, 6);
        sparseIntArray.put(R.id.tvSzName, 7);
        sparseIntArray.put(R.id.tvPx, 8);
        sparseIntArray.put(R.id.tvPxName, 9);
        sparseIntArray.put(R.id.tvProfit, 10);
        sparseIntArray.put(R.id.tvProfitName, 11);
    }

    public f0(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 12, O, P));
    }

    public void i() {
        synchronized (this) {
            this.N = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.N != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.N = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f0(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[1], objArr[3], objArr[4], objArr[5], objArr[10], objArr[11], objArr[8], objArr[9], objArr[2], objArr[6], objArr[7]);
        this.N = -1;
        FrameLayout frameLayout = objArr[0];
        this.M = frameLayout;
        frameLayout.setTag((Object) null);
        G(view);
        t();
    }
}
