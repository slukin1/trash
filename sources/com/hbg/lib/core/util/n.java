package com.hbg.lib.core.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.cpiz.android.bubbleview.BubbleTextView;
import com.cpiz.android.bubbleview.c;
import com.cpiz.android.bubbleview.d;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.R$color;
import com.hbg.lib.core.R$dimen;
import com.hbg.lib.core.R$id;
import com.hbg.lib.core.R$layout;
import com.hbg.lib.core.R$string;
import com.huobi.view.LightBubblePopup;
import java.util.HashMap;
import java.util.Map;

public final class n {

    /* renamed from: j  reason: collision with root package name */
    public static final n f68727j = new n();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Pair<View, Long>> f68728a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, Pair<View, Long>> f68729b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, Pair<View, Long>> f68730c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public Map<String, Pair<View, Long>> f68731d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public boolean f68732e;

    /* renamed from: f  reason: collision with root package name */
    public LightBubblePopup f68733f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f68734g;

    /* renamed from: h  reason: collision with root package name */
    public c f68735h;

    /* renamed from: i  reason: collision with root package name */
    public c f68736i;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f68737b;

        public a(View view) {
            this.f68737b = view;
        }

        public void run() {
            View inflate = LayoutInflater.from(this.f68737b.getContext()).inflate(R$layout.view_light_bubble, (ViewGroup) null);
            BubbleTextView bubbleTextView = (BubbleTextView) inflate.findViewById(R$id.popup_bubble);
            bubbleTextView.setText(R$string.n_exchange_order_tip);
            LightBubblePopup lightBubblePopup = new LightBubblePopup(inflate, bubbleTextView, NightHelper.e().g());
            d dVar = new d(3, 2);
            lightBubblePopup.setArrowPosDelta(PixelUtils.a(23.0f));
            lightBubblePopup.showArrowTo(this.f68737b, dVar, 0, 0);
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f68739b;

        public b(View view) {
            this.f68739b = view;
        }

        public void run() {
            View inflate = LayoutInflater.from(this.f68739b.getContext()).inflate(R$layout.view_light_bubble, (ViewGroup) null);
            BubbleTextView bubbleTextView = (BubbleTextView) inflate.findViewById(R$id.popup_bubble);
            bubbleTextView.setText(R$string.n_kline_draw_line_tip_set);
            new LightBubblePopup(inflate, bubbleTextView, NightHelper.e().g()).showArrowTo(this.f68739b, new d(1, 0), PixelUtils.a(10.0f), PixelUtils.a(5.0f));
        }
    }

    public static n o() {
        return f68727j;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(Activity activity, ImageView imageView) {
        if (activity != null && !activity.isDestroyed() && !imageView.isSelected()) {
            View inflate = LayoutInflater.from(imageView.getContext()).inflate(R$layout.view_light_bubble, (ViewGroup) null);
            BubbleTextView bubbleTextView = (BubbleTextView) inflate.findViewById(R$id.popup_bubble);
            bubbleTextView.setText(R$string.n_kline_add_collection_guide);
            bubbleTextView.setFillColor(-10592671);
            bubbleTextView.setBorderColor(-10592671);
            bubbleTextView.setBorderWidth(0.0f);
            bubbleTextView.setTextColor(-1);
            Resources resources = imageView.getResources();
            int i11 = R$dimen.dimen_12;
            int dimensionPixelOffset = resources.getDimensionPixelOffset(i11);
            Resources resources2 = imageView.getResources();
            int i12 = R$dimen.dimen_8;
            bubbleTextView.a(dimensionPixelOffset, resources2.getDimensionPixelOffset(i12), imageView.getResources().getDimensionPixelOffset(i11), imageView.getResources().getDimensionPixelOffset(i12));
            bubbleTextView.getBubbleImpl().B((float) imageView.getResources().getDimensionPixelOffset(i12));
            bubbleTextView.getBubbleImpl().y((float) imageView.getResources().getDimensionPixelOffset(R$dimen.dimen_4));
            bubbleTextView.setMaxWidth(imageView.getResources().getDimensionPixelOffset(R$dimen.dimen_310));
            c cVar = new c(inflate, bubbleTextView);
            cVar.setArrowPosDelta(imageView.getWidth() / 2);
            d dVar = new d(0, 2);
            cVar.setCancelOnLater(10000);
            cVar.setPadding(PixelUtils.a(10.0f));
            cVar.setCancelOnTouch(true);
            cVar.setCancelOnTouchOutside(true);
            cVar.showArrowTo(imageView, dVar, 0, imageView.getResources().getDimensionPixelOffset(R$dimen.dimen_0));
            cVar.setOnDismissListener(new d(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r() {
        this.f68734g = null;
    }

    public static /* synthetic */ void s(View view) {
        View inflate = LayoutInflater.from(view.getContext()).inflate(R$layout.view_light_bubble, (ViewGroup) null);
        BubbleTextView bubbleTextView = (BubbleTextView) inflate.findViewById(R$id.popup_bubble);
        bubbleTextView.setText(R$string.n_cloud_wallet_asset_page_analysis_change);
        LightBubblePopup lightBubblePopup = new LightBubblePopup(inflate, bubbleTextView, NightHelper.e().g());
        d dVar = new d(0, 2);
        lightBubblePopup.setPadding(PixelUtils.a(15.0f));
        lightBubblePopup.showArrowTo(view, dVar, 0, PixelUtils.a(5.0f));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t() {
        this.f68735h = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u(View view, String str) {
        if (this.f68735h == null) {
            View inflate = LayoutInflater.from(view.getContext()).inflate(R$layout.view_bubble_with_white_bg, (ViewGroup) null);
            BubbleTextView bubbleTextView = (BubbleTextView) inflate.findViewById(R$id.popup_bubble);
            bubbleTextView.setText(view.getContext().getResources().getString(R$string.n_experience_fund_optimize_available_hint, new Object[]{str}));
            c cVar = new c(inflate, bubbleTextView);
            this.f68735h = cVar;
            cVar.setCancelOnTouch(true);
            this.f68735h.setCancelOnTouchOutside(true);
            d dVar = new d(0, 1);
            this.f68735h.setCancelOnLater(3000);
            this.f68735h.setPadding(PixelUtils.a(8.0f));
            this.f68735h.showArrowTo(view, dVar, 0, PixelUtils.a(5.0f));
            this.f68735h.setOnDismissListener(new e(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v() {
        this.f68732e = false;
        l();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        View inflate = LayoutInflater.from(view.getContext()).inflate(R$layout.view_light_bubble, (ViewGroup) null);
        BubbleTextView bubbleTextView = (BubbleTextView) inflate.findViewById(R$id.popup_bubble);
        bubbleTextView.setText(R$string.account_exchange_btn_tips);
        LightBubblePopup lightBubblePopup = new LightBubblePopup(inflate, bubbleTextView, NightHelper.e().g());
        d dVar = new d(3, 2);
        lightBubblePopup.setArrowPosDelta(PixelUtils.a(23.5f));
        lightBubblePopup.setPadding(PixelUtils.a(5.0f));
        lightBubblePopup.showArrowTo(view, dVar, -PixelUtils.a(10.0f), 0);
        ConfigPreferences.n("user_config", "BUBBLE_HINT_INDEX_KEY", true);
        lightBubblePopup.setOnDismissListener(new f(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x() {
        this.f68733f = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        if (this.f68733f == null) {
            View inflate = LayoutInflater.from(view.getContext()).inflate(R$layout.view_bubble_with_white_bg, (ViewGroup) null);
            BubbleTextView bubbleTextView = (BubbleTextView) inflate.findViewById(R$id.popup_bubble);
            bubbleTextView.setText(view.getResources().getString(R$string.n_user_center_nft_tip));
            this.f68733f = new LightBubblePopup(inflate, bubbleTextView, NightHelper.e().g());
            d dVar = new d(0, 1);
            this.f68733f.setCancelOnTouchOutside(false);
            this.f68733f.setCancelOnLater(5000);
            this.f68733f.setPadding(PixelUtils.a(10.0f));
            this.f68733f.showArrowTo(view, dVar, 0, PixelUtils.a(5.0f));
            this.f68733f.setOnDismissListener(new g(this));
        }
    }

    public static /* synthetic */ void z() {
    }

    public void A(String str, View view) {
        if (!ConfigPreferences.c("user_config", "BUBBLE_HINT_INDEX_KEY", false)) {
            this.f68730c.put(str, new Pair(view, Long.valueOf(System.nanoTime())));
            if (k() && !this.f68732e) {
                this.f68732e = true;
                H();
            }
        }
    }

    public void B(View view) {
        view.removeCallbacks(this.f68734g);
        this.f68734g = null;
    }

    public void C(Activity activity, ImageView imageView, long j11) {
        j jVar = new j(this, activity, imageView);
        this.f68734g = jVar;
        imageView.postDelayed(jVar, j11);
    }

    public void D(View view) {
        if (!ConfigPreferences.c("user_config", "BUBBLE_HINT_ASSET_ANALYSIS_ENTRANCE_KEY", false)) {
            ConfigPreferences.n("user_config", "BUBBLE_HINT_ASSET_ANALYSIS_ENTRANCE_KEY", true);
            view.postDelayed(new i(view), 100);
        }
    }

    public void E(View view) {
        if (!ConfigPreferences.c("user_config", "BUBBLE_HINT_KLINE_DRAW_KEY", false)) {
            ConfigPreferences.n("user_config", "BUBBLE_HINT_KLINE_DRAW_KEY", true);
            view.postDelayed(new b(view), 600);
        }
    }

    public void F(View view, String str) {
        view.postDelayed(new m(this, view, str), 100);
    }

    public final void G() {
        Pair pair = this.f68730c.get("INDEX_HINT_STEP1");
        if ((pair == null || pair.first == null) ? false : true) {
            View view = (View) pair.first;
            view.postDelayed(new k(this, view), 600);
        }
    }

    public void H() {
        if (k()) {
            G();
        } else {
            this.f68730c.clear();
        }
    }

    public void I(View view) {
        view.postDelayed(new l(this, view), 100);
    }

    public void J(View view) {
        if (!TextUtils.equals(ConfigPreferences.e("user_config", "HBUserGuidePopViewTypeEntrustListInt", "0"), "1")) {
            ConfigPreferences.m("user_config", "HBUserGuidePopViewTypeEntrustListInt", "1");
            if (view != null) {
                view.postDelayed(new a(view), 100);
            }
        }
    }

    public com.cpiz.android.bubbleview.b K(View view) {
        View inflate = LayoutInflater.from(view.getContext()).inflate(R$layout.view_light_bubble, (ViewGroup) null);
        BubbleTextView bubbleTextView = (BubbleTextView) inflate.findViewById(R$id.popup_bubble);
        bubbleTextView.setText(view.getResources().getString(R$string.n_unit_deposit_release_pop_tip));
        bubbleTextView.setLineSpacing((float) PixelUtils.a(4.0f), 1.0f);
        Context context = view.getContext();
        int i11 = R$color.global_input_hint_color_night;
        bubbleTextView.setBorderColor(ContextCompat.getColor(context, i11));
        bubbleTextView.setFillColor(ContextCompat.getColor(view.getContext(), i11));
        bubbleTextView.setCornerRadius((float) PixelUtils.a(4.0f));
        bubbleTextView.getBubbleImpl().B((float) PixelUtils.a(8.0f));
        bubbleTextView.getBubbleImpl().y((float) PixelUtils.a(4.0f));
        bubbleTextView.setMaxWidth(view.getResources().getDimensionPixelOffset(R$dimen.dimen_220));
        com.cpiz.android.bubbleview.b bVar = new com.cpiz.android.bubbleview.b(inflate, bubbleTextView);
        d dVar = new d(4, 2);
        bVar.l(PixelUtils.a(10.0f));
        bVar.i(0);
        bVar.k(false);
        bVar.h(view.getResources().getDimensionPixelOffset(R$dimen.dimen_14));
        bVar.m(view, dVar, PixelUtils.a(5.0f), 0);
        bVar.setOnDismissListener(h.f68706b);
        return bVar;
    }

    public final boolean k() {
        Pair pair = this.f68730c.get("INDEX_HINT_STEP1");
        return (pair == null || pair.first == null) ? false : true;
    }

    public void l() {
        this.f68730c.clear();
    }

    public void m() {
        c cVar = this.f68736i;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    public void n() {
        LightBubblePopup lightBubblePopup = this.f68733f;
        if (lightBubblePopup != null) {
            lightBubblePopup.dismiss();
        }
    }

    public boolean p() {
        return this.f68733f != null;
    }
}
