package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class b0 extends a0 {
    public static final f.i G = null;
    public static final SparseIntArray H;
    public long F;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        H = sparseIntArray;
        sparseIntArray.put(R$id.iconImage, 1);
        sparseIntArray.put(R$id.tvSymbol, 2);
        sparseIntArray.put(R$id.tvSymbolPercent, 3);
    }

    public b0(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 4, G, H));
    }

    public void i() {
        synchronized (this) {
            this.F = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.F != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.F = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public b0(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[1], objArr[0], objArr[2], objArr[3]);
        this.F = -1;
        this.C.setTag((Object) null);
        G(view);
        t();
    }
}
