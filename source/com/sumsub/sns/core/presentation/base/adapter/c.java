package com.sumsub.sns.core.presentation.base.adapter;

import android.view.ViewGroup;
import com.sumsub.sns.core.presentation.base.adapter.holders.d;
import com.sumsub.sns.core.presentation.base.adapter.holders.e;
import com.sumsub.sns.core.presentation.base.adapter.holders.f;
import com.sumsub.sns.internal.core.data.model.Document;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.FunctionReferenceImpl;

public final class c extends a<com.sumsub.sns.internal.core.presentation.base.adapter.a, b<com.sumsub.sns.internal.core.presentation.base.adapter.a>> {

    /* renamed from: b  reason: collision with root package name */
    public final a f30900b;

    public interface a {
        void a(Document document);

        void a(String str);
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements l<Document, Unit> {
        public b(Object obj) {
            super(1, obj, a.class, "onDocumentClicked", "onDocumentClicked(Lcom/sumsub/sns/internal/core/data/model/Document;)V", 0);
        }

        public final void a(Document document) {
            ((a) this.receiver).a(document);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Document) obj);
            return Unit.f56620a;
        }
    }

    /* renamed from: com.sumsub.sns.core.presentation.base.adapter.c$c  reason: collision with other inner class name */
    public /* synthetic */ class C0289c extends FunctionReferenceImpl implements l<String, Unit> {
        public C0289c(Object obj) {
            super(1, obj, a.class, "onLinkClicked", "onLinkClicked(Ljava/lang/String;)V", 0);
        }

        public final void a(String str) {
            ((a) this.receiver).a(str);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public c(a aVar) {
        this.f30900b = aVar;
    }

    /* renamed from: a */
    public b<com.sumsub.sns.internal.core.presentation.base.adapter.a> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        switch (i11) {
            case 1:
                return com.sumsub.sns.core.presentation.base.adapter.holders.a.f30907b.a(viewGroup, new b(this.f30900b));
            case 2:
                return d.f30912d.a(viewGroup, new C0289c(this.f30900b));
            case 3:
                return com.sumsub.sns.core.presentation.base.adapter.holders.c.f30910b.a(viewGroup);
            case 4:
                return f.f30919b.a(viewGroup);
            case 5:
                return e.f30917b.a(viewGroup);
            case 6:
                return com.sumsub.sns.core.presentation.base.adapter.holders.b.f30909a.a(viewGroup);
            default:
                throw new IllegalStateException("Cannot create view holder for SNSDocumentListAdapter");
        }
    }

    public int getItemViewType(int i11) {
        com.sumsub.sns.internal.core.presentation.base.adapter.a aVar = (com.sumsub.sns.internal.core.presentation.base.adapter.a) a(i11);
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }

    /* renamed from: a */
    public void onBindViewHolder(b<com.sumsub.sns.internal.core.presentation.base.adapter.a> bVar, int i11) {
        com.sumsub.sns.internal.core.presentation.base.adapter.a aVar = (com.sumsub.sns.internal.core.presentation.base.adapter.a) a(i11);
        if (aVar != null) {
            bVar.a(aVar, getItemCount());
        }
    }
}
