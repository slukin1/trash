package sv;

import android.view.View;
import com.huochat.community.holders.CommentSubHolder;
import com.huochat.community.listener.OnCommentClickListener;
import com.huochat.community.model.CommentItemBean;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnCommentClickListener f29264b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommentItemBean f29265c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CommentSubHolder f29266d;

    public /* synthetic */ c(OnCommentClickListener onCommentClickListener, CommentItemBean commentItemBean, CommentSubHolder commentSubHolder) {
        this.f29264b = onCommentClickListener;
        this.f29265c = commentItemBean;
        this.f29266d = commentSubHolder;
    }

    public final void onClick(View view) {
        CommentSubHolder.bindData$lambda$1(this.f29264b, this.f29265c, this.f29266d, view);
    }
}
