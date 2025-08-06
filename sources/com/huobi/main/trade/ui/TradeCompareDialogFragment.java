package com.huobi.main.trade.ui;

import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.main.trade.enums.SafeguardType;
import com.huobi.main.trade.enums.TradeTabsType;
import com.huobi.main.trade.ui.TradeDialogFilterDialog;
import com.huobi.view.TitleLayout;
import com.huobi.webview2.ui.ContractWebActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import eo.h;
import i6.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p039do.e0;
import p039do.f0;
import p039do.k;
import p039do.s;
import p039do.y;
import p039do.z;
import pro.huobi.R;

public class TradeCompareDialogFragment extends BaseDialogFragment implements View.OnClickListener, co.b, co.a, TitleLayout.OnTitleListener {
    public u6.g A;
    public TradeType B = TradeType.PRO;
    public TradeType C;
    public s9.a D;
    public String E;
    public View F;
    public TextView G;
    public View H;
    public TextView I;
    public TradeDialogFilterDialog J = new TradeDialogFilterDialog();
    public boolean K;
    public final HashMap<TradeType, p039do.a> L = new HashMap<>();
    public g M;
    public boolean N = true;
    public TradeTabsType O = TradeTabsType.OTHER;

    /* renamed from: b  reason: collision with root package name */
    public View f77814b;

    /* renamed from: c  reason: collision with root package name */
    public RadioGroup f77815c;

    /* renamed from: d  reason: collision with root package name */
    public ConstraintLayout f77816d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f77817e;

    /* renamed from: f  reason: collision with root package name */
    public HorizontalScrollView f77818f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f77819g;

    /* renamed from: h  reason: collision with root package name */
    public DecelerateInterpolator f77820h = new DecelerateInterpolator();

    /* renamed from: i  reason: collision with root package name */
    public int f77821i;

    /* renamed from: j  reason: collision with root package name */
    public TitleLayout f77822j;

    /* renamed from: k  reason: collision with root package name */
    public List<String> f77823k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public TradeType f77824l;

    /* renamed from: m  reason: collision with root package name */
    public s9.a f77825m;

    /* renamed from: n  reason: collision with root package name */
    public View f77826n;

    /* renamed from: o  reason: collision with root package name */
    public LoadingLayout f77827o;

    /* renamed from: p  reason: collision with root package name */
    public View f77828p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f77829q;

    /* renamed from: r  reason: collision with root package name */
    public View f77830r;

    /* renamed from: s  reason: collision with root package name */
    public View f77831s;

    /* renamed from: t  reason: collision with root package name */
    public View f77832t;

    /* renamed from: u  reason: collision with root package name */
    public EditText f77833u;

    /* renamed from: v  reason: collision with root package name */
    public ImageView f77834v;

    /* renamed from: w  reason: collision with root package name */
    public EasyRecyclerView f77835w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f77836x;

    /* renamed from: y  reason: collision with root package name */
    public View f77837y;

    /* renamed from: z  reason: collision with root package name */
    public View f77838z;

    public class a implements BaseDialogFragment.b {
        public a() {
        }

        public void onDismiss() {
            if (TradeCompareDialogFragment.this.M != null && TradeCompareDialogFragment.this.f77824l != null && TradeCompareDialogFragment.this.f77825m != null) {
                TradeCompareDialogFragment.this.M.a(TradeCompareDialogFragment.this.f77824l, TradeCompareDialogFragment.this.f77825m);
            }
        }
    }

    public class b implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public String f77840b;

        public b() {
        }

        public void afterTextChanged(Editable editable) {
            String upperCase = editable.toString().toUpperCase(Locale.US);
            if (TextUtils.isEmpty(upperCase) || !upperCase.equals(this.f77840b)) {
                this.f77840b = upperCase;
                i6.d.b("TradeCompareDialogFragment-->TextChanged-->afterTextChanged-->" + this.f77840b);
                if (TradeType.CONTRACT == TradeCompareDialogFragment.this.B) {
                    if (TradeCompareDialogFragment.this.Oh() instanceof p039do.d) {
                        ((p039do.d) TradeCompareDialogFragment.this.Oh()).L(this.f77840b);
                    }
                } else if (TradeType.LINEAR_SWAP == TradeCompareDialogFragment.this.B) {
                    if (TradeCompareDialogFragment.this.Oh() instanceof y) {
                        ((y) TradeCompareDialogFragment.this.Oh()).R(this.f77840b);
                    }
                } else if (TradeType.GRID != TradeCompareDialogFragment.this.B) {
                    k Fh = TradeCompareDialogFragment.this.Qh();
                    if (Fh != null) {
                        Fh.d0(this.f77840b);
                    }
                } else if (TradeCompareDialogFragment.this.Oh() instanceof s) {
                    ((s) TradeCompareDialogFragment.this.Oh()).Z(this.f77840b);
                }
                TradeCompareDialogFragment.this.f77833u.removeTextChangedListener(this);
                TradeCompareDialogFragment.this.f77833u.setText(this.f77840b);
                TradeCompareDialogFragment.this.f77833u.setSelection(this.f77840b.length());
                TradeCompareDialogFragment.this.f77833u.addTextChangedListener(this);
                TradeCompareDialogFragment.this.f77834v.setVisibility(!TextUtils.isEmpty(this.f77840b) ? 0 : 8);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            i6.d.b("TradeCompareDialogFragment-->TextChanged-->beforeTextChanged-->" + charSequence);
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            i6.d.b("TradeCompareDialogFragment-->TextChanged-->onTextChanged-->" + charSequence);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            TradeCompareDialogFragment tradeCompareDialogFragment = TradeCompareDialogFragment.this;
            tradeCompareDialogFragment.fi(tradeCompareDialogFragment.G, false);
            TradeCompareDialogFragment.this.ji(0);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            TradeCompareDialogFragment tradeCompareDialogFragment = TradeCompareDialogFragment.this;
            tradeCompareDialogFragment.fi(tradeCompareDialogFragment.I, false);
            TradeCompareDialogFragment.this.ji(1);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class e implements TradeDialogFilterDialog.d {
        public e() {
        }

        public void a(int i11, int i12, String str) {
        }

        public void b(int i11) {
        }

        public void c(int i11, int i12) {
            TradeCompareDialogFragment tradeCompareDialogFragment = TradeCompareDialogFragment.this;
            tradeCompareDialogFragment.fi(tradeCompareDialogFragment.G, true);
            TradeCompareDialogFragment tradeCompareDialogFragment2 = TradeCompareDialogFragment.this;
            tradeCompareDialogFragment2.fi(tradeCompareDialogFragment2.I, true);
        }
    }

    public static /* synthetic */ class f {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f77845a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f77846b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f77847c;

        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|(2:23|24)|25|(2:27|28)|29|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|(2:27|28)|29|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|(2:27|28)|29|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x007e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0088 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00a6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00b1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00bc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00c8 */
        static {
            /*
                com.huobi.main.trade.enums.SafeguardType[] r0 = com.huobi.main.trade.enums.SafeguardType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f77847c = r0
                r1 = 1
                com.huobi.main.trade.enums.SafeguardType r2 = com.huobi.main.trade.enums.SafeguardType.SAFEGUARD_ALL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f77847c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.main.trade.enums.SafeguardType r3 = com.huobi.main.trade.enums.SafeguardType.SAFEGUARD_TIPS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f77847c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.main.trade.enums.SafeguardType r4 = com.huobi.main.trade.enums.SafeguardType.SAFEGUARD_SINGLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f77847c     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.main.trade.enums.SafeguardType r5 = com.huobi.main.trade.enums.SafeguardType.SAFEGUARD_NONE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.huobi.main.trade.enums.TradeTabsType[] r4 = com.huobi.main.trade.enums.TradeTabsType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f77846b = r4
                com.huobi.main.trade.enums.TradeTabsType r5 = com.huobi.main.trade.enums.TradeTabsType.COLLECTION     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r4 = f77846b     // Catch:{ NoSuchFieldError -> 0x004e }
                com.huobi.main.trade.enums.TradeTabsType r5 = com.huobi.main.trade.enums.TradeTabsType.COLLECTION_SEARCH     // Catch:{ NoSuchFieldError -> 0x004e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r4 = f77846b     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.huobi.main.trade.enums.TradeTabsType r5 = com.huobi.main.trade.enums.TradeTabsType.OTHER_SEARCH     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r4 = f77846b     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.huobi.main.trade.enums.TradeTabsType r5 = com.huobi.main.trade.enums.TradeTabsType.OTHER     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                r4 = 5
                int[] r5 = f77846b     // Catch:{ NoSuchFieldError -> 0x006d }
                com.huobi.main.trade.enums.TradeTabsType r6 = com.huobi.main.trade.enums.TradeTabsType.COMPARE     // Catch:{ NoSuchFieldError -> 0x006d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                com.hbg.lib.data.symbol.TradeType[] r5 = com.hbg.lib.data.symbol.TradeType.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f77845a = r5
                com.hbg.lib.data.symbol.TradeType r6 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ NoSuchFieldError -> 0x007e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                int[] r1 = f77845a     // Catch:{ NoSuchFieldError -> 0x0088 }
                com.hbg.lib.data.symbol.TradeType r5 = com.hbg.lib.data.symbol.TradeType.GRID     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0088 }
            L_0x0088:
                int[] r0 = f77845a     // Catch:{ NoSuchFieldError -> 0x0092 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.MARGIN     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                int[] r0 = f77845a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SUPERMARGIN     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f77845a     // Catch:{ NoSuchFieldError -> 0x00a6 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.C2C     // Catch:{ NoSuchFieldError -> 0x00a6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a6 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00a6 }
            L_0x00a6:
                int[] r0 = f77845a     // Catch:{ NoSuchFieldError -> 0x00b1 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x00b1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b1 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b1 }
            L_0x00b1:
                int[] r0 = f77845a     // Catch:{ NoSuchFieldError -> 0x00bc }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x00bc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bc }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00bc }
            L_0x00bc:
                int[] r0 = f77845a     // Catch:{ NoSuchFieldError -> 0x00c8 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.OTC     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                int[] r0 = f77845a     // Catch:{ NoSuchFieldError -> 0x00d4 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.OPTION     // Catch:{ NoSuchFieldError -> 0x00d4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d4 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d4 }
            L_0x00d4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.main.trade.ui.TradeCompareDialogFragment.f.<clinit>():void");
        }
    }

    public interface g {
        void a(TradeType tradeType, s9.a aVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Uh(RadioButton radioButton) {
        int scrollX = this.f77818f.getScrollX();
        int left = radioButton.getLeft();
        if (left < scrollX) {
            this.f77818f.smoothScrollBy(left - scrollX, 0);
        }
        int right = radioButton.getRight();
        int measuredWidth = this.f77818f.getMeasuredWidth();
        if (measuredWidth + scrollX < right) {
            this.f77818f.smoothScrollBy((right - scrollX) - measuredWidth, 0);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Vh(r rVar, RadioGroup radioGroup, int i11) {
        RadioButton radioButton = (RadioButton) rVar.b(i11);
        if (radioButton != null) {
            radioButton.postDelayed(new h(this, radioButton), 300);
        }
        SensorsDataAutoTrackHelper.trackRadioGroup(radioGroup, i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Wh(View view, int i11, int i12, int i13, int i14) {
        if (((view.getScrollX() + view.getWidth()) - view.getPaddingLeft()) - view.getPaddingRight() == this.f77818f.getChildAt(0).getWidth()) {
            Nh();
        } else {
            Mh();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        ContractWebActivity.li(getActivity(), 3);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        HorizontalScrollView horizontalScrollView = this.f77818f;
        if (horizontalScrollView != null) {
            horizontalScrollView.smoothScrollTo(Integer.MAX_VALUE, 0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public boolean G2() {
        return this.K;
    }

    public final void Kh() {
        this.f77833u.setText("");
        this.f77833u.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(this.f77833u.getWindowToken(), 0);
        }
    }

    public final p039do.a Lh(TradeType tradeType) {
        switch (f.f77845a[tradeType.ordinal()]) {
            case 1:
                k kVar = new k((Context) getActivity(), 1, (co.a) this, Rh());
                kVar.e0(true);
                return kVar;
            case 2:
                return new s(getActivity(), this, Rh());
            case 3:
                return new z(getActivity(), this, Rh());
            case 4:
                return new f0(getActivity(), this, Rh());
            case 5:
                return new p039do.b(getActivity(), this, Rh());
            case 6:
                return new p039do.d(getActivity(), this, Rh());
            case 7:
                return new y(getActivity(), this, Rh());
            case 8:
                return new e0(getActivity(), this, Rh());
            default:
                return null;
        }
    }

    public final void Mh() {
        if (!this.f77819g) {
            this.f77819g = true;
            this.f77817e.animate().setInterpolator(this.f77820h).setDuration(300).translationX(0.0f).alpha(1.0f);
        }
    }

    public final void Nh() {
        if (this.f77819g) {
            this.f77819g = false;
            this.f77817e.animate().setInterpolator(this.f77820h).setDuration(300).translationX((float) this.f77817e.getWidth()).alpha(0.0f);
        }
    }

    public final p039do.a Oh() {
        return this.L.get(Ph());
    }

    public TradeType Ph() {
        return this.B;
    }

    public final k Qh() {
        p039do.a Oh = Oh();
        if (Oh instanceof k) {
            return (k) Oh;
        }
        return null;
    }

    public s9.a R5() {
        if (this.C == Ph()) {
            return this.D;
        }
        return null;
    }

    public final u6.g Rh() {
        return this.A;
    }

    public final void Sh(TradeType tradeType) {
        TextView textView = this.f77829q;
        if (textView != null) {
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.trade_dialog_safeguard_text_color));
            this.f77829q.setBackground(ContextCompat.getDrawable(getContext(), R.color.trade_dialog_safeguard_bg_color));
        }
        int i11 = R.color.trade_dialog_divider_color_light;
        if (G2()) {
            i11 = R.color.trade_dialog_divider_color_night;
        }
        View view = this.f77830r;
        if (view != null) {
            view.setBackground(ContextCompat.getDrawable(getContext(), i11));
        }
        View view2 = this.f77814b;
        if (view2 != null) {
            view2.setBackground(ContextCompat.getDrawable(getContext(), i11));
        }
        View view3 = this.f77831s;
        if (view3 != null) {
            view3.setBackground(ContextCompat.getDrawable(getContext(), i11));
        }
    }

    public boolean Th() {
        return this.N;
    }

    public final void Xh(TradeType tradeType) {
        synchronized (this.L) {
            if (!this.L.containsKey(tradeType)) {
                this.L.put(tradeType, Lh(tradeType));
            }
            for (Map.Entry next : this.L.entrySet()) {
                TradeType tradeType2 = (TradeType) next.getKey();
                p039do.a aVar = (p039do.a) next.getValue();
                if (tradeType == tradeType2 && aVar != null) {
                    if (!(aVar instanceof f0)) {
                        if (!(aVar instanceof z)) {
                            aVar.k();
                        }
                    }
                    if (!TextUtils.isEmpty(this.f77833u.getText())) {
                        ((k) aVar).d0(this.f77833u.getText().toString());
                    }
                    ((k) aVar).W();
                }
            }
        }
    }

    public void Yf(TradeType tradeType, List list) {
        i6.d.b("TradeCompareDialogFragment-->onDataObserver-->" + tradeType + " list:" + list);
        if (Ph() == tradeType) {
            ai(this.O, list);
        }
    }

    public void Yh(g gVar) {
        this.M = gVar;
    }

    public final void Zh(TradeType tradeType) {
        this.B = tradeType;
    }

    public void a(TradeType tradeType, s9.a aVar) {
        if (this.M != null) {
            int i11 = f.f77845a[Ph().ordinal()];
            if (i11 != 3 && i11 != 4) {
                this.f77824l = tradeType;
                this.f77825m = aVar;
                HashMap hashMap = new HashMap();
                hashMap.put("TransPair_current_id", nf());
                hashMap.put("TransPair_target_id", ((ml.d) aVar).o());
                BaseModuleConfig.a().w("App_markets_contrast_pop_click", hashMap);
            } else if (this.f77822j.getSelectedIndex() == 0) {
                this.M.a(TradeType.SUPERMARGIN, aVar);
            } else {
                this.M.a(TradeType.MARGIN, aVar);
            }
        }
        dismiss();
    }

    public void addEvent(r rVar) {
        this.f77834v.setOnClickListener(this);
        this.f77833u.addTextChangedListener(new b());
        this.f77837y.setOnClickListener(new eo.e(this));
        this.F.setOnClickListener(new c());
        this.H.setOnClickListener(new d());
        this.J.Hh(new e());
        RadioGroup radioGroup = this.f77815c;
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new eo.g(this, rVar));
        }
        this.f77817e.setOnClickListener(new eo.c(this));
        HorizontalScrollView horizontalScrollView = this.f77818f;
        if (horizontalScrollView != null && Build.VERSION.SDK_INT >= 23) {
            horizontalScrollView.setOnScrollChangeListener(new eo.f(this));
        }
        TitleLayout titleLayout = this.f77822j;
        if (titleLayout != null) {
            titleLayout.setTitleListener(this);
        }
    }

    public void afterInit() {
    }

    public final void ai(TradeTabsType tradeTabsType, List<? extends s9.a> list) {
        int i11;
        EasyRecyclerView easyRecyclerView = this.f77835w;
        if (easyRecyclerView != null) {
            easyRecyclerView.setData(list);
        }
        int i12 = f.f77846b[tradeTabsType.ordinal()];
        if (i12 != 1) {
            i11 = (i12 == 2 || i12 == 3) ? G2() ? R.layout.common_empty_search_view_night : R.layout.common_empty_search_view_light : G2() ? R.layout.common_empty_view_night : R.layout.common_empty_view_light;
        } else {
            i11 = G2() ? R.layout.common_empty_collection_view_night : R.layout.common_empty_collection_view_light;
        }
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    this.f77827o.g();
                    return;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                return;
            }
        }
        if (getContext() != null) {
            View inflate = LayoutInflater.from(getContext()).inflate(i11, (ViewGroup) null);
            this.f77827o.setEmptyView(inflate);
            this.f77827o.i();
            bi(inflate);
        }
    }

    public final void bi(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_empty);
        if (textView != null) {
            TradeType Ph = Ph();
            TradeType tradeType = TradeType.CONTRACT;
            if (Ph == tradeType) {
                p039do.a aVar = this.L.get(tradeType);
                if (!(aVar instanceof p039do.d)) {
                    return;
                }
                if (((p039do.d) aVar).G() != 0) {
                    textView.setText(getString(R.string.n_market_contract_no_data_title));
                } else {
                    textView.setText(getString(R.string.n_contract_trade_no_record));
                }
            } else {
                TradeType tradeType2 = TradeType.LINEAR_SWAP;
                if (Ph == tradeType2) {
                    p039do.a aVar2 = this.L.get(tradeType2);
                    if (!(aVar2 instanceof y)) {
                        return;
                    }
                    if (((y) aVar2).I() == 0) {
                        textView.setText(getString(R.string.n_contract_trade_no_record));
                    } else {
                        textView.setText(getString(R.string.n_market_contract_no_data_title));
                    }
                }
            }
        }
    }

    public final void ci(boolean z11) {
        setViewVisible(this.f77828p, z11);
    }

    public void di(boolean z11) {
        this.K = z11;
    }

    public void doContentViewHideAnimation(View view) {
        if (isRunDefaultAnimation()) {
            updateContentViewSize();
            doDefaultHideAnimation(view, getGravity());
            return;
        }
        doDismiss();
    }

    public final void ei(boolean z11) {
        setViewVisible(this.f77832t, z11);
    }

    public final void fi(TextView textView, boolean z11) {
        if (z11) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.trade_arrow_down, 0);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.trade_arrow_up, 0);
        }
    }

    public int getContentViewResId() {
        if (G2()) {
            this.f77821i = R.layout.layout_market_filter_item_night;
            return R.layout.layout_trade_pk_drawer_night;
        }
        this.f77821i = R.layout.layout_market_filter_item_light;
        return R.layout.layout_trade_pk_drawer;
    }

    public int getGravity() {
        return 80;
    }

    public void gg(TradeType tradeType, String str, SafeguardType safeguardType) {
        int i11 = f.f77847c[safeguardType.ordinal()];
        if (i11 == 1) {
            ci(false);
            ei(false);
        } else if (i11 != 2) {
            ci(false);
            ei(true);
        } else {
            ci(!TextUtils.isEmpty(str));
            TextView textView = this.f77829q;
            if (textView != null) {
                textView.setText(str);
            }
            ei(true);
        }
    }

    public void gi(u6.g gVar) {
        this.A = gVar;
    }

    public final void hi(FragmentManager fragmentManager, String str, TradeType tradeType) {
        if (tradeType != null) {
            switch (f.f77845a[tradeType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    break;
                default:
                    tradeType = TradeType.PRO;
                    break;
            }
        } else {
            tradeType = TradeType.PRO;
        }
        Zh(tradeType);
        this.C = tradeType;
        super.show(fragmentManager, str);
    }

    public void ii(FragmentManager fragmentManager, String str, TradeType tradeType, String str2) {
        this.E = str2;
        hi(fragmentManager, str, tradeType);
    }

    public void initView(r rVar) {
        this.f77827o = (LoadingLayout) rVar.b(R.id.id_trade_dialog_loading_layout);
        this.f77835w = (EasyRecyclerView) rVar.b(R.id.id_trade_dialog_recyclerView);
        this.f77828p = rVar.b(R.id.id_incl_trade_drawer_item);
        this.f77829q = (TextView) rVar.b(R.id.safeguard_tv);
        this.f77830r = rVar.b(R.id.single_safeguard_top_divider);
        this.f77831s = rVar.b(R.id.single_safeguard_bottom_divider);
        this.f77832t = rVar.b(R.id.id_trade_dialog_search_layout);
        this.f77833u = (EditText) rVar.b(R.id.id_trade_dialog_search_editText);
        this.f77834v = (ImageView) rVar.b(R.id.id_trade_dialog_search_close);
        this.f77836x = (TextView) rVar.b(R.id.id_trade_dialog_title_tv);
        this.f77837y = rVar.b(R.id.rl_bottom_action_area);
        this.f77838z = rVar.b(R.id.ll_filter_area);
        this.F = rVar.b(R.id.fl_type1);
        this.G = (TextView) rVar.b(R.id.tv_type1);
        this.H = rVar.b(R.id.fl_type2);
        this.I = (TextView) rVar.b(R.id.tv_type2);
        this.f77822j = (TitleLayout) rVar.b(R.id.title_layout_trade_drawer_margin);
        this.f77826n = rVar.b(R.id.ll_dialog_content);
        this.f77817e = (ImageView) rVar.b(R.id.image_view_trade_dialog_filter_arrow_right);
        this.f77818f = (HorizontalScrollView) rVar.b(R.id.horizontal_scroll_view_trade_dialog_filter);
        this.f77814b = rVar.b(R.id.view_trade_dialog_line);
        this.f77815c = (RadioGroup) rVar.b(R.id.radio_group_trade_dialog_filter);
        this.f77816d = (ConstraintLayout) rVar.b(R.id.constrain_layout_trade_dialog_filter_box);
        rVar.b(R.id.iv_close).setOnClickListener(new eo.d(this));
        Sh(this.B);
        this.J = new TradeDialogFilterDialog();
        this.f77823k.clear();
        setDialogDismissListener(new a());
    }

    public boolean isTransparent() {
        return true;
    }

    public final void ji(int i11) {
        this.J.show(getChildFragmentManager(), "mFilterPopup");
    }

    public final void ki() {
        synchronized (this.L) {
            for (Map.Entry<TradeType, p039do.a> value : this.L.entrySet()) {
                p039do.a aVar = (p039do.a) value.getValue();
                if (aVar != null) {
                    aVar.o();
                }
            }
        }
    }

    public final void li() {
        Kh();
        TradeType Ph = Ph();
        this.f77837y.setVisibility(8);
        this.f77838z.setVisibility(8);
        String string = getResources().getString(R.string.n_trade_compare_title);
        boolean z11 = false;
        ei(false);
        this.f77836x.setText(string);
        TextView textView = this.f77836x;
        if (Th() && !TextUtils.isEmpty(string)) {
            z11 = true;
        }
        ViewUtil.m(textView, z11);
        Xh(Ph);
    }

    public String nf() {
        if (this.C == Ph()) {
            return this.E;
        }
        return null;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R.id.id_trade_dialog_search_close) {
            Kh();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onPause() {
        super.onPause();
        i6.d.b("TradeCompareDialogFragment-->onPause-->");
        ki();
    }

    public void onResume() {
        super.onResume();
        i6.d.b("TradeCompareDialogFragment-->onResume-->");
        li();
        HashMap hashMap = new HashMap();
        hashMap.put("TransPair_current_id", nf());
        BaseModuleConfig.a().w("App_markets_contrast_pop_expose", hashMap);
        this.f77824l = null;
        this.f77825m = null;
    }

    public void onTitleChange(int i11) {
        HashMap hashMap = new HashMap();
        if (i11 != 1) {
            hashMap.put("name", getResources().getString(R.string.super_margin));
            is.a.j("5976", hashMap, "1000100");
            TradeType tradeType = TradeType.SUPERMARGIN;
            Zh(tradeType);
            Xh(tradeType);
            return;
        }
        hashMap.put("name", getResources().getString(R.string.trade_margin));
        is.a.j("5976", hashMap, "1000101");
        TradeType tradeType2 = TradeType.MARGIN;
        Zh(tradeType2);
        Xh(tradeType2);
    }

    public void onTitleStatueChange(int i11, boolean z11) {
    }

    public void p7(TradeType tradeType, List<String> list) {
    }

    public void sb(int i11) {
    }

    public boolean useWindowBg() {
        return false;
    }

    public void xa(TradeType tradeType, TradeTabsType tradeTabsType, List<String> list, List<? extends s9.a> list2) {
        i6.d.b("TradeCompareDialogFragment-->onDataObserver--> \ntradeType:" + tradeType + " \ntradeTabsType:" + tradeTabsType + " \ntabList:" + list + " \nlist:" + list2);
        this.O = tradeTabsType;
        if (list2 != null && !list2.isEmpty() && Ph() == tradeType) {
            ArrayList arrayList = new ArrayList(list2);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                s9.a aVar = (s9.a) it2.next();
                if (aVar instanceof ml.d) {
                    ml.d dVar = (ml.d) aVar;
                    if (dVar.o().equals(this.E)) {
                        it2.remove();
                    } else {
                        dVar.H(true);
                        dVar.P(this.E);
                    }
                }
            }
            this.f77826n.setVisibility(0);
            ai(tradeTabsType, arrayList);
        }
    }

    public void y7(int i11) {
    }
}
