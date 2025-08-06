package com.hbg.module.huobi.im.gift.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend;
import com.hbg.module.huobi.im.gift.d;
import com.huobi.view.button.StatusButton;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import i6.r;
import java.util.HashMap;
import ld.e;
import ld.f;
import rd.q;
import rd.s;

public final class LiveGiftShowDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public float f19802b;

    /* renamed from: c  reason: collision with root package name */
    public float f19803c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f19804d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19805e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19806f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f19807g;

    /* renamed from: h  reason: collision with root package name */
    public SafeLottieView f19808h;

    /* renamed from: i  reason: collision with root package name */
    public StatusButton f19809i;

    /* renamed from: j  reason: collision with root package name */
    public SafeLottieView f19810j;

    /* renamed from: k  reason: collision with root package name */
    public View f19811k;

    /* renamed from: l  reason: collision with root package name */
    public ImageView f19812l;

    /* renamed from: m  reason: collision with root package name */
    public f f19813m = new f((e) null);

    /* renamed from: n  reason: collision with root package name */
    public CusMsgGiftSend f19814n;

    /* renamed from: o  reason: collision with root package name */
    public a f19815o;

    /* renamed from: p  reason: collision with root package name */
    public Animation f19816p;

    /* renamed from: q  reason: collision with root package name */
    public Animation f19817q;

    /* renamed from: r  reason: collision with root package name */
    public ScaleAnimation f19818r;

    public interface a {
        void a();

        void onCloseClick();
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f19819b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f19820c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveGiftShowDialog f19821d;

        public b(View view, long j11, LiveGiftShowDialog liveGiftShowDialog) {
            this.f19819b = view;
            this.f19820c = j11;
            this.f19821d = liveGiftShowDialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f19819b) > this.f19820c || (this.f19819b instanceof Checkable)) {
                sVar.e(this.f19819b, currentTimeMillis);
                StatusButton statusButton = (StatusButton) this.f19819b;
                StatusButton zh2 = this.f19821d.zh();
                if (zh2 != null) {
                    zh2.showAnim();
                }
                a yh2 = this.f19821d.yh();
                if (yh2 != null) {
                    yh2.a();
                }
                this.f19821d.Bh("APP_LIVE_giftbox_luckdrawclk");
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f19822b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f19823c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveGiftShowDialog f19824d;

        public c(View view, long j11, LiveGiftShowDialog liveGiftShowDialog) {
            this.f19822b = view;
            this.f19823c = j11;
            this.f19824d = liveGiftShowDialog;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f19822b) > this.f19823c || (this.f19822b instanceof Checkable)) {
                sVar.e(this.f19822b, currentTimeMillis);
                RelativeLayout relativeLayout = (RelativeLayout) this.f19822b;
                StatusButton zh2 = this.f19824d.zh();
                if (zh2 != null) {
                    zh2.showAnim();
                }
                a yh2 = this.f19824d.yh();
                if (yh2 != null) {
                    yh2.a();
                }
                this.f19824d.Bh("APP_LIVE_giftbox_luckdrawclk");
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public LiveGiftShowDialog(float f11, float f12) {
        this.f19802b = f11;
        this.f19803c = f12;
    }

    @SensorsDataInstrumented
    public static final void vh(LiveGiftShowDialog liveGiftShowDialog, View view) {
        a aVar = liveGiftShowDialog.f19815o;
        if (aVar != null) {
            aVar.onCloseClick();
        }
        liveGiftShowDialog.Bh("APP_LIVE_giftbox_luckdrawclose");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void wh(LiveGiftShowDialog liveGiftShowDialog) {
        super.dismiss();
    }

    public final void Ah(a aVar) {
        this.f19815o = aVar;
    }

    public final void Bh(String str) {
        Object rule;
        HashMap hashMap = new HashMap();
        d dVar = d.f19724a;
        String k11 = dVar.k();
        if (k11 == null) {
            k11 = "";
        }
        hashMap.put("groupid", k11);
        String p11 = dVar.p();
        if (p11 == null) {
            p11 = "";
        }
        hashMap.put("liveid", p11);
        Object obj = "1";
        hashMap.put(VineCardUtils.PLAYER_CARD, obj);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        CusMsgGiftSend cusMsgGiftSend = this.f19814n;
        if (!(cusMsgGiftSend == null || (rule = cusMsgGiftSend.getRule()) == null)) {
            obj = rule;
        }
        sb2.append(obj);
        hashMap.put("lotterytype", sb2.toString());
        q.a(str, hashMap);
    }

    public void addEvent(r rVar) {
        StatusButton statusButton = this.f19809i;
        if (statusButton != null) {
            s sVar = s.f23381a;
            statusButton.setOnClickListener(new b(statusButton, 800, this));
        }
        RelativeLayout relativeLayout = this.f19807g;
        if (relativeLayout != null) {
            s sVar2 = s.f23381a;
            relativeLayout.setOnClickListener(new c(relativeLayout, 800, this));
        }
        ImageView imageView = this.f19804d;
        if (imageView != null) {
            imageView.setOnClickListener(new id.s(this));
        }
    }

    public void afterInit() {
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [android.view.animation.Animation] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dismiss() {
        /*
            r11 = this;
            android.widget.ImageView r0 = r11.f19804d
            r1 = 4
            if (r0 != 0) goto L_0x0006
            goto L_0x0009
        L_0x0006:
            r0.setVisibility(r1)
        L_0x0009:
            android.widget.TextView r0 = r11.f19805e
            if (r0 != 0) goto L_0x000e
            goto L_0x0011
        L_0x000e:
            r0.setVisibility(r1)
        L_0x0011:
            android.widget.TextView r0 = r11.f19806f
            if (r0 != 0) goto L_0x0016
            goto L_0x0019
        L_0x0016:
            r0.setVisibility(r1)
        L_0x0019:
            com.huobi.view.button.StatusButton r0 = r11.f19809i
            if (r0 == 0) goto L_0x0020
            r0.clearAnimation()
        L_0x0020:
            com.hbg.lib.widgets.SafeLottieView r0 = r11.f19810j
            if (r0 == 0) goto L_0x0027
            r0.clearAnimation()
        L_0x0027:
            com.huobi.view.button.StatusButton r0 = r11.f19809i
            if (r0 != 0) goto L_0x002c
            goto L_0x002f
        L_0x002c:
            r0.setVisibility(r1)
        L_0x002f:
            com.hbg.lib.widgets.SafeLottieView r0 = r11.f19810j
            if (r0 != 0) goto L_0x0034
            goto L_0x0037
        L_0x0034:
            r0.setVisibility(r1)
        L_0x0037:
            android.view.animation.ScaleAnimation r0 = new android.view.animation.ScaleAnimation
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            r7 = 0
            float r8 = r11.f19802b
            r9 = 0
            float r10 = r11.f19803c
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = 300(0x12c, double:1.48E-321)
            r0.setDuration(r1)
            android.content.Context r3 = r11.getContext()
            int r4 = com.hbg.module.huobi.im.R$anim.im_anim_gift_close_right
            android.view.animation.Animation r3 = android.view.animation.AnimationUtils.loadAnimation(r3, r4)
            android.view.View r4 = r11.f19811k
            if (r4 == 0) goto L_0x006c
            float r5 = r11.f19802b
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 != 0) goto L_0x0065
            r5 = 1
            goto L_0x0066
        L_0x0065:
            r5 = 0
        L_0x0066:
            if (r5 == 0) goto L_0x0069
            r0 = r3
        L_0x0069:
            r4.startAnimation(r0)
        L_0x006c:
            android.view.View r0 = r11.f19811k
            if (r0 == 0) goto L_0x0078
            id.t r3 = new id.t
            r3.<init>(r11)
            r0.postDelayed(r3, r1)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.gift.ui.LiveGiftShowDialog.dismiss():void");
    }

    public int getContentViewResId() {
        return R$layout.layout_live_gift_box;
    }

    public long getDuration() {
        return 0;
    }

    public int getGravity() {
        return 0;
    }

    /* JADX WARNING: type inference failed for: r11v18, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView(i6.r r11) {
        /*
            r10 = this;
            android.os.Bundle r0 = r10.getArguments()
            r1 = 0
            if (r0 == 0) goto L_0x0010
            java.lang.String r2 = "live_gift_send_bean"
            android.os.Parcelable r0 = r0.getParcelable(r2)
            com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r0 = (com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend) r0
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            r10.f19814n = r0
            if (r11 == 0) goto L_0x001e
            int r0 = com.hbg.module.huobi.im.R$id.ivLiveGiftBoxClose
            android.view.View r0 = r11.b(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            goto L_0x001f
        L_0x001e:
            r0 = r1
        L_0x001f:
            r10.f19804d = r0
            if (r11 == 0) goto L_0x002c
            int r0 = com.hbg.module.huobi.im.R$id.tvLiveGiftBoxTitle
            android.view.View r0 = r11.b(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x002d
        L_0x002c:
            r0 = r1
        L_0x002d:
            r10.f19805e = r0
            if (r11 == 0) goto L_0x003a
            int r0 = com.hbg.module.huobi.im.R$id.tvLiveGiftBoxMsg
            android.view.View r0 = r11.b(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x003b
        L_0x003a:
            r0 = r1
        L_0x003b:
            r10.f19806f = r0
            if (r11 == 0) goto L_0x0048
            int r0 = com.hbg.module.huobi.im.R$id.rlGift
            android.view.View r0 = r11.b(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            goto L_0x0049
        L_0x0048:
            r0 = r1
        L_0x0049:
            r10.f19807g = r0
            if (r11 == 0) goto L_0x0056
            int r0 = com.hbg.module.huobi.im.R$id.ivLiveGiftBox
            android.view.View r0 = r11.b(r0)
            com.hbg.lib.widgets.SafeLottieView r0 = (com.hbg.lib.widgets.SafeLottieView) r0
            goto L_0x0057
        L_0x0056:
            r0 = r1
        L_0x0057:
            r10.f19808h = r0
            if (r11 == 0) goto L_0x0064
            int r0 = com.hbg.module.huobi.im.R$id.sbLiveGiftBoxButton
            android.view.View r0 = r11.b(r0)
            com.huobi.view.button.StatusButton r0 = (com.huobi.view.button.StatusButton) r0
            goto L_0x0065
        L_0x0064:
            r0 = r1
        L_0x0065:
            r10.f19809i = r0
            if (r11 == 0) goto L_0x0072
            int r0 = com.hbg.module.huobi.im.R$id.slvGiftBoxButton
            android.view.View r0 = r11.b(r0)
            com.hbg.lib.widgets.SafeLottieView r0 = (com.hbg.lib.widgets.SafeLottieView) r0
            goto L_0x0073
        L_0x0072:
            r0 = r1
        L_0x0073:
            r10.f19810j = r0
            if (r11 == 0) goto L_0x007e
            int r0 = com.hbg.module.huobi.im.R$id.layoutGiftDialogRoot
            android.view.View r0 = r11.b(r0)
            goto L_0x007f
        L_0x007e:
            r0 = r1
        L_0x007f:
            r10.f19811k = r0
            if (r11 == 0) goto L_0x008c
            int r0 = com.hbg.module.huobi.im.R$id.ivLiveGiftBoxBg
            android.view.View r11 = r11.b(r0)
            r1 = r11
            android.widget.ImageView r1 = (android.widget.ImageView) r1
        L_0x008c:
            r10.f19812l = r1
            android.widget.TextView r11 = r10.f19805e
            java.lang.String r0 = ""
            if (r11 != 0) goto L_0x0095
            goto L_0x00a4
        L_0x0095:
            com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r1 = r10.f19814n
            if (r1 == 0) goto L_0x00a0
            java.lang.String r1 = r1.getTitle()
            if (r1 == 0) goto L_0x00a0
            goto L_0x00a1
        L_0x00a0:
            r1 = r0
        L_0x00a1:
            r11.setText(r1)
        L_0x00a4:
            android.widget.TextView r11 = r10.f19806f
            if (r11 != 0) goto L_0x00a9
            goto L_0x00b7
        L_0x00a9:
            com.hbg.module.huobi.im.gift.bean.CusMsgGiftSend r1 = r10.f19814n
            if (r1 == 0) goto L_0x00b4
            java.lang.String r1 = r1.getSubtitle()
            if (r1 == 0) goto L_0x00b4
            r0 = r1
        L_0x00b4:
            r11.setText(r0)
        L_0x00b7:
            java.lang.String r11 = "APP_LIVE_giftbox_luckdraw"
            r10.Bh(r11)
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            r0 = 0
            if (r11 == 0) goto L_0x011b
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            r1 = 1
            if (r11 == 0) goto L_0x00d1
            boolean r11 = r11.isFinishing()
            if (r11 != r1) goto L_0x00d1
            goto L_0x00d2
        L_0x00d1:
            r1 = r0
        L_0x00d2:
            if (r1 != 0) goto L_0x011b
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            int r1 = com.hbg.module.huobi.im.R$anim.live_gift_bg_light
            android.view.animation.Animation r11 = android.view.animation.AnimationUtils.loadAnimation(r11, r1)
            r10.f19817q = r11
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            int r1 = com.hbg.module.huobi.im.R$anim.live_gift_bg_light_alpha
            android.view.animation.Animation r11 = android.view.animation.AnimationUtils.loadAnimation(r11, r1)
            r10.f19816p = r11
            android.view.animation.ScaleAnimation r11 = new android.view.animation.ScaleAnimation
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1065772646(0x3f866666, float:1.05)
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 1065772646(0x3f866666, float:1.05)
            r6 = 1
            r7 = 1056964608(0x3f000000, float:0.5)
            r8 = 1
            r9 = 1056964608(0x3f000000, float:0.5)
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r10.f19818r = r11
            r1 = 2
            r11.setRepeatMode(r1)
            android.view.animation.ScaleAnimation r11 = r10.f19818r
            if (r11 != 0) goto L_0x010d
            goto L_0x0111
        L_0x010d:
            r1 = -1
            r11.setRepeatCount(r1)
        L_0x0111:
            android.view.animation.ScaleAnimation r11 = r10.f19818r
            if (r11 != 0) goto L_0x0116
            goto L_0x011b
        L_0x0116:
            r1 = 1000(0x3e8, double:4.94E-321)
            r11.setDuration(r1)
        L_0x011b:
            android.view.animation.Animation r11 = r10.f19817q
            if (r11 == 0) goto L_0x0126
            com.hbg.lib.widgets.SafeLottieView r1 = r10.f19808h
            if (r1 == 0) goto L_0x0126
            r1.startAnimation(r11)
        L_0x0126:
            android.view.animation.Animation r11 = r10.f19816p
            if (r11 == 0) goto L_0x0131
            android.widget.ImageView r1 = r10.f19812l
            if (r1 == 0) goto L_0x0131
            r1.startAnimation(r11)
        L_0x0131:
            com.huobi.view.button.StatusButton r11 = r10.f19809i
            if (r11 == 0) goto L_0x013a
            android.view.animation.ScaleAnimation r1 = r10.f19818r
            r11.startAnimation(r1)
        L_0x013a:
            com.hbg.lib.widgets.SafeLottieView r11 = r10.f19810j
            if (r11 == 0) goto L_0x0143
            android.view.animation.ScaleAnimation r1 = r10.f19818r
            r11.startAnimation(r1)
        L_0x0143:
            r10.setCancelable(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.gift.ui.LiveGiftShowDialog.initView(i6.r):void");
    }

    public boolean isTransparent() {
        return false;
    }

    public final void xh() {
        super.dismiss();
    }

    public final a yh() {
        return this.f19815o;
    }

    public final StatusButton zh() {
        return this.f19809i;
    }
}
