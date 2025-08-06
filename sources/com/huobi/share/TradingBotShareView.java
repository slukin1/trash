package com.huobi.share;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.hbg.core.bean.UserOtherInfoData;
import com.hbg.lib.network.newkyc.bean.AuthInfoNew;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.iproov.sdk.bridge.OptionsBridge;
import i6.m;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.x;
import net.lucode.hackware.magicindicator.buildins.UIUtil;

public final class TradingBotShareView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public final Activity f80848b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80849c = ((TextView) findViewById(R$id.tv_nick));

    /* renamed from: d  reason: collision with root package name */
    public TextView f80850d = ((TextView) findViewById(R$id.tv_time));

    /* renamed from: e  reason: collision with root package name */
    public ImageView f80851e = ((ImageView) findViewById(R$id.iv_huobao));

    /* renamed from: f  reason: collision with root package name */
    public TextView f80852f = ((TextView) findViewById(R$id.tv_yield));

    /* renamed from: g  reason: collision with root package name */
    public View f80853g = findViewById(R$id.rl_yield_container);

    /* renamed from: h  reason: collision with root package name */
    public TextView f80854h = ((TextView) findViewById(R$id.tv_yield_num));

    /* renamed from: i  reason: collision with root package name */
    public TextView f80855i = ((TextView) findViewById(R$id.tv_yield_percent));

    /* renamed from: j  reason: collision with root package name */
    public TextView f80856j = ((TextView) findViewById(R$id.tv_yield_sign));

    /* renamed from: k  reason: collision with root package name */
    public TextView f80857k = ((TextView) findViewById(R$id.tv_total_profit_title));

    /* renamed from: l  reason: collision with root package name */
    public TextView f80858l = ((TextView) findViewById(R$id.tv_total_profit_value));

    /* renamed from: m  reason: collision with root package name */
    public TextView f80859m = ((TextView) findViewById(R$id.tv_share_code_title));

    /* renamed from: n  reason: collision with root package name */
    public TextView f80860n = ((TextView) findViewById(R$id.tv_share_code_value));

    /* renamed from: o  reason: collision with root package name */
    public TextView f80861o = ((TextView) findViewById(R$id.tv_bot_type_value));

    /* renamed from: p  reason: collision with root package name */
    public TextView f80862p = ((TextView) findViewById(R$id.tv_run_time_value));

    /* renamed from: q  reason: collision with root package name */
    public TextView f80863q = ((TextView) findViewById(R$id.tv_symbol_value));

    /* renamed from: r  reason: collision with root package name */
    public TextView f80864r = ((TextView) findViewById(R$id.tv_copy_num_value));

    /* renamed from: s  reason: collision with root package name */
    public View f80865s;

    public interface a {
        void a(ArrayList<Bitmap> arrayList);
    }

    public TradingBotShareView(Activity activity) {
        super(activity);
        this.f80848b = activity;
        this.f80865s = View.inflate(activity, R$layout.layout_trading_bot_share_view, this);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        TextView textView = this.f80850d;
        d0 d0Var = d0.f56774a;
        textView.setText(String.format(getContext().getString(R$string.n_contract_share_time_title), Arrays.copyOf(new Object[]{format}, 1)));
        this.f80857k.setText(String.format(getContext().getString(R$string.n_grid_strategy_profit), Arrays.copyOf(new Object[]{"USDT"}, 1)));
        d();
    }

    public final void a(a aVar) {
        this.f80865s.measure(View.MeasureSpec.makeMeasureSpec(UIUtil.a(getContext(), 275.0d), 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtil.a(getContext(), 800.0d), Integer.MIN_VALUE));
        View view = this.f80865s;
        view.layout(0, 0, view.getMeasuredWidth(), this.f80865s.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(this.f80865s.getMeasuredWidth(), this.f80865s.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.f80865s.draw(new Canvas(createBitmap));
        ArrayList arrayList = new ArrayList();
        arrayList.add(createBitmap);
        aVar.a(arrayList);
    }

    public final String b(String str) {
        return m.q(m.a(str).multiply(new BigDecimal(100)), 2);
    }

    public final boolean c(String str) {
        if (str != null) {
            if (!(str.length() == 0)) {
                if (!(StringsKt__StringsKt.i1(str).toString().length() == 0) && !x.b(str.toLowerCase(Locale.ROOT), OptionsBridge.NULL_VALUE)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void d() {
        AuthInfoNew auth_info;
        AuthInfoNew auth_info2;
        BaseModuleConfig.a a11 = BaseModuleConfig.a();
        boolean z11 = true;
        String str = null;
        if (!(a11 != null && a11.c())) {
            UserKycInfoNew q11 = a11 != null ? a11.q() : null;
            if (q11 == null || (auth_info2 = q11.getAuth_info()) == null || auth_info2.getPro_auth_type() != 10) {
                z11 = false;
            }
            if (!z11) {
                UserOtherInfoData Z = a11.Z();
                if (c(Z != null ? Z.getNick_name() : null)) {
                    if (c(Z != null ? Z.getPhone() : null)) {
                        if (c(Z != null ? Z.getEmail() : null)) {
                            str = a11.i();
                        } else if (Z != null) {
                            str = Z.getEmail();
                        }
                    } else if (Z != null) {
                        str = Z.getPhone();
                    }
                } else if (Z != null) {
                    str = Z.getNick_name();
                }
            } else if (!(q11 == null || (auth_info = q11.getAuth_info()) == null)) {
                str = auth_info.getPro_org_name();
            }
        } else if (a11 != null) {
            str = a11.i();
        }
        if (!TextUtils.isEmpty(str)) {
            this.f80849c.setText(str);
        }
    }

    public final Activity getActivity() {
        return this.f80848b;
    }

    public final ImageView getIvShareBaby() {
        return this.f80851e;
    }

    public final View getShareView() {
        return this.f80865s;
    }

    public final TextView getTvBotType() {
        return this.f80861o;
    }

    public final TextView getTvCopyNum() {
        return this.f80864r;
    }

    public final TextView getTvName() {
        return this.f80849c;
    }

    public final View getTvPositionRateContainer() {
        return this.f80853g;
    }

    public final TextView getTvPositionRateNum() {
        return this.f80854h;
    }

    public final TextView getTvPositionRatePercent() {
        return this.f80855i;
    }

    public final TextView getTvPositionRateSign() {
        return this.f80856j;
    }

    public final TextView getTvPositionRateTitle() {
        return this.f80852f;
    }

    public final TextView getTvRunTime() {
        return this.f80862p;
    }

    public final TextView getTvShareCodeTitle() {
        return this.f80859m;
    }

    public final TextView getTvShareCodeValue() {
        return this.f80860n;
    }

    public final TextView getTvShareTime() {
        return this.f80850d;
    }

    public final TextView getTvSymbol() {
        return this.f80863q;
    }

    public final TextView getTvTotalProfitTitle() {
        return this.f80857k;
    }

    public final TextView getTvTotalProfitValue() {
        return this.f80858l;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        r7 = kotlin.text.StringsKt__StringsJVMKt.G((r14 = kotlin.text.StringsKt__StringsJVMKt.G(r8, "+", "", false, 4, (java.lang.Object) null)), com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "", false, 4, (java.lang.Object) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setData(com.hbg.lib.network.hbg.grid.bean.GridStrategyInfo r21) {
        /*
            r20 = this;
            r1 = r20
            if (r21 != 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.String r0 = r21.getTotalProfitRate()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            java.lang.String r3 = "-"
            java.lang.String r4 = "+"
            java.lang.String r5 = ""
            r6 = 0
            if (r0 != 0) goto L_0x0083
            kotlin.Result$a r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0079 }
            java.lang.String r0 = r21.getTotalProfitRate()     // Catch:{ all -> 0x0079 }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ all -> 0x0079 }
            int r7 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r7 >= 0) goto L_0x002b
            android.widget.TextView r0 = r1.f80856j     // Catch:{ all -> 0x0079 }
            r0.setText(r3)     // Catch:{ all -> 0x0079 }
            goto L_0x003a
        L_0x002b:
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0035
            android.widget.TextView r0 = r1.f80856j     // Catch:{ all -> 0x0079 }
            r0.setText(r4)     // Catch:{ all -> 0x0079 }
            goto L_0x003a
        L_0x0035:
            android.widget.TextView r0 = r1.f80856j     // Catch:{ all -> 0x0079 }
            r0.setText(r5)     // Catch:{ all -> 0x0079 }
        L_0x003a:
            android.widget.TextView r0 = r1.f80854h     // Catch:{ all -> 0x0079 }
            java.lang.String r7 = r21.getTotalProfitRate()     // Catch:{ all -> 0x0079 }
            java.lang.String r8 = r1.b(r7)     // Catch:{ all -> 0x0079 }
            if (r8 == 0) goto L_0x006f
            java.lang.String r9 = "+"
            java.lang.String r10 = ""
            r11 = 0
            r12 = 4
            r13 = 0
            java.lang.String r14 = kotlin.text.StringsKt__StringsJVMKt.G(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0079 }
            if (r14 == 0) goto L_0x006f
            java.lang.String r15 = "-"
            java.lang.String r16 = ""
            r17 = 0
            r18 = 4
            r19 = 0
            java.lang.String r7 = kotlin.text.StringsKt__StringsJVMKt.G(r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x0079 }
            if (r7 == 0) goto L_0x006f
            java.lang.String r8 = "%"
            java.lang.String r9 = ""
            r10 = 0
            r11 = 4
            r12 = 0
            java.lang.String r7 = kotlin.text.StringsKt__StringsJVMKt.G(r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0079 }
            goto L_0x0070
        L_0x006f:
            r7 = r2
        L_0x0070:
            r0.setText(r7)     // Catch:{ all -> 0x0079 }
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0079 }
            kotlin.Result.m3072constructorimpl(r0)     // Catch:{ all -> 0x0079 }
            goto L_0x0083
        L_0x0079:
            r0 = move-exception
            kotlin.Result$a r7 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.k.a(r0)
            kotlin.Result.m3072constructorimpl(r0)
        L_0x0083:
            java.lang.String r0 = r21.getTotalProfitAmount()
            if (r0 == 0) goto L_0x008e
            float r0 = java.lang.Float.parseFloat(r0)
            goto L_0x008f
        L_0x008e:
            r0 = r6
        L_0x008f:
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0094
            goto L_0x0095
        L_0x0094:
            r4 = r5
        L_0x0095:
            android.widget.TextView r0 = r1.f80858l
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = r21.getTotalProfitAmount()
            r6 = 4
            r7 = 1
            java.lang.String r4 = i6.m.o(r4, r6, r7)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r0.setText(r4)
            android.widget.TextView r0 = r1.f80860n
            java.lang.String r4 = r21.getMarkCode()
            r0.setText(r4)
            android.widget.TextView r0 = r1.f80859m
            java.lang.String r4 = r21.getMarkCode()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            r5 = 0
            if (r4 == 0) goto L_0x00ca
            goto L_0x00cb
        L_0x00ca:
            r6 = r5
        L_0x00cb:
            r0.setVisibility(r6)
            java.lang.String r8 = r21.getSymbol()
            r0 = 3
            r4 = 2
            if (r8 == 0) goto L_0x016e
            boolean r2 = kotlin.text.StringsKt__StringsKt.R(r8, r3, r5, r4, r2)
            if (r2 == 0) goto L_0x0115
            android.widget.TextView r2 = r1.f80863q
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r11 = 0
            r12 = 4
            r13 = 0
            java.lang.String r9 = "-"
            java.lang.String r10 = ""
            java.lang.String r6 = kotlin.text.StringsKt__StringsJVMKt.G(r8, r9, r10, r11, r12, r13)
            r3.append(r6)
            android.content.res.Resources r6 = r20.getResources()
            int r8 = com.hbg.module.asset.R$string.n_market_contract_swap_trade_name
            java.lang.String r6 = r6.getString(r8)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r2.setText(r3)
            android.widget.TextView r2 = r1.f80861o
            android.content.res.Resources r3 = r20.getResources()
            int r6 = com.hbg.module.asset.R$string.n_trade_bot_contract_grid
            java.lang.String r3 = r3.getString(r6)
            r2.setText(r3)
            goto L_0x016e
        L_0x0115:
            android.widget.TextView r2 = r1.f80863q
            d7.a1 r3 = d7.a1.v()
            java.lang.String r6 = r21.getSymbol()
            com.hbg.lib.data.symbol.TradeType r8 = com.hbg.lib.data.symbol.TradeType.PRO
            java.lang.String r3 = r3.X(r6, r8)
            r2.setText(r3)
            int r2 = r21.getRunType()
            if (r2 == r4) goto L_0x0150
            if (r2 == r0) goto L_0x0140
            android.widget.TextView r2 = r1.f80861o
            android.content.res.Resources r3 = r20.getResources()
            int r6 = com.hbg.module.asset.R$string.n_trade_bot_spot_grid
            java.lang.String r3 = r3.getString(r6)
            r2.setText(r3)
            goto L_0x015f
        L_0x0140:
            android.widget.TextView r2 = r1.f80861o
            android.content.res.Resources r3 = r20.getResources()
            int r6 = com.hbg.module.asset.R$string.n_trade_bot_infinite_grid
            java.lang.String r3 = r3.getString(r6)
            r2.setText(r3)
            goto L_0x015f
        L_0x0150:
            android.widget.TextView r2 = r1.f80861o
            android.content.res.Resources r3 = r20.getResources()
            int r6 = com.hbg.module.asset.R$string.n_trade_bot_spot_martingale
            java.lang.String r3 = r3.getString(r6)
            r2.setText(r3)
        L_0x015f:
            android.widget.TextView r2 = r1.f80861o
            android.content.res.Resources r3 = r20.getResources()
            int r6 = com.hbg.module.asset.R$string.n_trade_bot_spot_grid
            java.lang.String r3 = r3.getString(r6)
            r2.setText(r3)
        L_0x016e:
            android.widget.TextView r2 = r1.f80864r
            kotlin.jvm.internal.d0 r3 = kotlin.jvm.internal.d0.f56774a
            android.content.Context r3 = r20.getContext()
            int r6 = com.hbg.module.asset.R$string.n_trade_bot_share_num
            java.lang.String r3 = r3.getString(r6)
            java.lang.Object[] r6 = new java.lang.Object[r7]
            int r8 = r21.getCopyNum()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r6[r5] = r8
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r7)
            java.lang.String r3 = java.lang.String.format(r3, r6)
            r2.setText(r3)
            long r2 = r21.getRunTime()
            r6 = 1000(0x3e8, float:1.401E-42)
            long r8 = (long) r6
            long r2 = r2 / r8
            r8 = 60
            int r6 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r6 >= 0) goto L_0x01b6
            android.widget.TextView r0 = r1.f80862p
            android.content.Context r2 = r20.getContext()
            android.content.res.Resources r2 = r2.getResources()
            int r3 = com.hbg.module.asset.R$string.n_trade_bot_less_than_minute
            java.lang.String r2 = r2.getString(r3)
            r0.setText(r2)
            goto L_0x0250
        L_0x01b6:
            r8 = 3600(0xe10, double:1.7786E-320)
            int r6 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            r8 = 60
            if (r6 >= 0) goto L_0x01e0
            android.widget.TextView r0 = r1.f80862p
            android.content.Context r4 = r20.getContext()
            int r6 = com.hbg.module.asset.R$string.n_trade_bot_more_than_minute
            java.lang.String r4 = r4.getString(r6)
            java.lang.Object[] r6 = new java.lang.Object[r7]
            long r8 = (long) r8
            long r2 = r2 / r8
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r6[r5] = r2
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r6, r7)
            java.lang.String r2 = java.lang.String.format(r4, r2)
            r0.setText(r2)
            goto L_0x0250
        L_0x01e0:
            r9 = 86400(0x15180, double:4.26873E-319)
            int r6 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            r9 = 3600(0xe10, float:5.045E-42)
            if (r6 >= 0) goto L_0x0215
            android.widget.TextView r0 = r1.f80862p
            android.content.Context r6 = r20.getContext()
            int r10 = com.hbg.module.asset.R$string.n_trade_bot_more_than_hour
            java.lang.String r6 = r6.getString(r10)
            java.lang.Object[] r10 = new java.lang.Object[r4]
            long r11 = (long) r9
            long r11 = r2 / r11
            java.lang.String r9 = java.lang.String.valueOf(r11)
            r10[r5] = r9
            long r8 = (long) r8
            long r2 = r2 / r8
            long r2 = r2 % r8
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r10[r7] = r2
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r10, r4)
            java.lang.String r2 = java.lang.String.format(r6, r2)
            r0.setText(r2)
            goto L_0x0250
        L_0x0215:
            android.widget.TextView r6 = r1.f80862p
            android.content.Context r10 = r20.getContext()
            int r11 = com.hbg.module.asset.R$string.n_trade_bot_more_than_day
            java.lang.String r10 = r10.getString(r11)
            java.lang.Object[] r11 = new java.lang.Object[r0]
            r12 = 86400(0x15180, float:1.21072E-40)
            long r12 = (long) r12
            long r12 = r2 / r12
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r11[r5] = r12
            long r12 = (long) r9
            long r12 = r2 / r12
            r5 = 24
            long r14 = (long) r5
            long r12 = r12 % r14
            java.lang.String r5 = java.lang.String.valueOf(r12)
            r11[r7] = r5
            long r7 = (long) r8
            long r2 = r2 / r7
            long r2 = r2 % r7
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r11[r4] = r2
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r11, r0)
            java.lang.String r0 = java.lang.String.format(r10, r0)
            r6.setText(r0)
        L_0x0250:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.share.TradingBotShareView.setData(com.hbg.lib.network.hbg.grid.bean.GridStrategyInfo):void");
    }

    public final void setIvShareBaby(ImageView imageView) {
        this.f80851e = imageView;
    }

    public final void setShareView(View view) {
        this.f80865s = view;
    }

    public final void setTvBotType(TextView textView) {
        this.f80861o = textView;
    }

    public final void setTvCopyNum(TextView textView) {
        this.f80864r = textView;
    }

    public final void setTvName(TextView textView) {
        this.f80849c = textView;
    }

    public final void setTvPositionRateContainer(View view) {
        this.f80853g = view;
    }

    public final void setTvPositionRateNum(TextView textView) {
        this.f80854h = textView;
    }

    public final void setTvPositionRatePercent(TextView textView) {
        this.f80855i = textView;
    }

    public final void setTvPositionRateSign(TextView textView) {
        this.f80856j = textView;
    }

    public final void setTvPositionRateTitle(TextView textView) {
        this.f80852f = textView;
    }

    public final void setTvRunTime(TextView textView) {
        this.f80862p = textView;
    }

    public final void setTvShareCodeTitle(TextView textView) {
        this.f80859m = textView;
    }

    public final void setTvShareCodeValue(TextView textView) {
        this.f80860n = textView;
    }

    public final void setTvShareTime(TextView textView) {
        this.f80850d = textView;
    }

    public final void setTvSymbol(TextView textView) {
        this.f80863q = textView;
    }

    public final void setTvTotalProfitTitle(TextView textView) {
        this.f80857k = textView;
    }

    public final void setTvTotalProfitValue(TextView textView) {
        this.f80858l = textView;
    }
}
