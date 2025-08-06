package i4;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.business.common.R$id;

public class d extends c {
    public static final f.i O = null;
    public static final SparseIntArray P;
    public final ConstraintLayout M;
    public long N;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        P = sparseIntArray;
        sparseIntArray.put(R$id.ivAnimation, 1);
        sparseIntArray.put(R$id.flContent, 2);
        sparseIntArray.put(R$id.tvTitle, 3);
        sparseIntArray.put(R$id.tvSubTitle, 4);
        sparseIntArray.put(R$id.recyclerView, 5);
        sparseIntArray.put(R$id.tvTips, 6);
        sparseIntArray.put(R$id.llBtn, 7);
        sparseIntArray.put(R$id.tvShare, 8);
        sparseIntArray.put(R$id.tvContinue, 9);
        sparseIntArray.put(R$id.flBottomSpace, 10);
        sparseIntArray.put(R$id.ivClose, 11);
    }

    public d(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 12, O, P));
    }

    public void i() {
        synchronized (this) {
            this.N = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.N != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.N = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[10], objArr[2], objArr[1], objArr[11], objArr[7], objArr[5], objArr[9], objArr[8], objArr[4], objArr[6], objArr[3]);
        this.N = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.M = constraintLayout;
        constraintLayout.setTag((Object) null);
        G(view);
        t();
    }
}
