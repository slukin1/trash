package com.huobi.homemarket.helper;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cpiz.android.bubbleview.BubbleImpl;
import com.cpiz.android.bubbleview.BubbleTextView;
import com.cpiz.android.bubbleview.c;
import com.cpiz.android.bubbleview.d;
import com.hbg.lib.core.R$color;
import com.hbg.lib.core.R$id;
import com.hbg.lib.core.R$layout;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.market.R$dimen;
import com.hbg.module.market.R$string;
import com.huobi.view.LightBubblePopup;
import java.io.Serializable;
import rl.e;
import rl.f;
import rl.g;
import rl.h;
import rl.i;

public class MarketContentGuideHelper implements Serializable {
    public static final String BUBBLE_MARKET_COLLECTION_FRESH_GUIDE = "BUBBLE_MARKET_COLLECTION_FRESH_GUIDE";
    public static final String BUBBLE_MARKET_CONTENT_GUIDE = "BUBBLE_MARKET_CONTENT_GUIDE";
    public static final String BUBBLE_MARKET_REMIND_GUIDE = "BUBBLE_MARKET_REMIND_GUIDE";
    public static final String BUBBLE_MARKET_STARE_GUIDE = "BUBBLE_MARKET_STARE_GUIDE1";
    private static volatile MarketContentGuideHelper instance = new MarketContentGuideHelper();
    private boolean showing = false;

    private int getGuideBgColor() {
        return -10592671;
    }

    private int getGuideTextColor() {
        return -1;
    }

    public static MarketContentGuideHelper getInstance() {
        return instance;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showCollectionGuide$0(String str, DialogInterface.OnDismissListener onDismissListener) {
        this.showing = false;
        ConfigPreferences.n("user_config", str, true);
        if (onDismissListener != null) {
            onDismissListener.onDismiss((DialogInterface) null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showCollectionGuide$1(BaseFragment baseFragment, View view, String str, String str2, DialogInterface.OnDismissListener onDismissListener) {
        if (baseFragment == null || baseFragment.isCanBeSeen()) {
            View inflate = LayoutInflater.from(view.getContext()).inflate(R$layout.view_light_bubble, (ViewGroup) null);
            BubbleTextView bubbleTextView = (BubbleTextView) inflate.findViewById(R$id.popup_bubble);
            Resources resources = inflate.getResources();
            int i11 = R$color.baseColorLightBubble;
            bubbleTextView.setFillColor(resources.getColor(i11));
            bubbleTextView.setBorderColor(inflate.getResources().getColor(i11));
            bubbleTextView.setTextColor(inflate.getResources().getColor(R$color.color_white));
            bubbleTextView.setText(str);
            LightBubblePopup lightBubblePopup = new LightBubblePopup(inflate, bubbleTextView, NightHelper.e().g());
            d dVar = new d(0, 2);
            lightBubblePopup.setOnDismissListener(new f(this, str2, onDismissListener));
            lightBubblePopup.setArrowPosDelta(0);
            lightBubblePopup.showArrowTo(view, dVar, 0, 0);
            return;
        }
        this.showing = false;
        if (onDismissListener != null) {
            onDismissListener.onDismiss((DialogInterface) null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showFreshItemGuide$2(String str) {
        this.showing = false;
        ConfigPreferences.n("user_config", str, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showFreshItemGuide$3(BaseFragment baseFragment, View view, String str, String str2) {
        if (baseFragment == null || baseFragment.isCanBeSeen()) {
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
            lightBubblePopup.setOnDismissListener(new e(this, str2));
            lightBubblePopup.showArrowTo(view, dVar, 0, 0);
            return;
        }
        this.showing = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showMarketStareGuide$4(DialogInterface.OnDismissListener onDismissListener) {
        this.showing = false;
        ConfigPreferences.n("user_config", BUBBLE_MARKET_STARE_GUIDE, true);
        if (onDismissListener != null) {
            onDismissListener.onDismiss((DialogInterface) null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showMarketStareGuide$5(View view, BaseFragment baseFragment, DialogInterface.OnDismissListener onDismissListener) {
        if (view.getVisibility() != 0 || (baseFragment != null && !baseFragment.isCanBeSeen())) {
            this.showing = false;
            if (onDismissListener != null) {
                onDismissListener.onDismiss((DialogInterface) null);
                return;
            }
            return;
        }
        View inflate = LayoutInflater.from(view.getContext()).inflate(R$layout.view_light_bubble, (ViewGroup) null);
        BubbleTextView bubbleTextView = (BubbleTextView) inflate.findViewById(R$id.popup_bubble);
        bubbleTextView.setFillColor(getGuideBgColor());
        bubbleTextView.setBorderColor(getGuideBgColor());
        bubbleTextView.setTextColor(getGuideTextColor());
        bubbleTextView.setBorderWidth(0.0f);
        bubbleTextView.setText(R$string.n_market_real_time_popup_text);
        Resources resources = view.getResources();
        int i11 = R$dimen.dimen_12;
        int dimensionPixelOffset = resources.getDimensionPixelOffset(i11);
        Resources resources2 = view.getResources();
        int i12 = R$dimen.dimen_8;
        bubbleTextView.setPadding(dimensionPixelOffset, resources2.getDimensionPixelOffset(i12), view.getResources().getDimensionPixelOffset(i11), view.getResources().getDimensionPixelOffset(i12));
        bubbleTextView.getBubbleImpl().B((float) view.getResources().getDimensionPixelOffset(i12));
        BubbleImpl bubbleImpl = bubbleTextView.getBubbleImpl();
        Resources resources3 = view.getResources();
        int i13 = R$dimen.dimen_4;
        bubbleImpl.y((float) resources3.getDimensionPixelOffset(i13));
        bubbleTextView.setMaxWidth(view.getResources().getDimensionPixelOffset(R$dimen.dimen_240));
        c cVar = new c(inflate, bubbleTextView);
        d dVar = new d(4, 2);
        cVar.setCancelOnLater(5000);
        cVar.setOnDismissListener(new rl.d(this, onDismissListener));
        cVar.setArrowPosDelta(view.getResources().getDimensionPixelOffset(R$dimen.dimen_17));
        cVar.showArrowTo(view, dVar, view.getResources().getDimensionPixelOffset(i12), -view.getResources().getDimensionPixelOffset(i13));
    }

    public void showCollectionGuide(BaseFragment baseFragment, View view, String str, String str2) {
        showCollectionGuide(baseFragment, view, str, str2, (DialogInterface.OnDismissListener) null);
    }

    public void showFreshItemGuide(View view, String str, String str2) {
        showFreshItemGuide((BaseFragment) null, view, str, str2);
    }

    public void showMarketStareGuide(BaseFragment baseFragment, View view, DialogInterface.OnDismissListener onDismissListener) {
        if (ConfigPreferences.c("user_config", BUBBLE_MARKET_STARE_GUIDE, false)) {
            if (onDismissListener != null) {
                onDismissListener.onDismiss((DialogInterface) null);
            }
        } else if (!this.showing) {
            this.showing = true;
            view.postDelayed(new g(this, view, baseFragment, onDismissListener), 300);
        }
    }

    public void showCollectionGuide(BaseFragment baseFragment, View view, String str, String str2, DialogInterface.OnDismissListener onDismissListener) {
        if (view == null) {
            return;
        }
        if (ConfigPreferences.c("user_config", str2, false)) {
            if (onDismissListener != null) {
                onDismissListener.onDismiss((DialogInterface) null);
            }
        } else if (!this.showing) {
            this.showing = true;
            view.postDelayed(new i(this, baseFragment, view, str, str2, onDismissListener), 200);
        }
    }

    public void showFreshItemGuide(BaseFragment baseFragment, View view, String str, String str2) {
        if (!ConfigPreferences.c("user_config", str2, false) && view != null && !this.showing) {
            this.showing = true;
            view.postDelayed(new h(this, baseFragment, view, str, str2), 200);
        }
    }
}
