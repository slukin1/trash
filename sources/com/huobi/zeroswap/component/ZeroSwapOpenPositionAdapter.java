package com.huobi.zeroswap.component;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.huobi.zeroswap.engine.model.KLineBean;
import com.huobi.zeroswap.vm.ZeroSwapViewModel;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import lj.o0;
import lj.q0;

public final class ZeroSwapOpenPositionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: c  reason: collision with root package name */
    public static final a f21172c = new a((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final List<KLineBean> f21173a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public boolean f21174b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final q0 f21175a;

        public b(q0 q0Var) {
            super(q0Var.getRoot());
            this.f21175a = q0Var;
        }
    }

    public final class c extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final o0 f21177a;

        public c(o0 o0Var) {
            super(o0Var.getRoot());
            this.f21177a = o0Var;
        }

        public final o0 e() {
            return this.f21177a;
        }
    }

    @SensorsDataInstrumented
    public static final void e(ZeroSwapOpenPositionAdapter zeroSwapOpenPositionAdapter, ZeroSwapViewModel zeroSwapViewModel, int i11, View view) {
        zeroSwapOpenPositionAdapter.f21174b = true;
        if (zeroSwapViewModel != null) {
            zeroSwapViewModel.d("activityzero", "openPosition.clickClosePosition(" + i11 + ')');
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void f(ZeroSwapOpenPositionAdapter zeroSwapOpenPositionAdapter, ZeroSwapViewModel zeroSwapViewModel, int i11, View view) {
        zeroSwapOpenPositionAdapter.f21174b = true;
        if (zeroSwapViewModel != null) {
            zeroSwapViewModel.d("activityzero", "openPosition.clickedFold(" + i11 + ')');
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final boolean d() {
        return this.f21174b;
    }

    public final void g() {
        this.f21174b = false;
    }

    public final List<KLineBean> getData() {
        return this.f21173a;
    }

    public int getItemCount() {
        return this.f21173a.size() + 1;
    }

    public int getItemViewType(int i11) {
        return i11 == this.f21173a.size() ? 1 : 0;
    }

    public final void h(List<KLineBean> list) {
        this.f21173a.clear();
        this.f21173a.addAll(list);
    }

    /* JADX WARNING: type inference failed for: r1v84, types: [androidx.lifecycle.ViewModel] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r19, int r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            int r3 = r0.getItemViewType(r2)
            if (r3 != 0) goto L_0x031e
            boolean r3 = r1 instanceof com.huobi.zeroswap.component.ZeroSwapOpenPositionAdapter.c
            r4 = 0
            if (r3 == 0) goto L_0x0014
            com.huobi.zeroswap.component.ZeroSwapOpenPositionAdapter$c r1 = (com.huobi.zeroswap.component.ZeroSwapOpenPositionAdapter.c) r1
            goto L_0x0015
        L_0x0014:
            r1 = r4
        L_0x0015:
            if (r1 == 0) goto L_0x031e
            java.util.List<com.huobi.zeroswap.engine.model.KLineBean> r3 = r0.f21173a
            java.lang.Object r3 = r3.get(r2)
            com.huobi.zeroswap.engine.model.KLineBean r3 = (com.huobi.zeroswap.engine.model.KLineBean) r3
            lj.o0 r5 = r1.e()
            android.view.View r1 = r1.itemView
            android.content.Context r1 = r1.getContext()
            boolean r6 = r1 instanceof com.huobi.zeroswap.ui.ZeroSwapActivity
            if (r6 == 0) goto L_0x0030
            com.huobi.zeroswap.ui.ZeroSwapActivity r1 = (com.huobi.zeroswap.ui.ZeroSwapActivity) r1
            goto L_0x0031
        L_0x0030:
            r1 = r4
        L_0x0031:
            if (r1 == 0) goto L_0x0041
            androidx.lifecycle.ViewModelProvider r4 = new androidx.lifecycle.ViewModelProvider
            r4.<init>(r1)
            java.lang.Class<com.huobi.zeroswap.vm.ZeroSwapViewModel> r1 = com.huobi.zeroswap.vm.ZeroSwapViewModel.class
            androidx.lifecycle.ViewModel r1 = r4.a(r1)
            r4 = r1
            com.huobi.zeroswap.vm.ZeroSwapViewModel r4 = (com.huobi.zeroswap.vm.ZeroSwapViewModel) r4
        L_0x0041:
            android.widget.TextView r1 = r5.f47621i0
            java.lang.String r6 = r3.getTitle()
            java.lang.String r7 = ""
            if (r6 == 0) goto L_0x004c
            goto L_0x004d
        L_0x004c:
            r6 = r7
        L_0x004d:
            r1.setText(r6)
            com.huobi.view.roundview.RoundTextView r1 = r5.J
            java.lang.String r6 = r3.getDay()
            if (r6 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r6 = r7
        L_0x005a:
            r1.setText(r6)
            android.widget.TextView r1 = r5.K
            java.lang.String r6 = r3.getDayUnit()
            if (r6 == 0) goto L_0x0066
            goto L_0x0067
        L_0x0066:
            r6 = r7
        L_0x0067:
            r1.setText(r6)
            com.huobi.view.roundview.RoundTextView r1 = r5.L
            java.lang.String r6 = r3.getHour()
            if (r6 == 0) goto L_0x0073
            goto L_0x0074
        L_0x0073:
            r6 = r7
        L_0x0074:
            r1.setText(r6)
            com.huobi.view.roundview.RoundTextView r1 = r5.V
            java.lang.String r6 = r3.getMinute()
            if (r6 == 0) goto L_0x0080
            goto L_0x0081
        L_0x0080:
            r6 = r7
        L_0x0081:
            r1.setText(r6)
            com.huobi.view.roundview.RoundTextView r1 = r5.f47617e0
            java.lang.String r6 = r3.getSecond()
            if (r6 == 0) goto L_0x008d
            goto L_0x008e
        L_0x008d:
            r6 = r7
        L_0x008e:
            r1.setText(r6)
            java.lang.Boolean r1 = r3.getShowClose()
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r1 = kotlin.jvm.internal.x.b(r1, r6)
            r6 = 4
            r8 = 0
            if (r1 == 0) goto L_0x00a5
            android.widget.LinearLayout r1 = r5.E
            r1.setVisibility(r8)
            goto L_0x00aa
        L_0x00a5:
            android.widget.LinearLayout r1 = r5.E
            r1.setVisibility(r6)
        L_0x00aa:
            androidx.appcompat.widget.AppCompatImageView r1 = r5.C
            java.lang.String r9 = r3.getIcon()
            if (r9 != 0) goto L_0x00b3
            r9 = r7
        L_0x00b3:
            com.hbg.module.libkt.base.ext.b.B(r1, r9)
            android.widget.TextView r1 = r5.f47618f0
            java.lang.String r9 = r3.getDisPlaySymbol()
            if (r9 == 0) goto L_0x00bf
            goto L_0x00c0
        L_0x00bf:
            r9 = r7
        L_0x00c0:
            r1.setText(r9)
            com.huobi.view.roundview.RoundTextView r1 = r5.f47615c0
            java.lang.String r9 = r3.getPosSide()
            if (r9 == 0) goto L_0x00cc
            goto L_0x00cd
        L_0x00cc:
            r9 = r7
        L_0x00cd:
            r1.setText(r9)
            com.huobi.view.roundview.RoundTextView r1 = r5.f47615c0
            r9 = -1
            java.lang.String r10 = r3.getPosSideColor()     // Catch:{ Exception -> 0x00dc }
            int r10 = android.graphics.Color.parseColor(r10)     // Catch:{ Exception -> 0x00dc }
            goto L_0x00dd
        L_0x00dc:
            r10 = r9
        L_0x00dd:
            r1.setTextColor(r10)
            com.huobi.view.roundview.RoundTextView r1 = r5.f47615c0
            com.huobi.view.roundview.RoundViewDelegate r1 = r1.getDelegate()
            java.lang.String r10 = r3.getPosSidebackColor()     // Catch:{ Exception -> 0x00ef }
            int r10 = android.graphics.Color.parseColor(r10)     // Catch:{ Exception -> 0x00ef }
            goto L_0x00f0
        L_0x00ef:
            r10 = r9
        L_0x00f0:
            r1.setBackgroundColor(r10)
            com.huobi.view.roundview.RoundTextView r1 = r5.U
            java.lang.String r10 = r3.getMarginMode()
            if (r10 == 0) goto L_0x00fc
            goto L_0x00fd
        L_0x00fc:
            r10 = r7
        L_0x00fd:
            r1.setText(r10)
            com.huobi.view.roundview.RoundTextView r1 = r5.M
            java.lang.String r10 = r3.getLever()
            if (r10 == 0) goto L_0x0109
            goto L_0x010a
        L_0x0109:
            r10 = r7
        L_0x010a:
            r1.setText(r10)
            java.lang.Boolean r1 = r3.getShowClose()
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            boolean r1 = kotlin.jvm.internal.x.b(r1, r10)
            if (r1 == 0) goto L_0x011f
            com.huobi.view.roundview.RoundTextView r1 = r5.I
            r1.setVisibility(r8)
            goto L_0x0124
        L_0x011f:
            com.huobi.view.roundview.RoundTextView r1 = r5.I
            r1.setVisibility(r6)
        L_0x0124:
            com.huobi.view.roundview.RoundTextView r1 = r5.I
            mv.c r6 = new mv.c
            r6.<init>(r0, r4, r2)
            r1.setOnClickListener(r6)
            java.lang.String r1 = r3.getLimitTips()
            if (r1 != 0) goto L_0x0135
            r1 = r7
        L_0x0135:
            int r6 = r1.length()
            if (r6 != 0) goto L_0x013d
            r6 = 1
            goto L_0x013e
        L_0x013d:
            r6 = r8
        L_0x013e:
            java.lang.String r10 = "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams"
            r11 = 8
            if (r6 == 0) goto L_0x0169
            com.huobi.view.roundview.RoundTextView r1 = r5.T
            r1.setVisibility(r11)
            android.widget.LinearLayout r1 = r5.G
            android.view.ViewGroup$LayoutParams r6 = r1.getLayoutParams()
            java.util.Objects.requireNonNull(r6, r10)
            boolean r10 = r6 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r10 == 0) goto L_0x0165
            r10 = r6
            android.view.ViewGroup$MarginLayoutParams r10 = (android.view.ViewGroup.MarginLayoutParams) r10
            r12 = 12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            int r12 = com.hbg.module.libkt.utils.m.a(r12)
            r10.topMargin = r12
        L_0x0165:
            r1.setLayoutParams(r6)
            goto L_0x0191
        L_0x0169:
            com.huobi.view.roundview.RoundTextView r6 = r5.T
            r6.setText(r1)
            com.huobi.view.roundview.RoundTextView r1 = r5.T
            r1.setVisibility(r8)
            android.widget.LinearLayout r1 = r5.G
            android.view.ViewGroup$LayoutParams r6 = r1.getLayoutParams()
            java.util.Objects.requireNonNull(r6, r10)
            boolean r10 = r6 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r10 == 0) goto L_0x018e
            r10 = r6
            android.view.ViewGroup$MarginLayoutParams r10 = (android.view.ViewGroup.MarginLayoutParams) r10
            r12 = 6
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            int r12 = com.hbg.module.libkt.utils.m.a(r12)
            r10.topMargin = r12
        L_0x018e:
            r1.setLayoutParams(r6)
        L_0x0191:
            android.widget.TextView r1 = r5.Z
            java.lang.String r6 = r3.getPnlName()
            if (r6 == 0) goto L_0x019a
            goto L_0x019b
        L_0x019a:
            r6 = r7
        L_0x019b:
            r1.setText(r6)
            android.widget.TextView r1 = r5.Y
            java.lang.String r6 = r3.getPnl()
            if (r6 == 0) goto L_0x01a7
            goto L_0x01a8
        L_0x01a7:
            r6 = r7
        L_0x01a8:
            r1.setText(r6)
            android.widget.TextView r1 = r5.Y
            java.lang.String r6 = r3.getPnlColor()     // Catch:{ Exception -> 0x01b6 }
            int r6 = android.graphics.Color.parseColor(r6)     // Catch:{ Exception -> 0x01b6 }
            goto L_0x01b7
        L_0x01b6:
            r6 = r9
        L_0x01b7:
            r1.setTextColor(r6)
            android.widget.TextView r1 = r5.f47614b0
            java.lang.String r6 = r3.getPnlRatioName()
            if (r6 == 0) goto L_0x01c3
            goto L_0x01c4
        L_0x01c3:
            r6 = r7
        L_0x01c4:
            r1.setText(r6)
            android.widget.TextView r1 = r5.f47613a0
            java.lang.String r6 = r3.getPnlRatio()
            if (r6 == 0) goto L_0x01d0
            goto L_0x01d1
        L_0x01d0:
            r6 = r7
        L_0x01d1:
            r1.setText(r6)
            android.widget.TextView r1 = r5.f47613a0
            java.lang.String r6 = r3.getPnlColor()     // Catch:{ Exception -> 0x01de }
            int r9 = android.graphics.Color.parseColor(r6)     // Catch:{ Exception -> 0x01de }
        L_0x01de:
            r1.setTextColor(r9)
            android.widget.TextView r1 = r5.f47620h0
            java.lang.String r6 = r3.getPositionAmountTitle()
            if (r6 == 0) goto L_0x01ea
            goto L_0x01eb
        L_0x01ea:
            r6 = r7
        L_0x01eb:
            r1.setText(r6)
            android.widget.TextView r1 = r5.f47619g0
            java.lang.String r6 = r3.getAmount()
            if (r6 == 0) goto L_0x01f7
            goto L_0x01f8
        L_0x01f7:
            r6 = r7
        L_0x01f8:
            r1.setText(r6)
            android.widget.TextView r1 = r5.X
            java.lang.String r6 = r3.getOpenAvgPxName()
            if (r6 == 0) goto L_0x0204
            goto L_0x0205
        L_0x0204:
            r6 = r7
        L_0x0205:
            r1.setText(r6)
            android.widget.TextView r1 = r5.W
            java.lang.String r6 = r3.getOpenAvgPx()
            if (r6 == 0) goto L_0x0211
            goto L_0x0212
        L_0x0211:
            r6 = r7
        L_0x0212:
            r1.setText(r6)
            android.widget.TextView r1 = r5.Q
            java.lang.String r6 = r3.getMarginName()
            if (r6 == 0) goto L_0x021e
            goto L_0x021f
        L_0x021e:
            r6 = r7
        L_0x021f:
            r1.setText(r6)
            android.widget.TextView r1 = r5.P
            java.lang.String r6 = r3.getMargin()
            if (r6 == 0) goto L_0x022b
            goto L_0x022c
        L_0x022b:
            r6 = r7
        L_0x022c:
            r1.setText(r6)
            android.widget.TextView r1 = r5.S
            java.lang.String r6 = r3.getMarginRatioName()
            if (r6 == 0) goto L_0x0238
            goto L_0x0239
        L_0x0238:
            r6 = r7
        L_0x0239:
            r1.setText(r6)
            android.widget.TextView r1 = r5.R
            java.lang.String r6 = r3.getMarginRatio()
            if (r6 == 0) goto L_0x0245
            goto L_0x0246
        L_0x0245:
            r6 = r7
        L_0x0246:
            r1.setText(r6)
            android.widget.TextView r1 = r5.O
            java.lang.String r6 = r3.getLiqPxName()
            if (r6 == 0) goto L_0x0252
            goto L_0x0253
        L_0x0252:
            r6 = r7
        L_0x0253:
            r1.setText(r6)
            android.widget.TextView r1 = r5.N
            java.lang.String r6 = r3.getLiqPx()
            if (r6 == 0) goto L_0x025f
            goto L_0x0260
        L_0x025f:
            r6 = r7
        L_0x0260:
            r1.setText(r6)
            android.widget.TextView r1 = r5.H
            java.lang.String r6 = r3.getKlineTitle()
            if (r6 == 0) goto L_0x026c
            goto L_0x026d
        L_0x026c:
            r6 = r7
        L_0x026d:
            r1.setText(r6)
            android.widget.LinearLayout r1 = r5.F
            mv.b r6 = new mv.b
            r6.<init>(r0, r4, r2)
            r1.setOnClickListener(r6)
            android.widget.TextView r1 = r5.f47616d0
            java.lang.String r2 = r3.getPrice()
            if (r2 == 0) goto L_0x0283
            goto L_0x0284
        L_0x0283:
            r2 = r7
        L_0x0284:
            r1.setText(r2)
            java.lang.String r1 = r3.getUpdownImage()
            if (r1 != 0) goto L_0x028e
            r1 = r7
        L_0x028e:
            java.lang.String r2 = "@drawable/edge_engine_arrow_up"
            boolean r1 = kotlin.jvm.internal.x.b(r2, r1)
            if (r1 == 0) goto L_0x029f
            androidx.appcompat.widget.AppCompatImageView r1 = r5.B
            r2 = 2131232125(0x7f08057d, float:1.808035E38)
            com.hbg.module.libkt.base.ext.b.A(r1, r2)
            goto L_0x02a7
        L_0x029f:
            androidx.appcompat.widget.AppCompatImageView r1 = r5.B
            r2 = 2131232124(0x7f08057c, float:1.8080348E38)
            com.hbg.module.libkt.base.ext.b.A(r1, r2)
        L_0x02a7:
            java.lang.String r1 = r3.getSymbol()
            if (r1 != 0) goto L_0x02af
            r15 = r7
            goto L_0x02b0
        L_0x02af:
            r15 = r1
        L_0x02b0:
            com.huobi.zeroswap.engine.view.KLineEdgeItemView r1 = r5.D
            java.lang.String r1 = r1.M
            if (r1 != 0) goto L_0x02b7
            r1 = r7
        L_0x02b7:
            boolean r1 = kotlin.jvm.internal.x.b(r15, r1)
            if (r1 != 0) goto L_0x02d1
            int r17 = com.hbg.lib.data.future.util.FuturePrecisionUtil.s(r15, r15, r7)
            int r16 = com.hbg.lib.data.future.util.FuturePrecisionUtil.y(r15, r15, r7)
            com.huobi.zeroswap.engine.view.KLineEdgeItemView r12 = r5.D
            r13 = 0
            com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP
            java.lang.String r14 = r1.toString()
            r12.i(r13, r14, r15, r16, r17)
        L_0x02d1:
            java.lang.Boolean r1 = r3.getFold()
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            boolean r1 = kotlin.jvm.internal.x.b(r1, r2)
            if (r1 == 0) goto L_0x02f8
            com.huobi.zeroswap.engine.view.KLineEdgeItemView r1 = r5.D
            int r1 = r1.getVisibility()
            if (r1 == 0) goto L_0x02ea
            com.huobi.zeroswap.engine.view.KLineEdgeItemView r1 = r5.D
            r1.setVisibility(r8)
        L_0x02ea:
            com.huobi.zeroswap.engine.view.KLineEdgeItemView r1 = r5.D
            boolean r1 = r1.k()
            if (r1 != 0) goto L_0x031e
            com.huobi.zeroswap.engine.view.KLineEdgeItemView r1 = r5.D
            r1.s()
            goto L_0x031e
        L_0x02f8:
            java.lang.Boolean r1 = r3.getFold()
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            boolean r1 = kotlin.jvm.internal.x.b(r1, r2)
            if (r1 == 0) goto L_0x031e
            com.huobi.zeroswap.engine.view.KLineEdgeItemView r1 = r5.D
            int r1 = r1.getVisibility()
            if (r1 == r11) goto L_0x0311
            com.huobi.zeroswap.engine.view.KLineEdgeItemView r1 = r5.D
            r1.setVisibility(r11)
        L_0x0311:
            com.huobi.zeroswap.engine.view.KLineEdgeItemView r1 = r5.D
            boolean r1 = r1.k()
            if (r1 == 0) goto L_0x031e
            com.huobi.zeroswap.engine.view.KLineEdgeItemView r1 = r5.D
            r1.r()
        L_0x031e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.zeroswap.component.ZeroSwapOpenPositionAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        if (i11 == 1) {
            q0 K = q0.K(LayoutInflater.from(viewGroup.getContext()));
            K.getRoot().setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new b(K);
        }
        o0 K2 = o0.K(LayoutInflater.from(viewGroup.getContext()));
        K2.getRoot().setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return new c(K2);
    }
}
