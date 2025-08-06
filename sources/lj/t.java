package lj;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.b;
import androidx.databinding.f;
import com.huobi.tradingbot.ui.TradingBotActivity;
import com.huobi.tradingbot.vm.TradingBotViewModel;
import jl.a;
import pro.huobi.R;

public class t extends s implements a.C0808a {
    public static final f.i U = null;
    public static final SparseIntArray V;
    public final ImageView R;
    public final View.OnClickListener S;
    public long T;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        V = sparseIntArray;
        sparseIntArray.put(R.id.vTopBar, 2);
        sparseIntArray.put(R.id.tvTitle, 3);
        sparseIntArray.put(R.id.ivSearch, 4);
        sparseIntArray.put(R.id.ivTutorial, 5);
        sparseIntArray.put(R.id.content_container, 6);
        sparseIntArray.put(R.id.refreshLayout, 7);
        sparseIntArray.put(R.id.appBarLayout, 8);
        sparseIntArray.put(R.id.llbotTopPage, 9);
        sparseIntArray.put(R.id.horizontal_scroll, 10);
        sparseIntArray.put(R.id.title_layout, 11);
        sparseIntArray.put(R.id.llbotFilter, 12);
        sparseIntArray.put(R.id.nl_root, 13);
        sparseIntArray.put(R.id.ivTop, 14);
    }

    public t(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 15, U, V));
    }

    public void M(TradingBotActivity tradingBotActivity) {
        this.Q = tradingBotActivity;
        synchronized (this) {
            this.T |= 1;
        }
        notifyPropertyChanged(11);
        super.B();
    }

    public void N(TradingBotViewModel tradingBotViewModel) {
        this.P = tradingBotViewModel;
    }

    public final void a(int i11, View view) {
        TradingBotActivity tradingBotActivity = this.Q;
        if (tradingBotActivity != null) {
            tradingBotActivity.finish();
        }
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.T;
            this.T = 0;
        }
        if ((j11 & 4) != 0) {
            this.R.setOnClickListener(this.S);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.T != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.T = 4;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public t(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[8], objArr[6], objArr[10], objArr[4], objArr[14], objArr[5], objArr[0], objArr[12], objArr[9], objArr[13], objArr[7], objArr[11], objArr[3], objArr[2]);
        this.T = -1;
        this.H.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.R = imageView;
        imageView.setTag((Object) null);
        G(view);
        this.S = new a(this, 1);
        t();
    }
}
