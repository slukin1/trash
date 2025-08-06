package lj;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.b;
import androidx.databinding.f;
import com.huobi.copytrading.ui.CopyTradingMeFragment;
import jl.a;
import pro.huobi.R;

public class z extends y implements a.C0808a {
    public static final f.i O = null;
    public static final SparseIntArray P;
    public final ImageView J;
    public final ImageView K;
    public final View.OnClickListener L;
    public final View.OnClickListener M;
    public long N;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        P = sparseIntArray;
        sparseIntArray.put(R.id.ivAvatar, 3);
        sparseIntArray.put(R.id.tvNickname, 4);
        sparseIntArray.put(R.id.llMeTopPage, 5);
        sparseIntArray.put(R.id.tabLayout, 6);
        sparseIntArray.put(R.id.vpRoot, 7);
        sparseIntArray.put(R.id.tvHistoryTips, 8);
    }

    public z(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 9, O, P));
    }

    public void K(CopyTradingMeFragment copyTradingMeFragment) {
        this.I = copyTradingMeFragment;
        synchronized (this) {
            this.N |= 1;
        }
        notifyPropertyChanged(12);
        super.B();
    }

    public final void a(int i11, View view) {
        boolean z11 = false;
        if (i11 == 1) {
            CopyTradingMeFragment copyTradingMeFragment = this.I;
            if (copyTradingMeFragment != null) {
                z11 = true;
            }
            if (z11) {
                copyTradingMeFragment.Gh();
            }
        } else if (i11 == 2) {
            CopyTradingMeFragment copyTradingMeFragment2 = this.I;
            if (copyTradingMeFragment2 != null) {
                z11 = true;
            }
            if (z11) {
                copyTradingMeFragment2.Fh();
            }
        }
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.N;
            this.N = 0;
        }
        if ((j11 & 2) != 0) {
            this.J.setOnClickListener(this.M);
            this.K.setOnClickListener(this.L);
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
            this.N = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public z(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[3], objArr[5], objArr[0], objArr[6], objArr[8], objArr[4], objArr[7]);
        this.N = -1;
        this.D.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.J = imageView;
        imageView.setTag((Object) null);
        ImageView imageView2 = objArr[2];
        this.K = imageView2;
        imageView2.setTag((Object) null);
        G(view);
        this.L = new a(this, 2);
        this.M = new a(this, 1);
        t();
    }
}
