package com.huobi.share.fragment;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.w;
import com.hbg.lib.network.hbg.core.bean.UserOtherInfoData;
import com.hbg.lib.network.newkyc.bean.AuthInfoNew;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.xiaomi.mipush.sdk.Constants;
import i6.m;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.x;
import kotlin.k;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import pro.huobi.R;
import tg.r;

public class ContractSimpleShareView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public final Activity f80919b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80920c = ((TextView) findViewById(R.id.tv_aurora));

    /* renamed from: d  reason: collision with root package name */
    public TextView f80921d = ((TextView) findViewById(R.id.tv_time));

    /* renamed from: e  reason: collision with root package name */
    public ImageView f80922e = ((ImageView) findViewById(R.id.iv_huobao));

    /* renamed from: f  reason: collision with root package name */
    public TextView f80923f = ((TextView) findViewById(R.id.tv_yield));

    /* renamed from: g  reason: collision with root package name */
    public View f80924g = findViewById(R.id.rl_yield_container);

    /* renamed from: h  reason: collision with root package name */
    public TextView f80925h = ((TextView) findViewById(R.id.tv_yield_num));

    /* renamed from: i  reason: collision with root package name */
    public TextView f80926i = ((TextView) findViewById(R.id.tv_yield_percent));

    /* renamed from: j  reason: collision with root package name */
    public TextView f80927j = ((TextView) findViewById(R.id.tv_yield_sign));

    /* renamed from: k  reason: collision with root package name */
    public TextView f80928k = ((TextView) findViewById(R.id.tv_code));

    /* renamed from: l  reason: collision with root package name */
    public TextView f80929l = ((TextView) findViewById(R.id.tv_level));

    /* renamed from: m  reason: collision with root package name */
    public TextView f80930m = ((TextView) findViewById(R.id.tv_price_open_value));

    /* renamed from: n  reason: collision with root package name */
    public TextView f80931n = ((TextView) findViewById(R.id.tv_price_cur_value));

    /* renamed from: o  reason: collision with root package name */
    public TextView f80932o = ((TextView) findViewById(R.id.tv_price_open_title));

    /* renamed from: p  reason: collision with root package name */
    public TextView f80933p = ((TextView) findViewById(R.id.tv_price_cur_title));

    /* renamed from: q  reason: collision with root package name */
    public View f80934q;

    public interface a {
        void a(ArrayList<Bitmap> arrayList);
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f80935a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.huobi.share.helper.CaptureShareHelper$ContractType[] r0 = com.huobi.share.helper.CaptureShareHelper.ContractType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.huobi.share.helper.CaptureShareHelper$ContractType r1 = com.huobi.share.helper.CaptureShareHelper.ContractType.Contract     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.huobi.share.helper.CaptureShareHelper$ContractType r1 = com.huobi.share.helper.CaptureShareHelper.ContractType.LinearSwap     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.huobi.share.helper.CaptureShareHelper$ContractType r1 = com.huobi.share.helper.CaptureShareHelper.ContractType.Swap     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f80935a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.share.fragment.ContractSimpleShareView.b.<clinit>():void");
        }
    }

    public ContractSimpleShareView(Activity activity) {
        super(activity);
        this.f80919b = activity;
        this.f80934q = View.inflate(activity, R.layout.layout_contract_share_view_new_simple, this);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String string = getContext().getString(R.string.n_contract_share_time_title);
        TextView textView = this.f80921d;
        d0 d0Var = d0.f56774a;
        textView.setText(String.format(string, Arrays.copyOf(new Object[]{format}, 1)));
        e();
    }

    public final void a(a aVar) {
        this.f80934q.measure(View.MeasureSpec.makeMeasureSpec(UIUtil.a(getContext(), 275.0d), 1073741824), View.MeasureSpec.makeMeasureSpec(UIUtil.a(getContext(), 800.0d), Integer.MIN_VALUE));
        View view = this.f80934q;
        view.layout(0, 0, view.getMeasuredWidth(), this.f80934q.getMeasuredHeight());
        Bitmap createBitmap = Bitmap.createBitmap(this.f80934q.getMeasuredWidth(), this.f80934q.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.f80934q.draw(new Canvas(createBitmap));
        ArrayList arrayList = new ArrayList();
        arrayList.add(createBitmap);
        aVar.a(arrayList);
    }

    public final String b(String str) {
        try {
            Result.a aVar = Result.Companion;
            str = m.q(m.a(str).multiply(new BigDecimal(100)), 2);
            Result.m3072constructorimpl(Unit.f56620a);
            return str;
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            Result.m3072constructorimpl(k.a(th2));
            return str;
        }
    }

    public final void c(String str, String str2, String str3, String str4, String str5, Boolean bool, Integer num) {
        String G;
        int i11;
        Resources resources;
        String str6 = str5;
        if (num != null && num.intValue() == 1) {
            this.f80932o.setText(R.string.n_contarct_share_position_open_price);
            this.f80933p.setText(R.string.n_exchange_order_list_trade_avg_price);
        } else if (num != null && num.intValue() == 2) {
            this.f80932o.setText(R.string.n_contract_share_history_position_open_price);
            this.f80933p.setText(R.string.n_contract_share_history_position_close_price);
            TextView textView = this.f80929l;
            if (x.b(bool, Boolean.TRUE)) {
                resources = getResources();
                i11 = w.h();
            } else {
                resources = getResources();
                i11 = w.d();
            }
            textView.setTextColor(resources.getColor(i11));
        }
        if (!TextUtils.isEmpty(str5)) {
            this.f80923f.setVisibility(0);
            this.f80924g.setVisibility(0);
            String str7 = null;
            if (StringsKt__StringsKt.R(str6, Constants.ACCEPT_TIME_SEPARATOR_SERVER, false, 2, (Object) null)) {
                this.f80927j.setText(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                this.f80927j.setTextColor(getResources().getColor(w.d()));
                this.f80925h.setTextColor(getResources().getColor(w.d()));
                this.f80926i.setTextColor(getResources().getColor(w.d()));
            } else if (StringsKt__StringsKt.R(str6, "+", false, 2, (Object) null)) {
                this.f80927j.setText("+");
                this.f80927j.setTextColor(getResources().getColor(w.h()));
                this.f80925h.setTextColor(getResources().getColor(w.h()));
                this.f80926i.setTextColor(getResources().getColor(w.h()));
            } else {
                this.f80927j.setText("");
                this.f80927j.setTextColor(getResources().getColor(R.color.white));
                this.f80925h.setTextColor(getResources().getColor(R.color.white));
                this.f80926i.setTextColor(getResources().getColor(R.color.white));
            }
            TextView textView2 = this.f80925h;
            String G2 = StringsKt__StringsJVMKt.G(str5, "+", "", false, 4, (Object) null);
            if (!(G2 == null || (G = StringsKt__StringsJVMKt.G(G2, Constants.ACCEPT_TIME_SEPARATOR_SERVER, "", false, 4, (Object) null)) == null)) {
                str7 = StringsKt__StringsJVMKt.G(G, "%", "", false, 4, (Object) null);
            }
            textView2.setText(str7);
        }
        this.f80930m.setText(str3);
        this.f80931n.setText(str4);
        this.f80928k.setText(str);
        this.f80929l.setText(str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ea, code lost:
        r4 = kotlin.text.StringsKt__StringsJVMKt.G((r11 = kotlin.text.StringsKt__StringsJVMKt.G(r5, "+", "", false, 4, (java.lang.Object) null)), com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "", false, 4, (java.lang.Object) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(com.huobi.contract.entity.ContractPosition r18, com.huobi.share.helper.CaptureShareHelper.ContractType r19) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            if (r2 != 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.String r0 = r2.profitRate
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r3 = 0
            if (r0 != 0) goto L_0x0118
            android.widget.TextView r0 = r1.f80923f
            r4 = 0
            r0.setVisibility(r4)
            android.view.View r0 = r1.f80924g
            r0.setVisibility(r4)
            kotlin.Result$a r0 = kotlin.Result.Companion     // Catch:{ all -> 0x010e }
            java.lang.String r0 = r2.profitRate     // Catch:{ all -> 0x010e }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ all -> 0x010e }
            r4 = 0
            int r5 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r5 >= 0) goto L_0x0063
            android.widget.TextView r0 = r1.f80927j     // Catch:{ all -> 0x010e }
            java.lang.String r4 = "-"
            r0.setText(r4)     // Catch:{ all -> 0x010e }
            android.widget.TextView r0 = r1.f80927j     // Catch:{ all -> 0x010e }
            android.content.res.Resources r4 = r17.getResources()     // Catch:{ all -> 0x010e }
            int r5 = com.hbg.lib.core.util.w.d()     // Catch:{ all -> 0x010e }
            int r4 = r4.getColor(r5)     // Catch:{ all -> 0x010e }
            r0.setTextColor(r4)     // Catch:{ all -> 0x010e }
            android.widget.TextView r0 = r1.f80925h     // Catch:{ all -> 0x010e }
            android.content.res.Resources r4 = r17.getResources()     // Catch:{ all -> 0x010e }
            int r5 = com.hbg.lib.core.util.w.d()     // Catch:{ all -> 0x010e }
            int r4 = r4.getColor(r5)     // Catch:{ all -> 0x010e }
            r0.setTextColor(r4)     // Catch:{ all -> 0x010e }
            android.widget.TextView r0 = r1.f80926i     // Catch:{ all -> 0x010e }
            android.content.res.Resources r4 = r17.getResources()     // Catch:{ all -> 0x010e }
            int r5 = com.hbg.lib.core.util.w.d()     // Catch:{ all -> 0x010e }
            int r4 = r4.getColor(r5)     // Catch:{ all -> 0x010e }
            r0.setTextColor(r4)     // Catch:{ all -> 0x010e }
            goto L_0x00d3
        L_0x0063:
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a2
            android.widget.TextView r0 = r1.f80927j     // Catch:{ all -> 0x010e }
            java.lang.String r4 = "+"
            r0.setText(r4)     // Catch:{ all -> 0x010e }
            android.widget.TextView r0 = r1.f80927j     // Catch:{ all -> 0x010e }
            android.content.res.Resources r4 = r17.getResources()     // Catch:{ all -> 0x010e }
            int r5 = com.hbg.lib.core.util.w.h()     // Catch:{ all -> 0x010e }
            int r4 = r4.getColor(r5)     // Catch:{ all -> 0x010e }
            r0.setTextColor(r4)     // Catch:{ all -> 0x010e }
            android.widget.TextView r0 = r1.f80925h     // Catch:{ all -> 0x010e }
            android.content.res.Resources r4 = r17.getResources()     // Catch:{ all -> 0x010e }
            int r5 = com.hbg.lib.core.util.w.h()     // Catch:{ all -> 0x010e }
            int r4 = r4.getColor(r5)     // Catch:{ all -> 0x010e }
            r0.setTextColor(r4)     // Catch:{ all -> 0x010e }
            android.widget.TextView r0 = r1.f80926i     // Catch:{ all -> 0x010e }
            android.content.res.Resources r4 = r17.getResources()     // Catch:{ all -> 0x010e }
            int r5 = com.hbg.lib.core.util.w.h()     // Catch:{ all -> 0x010e }
            int r4 = r4.getColor(r5)     // Catch:{ all -> 0x010e }
            r0.setTextColor(r4)     // Catch:{ all -> 0x010e }
            goto L_0x00d3
        L_0x00a2:
            android.widget.TextView r0 = r1.f80927j     // Catch:{ all -> 0x010e }
            java.lang.String r4 = ""
            r0.setText(r4)     // Catch:{ all -> 0x010e }
            android.widget.TextView r0 = r1.f80927j     // Catch:{ all -> 0x010e }
            android.content.res.Resources r4 = r17.getResources()     // Catch:{ all -> 0x010e }
            r5 = 2131102250(0x7f060a2a, float:1.7816933E38)
            int r4 = r4.getColor(r5)     // Catch:{ all -> 0x010e }
            r0.setTextColor(r4)     // Catch:{ all -> 0x010e }
            android.widget.TextView r0 = r1.f80925h     // Catch:{ all -> 0x010e }
            android.content.res.Resources r4 = r17.getResources()     // Catch:{ all -> 0x010e }
            int r4 = r4.getColor(r5)     // Catch:{ all -> 0x010e }
            r0.setTextColor(r4)     // Catch:{ all -> 0x010e }
            android.widget.TextView r0 = r1.f80926i     // Catch:{ all -> 0x010e }
            android.content.res.Resources r4 = r17.getResources()     // Catch:{ all -> 0x010e }
            int r4 = r4.getColor(r5)     // Catch:{ all -> 0x010e }
            r0.setTextColor(r4)     // Catch:{ all -> 0x010e }
        L_0x00d3:
            android.widget.TextView r0 = r1.f80925h     // Catch:{ all -> 0x010e }
            java.lang.String r4 = r2.profitRate     // Catch:{ all -> 0x010e }
            java.lang.String r5 = r1.b(r4)     // Catch:{ all -> 0x010e }
            if (r5 == 0) goto L_0x0104
            java.lang.String r6 = "+"
            java.lang.String r7 = ""
            r8 = 0
            r9 = 4
            r10 = 0
            java.lang.String r11 = kotlin.text.StringsKt__StringsJVMKt.G(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x010e }
            if (r11 == 0) goto L_0x0104
            java.lang.String r12 = "-"
            java.lang.String r13 = ""
            r14 = 0
            r15 = 4
            r16 = 0
            java.lang.String r4 = kotlin.text.StringsKt__StringsJVMKt.G(r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x010e }
            if (r4 == 0) goto L_0x0104
            java.lang.String r5 = "%"
            java.lang.String r6 = ""
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r4 = kotlin.text.StringsKt__StringsJVMKt.G(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x010e }
            goto L_0x0105
        L_0x0104:
            r4 = r3
        L_0x0105:
            r0.setText(r4)     // Catch:{ all -> 0x010e }
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x010e }
            kotlin.Result.m3072constructorimpl(r0)     // Catch:{ all -> 0x010e }
            goto L_0x0118
        L_0x010e:
            r0 = move-exception
            kotlin.Result$a r4 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.k.a(r0)
            kotlin.Result.m3072constructorimpl(r0)
        L_0x0118:
            android.widget.TextView r0 = r1.f80930m
            java.lang.String r4 = r2.costOpenDisplay
            r0.setText(r4)
            android.widget.TextView r0 = r1.f80931n
            java.lang.String r4 = r2.lastPriceDisplay
            r0.setText(r4)
            android.widget.TextView r0 = r1.f80932o
            r4 = 2132020560(0x7f140d50, float:1.9679487E38)
            r0.setText(r4)
            android.widget.TextView r0 = r1.f80933p
            r4 = 2132020559(0x7f140d4f, float:1.9679485E38)
            r0.setText(r4)
            if (r19 != 0) goto L_0x013a
            r0 = -1
            goto L_0x0142
        L_0x013a:
            int[] r0 = com.huobi.share.fragment.ContractSimpleShareView.b.f80935a
            int r4 = r19.ordinal()
            r0 = r0[r4]
        L_0x0142:
            r4 = 1
            r5 = 2
            if (r0 == r4) goto L_0x0170
            if (r0 == r5) goto L_0x015c
            r4 = 3
            if (r0 == r4) goto L_0x014c
            goto L_0x017d
        L_0x014c:
            android.widget.TextView r0 = r1.f80928k
            java.lang.String r4 = r2.symbol
            android.content.Context r5 = r17.getContext()
            java.lang.String r4 = us.j.h(r4, r5)
            r0.setText(r4)
            goto L_0x017d
        L_0x015c:
            android.widget.TextView r0 = r1.f80928k
            android.content.Context r4 = r17.getContext()
            java.lang.String r5 = r2.symbol
            java.lang.String r6 = r2.quoteCurrency
            java.lang.String r7 = r2.contractType
            java.lang.String r4 = a7.e.t(r4, r5, r6, r7)
            r0.setText(r4)
            goto L_0x017d
        L_0x0170:
            android.widget.TextView r0 = r1.f80928k
            java.lang.String r4 = r2.contractShortType
            java.lang.String r6 = r2.contractCode
            java.lang.String r4 = ej.g.h(r4, r6, r5)
            r0.setText(r4)
        L_0x017d:
            java.lang.String r0 = r2.marginMode
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01af
            java.lang.String r0 = r2.marginMode
            java.lang.String r3 = "cross"
            boolean r0 = kotlin.jvm.internal.x.b(r0, r3)
            if (r0 == 0) goto L_0x019f
            android.content.Context r0 = r17.getContext()
            android.content.res.Resources r0 = r0.getResources()
            r3 = 2132021049(0x7f140f39, float:1.9680478E38)
            java.lang.String r0 = r0.getString(r3)
            goto L_0x01ae
        L_0x019f:
            android.content.Context r0 = r17.getContext()
            android.content.res.Resources r0 = r0.getResources()
            r3 = 2132021119(0x7f140f7f, float:1.968062E38)
            java.lang.String r0 = r0.getString(r3)
        L_0x01ae:
            r3 = r0
        L_0x01af:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r5 = "·"
            if (r4 != 0) goto L_0x01c2
            r0.append(r3)
            r0.append(r5)
        L_0x01c2:
            java.lang.String r3 = r2.direction
            java.lang.String r4 = "sell"
            boolean r3 = kotlin.jvm.internal.x.b(r3, r4)
            if (r3 == 0) goto L_0x01db
            android.content.Context r3 = r17.getContext()
            r4 = 2132018169(0x7f1403f9, float:1.9674637E38)
            java.lang.String r3 = r3.getString(r4)
            r0.append(r3)
            goto L_0x01e9
        L_0x01db:
            android.content.Context r3 = r17.getContext()
            r4 = 2132018170(0x7f1403fa, float:1.967464E38)
            java.lang.String r3 = r3.getString(r4)
            r0.append(r3)
        L_0x01e9:
            r0.append(r5)
            java.lang.String r2 = r2.leverRate
            r0.append(r2)
            java.lang.String r2 = "X"
            r0.append(r2)
            android.widget.TextView r2 = r1.f80929l
            java.lang.String r0 = r0.toString()
            r2.setText(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.share.fragment.ContractSimpleShareView.d(com.huobi.contract.entity.ContractPosition, com.huobi.share.helper.CaptureShareHelper$ContractType):void");
    }

    public final void e() {
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
                UserOtherInfoData L = r.x().L();
                if (sd.a.c(L != null ? L.getNick_name() : null)) {
                    if (sd.a.c(L != null ? L.getPhone() : null)) {
                        if (!sd.a.c(L != null ? L.getEmail() : null)) {
                            if (L != null) {
                                str = L.getEmail();
                            }
                        } else if (a11 != null) {
                            str = a11.i();
                        }
                    } else if (L != null) {
                        str = L.getPhone();
                    }
                } else if (L != null) {
                    str = L.getNick_name();
                }
            } else if (!(q11 == null || (auth_info = q11.getAuth_info()) == null)) {
                str = auth_info.getPro_org_name();
            }
        } else if (a11 != null) {
            str = a11.i();
        }
        if (!TextUtils.isEmpty(str)) {
            this.f80920c.setText(str);
        }
    }

    public final Activity getActivity() {
        return this.f80919b;
    }

    public final ImageView getIvShareBaby() {
        return this.f80922e;
    }

    public final View getShareView() {
        return this.f80934q;
    }

    public final TextView getTvAvgPrice() {
        return this.f80930m;
    }

    public final TextView getTvLatestPrice() {
        return this.f80931n;
    }

    public final TextView getTvName() {
        return this.f80920c;
    }

    public final View getTvPositionRateContainer() {
        return this.f80924g;
    }

    public final TextView getTvPositionRateNum() {
        return this.f80925h;
    }

    public final TextView getTvPositionRatePercent() {
        return this.f80926i;
    }

    public final TextView getTvPositionRateSign() {
        return this.f80927j;
    }

    public final TextView getTvPositionRateTitle() {
        return this.f80923f;
    }

    public final TextView getTvPositionTitle() {
        return this.f80928k;
    }

    public final TextView getTvPositionType() {
        return this.f80929l;
    }

    public final TextView getTvPriceCurTitle() {
        return this.f80933p;
    }

    public final TextView getTvPriceOpenTitle() {
        return this.f80932o;
    }

    public final TextView getTvShareTime() {
        return this.f80921d;
    }

    public final void setIvShareBaby(ImageView imageView) {
        this.f80922e = imageView;
    }

    public final void setShareView(View view) {
        this.f80934q = view;
    }

    public final void setTvAvgPrice(TextView textView) {
        this.f80930m = textView;
    }

    public final void setTvLatestPrice(TextView textView) {
        this.f80931n = textView;
    }

    public final void setTvName(TextView textView) {
        this.f80920c = textView;
    }

    public final void setTvPositionRateContainer(View view) {
        this.f80924g = view;
    }

    public final void setTvPositionRateNum(TextView textView) {
        this.f80925h = textView;
    }

    public final void setTvPositionRatePercent(TextView textView) {
        this.f80926i = textView;
    }

    public final void setTvPositionRateSign(TextView textView) {
        this.f80927j = textView;
    }

    public final void setTvPositionRateTitle(TextView textView) {
        this.f80923f = textView;
    }

    public final void setTvPositionTitle(TextView textView) {
        this.f80928k = textView;
    }

    public final void setTvPositionType(TextView textView) {
        this.f80929l = textView;
    }

    public final void setTvPriceCurTitle(TextView textView) {
        this.f80933p = textView;
    }

    public final void setTvPriceOpenTitle(TextView textView) {
        this.f80932o = textView;
    }

    public final void setTvShareTime(TextView textView) {
        this.f80921d = textView;
    }
}
