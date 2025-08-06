package com.huobi.tradenew.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.cpiz.android.bubbleview.BubbleLinearLayout;
import com.cpiz.android.bubbleview.Utils;
import com.cpiz.android.bubbleview.d;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.huobi.utils.SymbolUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import pro.huobi.R;

public class TradeSpotPopUtil {

    public class a implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    public interface b {
        void a(int i11, boolean z11);
    }

    public interface c {
        void a(String str);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void d(b bVar, com.cpiz.android.bubbleview.b bVar2, View view) {
        int i11 = 75;
        boolean z11 = false;
        switch (view.getId()) {
            case R.id.pop_max_percent_100:
                i11 = 100;
                break;
            case R.id.pop_max_percent_25:
                i11 = 25;
                break;
            case R.id.pop_max_percent_50:
                i11 = 50;
                break;
            case R.id.pop_max_percent_75:
                break;
            case R.id.pop_percent_100:
                i11 = 100;
                break;
            case R.id.pop_percent_25:
                i11 = 25;
                break;
            case R.id.pop_percent_50:
                i11 = 50;
                break;
            case R.id.pop_percent_75:
                break;
            default:
                i11 = 0;
                break;
        }
        z11 = true;
        bVar.a(i11, z11);
        bVar2.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void e(WindowManager.LayoutParams layoutParams, Window window) {
        layoutParams.alpha = 1.0f;
        window.addFlags(2);
        window.setAttributes(layoutParams);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void f(c cVar, String str, String str2, String str3, String str4, com.cpiz.android.bubbleview.b bVar, View view) {
        int id2 = view.getId();
        if (id2 == R.id.pop_price_ask) {
            cVar.a(m.m(str4, PrecisionUtil.A(str2)));
        } else if (id2 == R.id.pop_price_bld) {
            cVar.a(m.m(str3, PrecisionUtil.A(str2)));
        } else if (id2 == R.id.pop_price_limit) {
            cVar.a(m.m(str, PrecisionUtil.A(str2)));
        }
        bVar.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static boolean g(View view, int i11) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        if (iArr[1] - i11 < PixelUtils.a(100.0f)) {
            return false;
        }
        return true;
    }

    public static void h(View view, boolean z11, boolean z12, boolean z13, b bVar, View.OnClickListener onClickListener) {
        if (view != null) {
            Context context = view.getContext();
            View inflate = LayoutInflater.from(context).inflate(R.layout.pop_amount_percent, (ViewGroup) null, false);
            BubbleLinearLayout bubbleLinearLayout = (BubbleLinearLayout) inflate.findViewById(R.id.amount_pop_root);
            bubbleLinearLayout.setArrowCornerRadius(0);
            TextView textView = (TextView) inflate.findViewById(R.id.pop_margin_text);
            TextView textView2 = (TextView) inflate.findViewById(R.id.pop_spot_text);
            if (!z11) {
                textView2.setText(context.getString(R.string.n_exchange_sell_on_spot));
                textView.setText(context.getString(R.string.n_exchange_sell_on_margin));
            }
            if (z13) {
                textView2.setText(context.getString(R.string.trade_asset_available));
                textView.setText(context.getString(R.string.n_spot_max_available));
            }
            int i11 = 132;
            if (!z12) {
                i11 = 72;
                textView.setVisibility(8);
                inflate.findViewById(R.id.pop_margin_layout).setVisibility(8);
            } else {
                textView.setOnClickListener(onClickListener);
            }
            com.cpiz.android.bubbleview.b bVar2 = new com.cpiz.android.bubbleview.b(inflate, bubbleLinearLayout);
            e2 e2Var = new e2(bVar, bVar2);
            inflate.findViewById(R.id.pop_percent_25).setOnClickListener(e2Var);
            inflate.findViewById(R.id.pop_percent_50).setOnClickListener(e2Var);
            inflate.findViewById(R.id.pop_percent_75).setOnClickListener(e2Var);
            inflate.findViewById(R.id.pop_percent_100).setOnClickListener(e2Var);
            inflate.findViewById(R.id.pop_max_percent_25).setOnClickListener(e2Var);
            inflate.findViewById(R.id.pop_max_percent_50).setOnClickListener(e2Var);
            inflate.findViewById(R.id.pop_max_percent_75).setOnClickListener(e2Var);
            inflate.findViewById(R.id.pop_max_percent_100).setOnClickListener(e2Var);
            i(view, bVar2, i11);
        }
    }

    public static void i(View view, com.cpiz.android.bubbleview.b bVar, int i11) {
        d dVar;
        int i12;
        bVar.setTouchable(true);
        bVar.setTouchInterceptor(new a());
        if (view.getContext() instanceof Activity) {
            Window window = ((Activity) view.getContext()).getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (NightHelper.e().g()) {
                attributes.alpha = 0.5f;
            } else {
                attributes.alpha = 0.8f;
            }
            window.setAttributes(attributes);
            window.addFlags(2);
            bVar.setOnDismissListener(new g2(attributes, window));
        }
        if (g(view, PixelUtils.a((float) i11))) {
            dVar = new d(0, 1);
            i12 = -Utils.d(view);
            bVar.setAnimationStyle(R.style.TradePopDownStyle);
        } else {
            dVar = new d(0, 2);
            bVar.setAnimationStyle(R.style.TradePopUpStyle);
            i12 = 0;
        }
        bVar.l(PixelUtils.a(15.0f));
        bVar.n(view, dVar, 0, i12);
    }

    public static void j(View view, String str, String str2, String str3, String str4, c cVar) {
        if (view != null) {
            String c11 = SymbolUtil.c(str4, false);
            View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.pop_trade_price, (ViewGroup) null, false);
            ((TextView) inflate.findViewById(R.id.pop_price_limit_text)).setText(str + " " + c11);
            ((TextView) inflate.findViewById(R.id.pop_price_ask_text)).setText(str3 + " " + c11);
            ((TextView) inflate.findViewById(R.id.pop_price_bld_text)).setText(str2 + " " + c11);
            BubbleLinearLayout bubbleLinearLayout = (BubbleLinearLayout) inflate.findViewById(R.id.pop_price_root);
            bubbleLinearLayout.setArrowCornerRadius(0);
            com.cpiz.android.bubbleview.b bVar = new com.cpiz.android.bubbleview.b(inflate, bubbleLinearLayout);
            f2 f2Var = new f2(cVar, str, str4, str2, str3, bVar);
            inflate.findViewById(R.id.pop_price_limit).setOnClickListener(f2Var);
            inflate.findViewById(R.id.pop_price_ask).setOnClickListener(f2Var);
            inflate.findViewById(R.id.pop_price_bld).setOnClickListener(f2Var);
            i(view, bVar, 68);
        }
    }
}
