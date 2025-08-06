package com.sumsub.sns.core.common;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.R;
import com.huochat.community.network.domain.DomainTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.squareup.picasso.Picasso;
import com.sumsub.sns.core.data.listener.SNSEvent;
import com.sumsub.sns.core.data.listener.SNSEventHandler;
import com.sumsub.sns.core.data.model.SNSSupportItem;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.i;
import d10.l;
import d10.r;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class b {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30750a;

        static {
            int[] iArr = new int[SNSSupportItem.Type.values().length];
            iArr[SNSSupportItem.Type.Url.ordinal()] = 1;
            iArr[SNSSupportItem.Type.Email.ordinal()] = 2;
            f30750a = iArr;
        }
    }

    /* renamed from: com.sumsub.sns.core.common.b$b  reason: collision with other inner class name */
    public static final class C0278b extends Lambda implements r<CharSequence, Integer, Integer, Integer, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public static final C0278b f30751a = new C0278b();

        public C0278b() {
            super(4);
        }

        public final void a(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            a((CharSequence) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue(), ((Number) obj4).intValue());
            return Unit.f56620a;
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r<CharSequence, Integer, Integer, Integer, Unit> f30752a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f30753b;

        public c(r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> rVar, TextView textView) {
            this.f30752a = rVar;
            this.f30753b = textView;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            this.f30752a.invoke(charSequence, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
            this.f30753b.removeTextChangedListener(this);
        }
    }

    public static final class d extends com.sumsub.sns.core.presentation.base.text.span.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l<String, Unit> f30754a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ URLSpan f30755b;

        public d(l<? super String, Unit> lVar, URLSpan uRLSpan) {
            this.f30754a = lVar;
            this.f30755b = uRLSpan;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            l<String, Unit> lVar = this.f30754a;
            if (lVar != null) {
                lVar.invoke(this.f30755b.getURL());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static /* synthetic */ void a(TextView textView, l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            lVar = null;
        }
        a(textView, (l<? super String, Unit>) lVar);
    }

    public static final void a(TextView textView, l<? super String, Unit> lVar) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(textView.getText());
        for (Object obj : valueOf.getSpans(0, valueOf.length(), URLSpan.class)) {
            URLSpan uRLSpan = (URLSpan) obj;
            valueOf.setSpan(new d(lVar, uRLSpan), valueOf.getSpanStart(uRLSpan), valueOf.getSpanEnd(uRLSpan), 17);
            valueOf.removeSpan(uRLSpan);
        }
        textView.setText(valueOf);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static final boolean a(SNSSupportItem sNSSupportItem, Context context) {
        SNSEventHandler eventHandler = e0.f32018a.getEventHandler();
        if (eventHandler != null) {
            eventHandler.onEvent(new SNSEvent.SupportItemClicked(sNSSupportItem.getType().name(), sNSSupportItem.getValue()));
        }
        if (sNSSupportItem.getOnClick() != null) {
            l<SNSSupportItem, Unit> onClick = sNSSupportItem.getOnClick();
            if (onClick != null) {
                onClick.invoke(sNSSupportItem);
            }
            return true;
        }
        int i11 = a.f30750a[sNSSupportItem.getType().ordinal()];
        if (i11 == 1) {
            String value = sNSSupportItem.getValue();
            if (!StringsKt__StringsJVMKt.M(value, DomainTool.DOMAIN_PREFIX, false, 2, (Object) null) && !StringsKt__StringsJVMKt.M(value, DomainTool.DOMAIN_PREFIX_HTTP, false, 2, (Object) null)) {
                value = DomainTool.DOMAIN_PREFIX_HTTP + value;
            }
            return i.a(context, Uri.parse(value));
        } else if (i11 != 2) {
            return false;
        } else {
            return i.a(context, Uri.parse("mailto:" + sNSSupportItem.getValue()));
        }
    }

    public static final CharSequence a(CharSequence charSequence, Context context, boolean z11) {
        if (!z11) {
            return charSequence;
        }
        return new SpannableStringBuilder(charSequence).append(" *", new ForegroundColorSpan(i.a(context, R.attr.colorOnError)), 33);
    }

    public static final int a(TypedArray typedArray, int i11, int i12) {
        if (typedArray.hasValue(i11)) {
            if (typedArray.peekValue(i11).type != 2) {
                return typedArray.getColor(i11, i12);
            }
            int resourceId = typedArray.getResourceId(i11, -1);
            if (resourceId != -1) {
                return typedArray.getColor(resourceId, i12);
            }
        }
        return i12;
    }

    public static /* synthetic */ TextWatcher a(TextView textView, r rVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            rVar = C0278b.f30751a;
        }
        c cVar = new c(rVar, textView);
        textView.addTextChangedListener(cVar);
        return cVar;
    }

    public static final TextWatcher a(TextView textView, r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> rVar) {
        c cVar = new c(rVar, textView);
        textView.addTextChangedListener(cVar);
        return cVar;
    }

    public static final float a(int i11) {
        return ((float) i11) * Resources.getSystem().getDisplayMetrics().density;
    }

    public static final Picasso a(Context context) {
        com.sumsub.sns.internal.core.a f11;
        com.sumsub.sns.core.presentation.a aVar = context instanceof com.sumsub.sns.core.presentation.a ? (com.sumsub.sns.core.presentation.a) context : null;
        if (aVar == null || (f11 = aVar.f()) == null) {
            return null;
        }
        return f11.A();
    }
}
