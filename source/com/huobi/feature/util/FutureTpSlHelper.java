package com.huobi.feature.util;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.badge.BadgeDrawable;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.hbg.lib.widgets.dialog.CommonListPopupDialog;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.bean.CommonPopListItem;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.entity.PriceType;
import com.huobi.contract.ui.ContractGearsTradePriceEditText;
import com.huobi.feature.bean.OnAmountChangeData;
import com.huobi.feature.util.FutureTpSlFuturesHelper;
import com.huobi.view.TradePriceEditext;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import com.huobi.view.keyboard.SystemKeyBoardHelper;
import com.huobi.view.seekbar.MultiColorSeekBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dj.k4;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import qk.a0;
import qk.b0;
import qk.c0;
import qk.d0;
import qk.e0;
import qk.f0;
import qk.g0;
import qk.h0;
import qk.i0;
import qk.j0;
import qk.k0;
import qk.l0;
import qk.u;
import qk.v;
import qk.w;
import qk.x;
import qk.y;
import qk.z;
import rx.Observable;

public class FutureTpSlHelper {

    /* renamed from: m0  reason: collision with root package name */
    public static final Handler f45109m0 = new Handler(Looper.getMainLooper());
    public TextView A;
    public TradePriceEditext B;
    public EditText C;
    public ViewGroup D;
    public ViewGroup E;
    public TextView F;
    public boolean G = true;
    public boolean H = true;
    public final List<CommonPopListItem> I = new ArrayList();
    public final List<CommonPopListItem> J = new ArrayList();
    public final CommonListPopupDialog K = new CommonListPopupDialog();
    public final CommonListPopupDialog L = new CommonListPopupDialog();
    public final CommonListPopupDialog M = new CommonListPopupDialog();
    public final CommonListPopupDialog N = new CommonListPopupDialog();
    public int O = 0;
    public int P = 0;
    public final CommonListPopupDialog Q = new CommonListPopupDialog();
    public final CommonListPopupDialog R = new CommonListPopupDialog();
    public int S = 0;
    public int T = 10;
    public String U;
    public String V;
    public boolean W;
    public final CommonListPopupDialog X = new CommonListPopupDialog();
    public int Y;
    public int Z = 0;

    /* renamed from: a  reason: collision with root package name */
    public Context f45110a;

    /* renamed from: a0  reason: collision with root package name */
    public int f45111a0 = 99;

    /* renamed from: b  reason: collision with root package name */
    public i f45112b;

    /* renamed from: b0  reason: collision with root package name */
    public j f45113b0;

    /* renamed from: c  reason: collision with root package name */
    public TradeType f45114c;

    /* renamed from: c0  reason: collision with root package name */
    public int f45115c0 = 8;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f45116d;

    /* renamed from: d0  reason: collision with root package name */
    public int f45117d0 = 8;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f45118e;

    /* renamed from: e0  reason: collision with root package name */
    public HuobiKeyboardHelper f45119e0;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f45120f;

    /* renamed from: f0  reason: collision with root package name */
    public boolean f45121f0 = true;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f45122g;

    /* renamed from: g0  reason: collision with root package name */
    public boolean f45123g0 = false;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f45124h;

    /* renamed from: h0  reason: collision with root package name */
    public TextView f45125h0;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f45126i;

    /* renamed from: i0  reason: collision with root package name */
    public TextView f45127i0;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f45128j;

    /* renamed from: j0  reason: collision with root package name */
    public BigDecimal f45129j0 = BigDecimal.ZERO;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f45130k;

    /* renamed from: k0  reason: collision with root package name */
    public final OnAmountChangeData f45131k0 = new OnAmountChangeData();

    /* renamed from: l  reason: collision with root package name */
    public LinearLayout f45132l;

    /* renamed from: l0  reason: collision with root package name */
    public final Runnable f45133l0 = new d();

    /* renamed from: m  reason: collision with root package name */
    public TextView f45134m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f45135n;

    /* renamed from: o  reason: collision with root package name */
    public MultiColorSeekBar f45136o;

    /* renamed from: p  reason: collision with root package name */
    public ViewGroup f45137p;

    /* renamed from: q  reason: collision with root package name */
    public ViewGroup f45138q;

    /* renamed from: r  reason: collision with root package name */
    public TradePriceEditext f45139r;

    /* renamed from: s  reason: collision with root package name */
    public TradePriceEditext f45140s;

    /* renamed from: t  reason: collision with root package name */
    public ContractGearsTradePriceEditText f45141t;

    /* renamed from: u  reason: collision with root package name */
    public ContractGearsTradePriceEditText f45142u;

    /* renamed from: v  reason: collision with root package name */
    public EditText f45143v;

    /* renamed from: w  reason: collision with root package name */
    public EditText f45144w;

    /* renamed from: x  reason: collision with root package name */
    public EditText f45145x;

    /* renamed from: y  reason: collision with root package name */
    public EditText f45146y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f45147z;

    public class a implements k4 {
        public a() {
        }

        public void onFocusChange(View view, boolean z11) {
            FutureTpSlHelper.this.B.setBackgroundResource(z11 ? R.drawable.custom_edittext_blue_focused_bg : R.drawable.custom_edittext_normal_bg);
            if (FutureTpSlHelper.this.C.isFocused()) {
                boolean unused = FutureTpSlHelper.this.r1(0);
            }
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
            if (FutureTpSlHelper.this.f45112b.getActivity() != null) {
                if (editable.length() == 0) {
                    FutureTpSlHelper.this.C.setTypeface(ResourcesCompat.h(FutureTpSlHelper.this.C.getContext(), R.font.roboto_regular));
                } else {
                    FutureTpSlHelper.this.C.setTypeface(ResourcesCompat.h(FutureTpSlHelper.this.C.getContext(), R.font.roboto_medium));
                }
                if (FutureTpSlHelper.this.V0() && !FutureTpSlHelper.this.f45112b.b(FutureTpSlHelper.this.C, editable)) {
                    FutureTpSlHelper.this.p1(true, editable, 0);
                }
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class c implements MultiColorSeekBar.OnProgressChangedListener {
        public c() {
        }

        public void getProgressOnActionUp(MultiColorSeekBar multiColorSeekBar, int i11, float f11) {
        }

        public void getProgressOnFinally(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
        }

        public void onProgressChanged(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
            if (z11) {
                FutureTpSlHelper.this.t1(i11);
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            boolean c11 = FutureTpSlHelper.this.f45131k0.c();
            Editable a11 = FutureTpSlHelper.this.f45131k0.a();
            int b11 = FutureTpSlHelper.this.f45131k0.b();
            boolean z11 = false;
            if (c11) {
                if (FutureTpSlHelper.this.U0()) {
                    b11 = (TextUtils.isEmpty(a11) || !i6.m.Z(a11.toString())) ? 0 : Integer.parseInt(a11.toString());
                    if (b11 <= 100) {
                        FutureTpSlHelper.this.E1((float) b11);
                    }
                    z11 = true;
                }
                FutureTpSlFuturesHelper.a e11 = FutureTpSlHelper.this.f45112b.e(b11, a11.toString(), z11);
                FutureTpSlHelper.this.B1(e11.f45107b);
                FutureTpSlHelper.this.x1(e11.a());
                FutureTpSlHelper.this.G1();
                return;
            }
            FutureTpSlFuturesHelper.a e12 = FutureTpSlHelper.this.f45112b.e(b11, (String) null, true);
            FutureTpSlHelper.this.B1(e12.f45107b);
            if (FutureTpSlHelper.this.U0()) {
                FutureTpSlHelper.this.C.setText(AppUtil.b(Integer.valueOf(b11)));
            } else {
                FutureTpSlHelper.this.C.setText(e12.f45106a);
            }
            FutureTpSlHelper.this.x1(e12.a());
            FutureTpSlHelper.this.G1();
        }
    }

    public class e implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f45152b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ EditText f45153c;

        public e(int i11, EditText editText) {
            this.f45152b = i11;
            this.f45153c = editText;
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x0110  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0116  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void afterTextChanged(android.text.Editable r7) {
            /*
                r6 = this;
                com.huobi.feature.util.FutureTpSlHelper r0 = com.huobi.feature.util.FutureTpSlHelper.this
                com.huobi.feature.util.FutureTpSlHelper$i r0 = r0.f45112b
                android.app.Activity r0 = r0.getActivity()
                if (r0 == 0) goto L_0x0122
                int r0 = r6.f45152b
                if (r0 != 0) goto L_0x0017
                com.huobi.feature.util.FutureTpSlHelper r0 = com.huobi.feature.util.FutureTpSlHelper.this
                int r0 = r0.S
                goto L_0x001d
            L_0x0017:
                com.huobi.feature.util.FutureTpSlHelper r0 = com.huobi.feature.util.FutureTpSlHelper.this
                int r0 = r0.T
            L_0x001d:
                java.lang.String r1 = ""
                if (r0 == 0) goto L_0x00fb
                java.lang.String r2 = "-"
                r3 = 1
                if (r0 == r3) goto L_0x00b9
                r4 = 2
                if (r0 == r4) goto L_0x007b
                r4 = 3
                if (r0 == r4) goto L_0x0031
                switch(r0) {
                    case 10: goto L_0x00fb;
                    case 11: goto L_0x00b9;
                    case 12: goto L_0x007b;
                    case 13: goto L_0x0031;
                    default: goto L_0x002f;
                }
            L_0x002f:
                goto L_0x010c
            L_0x0031:
                com.huobi.feature.util.FutureTpSlHelper r0 = com.huobi.feature.util.FutureTpSlHelper.this
                int r4 = r6.f45152b
                android.widget.EditText r5 = r6.f45153c
                r0.Y(r4, r5, r7)
                int r0 = r6.f45152b
                if (r0 != r3) goto L_0x004f
                int r0 = r7.length()
                if (r0 == 0) goto L_0x004f
                java.lang.String r0 = r7.toString()
                boolean r0 = r0.startsWith(r2)
                if (r0 != 0) goto L_0x004f
                return
            L_0x004f:
                java.lang.String r0 = r7.toString()
                boolean r0 = com.hbg.lib.common.utils.StringUtils.p(r0)
                if (r0 == 0) goto L_0x005b
                goto L_0x010c
            L_0x005b:
                com.huobi.feature.util.FutureTpSlHelper r0 = com.huobi.feature.util.FutureTpSlHelper.this
                com.huobi.feature.util.FutureTpSlHelper$i r0 = r0.f45112b
                java.lang.String r7 = r7.toString()
                int r1 = r6.f45152b
                if (r1 != 0) goto L_0x006a
                goto L_0x006b
            L_0x006a:
                r3 = 0
            L_0x006b:
                com.huobi.feature.util.FutureTpSlHelper r1 = com.huobi.feature.util.FutureTpSlHelper.this
                java.math.BigDecimal r1 = r1.s0()
                java.math.BigDecimal r7 = r0.g(r7, r3, r1)
                java.lang.String r1 = r7.toPlainString()
                goto L_0x010c
            L_0x007b:
                com.huobi.feature.util.FutureTpSlHelper r0 = com.huobi.feature.util.FutureTpSlHelper.this
                int r4 = r6.f45152b
                android.widget.EditText r5 = r6.f45153c
                r0.a0(r4, r5, r7)
                int r0 = r6.f45152b
                if (r0 != r3) goto L_0x0099
                int r0 = r7.length()
                if (r0 == 0) goto L_0x0099
                java.lang.String r0 = r7.toString()
                boolean r0 = r0.startsWith(r2)
                if (r0 != 0) goto L_0x0099
                return
            L_0x0099:
                java.lang.String r0 = r7.toString()
                boolean r0 = com.hbg.lib.common.utils.StringUtils.p(r0)
                if (r0 == 0) goto L_0x00a4
                goto L_0x010c
            L_0x00a4:
                com.huobi.feature.util.FutureTpSlHelper r0 = com.huobi.feature.util.FutureTpSlHelper.this
                com.huobi.feature.util.FutureTpSlHelper$i r0 = r0.f45112b
                java.lang.String r7 = r7.toString()
                int r1 = r6.f45152b
                java.math.BigDecimal r7 = r0.c(r7, r1)
                java.lang.String r1 = r7.toPlainString()
                goto L_0x010c
            L_0x00b9:
                com.huobi.feature.util.FutureTpSlHelper r0 = com.huobi.feature.util.FutureTpSlHelper.this
                int r4 = r6.f45152b
                android.widget.EditText r5 = r6.f45153c
                r0.a0(r4, r5, r7)
                int r0 = r6.f45152b
                if (r0 != r3) goto L_0x00d7
                int r0 = r7.length()
                if (r0 == 0) goto L_0x00d7
                java.lang.String r0 = r7.toString()
                boolean r0 = r0.startsWith(r2)
                if (r0 != 0) goto L_0x00d7
                return
            L_0x00d7:
                java.lang.String r0 = r7.toString()
                boolean r0 = com.hbg.lib.common.utils.StringUtils.p(r0)
                if (r0 == 0) goto L_0x00e2
                goto L_0x010c
            L_0x00e2:
                com.huobi.feature.util.FutureTpSlHelper r0 = com.huobi.feature.util.FutureTpSlHelper.this
                com.huobi.feature.util.FutureTpSlHelper$i r0 = r0.f45112b
                java.lang.String r7 = r7.toString()
                int r1 = r6.f45152b
                java.lang.String r7 = r0.h(r7, r1)
                java.math.BigDecimal r7 = i6.m.a(r7)
                java.lang.String r1 = r7.toPlainString()
                goto L_0x010c
            L_0x00fb:
                com.huobi.feature.util.FutureTpSlHelper r0 = com.huobi.feature.util.FutureTpSlHelper.this
                android.widget.EditText r1 = r6.f45153c
                r0.Z(r1, r7)
                android.widget.EditText r7 = r6.f45153c
                android.text.Editable r7 = r7.getText()
                java.lang.String r1 = r7.toString()
            L_0x010c:
                int r7 = r6.f45152b
                if (r7 != 0) goto L_0x0116
                com.huobi.feature.util.FutureTpSlHelper r7 = com.huobi.feature.util.FutureTpSlHelper.this
                java.lang.String unused = r7.U = r1
                goto L_0x011b
            L_0x0116:
                com.huobi.feature.util.FutureTpSlHelper r7 = com.huobi.feature.util.FutureTpSlHelper.this
                java.lang.String unused = r7.V = r1
            L_0x011b:
                com.huobi.feature.util.FutureTpSlHelper r7 = com.huobi.feature.util.FutureTpSlHelper.this
                int r0 = r6.f45152b
                r7.H1(r0)
            L_0x0122:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.feature.util.FutureTpSlHelper.e.afterTextChanged(android.text.Editable):void");
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class f implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EditText f45155b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f45156c;

        public f(EditText editText, int i11) {
            this.f45155b = editText;
            this.f45156c = i11;
        }

        public void afterTextChanged(Editable editable) {
            if (FutureTpSlHelper.this.f45112b.getActivity() != null) {
                FutureTpSlHelper.this.X(this.f45155b, editable, false);
                FutureTpSlHelper.this.H1(this.f45156c);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class g implements ContractGearsTradePriceEditText.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f45158a;

        public g(int i11) {
            this.f45158a = i11;
        }

        public void a() {
            FutureTpSlHelper.this.D1(1, this.f45158a);
        }

        public void b() {
            FutureTpSlHelper.this.D1(1, this.f45158a);
        }
    }

    public class h implements CommonPopListItem.a {

        /* renamed from: b  reason: collision with root package name */
        public final TextView f45160b;

        /* renamed from: c  reason: collision with root package name */
        public final CommonListPopupDialog f45161c;

        public h(CommonListPopupDialog commonListPopupDialog, TextView textView) {
            this.f45161c = commonListPopupDialog;
            this.f45160b = textView;
        }

        public void V6(CommonPopListItem commonPopListItem) {
            this.f45160b.setText(commonPopListItem.getText());
            this.f45161c.dismiss();
            FutureTpSlHelper.this.q1(commonPopListItem.getType());
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return commonPopListItem.getType() == FutureTpSlHelper.this.f45111a0;
        }
    }

    public interface i {
        String E0();

        void a();

        boolean b(EditText editText, Editable editable);

        BigDecimal c(String str, int i11);

        String d(String str, boolean z11, BigDecimal bigDecimal);

        FutureTpSlFuturesHelper.a e(int i11, String str, boolean z11);

        String f();

        BigDecimal g(String str, boolean z11, BigDecimal bigDecimal);

        Activity getActivity();

        String getQuoteCurrency();

        int getTradePricePrecision();

        String h(String str, int i11);

        String o0();
    }

    public interface j {
        void a(int i11, int i12);
    }

    public class k implements CommonPopListItem.a {

        /* renamed from: b  reason: collision with root package name */
        public final TextView f45163b;

        /* renamed from: c  reason: collision with root package name */
        public final CommonListPopupDialog f45164c;

        public k(CommonListPopupDialog commonListPopupDialog, TextView textView) {
            this.f45164c = commonListPopupDialog;
            this.f45163b = textView;
        }

        public void V6(CommonPopListItem commonPopListItem) {
            this.f45163b.setText(commonPopListItem.getText());
            this.f45164c.dismiss();
            if (this.f45164c == FutureTpSlHelper.this.M) {
                int unused = FutureTpSlHelper.this.O = commonPopListItem.getType();
            } else {
                int unused2 = FutureTpSlHelper.this.P = commonPopListItem.getType();
            }
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            if (this.f45164c == FutureTpSlHelper.this.M) {
                if (commonPopListItem.getType() == FutureTpSlHelper.this.O) {
                    return true;
                }
                return false;
            } else if (commonPopListItem.getType() == FutureTpSlHelper.this.P) {
                return true;
            } else {
                return false;
            }
        }
    }

    public interface l {
        void onProgress(int i11);
    }

    public class m implements CommonPopListItem.a {

        /* renamed from: b  reason: collision with root package name */
        public final int f45166b;

        public m(int i11) {
            this.f45166b = i11;
        }

        public void V6(CommonPopListItem commonPopListItem) {
            int type = commonPopListItem.getType();
            if (type == 5 || type == 4 || type == 3) {
                FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
                new DialogUtils.b.d(fragmentActivity).c1(FutureTpSlHelper.this.o0().getString(R.string.n_spot_order_risk)).C0(FutureTpSlHelper.this.o0().getString(R.string.n_contract_trade_bbo_tips)).q0(false).P0(FutureTpSlHelper.this.o0().getString(R.string.n_known)).Q0(cn.n.f13170a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
            }
            if (FutureTpSlHelper.this.f45113b0 != null) {
                FutureTpSlHelper.this.f45113b0.a(commonPopListItem.getType(), this.f45166b);
                if (this.f45166b == 0) {
                    FutureTpSlHelper.this.K.dismiss();
                } else {
                    FutureTpSlHelper.this.L.dismiss();
                }
            }
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            if (this.f45166b == 0 && commonPopListItem.getType() == FutureTpSlHelper.this.f45115c0) {
                return true;
            }
            if (this.f45166b == 1 && commonPopListItem.getType() == FutureTpSlHelper.this.f45117d0) {
                return true;
            }
            return false;
        }
    }

    public class n implements CommonPopListItem.a {

        /* renamed from: b  reason: collision with root package name */
        public final TradePriceEditext f45168b;

        /* renamed from: c  reason: collision with root package name */
        public final CommonListPopupDialog f45169c;

        /* renamed from: d  reason: collision with root package name */
        public final ViewGroup f45170d;

        public n(CommonListPopupDialog commonListPopupDialog, TradePriceEditext tradePriceEditext, ViewGroup viewGroup) {
            this.f45169c = commonListPopupDialog;
            this.f45168b = tradePriceEditext;
            this.f45170d = viewGroup;
        }

        public void V6(CommonPopListItem commonPopListItem) {
            this.f45169c.dismiss();
            int type = commonPopListItem.getType();
            if (type <= 3) {
                int unused = FutureTpSlHelper.this.S = commonPopListItem.getType();
            } else {
                int unused2 = FutureTpSlHelper.this.T = commonPopListItem.getType();
            }
            FutureTpSlHelper.this.w1(type, this.f45168b, this.f45170d);
            this.f45168b.getEditText().setText("");
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            int type = commonPopListItem.getType();
            if (type <= 3) {
                if (FutureTpSlHelper.this.S == type) {
                    return true;
                }
                return false;
            } else if (FutureTpSlHelper.this.T == type) {
                return true;
            } else {
                return false;
            }
        }
    }

    public FutureTpSlHelper() {
    }

    public static void H0(ViewGroup viewGroup) {
        ViewUtil.m(viewGroup.findViewById(R.id.ctlStopProfit), false);
        ViewUtil.m(viewGroup.findViewById(R.id.ctlStopLoss), false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y0(View view, FragmentManager fragmentManager) {
        if (this.Y == 0) {
            this.Y = view.getWidth();
        }
        this.X.showAsDropDown(fragmentManager, view, this.Y, 0, 0, (int) BadgeDrawable.BOTTOM_END);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z0(View view, FragmentManager fragmentManager, Void voidR) {
        this.f45112b.a();
        view.postDelayed(new l0(this, view, fragmentManager), 300);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void a1(View view) {
        j0(0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void b1(View view) {
        j0(1);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void c1(TradePriceEditext tradePriceEditext, View view, boolean z11) {
        tradePriceEditext.setBackgroundResource(z11 ? R.drawable.custom_edittext_blue_focused_bg : R.drawable.custom_edittext_normal_bg);
    }

    public static /* synthetic */ void d1(ContractGearsTradePriceEditText contractGearsTradePriceEditText, EditText editText, View view, boolean z11) {
        contractGearsTradePriceEditText.setBackgroundResource(z11 ? R.drawable.custom_edittext_blue_focused_bg : R.drawable.custom_edittext_normal_bg);
        if (z11) {
            editText.requestFocus();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void e1(ContractGearsTradePriceEditText contractGearsTradePriceEditText, View view) {
        if (contractGearsTradePriceEditText.k() && this.f45119e0.isKeyboardShowing()) {
            this.f45112b.a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f1(FragmentManager fragmentManager) {
        this.K.showAsDropDown(fragmentManager, this.f45130k);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g1(FragmentManager fragmentManager, View view) {
        this.f45112b.a();
        this.f45130k.postDelayed(new v(this, fragmentManager), 300);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h1(FragmentManager fragmentManager) {
        this.L.showAsDropDown(fragmentManager, this.f45132l);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i1(FragmentManager fragmentManager, View view) {
        this.f45112b.a();
        this.f45132l.postDelayed(new w(this, fragmentManager), 300);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k1(View view, CommonListPopupDialog commonListPopupDialog, FragmentManager fragmentManager, Void voidR) {
        this.f45112b.a();
        view.postDelayed(new k0(commonListPopupDialog, fragmentManager, view), 300);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l1(FragmentManager fragmentManager, View view) {
        this.N.showAsDropDown(fragmentManager, view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m1(View view, FragmentManager fragmentManager, Void voidR) {
        this.f45112b.a();
        view.postDelayed(new y(this, fragmentManager, view), 300);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n1(FragmentManager fragmentManager, View view) {
        this.M.showAsDropDown(fragmentManager, view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o1(View view, FragmentManager fragmentManager, Void voidR) {
        this.f45112b.a();
        view.postDelayed(new x(this, fragmentManager, view), 300);
    }

    public final String A0(int i11) {
        return this.f45110a.getResources().getString(i11);
    }

    public void A1(int i11, ContractOrderPlace contractOrderPlace) {
        CharSequence charSequence;
        if (i11 == 0) {
            charSequence = this.f45141t.getCurrentPriceTypeText();
        } else {
            charSequence = this.f45142u.getCurrentPriceTypeText();
        }
        contractOrderPlace.x0(charSequence);
    }

    public final String B0() {
        if (this.f45114c == TradeType.LINEAR_SWAP) {
            return this.f45112b.getQuoteCurrency();
        }
        return this.f45112b.o0();
    }

    public void B1(BigDecimal bigDecimal) {
        this.f45129j0 = bigDecimal.multiply(BigDecimal.valueOf(100));
    }

    public int C0(int i11) {
        return i11 == 0 ? this.S : this.T;
    }

    public void C1() {
        this.W = true;
        this.f45137p.setVisibility(8);
        this.f45138q.setVisibility(8);
        this.f45136o.setProgress(100.0f);
        t1(100);
        this.f45136o.setVisibility(8);
        this.D.setVisibility(8);
    }

    public String D0(int i11) {
        if (i11 == 0) {
            return this.f45145x.getText().toString();
        }
        return this.f45146y.getText().toString();
    }

    public final void D1(int i11, int i12) {
        String str;
        this.f45112b.a();
        h0();
        if (i11 == 8) {
            str = A0(R.string.n_exchange_order_list_market);
        } else if (i11 == 3) {
            str = A0(R.string.n_contract_trade_optimal_five);
        } else if (i11 == 4) {
            str = A0(R.string.n_contract_trade_optimal_ten);
        } else if (i11 == 5) {
            str = A0(R.string.n_contract_trade_optimal_twenty);
        } else {
            str = A0(R.string.n_exchange_order_list_limit);
        }
        if (i12 == 0) {
            this.f45141t.setPriceInputType(i11);
            this.f45115c0 = i11;
            this.f45134m.setText(str);
        } else {
            this.f45142u.setPriceInputType(i11);
            this.f45117d0 = i11;
            this.f45135n.setText(str);
        }
        if (i11 == 1) {
            if (i12 == 0) {
                this.f45141t.setLabel(this.f45112b.getQuoteCurrency());
                this.f45143v.setText("");
                this.f45143v.setEnabled(true);
                this.f45143v.requestFocus();
            } else {
                this.f45142u.setLabel(this.f45112b.getQuoteCurrency());
                this.f45144w.setText("");
                this.f45144w.setEnabled(true);
                this.f45144w.requestFocus();
            }
        } else if (i12 == 0) {
            this.f45141t.setBackgroundResource(R.drawable.gray_edit_bg);
            this.f45141t.setLabel("");
            this.f45141t.setIconImgVisible(false);
            this.f45141t.o(true);
            this.f45143v.setText("");
            this.f45143v.setEnabled(false);
            this.f45143v.setVisibility(0);
        } else {
            this.f45142u.setBackgroundResource(R.drawable.gray_edit_bg);
            this.f45142u.setLabel("");
            this.f45142u.setIconImgVisible(false);
            this.f45142u.o(true);
            this.f45144w.setText("");
            this.f45144w.setEnabled(false);
            this.f45144w.setVisibility(0);
        }
        H1(i12);
    }

    public String E0(int i11) {
        return i11 == 0 ? this.U : this.V;
    }

    public void E1(float f11) {
        this.f45136o.setProgress(f11);
    }

    public String F0(int i11) {
        if (i11 == 0) {
            return this.f45143v.getText().toString();
        }
        return this.f45144w.getText().toString();
    }

    public void F1(int i11, ContractOrderPlace contractOrderPlace) {
        contractOrderPlace.Z0(i11 == 0 ? this.U : this.V);
    }

    public void G0(ViewGroup viewGroup) {
        viewGroup.removeView(this.D);
        viewGroup.removeView(this.f45136o);
    }

    public final void G1() {
        if (q0()) {
            H1(0);
        }
        if (p0()) {
            H1(1);
        }
    }

    public void H1(int i11) {
        String str;
        String str2;
        String str3;
        String str4;
        try {
            BigDecimal s02 = s0();
            if (i11 == 0) {
                if (!TextUtils.isEmpty(this.U)) {
                    if (this.f45141t.getTradePriceType() == 1) {
                        str4 = this.f45143v.getText().toString();
                        str3 = A0(R.string.n_contract_dialog_tpsl_limit_tips);
                    } else if (this.f45141t.getTradePriceType() == 3) {
                        str4 = this.U;
                        str3 = A0(R.string.n_contract_tpsl_optimal_five_tips);
                    } else if (this.f45141t.getTradePriceType() == 4) {
                        str4 = this.U;
                        str3 = A0(R.string.n_contract_tpsl_optimal_ten_tips);
                    } else if (this.f45141t.getTradePriceType() == 5) {
                        String str5 = this.U;
                        str3 = A0(R.string.n_contract_tpsl_optimal_twenty_tips);
                        str4 = str5;
                    } else {
                        str4 = this.U;
                        str3 = A0(R.string.n_contract_dialog_tpsl_market_tips);
                    }
                    String d11 = this.f45112b.d(str4, true, s02);
                    String str6 = this.U + " " + this.f45112b.getQuoteCurrency();
                    String str7 = d11 + " " + B0();
                    String format = String.format(str3, new Object[]{str6, str7});
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
                    int indexOf = format.indexOf(str6);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.f45110a, R.color.kColorPrimaryText)), indexOf, str6.length() + indexOf, 33);
                    int lastIndexOf = format.lastIndexOf(str7);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(y0(d11)), lastIndexOf, str7.length() + lastIndexOf, 33);
                    this.f45147z.setText(spannableStringBuilder);
                    this.f45147z.setVisibility(0);
                    return;
                }
                this.f45147z.setVisibility(8);
            } else if (!TextUtils.isEmpty(this.V)) {
                if (this.f45142u.getTradePriceType() == 1) {
                    str2 = this.f45144w.getText().toString();
                    str = A0(R.string.n_contract_dialog_tpsl_limit_tips);
                } else if (this.f45142u.getTradePriceType() == 3) {
                    str2 = this.V;
                    str = A0(R.string.n_contract_tpsl_optimal_five_tips);
                } else if (this.f45142u.getTradePriceType() == 4) {
                    str2 = this.V;
                    str = A0(R.string.n_contract_tpsl_optimal_ten_tips);
                } else if (this.f45142u.getTradePriceType() == 5) {
                    String str8 = this.V;
                    str = A0(R.string.n_contract_tpsl_optimal_twenty_tips);
                    str2 = str8;
                } else {
                    str2 = this.V;
                    str = A0(R.string.n_contract_dialog_tpsl_market_tips);
                }
                String d12 = this.f45112b.d(str2, false, s02);
                String str9 = this.V + " " + this.f45112b.getQuoteCurrency();
                String str10 = d12 + " " + B0();
                String format2 = String.format(str, new Object[]{str9, str10});
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(format2);
                int indexOf2 = format2.indexOf(str9);
                spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.f45110a, R.color.kColorPrimaryText)), indexOf2, str9.length() + indexOf2, 33);
                int lastIndexOf2 = format2.lastIndexOf(str10);
                spannableStringBuilder2.setSpan(new ForegroundColorSpan(y0(d12)), lastIndexOf2, str10.length() + lastIndexOf2, 33);
                this.A.setText(spannableStringBuilder2);
                this.A.setVisibility(0);
            } else {
                this.A.setVisibility(8);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void I0(ViewGroup viewGroup, Fragment fragment, boolean z11) {
        T0(viewGroup, fragment.getActivity());
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        FragmentManager fragmentManager = childFragmentManager;
        boolean z12 = z11;
        R0(fragmentManager, this.f45139r, this.Q, this.f45137p, 0, z12);
        R0(fragmentManager, this.f45140s, this.R, this.f45138q, 1, z12);
        S0(childFragmentManager, viewGroup);
        P0(this.f45121f0, new h0(this));
        N0();
    }

    public final void J0(FragmentManager fragmentManager) {
        View labelContainer = this.B.getLabelContainer();
        h hVar = new h(this.X, this.B.getLabelTv());
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new CommonPopListItem(99, m0(), ContextCompat.getColor(o0(), R.color.baseColorPrimaryText), hVar));
        arrayList.add(new CommonPopListItem(100, "%", hVar));
        this.X.setData(arrayList);
        this.X.setFollowViewWidth(false);
        dw.a.a(labelContainer).throttleFirst(1, TimeUnit.SECONDS).subscribe(new a0(this, labelContainer, fragmentManager));
    }

    public void K0() {
        H1(0);
        H1(1);
    }

    public void L0(String str, String str2, int i11, int i12, String str3, String str4, String str5, String str6, PriceType priceType, PriceType priceType2) {
        this.Z = 5;
        if (i11 <= 0) {
            i11 = 0;
        }
        this.S = i11;
        if (i12 <= 10) {
            i12 = 10;
        }
        this.T = i12;
        w1(i11, this.f45139r, this.f45137p);
        w1(this.T, this.f45140s, this.f45138q);
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                j0(0);
            } else if (TextUtils.isEmpty(str2)) {
                j0(1);
            }
        }
        if (TextUtils.equals(str3, "3")) {
            this.O = 1;
            this.f45125h0.setText(A0(R.string.n_contract_mark_price));
        }
        if (TextUtils.equals(str4, "3")) {
            this.P = 1;
            this.f45127i0.setText(A0(R.string.n_contract_mark_price));
        }
        M0(str5, priceType, true);
        M0(str6, priceType2, false);
        this.f45145x.setText(str);
        this.f45146y.setText(str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void M0(java.lang.String r5, com.huobi.contract.entity.PriceType r6, boolean r7) {
        /*
            r4 = this;
            com.huobi.contract.entity.PriceType r0 = com.huobi.contract.entity.PriceType.MARKET
            r1 = 0
            r2 = 1
            if (r6 != r0) goto L_0x000a
            r6 = 8
        L_0x0008:
            r0 = r1
            goto L_0x001e
        L_0x000a:
            com.huobi.contract.entity.PriceType r0 = com.huobi.contract.entity.PriceType.OPTIMAL_FIVE
            if (r6 != r0) goto L_0x0010
            r6 = 3
            goto L_0x0008
        L_0x0010:
            com.huobi.contract.entity.PriceType r0 = com.huobi.contract.entity.PriceType.OPTIMAL_TEN
            if (r6 != r0) goto L_0x0016
            r6 = 4
            goto L_0x0008
        L_0x0016:
            com.huobi.contract.entity.PriceType r0 = com.huobi.contract.entity.PriceType.OPTIMAL_TWENTY
            if (r6 != r0) goto L_0x001c
            r6 = 5
            goto L_0x0008
        L_0x001c:
            r6 = r2
            r0 = r6
        L_0x001e:
            java.lang.String r3 = ""
            if (r7 == 0) goto L_0x003e
            r4.D1(r6, r1)
            if (r0 == 0) goto L_0x0038
            com.huobi.contract.ui.ContractGearsTradePriceEditText r6 = r4.f45141t
            com.huobi.feature.util.FutureTpSlHelper$i r7 = r4.f45112b
            java.lang.String r7 = r7.getQuoteCurrency()
            r6.setLabel(r7)
            android.widget.EditText r6 = r4.f45143v
            r6.setText(r5)
            goto L_0x0059
        L_0x0038:
            com.huobi.contract.ui.ContractGearsTradePriceEditText r5 = r4.f45141t
            r5.setLabel(r3)
            goto L_0x0059
        L_0x003e:
            r4.D1(r6, r2)
            if (r0 == 0) goto L_0x0054
            com.huobi.contract.ui.ContractGearsTradePriceEditText r6 = r4.f45142u
            com.huobi.feature.util.FutureTpSlHelper$i r7 = r4.f45112b
            java.lang.String r7 = r7.getQuoteCurrency()
            r6.setLabel(r7)
            android.widget.EditText r6 = r4.f45144w
            r6.setText(r5)
            goto L_0x0059
        L_0x0054:
            com.huobi.contract.ui.ContractGearsTradePriceEditText r5 = r4.f45142u
            r5.setLabel(r3)
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.feature.util.FutureTpSlHelper.M0(java.lang.String, com.huobi.contract.entity.PriceType, boolean):void");
    }

    public final void N0() {
        this.f45118e.setOnClickListener(new d0(this));
        this.f45120f.setOnClickListener(new u(this));
        this.f45136o.getConfigBuilder().colorConfig(o0(), NightHelper.e().g(), true).build();
        O0(0, this.f45139r, this.f45145x, this.f45143v, this.f45141t);
        O0(1, this.f45140s, this.f45146y, this.f45144w, this.f45142u);
        this.B.setOnEditTextFocusChangeListener(new a());
        this.C.addTextChangedListener(new b());
        this.f45136o.setOnProgressChangedListener(new c());
    }

    public final void O0(int i11, TradePriceEditext tradePriceEditext, EditText editText, EditText editText2, ContractGearsTradePriceEditText contractGearsTradePriceEditText) {
        tradePriceEditext.setOnEditTextFocusChangeListener(new j0(tradePriceEditext));
        editText.addTextChangedListener(new e(i11, editText));
        editText2.addTextChangedListener(new f(editText2, i11));
        contractGearsTradePriceEditText.setOnEditTextFocusChangeListener(new i0(contractGearsTradePriceEditText, editText2));
        contractGearsTradePriceEditText.setOnClickListener(new g0(this, contractGearsTradePriceEditText));
        contractGearsTradePriceEditText.setCallback(new g(i11));
    }

    public final void P0(boolean z11, j jVar) {
        FragmentManager fragmentManager;
        this.f45113b0 = jVar;
        m mVar = new m(0);
        m mVar2 = new m(1);
        this.I.clear();
        if (z11) {
            this.I.add(new CommonPopListItem(8, o0().getString(R.string.n_exchange_order_list_market), ContextCompat.getColor(o0(), R.color.baseColorPrimaryText), mVar));
        } else {
            this.f45115c0 = 1;
        }
        this.I.add(new CommonPopListItem(1, o0().getString(R.string.n_exchange_order_list_limit), mVar));
        this.I.add(new CommonPopListItem(5, o0().getString(R.string.n_contract_trade_optimal_twenty), mVar));
        this.I.add(new CommonPopListItem(4, o0().getString(R.string.n_contract_trade_optimal_ten), mVar));
        this.I.add(new CommonPopListItem(3, o0().getString(R.string.n_contract_trade_optimal_five), mVar));
        this.K.setData(this.I);
        this.K.setFollowViewWidth(true);
        this.J.clear();
        if (z11) {
            this.J.add(new CommonPopListItem(8, o0().getString(R.string.n_exchange_order_list_market), ContextCompat.getColor(o0(), R.color.baseColorPrimaryText), mVar2));
        } else {
            this.f45117d0 = 1;
        }
        this.J.add(new CommonPopListItem(1, o0().getString(R.string.n_exchange_order_list_limit), mVar2));
        this.J.add(new CommonPopListItem(5, o0().getString(R.string.n_contract_trade_optimal_twenty), mVar2));
        this.J.add(new CommonPopListItem(4, o0().getString(R.string.n_contract_trade_optimal_ten), mVar2));
        this.J.add(new CommonPopListItem(3, o0().getString(R.string.n_contract_trade_optimal_five), mVar2));
        this.L.setData(this.J);
        this.L.setFollowViewWidth(true);
        if (z11) {
            this.f45134m.setText(o0().getString(R.string.n_exchange_order_list_market));
            this.f45135n.setText(o0().getString(R.string.n_exchange_order_list_market));
        } else {
            this.f45134m.setText(o0().getString(R.string.n_exchange_order_list_limit));
            this.f45135n.setText(o0().getString(R.string.n_exchange_order_list_limit));
        }
        if (o0() instanceof ContextThemeWrapper) {
            fragmentManager = ((AppCompatActivity) ((ContextThemeWrapper) o0()).getBaseContext()).getSupportFragmentManager();
        } else {
            fragmentManager = o0() instanceof FragmentActivity ? ((FragmentActivity) o0()).getSupportFragmentManager() : null;
        }
        if (fragmentManager != null) {
            this.f45130k.setOnClickListener(new f0(this, fragmentManager));
            this.f45132l.setOnClickListener(new e0(this, fragmentManager));
        }
    }

    public void Q0(Fragment fragment) {
        this.f45123g0 = true;
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        this.B.setPriceInputType(7);
        J0(childFragmentManager);
    }

    public final void R0(FragmentManager fragmentManager, TradePriceEditext tradePriceEditext, CommonListPopupDialog commonListPopupDialog, ViewGroup viewGroup, int i11, boolean z11) {
        CommonListPopupDialog commonListPopupDialog2 = commonListPopupDialog;
        View labelContainer = tradePriceEditext.getLabelContainer();
        int i12 = i11 == 0 ? 0 : 10;
        int i13 = i11 == 0 ? 1 : 11;
        n nVar = new n(commonListPopupDialog2, tradePriceEditext, viewGroup);
        int i14 = 2;
        ArrayList arrayList = new ArrayList(z11 ? 4 : 2);
        arrayList.add(new CommonPopListItem(i12, this.f45112b.getQuoteCurrency(), ContextCompat.getColor(o0(), R.color.baseColorPrimaryText), nVar));
        arrayList.add(new CommonPopListItem(i13, A0(R.string.n_contract_percent_yield), nVar));
        if (z11) {
            if (i11 != 0) {
                i14 = 12;
            }
            int i15 = i11 == 0 ? 3 : 13;
            arrayList.add(new CommonPopListItem(i14, A0(R.string.n_contract_percent_change), nVar));
            arrayList.add(new CommonPopListItem(i15, String.format(A0(R.string.n_contract_profit_unit), new Object[]{B0()}), nVar));
        }
        commonListPopupDialog2.setData(arrayList);
        commonListPopupDialog2.setFollowViewWidth(false);
        FragmentManager fragmentManager2 = fragmentManager;
        dw.a.a(labelContainer).throttleFirst(1, TimeUnit.SECONDS).subscribe(new c0(this, labelContainer, commonListPopupDialog2, fragmentManager));
    }

    public final void S0(FragmentManager fragmentManager, View view) {
        View findViewById = view.findViewById(R.id.ll_price_type_stop_profit);
        View findViewById2 = view.findViewById(R.id.ll_price_type_stop_loss);
        k kVar = new k(this.M, this.f45125h0);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new CommonPopListItem(0, o0().getString(R.string.n_contract_latest_price), ContextCompat.getColor(o0(), R.color.baseColorPrimaryText), kVar));
        arrayList.add(new CommonPopListItem(1, o0().getString(R.string.n_contract_mark_price), kVar));
        this.M.setData(arrayList);
        this.M.setFollowViewWidth(true);
        k kVar2 = new k(this.N, this.f45127i0);
        ArrayList arrayList2 = new ArrayList(2);
        arrayList2.add(new CommonPopListItem(0, o0().getString(R.string.n_contract_latest_price), ContextCompat.getColor(o0(), R.color.baseColorPrimaryText), kVar2));
        arrayList2.add(new CommonPopListItem(1, o0().getString(R.string.n_contract_mark_price), kVar2));
        this.N.setData(arrayList2);
        this.N.setFollowViewWidth(true);
        if (fragmentManager != null) {
            Observable<Void> a11 = dw.a.a(findViewById);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            a11.throttleFirst(1, timeUnit).subscribe(new b0(this, findViewById, fragmentManager));
            dw.a.a(findViewById2).throttleFirst(1, timeUnit).subscribe(new z(this, findViewById2, fragmentManager));
        }
    }

    public final void T0(ViewGroup viewGroup, FragmentActivity fragmentActivity) {
        this.f45110a = viewGroup.getContext();
        SystemKeyBoardHelper systemKeyBoardHelper = new SystemKeyBoardHelper();
        this.f45119e0 = systemKeyBoardHelper;
        systemKeyBoardHelper.attach(fragmentActivity);
        this.f45116d = viewGroup;
        this.f45118e = (ViewGroup) viewGroup.findViewById(R.id.ctlStopProfit);
        this.f45120f = (ViewGroup) viewGroup.findViewById(R.id.ctlStopLoss);
        this.f45122g = (ImageView) viewGroup.findViewById(R.id.cbStopProfit);
        this.f45124h = (ImageView) viewGroup.findViewById(R.id.cbStopLoss);
        this.f45126i = (LinearLayout) viewGroup.findViewById(R.id.llStopProfit);
        this.f45128j = (LinearLayout) viewGroup.findViewById(R.id.llStopLoss);
        this.f45130k = (LinearLayout) viewGroup.findViewById(R.id.llStopProfitGear);
        this.f45132l = (LinearLayout) viewGroup.findViewById(R.id.llStopLossGear);
        this.f45136o = (MultiColorSeekBar) viewGroup.findViewById(R.id.contract_seekbar_new);
        this.f45134m = (TextView) viewGroup.findViewById(R.id.tvStopProfitGear);
        this.f45135n = (TextView) viewGroup.findViewById(R.id.tvStopLossGear);
        this.f45137p = (ViewGroup) viewGroup.findViewById(R.id.llTpEntrustParent);
        this.f45138q = (ViewGroup) viewGroup.findViewById(R.id.llSlEntrustParent);
        TradePriceEditext tradePriceEditext = (TradePriceEditext) viewGroup.findViewById(R.id.dialog_contract_price_et);
        this.f45139r = tradePriceEditext;
        tradePriceEditext.setTradeType(this.f45114c);
        this.f45139r.setPriceInputType(7);
        this.f45139r.setLabel(this.f45112b.getQuoteCurrency());
        TradePriceEditext tradePriceEditext2 = (TradePriceEditext) viewGroup.findViewById(R.id.dialog_contract_price_et_loss);
        this.f45140s = tradePriceEditext2;
        tradePriceEditext2.setTradeType(this.f45114c);
        this.f45140s.setPriceInputType(7);
        this.f45140s.setLabel(this.f45112b.getQuoteCurrency());
        this.f45125h0 = (TextView) viewGroup.findViewById(R.id.tv_price_type_stop_profit);
        this.f45127i0 = (TextView) viewGroup.findViewById(R.id.tv_price_type_stop_loss);
        EditText editText = this.f45139r.getEditText();
        this.f45145x = editText;
        editText.setHint(A0(R.string.n_grid_trad_stop_profit_trigger_price));
        EditText editText2 = this.f45140s.getEditText();
        this.f45146y = editText2;
        editText2.setHint(A0(R.string.n_grid_trad_stop_loss_trigger_price));
        ContractGearsTradePriceEditText contractGearsTradePriceEditText = (ContractGearsTradePriceEditText) viewGroup.findViewById(R.id.contract_trade_price_view);
        this.f45141t = contractGearsTradePriceEditText;
        contractGearsTradePriceEditText.setTradeType(this.f45114c);
        this.f45141t.setLabelViewEnd(DimenUtils.a(23.0f));
        if (this.f45121f0) {
            this.f45141t.setBackgroundResource(R.drawable.gray_edit_bg);
            this.f45141t.setPriceInputType(8);
        } else {
            this.f45141t.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.f45141t.setPriceInputType(1);
        }
        EditText editText3 = this.f45141t.getEditText();
        this.f45143v = editText3;
        editText3.setHint(R.string.n_grid_trad_stop_profit_entrust_price);
        this.f45143v.setText("");
        if (!this.f45121f0) {
            this.f45143v.setEnabled(false);
        } else {
            this.f45143v.setEnabled(true);
        }
        this.f45143v.setVisibility(0);
        this.f45141t.setIconImgVisible(false);
        this.f45141t.o(this.f45121f0);
        ContractGearsTradePriceEditText contractGearsTradePriceEditText2 = (ContractGearsTradePriceEditText) viewGroup.findViewById(R.id.contract_trade_price_view_loss);
        this.f45142u = contractGearsTradePriceEditText2;
        contractGearsTradePriceEditText2.setTradeType(this.f45114c);
        this.f45142u.setLabelViewEnd(DimenUtils.a(23.0f));
        if (this.f45121f0) {
            this.f45142u.setBackgroundResource(R.drawable.gray_edit_bg);
            this.f45142u.setPriceInputType(8);
        } else {
            this.f45142u.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.f45142u.setPriceInputType(1);
        }
        EditText editText4 = this.f45142u.getEditText();
        this.f45144w = editText4;
        editText4.setHint(R.string.n_grid_trad_stop_loss_entrust_price);
        this.f45144w.setText("");
        if (this.f45121f0) {
            this.f45144w.setEnabled(false);
        } else {
            this.f45144w.setEnabled(true);
        }
        this.f45144w.setVisibility(0);
        this.f45142u.setIconImgVisible(false);
        this.f45142u.o(this.f45121f0);
        this.f45147z = (TextView) viewGroup.findViewById(R.id.tv_pnl_tp);
        this.A = (TextView) viewGroup.findViewById(R.id.tv_pnl_sl);
        TradePriceEditext tradePriceEditext3 = (TradePriceEditext) viewGroup.findViewById(R.id.tpeCount);
        this.B = tradePriceEditext3;
        tradePriceEditext3.setTradeType(this.f45114c);
        this.B.setLabel(m0());
        this.B.setHintText(o0().getString(R.string.n_contract_trade_input_amount));
        this.B.hidePlus();
        this.C = this.B.getEditText();
        this.D = (ViewGroup) viewGroup.findViewById(R.id.amount_layout);
        this.E = (ViewGroup) viewGroup.findViewById(R.id.amount_convert_container);
        this.F = (TextView) viewGroup.findViewById(R.id.amount_convert_tv);
    }

    public boolean U0() {
        return this.f45111a0 == 100;
    }

    public boolean V0() {
        return this.Z == 0;
    }

    public boolean W0() {
        return this.P == 1;
    }

    public final void X(EditText editText, Editable editable, boolean z11) {
        if (editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        }
        String b11 = i6.m.b(editable, 10, this.f45112b.getTradePricePrecision());
        if (b11 != null) {
            editText.setText(b11);
            editText.setSelection(editText.getText().length());
        }
    }

    public boolean X0() {
        return this.O == 1;
    }

    public void Y(int i11, EditText editText, Editable editable) {
        int i12;
        if (editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        }
        String str = null;
        String obj = editable.toString();
        if (!TextUtils.isEmpty(obj)) {
            if (this.f45114c == TradeType.LINEAR_SWAP) {
                i12 = 4;
            } else {
                i12 = us.i.p(this.f45112b.E0());
            }
            str = i6.m.b(editable, 10, i12);
        }
        BigDecimal bigDecimal = BigDecimal.ZERO;
        boolean z11 = false;
        boolean z12 = true;
        if (str != null) {
            bigDecimal = i6.m.a(str);
            z11 = true;
        } else if (!TextUtils.isEmpty(obj)) {
            bigDecimal = i6.m.a(obj);
        }
        if (!editText.isFocused() || i11 != 1 || !i6.m.f0(bigDecimal, BigDecimal.ZERO)) {
            z12 = z11;
        } else {
            bigDecimal = bigDecimal.negate();
        }
        if (z12) {
            String plainString = bigDecimal.toPlainString();
            editText.setText(plainString);
            editText.setSelection(plainString.length());
        }
    }

    public void Z(EditText editText, Editable editable) {
        if (editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        }
        String b11 = i6.m.b(editable, 10, this.f45112b.getTradePricePrecision());
        if (b11 != null) {
            editText.setText(b11);
            editText.setSelection(editText.getText().length());
        }
    }

    public void a0(int i11, EditText editText, Editable editable) {
        if (editable.length() == 0) {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_regular));
        } else {
            editText.setTypeface(ResourcesCompat.h(editText.getContext(), R.font.roboto_medium));
        }
        String str = null;
        String obj = editable.toString();
        if (!TextUtils.isEmpty(obj)) {
            str = i6.m.b(editable, 10, 2);
        }
        BigDecimal bigDecimal = BigDecimal.ZERO;
        boolean z11 = false;
        boolean z12 = true;
        if (str != null) {
            bigDecimal = i6.m.a(str);
            z11 = true;
        } else if (!TextUtils.isEmpty(obj)) {
            bigDecimal = i6.m.a(obj);
        }
        if (!editText.isFocused() || i11 != 1 || !i6.m.f0(bigDecimal, BigDecimal.ZERO)) {
            z12 = z11;
        } else {
            bigDecimal = bigDecimal.negate();
        }
        if (z12) {
            String plainString = bigDecimal.toPlainString();
            editText.setText(plainString);
            editText.setSelection(plainString.length());
        }
    }

    public final boolean b0(String str) {
        return i6.m.a(str).compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean c0(String str) {
        if (!V0() || b0(str)) {
            return true;
        }
        HuobiToastUtil.l(bh.j.c(), String.format(bh.j.c().getString(R.string.input_unknow_text), new Object[]{this.C.getHint() == null ? "" : this.C.getHint().toString()}));
        return false;
    }

    public boolean d0(String str) {
        return i6.m.a(str).compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean e0() {
        String str = "";
        if (q0()) {
            String charSequence = this.f45143v.getHint() == null ? str : this.f45143v.getHint().toString();
            String obj = this.f45143v.getText().toString();
            if (this.f45141t.getTradePriceType() == 1 && !d0(obj)) {
                HuobiToastUtil.l(bh.j.c(), String.format(bh.j.c().getString(R.string.input_unknow_text), new Object[]{charSequence}));
                return false;
            }
        }
        if (p0()) {
            if (this.f45144w.getHint() != null) {
                str = this.f45144w.getHint().toString();
            }
            String obj2 = this.f45144w.getText().toString();
            if (this.f45142u.getTradePriceType() == 1 && !d0(obj2)) {
                HuobiToastUtil.l(bh.j.c(), String.format(bh.j.c().getString(R.string.input_unknow_text), new Object[]{str}));
                return false;
            }
        }
        return true;
    }

    public boolean f0() {
        if (q0() && TextUtils.isEmpty(this.U)) {
            HuobiToastUtil.l(bh.j.c(), String.format(A0(R.string.input_unknow_text), new Object[]{this.f45145x.getHint() == null ? A0(R.string.n_contract_please_enter_trigger_price) : this.f45145x.getHint().toString()}));
            return false;
        } else if (!p0() || !TextUtils.isEmpty(this.V)) {
            return true;
        } else {
            HuobiToastUtil.l(bh.j.c(), String.format(A0(R.string.input_unknow_text), new Object[]{this.f45146y.getHint() == null ? A0(R.string.n_contract_please_enter_trigger_price) : this.f45146y.getHint().toString()}));
            return false;
        }
    }

    public boolean g0(String str) {
        if (!f0()) {
            return false;
        }
        BigDecimal a11 = i6.m.a(this.U);
        BigDecimal a12 = i6.m.a(this.V);
        boolean z11 = true;
        BigDecimal scale = i6.m.a(str).setScale(this.f45112b.getTradePricePrecision(), 1);
        if ("buy".equalsIgnoreCase(this.f45112b.f())) {
            if (q0() && a11.compareTo(scale) <= 0) {
                HuobiToastUtil.k(bh.j.c(), R.string.n_contract_trade_hold_stop_tips1);
                z11 = false;
            }
            if ((p0() && a12.compareTo(BigDecimal.ZERO) <= 0) || a12.compareTo(scale) >= 0) {
                HuobiToastUtil.k(bh.j.c(), R.string.n_contract_trade_hold_stop_tips2);
                return false;
            }
        } else {
            if ((q0() && a11.compareTo(BigDecimal.ZERO) <= 0) || a11.compareTo(scale) >= 0) {
                HuobiToastUtil.k(bh.j.c(), R.string.n_contract_trade_hold_stop_tips2);
                z11 = false;
            }
            if (p0() && a12.compareTo(scale) <= 0) {
                HuobiToastUtil.k(bh.j.c(), R.string.n_contract_trade_hold_stop_tips1);
                return false;
            }
        }
        return z11;
    }

    public void h0() {
        this.f45145x.clearFocus();
        this.f45146y.clearFocus();
        this.C.clearFocus();
        this.f45143v.clearFocus();
        this.f45144w.clearFocus();
    }

    public final void i0() {
        this.f45136o.setProgress(0.0f);
    }

    public final void j0(int i11) {
        if (i11 == 0) {
            if (!this.H) {
                return;
            }
        } else if (!this.G) {
            return;
        }
        int i12 = 0;
        int i13 = R.drawable.common_check_selected;
        if (i11 == 0) {
            boolean z11 = !this.G;
            this.G = z11;
            ImageView imageView = this.f45122g;
            if (!z11) {
                i13 = R.drawable.common_check_unselected;
            }
            imageView.setImageResource(i13);
            LinearLayout linearLayout = this.f45126i;
            if (!this.G) {
                i12 = 8;
            }
            linearLayout.setVisibility(i12);
            return;
        }
        boolean z12 = !this.H;
        this.H = z12;
        ImageView imageView2 = this.f45124h;
        if (!z12) {
            i13 = R.drawable.common_check_unselected;
        }
        imageView2.setImageResource(i13);
        LinearLayout linearLayout2 = this.f45128j;
        if (!this.H) {
            i12 = 8;
        }
        linearLayout2.setVisibility(i12);
    }

    public void k0() {
        this.K.dismiss();
        this.L.dismiss();
    }

    public EditText l0() {
        return this.C;
    }

    public final String m0() {
        TradeType tradeType = this.f45114c;
        if (tradeType == TradeType.LINEAR_SWAP) {
            if (a7.e.E(tradeType)) {
                return this.f45112b.o0();
            }
            return this.f45112b.getQuoteCurrency();
        } else if (a7.e.E(tradeType)) {
            return this.f45112b.o0();
        } else {
            return A0(R.string.contract_trade_unit_sheet);
        }
    }

    public final int n0(int i11) {
        return this.f45110a.getResources().getColor(i11);
    }

    public final Context o0() {
        return this.f45110a;
    }

    public boolean p0() {
        return this.H;
    }

    public final void p1(boolean z11, Editable editable, int i11) {
        this.f45131k0.e(z11);
        this.f45131k0.d(editable);
        this.f45131k0.f(i11);
        f45109m0.postDelayed(this.f45133l0, 30);
    }

    public boolean q0() {
        return this.G;
    }

    public final void q1(int i11) {
        if (this.f45123g0 && i11 != this.f45111a0) {
            this.f45111a0 = i11;
            if (!r1(0)) {
                this.f45129j0 = BigDecimal.ZERO;
                i0();
                this.C.setText((CharSequence) null);
                this.E.setVisibility(8);
            }
        }
    }

    public String r0(int i11) {
        int i12;
        if (this.W) {
            return "tpsl_position_trigger";
        }
        if (i11 == 0) {
            i12 = this.f45141t.getTradePriceType();
        } else {
            i12 = this.f45142u.getTradePriceType();
        }
        if (i12 == 3) {
            return "optimal_5";
        }
        if (i12 == 4) {
            return "optimal_10";
        }
        if (i12 != 5) {
            return i12 != 8 ? "limit" : PrimeRounds.ROUND_TRADE_MARKET_TYPE;
        }
        return "optimal_20";
    }

    public final boolean r1(int i11) {
        if (this.Z == i11) {
            return false;
        }
        this.Z = i11;
        if (i11 == 0) {
            this.f45129j0 = BigDecimal.ZERO;
            i0();
            this.C.requestFocus();
        } else {
            this.f45112b.a();
            h0();
        }
        this.C.setText((CharSequence) null);
        this.E.setVisibility(8);
        return true;
    }

    public final BigDecimal s0() {
        BigDecimal bigDecimal = this.f45129j0;
        if (bigDecimal == null) {
            return BigDecimal.ZERO;
        }
        return bigDecimal.divide(BigDecimal.valueOf(100));
    }

    public void s1() {
        if (q0()) {
            v1(0);
        }
        if (p0()) {
            v1(1);
        }
    }

    public String t0() {
        return this.f45144w.getText().toString();
    }

    public final void t1(int i11) {
        r1(5);
        p1(false, (Editable) null, i11);
    }

    public String u0() {
        return this.f45143v.getText().toString();
    }

    public void u1() {
        this.f45136o.setProgress(100.0f);
        t1(100);
    }

    public int v0() {
        return this.f45142u.getTradePriceType();
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void v1(int r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0005
            int r0 = r5.S
            goto L_0x0007
        L_0x0005:
            int r0 = r5.T
        L_0x0007:
            if (r6 != 0) goto L_0x000c
            android.widget.EditText r1 = r5.f45145x
            goto L_0x000e
        L_0x000c:
            android.widget.EditText r1 = r5.f45146y
        L_0x000e:
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x0092
            r3 = 1
            if (r0 == r3) goto L_0x006c
            r4 = 2
            if (r0 == r4) goto L_0x004a
            r4 = 3
            if (r0 == r4) goto L_0x0020
            switch(r0) {
                case 10: goto L_0x0092;
                case 11: goto L_0x006c;
                case 12: goto L_0x004a;
                case 13: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x009a
        L_0x0020:
            android.text.Editable r0 = r1.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = com.hbg.lib.common.utils.StringUtils.p(r0)
            if (r0 == 0) goto L_0x002f
            goto L_0x009a
        L_0x002f:
            com.huobi.feature.util.FutureTpSlHelper$i r0 = r5.f45112b
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            if (r6 != 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r3 = 0
        L_0x003d:
            java.math.BigDecimal r2 = r5.s0()
            java.math.BigDecimal r0 = r0.g(r1, r3, r2)
            java.lang.String r2 = r0.toPlainString()
            goto L_0x009a
        L_0x004a:
            android.text.Editable r0 = r1.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = com.hbg.lib.common.utils.StringUtils.p(r0)
            if (r0 == 0) goto L_0x0059
            goto L_0x009a
        L_0x0059:
            com.huobi.feature.util.FutureTpSlHelper$i r0 = r5.f45112b
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.math.BigDecimal r0 = r0.c(r1, r6)
            java.lang.String r2 = r0.toPlainString()
            goto L_0x009a
        L_0x006c:
            android.text.Editable r0 = r1.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = com.hbg.lib.common.utils.StringUtils.p(r0)
            if (r0 == 0) goto L_0x007b
            goto L_0x009a
        L_0x007b:
            com.huobi.feature.util.FutureTpSlHelper$i r0 = r5.f45112b
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r0 = r0.h(r1, r6)
            java.math.BigDecimal r0 = i6.m.a(r0)
            java.lang.String r2 = r0.toPlainString()
            goto L_0x009a
        L_0x0092:
            android.text.Editable r0 = r1.getText()
            java.lang.String r2 = r0.toString()
        L_0x009a:
            if (r6 != 0) goto L_0x009f
            r5.U = r2
            goto L_0x00a1
        L_0x009f:
            r5.V = r2
        L_0x00a1:
            r5.H1(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.feature.util.FutureTpSlHelper.v1(int):void");
    }

    public int w0() {
        return this.f45141t.getTradePriceType();
    }

    public final void w1(int i11, TradePriceEditext tradePriceEditext, ViewGroup viewGroup) {
        if (i11 == 0) {
            tradePriceEditext.getEditText().setHint(A0(R.string.n_grid_trad_stop_profit_trigger_price));
            tradePriceEditext.setLabel(this.f45112b.getQuoteCurrency());
            if (!this.W) {
                viewGroup.setVisibility(0);
            }
        } else if (i11 == 1) {
            tradePriceEditext.getEditText().setHint(A0(R.string.n_contract_tp_yield));
            tradePriceEditext.setLabel(A0(R.string.n_contract_percent_yield));
            viewGroup.setVisibility(8);
            j jVar = this.f45113b0;
            if (jVar != null) {
                jVar.a(8, 0);
            }
        } else if (i11 == 2) {
            tradePriceEditext.getEditText().setHint(A0(R.string.n_contract_tp_change));
            tradePriceEditext.setLabel(A0(R.string.n_contract_percent_change));
            if (!this.W) {
                viewGroup.setVisibility(0);
            }
        } else if (i11 != 3) {
            switch (i11) {
                case 10:
                    tradePriceEditext.getEditText().setHint(A0(R.string.n_grid_trad_stop_loss_trigger_price));
                    tradePriceEditext.setLabel(this.f45112b.getQuoteCurrency());
                    if (!this.W) {
                        viewGroup.setVisibility(0);
                        return;
                    }
                    return;
                case 11:
                    tradePriceEditext.getEditText().setHint(A0(R.string.n_contract_sl_yield));
                    tradePriceEditext.setLabel(A0(R.string.n_contract_percent_yield));
                    viewGroup.setVisibility(8);
                    j jVar2 = this.f45113b0;
                    if (jVar2 != null) {
                        jVar2.a(8, 1);
                        return;
                    }
                    return;
                case 12:
                    tradePriceEditext.getEditText().setHint(A0(R.string.n_contract_sl_change));
                    tradePriceEditext.setLabel(A0(R.string.n_contract_percent_change));
                    if (!this.W) {
                        viewGroup.setVisibility(0);
                        return;
                    }
                    return;
                case 13:
                    tradePriceEditext.getEditText().setHint(A0(R.string.n_contract_sl_profit));
                    tradePriceEditext.setLabel(String.format(A0(R.string.n_contract_profit_unit), new Object[]{B0()}));
                    viewGroup.setVisibility(8);
                    j jVar3 = this.f45113b0;
                    if (jVar3 != null) {
                        jVar3.a(8, 1);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            tradePriceEditext.getEditText().setHint(A0(R.string.n_contract_tp_profit));
            tradePriceEditext.setLabel(String.format(A0(R.string.n_contract_profit_unit), new Object[]{B0()}));
            viewGroup.setVisibility(8);
            j jVar4 = this.f45113b0;
            if (jVar4 != null) {
                jVar4.a(8, 0);
            }
        }
    }

    public BigDecimal x0() {
        return this.f45129j0;
    }

    public void x1(String str) {
        if (!U0()) {
            this.E.setVisibility(8);
        } else if (TextUtils.isEmpty(str)) {
            this.E.setVisibility(8);
        } else {
            this.E.setVisibility(0);
            this.F.setText(AppUtil.b("≈", str, " ", m0()));
        }
    }

    public final int y0(String str) {
        if ("--".equalsIgnoreCase(str)) {
            return n0(R.color.baseColorPrimaryText);
        }
        if (i6.m.a(str).compareTo(BigDecimal.ZERO) > 0) {
            return n0(com.hbg.lib.core.util.w.h());
        }
        if (i6.m.a(str).compareTo(BigDecimal.ZERO) < 0) {
            return n0(com.hbg.lib.core.util.w.d());
        }
        return n0(R.color.baseColorPrimaryText);
    }

    public void y1(TradeType tradeType, i iVar) {
        this.f45114c = tradeType;
        this.f45112b = iVar;
    }

    public int z0() {
        return this.f45136o.getProgress();
    }

    public void z1(boolean z11) {
    }

    public FutureTpSlHelper(TradeType tradeType, i iVar) {
        this.f45114c = tradeType;
        this.f45112b = iVar;
    }
}
