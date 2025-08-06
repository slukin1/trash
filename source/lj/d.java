package lj;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.b;
import androidx.databinding.f;
import com.huobi.tradingbot.ui.BotDetailActivity;
import jl.a;
import pro.huobi.R;

public class d extends c implements a.C0808a {
    public static final f.i P = null;
    public static final SparseIntArray Q;
    public final ImageView M;
    public final View.OnClickListener N;
    public long O;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        Q = sparseIntArray;
        sparseIntArray.put(R.id.vTopBar, 2);
        sparseIntArray.put(R.id.tvTitle, 3);
        sparseIntArray.put(R.id.ivShare, 4);
        sparseIntArray.put(R.id.loadingLayout, 5);
        sparseIntArray.put(R.id.refreshLayout, 6);
        sparseIntArray.put(R.id.llBotTopPage, 7);
        sparseIntArray.put(R.id.llbotTab, 8);
        sparseIntArray.put(R.id.vpRoot, 9);
        sparseIntArray.put(R.id.llbotBottom, 10);
    }

    public d(b bVar, View view) {
        this(bVar, view, f.w(bVar, view, 11, P, Q));
    }

    public void M(BotDetailActivity botDetailActivity) {
        this.L = botDetailActivity;
        synchronized (this) {
            this.O |= 1;
        }
        notifyPropertyChanged(11);
        super.B();
    }

    public final void a(int i11, View view) {
        BotDetailActivity botDetailActivity = this.L;
        if (botDetailActivity != null) {
            botDetailActivity.finish();
        }
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.O;
            this.O = 0;
        }
        if ((j11 & 2) != 0) {
            this.M.setOnClickListener(this.N);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.O != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.O = 2;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[4], objArr[7], objArr[0], objArr[10], objArr[8], objArr[5], objArr[6], objArr[3], objArr[2], objArr[9]);
        this.O = -1;
        this.D.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.M = imageView;
        imageView.setTag((Object) null);
        G(view);
        this.N = new a(this, 1);
        t();
    }
}
