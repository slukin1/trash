package i4;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.business.common.R$id;

public class n extends m {
    public static final f.i H = null;
    public static final SparseIntArray I;
    public long G;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        I = sparseIntArray;
        sparseIntArray.put(R$id.ivSwapZeroGift, 1);
        sparseIntArray.put(R$id.swapZeroContent, 2);
        sparseIntArray.put(R$id.tvZeroSwapContent, 3);
        sparseIntArray.put(R$id.ivSwapZeroClose, 4);
    }

    public n(b bVar, View view) {
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

    public n(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[4], objArr[1], objArr[2], objArr[0], objArr[3]);
        this.G = -1;
        this.E.setTag((Object) null);
        G(view);
        t();
    }
}
