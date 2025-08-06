package com.huobi.staring.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.widgets.CommonStatusView;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.staring.bean.CustomPriceResp;
import com.huobi.staring.bean.CustomRuleListResult;
import com.huobi.staring.helper.StaringRemindHelper;
import com.huobi.staring.ui.BaseRemindFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import cs.n;
import d7.a1;
import ds.e;
import ds.f;
import gs.g;
import i6.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import pro.huobi.R;

public class AllRemindNewFragment extends BaseRemindFragment {
    public View A;
    public int B = 1;

    /* renamed from: y  reason: collision with root package name */
    public CustomRuleListResult f81191y;

    /* renamed from: z  reason: collision with root package name */
    public ImageView f81192z;

    public class a extends BaseRemindFragment.e<CustomRuleListResult> {
        public a() {
            super();
        }

        /* renamed from: b */
        public void a(CustomRuleListResult customRuleListResult) {
            CustomRuleListResult unused = AllRemindNewFragment.this.f81191y = customRuleListResult;
        }
    }

    public class b extends BaseRemindFragment.e<CustomRuleListResult> {
        public b() {
            super();
        }

        /* renamed from: b */
        public void a(CustomRuleListResult customRuleListResult) {
            CustomRuleListResult unused = AllRemindNewFragment.this.f81191y = customRuleListResult;
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
            if (AllRemindNewFragment.this.B != 2) {
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

    public AllRemindNewFragment() {
        this.f81227v = false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ int Bi(bs.a aVar, bs.a aVar2) {
        String Ai = Ai(aVar);
        String Ai2 = Ai(aVar2);
        if (Ai == null || Ai2 == null) {
            return 0;
        }
        if (Ai.equalsIgnoreCase(Ai2)) {
            if (this.B == 2) {
                return aVar.e().type - aVar2.e().type;
            }
            return aVar2.e().type - aVar.e().type;
        } else if (this.B == 2) {
            return Ai.compareTo(Ai2);
        } else {
            return Ai2.compareTo(Ai);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ci(View view) {
        int i11 = this.B;
        if (i11 == 1) {
            this.B = 2;
        } else if (i11 != 2) {
            this.B = 1;
        } else {
            this.B = 3;
        }
        Di();
        this.f81222q.l();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
    }

    public final String Ai(bs.a aVar) {
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

    public final void Di() {
        int i11 = this.B;
        if (i11 == 2) {
            this.f81192z.setImageResource(R.drawable.market_selected_up_light);
        } else if (i11 != 3) {
            this.f81192z.setImageResource(R.drawable.market_selected_default);
        } else {
            this.f81192z.setImageResource(R.drawable.market_selected_down_light);
        }
    }

    public void Th(boolean z11) {
        if (z11 && this.f81191y != null) {
            return;
        }
        if (ai()) {
            n.r(this, new a());
        } else {
            StaringRemindHelper.j(this, new b());
        }
    }

    public void afterInit() {
        super.afterInit();
        CommonStatusView commonStatusView = this.f81223r;
        commonStatusView.setEmptyBtnText("+" + getString(R.string.staring_remind_create_now));
    }

    public void initViews() {
        super.initViews();
        this.f81192z = (ImageView) this.f67460i.b(R.id.id_remind_title_symbols_checkbox);
        this.A = this.f67460i.b(R.id.id_remind_title_symbols_tv_parent);
    }

    public void ki(List<bs.a> list) {
        List<CustomPriceResp> customPrice;
        CustomRuleListResult customRuleListResult = this.f81191y;
        if (customRuleListResult != null && (customPrice = customRuleListResult.getCustomPrice()) != null) {
            synchronized (AllRemindNewFragment.class) {
                for (CustomPriceResp next : customPrice) {
                    if (next != null) {
                        list.add(new bs.a(next.getPriceId(), next.getSymbol(), next.getPrice(), 0, next.getDirection(), next.getContractType(), next.getBusinessType(), this.f81229x));
                    }
                }
            }
            int i11 = this.B;
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
                if (ai()) {
                    list.clear();
                    zi(arrayList2, list);
                    zi(arrayList, list);
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

    public void mi(boolean z11) {
        super.mi(z11);
        AllRemindNewActivity allRemindNewActivity = (AllRemindNewActivity) getActivity();
        if (allRemindNewActivity != null) {
            allRemindNewActivity.qh(Xh());
        }
        if (z11) {
            ui(false);
            this.A.setOnClickListener((View.OnClickListener) null);
            this.f81192z.setImageResource(R.drawable.market_selected_default);
            return;
        }
        this.A.setOnClickListener(new e(this));
    }

    public void ni(List<bs.a> list) {
        if (list != null) {
            synchronized (AllRemindNewFragment.class) {
                List<CustomPriceResp> customPrice = this.f81191y.getCustomPrice();
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

    public void oi(int i11) {
        super.oi(i11);
        if (i11 == -1) {
            RemindSearchListActivity.gg(getActivity());
            ui(false);
            HashMap hashMap = new HashMap();
            hashMap.put("Page_name", ai() ? "Me_derivatives" : "Me_spot");
            g.i("Alert_Create_Me_click", hashMap);
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_all_remind, viewGroup, false);
    }

    public final void zi(List<bs.a> list, List<bs.a> list2) {
        Collections.sort(list, new f(this));
        list2.addAll(list);
    }

    public AllRemindNewFragment(boolean z11) {
        super(z11);
        this.f81227v = z11;
    }
}
