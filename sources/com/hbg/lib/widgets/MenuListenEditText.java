package com.hbg.lib.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class MenuListenEditText extends EditText {

    /* renamed from: b  reason: collision with root package name */
    public a f71535b;

    public interface a {
        boolean a(int i11);
    }

    public MenuListenEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTextContextMenuItem(int i11) {
        a aVar = this.f71535b;
        if (aVar != null) {
            return aVar.a(i11);
        }
        return super.onTextContextMenuItem(i11);
    }

    public void setCallback(a aVar) {
        this.f71535b = aVar;
    }

    public MenuListenEditText(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
