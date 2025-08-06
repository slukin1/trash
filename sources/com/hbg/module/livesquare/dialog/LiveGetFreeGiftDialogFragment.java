package com.hbg.module.livesquare.dialog;

import af.b;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.R$string;
import com.hbg.module.content.helper.live.f;
import com.hbg.module.libkt.utils.event.bean.GiftBean;
import com.hbg.module.livesquare.bean.LiveGetGiftInfo;
import com.hbg.module.livesquare.bean.LiveIntegralList;
import com.huobi.utils.GsonHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import f6.c;
import i6.d;
import i6.r;
import java.util.ArrayList;
import java.util.Iterator;

public class LiveGetFreeGiftDialogFragment extends BaseDialogFragment implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public View f26488b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f26489c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f26490d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f26491e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f26492f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f26493g;

    /* renamed from: h  reason: collision with root package name */
    public EasyRecyclerView f26494h;

    /* renamed from: i  reason: collision with root package name */
    public a f26495i;

    public interface a {
        void a();

        void b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void uh() {
        this.f26492f.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = this.f26492f.getMeasuredWidth();
        TextView textView = this.f26491e;
        textView.setMaxWidth(((((View) textView.getParent()).getWidth() - this.f26489c.getWidth()) - measuredWidth) - ((RelativeLayout.LayoutParams) this.f26491e.getLayoutParams()).leftMargin);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void vh(View view, LiveGetGiftInfo liveGetGiftInfo) {
        a aVar;
        dismiss();
        int i11 = liveGetGiftInfo.type;
        if (i11 == 2) {
            a aVar2 = this.f26495i;
            if (aVar2 != null) {
                aVar2.a();
            }
        } else if (i11 == 6 && (aVar = this.f26495i) != null) {
            aVar.b();
        }
    }

    public void addEvent(r rVar) {
        this.f26488b.setOnClickListener(this);
        this.f26494h.setLayoutManager(new StableLinearLayoutManager(getActivity()));
    }

    public void afterInit() {
        wh(getArguments().getString("liveIntegralList"));
        GiftBean giftBean = (GiftBean) getArguments().getParcelable("live_free_bean");
        f fVar = f.f18246a;
        int c11 = fVar.c() >= 0 ? fVar.c() : 0;
        if (giftBean != null) {
            c.a().e(this.f26489c, giftBean.getUrlPng());
            if (giftBean.getUnlockIntegral() == 0) {
                this.f26490d.setMax(100);
                this.f26490d.setProgress(100);
            } else {
                this.f26490d.setMax(giftBean.getUnlockIntegral());
                this.f26490d.setProgress(c11);
            }
            if (giftBean.getUnlockIntegral() > c11) {
                String str = String.format(getResources().getString(R$string.n_live_gift_integral_unlock), new Object[]{String.valueOf(giftBean.getUnlockIntegral())}) + " ";
                String str2 = str + String.format(getResources().getString(R$string.n_live_gift_left_integral), new Object[]{String.valueOf(giftBean.getUnlockIntegral() - c11)});
                SpannableString spannableString = new SpannableString(str2);
                spannableString.setSpan(new ForegroundColorSpan(-16682011), str.length(), str2.length(), 33);
                this.f26493g.setText(spannableString);
            } else {
                this.f26493g.setText(String.format(getResources().getString(R$string.n_live_gift_integral_unlock), new Object[]{String.valueOf(giftBean.getUnlockIntegral())}));
            }
        }
        this.f26492f.setText(String.valueOf(c11));
        this.f26492f.post(new b(this));
    }

    public int getContentViewResId() {
        return R$layout.dialog_live_get_free_gift;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        setCanceledOnTouchOutside(true);
        this.f26488b = rVar.b(R$id.imgClose);
        this.f26489c = (ImageView) rVar.b(R$id.ivGift);
        this.f26490d = (ProgressBar) rVar.b(R$id.progressbar);
        this.f26491e = (TextView) rVar.b(R$id.tvCurrent);
        this.f26492f = (TextView) rVar.b(R$id.tvCurrentValue);
        this.f26493g = (TextView) rVar.b(R$id.tvGiftLock);
        this.f26494h = (EasyRecyclerView) rVar.b(R$id.easy_recycler_view);
    }

    public boolean isTransparent() {
        return false;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getDialog() != null) {
            getDialog().getWindow().setLayout(-1, PixelUtils.a(448.0f));
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        d.d("onCancel dialog:" + dialogInterface);
        a aVar = this.f26495i;
        if (aVar != null) {
            aVar.b();
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R$id.imgClose) {
            dismiss();
            a aVar = this.f26495i;
            if (aVar != null) {
                aVar.b();
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void wh(String str) {
        LiveGetGiftInfo liveGetGiftInfo;
        LiveGetGiftInfo liveGetGiftInfo2;
        LiveGetGiftInfo liveGetGiftInfo3;
        LiveGetGiftInfo liveGetGiftInfo4;
        LiveGetGiftInfo liveGetGiftInfo5;
        ArrayList<LiveIntegralList.LiveIntegralInfo> arrayList;
        ArrayList arrayList2 = new ArrayList();
        af.a aVar = new af.a(this);
        LiveIntegralList liveIntegralList = (LiveIntegralList) GsonHelper.a().fromJson(str, LiveIntegralList.class);
        LiveGetGiftInfo liveGetGiftInfo6 = null;
        if (liveIntegralList == null || liveIntegralList.code != 200 || (arrayList = liveIntegralList.data) == null) {
            liveGetGiftInfo3 = null;
            liveGetGiftInfo2 = null;
            liveGetGiftInfo = null;
        } else {
            Iterator<LiveIntegralList.LiveIntegralInfo> it2 = arrayList.iterator();
            LiveGetGiftInfo liveGetGiftInfo7 = null;
            liveGetGiftInfo3 = null;
            liveGetGiftInfo2 = null;
            liveGetGiftInfo = null;
            while (it2.hasNext()) {
                LiveIntegralList.LiveIntegralInfo next = it2.next();
                int i11 = next.type;
                if (i11 == 1) {
                    liveGetGiftInfo2 = new LiveGetGiftInfo(i11, R$drawable.live_get_gift_parise, getResources().getString(R$string.n_live_gift_praise), String.format(getResources().getString(R$string.n_live_gift_praise_get_integral), new Object[]{String.valueOf(next.number), String.valueOf(next.drawNumber)}), getResources().getString(R$string.n_live_gift_go_praise), aVar);
                } else if (i11 == 2) {
                    liveGetGiftInfo = new LiveGetGiftInfo(i11, R$drawable.live_get_gift_comment, getResources().getString(R$string.n_live_gift_comment), String.format(getResources().getString(R$string.n_live_gift_comment_get_integral), new Object[]{String.valueOf(next.number), String.valueOf(next.drawNumber)}), getResources().getString(R$string.n_live_gift_go_comment), aVar);
                } else if (i11 == 5) {
                    liveGetGiftInfo3 = new LiveGetGiftInfo(i11, R$drawable.live_get_gift_watch, getResources().getString(R$string.n_live_gift_watch_live), String.format(getResources().getString(R$string.n_live_gift_watch_get_integral), new Object[]{String.valueOf(next.number), String.valueOf(next.drawNumber)}), getResources().getString(R$string.n_live_gift_go_watch), aVar);
                } else if (i11 == 6) {
                    liveGetGiftInfo7 = new LiveGetGiftInfo(i11, R$drawable.live_get_gift_reward, getResources().getString(R$string.n_live_gift_reward), String.format(getResources().getString(R$string.n_live_gift_reward_get_integral), new Object[]{String.valueOf(next.number), String.valueOf(next.drawNumber)}), getResources().getString(R$string.n_live_gift_go_reward), aVar);
                }
            }
            liveGetGiftInfo6 = liveGetGiftInfo7;
        }
        if (liveGetGiftInfo6 == null) {
            liveGetGiftInfo6 = new LiveGetGiftInfo(6, R$drawable.live_get_gift_reward, getResources().getString(R$string.n_live_gift_reward), String.format(getResources().getString(R$string.n_live_gift_reward_get_integral), new Object[]{"--", "--"}), getResources().getString(R$string.n_live_gift_go_reward), aVar);
        }
        arrayList2.add(liveGetGiftInfo6);
        if (liveGetGiftInfo3 == null) {
            liveGetGiftInfo3 = new LiveGetGiftInfo(5, R$drawable.live_get_gift_watch, getResources().getString(R$string.n_live_gift_watch_live), String.format(getResources().getString(R$string.n_live_gift_watch_get_integral), new Object[]{"--", "--"}), getResources().getString(R$string.n_live_gift_go_watch), aVar);
        }
        arrayList2.add(liveGetGiftInfo3);
        if (liveGetGiftInfo2 == null) {
            liveGetGiftInfo4 = new LiveGetGiftInfo(1, R$drawable.live_get_gift_parise, getResources().getString(R$string.n_live_gift_praise), String.format(getResources().getString(R$string.n_live_gift_praise_get_integral), new Object[]{"--", "--"}), getResources().getString(R$string.n_live_gift_go_praise), aVar);
        } else {
            liveGetGiftInfo4 = liveGetGiftInfo2;
        }
        arrayList2.add(liveGetGiftInfo4);
        if (liveGetGiftInfo == null) {
            liveGetGiftInfo5 = new LiveGetGiftInfo(2, R$drawable.live_get_gift_comment, getResources().getString(R$string.n_live_gift_comment), String.format(getResources().getString(R$string.n_live_gift_comment_get_integral), new Object[]{"--", "--"}), getResources().getString(R$string.n_live_gift_go_comment), aVar);
        } else {
            liveGetGiftInfo5 = liveGetGiftInfo;
        }
        arrayList2.add(liveGetGiftInfo5);
        this.f26494h.setData(arrayList2);
    }

    public void xh(a aVar) {
        this.f26495i = aVar;
    }
}
