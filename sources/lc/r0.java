package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.R$id;

public class r0 extends q0 {
    public static final f.i H = null;
    public static final SparseIntArray I;
    public final RelativeLayout F;
    public long G;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        I = sparseIntArray;
        sparseIntArray.put(R$id.tvDialogTitle, 1);
        sparseIntArray.put(R$id.etReason, 2);
        sparseIntArray.put(R$id.tvCancel, 3);
        sparseIntArray.put(R$id.tvConfirm, 4);
    }

    public r0(b bVar, View view) {
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

    public r0(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[2], objArr[3], objArr[4], objArr[1]);
        this.G = -1;
        RelativeLayout relativeLayout = objArr[0];
        this.F = relativeLayout;
        relativeLayout.setTag((Object) null);
        G(view);
        t();
    }
}
