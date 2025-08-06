package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.view.title.HbTitleBar;

public class OtcSearchTitleBar extends HbTitleBar {

    /* renamed from: b  reason: collision with root package name */
    public EditText f80050b;

    /* renamed from: c  reason: collision with root package name */
    public View f80051c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f80052d;

    public OtcSearchTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public final void c() {
        this.f80050b = (EditText) findViewById(R$id.et_search);
        this.f80051c = findViewById(R$id.rl_search);
        this.f80052d = (ImageView) findViewById(R$id.iv_close);
        ImageView imageView = (ImageView) findViewById(com.hbg.lib.widgets.R$id.iv_back);
        if (imageView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            marginLayoutParams.setMarginEnd(0);
            imageView.setLayoutParams(marginLayoutParams);
        }
    }

    public EditText getEditText() {
        return this.f80050b;
    }

    public View getSearchCloseView() {
        return this.f80052d;
    }

    public View getSearchRootView() {
        return this.f80051c;
    }

    public View getTitleContent() {
        return View.inflate(getContext(), R$layout.otc_payment_search_layout, (ViewGroup) null);
    }
}
