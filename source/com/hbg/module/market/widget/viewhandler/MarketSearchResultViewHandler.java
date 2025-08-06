package com.hbg.module.market.widget.viewhandler;

import a7.e;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$color;
import com.hbg.module.market.R$dimen;
import com.hbg.module.market.R$drawable;
import com.hbg.module.market.R$font;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.widget.bean.MarketSearchResultItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import ej.g;
import i6.r;
import jf.b;
import org.greenrobot.eventbus.EventBus;
import s9.c;
import us.j;

public class MarketSearchResultViewHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public String f26800b;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26801a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f26801a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f26801a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f26801a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT_INDEX     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f26801a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP_INDEX     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f26801a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.market.widget.viewhandler.MarketSearchResultViewHandler.a.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void e(ImageView imageView, RelativeLayout relativeLayout, View view) {
        MarketSearchResultItem marketSearchResultItem = (MarketSearchResultItem) view.getTag(R$id.item_data1);
        marketSearchResultItem.setSelected(!marketSearchResultItem.isSelected());
        h(marketSearchResultItem, imageView);
        EventBus.d().k(new p000if.a(marketSearchResultItem, imageView));
        SoftInputUtils.f((Activity) relativeLayout.getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static String f(String str, TradeType tradeType) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int i11 = a.f26801a[tradeType.ordinal()];
        if (i11 == 1) {
            return StringUtils.i(g.f(str)) + " " + g.c(str);
        } else if (i11 != 2) {
            if (i11 == 3 || i11 == 4) {
                if (str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    return j.a(str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0], BaseApplication.b());
                }
                return "";
            } else if (i11 != 5) {
                return a1.v().p(str);
            } else {
                if (!str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                    return "";
                }
                return e.n(BaseApplication.b(), str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0]);
            }
        } else if (str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return j.h(str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0], BaseApplication.b());
        } else {
            return "";
        }
    }

    public static String g(String str, TradeType tradeType) {
        int i11;
        if (TextUtils.isEmpty(str) || (i11 = a.f26801a[tradeType.ordinal()]) == 1) {
            return "";
        }
        if (i11 == 2 || i11 == 3) {
            return "USD";
        }
        if (i11 != 4 && i11 != 5) {
            return a1.v().F(str);
        }
        if (str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1];
        }
        return "";
    }

    public final TradeType c(int i11) {
        if (i11 == 0) {
            return TradeType.PRO;
        }
        if (i11 == 1) {
            return TradeType.CONTRACT;
        }
        if (i11 == 2) {
            return TradeType.SWAP;
        }
        if (i11 == 4) {
            return TradeType.LINEAR_SWAP;
        }
        if (i11 == 5) {
            return TradeType.CONTRACT_INDEX;
        }
        if (i11 != 6) {
            return TradeType.PRO;
        }
        return TradeType.LINEAR_SWAP_INDEX;
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, MarketSearchResultItem marketSearchResultItem, ViewGroup viewGroup) {
        String str;
        String str2;
        String str3;
        String str4;
        v9.c cVar2 = cVar;
        MarketSearchResultItem marketSearchResultItem2 = marketSearchResultItem;
        r e11 = cVar.e();
        RelativeLayout relativeLayout = (RelativeLayout) e11.b(R$id.item_search_symbol_layout);
        TextView e12 = e11.e(R$id.item_search_symbol_result);
        TextView e13 = e11.e(R$id.item_search_qotue_currency);
        ImageView c11 = e11.c(R$id.item_search_symbol_selected);
        View b11 = e11.b(R$id.v_item_divider_line);
        c11.setVisibility(0);
        b11.setVisibility(0);
        String f11 = f(marketSearchResultItem.getSymbol(), c(marketSearchResultItem.getItemCurrencyType()));
        String g11 = g(marketSearchResultItem.getSymbol(), c(marketSearchResultItem.getItemCurrencyType()));
        if (marketSearchResultItem.getItemCurrencyType() == 4 || marketSearchResultItem.getItemCurrencyType() == 2 || marketSearchResultItem.getItemCurrencyType() == 1) {
            String str5 = "";
            if (marketSearchResultItem.getLinearSwapContractInfo() != null) {
                FutureContractInfo linearSwapContractInfo = marketSearchResultItem.getLinearSwapContractInfo();
                str2 = linearSwapContractInfo.getContractCode();
                str = linearSwapContractInfo.getSymbol();
                str3 = linearSwapContractInfo.getContractType();
            } else {
                str3 = str5;
                str2 = str3;
                str = str2;
            }
            if (marketSearchResultItem.getSwapCurrencyInfo() != null) {
                SwapCurrencyInfo swapCurrencyInfo = marketSearchResultItem.getSwapCurrencyInfo();
                str2 = swapCurrencyInfo.getContractCode();
                str = swapCurrencyInfo.getSymbol();
                if (TextUtils.isEmpty(swapCurrencyInfo.getContractType())) {
                    str3 = "swap";
                } else {
                    str3 = swapCurrencyInfo.getContractType();
                }
            }
            if (marketSearchResultItem.getContractCurrencyInfo() != null) {
                ContractCurrencyInfo contractCurrencyInfo = marketSearchResultItem.getContractCurrencyInfo();
                str2 = contractCurrencyInfo.getContractCode();
                str = contractCurrencyInfo.getSymbol();
                str3 = contractCurrencyInfo.getContractType();
                str4 = "USD";
            } else {
                str4 = str5;
            }
            if (str2.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER) > 0) {
                String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                str4 = split.length > 1 ? split[1] : str5;
            }
            Context context = cVar2.itemView.getContext();
            if (!TextUtils.isEmpty(str3)) {
                str5 = str3;
            }
            String v11 = e.v(context, str, str4, str2, str5);
            int indexOf = v11.indexOf(" ");
            if (-1 != indexOf) {
                SpannableString spannableString = new SpannableString(v11);
                Resources resources = cVar2.itemView.getResources();
                int i12 = R$color.baseColorPrimaryText;
                spannableString.setSpan(new ForegroundColorSpan(resources.getColor(i12)), 0, indexOf, 33);
                if (Build.VERSION.SDK_INT >= 28) {
                    spannableString.setSpan(new TypefaceSpan(ResourcesCompat.h(cVar2.itemView.getContext(), R$font.roboto_medium)), 0, indexOf, 33);
                }
                spannableString.setSpan(new AbsoluteSizeSpan(cVar2.itemView.getResources().getDimensionPixelSize(R$dimen.global_text_size_14)), 0, indexOf, 33);
                spannableString.setSpan(new ForegroundColorSpan(cVar2.itemView.getResources().getColor(i12)), 0, indexOf, 33);
                e13.setText(spannableString);
            }
        } else {
            if (!TextUtils.isEmpty(g11)) {
                f11 = f11 + " /" + g11;
            }
            int indexOf2 = f11.indexOf("/");
            if (-1 != indexOf2) {
                SpannableString spannableString2 = new SpannableString(f11);
                Resources resources2 = cVar2.itemView.getResources();
                int i13 = R$color.baseColorPrimaryText;
                spannableString2.setSpan(new ForegroundColorSpan(resources2.getColor(i13)), 0, indexOf2, 33);
                if (Build.VERSION.SDK_INT >= 28) {
                    spannableString2.setSpan(new TypefaceSpan(ResourcesCompat.h(cVar2.itemView.getContext(), R$font.roboto_medium)), 0, indexOf2, 33);
                }
                spannableString2.setSpan(new AbsoluteSizeSpan(cVar2.itemView.getResources().getDimensionPixelSize(R$dimen.global_text_size_14)), 0, indexOf2, 33);
                spannableString2.setSpan(new ForegroundColorSpan(cVar2.itemView.getResources().getColor(i13)), 0, indexOf2, 33);
                e13.setText(spannableString2);
            } else {
                e12.setText(f11);
            }
        }
        h(marketSearchResultItem2, c11);
        relativeLayout.setClickable(true);
        relativeLayout.setTag(R$id.item_data1, marketSearchResultItem2);
        relativeLayout.setOnClickListener(new pf.c(this, c11, relativeLayout));
    }

    public int getResId() {
        b b11 = MarketModuleConfig.b();
        if (b11 != null) {
            this.f26800b = b11.getUid();
        } else {
            this.f26800b = "local_uid";
        }
        return R$layout.item_market_search_symbol_result;
    }

    public final void h(MarketSearchResultItem marketSearchResultItem, ImageView imageView) {
        if (marketSearchResultItem == null) {
            return;
        }
        if (marketSearchResultItem.isSelected()) {
            imageView.setImageResource(R$drawable.common_check_selected);
        } else {
            imageView.setImageResource(R$drawable.common_check_unselected);
        }
    }
}
