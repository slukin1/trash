package sv;

import android.view.View;
import com.huochat.community.holders.CommentFullHolder;
import com.huochat.community.listener.OnCommentClickListener;
import com.huochat.community.model.CommentItemBean;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OnCommentClickListener f29258b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CommentItemBean f29259c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CommentFullHolder f29260d;

    public /* synthetic */ a(OnCommentClickListener onCommentClickListener, CommentItemBean commentItemBean, CommentFullHolder commentFullHolder) {
        this.f29258b = onCommentClickListener;
        this.f29259c = commentItemBean;
        this.f29260d = commentFullHolder;
    }

    public final void onClick(View view) {
        CommentFullHolder.bindData$lambda$0(this.f29258b, this.f29259c, this.f29260d, view);
    }
}
