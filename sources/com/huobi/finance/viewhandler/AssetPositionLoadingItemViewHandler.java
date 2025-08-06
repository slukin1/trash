package com.huobi.finance.viewhandler;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import s9.c;
import vk.f;

public class AssetPositionLoadingItemViewHandler implements c {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f67591a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huobi.asset.AssetAccountType[] r0 = com.huobi.asset.AssetAccountType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f67591a = r0
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.SPOT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f67591a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.FUTURE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f67591a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.MARGIN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f67591a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.OTC     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f67591a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.HUOBI_EARN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f67591a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.QUANT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f67591a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.huobi.asset.AssetAccountType r1 = com.huobi.asset.AssetAccountType.WARRANT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.viewhandler.AssetPositionLoadingItemViewHandler.a.<clinit>():void");
        }
    }

    public String b(Context context, AssetAccountType assetAccountType) {
        String str;
        switch (a.f67591a[assetAccountType.ordinal()]) {
            case 1:
                str = context.getString(R$string.n_spot);
                break;
            case 2:
                str = context.getString(R$string.n_title_future);
                break;
            case 3:
                str = context.getString(R$string.n_kline_loan);
                break;
            case 4:
                str = context.getString(R$string.n_trade_fiat_title);
                break;
            case 5:
                str = context.getString(R$string.n_asset_ybb_stop_financial);
                break;
            case 6:
                str = context.getString(R$string.n_balance_strategy);
                break;
            case 7:
                str = context.getString(R$string.n_option);
                break;
            default:
                str = "";
                break;
        }
        return str + context.getString(R$string.n_asset_position_data_loading_hint);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, f fVar, ViewGroup viewGroup) {
        TextView textView = (TextView) cVar.e().b(R$id.classic_footer_title);
        Context context = cVar.itemView.getContext();
        textView.setTextColor(context.getResources().getColor(R$color.baseColorThreeLevelTextNew));
        textView.setText(b(context, fVar.a()));
    }

    public int getResId() {
        return R$layout.view_smart_refresh_footer;
    }
}
