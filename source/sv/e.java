package sv;

import android.view.View;
import com.huochat.community.holders.CommentSubHolder;
import com.huochat.community.listener.OnCommentClickListener;
import com.huochat.community.model.CommentItemBean;

public final /* synthetic */ class e implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnCommentClickListener f29268b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommentItemBean f29269c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CommentSubHolder f29270d;

    public /* synthetic */ e(OnCommentClickListener onCommentClickListener, CommentItemBean commentItemBean, CommentSubHolder commentSubHolder) {
        this.f29268b = onCommentClickListener;
        this.f29269c = commentItemBean;
        this.f29270d = commentSubHolder;
    }

    public final boolean onLongClick(View view) {
        return CommentSubHolder.bindData$lambda$2(this.f29268b, this.f29269c, this.f29270d, view);
    }
}
