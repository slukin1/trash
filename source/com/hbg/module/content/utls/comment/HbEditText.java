package com.hbg.module.content.utls.comment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class HbEditText extends AppCompatEditText {

    /* renamed from: b  reason: collision with root package name */
    public Context f18891b;

    /* renamed from: c  reason: collision with root package name */
    public d10.a<Unit> f18892c;

    public static final class a extends InputConnectionWrapper {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HbEditText f18893a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InputConnection inputConnection, HbEditText hbEditText) {
            super(inputConnection, true);
            this.f18893a = hbEditText;
        }

        public boolean commitText(CharSequence charSequence, int i11) {
            if (!x.b(charSequence, "\n")) {
                return super.commitText(charSequence, i11);
            }
            this.f18893a.f18892c.invoke();
            return false;
        }
    }

    public HbEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HbEditText(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final Context getMContext() {
        return this.f18891b;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new a(super.onCreateInputConnection(editorInfo), this);
    }

    public final void setMContext(Context context) {
        this.f18891b = context;
    }

    public final void setOnSendListener(d10.a<Unit> aVar) {
        this.f18892c = aVar;
    }

    public HbEditText(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f18891b = context;
        this.f18892c = HbEditText$onSend$1.INSTANCE;
    }
}
