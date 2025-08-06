package com.sumsub.sns.core.presentation.base.adapter.holders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.base.adapter.b;
import com.sumsub.sns.internal.core.presentation.base.adapter.g;
import kotlin.jvm.internal.r;

public final class e extends b<com.sumsub.sns.internal.core.presentation.base.adapter.a> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f30917b = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final TextView f30918a;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final e a(ViewGroup viewGroup) {
            return new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sns_layout_status_text_item, viewGroup, false));
        }

        public a() {
        }
    }

    public e(View view) {
        super(view);
        this.f30918a = (TextView) view;
    }

    public void a(com.sumsub.sns.internal.core.presentation.base.adapter.a aVar, int i11) {
        if (aVar instanceof g) {
            this.f30918a.setText(((g) aVar).c());
        }
    }
}
