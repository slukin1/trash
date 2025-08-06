package com.huobi.edgeengine.template.widget;

import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.blankj.utilcode.util.KeyboardUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huobi.edgeengine.util.IdentifierUtil;
import java.lang.reflect.Field;
import java.util.Map;
import rj.n;
import yj.b;
import yj.c;

public class EditTextWidget extends TextWidget {
    public String E0;
    public String F0;
    public String G0;
    public String H0;
    public String I0;
    public String J0;

    public class a extends b {
        public a(View view) {
            super(view);
        }

        public void b(View view, String str) {
            if ("true".equals(str)) {
                KeyboardUtils.m(view);
                return;
            }
            view.clearFocus();
            KeyboardUtils.j(view);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0(n nVar, EditText editText, View view, boolean z11) {
        int i11;
        z(this.E0.replace("@eventParams", String.valueOf(z11)), nVar);
        if (z11) {
            Editable text = editText.getText();
            if (text == null) {
                i11 = 0;
            } else {
                i11 = text.length();
            }
            editText.setSelection(i11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean n0(n nVar, View view, int i11, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i11 != 66) {
            return false;
        }
        z(this.F0, nVar);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o0(EditText editText, Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            p0(editText, IdentifierUtil.a(context, str, "drawable"));
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.E0 = map.get("onFocusChange");
        this.F0 = map.get("onReturn");
        this.G0 = map.get("textCursorDrawable");
        this.H0 = map.get(RemoteMessageConst.INPUT_TYPE);
        this.I0 = map.get("imeOptions");
        this.J0 = map.get("requestFocus");
        this.f44120y0 = map.get("textFilter");
    }

    public View Q(Context context, n nVar) {
        EditText editText = (EditText) super.Q(context, nVar);
        if (TextUtils.isEmpty(this.f44167q)) {
            editText.setBackgroundColor(0);
        }
        if (!TextUtils.isEmpty(this.E0)) {
            editText.setOnFocusChangeListener(new yj.a(this, nVar, editText));
        }
        if ("actionDone".equals(this.I0)) {
            editText.setImeOptions(6);
        } else if ("actionNone".equals(this.I0)) {
            editText.setImeOptions(1);
        } else if ("actionGo".equals(this.I0)) {
            editText.setImeOptions(2);
        } else if ("actionNext".equals(this.I0)) {
            editText.setImeOptions(5);
        } else if ("actionSearch".equals(this.I0)) {
            editText.setImeOptions(3);
        } else if ("actionSend".equals(this.I0)) {
            editText.setImeOptions(4);
        }
        if ("textPassword".equals(this.H0)) {
            editText.setInputType(129);
        } else if ("text".equals(this.H0)) {
            editText.setInputType(1);
        } else if ("numberPassword".equals(this.H0)) {
            editText.setInputType(18);
        } else if ("number".equals(this.H0)) {
            editText.setInputType(2);
        } else if ("textEmailAddress".equals(this.H0)) {
            editText.setInputType(33);
        } else if ("numberDecimal".equals(this.H0)) {
            editText.setInputType(8194);
        }
        if (!TextUtils.isEmpty(this.F0)) {
            editText.setOnKeyListener(new b(this, nVar));
        }
        y(this.G0, new c(this, editText, context));
        w(context, this.J0, new a(editText), nVar);
        return editText;
    }

    /* renamed from: l0 */
    public EditText q(Context context) {
        return new EditText(context);
    }

    public final void p0(EditText editText, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            editText.setTextCursorDrawable(i11);
            return;
        }
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i11));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
