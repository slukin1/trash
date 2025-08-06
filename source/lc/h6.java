package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class h6 extends g6 {
    public static final f.i E = null;
    public static final SparseIntArray F;
    public final LinearLayout C;
    public long D;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        F = sparseIntArray;
        sparseIntArray.put(R$id.tvRetry, 1);
    }

    public h6(b bVar, View view) {
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

    public h6(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[1]);
        this.D = -1;
        LinearLayout linearLayout = objArr[0];
        this.C = linearLayout;
        linearLayout.setTag((Object) null);
        G(view);
        t();
    }
}
