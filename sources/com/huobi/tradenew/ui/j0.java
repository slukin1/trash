package com.huobi.tradenew.ui;

import android.widget.EditText;
import com.huobi.view.keyboard.CustomBoardView;

public final /* synthetic */ class j0 implements CustomBoardView.KeyBoardStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TradeBaseFragment f83426a;

    public /* synthetic */ j0(TradeBaseFragment tradeBaseFragment) {
        this.f83426a = tradeBaseFragment;
    }

    public final void KeyBoardStateChange(int i11, EditText editText) {
        this.f83426a.Ni(i11, editText);
    }
}
