package lj;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.b;
import androidx.databinding.f;
import com.huobi.copytrading.ui.CopyTradingTradeFragment;
import jl.a;
import pro.huobi.R;

public class d0 extends c0 implements a.C0808a {
    public static final f.i V = null;
    public static final SparseIntArray W;
    public final LinearLayout R;
    public final ImageView S;
    public final View.OnClickListener T;
    public long U;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        W = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 2);
        sparseIntArray.put(R.id.ll_trade_title, 3);
        sparseIntArray.put(R.id.ll_trade_panel, 4);
        sparseIntArray.put(R.id.tabLayout, 5);
        sparseIntArray.put(R.id.ll_history_root, 6);
        sparseIntArray.put(R.id.vp_root, 7);
        sparseIntArray.put(R.id.tvHistoryTips, 8);
        sparseIntArray.put(R.id.kline_wrapper_container, 9);
        sparseIntArray.put(R.id.trade_kline_line, 10);
        sparseIntArray.put(R.id.trade_vertical_kline_show_rl, 11);
        sparseIntArray.put(R.id.trade_vertical_kline_show_tv, 12);
        sparseIntArray.put(R.id.trade_vertical_kline_symbol_tv, 13);
        sparseIntArray.put(R.id.klineViewWrapper_divider, 14);
        sparseIntArray.put(R.id.klineViewWrapper_rl, 15);
        sparseIntArray.put(R.id.klineViewWrapper_bottom_divider, 16);
    }

    public d0(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 17, V, W));
    }

    public void K(CopyTradingTradeFragment copyTradingTradeFragment) {
        this.Q = copyTradingTradeFragment;
        synchronized (this) {
            this.U |= 1;
        }
        notifyPropertyChanged(12);
        super.B();
    }

    public final void a(int i11, View view) {
        CopyTradingTradeFragment copyTradingTradeFragment = this.Q;
        if (copyTradingTradeFragment != null) {
            copyTradingTradeFragment.Uh();
        }
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.U;
            this.U = 0;
        }
        if ((j11 & 2) != 0) {
            this.S.setOnClickListener(this.T);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.U != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.U = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public d0(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[16], objArr[14], objArr[15], objArr[9], objArr[6], objArr[4], objArr[3], objArr[5], objArr[10], objArr[11], objArr[12], objArr[13], objArr[8], objArr[2], objArr[7]);
        this.U = -1;
        LinearLayout linearLayout = objArr[0];
        this.R = linearLayout;
        linearLayout.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.S = imageView;
        imageView.setTag((Object) null);
        G(view);
        this.T = new a(this, 1);
        t();
    }
}
