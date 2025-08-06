package com.sumsub.sns.core.presentation.base.adapter.holders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sumsub.sns.R;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.r;

public final class d extends com.sumsub.sns.core.presentation.base.adapter.b<com.sumsub.sns.internal.core.presentation.base.adapter.a> {

    /* renamed from: d  reason: collision with root package name */
    public static final a f30912d = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f30913a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f30914b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f30915c;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public static /* synthetic */ d a(a aVar, ViewGroup viewGroup, l lVar, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                lVar = null;
            }
            return aVar.a(viewGroup, lVar);
        }

        public a() {
        }

        public final d a(ViewGroup viewGroup, l<? super String, Unit> lVar) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sns_layout_moderator_comment_item, viewGroup, false), lVar);
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30916a;

        static {
            int[] iArr = new int[SNSStepState.values().length];
            iArr[SNSStepState.APPROVED.ordinal()] = 1;
            iArr[SNSStepState.REJECTED.ordinal()] = 2;
            f30916a = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(View view, l lVar, int i11, r rVar) {
        this(view, (i11 & 2) != 0 ? null : lVar);
    }

    public d(View view, l<? super String, Unit> lVar) {
        super(view);
        this.f30913a = (ImageView) view.findViewById(R.id.sns_status_icon);
        TextView textView = (TextView) view.findViewById(R.id.sns_status_comment);
        this.f30914b = textView;
        this.f30915c = (TextView) view.findViewById(R.id.sns_status_title);
        if (textView != null) {
            com.sumsub.sns.core.common.b.a(textView, lVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.sumsub.sns.internal.core.presentation.base.adapter.a r4, int r5) {
        /*
            r3 = this;
            boolean r5 = r4 instanceof com.sumsub.sns.internal.core.presentation.base.adapter.f
            if (r5 != 0) goto L_0x0005
            return
        L_0x0005:
            com.sumsub.sns.internal.core.presentation.base.adapter.f r4 = (com.sumsub.sns.internal.core.presentation.base.adapter.f) r4
            com.sumsub.sns.internal.core.widget.SNSStepState r5 = r4.g()
            android.widget.ImageView r0 = r3.f30913a
            if (r0 == 0) goto L_0x0061
            r1 = 1
            if (r5 != 0) goto L_0x0014
            r2 = r1
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            com.sumsub.sns.internal.core.common.i.a((android.view.View) r0, (boolean) r2)
            if (r5 == 0) goto L_0x0052
            int[] r2 = com.sumsub.sns.core.presentation.base.adapter.holders.d.b.f30916a
            int r5 = r5.ordinal()
            r5 = r2[r5]
            if (r5 == r1) goto L_0x003d
            r1 = 2
            if (r5 == r1) goto L_0x0028
            goto L_0x0052
        L_0x0028:
            com.sumsub.sns.internal.core.common.e0 r5 = com.sumsub.sns.internal.core.common.e0.f32018a
            com.sumsub.sns.core.data.listener.SNSIconHandler r5 = r5.getIconHandler()
            android.content.Context r1 = r0.getContext()
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSResultIcons r2 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSResultIcons.FAILURE
            java.lang.String r2 = r2.getImageName()
            android.graphics.drawable.Drawable r5 = r5.onResolveIcon(r1, r2)
            goto L_0x0053
        L_0x003d:
            com.sumsub.sns.internal.core.common.e0 r5 = com.sumsub.sns.internal.core.common.e0.f32018a
            com.sumsub.sns.core.data.listener.SNSIconHandler r5 = r5.getIconHandler()
            android.content.Context r1 = r0.getContext()
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSResultIcons r2 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSResultIcons.SUCCESS
            java.lang.String r2 = r2.getImageName()
            android.graphics.drawable.Drawable r5 = r5.onResolveIcon(r1, r2)
            goto L_0x0053
        L_0x0052:
            r5 = 0
        L_0x0053:
            r0.setImageDrawable(r5)
            com.sumsub.sns.internal.core.widget.SNSStepState r5 = r4.g()
            if (r5 != 0) goto L_0x005e
            com.sumsub.sns.internal.core.widget.SNSStepState r5 = com.sumsub.sns.internal.core.widget.SNSStepState.INIT
        L_0x005e:
            com.sumsub.sns.core.widget.SNSStepViewExtensionsKt.setSnsStepState(r0, r5)
        L_0x0061:
            android.widget.TextView r5 = r3.f30915c
            if (r5 == 0) goto L_0x006c
            java.lang.CharSequence r0 = r4.f()
            com.sumsub.sns.internal.core.common.i.a((android.widget.TextView) r5, (java.lang.CharSequence) r0)
        L_0x006c:
            android.widget.TextView r5 = r3.f30914b
            if (r5 == 0) goto L_0x0077
            java.lang.CharSequence r4 = r4.e()
            com.sumsub.sns.internal.core.common.i.a((android.widget.TextView) r5, (java.lang.CharSequence) r4)
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.base.adapter.holders.d.a(com.sumsub.sns.internal.core.presentation.base.adapter.a, int):void");
    }
}
