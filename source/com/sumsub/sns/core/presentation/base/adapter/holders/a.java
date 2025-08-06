package com.sumsub.sns.core.presentation.base.adapter.holders;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.presentation.base.adapter.b;
import com.sumsub.sns.core.widget.SNSStepView;
import com.sumsub.sns.core.widget.SNSStepViewExtensionsKt;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.presentation.base.adapter.c;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.r;

public final class a extends b<com.sumsub.sns.internal.core.presentation.base.adapter.a> {

    /* renamed from: b  reason: collision with root package name */
    public static final C0290a f30907b = new C0290a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final l<Document, Unit> f30908a;

    /* renamed from: com.sumsub.sns.core.presentation.base.adapter.holders.a$a  reason: collision with other inner class name */
    public static final class C0290a {
        public /* synthetic */ C0290a(r rVar) {
            this();
        }

        public static /* synthetic */ a a(C0290a aVar, ViewGroup viewGroup, l lVar, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                lVar = null;
            }
            return aVar.a(viewGroup, lVar);
        }

        public C0290a() {
        }

        public final a a(ViewGroup viewGroup, l<? super Document, Unit> lVar) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sns_layout_status_document_item, viewGroup, false), lVar);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(View view, l lVar, int i11, r rVar) {
        this(view, (i11 & 2) != 0 ? null : lVar);
    }

    public a(View view, l<? super Document, Unit> lVar) {
        super(view);
        this.f30908a = lVar;
    }

    public void a(com.sumsub.sns.internal.core.presentation.base.adapter.a aVar, int i11) {
        if (aVar instanceof c) {
            View view = this.itemView;
            SNSStepView sNSStepView = view instanceof SNSStepView ? (SNSStepView) view : null;
            if (sNSStepView != null) {
                c cVar = (c) aVar;
                Spanned a11 = i.a(cVar.i(), sNSStepView.getContext());
                sNSStepView.setTitle(a11);
                if (a11.length() == 0) {
                    sNSStepView.setTitle("   ");
                }
                CharSequence h11 = cVar.h();
                sNSStepView.setSubtitle(h11 != null ? i.a(h11, sNSStepView.getContext()) : null);
                sNSStepView.setIconStart(cVar.a(sNSStepView.getContext()));
                SNSStepViewExtensionsKt.setSnsStepState(sNSStepView, cVar.g());
                sNSStepView.setIconEnd((Drawable) null);
                if (cVar.k()) {
                    this.itemView.setOnClickListener(new g(this, aVar));
                    Context context = sNSStepView.getContext();
                    com.sumsub.sns.core.presentation.helper.a aVar2 = com.sumsub.sns.core.presentation.helper.a.f31095a;
                    Drawable a12 = aVar2.a(context, SNSIconHandler.SNSCommonIcons.MORE.getImageName());
                    if (a12 == null) {
                        a12 = aVar2.a(context, SNSIconHandler.SNSCommonIcons.DISCLOSURE.getImageName());
                    }
                    sNSStepView.setIconEnd(a12);
                }
            }
        }
    }

    public static final void a(a aVar, com.sumsub.sns.internal.core.presentation.base.adapter.a aVar2, View view) {
        l<Document, Unit> lVar = aVar.f30908a;
        if (lVar != null) {
            lVar.invoke(((c) aVar2).j().c());
        }
    }
}
