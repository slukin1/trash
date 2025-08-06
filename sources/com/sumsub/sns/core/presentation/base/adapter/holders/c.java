package com.sumsub.sns.core.presentation.base.adapter.holders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.base.adapter.b;
import com.sumsub.sns.core.widget.SNSImageView;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.presentation.base.adapter.e;
import kotlin.jvm.internal.r;

public final class c extends b<com.sumsub.sns.internal.core.presentation.base.adapter.a> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f30910b = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final SNSImageView f30911a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final c a(ViewGroup viewGroup) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sns_layout_status_image_item, viewGroup, false));
        }

        public a() {
        }
    }

    public c(View view) {
        super(view);
        this.f30911a = (SNSImageView) view;
    }

    public void a(com.sumsub.sns.internal.core.presentation.base.adapter.a aVar, int i11) {
        if (aVar instanceof e) {
            this.f30911a.setImageDrawable(e0.f32018a.getIconHandler().onResolveIcon(this.itemView.getContext(), ((e) aVar).c()));
        }
    }
}
