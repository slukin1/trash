package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class d5 extends c5 {
    public static final f.i F = null;
    public static final SparseIntArray G;
    public final ConstraintLayout D;
    public long E;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        G = sparseIntArray;
        sparseIntArray.put(R$id.tvDesc, 1);
        sparseIntArray.put(R$id.ivImg, 2);
    }

    public d5(b bVar, View view) {
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

    public d5(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[2], objArr[1]);
        this.E = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.D = constraintLayout;
        constraintLayout.setTag((Object) null);
        G(view);
        t();
    }
}
