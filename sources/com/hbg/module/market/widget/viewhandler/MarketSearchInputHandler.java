package com.hbg.module.market.widget.viewhandler;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.widget.bean.MarketSearchInputItem;
import i6.r;
import pf.b;
import s9.c;

public class MarketSearchInputHandler implements c {

    public class a implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MarketSearchInputItem.a f26798b;

        public a(MarketSearchInputItem.a aVar) {
            this.f26798b = aVar;
        }

        public void afterTextChanged(Editable editable) {
            MarketSearchInputItem.a aVar = this.f26798b;
            if (aVar != null) {
                aVar.a(editable);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public static /* synthetic */ boolean d(MarketSearchInputItem.a aVar, TextView textView, int i11, KeyEvent keyEvent) {
        if (aVar != null) {
            return aVar.onEditorAction(textView, i11, keyEvent);
        }
        return false;
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, MarketSearchInputItem marketSearchInputItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        MarketSearchInputItem.a callback = marketSearchInputItem.getCallback();
        View b11 = e11.b(R$id.ll_search_container);
        EditText a11 = e11.a(R$id.et_input_listen);
        if (callback != null) {
            callback.b(b11, a11);
        }
        a11.addTextChangedListener(new a(callback));
        a11.setOnEditorActionListener(new b(callback));
    }

    public int getResId() {
        return R$layout.item_market_search_input;
    }
}
