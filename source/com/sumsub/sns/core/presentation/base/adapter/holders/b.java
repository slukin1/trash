package com.sumsub.sns.core.presentation.base.adapter.holders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.widget.SNSModeratorCommentView;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.presentation.base.adapter.d;
import kotlin.jvm.internal.r;

public final class b extends com.sumsub.sns.core.presentation.base.adapter.b<com.sumsub.sns.internal.core.presentation.base.adapter.a> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30909a = new a((r) null);

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final b a(ViewGroup viewGroup) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sns_layout_status_documents_moderator_comment_item, viewGroup, false));
        }

        public a() {
        }
    }

    public b(View view) {
        super(view);
    }

    public void a(com.sumsub.sns.internal.core.presentation.base.adapter.a aVar, int i11) {
        View view = this.itemView;
        if ((aVar instanceof d) && (view instanceof SNSModeratorCommentView)) {
            SNSModeratorCommentView sNSModeratorCommentView = (SNSModeratorCommentView) view;
            CharSequence c11 = ((d) aVar).c();
            sNSModeratorCommentView.setSubtitle(c11 != null ? i.a(c11, sNSModeratorCommentView.getContext()) : null);
            sNSModeratorCommentView.setIconStart(e0.f32018a.getIconHandler().onResolveIcon(sNSModeratorCommentView.getContext(), SNSIconHandler.SNSCommonIcons.NOTIFY.getImageName()));
        }
    }
}
