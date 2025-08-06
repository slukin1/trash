package com.huobi.points.viewhandler;

import android.view.View;
import com.huobi.points.activity.PointsHistoryDetailsActivity;
import com.huobi.points.entity.PointsAction;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;
import s9.c;

public class PointsActionViewHandler implements c, View.OnClickListener {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f4, code lost:
        if (r2.equals(com.huobi.points.entity.PointsAction.TYPE_MASTER_POINT_TRANSFER_OUT) == false) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0242, code lost:
        if (r1.equals("invalid") == false) goto L_0x023a;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleView(v9.c r17, int r18, com.huobi.points.entity.PointsAction r19, android.view.ViewGroup r20) {
        /*
            r16 = this;
            r0 = r17
            i6.r r1 = r17.e()
            android.view.View r2 = r0.itemView
            android.content.Context r2 = r2.getContext()
            r3 = 2131433588(0x7f0b1874, float:1.8488966E38)
            android.view.View r3 = r1.b(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r4 = 2131433586(0x7f0b1872, float:1.8488962E38)
            android.view.View r4 = r1.b(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r5 = 2131433590(0x7f0b1876, float:1.848897E38)
            android.view.View r5 = r1.b(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r6 = 2131433591(0x7f0b1877, float:1.8488972E38)
            android.view.View r6 = r1.b(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r7 = 2131433587(0x7f0b1873, float:1.8488964E38)
            android.view.View r1 = r1.b(r7)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            java.lang.String r7 = r19.getDirection()
            java.lang.String r8 = "in"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x0048
            java.lang.String r7 = "+"
            goto L_0x004a
        L_0x0048:
            java.lang.String r7 = "-"
        L_0x004a:
            r9 = 2132025944(0x7f142258, float:1.9690407E38)
            java.lang.String r9 = r2.getString(r9)
            r10 = 2
            java.lang.Object[] r11 = new java.lang.Object[r10]
            r12 = 0
            r11[r12] = r7
            java.lang.String r7 = r19.getPoints()
            r13 = 12
            r14 = 8
            java.lang.String r7 = i6.m.u0(r7, r13, r14)
            java.lang.String r7 = i6.m.p0(r7)
            r15 = 1
            r11[r15] = r7
            java.lang.String r7 = java.lang.String.format(r9, r11)
            r4.setText(r7)
            java.lang.String r7 = r19.getDirection()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x0086
            r7 = 2131100804(0x7f060484, float:1.7814E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r7)
            r4.setTextColor(r2)
            goto L_0x0090
        L_0x0086:
            r7 = 2131100806(0x7f060486, float:1.7814004E38)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r7)
            r4.setTextColor(r2)
        L_0x0090:
            long r7 = r19.getUpdatedAt()
            java.lang.String r2 = com.hbg.lib.common.utils.DateTimeUtils.C(r7)
            r6.setText(r2)
            java.lang.String r2 = r19.getType()
            r2.hashCode()
            int r4 = r2.hashCode()
            r6 = -1
            switch(r4) {
                case -2144670100: goto L_0x017e;
                case -2008845753: goto L_0x0172;
                case -1944413128: goto L_0x0166;
                case -1537147903: goto L_0x015a;
                case -1370390916: goto L_0x014e;
                case -1331214714: goto L_0x0142;
                case -1003958166: goto L_0x0136;
                case -374103039: goto L_0x012a;
                case -224123038: goto L_0x011e;
                case 166516447: goto L_0x0111;
                case 507502302: goto L_0x0104;
                case 759030491: goto L_0x00f7;
                case 867048660: goto L_0x00ee;
                case 1075992713: goto L_0x00e1;
                case 1186323377: goto L_0x00d4;
                case 1483145232: goto L_0x00c7;
                case 1743324417: goto L_0x00ba;
                case 1987642980: goto L_0x00ad;
                default: goto L_0x00aa;
            }
        L_0x00aa:
            r13 = r6
            goto L_0x0189
        L_0x00ad:
            java.lang.String r4 = "limit-point-transfer-in-auto"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x00b6
            goto L_0x00aa
        L_0x00b6:
            r13 = 17
            goto L_0x0189
        L_0x00ba:
            java.lang.String r4 = "purchase"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x00c3
            goto L_0x00aa
        L_0x00c3:
            r13 = 16
            goto L_0x0189
        L_0x00c7:
            java.lang.String r4 = "global-force-system-to-point"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x00d0
            goto L_0x00aa
        L_0x00d0:
            r13 = 15
            goto L_0x0189
        L_0x00d4:
            java.lang.String r4 = "mine-pool-pay"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x00dd
            goto L_0x00aa
        L_0x00dd:
            r13 = 14
            goto L_0x0189
        L_0x00e1:
            java.lang.String r4 = "activity-transfer-in"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x00ea
            goto L_0x00aa
        L_0x00ea:
            r13 = 13
            goto L_0x0189
        L_0x00ee:
            java.lang.String r4 = "master-point-transfer-out"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0189
            goto L_0x00aa
        L_0x00f7:
            java.lang.String r4 = "limit-point-transfer-out"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0100
            goto L_0x00aa
        L_0x0100:
            r13 = 11
            goto L_0x0189
        L_0x0104:
            java.lang.String r4 = "fee-deduction"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x010d
            goto L_0x00aa
        L_0x010d:
            r13 = 10
            goto L_0x0189
        L_0x0111:
            java.lang.String r4 = "master-point-transfer-in"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x011a
            goto L_0x00aa
        L_0x011a:
            r13 = 9
            goto L_0x0189
        L_0x011e:
            java.lang.String r4 = "point-buy-back-point-to-system"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0127
            goto L_0x00aa
        L_0x0127:
            r13 = r14
            goto L_0x0189
        L_0x012a:
            java.lang.String r4 = "super-margin-interest-deduct-repay"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0134
            goto L_0x00aa
        L_0x0134:
            r13 = 7
            goto L_0x0189
        L_0x0136:
            java.lang.String r4 = "activity-transfer-out"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0140
            goto L_0x00aa
        L_0x0140:
            r13 = 6
            goto L_0x0189
        L_0x0142:
            java.lang.String r4 = "brokerage"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x014c
            goto L_0x00aa
        L_0x014c:
            r13 = 5
            goto L_0x0189
        L_0x014e:
            java.lang.String r4 = "purchase-gift"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0158
            goto L_0x00aa
        L_0x0158:
            r13 = 4
            goto L_0x0189
        L_0x015a:
            java.lang.String r4 = "margin-interest-deduction"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0164
            goto L_0x00aa
        L_0x0164:
            r13 = 3
            goto L_0x0189
        L_0x0166:
            java.lang.String r4 = "global-force-point-to-system"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0170
            goto L_0x00aa
        L_0x0170:
            r13 = r10
            goto L_0x0189
        L_0x0172:
            java.lang.String r4 = "transfer-in"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x017c
            goto L_0x00aa
        L_0x017c:
            r13 = r15
            goto L_0x0189
        L_0x017e:
            java.lang.String r4 = "transfer-out"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0188
            goto L_0x00aa
        L_0x0188:
            r13 = r12
        L_0x0189:
            r2 = 2132025949(0x7f14225d, float:1.9690417E38)
            switch(r13) {
                case 0: goto L_0x0223;
                case 1: goto L_0x0219;
                case 2: goto L_0x020f;
                case 3: goto L_0x0205;
                case 4: goto L_0x01fe;
                case 5: goto L_0x01f4;
                case 6: goto L_0x01ed;
                case 7: goto L_0x0205;
                case 8: goto L_0x01e3;
                case 9: goto L_0x01d9;
                case 10: goto L_0x01cf;
                case 11: goto L_0x020f;
                case 12: goto L_0x01d9;
                case 13: goto L_0x01c5;
                case 14: goto L_0x01bb;
                case 15: goto L_0x01b0;
                case 16: goto L_0x01a5;
                case 17: goto L_0x019a;
                default: goto L_0x018f;
            }
        L_0x018f:
            r1.setVisibility(r14)
            r1 = 2132018443(0x7f14050b, float:1.9675193E38)
            r3.setText(r1)
            goto L_0x022c
        L_0x019a:
            r1.setVisibility(r14)
            r1 = 2132025990(0x7f142286, float:1.96905E38)
            r3.setText(r1)
            goto L_0x022c
        L_0x01a5:
            r1.setVisibility(r14)
            r1 = 2132025954(0x7f142262, float:1.9690427E38)
            r3.setText(r1)
            goto L_0x022c
        L_0x01b0:
            r1.setVisibility(r14)
            r1 = 2132020122(0x7f140b9a, float:1.9678598E38)
            r3.setText(r1)
            goto L_0x022c
        L_0x01bb:
            r1.setVisibility(r14)
            r1 = 2132025953(0x7f142261, float:1.9690425E38)
            r3.setText(r1)
            goto L_0x022c
        L_0x01c5:
            r1.setVisibility(r14)
            r1 = 2132025948(0x7f14225c, float:1.9690415E38)
            r3.setText(r1)
            goto L_0x022c
        L_0x01cf:
            r1.setVisibility(r14)
            r1 = 2132025951(0x7f14225f, float:1.969042E38)
            r3.setText(r1)
            goto L_0x022c
        L_0x01d9:
            r1.setVisibility(r14)
            r1 = 2132026014(0x7f14229e, float:1.9690549E38)
            r3.setText(r1)
            goto L_0x022c
        L_0x01e3:
            r1.setVisibility(r14)
            r1 = 2132024022(0x7f141ad6, float:1.9686508E38)
            r3.setText(r1)
            goto L_0x022c
        L_0x01ed:
            r1.setVisibility(r14)
            r3.setText(r2)
            goto L_0x022c
        L_0x01f4:
            r1.setVisibility(r14)
            r1 = 2132025950(0x7f14225e, float:1.9690419E38)
            r3.setText(r1)
            goto L_0x022c
        L_0x01fe:
            r1.setVisibility(r14)
            r3.setText(r2)
            goto L_0x022c
        L_0x0205:
            r1.setVisibility(r14)
            r1 = 2132025952(0x7f142260, float:1.9690423E38)
            r3.setText(r1)
            goto L_0x022c
        L_0x020f:
            r1.setVisibility(r14)
            r1 = 2132026032(0x7f1422b0, float:1.9690585E38)
            r3.setText(r1)
            goto L_0x022c
        L_0x0219:
            r1.setVisibility(r12)
            r1 = 2132027291(0x7f14279b, float:1.9693139E38)
            r3.setText(r1)
            goto L_0x022c
        L_0x0223:
            r1.setVisibility(r12)
            r1 = 2132019684(0x7f1409e4, float:1.967771E38)
            r3.setText(r1)
        L_0x022c:
            java.lang.String r1 = r19.getState()
            r1.hashCode()
            int r2 = r1.hashCode()
            switch(r2) {
                case -1279552451: goto L_0x0250;
                case -673660814: goto L_0x0245;
                case 1959784951: goto L_0x023c;
                default: goto L_0x023a;
            }
        L_0x023a:
            r10 = r6
            goto L_0x025a
        L_0x023c:
            java.lang.String r2 = "invalid"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x025a
            goto L_0x023a
        L_0x0245:
            java.lang.String r2 = "finished"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x024e
            goto L_0x023a
        L_0x024e:
            r10 = r15
            goto L_0x025a
        L_0x0250:
            java.lang.String r2 = "prepared"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0259
            goto L_0x023a
        L_0x0259:
            r10 = r12
        L_0x025a:
            switch(r10) {
                case 0: goto L_0x026c;
                case 1: goto L_0x0265;
                case 2: goto L_0x025e;
                default: goto L_0x025d;
            }
        L_0x025d:
            goto L_0x0272
        L_0x025e:
            r1 = 2132025946(0x7f14225a, float:1.969041E38)
            r5.setText(r1)
            goto L_0x0272
        L_0x0265:
            r1 = 2132025945(0x7f142259, float:1.9690409E38)
            r5.setText(r1)
            goto L_0x0272
        L_0x026c:
            r1 = 2132025947(0x7f14225b, float:1.9690413E38)
            r5.setText(r1)
        L_0x0272:
            android.view.View r1 = r0.itemView
            r2 = 2131431239(0x7f0b0f47, float:1.8484202E38)
            r3 = r19
            r1.setTag(r2, r3)
            android.view.View r0 = r0.itemView
            r1 = r16
            r0.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.points.viewhandler.PointsActionViewHandler.handleView(v9.c, int, com.huobi.points.entity.PointsAction, android.view.ViewGroup):void");
    }

    public int getResId() {
        return R.layout.item_points_action;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        PointsAction pointsAction = (PointsAction) view.getTag(R.id.item_data1);
        if (PointsAction.TYPE_TRANSFER_OUT.equals(pointsAction.getType()) || PointsAction.TYPE_TRANSFER_IN.equals(pointsAction.getType())) {
            PointsHistoryDetailsActivity.fg(view.getContext(), pointsAction);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
