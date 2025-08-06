package lj;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import pro.huobi.R;

public class n0 extends m0 {
    public static final f.i F = null;
    public static final SparseIntArray G;
    public final LinearLayout D;
    public long E;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        G = sparseIntArray;
        sparseIntArray.put(R.id.tvRank, 1);
        sparseIntArray.put(R.id.atv_topic, 2);
    }

    public n0(b bVar, View view) {
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

    public n0(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[2], objArr[1]);
        this.E = -1;
        LinearLayout linearLayout = objArr[0];
        this.D = linearLayout;
        linearLayout.setTag((Object) null);
        G(view);
        t();
    }
}
