package com.huobi.finance.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.huobi.finance.bean.BaseAssetTotal;

public class x2 implements TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public EditText f47390b;

    /* renamed from: c  reason: collision with root package name */
    public a f47391c;

    public interface a {
        void B(EditText editText, String str);

        void I(BaseAssetTotal baseAssetTotal);
    }

    public x2(EditText editText, a aVar) {
        this.f47390b = editText;
        this.f47391c = aVar;
        editText.setTag(this);
    }

    public void afterTextChanged(Editable editable) {
        a aVar = this.f47391c;
        if (aVar != null) {
            aVar.B(this.f47390b, editable.toString());
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }
}
