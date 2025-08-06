package lc;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class f4 extends e4 {
    public static final f.i I = null;
    public static final SparseIntArray J;
    public final ConstraintLayout G;
    public long H;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        J = sparseIntArray;
        sparseIntArray.put(R$id.verticalDivider, 1);
        sparseIntArray.put(R$id.flPoint, 2);
        sparseIntArray.put(R$id.tvTime, 3);
        sparseIntArray.put(R$id.tvTitle, 4);
        sparseIntArray.put(R$id.flowCoinTags, 5);
    }

    public f4(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 6, I, J));
    }

    public void i() {
        synchronized (this) {
            this.H = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.H != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.H = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public f4(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[2], objArr[5], objArr[3], objArr[4], objArr[1]);
        this.H = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.G = constraintLayout;
        constraintLayout.setTag((Object) null);
        G(view);
        t();
    }
}
