package i4;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.f;
import com.business.common.R$id;

public class b extends a {
    public static final f.i Q = null;
    public static final SparseIntArray R;
    public final LinearLayout O;
    public long P;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        R = sparseIntArray;
        sparseIntArray.put(R$id.clPopView, 1);
        sparseIntArray.put(R$id.ivAnimation, 2);
        sparseIntArray.put(R$id.tvTitle, 3);
        sparseIntArray.put(R$id.tvSubTitle, 4);
        sparseIntArray.put(R$id.tvClaim, 5);
        sparseIntArray.put(R$id.tvInvalid, 6);
        sparseIntArray.put(R$id.ivClose, 7);
        sparseIntArray.put(R$id.clRedPackageView, 8);
        sparseIntArray.put(R$id.ivRedAnim, 9);
        sparseIntArray.put(R$id.tvRedTitle, 10);
        sparseIntArray.put(R$id.tvRedSubTitle, 11);
        sparseIntArray.put(R$id.tvRedInvalid, 12);
        sparseIntArray.put(R$id.ivRedClose, 13);
    }

    public b(androidx.databinding.b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 14, Q, R));
    }

    public void i() {
        synchronized (this) {
            this.P = 0;
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.P != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.P = 1;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public b(androidx.databinding.b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[1], objArr[8], objArr[2], objArr[7], objArr[9], objArr[13], objArr[5], objArr[6], objArr[12], objArr[11], objArr[10], objArr[4], objArr[3]);
        this.P = -1;
        LinearLayout linearLayout = objArr[0];
        this.O = linearLayout;
        linearLayout.setTag((Object) null);
        G(view);
        t();
    }
}
