package cd;

import com.hbg.module.exchange.grid.ui.GridTradeInputView;
import com.huobi.view.keyboard.CustomBoardView;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GridTradeInputView f13025b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CustomBoardView f13026c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f13027d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f13028e;

    public /* synthetic */ b0(GridTradeInputView gridTradeInputView, CustomBoardView customBoardView, int i11, int i12) {
        this.f13025b = gridTradeInputView;
        this.f13026c = customBoardView;
        this.f13027d = i11;
        this.f13028e = i12;
    }

    public final void run() {
        this.f13025b.g(this.f13026c, this.f13027d, this.f13028e);
    }
}
