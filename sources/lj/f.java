package lj;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.b;
import androidx.databinding.f;
import com.huobi.tradingbot.ui.ContractGridActivity;
import com.huobi.tradingbot.vm.TradingBotViewModel;
import jl.a;
import pro.huobi.R;

public class f extends e implements a.C0808a {

    /* renamed from: a0  reason: collision with root package name */
    public static final f.i f47611a0 = null;

    /* renamed from: b0  reason: collision with root package name */
    public static final SparseIntArray f47612b0;
    public final ImageView X;
    public final View.OnClickListener Y;
    public long Z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f47612b0 = sparseIntArray;
        sparseIntArray.put(R.id.vTopBar, 2);
        sparseIntArray.put(R.id.titleLayout, 3);
        sparseIntArray.put(R.id.tvTitle, 4);
        sparseIntArray.put(R.id.ivSearch, 5);
        sparseIntArray.put(R.id.ivTutorial, 6);
        sparseIntArray.put(R.id.ivAvatar, 7);
        sparseIntArray.put(R.id.refreshLayout, 8);
        sparseIntArray.put(R.id.appBarLayout, 9);
        sparseIntArray.put(R.id.llBotTopAdBannerPage, 10);
        sparseIntArray.put(R.id.llBotTopPage, 11);
        sparseIntArray.put(R.id.kline_wrapper_container, 12);
        sparseIntArray.put(R.id.trade_kline_line, 13);
        sparseIntArray.put(R.id.klineViewWrapper_rl, 14);
        sparseIntArray.put(R.id.klineViewWrapper_bottom_divider, 15);
        sparseIntArray.put(R.id.llBotTabPage, 16);
        sparseIntArray.put(R.id.llBotSort, 17);
        sparseIntArray.put(R.id.llBotFirstPage, 18);
        sparseIntArray.put(R.id.llBotSecondPage, 19);
        sparseIntArray.put(R.id.llBotBottom, 20);
    }

    public f(b bVar, View view) {
        this(bVar, view, androidx.databinding.f.w(bVar, view, 21, f47611a0, f47612b0));
    }

    public void M(ContractGridActivity contractGridActivity) {
        this.W = contractGridActivity;
        synchronized (this) {
            this.Z |= 1;
        }
        notifyPropertyChanged(11);
        super.B();
    }

    public void N(TradingBotViewModel tradingBotViewModel) {
        this.V = tradingBotViewModel;
    }

    public final void a(int i11, View view) {
        ContractGridActivity contractGridActivity = this.W;
        if (contractGridActivity != null) {
            contractGridActivity.finish();
        }
    }

    public void i() {
        long j11;
        synchronized (this) {
            j11 = this.Z;
            this.Z = 0;
        }
        if ((j11 & 4) != 0) {
            this.X.setOnClickListener(this.Y);
        }
    }

    public boolean r() {
        synchronized (this) {
            if (this.Z != 0) {
                return true;
            }
            return false;
        }
    }

    public void t() {
        synchronized (this) {
            this.Z = 4;
        }
        B();
    }

    public boolean x(int i11, Object obj, int i12) {
        return false;
    }

    public f(b bVar, View view, Object[] objArr) {
        super(bVar, view, 0, objArr[9], objArr[7], objArr[5], objArr[6], objArr[15], objArr[14], objArr[12], objArr[20], objArr[18], objArr[19], objArr[17], objArr[16], objArr[10], objArr[11], objArr[0], objArr[8], objArr[3], objArr[13], objArr[4], objArr[2]);
        this.Z = -1;
        this.P.setTag((Object) null);
        ImageView imageView = objArr[1];
        this.X = imageView;
        imageView.setTag((Object) null);
        G(view);
        this.Y = new a(this, 1);
        t();
    }
}
