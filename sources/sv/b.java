package sv;

import android.view.View;
import com.huochat.community.holders.CommentFullHolder;
import com.huochat.community.listener.OnCommentClickListener;
import com.huochat.community.model.CommentItemBean;

public final /* synthetic */ class b implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnCommentClickListener f29261b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommentItemBean f29262c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CommentFullHolder f29263d;

    public /* synthetic */ b(OnCommentClickListener onCommentClickListener, CommentItemBean commentItemBean, CommentFullHolder commentFullHolder) {
        this.f29261b = onCommentClickListener;
        this.f29262c = commentItemBean;
        this.f29263d = commentFullHolder;
    }

    public final boolean onLongClick(View view) {
        return CommentFullHolder.bindData$lambda$1(this.f29261b, this.f29262c, this.f29263d, view);
    }
}
