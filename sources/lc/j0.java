package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class j0 extends i0 {
    public static final f.i M = null;
    public static final SparseIntArray N;
    public final LinearLayout K;
    public long L;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        N = sparseIntArray;
        sparseIntArray.put(R$id.vEmpty, 1);
        sparseIntArray.put(R$id.rlIndicator, 2);
        sparseIntArray.put(R$id.coIndicator, 3);
        sparseIntArray.put(R$id.ivShowInfo, 4);
        sparseIntArray.put(R$id.vpContent, 5);
        sparseIntArray.put(R$id.rlRuleDesc, 6);
        sparseIntArray.put(R$id.ivBack, 7);
        sparseIntArray.put(R$id.tvUserDesc, 8);
        sparseIntArray.put(R$id.tvAnchorDesc, 9);
    }

    public j0(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 10, M, N));
    }

    public void i() {
        synchronized (this) {
            this.L = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.L != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.L = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j0(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[3], objArr[7], objArr[4], objArr[2], objArr[6], objArr[9], objArr[8], objArr[1], objArr[5]);
        this.L = -1;
        LinearLayout linearLayout = objArr[0];
        this.K = linearLayout;
        linearLayout.setTag((Object) null);
        G(view);
        t();
    }
}
