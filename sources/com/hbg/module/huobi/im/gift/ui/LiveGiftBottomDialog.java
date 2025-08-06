package com.hbg.module.huobi.im.gift.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import id.b;
import id.c;

public final class LiveGiftBottomDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f19756b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19757c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19758d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19759e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f19760f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView f19761g;

    /* renamed from: h  reason: collision with root package name */
    public CusMsgGiftSend f19762h;

    /* renamed from: i  reason: collision with root package name */
    public long f19763i = 300;

    /* renamed from: j  reason: collision with root package name */
    public a f19764j;

    public interface a {
        void b();

        void c();
    }

    public static final void Bh(LiveGiftBottomDialog liveGiftBottomDialog) {
        liveGiftBottomDialog.Ah();
    }

    @SensorsDataInstrumented
    public static final void wh(LiveGiftBottomDialog liveGiftBottomDialog, View view) {
        a aVar = liveGiftBottomDialog.f19764j;
        if (aVar != null) {
            aVar.b();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void xh(LiveGiftBottomDialog liveGiftBottomDialog, View view) {
        liveGiftBottomDialog.dismiss();
        a aVar = liveGiftBottomDialog.f19764j;
        if (aVar != null) {
            aVar.c();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void yh(LiveGiftBottomDialog liveGiftBottomDialog, View view) {
        liveGiftBottomDialog.dismiss();
        a aVar = liveGiftBottomDialog.f19764j;
        if (aVar != null) {
            aVar.c();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        r0 = r0.getStartTime();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Ah() {
        /*
            r13 = this;
            boolean r0 = r13.isDetached()
            java.lang.String r1 = "LiveGiftBottomDialog"
            if (r0 == 0) goto L_0x000e
            java.lang.String r0 = "关闭窗口，退出递归"
            com.tencent.imsdk.common.IMLog.d(r1, r0)
            return
        L_0x000e:
            kotlin.Result$a r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00a1 }
            com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r0 = r13.f19762h     // Catch:{ all -> 0x00a1 }
            r2 = 0
            if (r0 == 0) goto L_0x0021
            java.lang.Long r0 = r0.getStartTime()     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x0021
            long r4 = r0.longValue()     // Catch:{ all -> 0x00a1 }
            goto L_0x0022
        L_0x0021:
            r4 = r2
        L_0x0022:
            com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r0 = r13.f19762h     // Catch:{ all -> 0x00a1 }
            r6 = 0
            if (r0 == 0) goto L_0x0032
            java.lang.Integer r0 = r0.getPrizeTime()     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x0032
            int r0 = r0.intValue()     // Catch:{ all -> 0x00a1 }
            goto L_0x0033
        L_0x0032:
            r0 = r6
        L_0x0033:
            int r0 = r0 * 1000
            long r7 = (long) r0     // Catch:{ all -> 0x00a1 }
            long r4 = r4 + r7
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00a1 }
            long r4 = r4 - r7
            java.lang.String r0 = com.hbg.module.huobi.im.utils.DateUtils.c(r4)     // Catch:{ all -> 0x00a1 }
            kotlin.jvm.internal.d0 r7 = kotlin.jvm.internal.d0.f56774a     // Catch:{ all -> 0x00a1 }
            int r7 = com.hbg.module.huobi.im.R$string.n_content_live_get_gift_wait_after     // Catch:{ all -> 0x00a1 }
            java.lang.String r7 = r13.getString(r7)     // Catch:{ all -> 0x00a1 }
            r8 = 1
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x00a1 }
            r9[r6] = r0     // Catch:{ all -> 0x00a1 }
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r9, r8)     // Catch:{ all -> 0x00a1 }
            java.lang.String r7 = java.lang.String.format(r7, r6)     // Catch:{ all -> 0x00a1 }
            android.text.SpannableStringBuilder r6 = new android.text.SpannableStringBuilder     // Catch:{ all -> 0x00a1 }
            r6.<init>(r7)     // Catch:{ all -> 0x00a1 }
            r9 = 0
            r10 = 0
            r11 = 6
            r12 = 0
            r8 = r0
            int r7 = kotlin.text.StringsKt__StringsKt.g0(r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00a1 }
            android.text.style.ForegroundColorSpan r8 = new android.text.style.ForegroundColorSpan     // Catch:{ all -> 0x00a1 }
            android.content.res.Resources r9 = r13.getResources()     // Catch:{ all -> 0x00a1 }
            int r10 = com.hbg.module.huobi.im.R$color.COLOR_FF842C     // Catch:{ all -> 0x00a1 }
            int r9 = r9.getColor(r10)     // Catch:{ all -> 0x00a1 }
            r8.<init>(r9)     // Catch:{ all -> 0x00a1 }
            int r0 = r0.length()     // Catch:{ all -> 0x00a1 }
            int r0 = r0 + r7
            r9 = 34
            r6.setSpan(r8, r7, r0, r9)     // Catch:{ all -> 0x00a1 }
            android.widget.TextView r0 = r13.f19758d     // Catch:{ all -> 0x00a1 }
            if (r0 != 0) goto L_0x0081
            goto L_0x0084
        L_0x0081:
            r0.setText(r6)     // Catch:{ all -> 0x00a1 }
        L_0x0084:
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x009b
            java.lang.String r0 = "未关闭窗口，递归更新UI"
            com.tencent.imsdk.common.IMLog.d(r1, r0)     // Catch:{ all -> 0x00a1 }
            android.widget.TextView r0 = r13.f19758d     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x009b
            id.d r1 = new id.d     // Catch:{ all -> 0x00a1 }
            r1.<init>(r13)     // Catch:{ all -> 0x00a1 }
            r2 = 1000(0x3e8, double:4.94E-321)
            r0.postDelayed(r1, r2)     // Catch:{ all -> 0x00a1 }
        L_0x009b:
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x00a1 }
            kotlin.Result.m3072constructorimpl(r0)     // Catch:{ all -> 0x00a1 }
            goto L_0x00ab
        L_0x00a1:
            r0 = move-exception
            kotlin.Result$a r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.k.a(r0)
            kotlin.Result.m3072constructorimpl(r0)
        L_0x00ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.gift.ui.LiveGiftBottomDialog.Ah():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r2 = r2.getTaskTime();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Ch() {
        /*
            r12 = this;
            int r0 = com.hbg.module.huobi.im.R$string.n_content_live_get_gift_wait_time
            java.lang.String r0 = r12.getString(r0)
            android.content.Context r1 = r12.getContext()
            com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r2 = r12.f19762h
            r3 = 0
            if (r2 == 0) goto L_0x001a
            java.lang.Integer r2 = r2.getTaskTime()
            if (r2 == 0) goto L_0x001a
            int r2 = r2.intValue()
            goto L_0x001b
        L_0x001a:
            r2 = r3
        L_0x001b:
            long r4 = (long) r2
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r6
            java.lang.String r1 = com.hbg.module.huobi.im.utils.DateUtils.d(r1, r4)
            kotlin.jvm.internal.d0 r2 = kotlin.jvm.internal.d0.f56774a
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]
            r4[r3] = r1
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r4, r2)
            java.lang.String r6 = java.lang.String.format(r0, r2)
            android.text.SpannableStringBuilder r0 = new android.text.SpannableStringBuilder
            r0.<init>(r6)
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            r7 = r1
            int r2 = kotlin.text.StringsKt__StringsKt.g0(r6, r7, r8, r9, r10, r11)
            android.text.style.ForegroundColorSpan r3 = new android.text.style.ForegroundColorSpan
            android.content.res.Resources r4 = r12.getResources()
            int r5 = com.hbg.module.huobi.im.R$color.COLOR_FF842C
            int r4 = r4.getColor(r5)
            r3.<init>(r4)
            int r1 = r1.length()
            int r1 = r1 + r2
            r4 = 34
            r0.setSpan(r3, r2, r1, r4)
            android.widget.TextView r1 = r12.f19758d
            if (r1 != 0) goto L_0x005e
            goto L_0x0061
        L_0x005e:
            r1.setText(r0)
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.gift.ui.LiveGiftBottomDialog.Ch():void");
    }

    public void addEvent(r rVar) {
        ImageView imageView = this.f19756b;
        if (imageView != null) {
            imageView.setOnClickListener(new c(this));
        }
        TextView textView = this.f19759e;
        if (textView != null) {
            textView.setOnClickListener(new id.a(this));
        }
        ImageView imageView2 = this.f19760f;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new b(this));
        }
    }

    public void afterInit() {
    }

    public int getContentViewResId() {
        return R$layout.im_layout_live_gift_bottom_pop;
    }

    public long getDuration() {
        return this.f19763i;
    }

    public int getGravity() {
        return 80;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView(i6.r r6) {
        /*
            r5 = this;
            android.os.Bundle r0 = r5.getArguments()
            r1 = 0
            if (r0 == 0) goto L_0x0010
            java.lang.String r2 = "live_gift_send_bean"
            android.os.Parcelable r0 = r0.getParcelable(r2)
            com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r0 = (com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend) r0
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            r5.f19762h = r0
            if (r6 == 0) goto L_0x001e
            int r0 = com.hbg.module.huobi.im.R$id.tvLiveGiftBottomRule
            android.view.View r0 = r6.b(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x001f
        L_0x001e:
            r0 = r1
        L_0x001f:
            r5.f19756b = r0
            if (r6 == 0) goto L_0x002c
            int r0 = com.hbg.module.huobi.im.R$id.tvLiveGiftBottomTitle
            android.view.View r0 = r6.b(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x002d
        L_0x002c:
            r0 = r1
        L_0x002d:
            r5.f19757c = r0
            if (r6 == 0) goto L_0x003a
            int r0 = com.hbg.module.huobi.im.R$id.tvLiveGiftBottomTime
            android.view.View r0 = r6.b(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x003b
        L_0x003a:
            r0 = r1
        L_0x003b:
            r5.f19758d = r0
            if (r6 == 0) goto L_0x0048
            int r0 = com.hbg.module.huobi.im.R$id.tvLiveGiftBottomOk
            android.view.View r0 = r6.b(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x0049
        L_0x0048:
            r0 = r1
        L_0x0049:
            r5.f19759e = r0
            if (r6 == 0) goto L_0x0056
            int r0 = com.hbg.module.huobi.im.R$id.ivLiveGiftBottomClose
            android.view.View r0 = r6.b(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x0057
        L_0x0056:
            r0 = r1
        L_0x0057:
            r5.f19760f = r0
            if (r6 == 0) goto L_0x0064
            int r0 = com.hbg.module.huobi.im.R$id.rvLiveGiftBottom
            android.view.View r6 = r6.b(r0)
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            goto L_0x0065
        L_0x0064:
            r6 = r1
        L_0x0065:
            r5.f19761g = r6
            com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r6 = r5.f19762h
            r0 = 0
            if (r6 == 0) goto L_0x0097
            java.util.List r6 = r6.getPrizeList()
            if (r6 == 0) goto L_0x0097
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r3 = r5.getContext()
            r2.<init>(r3)
            r2.setOrientation(r0)
            androidx.recyclerview.widget.RecyclerView r3 = r5.f19761g
            if (r3 != 0) goto L_0x0083
            goto L_0x0086
        L_0x0083:
            r3.setLayoutManager(r2)
        L_0x0086:
            androidx.recyclerview.widget.RecyclerView r2 = r5.f19761g
            if (r2 != 0) goto L_0x008b
            goto L_0x0097
        L_0x008b:
            id.e r3 = new id.e
            android.content.Context r4 = r5.requireContext()
            r3.<init>(r4, r6)
            r2.setAdapter(r3)
        L_0x0097:
            android.widget.TextView r6 = r5.f19757c
            if (r6 != 0) goto L_0x009c
            goto L_0x00a7
        L_0x009c:
            com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r2 = r5.f19762h
            if (r2 == 0) goto L_0x00a4
            java.lang.String r1 = r2.getTitle()
        L_0x00a4:
            r6.setText(r1)
        L_0x00a7:
            com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r6 = r5.f19762h
            r1 = 1
            if (r6 == 0) goto L_0x00c1
            java.lang.Integer r6 = r6.getRule()
            com.hbg.module.huobi.im.utils.LiveGiftRule r2 = com.hbg.module.huobi.im.utils.LiveGiftRule.RULE_TASK
            int r2 = r2.getValue()
            if (r6 != 0) goto L_0x00b9
            goto L_0x00c1
        L_0x00b9:
            int r6 = r6.intValue()
            if (r6 != r2) goto L_0x00c1
            r6 = r1
            goto L_0x00c2
        L_0x00c1:
            r6 = r0
        L_0x00c2:
            if (r6 == 0) goto L_0x00c7
            r5.Ch()
        L_0x00c7:
            com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r6 = r5.f19762h
            if (r6 == 0) goto L_0x00df
            java.lang.Integer r6 = r6.getRule()
            com.hbg.module.huobi.im.utils.LiveGiftRule r2 = com.hbg.module.huobi.im.utils.LiveGiftRule.RULE_FIXED_TIME
            int r2 = r2.getValue()
            if (r6 != 0) goto L_0x00d8
            goto L_0x00df
        L_0x00d8:
            int r6 = r6.intValue()
            if (r6 != r2) goto L_0x00df
            r0 = r1
        L_0x00df:
            if (r0 == 0) goto L_0x0119
            r5.Ah()
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            com.hbg.module.huobi.im.gift.d r0 = com.hbg.module.huobi.im.gift.d.f19724a
            java.lang.String r1 = r0.k()
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x00f4
            r1 = r2
        L_0x00f4:
            java.lang.String r3 = "groupid"
            r6.put(r3, r1)
            java.lang.String r0 = r0.p()
            if (r0 != 0) goto L_0x0100
            goto L_0x0101
        L_0x0100:
            r2 = r0
        L_0x0101:
            java.lang.String r0 = "liveid"
            r6.put(r0, r2)
            java.lang.String r0 = "player"
            java.lang.String r1 = "1"
            r6.put(r0, r1)
            java.lang.String r0 = "lotterytype"
            java.lang.String r1 = "2"
            r6.put(r0, r1)
            java.lang.String r0 = "APP_LIVE_notice_lucktiming"
            rd.q.a(r0, r6)
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.gift.ui.LiveGiftBottomDialog.initView(i6.r):void");
    }

    public boolean isTransparent() {
        return true;
    }

    public final void zh(a aVar) {
        this.f19764j = aVar;
    }
}
