package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class x0 extends w0 {
    public static final f.i H = null;
    public static final SparseIntArray I;
    public long G;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        I = sparseIntArray;
        sparseIntArray.put(R$id.loadingLayout, 1);
        sparseIntArray.put(R$id.achievementCount, 2);
        sparseIntArray.put(R$id.recyclerView, 3);
        sparseIntArray.put(R$id.btnAchievement, 4);
    }

    public x0(b bVar, View view) {
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

    public x0(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[2], objArr[4], objArr[1], objArr[3], objArr[0]);
        this.G = -1;
        this.F.setTag((Object) null);
        G(view);
        t();
    }
}
