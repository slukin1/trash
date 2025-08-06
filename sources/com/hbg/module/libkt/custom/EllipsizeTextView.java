package com.hbg.module.libkt.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.jvm.internal.r;

public final class EllipsizeTextView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public SpannableStringBuilder f24672b;

    public EllipsizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EllipsizeTextView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 16842884 : i11);
    }

    public final SpannableStringBuilder getSBuilder() {
        return this.f24672b;
    }

    public void onDraw(Canvas canvas) {
        int lineVisibleEnd;
        SpannableStringBuilder append;
        super.onDraw(canvas);
        if (getLineCount() > 4 && getText().length() > (lineVisibleEnd = getLayout().getLineVisibleEnd(3))) {
            if (this.f24672b == null) {
                this.f24672b = new SpannableStringBuilder();
            }
            SpannableStringBuilder spannableStringBuilder = this.f24672b;
            if (!(spannableStringBuilder == null || (append = spannableStringBuilder.append(getText().subSequence(0, lineVisibleEnd - 4))) == null)) {
                append.append("...");
            }
            setText(this.f24672b);
        }
    }

    public final void setSBuilder(SpannableStringBuilder spannableStringBuilder) {
        this.f24672b = spannableStringBuilder;
    }

    public EllipsizeTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
