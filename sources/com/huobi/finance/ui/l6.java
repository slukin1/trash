package com.huobi.finance.ui;

import android.widget.EditText;
import com.huobi.view.keyboard.CustomBoardView;

public final /* synthetic */ class l6 implements CustomBoardView.KeyBoardStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoanActivity f47221a;

    public /* synthetic */ l6(LoanActivity loanActivity) {
        this.f47221a = loanActivity;
    }

    public final void KeyBoardStateChange(int i11, EditText editText) {
        this.f47221a.Dh(i11, editText);
    }
}
