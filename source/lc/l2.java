package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class l2 extends k2 {
    public static final f.i F = null;
    public static final SparseIntArray G;
    public long E;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        G = sparseIntArray;
        sparseIntArray.put(R$id.srl_loading_layout, 1);
        sparseIntArray.put(R$id.rv_tab_content, 2);
    }

    public l2(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 3, F, G));
    }

    public void i() {
        synchronized (this) {
            this.E = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.E != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.E = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public l2(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[2], objArr[1], objArr[0]);
        this.E = -1;
        this.D.setTag((Object) null);
        G(view);
        t();
    }
}
