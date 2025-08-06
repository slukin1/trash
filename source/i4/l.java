package i4;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.business.common.R$id;

public class l extends k {
    public static final f.i G = null;
    public static final SparseIntArray H;
    public final ConstraintLayout E;
    public long F;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        H = sparseIntArray;
        sparseIntArray.put(R$id.flClose, 1);
        sparseIntArray.put(R$id.ivAnimation, 2);
        sparseIntArray.put(R$id.tvContent, 3);
    }

    public l(b bVar, View view) {
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

    public l(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[1], objArr[2], objArr[3]);
        this.F = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.E = constraintLayout;
        constraintLayout.setTag((Object) null);
        G(view);
        t();
    }
}
