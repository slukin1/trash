package com.huobi.finance.presenter;

import androidx.annotation.Keep;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.page.SmartRefreshPageSplitter;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapFinancialRecord;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.finance.api.FinanceService;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.finance.bean.TransferOrderHistory;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import rx.Observable;
import rx.functions.Func1;
import tq.p;
import u6.g;
import vk.m;
import vk.t;

public class CurrencyHistoryPresenter extends ActivityPresenter<e> {

    /* renamed from: a  reason: collision with root package name */
    public SmartRefreshPageSplitter<?> f45538a;

    /* renamed from: b  reason: collision with root package name */
    public String f45539b;

    /* renamed from: c  reason: collision with root package name */
    public String f45540c;

    /* renamed from: d  reason: collision with root package name */
    public String f45541d = FinanceRecordItem.TYPE_DEPOSIT_VIRTUAL_COMMON_FAST;

    /* renamed from: e  reason: collision with root package name */
    public String f45542e;

    /* renamed from: f  reason: collision with root package name */
    public String f45543f;

    /* renamed from: g  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<FinanceRecordItem> f45544g = new a();

    /* renamed from: h  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<m> f45545h = new b();

    /* renamed from: i  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<t> f45546i = new c();

    /* renamed from: j  reason: collision with root package name */
    public SmartRefreshPageSplitter.c<TransferOrderHistory> f45547j = new d();

    public class a implements SmartRefreshPageSplitter.c<FinanceRecordItem> {
        public a() {
        }

        public Func1<? super FinanceRecordItem, ? extends Long> a() {
            return v3.f46145b;
        }

        public Observable<List<FinanceRecordItem>> c() {
            MapParamsBuilder a11 = MapParamsBuilder.c().a("size", 10).a("types", CurrencyHistoryPresenter.this.f45541d).a(DevicePublicKeyStringDef.DIRECT, "next");
            if (CurrencyHistoryPresenter.this.f45539b != null) {
                a11.a(FirebaseAnalytics.Param.CURRENCY, CurrencyHistoryPresenter.this.f45539b.toLowerCase(Locale.US));
            }
            return CurrencyHistoryPresenter.this.a0(a11.b());
        }

        /* renamed from: f */
        public Observable<List<FinanceRecordItem>> b(FinanceRecordItem financeRecordItem) {
            MapParamsBuilder a11 = MapParamsBuilder.c().a("size", 10).a(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "next").a("types", CurrencyHistoryPresenter.this.f45541d).a("from", Long.valueOf(financeRecordItem.getId()));
            if (CurrencyHistoryPresenter.this.f45539b != null) {
                a11.a(FirebaseAnalytics.Param.CURRENCY, CurrencyHistoryPresenter.this.f45539b.toLowerCase(Locale.US));
            }
            return CurrencyHistoryPresenter.this.a0(a11.b());
        }
    }

    public class b implements SmartRefreshPageSplitter.c<m> {

        /* renamed from: a  reason: collision with root package name */
        public int f45549a = 1;

        public b() {
        }

        public Func1<? super m, ? extends Long> a() {
            return x3.f46172b;
        }

        public Observable<List<m>> c() {
            this.f45549a = 1;
            return f();
        }

        public final Observable<List<m>> f() {
            return v7.b.a().requestCopyTradingTransferRecord(CurrencyHistoryPresenter.this.f45541d == null ? null : Integer.valueOf(CurrencyHistoryPresenter.this.f45541d), this.f45549a, 10).b().compose(RxJavaHelper.t((g) CurrencyHistoryPresenter.this.getUI())).flatMap(w3.f46159b).map(y3.f46188b).toList();
        }

        /* renamed from: i */
        public Observable<List<m>> b(m mVar) {
            this.f45549a++;
            return f();
        }
    }

    public class c implements SmartRefreshPageSplitter.c<t> {

        /* renamed from: a  reason: collision with root package name */
        public int f45551a = 1;

        public class a implements Func1<LinearSwapFinancialRecord.FinancialRecord, t> {
            public a() {
            }

            /* renamed from: a */
            public t call(LinearSwapFinancialRecord.FinancialRecord financialRecord) {
                return new t(financialRecord);
            }
        }

        public class b implements Func1<LinearSwapFinancialRecord, Observable<LinearSwapFinancialRecord.FinancialRecord>> {
            public b() {
            }

            /* renamed from: a */
            public Observable<LinearSwapFinancialRecord.FinancialRecord> call(LinearSwapFinancialRecord linearSwapFinancialRecord) {
                return Observable.from(linearSwapFinancialRecord.getTransferRecordList());
            }
        }

        public c() {
        }

        public static /* synthetic */ Boolean h(LinearSwapFinancialRecord linearSwapFinancialRecord) {
            return Boolean.valueOf((linearSwapFinancialRecord == null || linearSwapFinancialRecord.getTransferRecordList() == null) ? false : true);
        }

        public Func1<? super t, ? extends Long> a() {
            return a4.f45800b;
        }

        public Observable<List<t>> c() {
            this.f45551a = 1;
            return f();
        }

        public final Observable<List<t>> f() {
            return h8.a.a().i0(StringUtils.i(CurrencyHistoryPresenter.this.f45539b), Integer.parseInt(CurrencyHistoryPresenter.this.f45541d), this.f45551a, 10).b().filter(z3.f46201b).flatMap(new b()).map(new a()).toList();
        }

        /* renamed from: i */
        public Observable<List<t>> b(t tVar) {
            this.f45551a++;
            return f();
        }
    }

    public class d implements SmartRefreshPageSplitter.c<TransferOrderHistory> {
        public d() {
        }

        public Func1<? super TransferOrderHistory, ? extends Long> a() {
            return b4.f45815b;
        }

        public Observable<List<TransferOrderHistory>> c() {
            return CurrencyHistoryPresenter.this.c0(MapParamsBuilder.c().a("size", 10).a(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "next").a("types", CurrencyHistoryPresenter.this.f45541d).a("symbol", CurrencyHistoryPresenter.this.f45540c).b());
        }

        /* renamed from: f */
        public Observable<List<TransferOrderHistory>> b(TransferOrderHistory transferOrderHistory) {
            return CurrencyHistoryPresenter.this.c0(MapParamsBuilder.c().a("size", 10).a(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "next").a("types", CurrencyHistoryPresenter.this.f45541d).a("symbol", CurrencyHistoryPresenter.this.f45540c).a("from", Long.valueOf(transferOrderHistory.getId())).b());
        }
    }

    public interface e extends SmartRefreshPageSplitter.d {
        void q2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d0(Object obj) {
        this.f45538a.B();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ FinanceRecordItem g0(FinanceRecordItem financeRecordItem) {
        if (financeRecordItem != null && "3".equals(this.f45542e)) {
            financeRecordItem.setLayoutType(1);
        }
        return financeRecordItem;
    }

    public String Y() {
        return this.f45542e;
    }

    public List<String> Z() {
        ArrayList arrayList = new ArrayList();
        String str = this.f45543f;
        if (str != null) {
            str.hashCode();
            char c11 = 65535;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 52:
                    if (str.equals("4")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 54:
                    if (str.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL)) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 55:
                    if (str.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP)) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 56:
                    if (str.equals("8")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 57:
                    if (str.equals("9")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 1567:
                    if (str.equals(CouponReturn.TYPE_EXPERIENCE)) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 1568:
                    if (str.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP)) {
                        c11 = 8;
                        break;
                    }
                    break;
                case 1569:
                    if (str.equals("12")) {
                        c11 = 9;
                        break;
                    }
                    break;
                case 1570:
                    if (str.equals(BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT)) {
                        c11 = 10;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    arrayList.add(getString(R.string.otc_balance_detail_history_type_all));
                    arrayList.add(getString(R.string.n_transfer_from_otc));
                    arrayList.add(getString(R.string.n_transfer_to_otc));
                    break;
                case 1:
                    arrayList.add(getString(R.string.otc_balance_detail_history_type_all));
                    arrayList.add(getString(R.string.n_transfer_from_isolate_margin));
                    arrayList.add(getString(R.string.n_transfer_to_isolated_margin));
                    break;
                case 2:
                    arrayList.add(getString(R.string.otc_balance_detail_history_type_all));
                    arrayList.add(getString(R.string.n_balance_contract_to_pro));
                    arrayList.add(getString(R.string.n_balance_pro_to_contract));
                    break;
                case 3:
                    arrayList.add(getString(R.string.otc_balance_detail_history_type_all));
                    arrayList.add(getString(R.string.n_transfer_from_supper_margin));
                    arrayList.add(getString(R.string.n_transfer_to_supper_margin));
                    break;
                case 4:
                    arrayList.add(getString(R.string.otc_balance_detail_history_type_all));
                    arrayList.add(getString(R.string.n_balance_swap_to_pro));
                    arrayList.add(getString(R.string.n_balance_pro_to_swap));
                    break;
                case 5:
                    arrayList.add(getString(R.string.otc_balance_detail_history_type_all));
                    arrayList.add(getString(R.string.n_transfer_from_c2c_margin));
                    arrayList.add(getString(R.string.n_transfer_to_c2c_margin));
                    break;
                case 6:
                    arrayList.add(getString(R.string.otc_balance_detail_history_type_all));
                    arrayList.add(getString(R.string.n_transfer_from_mine));
                    arrayList.add(getString(R.string.n_transfer_to_mine));
                    break;
                case 7:
                    arrayList.add(getString(R.string.otc_balance_detail_history_type_all));
                    arrayList.add(getString(R.string.n_balance_pro_to_option));
                    arrayList.add(getString(R.string.n_balance_option_to_pro));
                    break;
                case 8:
                    arrayList.add(getString(R.string.otc_balance_detail_history_type_all));
                    arrayList.add(getString(R.string.n_balance_pro_to_linear_swap_usdt));
                    arrayList.add(getString(R.string.n_balance_linear_swap_usdt_to_pro));
                    arrayList.add(getString(R.string.n_balance_linear_swap_usdt_account_to_linear_swap_account));
                    break;
                case 9:
                    arrayList.add(getString(R.string.otc_balance_detail_history_type_all));
                    arrayList.add(getString(R.string.n_balance_otc_option_to_pro));
                    arrayList.add(getString(R.string.n_balance_pro_to_otc_option));
                    break;
                case 10:
                    arrayList.add(getString(R.string.otc_balance_detail_history_type_all));
                    arrayList.add(getString(R.string.n_transfer_record_future_to_follower));
                    arrayList.add(getString(R.string.transfer_spot_to_copy_trading));
                    arrayList.add(getString(R.string.n_transfer_record_follower_to_future));
                    arrayList.add(getString(R.string.transfer_copy_trading_to_spot));
                    break;
                default:
                    arrayList.add(getString(R.string.otc_balance_detail_history_type_all));
                    arrayList.add(getString(R.string.n_transfer_from_otc));
                    arrayList.add(getString(R.string.n_transfer_to_otc));
                    break;
            }
        } else {
            arrayList.add(getString(R.string.otc_balance_detail_history_type_all));
            arrayList.add(getString(R.string.n_transfer_from_otc));
            arrayList.add(getString(R.string.n_transfer_to_otc));
        }
        return arrayList;
    }

    public final Observable<List<FinanceRecordItem>> a0(Map<String, Object> map) {
        return ((FinanceService) p.W(FinanceService.class)).queryAllFinances(map).compose(p.a0()).flatMap(u3.f46131b).map(new t3(this)).toList();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        return r14;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b0(int r14) {
        /*
            r13 = this;
            java.lang.String r0 = r13.f45543f
            java.lang.String r1 = "pro-to-otc"
            java.lang.String r2 = "otc-to-pro,pro-to-otc"
            java.lang.String r3 = "otc-to-pro"
            r4 = 2
            r5 = 1
            if (r0 == 0) goto L_0x0144
            r0.hashCode()
            r6 = -1
            int r7 = r0.hashCode()
            r8 = 4
            java.lang.String r9 = "4"
            java.lang.String r10 = "3"
            java.lang.String r11 = "2"
            r12 = 3
            switch(r7) {
                case 50: goto L_0x0094;
                case 51: goto L_0x008b;
                case 52: goto L_0x0082;
                case 54: goto L_0x0077;
                case 55: goto L_0x006c;
                case 56: goto L_0x0061;
                case 57: goto L_0x0056;
                case 1567: goto L_0x004b;
                case 1568: goto L_0x003d;
                case 1569: goto L_0x002f;
                case 1570: goto L_0x0021;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x009c
        L_0x0021:
            java.lang.String r7 = "13"
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x002b
            goto L_0x009c
        L_0x002b:
            r6 = 10
            goto L_0x009c
        L_0x002f:
            java.lang.String r7 = "12"
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x0039
            goto L_0x009c
        L_0x0039:
            r6 = 9
            goto L_0x009c
        L_0x003d:
            java.lang.String r7 = "11"
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x0047
            goto L_0x009c
        L_0x0047:
            r6 = 8
            goto L_0x009c
        L_0x004b:
            java.lang.String r7 = "10"
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x0054
            goto L_0x009c
        L_0x0054:
            r6 = 7
            goto L_0x009c
        L_0x0056:
            java.lang.String r7 = "9"
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x005f
            goto L_0x009c
        L_0x005f:
            r6 = 6
            goto L_0x009c
        L_0x0061:
            java.lang.String r7 = "8"
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x006a
            goto L_0x009c
        L_0x006a:
            r6 = 5
            goto L_0x009c
        L_0x006c:
            java.lang.String r7 = "7"
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x0075
            goto L_0x009c
        L_0x0075:
            r6 = r8
            goto L_0x009c
        L_0x0077:
            java.lang.String r7 = "6"
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x0080
            goto L_0x009c
        L_0x0080:
            r6 = r12
            goto L_0x009c
        L_0x0082:
            boolean r0 = r0.equals(r9)
            if (r0 != 0) goto L_0x0089
            goto L_0x009c
        L_0x0089:
            r6 = r4
            goto L_0x009c
        L_0x008b:
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x0092
            goto L_0x009c
        L_0x0092:
            r6 = r5
            goto L_0x009c
        L_0x0094:
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x009b
            goto L_0x009c
        L_0x009b:
            r6 = 0
        L_0x009c:
            switch(r6) {
                case 0: goto L_0x013e;
                case 1: goto L_0x0131;
                case 2: goto L_0x0123;
                case 3: goto L_0x0116;
                case 4: goto L_0x0109;
                case 5: goto L_0x00fc;
                case 6: goto L_0x00ef;
                case 7: goto L_0x00e2;
                case 8: goto L_0x00cf;
                case 9: goto L_0x00bf;
                case 10: goto L_0x00a7;
                default: goto L_0x009f;
            }
        L_0x009f:
            if (r5 != r14) goto L_0x00a3
            goto L_0x0146
        L_0x00a3:
            if (r4 != r14) goto L_0x014b
            goto L_0x014c
        L_0x00a7:
            if (r5 != r14) goto L_0x00ad
            java.lang.String r14 = "1"
            goto L_0x0127
        L_0x00ad:
            if (r4 != r14) goto L_0x00b2
            r1 = r10
            goto L_0x014c
        L_0x00b2:
            if (r12 != r14) goto L_0x00b7
            r1 = r11
            goto L_0x014c
        L_0x00b7:
            if (r8 != r14) goto L_0x00bc
            r1 = r9
            goto L_0x014c
        L_0x00bc:
            r14 = 0
            goto L_0x0127
        L_0x00bf:
            if (r5 != r14) goto L_0x00c5
            java.lang.String r14 = "otc-options-to-spot"
            goto L_0x0127
        L_0x00c5:
            if (r4 != r14) goto L_0x00cb
            java.lang.String r14 = "spot-to-otc-options"
            goto L_0x0127
        L_0x00cb:
            java.lang.String r14 = "spot-to-otc-options,otc-options-to-spot"
            goto L_0x0127
        L_0x00cf:
            if (r5 != r14) goto L_0x00d5
            java.lang.String r14 = "14"
            goto L_0x0127
        L_0x00d5:
            if (r4 != r14) goto L_0x00da
            java.lang.String r14 = "15"
            goto L_0x0127
        L_0x00da:
            if (r12 != r14) goto L_0x00df
            java.lang.String r14 = "39"
            goto L_0x0127
        L_0x00df:
            java.lang.String r14 = "0"
            goto L_0x0127
        L_0x00e2:
            if (r5 != r14) goto L_0x00e7
            java.lang.String r14 = "spot-to-option"
            goto L_0x0127
        L_0x00e7:
            if (r4 != r14) goto L_0x00ec
            java.lang.String r14 = "option-to-spot"
            goto L_0x0127
        L_0x00ec:
            java.lang.String r14 = "option-to-spot,spot-to-option"
            goto L_0x0127
        L_0x00ef:
            if (r5 != r14) goto L_0x00f4
            java.lang.String r14 = "mine-pool-transfer-out"
            goto L_0x0127
        L_0x00f4:
            if (r4 != r14) goto L_0x00f9
            java.lang.String r14 = "mine-pool-transfer-in"
            goto L_0x0127
        L_0x00f9:
            java.lang.String r14 = "mine-pool-transfer-out,mine-pool-transfer-in"
            goto L_0x0127
        L_0x00fc:
            if (r5 != r14) goto L_0x0101
            java.lang.String r14 = "borrow-to-spot"
            goto L_0x0127
        L_0x0101:
            if (r4 != r14) goto L_0x0106
            java.lang.String r14 = "spot-to-borrow"
            goto L_0x0127
        L_0x0106:
            java.lang.String r14 = "spot-to-borrow,borrow-to-spot"
            goto L_0x0127
        L_0x0109:
            if (r5 != r14) goto L_0x010e
            java.lang.String r14 = "dm-swap-to-pro"
            goto L_0x0127
        L_0x010e:
            if (r4 != r14) goto L_0x0113
            java.lang.String r14 = "dm-pro-to-swap"
            goto L_0x0127
        L_0x0113:
            java.lang.String r14 = "dm-swap-to-pro,dm-pro-to-swap"
            goto L_0x0127
        L_0x0116:
            if (r5 != r14) goto L_0x011b
            java.lang.String r14 = "super-margin-to-pro"
            goto L_0x0127
        L_0x011b:
            if (r4 != r14) goto L_0x0120
            java.lang.String r14 = "pro-to-super-margin"
            goto L_0x0127
        L_0x0120:
            java.lang.String r14 = "pro-to-super-margin,super-margin-to-pro"
            goto L_0x0127
        L_0x0123:
            if (r5 != r14) goto L_0x0129
            java.lang.String r14 = "futures-to-pro"
        L_0x0127:
            r1 = r14
            goto L_0x014c
        L_0x0129:
            if (r4 != r14) goto L_0x012e
            java.lang.String r14 = "pro-to-futures"
            goto L_0x0127
        L_0x012e:
            java.lang.String r14 = "futures-to-pro,pro-to-futures"
            goto L_0x0127
        L_0x0131:
            if (r5 != r14) goto L_0x0136
            java.lang.String r14 = "margin-transfer-out"
            goto L_0x0127
        L_0x0136:
            if (r4 != r14) goto L_0x013b
            java.lang.String r14 = "margin-transfer-in"
            goto L_0x0127
        L_0x013b:
            java.lang.String r14 = "margin-transfer-in,margin-transfer-out"
            goto L_0x0127
        L_0x013e:
            if (r5 != r14) goto L_0x0141
            goto L_0x0146
        L_0x0141:
            if (r4 != r14) goto L_0x014b
            goto L_0x014c
        L_0x0144:
            if (r5 != r14) goto L_0x0148
        L_0x0146:
            r1 = r3
            goto L_0x014c
        L_0x0148:
            if (r4 != r14) goto L_0x014b
            goto L_0x014c
        L_0x014b:
            r1 = r2
        L_0x014c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.presenter.CurrencyHistoryPresenter.b0(int):java.lang.String");
    }

    public final Observable<List<TransferOrderHistory>> c0(Map<String, Object> map) {
        return ((FinanceService) p.W(FinanceService.class)).marginFinances(map).compose(p.a0()).compose(RxJavaHelper.t((g) getUI()));
    }

    @h(priority = 1)
    @Keep
    public void cancelWithDraw(FinanceRecordItem financeRecordItem) {
        ((FinanceService) p.W(FinanceService.class)).withdrawCancel(financeRecordItem.getTransactionId()).compose(p.a0()).compose(RxJavaHelper.t((g) getUI())).subscribe(q6.d.c((g) getUI(), new s3(this)));
        EventBus.d().b(financeRecordItem);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e3, code lost:
        if (r11.equals("4") == false) goto L_0x0082;
     */
    /* renamed from: h0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onUIReady(com.hbg.lib.common.ui.BaseCoreActivity r11, com.huobi.finance.presenter.CurrencyHistoryPresenter.e r12) {
        /*
            r10 = this;
            super.onUIReady((com.hbg.lib.common.ui.BaseCoreActivity) r11, r12)
            com.hbg.lib.common.ui.BaseCoreActivity r11 = r10.getActivity()
            android.content.Intent r11 = r11.getIntent()
            if (r11 == 0) goto L_0x002d
            java.lang.String r0 = "coin"
            java.lang.String r0 = r11.getStringExtra(r0)
            r10.f45539b = r0
            java.lang.String r0 = "KEY_JUMP_FOR"
            java.lang.String r0 = r11.getStringExtra(r0)
            r10.f45542e = r0
            java.lang.String r0 = "account"
            java.lang.String r0 = r11.getStringExtra(r0)
            r10.f45543f = r0
            java.lang.String r0 = "JUMP_SYMBOL_PAIR"
            java.lang.String r11 = r11.getStringExtra(r0)
            r10.f45540c = r11
        L_0x002d:
            java.lang.String r11 = r10.f45543f
            java.lang.String r0 = "2"
            if (r11 != 0) goto L_0x0035
            r10.f45543f = r0
        L_0x0035:
            java.lang.String r11 = r10.f45542e
            java.lang.String r1 = "1"
            if (r11 != 0) goto L_0x003d
            r10.f45542e = r1
        L_0x003d:
            java.lang.String r11 = r10.f45542e
            r11.hashCode()
            int r2 = r11.hashCode()
            r3 = 2
            r4 = 0
            r5 = -1
            java.lang.String r6 = "3"
            r7 = 1
            switch(r2) {
                case 49: goto L_0x0063;
                case 50: goto L_0x005a;
                case 51: goto L_0x0051;
                default: goto L_0x004f;
            }
        L_0x004f:
            r11 = r5
            goto L_0x006b
        L_0x0051:
            boolean r11 = r11.equals(r6)
            if (r11 != 0) goto L_0x0058
            goto L_0x004f
        L_0x0058:
            r11 = r3
            goto L_0x006b
        L_0x005a:
            boolean r11 = r11.equals(r0)
            if (r11 != 0) goto L_0x0061
            goto L_0x004f
        L_0x0061:
            r11 = r7
            goto L_0x006b
        L_0x0063:
            boolean r11 = r11.equals(r1)
            if (r11 != 0) goto L_0x006a
            goto L_0x004f
        L_0x006a:
            r11 = r4
        L_0x006b:
            java.lang.String r1 = "11"
            java.lang.String r2 = "13"
            r8 = 10
            switch(r11) {
                case 0: goto L_0x0138;
                case 1: goto L_0x0133;
                case 2: goto L_0x0076;
                default: goto L_0x0074;
            }
        L_0x0074:
            goto L_0x013c
        L_0x0076:
            java.lang.String r11 = r10.f45543f
            r11.hashCode()
            int r9 = r11.hashCode()
            switch(r9) {
                case 50: goto L_0x00ef;
                case 51: goto L_0x00e6;
                case 52: goto L_0x00dd;
                case 54: goto L_0x00d2;
                case 55: goto L_0x00c7;
                case 56: goto L_0x00bc;
                case 57: goto L_0x00b1;
                case 1567: goto L_0x00a6;
                case 1568: goto L_0x009c;
                case 1569: goto L_0x008f;
                case 1570: goto L_0x0085;
                default: goto L_0x0082;
            }
        L_0x0082:
            r3 = r5
            goto L_0x00f7
        L_0x0085:
            boolean r11 = r11.equals(r2)
            if (r11 != 0) goto L_0x008c
            goto L_0x0082
        L_0x008c:
            r3 = r8
            goto L_0x00f7
        L_0x008f:
            java.lang.String r0 = "12"
            boolean r11 = r11.equals(r0)
            if (r11 != 0) goto L_0x0098
            goto L_0x0082
        L_0x0098:
            r3 = 9
            goto L_0x00f7
        L_0x009c:
            boolean r11 = r11.equals(r1)
            if (r11 != 0) goto L_0x00a3
            goto L_0x0082
        L_0x00a3:
            r3 = 8
            goto L_0x00f7
        L_0x00a6:
            java.lang.String r0 = "10"
            boolean r11 = r11.equals(r0)
            if (r11 != 0) goto L_0x00af
            goto L_0x0082
        L_0x00af:
            r3 = 7
            goto L_0x00f7
        L_0x00b1:
            java.lang.String r0 = "9"
            boolean r11 = r11.equals(r0)
            if (r11 != 0) goto L_0x00ba
            goto L_0x0082
        L_0x00ba:
            r3 = 6
            goto L_0x00f7
        L_0x00bc:
            java.lang.String r0 = "8"
            boolean r11 = r11.equals(r0)
            if (r11 != 0) goto L_0x00c5
            goto L_0x0082
        L_0x00c5:
            r3 = 5
            goto L_0x00f7
        L_0x00c7:
            java.lang.String r0 = "7"
            boolean r11 = r11.equals(r0)
            if (r11 != 0) goto L_0x00d0
            goto L_0x0082
        L_0x00d0:
            r3 = 4
            goto L_0x00f7
        L_0x00d2:
            java.lang.String r0 = "6"
            boolean r11 = r11.equals(r0)
            if (r11 != 0) goto L_0x00db
            goto L_0x0082
        L_0x00db:
            r3 = 3
            goto L_0x00f7
        L_0x00dd:
            java.lang.String r0 = "4"
            boolean r11 = r11.equals(r0)
            if (r11 != 0) goto L_0x00f7
            goto L_0x0082
        L_0x00e6:
            boolean r11 = r11.equals(r6)
            if (r11 != 0) goto L_0x00ed
            goto L_0x0082
        L_0x00ed:
            r3 = r7
            goto L_0x00f7
        L_0x00ef:
            boolean r11 = r11.equals(r0)
            if (r11 != 0) goto L_0x00f6
            goto L_0x0082
        L_0x00f6:
            r3 = r4
        L_0x00f7:
            java.lang.String r11 = "otc-to-pro,pro-to-otc"
            switch(r3) {
                case 0: goto L_0x0130;
                case 1: goto L_0x012b;
                case 2: goto L_0x0126;
                case 3: goto L_0x0121;
                case 4: goto L_0x011c;
                case 5: goto L_0x0117;
                case 6: goto L_0x0112;
                case 7: goto L_0x010d;
                case 8: goto L_0x0108;
                case 9: goto L_0x0103;
                case 10: goto L_0x00ff;
                default: goto L_0x00fc;
            }
        L_0x00fc:
            r10.f45541d = r11
            goto L_0x013c
        L_0x00ff:
            r11 = 0
            r10.f45541d = r11
            goto L_0x013c
        L_0x0103:
            java.lang.String r11 = "spot-to-otc-options,otc-options-to-spot"
            r10.f45541d = r11
            goto L_0x013c
        L_0x0108:
            java.lang.String r11 = "0"
            r10.f45541d = r11
            goto L_0x013c
        L_0x010d:
            java.lang.String r11 = "option-to-spot,spot-to-option"
            r10.f45541d = r11
            goto L_0x013c
        L_0x0112:
            java.lang.String r11 = "mine-pool-transfer-out,mine-pool-transfer-in"
            r10.f45541d = r11
            goto L_0x013c
        L_0x0117:
            java.lang.String r11 = "spot-to-borrow,borrow-to-spot"
            r10.f45541d = r11
            goto L_0x013c
        L_0x011c:
            java.lang.String r11 = "dm-swap-to-pro,dm-pro-to-swap"
            r10.f45541d = r11
            goto L_0x013c
        L_0x0121:
            java.lang.String r11 = "pro-to-super-margin,super-margin-to-pro"
            r10.f45541d = r11
            goto L_0x013c
        L_0x0126:
            java.lang.String r11 = "futures-to-pro,pro-to-futures"
            r10.f45541d = r11
            goto L_0x013c
        L_0x012b:
            java.lang.String r11 = "margin-transfer-in,margin-transfer-out"
            r10.f45541d = r11
            goto L_0x013c
        L_0x0130:
            r10.f45541d = r11
            goto L_0x013c
        L_0x0133:
            java.lang.String r11 = "withdraw-virtual,withdraw-virtual-fast"
            r10.f45541d = r11
            goto L_0x013c
        L_0x0138:
            java.lang.String r11 = "deposit-virtual,deposit-virtual-fast,deposit-virtual-mgt-special"
            r10.f45541d = r11
        L_0x013c:
            h6.a r11 = r10.getUI()
            com.huobi.finance.presenter.CurrencyHistoryPresenter$e r11 = (com.huobi.finance.presenter.CurrencyHistoryPresenter.e) r11
            r11.q2()
            java.lang.String r11 = r10.f45543f
            boolean r11 = r2.equals(r11)
            if (r11 == 0) goto L_0x016f
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = new com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder
            r11.<init>()
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.n(r7)
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.l(r7)
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.m(r8)
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.p(r12)
            com.hbg.lib.core.page.SmartRefreshPageSplitter$c<vk.m> r12 = r10.f45545h
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.o(r12)
            com.hbg.lib.core.page.SmartRefreshPageSplitter r11 = r11.k()
            r10.f45538a = r11
            goto L_0x01e4
        L_0x016f:
            java.lang.String r11 = r10.f45543f
            boolean r11 = r1.equals(r11)
            if (r11 == 0) goto L_0x0199
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = new com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder
            r11.<init>()
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.n(r7)
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.l(r7)
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.m(r8)
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.p(r12)
            com.hbg.lib.core.page.SmartRefreshPageSplitter$c<vk.t> r12 = r10.f45546i
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.o(r12)
            com.hbg.lib.core.page.SmartRefreshPageSplitter r11 = r11.k()
            r10.f45538a = r11
            goto L_0x01e4
        L_0x0199:
            java.lang.String r11 = r10.f45543f
            boolean r11 = r6.equals(r11)
            if (r11 == 0) goto L_0x01c3
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = new com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder
            r11.<init>()
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.n(r7)
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.l(r7)
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.m(r8)
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.p(r12)
            com.hbg.lib.core.page.SmartRefreshPageSplitter$c<com.huobi.finance.bean.TransferOrderHistory> r12 = r10.f45547j
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.o(r12)
            com.hbg.lib.core.page.SmartRefreshPageSplitter r11 = r11.k()
            r10.f45538a = r11
            goto L_0x01e4
        L_0x01c3:
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = new com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder
            r11.<init>()
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.n(r7)
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.l(r7)
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.m(r8)
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.p(r12)
            com.hbg.lib.core.page.SmartRefreshPageSplitter$c<com.huobi.finance.bean.FinanceRecordItem> r12 = r10.f45544g
            com.hbg.lib.core.page.SmartRefreshPageSplitter$Builder r11 = r11.o(r12)
            com.hbg.lib.core.page.SmartRefreshPageSplitter r11 = r11.k()
            r10.f45538a = r11
        L_0x01e4:
            com.hbg.lib.core.page.SmartRefreshPageSplitter<?> r11 = r10.f45538a
            r11.B()
            org.greenrobot.eventbus.EventBus r11 = org.greenrobot.eventbus.EventBus.d()
            r11.p(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.presenter.CurrencyHistoryPresenter.onUIReady(com.hbg.lib.common.ui.BaseCoreActivity, com.huobi.finance.presenter.CurrencyHistoryPresenter$e):void");
    }

    public void i0(String str) {
        this.f45541d = str;
        this.f45538a.B();
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        rn.c.i().m(getActivity(), (kn.a) null);
        getActivity().finish();
    }
}
