package com.huobi.main.trade.ui;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.Partitions;
import com.hbg.lib.widgets.CommonTextListIndicator;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.main.trade.enums.SafeguardType;
import com.huobi.main.trade.enums.TradeTabsType;
import com.huobi.view.TitleLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import eo.a0;
import eo.b0;
import eo.o;
import eo.p;
import eo.q;
import eo.t;
import eo.u;
import eo.v;
import eo.w;
import eo.x;
import i6.n;
import i6.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import p039do.e0;
import p039do.f0;
import p039do.k;
import p039do.s;
import p039do.y;
import p039do.z;
import pro.huobi.R;
import rx.Observable;
import u6.g;

public class TradeDialogFragment extends BaseDialogFragment implements View.OnClickListener, co.b, co.a, TitleLayout.OnTitleListener {
    public EasyRecyclerView A;
    public CommonTextListIndicator B;
    public TextView C;
    public TextView D;
    public TextView E;
    public int F = 0;
    public g G;
    public TradeType H = TradeType.PRO;
    public TradeType I;
    public s9.a J;
    public String K;
    public boolean L;
    public final HashMap<TradeType, p039do.a> M = new HashMap<>();
    public e N;
    public String O;
    public boolean P = true;
    public TradeTabsType Q = TradeTabsType.OTHER;

    /* renamed from: b  reason: collision with root package name */
    public View f77865b;

    /* renamed from: c  reason: collision with root package name */
    public RadioGroup f77866c;

    /* renamed from: d  reason: collision with root package name */
    public ConstraintLayout f77867d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f77868e;

    /* renamed from: f  reason: collision with root package name */
    public HorizontalScrollView f77869f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f77870g;

    /* renamed from: h  reason: collision with root package name */
    public DecelerateInterpolator f77871h = new DecelerateInterpolator();

    /* renamed from: i  reason: collision with root package name */
    public int f77872i;

    /* renamed from: j  reason: collision with root package name */
    public TitleLayout f77873j;

    /* renamed from: k  reason: collision with root package name */
    public List<String> f77874k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public boolean f77875l = false;

    /* renamed from: m  reason: collision with root package name */
    public LoadingLayout f77876m;

    /* renamed from: n  reason: collision with root package name */
    public View f77877n;

    /* renamed from: o  reason: collision with root package name */
    public View f77878o;

    /* renamed from: p  reason: collision with root package name */
    public View f77879p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f77880q;

    /* renamed from: r  reason: collision with root package name */
    public View f77881r;

    /* renamed from: s  reason: collision with root package name */
    public View f77882s;

    /* renamed from: t  reason: collision with root package name */
    public View f77883t;

    /* renamed from: u  reason: collision with root package name */
    public EditText f77884u;

    /* renamed from: v  reason: collision with root package name */
    public ImageView f77885v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f77886w;

    /* renamed from: x  reason: collision with root package name */
    public View f77887x;

    /* renamed from: y  reason: collision with root package name */
    public View f77888y;

    /* renamed from: z  reason: collision with root package name */
    public View f77889z;

    public class a implements View.OnFocusChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f77890b;

        public a(View view) {
            this.f77890b = view;
        }

        public void onFocusChange(View view, boolean z11) {
            if (z11) {
                if (TradeDialogFragment.this.G2()) {
                    this.f77890b.setBackgroundResource(R.drawable.custom_edittext_blue_focused_bg_night);
                } else {
                    this.f77890b.setBackgroundResource(R.drawable.trade_edittext_blue_focused_bg);
                }
                TradeDialogFragment.this.f77886w.setVisibility(0);
            } else {
                if (TradeDialogFragment.this.G2()) {
                    this.f77890b.setBackgroundResource(R.drawable.custom_edittext_normal_bg_night);
                } else {
                    this.f77890b.setBackgroundResource(R.drawable.trade_edittext_normal_bg);
                }
                TradeDialogFragment.this.f77886w.setVisibility(8);
            }
            if (!z11 || !(TradeDialogFragment.this.f77884u.getText() == null || TradeDialogFragment.this.f77884u.getText().length() == 0)) {
                TradeDialogFragment.this.Ei();
            } else {
                TradeDialogFragment.this.Fi();
            }
        }
    }

    public class b implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public String f77892b;

        public b() {
        }

        public void afterTextChanged(Editable editable) {
            String upperCase = editable.toString().toUpperCase(Locale.US);
            if (TextUtils.isEmpty(upperCase) || !upperCase.equals(this.f77892b)) {
                if (!TextUtils.isEmpty(upperCase) || !TradeDialogFragment.this.f77884u.hasFocus()) {
                    TradeDialogFragment.this.Ei();
                } else {
                    TradeDialogFragment.this.Fi();
                }
                this.f77892b = upperCase;
                if (TradeDialogFragment.this.A.getScrollState() != 0) {
                    TradeDialogFragment.this.A.stopScroll();
                }
                i6.d.b("TradeDialogFragment-->TextChanged-->afterTextChanged-->" + this.f77892b);
                if (TradeType.CONTRACT == TradeDialogFragment.this.H) {
                    if (TradeDialogFragment.this.Uh() instanceof p039do.d) {
                        ((p039do.d) TradeDialogFragment.this.Uh()).L(this.f77892b);
                    }
                } else if (TradeType.LINEAR_SWAP == TradeDialogFragment.this.H) {
                    if (TradeDialogFragment.this.Uh() instanceof y) {
                        ((y) TradeDialogFragment.this.Uh()).R(this.f77892b);
                    }
                } else if (TradeType.GRID != TradeDialogFragment.this.H) {
                    k Nh = TradeDialogFragment.this.Wh();
                    if (Nh != null) {
                        Nh.d0(this.f77892b);
                    }
                } else if (TradeDialogFragment.this.Uh() instanceof s) {
                    ((s) TradeDialogFragment.this.Uh()).Z(this.f77892b);
                }
                TradeDialogFragment.this.f77884u.removeTextChangedListener(this);
                TradeDialogFragment.this.f77884u.setText(this.f77892b);
                TradeDialogFragment.this.f77884u.setSelection(this.f77892b.length());
                TradeDialogFragment.this.f77884u.addTextChangedListener(this);
                TradeDialogFragment.this.f77885v.setVisibility(!TextUtils.isEmpty(this.f77892b) ? 0 : 8);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            i6.d.b("TradeDialogFragment-->TextChanged-->beforeTextChanged-->" + charSequence);
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            i6.d.b("TradeDialogFragment-->TextChanged-->onTextChanged-->" + charSequence);
        }
    }

    public class c implements CommonTextListIndicator.b {
        public c() {
        }

        public void a(int i11, View view) {
        }

        public void onItemClick(int i11) {
            if (TradeDialogFragment.this.A.getScrollState() != 0) {
                TradeDialogFragment.this.A.stopScroll();
            }
            if (TradeType.CONTRACT == TradeDialogFragment.this.H) {
                if (TradeDialogFragment.this.Uh() instanceof p039do.d) {
                    ConfigPreferences.k("user_config", "config_home_market_contract_index", i11);
                    ((p039do.d) TradeDialogFragment.this.Uh()).y(i11);
                }
            } else if (TradeType.LINEAR_SWAP == TradeDialogFragment.this.H) {
                if (TradeDialogFragment.this.Uh() instanceof y) {
                    ConfigPreferences.k("user_config", "config_home_market_linear_swap_index", i11);
                    ((y) TradeDialogFragment.this.Uh()).A(i11);
                }
            } else if (TradeType.OPTION != TradeDialogFragment.this.H) {
                if (TradeType.GRID != TradeDialogFragment.this.H) {
                    k Nh = TradeDialogFragment.this.Wh();
                    if (Nh != null && Nh.H() != i11) {
                        if (TradeType.PRO == TradeDialogFragment.this.H) {
                            ConfigPreferences.k("user_config", "config_home_market_index", i11);
                        } else if (TradeType.MARGIN == TradeDialogFragment.this.H) {
                            ConfigPreferences.k("user_config", "config_home_market_margin_index", i11);
                        } else if (TradeType.SUPERMARGIN == TradeDialogFragment.this.H) {
                            ConfigPreferences.k("user_config", "config_home_market_super_margin_index", i11);
                        } else if (TradeType.C2C == TradeDialogFragment.this.H) {
                            ConfigPreferences.k("user_config", "config_home_market_c2c_index", i11);
                        }
                        Nh.C(i11);
                    }
                } else if (TradeDialogFragment.this.Uh() instanceof s) {
                    ConfigPreferences.k("user_config", "config_market_grid_index", i11);
                    ((s) TradeDialogFragment.this.Uh()).E(i11);
                }
            }
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f77895a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f77896b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f77897c;

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
                f77897c = r0
                r1 = 1
                com.huobi.main.trade.enums.SafeguardType r2 = com.huobi.main.trade.enums.SafeguardType.SAFEGUARD_ALL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f77897c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.main.trade.enums.SafeguardType r3 = com.huobi.main.trade.enums.SafeguardType.SAFEGUARD_TIPS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f77897c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.main.trade.enums.SafeguardType r4 = com.huobi.main.trade.enums.SafeguardType.SAFEGUARD_SINGLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f77897c     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.main.trade.enums.SafeguardType r5 = com.huobi.main.trade.enums.SafeguardType.SAFEGUARD_NONE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.huobi.main.trade.enums.TradeTabsType[] r4 = com.huobi.main.trade.enums.TradeTabsType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f77896b = r4
                com.huobi.main.trade.enums.TradeTabsType r5 = com.huobi.main.trade.enums.TradeTabsType.COLLECTION     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r4 = f77896b     // Catch:{ NoSuchFieldError -> 0x004e }
                com.huobi.main.trade.enums.TradeTabsType r5 = com.huobi.main.trade.enums.TradeTabsType.COLLECTION_SEARCH     // Catch:{ NoSuchFieldError -> 0x004e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r4 = f77896b     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.huobi.main.trade.enums.TradeTabsType r5 = com.huobi.main.trade.enums.TradeTabsType.OTHER_SEARCH     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r4 = f77896b     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.huobi.main.trade.enums.TradeTabsType r5 = com.huobi.main.trade.enums.TradeTabsType.OTHER     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                r4 = 5
                int[] r5 = f77896b     // Catch:{ NoSuchFieldError -> 0x006d }
                com.huobi.main.trade.enums.TradeTabsType r6 = com.huobi.main.trade.enums.TradeTabsType.COMPARE     // Catch:{ NoSuchFieldError -> 0x006d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                com.hbg.lib.data.symbol.TradeType[] r5 = com.hbg.lib.data.symbol.TradeType.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f77895a = r5
                com.hbg.lib.data.symbol.TradeType r6 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ NoSuchFieldError -> 0x007e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                int[] r1 = f77895a     // Catch:{ NoSuchFieldError -> 0x0088 }
                com.hbg.lib.data.symbol.TradeType r5 = com.hbg.lib.data.symbol.TradeType.GRID     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
                r1[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0088 }
            L_0x0088:
                int[] r0 = f77895a     // Catch:{ NoSuchFieldError -> 0x0092 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.MARGIN     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                int[] r0 = f77895a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SUPERMARGIN     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f77895a     // Catch:{ NoSuchFieldError -> 0x00a6 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.C2C     // Catch:{ NoSuchFieldError -> 0x00a6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a6 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00a6 }
            L_0x00a6:
                int[] r0 = f77895a     // Catch:{ NoSuchFieldError -> 0x00b1 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x00b1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b1 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b1 }
            L_0x00b1:
                int[] r0 = f77895a     // Catch:{ NoSuchFieldError -> 0x00bc }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x00bc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bc }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00bc }
            L_0x00bc:
                int[] r0 = f77895a     // Catch:{ NoSuchFieldError -> 0x00c8 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.OTC     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                int[] r0 = f77895a     // Catch:{ NoSuchFieldError -> 0x00d4 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.OPTION     // Catch:{ NoSuchFieldError -> 0x00d4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d4 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d4 }
            L_0x00d4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.main.trade.ui.TradeDialogFragment.d.<clinit>():void");
        }
    }

    public interface e {
        void a(TradeType tradeType, s9.a aVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ci(RadioButton radioButton) {
        int scrollX = this.f77869f.getScrollX();
        int left = radioButton.getLeft();
        if (left < scrollX) {
            this.f77869f.smoothScrollBy(left - scrollX, 0);
        }
        int right = radioButton.getRight();
        int measuredWidth = this.f77869f.getMeasuredWidth();
        if (measuredWidth + scrollX < right) {
            this.f77869f.smoothScrollBy((right - scrollX) - measuredWidth, 0);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void di(r rVar, RadioGroup radioGroup, int i11) {
        RadioButton radioButton = (RadioButton) rVar.b(i11);
        if (radioButton != null) {
            radioButton.postDelayed(new p(this, radioButton), 300);
        }
        SensorsDataAutoTrackHelper.trackRadioGroup(radioGroup, i11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ei(View view) {
        HorizontalScrollView horizontalScrollView = this.f77869f;
        if (horizontalScrollView != null) {
            horizontalScrollView.smoothScrollTo(Integer.MAX_VALUE, 0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fi(View view, int i11, int i12, int i13, int i14) {
        if (((view.getScrollX() + view.getWidth()) - view.getPaddingLeft()) - view.getPaddingRight() == this.f77869f.getChildAt(0).getWidth()) {
            Th();
        } else {
            Sh();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void gi(boolean z11) {
        this.B.setCoverViewVisibility(z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ii(String str, CompoundButton compoundButton, boolean z11) {
        if (z11) {
            Wh().Z((Partitions) null);
            ConfigPreferences.k("user_config", "config_trade_dialog_filter_index" + str, this.f77866c.indexOfChild(compoundButton));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ji(Partitions partitions, String str, CompoundButton compoundButton, boolean z11) {
        if (z11) {
            Wh().Z(partitions);
            ConfigPreferences.k("user_config", "config_trade_dialog_filter_index" + str, this.f77866c.indexOfChild(compoundButton));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ki() {
        this.f77867d.setVisibility(0);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void li(View view) {
        int i11 = this.F;
        if (i11 == 0 || i11 == 4 || i11 == 3) {
            this.F = 1;
        } else if (i11 == 1) {
            this.F = 2;
        } else {
            this.F = 0;
        }
        Gi();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void mi(View view) {
        int i11 = this.F;
        if (i11 == 0 || i11 == 2 || i11 == 1) {
            this.F = 3;
        } else if (i11 == 3) {
            this.F = 4;
        } else {
            this.F = 0;
        }
        Gi();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ni(Void voidR) {
        Ph();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void oi() {
        if (Uh().f()) {
            Wh().L();
        } else {
            Fi();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void pi(Void voidR) {
        if (Wh() != null) {
            HuobiToastUtil.v(getString(R.string.n_exchange_left_menu_clear_history_record));
            Wh().E(new a0(this));
        }
    }

    public void Ai(boolean z11) {
        this.f77875l = z11;
    }

    public void Bi(FragmentManager fragmentManager, String str, TradeType tradeType) {
        if (tradeType != null) {
            switch (d.f77895a[tradeType.ordinal()]) {
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
        si(tradeType);
        this.I = tradeType;
        super.show(fragmentManager, str);
    }

    public void Ci(FragmentManager fragmentManager, String str, TradeType tradeType, String str2) {
        this.K = str2;
        Bi(fragmentManager, str, tradeType);
    }

    public void Di(FragmentManager fragmentManager, String str, TradeType tradeType, s9.a aVar) {
        this.J = aVar;
        Bi(fragmentManager, str, tradeType);
    }

    public final void Ei() {
        if (tg.r.x().F0() && Uh() != null) {
            TradeType Vh = Vh();
            if (Vh == TradeType.PRO || Vh == TradeType.MARGIN || Vh == TradeType.SUPERMARGIN) {
                this.f77888y.setVisibility(0);
                this.f77889z.setVisibility(8);
                Uh().m(false);
            }
        }
    }

    public final void Fi() {
        if (tg.r.x().F0() && Uh() != null) {
            TradeType Vh = Vh();
            if (Vh == TradeType.PRO || Vh == TradeType.MARGIN || Vh == TradeType.SUPERMARGIN) {
                this.f77888y.setVisibility(8);
                this.f77889z.setVisibility(0);
                Uh().m(true);
            }
        }
    }

    public boolean G2() {
        return this.L;
    }

    public final void Gi() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            boolean z11 = false;
            if (G2()) {
                int i11 = this.F;
                if (i11 == 1) {
                    z11 = true;
                } else if (i11 == 2) {
                    z11 = true;
                } else if (i11 == 3) {
                    z11 = true;
                } else if (i11 == 4) {
                    z11 = true;
                }
            } else {
                int i12 = this.F;
                if (i12 == 1) {
                    z11 = true;
                } else if (i12 == 2) {
                    z11 = true;
                } else if (i12 == 3) {
                    z11 = true;
                } else if (i12 == 4) {
                    z11 = true;
                }
            }
            if (!(this.D == null || this.E == null)) {
                FragmentActivity activity = getActivity();
                int i13 = R.drawable.ic_filter_normal_night;
                Drawable drawable = activity.getDrawable(z11 ? R.drawable.ic_filter_down : z11 ? R.drawable.ic_filter_up : z11 ? R.drawable.ic_filter_down_night : z11 ? R.drawable.ic_filter_up_night : G2() ? R.drawable.ic_filter_normal_night : R.drawable.ic_filter_normal);
                FragmentActivity activity2 = getActivity();
                if (z11) {
                    i13 = R.drawable.ic_filter_down;
                } else if (z11) {
                    i13 = R.drawable.ic_filter_up;
                } else if (z11) {
                    i13 = R.drawable.ic_filter_down_night;
                } else if (z11) {
                    i13 = R.drawable.ic_filter_up_night;
                } else if (!G2()) {
                    i13 = R.drawable.ic_filter_normal;
                }
                Drawable drawable2 = activity2.getDrawable(i13);
                this.D.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                this.E.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable2, (Drawable) null);
            }
            Uh().n(this.F, true);
            SP.q("Sidebar_" + this.H + this.O, this.F);
        }
    }

    public final void Hi() {
        synchronized (this.M) {
            for (Map.Entry<TradeType, p039do.a> value : this.M.entrySet()) {
                p039do.a aVar = (p039do.a) value.getValue();
                if (aVar != null) {
                    aVar.o();
                }
            }
        }
    }

    public final void Ii() {
        if (this.f77874k.size() == 0) {
            this.f77874k.add(BaseApplication.c(R.string.super_margin));
            this.f77874k.add(BaseApplication.c(R.string.trade_margin));
            this.f77873j.setItemSpace(getResources().getDimensionPixelOffset(R.dimen.dimen_0));
            this.f77873j.setItemPaddingLeft(getResources().getDimensionPixelOffset(R.dimen.dimen_12));
            this.f77873j.setItemPaddingRight(getResources().getDimensionPixelOffset(R.dimen.dimen_6));
            this.f77873j.setNormalTextSize((float) getResources().getDimensionPixelSize(R.dimen.dimen_18));
            this.f77873j.setSelectedTextSize((float) getResources().getDimensionPixelSize(R.dimen.dimen_18));
            if (G2()) {
                this.f77873j.setSelectedColor(getResources().getColor(R.color.global_main_text_color_night));
                this.f77873j.setNormalColor(getResources().getColor(R.color.global_sec_text_color_night));
            } else {
                this.f77873j.setSelectedColor(getResources().getColor(R.color.global_main_text_color_light));
                this.f77873j.setNormalColor(getResources().getColor(R.color.global_sec_text_color_light));
            }
            TradeType Vh = Vh();
            TradeType tradeType = TradeType.SUPERMARGIN;
            if (Vh == tradeType) {
                this.f77873j.setTitles(this.f77874k, 0);
                HashMap hashMap = new HashMap();
                hashMap.put("name", getResources().getString(R.string.super_margin));
                is.a.j("5976", hashMap, "1000100");
                qi(tradeType, Uh() != null ? Uh().f() : false);
            } else {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("name", getResources().getString(R.string.trade_margin));
                is.a.j("5976", hashMap2, "1000101");
                this.f77873j.setTitles(this.f77874k, 1);
                qi(TradeType.MARGIN, Uh() != null ? Uh().f() : false);
            }
            this.f77873j.setVisibility(0);
        }
    }

    public final void Ji() {
        Ph();
        TradeType Vh = Vh();
        String str = null;
        boolean z11 = false;
        boolean z12 = true;
        switch (d.f77895a[Vh.ordinal()]) {
            case 1:
                vi(true);
                yi(true);
                str = getResources().getString(R.string.n_spot);
                break;
            case 2:
                vi(true);
                yi(true);
                str = getResources().getString(R.string.n_grid_grid_strategy);
                break;
            case 3:
            case 4:
                vi(true);
                yi(true);
                Ii();
                break;
            case 5:
                vi(true);
                yi(true);
                str = getResources().getString(R.string.string_c2c_margin);
                break;
            case 6:
                vi(true);
                yi(true);
                str = getResources().getString(R.string.n_market_contract_coin_m);
                break;
            case 7:
                vi(true);
                yi(true);
                str = getResources().getString(R.string.n_linear_swap_usdt_contract_title);
                break;
            case 8:
                vi(false);
                yi(false);
                str = getResources().getString(R.string.legal_toolbar_header_title);
                break;
        }
        this.C.setText(str);
        TextView textView = this.C;
        if (!bi() || TextUtils.isEmpty(str)) {
            z12 = false;
        }
        ViewUtil.m(textView, z12);
        if (Uh() != null) {
            z11 = Uh().f();
        }
        qi(Vh, z11);
    }

    public final void Ph() {
        this.f77884u.setText("");
        this.f77884u.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(this.f77884u.getWindowToken(), 0);
        }
    }

    public final void Qh() {
        this.f77884u.setText("");
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(this.f77884u.getWindowToken(), 0);
        }
    }

    public s9.a R5() {
        if (this.I == Vh()) {
            return this.J;
        }
        return null;
    }

    public final p039do.a Rh(TradeType tradeType) {
        switch (d.f77895a[tradeType.ordinal()]) {
            case 1:
                k kVar = new k(getActivity(), this, Xh());
                kVar.e0(this.f77875l);
                return kVar;
            case 2:
                return new s(getActivity(), this, Xh());
            case 3:
                return new z(getActivity(), this, Xh());
            case 4:
                return new f0(getActivity(), this, Xh());
            case 5:
                return new p039do.b(getActivity(), this, Xh());
            case 6:
                return new p039do.d(getActivity(), this, Xh());
            case 7:
                return new y(getActivity(), this, Xh());
            case 8:
                return new e0(getActivity(), this, Xh());
            default:
                return null;
        }
    }

    public final void Sh() {
        if (!this.f77870g) {
            this.f77870g = true;
            this.f77868e.animate().setInterpolator(this.f77871h).setDuration(300).translationX(0.0f).alpha(1.0f);
        }
    }

    public final void Th() {
        if (this.f77870g) {
            this.f77870g = false;
            this.f77868e.animate().setInterpolator(this.f77871h).setDuration(300).translationX((float) this.f77868e.getWidth()).alpha(0.0f);
        }
    }

    public final p039do.a Uh() {
        return this.M.get(Vh());
    }

    public TradeType Vh() {
        return this.H;
    }

    public final k Wh() {
        p039do.a Uh = Uh();
        if (Uh instanceof k) {
            return (k) Uh;
        }
        return null;
    }

    public final g Xh() {
        return this.G;
    }

    public void Yf(TradeType tradeType, List list) {
        i6.d.b("TradeDialogFragment-->onDataObserver-->" + tradeType + " list:" + list);
        if (Vh() == tradeType) {
            ti(this.Q, list);
        }
    }

    public final void Yh(TradeType tradeType) {
        TextView textView = this.f77880q;
        if (textView != null) {
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.trade_dialog_safeguard_text_color));
            this.f77880q.setBackground(ContextCompat.getDrawable(getContext(), R.color.trade_dialog_safeguard_bg_color));
        }
        int i11 = R.color.trade_dialog_divider_color_light;
        if (G2()) {
            i11 = R.color.trade_dialog_divider_color_night;
        }
        View view = this.f77881r;
        if (view != null) {
            view.setBackground(ContextCompat.getDrawable(getContext(), i11));
        }
        View view2 = this.f77865b;
        if (view2 != null) {
            view2.setBackground(ContextCompat.getDrawable(getContext(), i11));
        }
        View view3 = this.f77882s;
        if (view3 != null) {
            view3.setBackground(ContextCompat.getDrawable(getContext(), i11));
        }
    }

    public final void Zh() {
        TextView textView = this.D;
        if (textView != null && this.E != null) {
            textView.setOnClickListener(new u(this));
            this.E.setOnClickListener(new t(this));
        }
    }

    public void a(TradeType tradeType, s9.a aVar) {
        if (this.N != null) {
            if ((aVar instanceof ml.d) && Wh() != null && this.f77884u.isFocused() && !TextUtils.isEmpty(this.f77884u.getText().toString())) {
                Wh().N((ml.d) aVar);
            }
            int i11 = d.f77895a[Vh().ordinal()];
            if (i11 != 3 && i11 != 4) {
                this.N.a(tradeType, aVar);
            } else if (this.f77873j.getSelectedIndex() == 0) {
                this.N.a(TradeType.SUPERMARGIN, aVar);
            } else {
                this.N.a(TradeType.MARGIN, aVar);
            }
        }
        dismiss();
    }

    public void addEvent(r rVar) {
        this.f77885v.setOnClickListener(this);
        rVar.b(R.id.id_trade_dialog_empty_View).setOnClickListener(this);
        this.f77884u.addTextChangedListener(new b());
        this.B.setCallback(new c());
        this.B.setOnScrollChangeCallback(new eo.z(this));
        RadioGroup radioGroup = this.f77866c;
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new eo.y(this, rVar));
        }
        this.f77868e.setOnClickListener(new o(this));
        HorizontalScrollView horizontalScrollView = this.f77869f;
        if (horizontalScrollView != null && Build.VERSION.SDK_INT >= 23) {
            horizontalScrollView.setOnScrollChangeListener(new v(this));
        }
        TitleLayout titleLayout = this.f77873j;
        if (titleLayout != null) {
            titleLayout.setTitleListener(this);
        }
    }

    public void afterInit() {
    }

    public final boolean ai() {
        TradeType tradeType = this.H;
        return tradeType == TradeType.PRO || tradeType == TradeType.MARGIN || tradeType == TradeType.SUPERMARGIN;
    }

    public boolean bi() {
        return this.P;
    }

    public int getAnimationStyle() {
        return R.style.tradeDialogAnimation;
    }

    public int getContentViewResId() {
        if (G2()) {
            this.f77872i = R.layout.layout_market_filter_item_night;
            return ai() ? R.layout.layout_trade_drawer_night_new : R.layout.layout_trade_drawer_night;
        }
        this.f77872i = R.layout.layout_market_filter_item_light;
        return ai() ? R.layout.layout_trade_drawer_new : R.layout.layout_trade_drawer;
    }

    public int getGravity() {
        return 8388611;
    }

    public void gg(TradeType tradeType, String str, SafeguardType safeguardType) {
        int i11 = d.f77897c[safeguardType.ordinal()];
        if (i11 == 1) {
            wi(false);
            vi(false);
            yi(false);
        } else if (i11 != 2) {
            wi(false);
            vi(true);
            yi(true);
        } else {
            wi(!TextUtils.isEmpty(str));
            TextView textView = this.f77880q;
            if (textView != null) {
                textView.setText(str);
            }
            vi(true);
            yi(true);
        }
    }

    public void initView(r rVar) {
        this.f77876m = (LoadingLayout) rVar.b(R.id.id_trade_dialog_loading_layout);
        this.A = (EasyRecyclerView) rVar.b(R.id.id_trade_dialog_recyclerView);
        this.B = (CommonTextListIndicator) rVar.b(R.id.id_trade_dialog_exchange_tab_MagicIndicator);
        if (G2()) {
            this.B.setTitleViewSelectColor(getResources().getColor(R.color.global_main_text_color_night));
            this.B.setTitleViewNormalColor(getResources().getColor(R.color.global_sec_text_color_night));
        } else {
            this.B.setTitleViewSelectColor(getResources().getColor(R.color.global_main_text_color_light));
            this.B.setTitleViewNormalColor(getResources().getColor(R.color.global_sec_text_color_light));
        }
        this.f77877n = rVar.b(R.id.id_trade_dialog_exchange_tab_layout);
        View b11 = rVar.b(R.id.trade_drawer_content_container);
        this.f77879p = b11;
        ViewGroup.LayoutParams layoutParams = b11.getLayoutParams();
        int g11 = (int) (((double) n.g(getContext())) * 0.76d);
        if (layoutParams != null) {
            layoutParams.width = g11;
        } else {
            layoutParams = new ViewGroup.LayoutParams(g11, -1);
        }
        this.f77879p.setLayoutParams(layoutParams);
        this.f77878o = rVar.b(R.id.id_incl_trade_drawer_item);
        this.f77880q = (TextView) rVar.b(R.id.safeguard_tv);
        this.f77881r = rVar.b(R.id.single_safeguard_top_divider);
        this.f77882s = rVar.b(R.id.single_safeguard_bottom_divider);
        this.f77883t = rVar.b(R.id.id_trade_dialog_search_layout);
        View b12 = rVar.b(R.id.search_container);
        this.f77884u = (EditText) rVar.b(R.id.id_trade_dialog_search_editText);
        ImageView imageView = (ImageView) rVar.b(R.id.id_trade_dialog_search_close);
        this.f77885v = imageView;
        imageView.setVisibility(8);
        TextView textView = (TextView) rVar.b(R.id.tv_list_title_right);
        this.f77888y = rVar.b(R.id.ll_normal_list_title);
        this.f77889z = rVar.b(R.id.ll_search_history_list_title);
        this.f77886w = (TextView) rVar.b(R.id.tv_search_cancel);
        this.f77887x = rVar.b(R.id.iv_search_history_clear);
        this.C = (TextView) rVar.b(R.id.id_trade_dialog_title_tv);
        this.f77873j = (TitleLayout) rVar.b(R.id.title_layout_trade_drawer_margin);
        this.f77868e = (ImageView) rVar.b(R.id.image_view_trade_dialog_filter_arrow_right);
        this.f77869f = (HorizontalScrollView) rVar.b(R.id.horizontal_scroll_view_trade_dialog_filter);
        this.f77865b = rVar.b(R.id.view_trade_dialog_line);
        this.f77866c = (RadioGroup) rVar.b(R.id.radio_group_trade_dialog_filter);
        this.f77867d = (ConstraintLayout) rVar.b(R.id.constrain_layout_trade_dialog_filter_box);
        this.B.setCapitalTitle(false);
        this.D = (TextView) rVar.b(R.id.tvPriceSort);
        this.E = (TextView) rVar.b(R.id.tvChangeSort);
        Zh();
        Yh(this.H);
        this.f77874k.clear();
        if (ai()) {
            textView.setText(AppUtil.b(getString(R.string.n_contract_last_price), " / ", getString(R.string.n_exchange_left_menu_today_rise_fall)));
            this.f77884u.setOnFocusChangeListener(new a(b12));
            Observable<Void> a11 = dw.a.a(this.f77886w);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            a11.throttleFirst(1, timeUnit).subscribe(new eo.r(this));
            dw.a.a(this.f77887x).throttleFirst(1, timeUnit).subscribe(new eo.s(this));
        }
    }

    public boolean isTransparent() {
        return false;
    }

    public String nf() {
        if (this.I == Vh()) {
            return this.K;
        }
        return null;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.id_trade_dialog_empty_View) {
            dismiss();
        } else if (id2 == R.id.id_trade_dialog_search_close) {
            Qh();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onPause() {
        super.onPause();
        i6.d.b("TradeDialogFragment-->onPause-->");
        Hi();
    }

    public void onResume() {
        super.onResume();
        i6.d.b("TradeDialogFragment-->onResume-->");
        Ji();
    }

    public void onTitleChange(int i11) {
        HashMap hashMap = new HashMap();
        boolean z11 = false;
        if (i11 != 1) {
            hashMap.put("name", getResources().getString(R.string.super_margin));
            is.a.j("5976", hashMap, "1000100");
            if (Uh() != null) {
                z11 = Uh().f();
            }
            TradeType tradeType = TradeType.SUPERMARGIN;
            si(tradeType);
            qi(tradeType, z11);
            return;
        }
        hashMap.put("name", getResources().getString(R.string.trade_margin));
        is.a.j("5976", hashMap, "1000101");
        if (Uh() != null) {
            z11 = Uh().f();
        }
        TradeType tradeType2 = TradeType.MARGIN;
        si(tradeType2);
        qi(tradeType2, z11);
    }

    public void onTitleStatueChange(int i11, boolean z11) {
    }

    public void p7(TradeType tradeType, List<String> list) {
        List<String> list2 = this.B.getList();
        if (!(list2 == null || list == null || list.size() == 0 || list2.size() != list.size())) {
            int i11 = 0;
            boolean z11 = false;
            while (true) {
                if (i11 >= list2.size()) {
                    break;
                }
                if (list2.get(i11) != null || list.get(i11) != null) {
                    if (list2.get(i11) == null && list.get(i11) != null) {
                        z11 = true;
                        break;
                    } else if (!list2.get(i11).equals(list.get(i11))) {
                        z11 = true;
                    }
                }
                i11++;
            }
            if (!z11) {
                return;
            }
        }
        if (tradeType == Vh()) {
            this.B.setDataList(list);
        }
    }

    public final void qi(TradeType tradeType, boolean z11) {
        synchronized (this.M) {
            if (!this.M.containsKey(tradeType)) {
                p039do.a Rh = Rh(tradeType);
                this.M.put(tradeType, Rh);
                Rh.m(z11);
            } else {
                this.M.get(tradeType).m(z11);
            }
            for (Map.Entry next : this.M.entrySet()) {
                TradeType tradeType2 = (TradeType) next.getKey();
                p039do.a aVar = (p039do.a) next.getValue();
                if (tradeType == tradeType2 && aVar != null) {
                    if (!(aVar instanceof f0)) {
                        if (!(aVar instanceof z)) {
                            aVar.k();
                        }
                    }
                    if (!TextUtils.isEmpty(this.f77884u.getText())) {
                        ((k) aVar).d0(this.f77884u.getText().toString());
                    }
                    ((k) aVar).W();
                }
            }
        }
    }

    public void ri(e eVar) {
        this.N = eVar;
    }

    public void sb(int i11) {
        if (TradeType.PRO == this.H) {
            this.f77866c.removeAllViews();
            List<String> list = this.B.getList();
            if (list.size() != 0 && i11 < list.size()) {
                String str = list.get(i11);
                List<Partitions> C2 = a1.v().C(str);
                int size = C2.size();
                if (C2.size() == 0 || i11 > list.size()) {
                    this.f77867d.post(new q(Wh()));
                    if (this.f77867d.getVisibility() != 8) {
                        this.f77866c.removeAllViews();
                        this.f77867d.setVisibility(8);
                    }
                } else if (this.f77866c != null) {
                    RadioButton radioButton = (RadioButton) LayoutInflater.from(getActivity()).inflate(this.f77872i, (ViewGroup) null);
                    radioButton.setText(getResources().getString(R.string.market_title_table_all));
                    RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    if (ai()) {
                        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.dimen_12);
                    } else {
                        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.dimen_15);
                    }
                    this.f77866c.addView(radioButton, layoutParams);
                    radioButton.setOnCheckedChangeListener(new x(this, str));
                    int i12 = 0;
                    for (int i13 = 0; i13 < size; i13++) {
                        Partitions partitions = C2.get(i13);
                        RadioButton radioButton2 = (RadioButton) LayoutInflater.from(getActivity()).inflate(this.f77872i, (ViewGroup) null);
                        radioButton2.setText(partitions.getName());
                        RadioGroup.LayoutParams layoutParams2 = new RadioGroup.LayoutParams(-2, -2);
                        layoutParams2.gravity = 16;
                        layoutParams2.leftMargin = getResources().getDimensionPixelSize(R.dimen.dimen_8);
                        if (i13 == size - 1) {
                            layoutParams2.rightMargin = getResources().getDimensionPixelOffset(R.dimen.dimen_15);
                        }
                        this.f77866c.addView(radioButton2, layoutParams2);
                        radioButton2.setOnCheckedChangeListener(new w(this, partitions, str));
                    }
                    int g11 = ConfigPreferences.g("user_config", "config_trade_dialog_filter_index" + str, 0);
                    if (g11 >= 0 && g11 < size) {
                        i12 = g11;
                    }
                    View childAt = this.f77866c.getChildAt(i12);
                    if (childAt instanceof RadioButton) {
                        ((RadioButton) childAt).setChecked(true);
                    }
                    if (this.f77867d.getVisibility() != 0) {
                        this.f77867d.postDelayed(new b0(this), 200);
                    }
                } else if (this.f77867d.getVisibility() != 8) {
                    this.f77866c.removeAllViews();
                    this.f77867d.setVisibility(8);
                }
            }
        }
    }

    public final void si(TradeType tradeType) {
        this.H = tradeType;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0038, code lost:
        if (G2() != false) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0052, code lost:
        if (G2() != false) goto L_0x0072;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0074 A[SYNTHETIC, Splitter:B:33:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0087 A[Catch:{ Exception -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ti(com.huobi.main.trade.enums.TradeTabsType r4, java.util.List<? extends s9.a> r5) {
        /*
            r3 = this;
            com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView r0 = r3.A
            if (r0 == 0) goto L_0x0007
            r0.setData(r5)
        L_0x0007:
            do.a r0 = r3.Uh()
            r1 = 2131624308(0x7f0e0174, float:1.8875792E38)
            r2 = 2131624307(0x7f0e0173, float:1.887579E38)
            if (r0 == 0) goto L_0x003d
            do.a r0 = r3.Uh()
            boolean r0 = r0.f()
            if (r0 == 0) goto L_0x003d
            if (r5 == 0) goto L_0x002d
            int r4 = r5.size()
            if (r4 != 0) goto L_0x0026
            goto L_0x002d
        L_0x0026:
            android.view.View r4 = r3.f77887x
            r0 = 0
            r4.setVisibility(r0)
            goto L_0x0034
        L_0x002d:
            android.view.View r4 = r3.f77887x
            r0 = 8
            r4.setVisibility(r0)
        L_0x0034:
            boolean r4 = r3.G2()
            if (r4 == 0) goto L_0x003b
            goto L_0x0072
        L_0x003b:
            r1 = r2
            goto L_0x0072
        L_0x003d:
            int[] r0 = com.huobi.main.trade.ui.TradeDialogFragment.d.f77896b
            int r4 = r4.ordinal()
            r4 = r0[r4]
            r0 = 1
            if (r4 == r0) goto L_0x0064
            r0 = 2
            if (r4 == r0) goto L_0x0055
            r0 = 3
            if (r4 == r0) goto L_0x0055
            boolean r4 = r3.G2()
            if (r4 == 0) goto L_0x003b
            goto L_0x0072
        L_0x0055:
            boolean r4 = r3.G2()
            if (r4 == 0) goto L_0x005f
            r4 = 2131624303(0x7f0e016f, float:1.8875782E38)
            goto L_0x0062
        L_0x005f:
            r4 = 2131624302(0x7f0e016e, float:1.887578E38)
        L_0x0062:
            r1 = r4
            goto L_0x0072
        L_0x0064:
            boolean r4 = r3.G2()
            if (r4 == 0) goto L_0x006e
            r4 = 2131624298(0x7f0e016a, float:1.8875772E38)
            goto L_0x0062
        L_0x006e:
            r4 = 2131624297(0x7f0e0169, float:1.887577E38)
            goto L_0x0062
        L_0x0072:
            if (r5 == 0) goto L_0x0081
            boolean r4 = r5.isEmpty()     // Catch:{ Exception -> 0x00a2 }
            if (r4 == 0) goto L_0x007b
            goto L_0x0081
        L_0x007b:
            com.hbg.lib.widgets.LoadingLayout r4 = r3.f77876m     // Catch:{ Exception -> 0x00a2 }
            r4.g()     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00a6
        L_0x0081:
            android.content.Context r4 = r3.getContext()     // Catch:{ Exception -> 0x00a2 }
            if (r4 == 0) goto L_0x00a6
            android.content.Context r4 = r3.getContext()     // Catch:{ Exception -> 0x00a2 }
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)     // Catch:{ Exception -> 0x00a2 }
            r5 = 0
            android.view.View r4 = r4.inflate(r1, r5)     // Catch:{ Exception -> 0x00a2 }
            com.hbg.lib.widgets.LoadingLayout r5 = r3.f77876m     // Catch:{ Exception -> 0x00a2 }
            r5.setEmptyView(r4)     // Catch:{ Exception -> 0x00a2 }
            com.hbg.lib.widgets.LoadingLayout r5 = r3.f77876m     // Catch:{ Exception -> 0x00a2 }
            r5.i()     // Catch:{ Exception -> 0x00a2 }
            r3.ui(r4)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00a6
        L_0x00a2:
            r4 = move-exception
            r4.printStackTrace()
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.main.trade.ui.TradeDialogFragment.ti(com.huobi.main.trade.enums.TradeTabsType, java.util.List):void");
    }

    public final void ui(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_empty);
        if (textView != null) {
            TradeType Vh = Vh();
            if (Uh() == null || !Uh().f()) {
                TradeType tradeType = TradeType.CONTRACT;
                if (Vh == tradeType) {
                    p039do.a aVar = this.M.get(tradeType);
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
                    if (Vh == tradeType2) {
                        p039do.a aVar2 = this.M.get(tradeType2);
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
            } else {
                textView.setText(getString(R.string.n_exchange_left_menu_no_data));
            }
        }
    }

    public void vi(boolean z11) {
        setViewVisible(this.f77877n, z11);
    }

    public final void wi(boolean z11) {
        setViewVisible(this.f77878o, z11);
    }

    public void xa(TradeType tradeType, TradeTabsType tradeTabsType, List<String> list, List<? extends s9.a> list2) {
        i6.d.b("TradeDialogFragment-->onDataObserver--> \ntradeType:" + tradeType + " \ntradeTabsType:" + tradeTabsType + " \ntabList:" + list + " \nlist:" + list2);
        this.Q = tradeTabsType;
        if (Vh() == tradeType) {
            if (this.A.getScrollState() == 0) {
                ti(tradeTabsType, list2);
            } else {
                i6.d.b("TradeDialogFragment-->onDataObserver--> 列表正在滑动");
            }
        }
        p7(tradeType, list);
    }

    public void xi(boolean z11) {
        this.L = z11;
    }

    public void y7(int i11) {
        this.B.c(i11);
        this.B.b(i11, 0.0f, 0);
        if (TradeType.PRO == this.H) {
            sb(i11);
        }
        this.F = 0;
        Gi();
    }

    public final void yi(boolean z11) {
        setViewVisible(this.f77883t, z11);
    }

    public void zi(g gVar) {
        this.G = gVar;
    }
}
