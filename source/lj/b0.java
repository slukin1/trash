package lj;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.b;
import androidx.databinding.f;
import com.huobi.copytrading.ui.CopyTradingNewHomeFragment;
import com.huobi.copytrading.vm.CopyTradingViewModel;
import jl.a;
import pro.huobi.R;

public class b0 extends a0 implements a.C0808a {
    public static final f.i N = null;
    public static final SparseIntArray O;
    public final ImageView K;
    public final View.OnClickListener L;
    public long M;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        O = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 2);
        sparseIntArray.put(R.id.ivSearch, 3);
        sparseIntArray.put(R.id.ivMore, 4);
        sparseIntArray.put(R.id.llTopPage, 5);
        sparseIntArray.put(R.id.rlFilterList, 6);
        sparseIntArray.put(R.id.llListView, 7);
    }

    public b0(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 8, N, O));
    }

    public void K(CopyTradingNewHomeFragment copyTradingNewHomeFragment) {
        this.J = copyTradingNewHomeFragment;
        synchronized (this) {
            this.M |= 2;
        }
        notifyPropertyChanged(12);
        super.B();
    }

    public void L(CopyTradingViewModel copyTradingViewModel) {
        this.I = copyTradingViewModel;
    }

    public final void a(int i11, View view) {
        CopyTradingNewHomeFragment copyTradingNewHomeFragment = this.J;
        if (copyTradingNewHomeFragment != null) {
            copyTradingNewHomeFragment.wh();
        }
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.M;
            this.M = 0;
        }
        if ((j11 & 4) != 0) {
            this.K.setOnClickListener(this.L);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.M != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.M = 4;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public b0(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[4], objArr[3], objArr[7], objArr[0], objArr[5], objArr[6], objArr[2]);
        this.M = -1;
        this.E.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.K = imageView;
        imageView.setTag((Object) null);
        G(view);
        this.L = new a(this, 1);
        t();
    }
}
