package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class n0 extends m0 {
    public static final f.i L = null;
    public static final SparseIntArray M;
    public final LinearLayout J;
    public long K;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        M = sparseIntArray;
        sparseIntArray.put(R$id.vSpace, 1);
        sparseIntArray.put(R$id.ivClose, 2);
        sparseIntArray.put(R$id.llSearch, 3);
        sparseIntArray.put(R$id.etSearch, 4);
        sparseIntArray.put(R$id.llLoading, 5);
        sparseIntArray.put(R$id.srfRefresh, 6);
        sparseIntArray.put(R$id.rvTraders, 7);
        sparseIntArray.put(R$id.tvRecommend, 8);
    }

    public n0(b bVar, View view) {
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
    public n0(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[4], objArr[2], objArr[5], objArr[3], objArr[7], objArr[6], objArr[8], objArr[1]);
        this.K = -1;
        LinearLayout linearLayout = objArr[0];
        this.J = linearLayout;
        linearLayout.setTag((Object) null);
        View view2 = view;
        G(view);
        t();
    }
}
