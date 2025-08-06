package com.hbg.module.content.utls;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cpiz.android.bubbleview.BubbleTextView;
import com.cpiz.android.bubbleview.d;
import com.hbg.lib.core.R$color;
import com.hbg.lib.core.R$id;
import com.hbg.lib.core.R$layout;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.huobi.view.LightBubblePopup;
import kotlin.jvm.internal.r;

public final class e {

    /* renamed from: b  reason: collision with root package name */
    public static final a f18909b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static volatile e f18910c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f18911a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final e a() {
            e c11 = e.f18910c;
            if (c11 == null) {
                synchronized (this) {
                    c11 = e.f18910c;
                    if (c11 == null) {
                        c11 = new e((r) null);
                        a aVar = e.f18909b;
                        e.f18910c = c11;
                    }
                }
            }
            return c11;
        }
    }

    public e() {
    }

    public /* synthetic */ e(r rVar) {
        this();
    }

    public static final void f(View view, String str, e eVar, String str2) {
        View inflate = LayoutInflater.from(view.getContext()).inflate(R$layout.view_light_bubble, (ViewGroup) null);
        BubbleTextView bubbleTextView = (BubbleTextView) inflate.findViewById(R$id.popup_bubble);
        Resources resources = inflate.getResources();
        int i11 = R$color.baseColorLightBubble;
        bubbleTextView.setFillColor(resources.getColor(i11));
        bubbleTextView.setBorderColor(inflate.getResources().getColor(i11));
        bubbleTextView.setTextColor(inflate.getResources().getColor(R$color.color_white));
        bubbleTextView.setText(str);
        LightBubblePopup lightBubblePopup = new LightBubblePopup(inflate, bubbleTextView, NightHelper.e().g());
        d dVar = new d(0, 1);
        lightBubblePopup.setOnDismissListener(new c(eVar, str2));
        lightBubblePopup.showArrowTo(view, dVar, 0, 0);
    }

    public static final void g(e eVar, String str) {
        eVar.f18911a = false;
        ConfigPreferences.n("user_config", str, true);
    }

    public final void e(View view, String str, String str2) {
        if (!ConfigPreferences.c("user_config", str2, false) && view != null && !this.f18911a) {
            this.f18911a = true;
            view.postDelayed(new d(view, str, this, str2), 200);
        }
    }
}
