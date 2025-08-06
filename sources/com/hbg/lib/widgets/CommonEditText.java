package com.hbg.lib.widgets;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.res.ResourcesCompat;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.utils.CommonTextWatcher;
import i6.d;

public class CommonEditText extends AppCompatEditText {

    /* renamed from: b  reason: collision with root package name */
    public int f71099b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f71100c = -1;

    /* renamed from: d  reason: collision with root package name */
    public b f71101d;

    public class a extends CommonTextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public String f71102b;

        public a() {
        }

        public final void a(String str, Editable editable) {
            this.f71102b = str;
            CommonEditText.this.setText(str);
            try {
                CommonEditText.this.setSelection(str.length());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            if (CommonEditText.this.f71101d != null) {
                CommonEditText.this.f71101d.c(str, editable);
            }
        }

        public void afterTextChanged(Editable editable) {
            CommonEditText.this.setTextBold(editable.length() == 0);
            String obj = editable.toString();
            if (obj.startsWith(InstructionFileId.DOT)) {
                a("0" + obj, editable);
            } else if (!obj.contains(InstructionFileId.DOT) && !"0".equals(obj) && obj.startsWith("0")) {
                a(obj.substring(1), editable);
            } else if (CommonEditText.this.f71099b <= -1 || obj.contains(InstructionFileId.DOT) || obj.length() <= CommonEditText.this.f71099b) {
                if (obj.contains(InstructionFileId.DOT)) {
                    String[] split = obj.split("\\.");
                    String str = "";
                    if (CommonEditText.this.f71099b <= -1 || split[0].length() <= CommonEditText.this.f71099b) {
                        if (split.length > 1) {
                            str = split[1];
                        }
                        if (!TextUtils.isEmpty(str) && CommonEditText.this.f71100c > -1 && str.length() > CommonEditText.this.f71100c) {
                            a(split[0] + InstructionFileId.DOT + str.substring(0, CommonEditText.this.f71100c), editable);
                            return;
                        }
                    } else {
                        if (split.length > 1) {
                            str = split[1];
                        }
                        a(obj.substring(0, CommonEditText.this.f71099b) + InstructionFileId.DOT + str, editable);
                        return;
                    }
                }
                this.f71102b = obj;
                try {
                    CommonEditText.this.setSelection(obj.length());
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                if (CommonEditText.this.f71101d != null) {
                    CommonEditText.this.f71101d.c(obj, editable);
                }
            } else {
                a(obj.substring(0, CommonEditText.this.f71099b), editable);
            }
        }
    }

    public interface b {
        boolean b();

        void c(String str, Editable editable);
    }

    public CommonEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean g(View view, MotionEvent motionEvent) {
        b bVar;
        d.b("CommonAmountEditTextLayout-->setText-->" + motionEvent.getAction());
        if (motionEvent.getAction() == 1 && (bVar = this.f71101d) != null) {
            return bVar.b();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void setTextBold(boolean z11) {
        if (z11) {
            setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_regular));
        } else {
            setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
        }
    }

    public final void f(Context context) {
        addTextChangedListener(new a());
        setOnTouchListener(new o(this));
    }

    public void setCallback(b bVar) {
        this.f71101d = bVar;
    }

    public void setFloatPrecision(int i11) {
        this.f71100c = i11;
    }

    public void setIntPrecision(int i11) {
        this.f71099b = i11;
    }

    public CommonEditText(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        f(context);
    }
}
