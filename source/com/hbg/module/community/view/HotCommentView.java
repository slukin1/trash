package com.hbg.module.community.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.huochat.community.widget.expandable.CommentTextViewTouchListener;
import kotlin.jvm.internal.r;

public final class HotCommentView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public final CommentTextViewTouchListener f17608b;

    public HotCommentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HotCommentView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? -1 : i11);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.f17608b.setOnClickListener(onClickListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
        this.f17608b.setOnLongClickListener(onLongClickListener);
    }

    public HotCommentView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        CommentTextViewTouchListener commentTextViewTouchListener = new CommentTextViewTouchListener();
        this.f17608b = commentTextViewTouchListener;
        setOnTouchListener(commentTextViewTouchListener);
    }
}
