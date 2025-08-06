package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class b1 extends a1 {
    public static final f.i H = null;
    public static final SparseIntArray I;
    public final LinearLayout F;
    public long G;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        I = sparseIntArray;
        sparseIntArray.put(R$id.loading_layout, 1);
        sparseIntArray.put(R$id.sflDetail, 2);
        sparseIntArray.put(R$id.rvContent, 3);
        sparseIntArray.put(R$id.tvComment, 4);
    }

    public b1(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 5, H, I));
    }

    public void i() {
        synchronized (this) {
            this.G = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.G != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.G = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public b1(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[1], objArr[3], objArr[2], objArr[4]);
        this.G = -1;
        LinearLayout linearLayout = objArr[0];
        this.F = linearLayout;
        linearLayout.setTag((Object) null);
        G(view);
        t();
    }
}
