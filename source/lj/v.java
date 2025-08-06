package lj;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import pro.huobi.R;

public class v extends u {
    public static final f.i L = null;
    public static final SparseIntArray M;
    public long K;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        M = sparseIntArray;
        sparseIntArray.put(R.id.topRoot, 1);
        sparseIntArray.put(R.id.tvTitle, 2);
        sparseIntArray.put(R.id.tvSubTitle, 3);
        sparseIntArray.put(R.id.ivRight, 4);
        sparseIntArray.put(R.id.centerRoot, 5);
        sparseIntArray.put(R.id.llContent, 6);
        sparseIntArray.put(R.id.bottomRoot, 7);
        sparseIntArray.put(R.id.btConfirm, 8);
    }

    public v(b bVar, View view) {
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
    public v(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[7], objArr[8], objArr[5], objArr[4], objArr[6], objArr[0], objArr[1], objArr[3], objArr[2]);
        this.K = -1;
        this.G.setTag((Object) null);
        G(view);
        t();
    }
}
