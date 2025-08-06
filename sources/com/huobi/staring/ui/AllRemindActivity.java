package com.huobi.staring.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.contract.core.util.RemindContractType;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.widgets.CommonStatusView;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.staring.bean.CustomPriceResp;
import com.huobi.staring.bean.CustomRuleListResult;
import com.huobi.staring.helper.StaringRemindHelper;
import com.huobi.staring.ui.BaseRemindActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import cs.n;
import d7.a1;
import gs.g;
import i6.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import pro.huobi.R;

public class AllRemindActivity extends BaseRemindActivity {

    /* renamed from: v  reason: collision with root package name */
    public static final Object f81173v = new Object();

    /* renamed from: r  reason: collision with root package name */
    public CustomRuleListResult f81174r;

    /* renamed from: s  reason: collision with root package name */
    public ImageView f81175s;

    /* renamed from: t  reason: collision with root package name */
    public View f81176t;

    /* renamed from: u  reason: collision with root package name */
    public int f81177u = 1;

    public class a extends BaseRemindActivity.e<CustomRuleListResult> {
        public a() {
            super();
        }

        /* renamed from: b */
        public void a(CustomRuleListResult customRuleListResult) {
            CustomRuleListResult unused = AllRemindActivity.this.f81174r = customRuleListResult;
        }
    }

    public class b extends BaseRemindActivity.e<CustomRuleListResult> {
        public b() {
            super();
        }

        /* renamed from: b */
        public void a(CustomRuleListResult customRuleListResult) {
            CustomRuleListResult unused = AllRemindActivity.this.f81174r = customRuleListResult;
        }
    }

    public class c implements Comparator<bs.a> {
        public c() {
        }

        /* renamed from: a */
        public int compare(bs.a aVar, bs.a aVar2) {
            String i11 = aVar.i();
            String i12 = aVar2.i();
            String n11 = a1.v().n(i11);
            String n12 = a1.v().n(i12);
            if (AllRemindActivity.this.f81177u != 2) {
                int compareTo = n12.compareTo(n11);
                if (compareTo != 0) {
                    return compareTo;
                }
                return a1.v().D(i12).compareTo(a1.v().D(i11));
            }
            int compareTo2 = n11.compareTo(n12);
            if (compareTo2 != 0) {
                return compareTo2;
            }
            return a1.v().D(i11).compareTo(a1.v().D(i12));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ int hi(bs.a aVar, bs.a aVar2) {
        String gi2 = gi(aVar);
        String gi3 = gi(aVar2);
        if (gi2 == null || gi3 == null) {
            return 0;
        }
        if (gi2.equalsIgnoreCase(gi3)) {
            if (this.f81177u == 2) {
                return aVar.e().type - aVar2.e().type;
            }
            return aVar2.e().type - aVar.e().type;
        } else if (this.f81177u == 2) {
            return gi2.compareTo(gi3);
        } else {
            return gi3.compareTo(gi2);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ii(View view) {
        int i11 = this.f81177u;
        if (i11 == 1) {
            this.f81177u = 2;
        } else if (i11 != 2) {
            this.f81177u = 1;
        } else {
            this.f81177u = 3;
        }
        ki();
        this.f81201g.l();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void ji(Activity activity, RemindContractType remindContractType, RemindBusinessType remindBusinessType) {
        if (activity != null) {
            Intent intent = new Intent(activity, AllRemindActivity.class);
            if (remindContractType != null) {
                intent.putExtra("PARAM_CONTRACT_TYPE", remindContractType.toString());
            }
            if (remindBusinessType != null) {
                intent.putExtra("PARAM_BUSINESS_TYPE", remindBusinessType.toString());
            }
            activity.startActivityForResult(intent, 255);
        }
    }

    public void Ph(List<bs.a> list) {
        List<CustomPriceResp> customPrice;
        CustomRuleListResult customRuleListResult = this.f81174r;
        if (customRuleListResult != null && (customPrice = customRuleListResult.getCustomPrice()) != null) {
            synchronized (f81173v) {
                for (CustomPriceResp next : customPrice) {
                    if (next != null) {
                        list.add(new bs.a(next.getPriceId(), next.getSymbol(), next.getPrice(), 0, next.getDirection(), next.getContractType(), next.getBusinessType(), this.f81211q));
                    }
                }
            }
            int i11 = this.f81177u;
            if (i11 == 2 || i11 == 3) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (bs.a next2 : list) {
                    String i12 = next2.i();
                    if (TextUtils.isEmpty(i12) || m.l0(i12.substring(0, 1), -1) <= 0) {
                        arrayList2.add(next2);
                    } else {
                        arrayList.add(next2);
                    }
                }
                if (Ch()) {
                    list.clear();
                    fi(arrayList2, list);
                    fi(arrayList, list);
                    return;
                }
                Collections.sort(arrayList, new c());
                Collections.sort(arrayList2, new c());
                list.clear();
                list.addAll(arrayList2);
                list.addAll(arrayList);
            }
        }
    }

    public void Rh() {
        super.Rh();
        is.a.i("3114", (Map<String, Object>) null);
    }

    public void Sh(boolean z11) {
        super.Sh(z11);
        if (this.f81201g.i()) {
            Wh(false);
            this.f81176t.setOnClickListener((View.OnClickListener) null);
            this.f81175s.setImageResource(R.drawable.market_selected_default);
            return;
        }
        this.f81176t.setOnClickListener(new ds.a(this));
    }

    public void Th(List<bs.a> list) {
        if (list != null) {
            synchronized (f81173v) {
                List<CustomPriceResp> customPrice = this.f81174r.getCustomPrice();
                HashSet hashSet = new HashSet();
                for (int i11 = 0; i11 < list.size(); i11++) {
                    bs.a aVar = list.get(i11);
                    if (aVar != null) {
                        Iterator<CustomPriceResp> it2 = customPrice.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                CustomPriceResp next = it2.next();
                                if (next != null && aVar.h() == next.getPriceId()) {
                                    hashSet.add(next);
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
                customPrice.removeAll(hashSet);
            }
        }
    }

    public void Uh(int i11) {
        super.Uh(i11);
        if (i11 == -1) {
            setResult(-1);
            finish();
            HashMap hashMap = new HashMap();
            hashMap.put("Page_name", "Markets");
            g.i("Alert_Create_Me_click", hashMap);
        }
    }

    public void addEvent() {
        super.addEvent();
    }

    public void afterInit() {
        super.afterInit();
        CommonStatusView commonStatusView = this.f81202h;
        commonStatusView.setEmptyBtnText("+" + getString(R.string.staring_remind_create_now));
        Intent intent = getIntent();
        intent.getStringExtra("PARAM_CONTRACT_TYPE");
        String stringExtra = intent.getStringExtra("PARAM_BUSINESS_TYPE");
        if (stringExtra != null) {
            this.f81209o = RemindBusinessType.valueOf(stringExtra);
        }
    }

    public final void fi(List<bs.a> list, List<bs.a> list2) {
        Collections.sort(list, new ds.b(this));
        list2.addAll(list);
    }

    public int getContentView() {
        return R.layout.activity_all_remind;
    }

    public final String gi(bs.a aVar) {
        LinearSwapContractInfo n11;
        String i11 = aVar.i();
        if (aVar.b() == RemindBusinessType.CONTRACT) {
            ContractCurrencyInfo b11 = ContractCurrencyUtils.b(i11);
            if (b11 != null) {
                return b11.getSymbol();
            }
            return null;
        } else if (aVar.b() == RemindBusinessType.SWAP) {
            SwapCurrencyInfo c11 = SwapCurrencyInfoController.k().c(i11);
            if (c11 != null) {
                return c11.getSymbol();
            }
            return null;
        } else if (aVar.b() != RemindBusinessType.LINEAR_SWAP || (n11 = LinearSwapCurrencyInfoController.l().n(i11)) == null) {
            return null;
        } else {
            return n11.getSymbol();
        }
    }

    public void initView() {
        super.initView();
        this.f81175s = (ImageView) this.viewFinder.b(R.id.id_remind_title_symbols_checkbox);
        this.f81176t = this.viewFinder.b(R.id.id_remind_title_symbols_tv_parent);
    }

    public final void ki() {
        int i11 = this.f81177u;
        if (i11 == 2) {
            this.f81175s.setImageResource(R.drawable.market_selected_up_light);
        } else if (i11 != 3) {
            this.f81175s.setImageResource(R.drawable.market_selected_default);
        } else {
            this.f81175s.setImageResource(R.drawable.market_selected_down_light);
        }
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public void xh() {
        if (Ch()) {
            n.r(this, new a());
        } else {
            StaringRemindHelper.j(this, new b());
        }
    }
}
