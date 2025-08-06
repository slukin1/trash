package com.huochat.community.widget;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.huochat.community.util.UrlParamTool;
import com.huochat.community.widget.expandable.TextLinkSpan;
import java.util.List;

public class LinkTextView extends AppCompatTextView {
    public LinkTextView(Context context) {
        super(context);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        Spannable spannable;
        if (charSequence instanceof Spannable) {
            spannable = (Spannable) charSequence;
        } else {
            spannable = new SpannableString(charSequence.toString());
        }
        List<UrlParamTool.UrlResult> applyFilter = UrlParamTool.applyFilter(charSequence.toString());
        if (applyFilter != null && applyFilter.size() > 0) {
            for (UrlParamTool.UrlResult next : applyFilter) {
                spannable.setSpan(new TextLinkSpan(next.url), next.start, next.end, 33);
            }
        }
        super.setText(spannable, bufferType);
    }

    public LinkTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LinkTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
