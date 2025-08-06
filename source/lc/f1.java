package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class f1 extends e1 {
    public static final f.i E = null;
    public static final SparseIntArray F;
    public long D;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        F = sparseIntArray;
        sparseIntArray.put(R$id.rvContent, 1);
    }

    public f1(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 2, E, F));
    }

    public void i() {
        synchronized (this) {
            this.D = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.D != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.D = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public f1(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[0], objArr[1]);
        this.D = -1;
        this.B.setTag((Object) null);
        G(view);
        t();
    }
}
