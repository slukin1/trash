package lj;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.b;
import androidx.databinding.f;
import com.huobi.copytrading.ui.CopyTradingTraderInfoActivity;
import jl.a;
import pro.huobi.R;

public class j extends i implements a.C0808a {
    public static final f.i T = null;
    public static final SparseIntArray U;
    public final View.OnClickListener Q;
    public final View.OnClickListener R;
    public long S;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        U = sparseIntArray;
        sparseIntArray.put(R.id.vTopBar, 3);
        sparseIntArray.put(R.id.rlActionBar, 4);
        sparseIntArray.put(R.id.llTraderAvatar, 5);
        sparseIntArray.put(R.id.ivAvatar, 6);
        sparseIntArray.put(R.id.tvNickName, 7);
        sparseIntArray.put(R.id.abLayout, 8);
        sparseIntArray.put(R.id.llTraderInfoPage, 9);
        sparseIntArray.put(R.id.rlTabContainer, 10);
        sparseIntArray.put(R.id.tabLayout, 11);
        sparseIntArray.put(R.id.vpRoot, 12);
        sparseIntArray.put(R.id.tvCopy, 13);
    }

    public j(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 14, T, U));
    }

    public void M(CopyTradingTraderInfoActivity copyTradingTraderInfoActivity) {
        this.P = copyTradingTraderInfoActivity;
        synchronized (this) {
            this.S |= 1;
        }
        notifyPropertyChanged(11);
        super.B();
    }

    public final void a(int i11, View view) {
        boolean z11 = false;
        if (i11 == 1) {
            CopyTradingTraderInfoActivity copyTradingTraderInfoActivity = this.P;
            if (copyTradingTraderInfoActivity != null) {
                z11 = true;
            }
            if (z11) {
                copyTradingTraderInfoActivity.finish();
            }
        } else if (i11 == 2) {
            CopyTradingTraderInfoActivity copyTradingTraderInfoActivity2 = this.P;
            if (copyTradingTraderInfoActivity2 != null) {
                z11 = true;
            }
            if (z11) {
                copyTradingTraderInfoActivity2.Oh();
            }
        }
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.S;
            this.S = 0;
        }
        if ((j11 & 2) != 0) {
            this.D.setOnClickListener(this.R);
            this.E.setOnClickListener(this.Q);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.S != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.S = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public j(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[8], objArr[6], objArr[1], objArr[2], objArr[0], objArr[5], objArr[9], objArr[4], objArr[10], objArr[11], objArr[13], objArr[7], objArr[3], objArr[12]);
        this.S = -1;
        this.D.setTag((Object) null);
        this.E.setTag((Object) null);
        this.F.setTag((Object) null);
        G(view);
        this.Q = new a(this, 2);
        this.R = new a(this, 1);
        t();
    }
}
