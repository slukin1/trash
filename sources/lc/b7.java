package lc;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.hbg.module.content.BR;
import com.hbg.module.content.R$id;

public class b7 extends a7 {
    public static final f.i K = null;
    public static final SparseIntArray L;
    public final LinearLayout H;
    public final View I;
    public long J;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        L = sparseIntArray;
        sparseIntArray.put(R$id.llCountDown, 2);
        sparseIntArray.put(R$id.tvDay, 3);
        sparseIntArray.put(R$id.tvHour, 4);
        sparseIntArray.put(R$id.tvMinute, 5);
        sparseIntArray.put(R$id.tvSecond, 6);
    }

    public b7(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 7, K, L));
    }

    public void K(Boolean bool) {
        this.G = bool;
        synchronized (this) {
            this.J |= 1;
        }
        notifyPropertyChanged(BR.f17734k);
        super.B();
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.J;
            this.J = 0;
        }
        Boolean bool = this.G;
        int i11 = ((j11 & 3) > 0 ? 1 : ((j11 & 3) == 0 ? 0 : -1));
        int i12 = 0;
        if (i11 != 0) {
            boolean D = f.D(bool);
            if (i11 != 0) {
                j11 |= D ? 8 : 4;
            }
            if (!D) {
                i12 = 8;
            }
        }
        if ((j11 & 3) != 0) {
            this.I.setVisibility(i12);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.J != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.J = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public b7(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
        this.J = -1;
        LinearLayout linearLayout = objArr[0];
        this.H = linearLayout;
        linearLayout.setTag((Object) null);
        View view2 = objArr[1];
        this.I = view2;
        view2.setTag((Object) null);
        G(view);
        t();
    }
}
