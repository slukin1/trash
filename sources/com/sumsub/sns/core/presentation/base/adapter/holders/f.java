package com.sumsub.sns.core.presentation.base.adapter.holders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.base.adapter.b;
import com.sumsub.sns.internal.core.presentation.base.adapter.h;
import kotlin.jvm.internal.r;

public final class f extends b<com.sumsub.sns.internal.core.presentation.base.adapter.a> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f30919b = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final TextView f30920a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final f a(ViewGroup viewGroup) {
            return new f(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sns_layout_status_title_item, viewGroup, false));
        }

        public a() {
        }
    }

    public f(View view) {
        super(view);
        this.f30920a = (TextView) view;
    }

    public void a(com.sumsub.sns.internal.core.presentation.base.adapter.a aVar, int i11) {
        if (aVar instanceof h) {
            this.f30920a.setText(((h) aVar).c());
        }
    }
}
