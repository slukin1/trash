package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class h2 extends g2 {
    public static final f.i L = null;
    public static final SparseIntArray M;
    public long K;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        M = sparseIntArray;
        sparseIntArray.put(R$id.llUGC, 1);
        sparseIntArray.put(R$id.tvComplete, 2);
        sparseIntArray.put(R$id.tvCompleteNum, 3);
        sparseIntArray.put(R$id.tvUGCAmount, 4);
        sparseIntArray.put(R$id.rvUGCList, 5);
        sparseIntArray.put(R$id.lineView, 6);
        sparseIntArray.put(R$id.srl_loading_layout, 7);
        sparseIntArray.put(R$id.rv_tab_content, 8);
    }

    public h2(b bVar, View view) {
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
    public h2(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[6], objArr[1], objArr[8], objArr[5], objArr[7], objArr[0], objArr[2], objArr[3], objArr[4]);
        this.K = -1;
        this.G.setTag((Object) null);
        G(view);
        t();
    }
}
