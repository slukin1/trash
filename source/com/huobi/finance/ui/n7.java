package com.huobi.finance.ui;

import android.widget.EditText;
import com.huobi.view.keyboard.CustomBoardView;

public final /* synthetic */ class n7 implements CustomBoardView.KeyBoardStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RepayActivity f47250a;

    public /* synthetic */ n7(RepayActivity repayActivity) {
        this.f47250a = repayActivity;
    }

    public final void KeyBoardStateChange(int i11, EditText editText) {
        this.f47250a.rh(i11, editText);
    }
}
