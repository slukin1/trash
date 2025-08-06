package rl;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.module.market.R$color;
import com.hbg.module.market.R$raw;
import com.hbg.module.market.R$string;
import com.huobi.view.HeavyBubblePopup;
import com.huobi.view.HeavyKlineBubblePopup;
import com.huobi.view.HighLightPopup;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f76456a;

    /* renamed from: b  reason: collision with root package name */
    public static List<HeavyBubblePopup> f76457b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static List<HeavyKlineBubblePopup> f76458c = new ArrayList();

    public static void c() {
        for (HeavyBubblePopup dismiss2 : f76457b) {
            dismiss2.dismiss2();
        }
        for (HeavyKlineBubblePopup dismiss22 : f76458c) {
            dismiss22.dismiss2();
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void d(View view) {
        ConfigPreferences.n("user_config", "BUBBLE_MARKET_GUIDE", true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void e(HighLightPopup highLightPopup, HeavyBubblePopup heavyBubblePopup, View view) {
        f76456a = false;
        highLightPopup.dismiss();
        f76457b.remove(heavyBubblePopup);
        if (view.getContext() instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) view.getContext()).getWindow().getDecorView();
            viewGroup.removeViewAt(viewGroup.getChildCount() - 1);
        }
    }

    public static void f(View view) {
        if (view != null && view.getWindowToken() != null && !f76456a && !ConfigPreferences.c("user_config", "BUBBLE_MARKET_GUIDE", false)) {
            f76456a = true;
            HighLightPopup highLightPopup = new HighLightPopup(view);
            highLightPopup.show();
            HeavyBubblePopup heavyBubblePopup = new HeavyBubblePopup(NightHelper.e().g(), view, -2);
            heavyBubblePopup.setArrowOffset(PixelUtils.a(37.0f));
            heavyBubblePopup.setJsonAnim(R$raw.popover_guide_marktes, PixelUtils.a(222.0f), PixelUtils.a(102.0f));
            heavyBubblePopup.setContent(view.getResources().getString(R$string.n_market_pop_guide_tips));
            heavyBubblePopup.setPosText(view.getResources().getString(R$string.showcase_know));
            heavyBubblePopup.setPosListener(j.f25752b);
            heavyBubblePopup.setOnDismissListener(new k(highLightPopup, heavyBubblePopup, view));
            heavyBubblePopup.show(PixelUtils.a(-12.0f), PixelUtils.a(-6.0f));
            f76457b.add(heavyBubblePopup);
            if (view.getContext() instanceof Activity) {
                View view2 = new View(view.getContext());
                view2.setTag("POPUP_WINDOW_VIEW_TAG");
                view2.setBackgroundColor(ContextCompat.getColor(view.getContext(), R$color.bubble_popup_cover));
                ((ViewGroup) ((Activity) view.getContext()).getWindow().getDecorView()).addView(view2);
            }
        }
    }
}
