package i4;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.business.common.R$id;
import com.huobi.view.roundview.RoundConstraintLayout;

public class j extends i {
    public static final f.i H = null;
    public static final SparseIntArray I;
    public final RoundConstraintLayout F;
    public long G;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        I = sparseIntArray;
        sparseIntArray.put(R$id.ivSymbol, 1);
        sparseIntArray.put(R$id.tvName, 2);
        sparseIntArray.put(R$id.tvValue, 3);
        sparseIntArray.put(R$id.tvTrade, 4);
    }

    public j(b bVar, View view) {
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

    public j(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[1], objArr[2], objArr[4], objArr[3]);
        this.G = -1;
        RoundConstraintLayout roundConstraintLayout = objArr[0];
        this.F = roundConstraintLayout;
        roundConstraintLayout.setTag((Object) null);
        G(view);
        t();
    }
}
