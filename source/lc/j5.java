package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class j5 extends i5 {
    public static final f.i G = null;
    public static final SparseIntArray H;
    public final LinearLayout E;
    public long F;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        H = sparseIntArray;
        sparseIntArray.put(R$id.llTitleMore, 1);
        sparseIntArray.put(R$id.tvTitle, 2);
        sparseIntArray.put(R$id.rvList, 3);
    }

    public j5(b bVar, View view) {
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

    public j5(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[1], objArr[3], objArr[2]);
        this.F = -1;
        LinearLayout linearLayout = objArr[0];
        this.E = linearLayout;
        linearLayout.setTag((Object) null);
        G(view);
        t();
    }
}
