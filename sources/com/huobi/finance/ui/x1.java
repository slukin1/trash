package com.huobi.finance.ui;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public final /* synthetic */ class x1 implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetFragment f47388b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EditText f47389c;

    public /* synthetic */ x1(BalanceAssetFragment balanceAssetFragment, EditText editText) {
        this.f47388b = balanceAssetFragment;
        this.f47389c = editText;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f47388b.Vj(this.f47389c, textView, i11, keyEvent);
    }
}
