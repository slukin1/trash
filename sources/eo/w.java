package eo;

import android.widget.CompoundButton;
import com.hbg.lib.network.pro.core.bean.Partitions;
import com.huobi.main.trade.ui.TradeDialogFragment;

public final /* synthetic */ class w implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeDialogFragment f54392b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Partitions f54393c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f54394d;

    public /* synthetic */ w(TradeDialogFragment tradeDialogFragment, Partitions partitions, String str) {
        this.f54392b = tradeDialogFragment;
        this.f54393c = partitions;
        this.f54394d = str;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f54392b.ji(this.f54393c, this.f54394d, compoundButton, z11);
    }
}
