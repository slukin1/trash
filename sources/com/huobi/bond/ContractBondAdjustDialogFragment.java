package com.huobi.bond;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.network.linear.swap.core.bean.ContractBondAdjustDetailQuestParams;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapBondAdjustDetail;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapBondAdjustResult;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.TransparentListPopupDialog;
import com.hbg.lib.widgets.dialog.bean.CommonPopListItem;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem;
import com.huobi.view.keyboard.HuobiBottomDialogKeyboardHelper;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.util.ArrayList;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;

public class ContractBondAdjustDialogFragment extends BaseDialogFragment implements CommonPopListItem.a, TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public int f42826b = -1;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f42827c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f42828d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f42829e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f42830f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f42831g;

    /* renamed from: h  reason: collision with root package name */
    public TransparentListPopupDialog f42832h = new TransparentListPopupDialog();

    /* renamed from: i  reason: collision with root package name */
    public TextView f42833i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f42834j;

    /* renamed from: k  reason: collision with root package name */
    public ki.a f42835k;

    /* renamed from: l  reason: collision with root package name */
    public LinearSwapPositionOrderItem f42836l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f42837m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f42838n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f42839o;

    /* renamed from: p  reason: collision with root package name */
    public LinearSwapBondAdjustDetail f42840p;

    /* renamed from: q  reason: collision with root package name */
    public FrameLayout f42841q;

    /* renamed from: r  reason: collision with root package name */
    public LoadingView f42842r;

    /* renamed from: s  reason: collision with root package name */
    public String f42843s = "USDT";

    /* renamed from: t  reason: collision with root package name */
    public String f42844t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f42845u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f42846v = false;

    /* renamed from: w  reason: collision with root package name */
    public ContractBondAdjustDetailQuestParams f42847w;

    public class a implements BaseDialogFragment.c {
        public a() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            ContractBondAdjustDialogFragment.this.f42830f.setImageResource(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            ContractBondAdjustDialogFragment.this.f42830f.setImageResource(R.drawable.trade_arrow_up);
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommonPopListItem f42849b;

        public b(CommonPopListItem commonPopListItem) {
            this.f42849b = commonPopListItem;
        }

        public void run() {
            ContractBondAdjustDialogFragment.this.V6(this.f42849b);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ContractBondAdjustDialogFragment.this.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ContractBondAdjustDialogFragment.this.f42832h.showAsDropDown(ContractBondAdjustDialogFragment.this.getActivity().getSupportFragmentManager(), ContractBondAdjustDialogFragment.this.f42829e);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class e implements View.OnClickListener {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                Editable text = ContractBondAdjustDialogFragment.this.f42828d.getText();
                if (text != null) {
                    ContractBondAdjustDialogFragment.this.f42828d.setSelection(text.toString().length());
                }
            }
        }

        public e() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (!TextUtils.isEmpty(ContractBondAdjustDialogFragment.this.f42844t)) {
                boolean unused = ContractBondAdjustDialogFragment.this.f42845u = true;
                ContractBondAdjustDialogFragment.this.f42828d.setText(ContractBondAdjustDialogFragment.this.f42844t);
                ContractBondAdjustDialogFragment.this.f42828d.post(new a());
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ContractBondAdjustDialogFragment.this.Ch();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public final int Ah() {
        LinearSwapPositionOrderItem linearSwapPositionOrderItem = this.f42836l;
        if (linearSwapPositionOrderItem == null) {
            return 3;
        }
        FutureContractInfo d11 = linearSwapPositionOrderItem.d();
        return FuturePrecisionUtil.w(d11.getContractCode(), d11.getContractShortType(), d11.getOptionCode());
    }

    public final String Bh() {
        return this.f42828d.getText().toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Ch() {
        /*
            r9 = this;
            java.lang.String r6 = r9.Bh()
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x000b
            return
        L_0x000b:
            java.lang.String r0 = r9.f42844t
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0079
            double r0 = java.lang.Double.parseDouble(r6)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r2 = r9.f42844t     // Catch:{ Exception -> 0x0030 }
            double r2 = java.lang.Double.parseDouble(r2)     // Catch:{ Exception -> 0x0030 }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0034
            android.content.res.Resources r0 = r9.getResources()     // Catch:{ Exception -> 0x0030 }
            r1 = 2132020897(0x7f140ea1, float:1.968017E38)
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x0030 }
            com.hbg.lib.widgets.utils.HuobiToastUtil.m(r0)     // Catch:{ Exception -> 0x0030 }
            return
        L_0x0030:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0034:
            com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem r0 = r9.f42836l
            if (r0 == 0) goto L_0x0079
            com.hbg.lib.data.future.bean.FutureContractInfo r0 = r0.d()
            com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem r1 = r9.f42836l
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r1 = r1.e()
            java.lang.String r2 = r1.getContractCode()
            java.lang.String r3 = r0.getQuoteCurrency()
            java.lang.String r0 = r1.getDirection()
            r1 = 0
            java.lang.String r4 = "buy"
            boolean r4 = android.text.TextUtils.equals(r0, r4)
            if (r4 == 0) goto L_0x005a
            r0 = 1
        L_0x0058:
            r4 = r0
            goto L_0x0065
        L_0x005a:
            java.lang.String r4 = "sell"
            boolean r0 = android.text.TextUtils.equals(r0, r4)
            if (r0 == 0) goto L_0x0064
            r0 = 2
            goto L_0x0058
        L_0x0064:
            r4 = r1
        L_0x0065:
            boolean r5 = r9.Jh()
            if (r5 == 0) goto L_0x006e
            r8 = r2
            r7 = r3
            goto L_0x0070
        L_0x006e:
            r7 = r2
            r8 = r3
        L_0x0070:
            ki.a r0 = r9.f42835k
            r1 = r3
            r2 = r4
            r3 = r7
            r4 = r8
            r0.b(r1, r2, r3, r4, r5, r6)
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.bond.ContractBondAdjustDialogFragment.Ch():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
        if (java.lang.Double.parseDouble(r0) <= java.lang.Double.parseDouble(r10.f42844t)) goto L_0x0029;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Dh() {
        /*
            r10 = this;
            java.lang.String r0 = r10.Bh()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0029
            java.lang.String r1 = r10.f42844t
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0015
            goto L_0x0029
        L_0x0015:
            double r4 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x0024 }
            java.lang.String r1 = r10.f42844t     // Catch:{ Exception -> 0x0024 }
            double r6 = java.lang.Double.parseDouble(r1)     // Catch:{ Exception -> 0x0024 }
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 > 0) goto L_0x0028
            goto L_0x0029
        L_0x0024:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0028:
            r2 = r3
        L_0x0029:
            if (r2 == 0) goto L_0x0063
            com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem r1 = r10.f42836l
            if (r1 == 0) goto L_0x0063
            com.hbg.lib.data.future.bean.FutureContractInfo r1 = r1.d()
            com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem r2 = r10.f42836l
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition r2 = r2.e()
            java.lang.String r4 = r2.getContractCode()
            java.lang.String r5 = r1.getQuoteCurrency()
            java.lang.String r6 = r1.getTradePartition()
            java.lang.String r9 = r2.getDirection()
            com.hbg.lib.network.linear.swap.core.bean.ContractBondAdjustDetailQuestParams r1 = new com.hbg.lib.network.linear.swap.core.bean.ContractBondAdjustDetailQuestParams
            boolean r7 = r10.Jh()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x0057
            java.lang.String r0 = "0"
        L_0x0057:
            r8 = r0
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r10.f42847w = r1
            ki.a r0 = r10.f42835k
            r0.c(r1)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.bond.ContractBondAdjustDialogFragment.Dh():void");
    }

    public void Eh(Throwable th2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("handAdjustBondFail ");
        sb2.append(th2 == null ? OptionsBridge.NULL_VALUE : th2.toString());
        i6.d.c("ContractBondAdjust", sb2.toString());
        if (th2 instanceof APIStatusErrorException) {
            HuobiToastUtil.m(((APIStatusErrorException) th2).getErrMsg());
        }
        dismiss();
    }

    public void Fh(LinearSwapBondAdjustResult linearSwapBondAdjustResult) {
        i6.d.c("ContractBondAdjust", "handAdjustBondSuccess " + linearSwapBondAdjustResult.toString());
        this.f42844t = null;
        HuobiToastUtil.s(R.string.n_title_operate_success);
        dismiss();
    }

    public void Gh(Throwable th2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("handDetailRefreshFail ");
        sb2.append(th2 == null ? OptionsBridge.NULL_VALUE : th2.toString());
        i6.d.c("ContractBondAdjust", sb2.toString());
        this.f42840p = null;
        zh();
        if (th2 instanceof APIStatusErrorException) {
            HuobiToastUtil.m(((APIStatusErrorException) th2).getErrMsg());
        }
    }

    public void Hh(LinearSwapBondAdjustDetail linearSwapBondAdjustDetail) {
        if (this.f42847w == null || linearSwapBondAdjustDetail.getContractBondAdjustDetailQuestParams() == null || this.f42847w.equals(linearSwapBondAdjustDetail.getContractBondAdjustDetailQuestParams())) {
            i6.d.c("ContractBondAdjust", "handDetailRefreshSuccess " + linearSwapBondAdjustDetail.toString());
            this.f42840p = linearSwapBondAdjustDetail;
            zh();
            return;
        }
        i6.d.c("ContractBondAdjust", "handDetailRefreshSuccess check fail");
    }

    public void Ih() {
        if (getActivity() != null) {
            this.f42841q.setVisibility(8);
            this.f42842r.d();
        }
    }

    public final boolean Jh() {
        return this.f42826b == 0;
    }

    public void Kh(LinearSwapPositionOrderItem linearSwapPositionOrderItem) {
        this.f42836l = linearSwapPositionOrderItem;
        if (linearSwapPositionOrderItem != null) {
            this.f42843s = linearSwapPositionOrderItem.d().getQuoteCurrency();
        }
    }

    public void V6(CommonPopListItem commonPopListItem) {
        this.f42832h.dismiss();
        if (this.f42826b != commonPopListItem.getType()) {
            this.f42826b = commonPopListItem.getType();
            i6.d.c("ContractBondAdjust", "onItemClick curAddOrReduceType = " + this.f42826b);
            this.f42831g.setText(commonPopListItem.getText());
            int i11 = this.f42826b;
            if (i11 == 0) {
                this.f42833i.setText(getResources().getString(R.string.n_contract_adjust_position_max_increase));
            } else if (i11 == 1) {
                this.f42833i.setText(getResources().getString(R.string.n_contract_adjust_position_max_decrease));
            }
            this.f42844t = null;
            this.f42828d.setText("");
            Dh();
        }
    }

    public void addEvent(r rVar) {
        rVar.b(R.id.iv_close).setOnClickListener(new c());
        if (this.f42846v) {
            this.f42829e.setOnClickListener(new d());
        }
        this.f42834j.setOnClickListener(new e());
        rVar.b(R.id.tv_confirm).setOnClickListener(new f());
        this.f42828d.removeTextChangedListener(this);
        this.f42828d.addTextChangedListener(this);
    }

    public void afterInit() {
    }

    public void afterTextChanged(Editable editable) {
        i6.d.c("ContractBondAdjust", "afterTextChanged s = " + editable.toString());
        if (this.f42845u) {
            this.f42834j.setEnabled(false);
            this.f42845u = false;
        } else {
            this.f42834j.setEnabled(true);
        }
        Dh();
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public int getContentViewResId() {
        return R.layout.dialog_contract_bond_adjust;
    }

    public int getGravity() {
        return 80;
    }

    public boolean ic(CommonPopListItem commonPopListItem) {
        return this.f42826b == commonPopListItem.getType();
    }

    public void initView(r rVar) {
        this.f42835k = new ki.a(this);
        this.f42827c = (LinearLayout) rVar.b(R.id.ll_root);
        this.f42841q = (FrameLayout) rVar.b(R.id.fl_loading_container);
        this.f42842r = (LoadingView) rVar.b(R.id.loading_view);
        EditText editText = (EditText) rVar.b(R.id.ed_amount);
        this.f42828d = editText;
        editText.setHint(getResources().getString(R.string.n_contract_trade_market_amount_label, new Object[]{"USDT"}));
        new HuobiBottomDialogKeyboardHelper().attach(getActivity(), this.f42827c).registerInput(this.f42828d);
        this.f42829e = (RelativeLayout) rVar.b(R.id.rl_add_or_reduce_container);
        this.f42830f = (ImageView) rVar.b(R.id.iv_add_or_reduce_menu);
        this.f42831g = (TextView) rVar.b(R.id.tv_add_or_reduce_menu);
        this.f42837m = (TextView) rVar.b(R.id.tv_cur_encumbered_assets_value);
        this.f42838n = (TextView) rVar.b(R.id.tv_max_adjust_value);
        this.f42839o = (TextView) rVar.b(R.id.tv_reference_strong_flat_price_value);
        this.f42834j = (TextView) rVar.b(R.id.tv_adjust_max);
        this.f42833i = (TextView) rVar.b(R.id.tv_max_adjust_title);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f42846v = arguments.getBoolean("enableReduce");
        }
        if (this.f42846v) {
            this.f42830f.setVisibility(0);
        } else {
            this.f42830f.setVisibility(8);
        }
        ArrayList arrayList = new ArrayList();
        CommonPopListItem commonPopListItem = new CommonPopListItem(0, getResources().getString(R.string.n_contract_adjust_position_increase), this);
        arrayList.add(commonPopListItem);
        arrayList.add(new CommonPopListItem(1, getResources().getString(R.string.n_contract_adjust_position_decrease), this));
        this.f42832h.setData(arrayList);
        this.f42832h.setFollowViewWidth(true);
        this.f42832h.setDialogFragmentListener(new a());
        this.f42831g.post(new b(commonPopListItem));
    }

    public boolean isTransparent() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.d().p(this);
    }

    public void onDestroy() {
        EventBus.d().r(this);
        super.onDestroy();
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (Jh()) {
            dismiss();
        }
    }

    public void showLoading() {
        if (getActivity() != null) {
            this.f42841q.setVisibility(0);
            this.f42842r.setLottieAnimationRes(R.raw.nd_middle_bg);
            this.f42842r.c();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zh() {
        /*
            r8 = this;
            java.lang.String r0 = r8.f42843s
            int r1 = r8.Ah()
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapBondAdjustDetail r2 = r8.f42840p
            java.lang.String r3 = "--"
            if (r2 == 0) goto L_0x006a
            java.math.BigDecimal r2 = r2.getPositionBond()
            if (r2 == 0) goto L_0x001b
            java.lang.String r2 = r2.toPlainString()
            java.lang.String r2 = i6.m.m(r2, r1)
            goto L_0x001c
        L_0x001b:
            r2 = r3
        L_0x001c:
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapBondAdjustDetail r4 = r8.f42840p
            java.math.BigDecimal r4 = r4.getMaxAddBond()
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapBondAdjustDetail r5 = r8.f42840p
            java.math.BigDecimal r5 = r5.getMaxReduceBond()
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapBondAdjustDetail r6 = r8.f42840p
            com.hbg.lib.network.linear.swap.core.bean.ContractBondAdjustDetailQuestParams r6 = r6.getContractBondAdjustDetailQuestParams()
            if (r6 == 0) goto L_0x0056
            boolean r7 = r6.isAdd()
            if (r7 == 0) goto L_0x0043
            if (r4 == 0) goto L_0x0043
            java.lang.String r4 = r4.toPlainString()
            java.lang.String r4 = i6.m.m(r4, r1)
            r8.f42844t = r4
            goto L_0x0057
        L_0x0043:
            boolean r4 = r6.isAdd()
            if (r4 != 0) goto L_0x0056
            if (r5 == 0) goto L_0x0056
            java.lang.String r4 = r5.toPlainString()
            java.lang.String r4 = i6.m.m(r4, r1)
            r8.f42844t = r4
            goto L_0x0057
        L_0x0056:
            r4 = r3
        L_0x0057:
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapBondAdjustDetail r5 = r8.f42840p
            java.math.BigDecimal r5 = r5.getEstimatedStrongParity()
            if (r5 == 0) goto L_0x0067
            java.lang.String r3 = r5.toPlainString()
            java.lang.String r3 = i6.m.m(r3, r1)
        L_0x0067:
            r1 = r3
            r3 = r2
            goto L_0x006c
        L_0x006a:
            r1 = r3
            r4 = r1
        L_0x006c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            java.lang.String r3 = " "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r3)
            r5.append(r0)
            java.lang.String r4 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            r5.append(r3)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            android.widget.TextView r1 = r8.f42837m
            r1.setText(r2)
            android.widget.TextView r1 = r8.f42838n
            r1.setText(r4)
            android.widget.TextView r1 = r8.f42839o
            r1.setText(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.bond.ContractBondAdjustDialogFragment.zh():void");
    }
}
