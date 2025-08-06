package com.hbg.module.market.widget.bean;

import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.hbg.module.market.widget.viewhandler.MarketSearchInputHandler;
import java.io.Serializable;

public class MarketSearchInputItem implements s9.a, Serializable {
    private a callback;

    public interface a {
        void a(Editable editable);

        void b(View view, EditText editText);

        void c(boolean z11);

        boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent);
    }

    public a getCallback() {
        return this.callback;
    }

    public String getViewHandlerName() {
        return MarketSearchInputHandler.class.getName();
    }

    public void setCallback(a aVar) {
        this.callback = aVar;
    }
}
