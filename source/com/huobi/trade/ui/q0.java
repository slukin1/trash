package com.huobi.trade.ui;

import android.widget.EditText;
import com.huobi.view.keyboard.CustomBoardView;

public final /* synthetic */ class q0 implements CustomBoardView.KeyBoardStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TradeBaseFragment f82693a;

    public /* synthetic */ q0(TradeBaseFragment tradeBaseFragment) {
        this.f82693a = tradeBaseFragment;
    }

    public final void KeyBoardStateChange(int i11, EditText editText) {
        this.f82693a.Ii(i11, editText);
    }
}
