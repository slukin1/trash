package com.huobi.index.viewhandler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.lib.router.HbgRouter;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.lib.widgets.o0;
import com.hbg.module.huobi.im.utils.DateUtils;
import com.huobi.index.bean.HomeFeedInfoItem;
import com.huobi.index.bean.IndexLive;
import com.huobi.utils.HomeSensorsHelper;
import com.huochat.community.util.DisplayTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import he.b;
import i6.r;
import pro.huobi.R;
import s9.c;

public final class NewsLiveHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public boolean f74413b;

    @SensorsDataInstrumented
    public static final void d(NewsLiveHandler newsLiveHandler, IndexLive indexLive, HomeFeedInfoItem homeFeedInfoItem, View view) {
        newsLiveHandler.e(view.getContext(), indexLive.status.intValue(), String.valueOf(indexLive.f73197id));
        Number number = indexLive.f73197id;
        if (number == null) {
            number = 0L;
        }
        g.g("app_recome_content_click", HomeSensorsHelper.d(number.longValue(), homeFeedInfoItem.f73152c, indexLive.title, "liveStreaming", homeFeedInfoItem.f73165p, String.valueOf(indexLive.status), 6));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, HomeFeedInfoItem homeFeedInfoItem, ViewGroup viewGroup) {
        String str;
        HomeFeedInfoItem homeFeedInfoItem2 = homeFeedInfoItem;
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.tvTitle);
        ImageView imageView = (ImageView) e11.b(R.id.ivHead);
        ImageView imageView2 = (ImageView) e11.b(R.id.ivPic);
        TextView textView2 = (TextView) e11.b(R.id.tvName);
        TextView textView3 = (TextView) e11.b(R.id.tvDate);
        TextView textView4 = (TextView) e11.b(R.id.tvLive);
        LinearLayout linearLayout = (LinearLayout) e11.b(R.id.liveLayout);
        SafeLottieView safeLottieView = (SafeLottieView) e11.b(R.id.iv_live_playing);
        IndexLive indexLive = homeFeedInfoItem2.f73161l;
        if (indexLive != null) {
            textView.setText(indexLive.title);
            Context context = imageView.getContext();
            IndexLive.SpeakerListDTO speakerListDTO = indexLive.speakerListX.get(0);
            String str2 = speakerListDTO != null ? speakerListDTO.f73198a : null;
            if (str2 == null) {
                str2 = "";
            }
            o0.c(context, str2, imageView, DisplayTool.dp2px(0.5f), imageView.getContext().getResources().getColor(R.color.baseColorPrimarySeparator));
            Integer num = indexLive.status;
            if (num != null && num.intValue() == 1) {
                linearLayout.setBackgroundResource(R.drawable.bg_live_playback);
                safeLottieView.setVisibility(8);
                safeLottieView.cancelAnimation();
                StringBuilder sb2 = new StringBuilder();
                Integer num2 = indexLive.appointedNum;
                sb2.append(b.e(num2 != null ? String.valueOf(num2) : null));
                sb2.append("k ");
                sb2.append(textView4.getContext().getString(R.string.n_live_make_appointment));
                textView4.setText(sb2.toString());
            } else {
                Integer num3 = indexLive.status;
                if (num3 != null && num3.intValue() == 2) {
                    linearLayout.setBackgroundResource(R.drawable.bg_live_playing);
                    safeLottieView.setVisibility(0);
                    Context context2 = textView4.getContext();
                    Object[] objArr = new Object[1];
                    Integer num4 = indexLive.onlineNum;
                    objArr[0] = b.e(num4 != null ? String.valueOf(num4) : null);
                    textView4.setText(context2.getString(R.string.n_content_live_watch, objArr));
                } else {
                    Integer num5 = indexLive.status;
                    if (num5 != null && num5.intValue() == 3) {
                        linearLayout.setBackgroundResource(R.drawable.bg_live_playback);
                        safeLottieView.setVisibility(8);
                        safeLottieView.cancelAnimation();
                        Context context3 = textView4.getContext();
                        Object[] objArr2 = new Object[1];
                        Integer num6 = indexLive.onlineNum;
                        objArr2[0] = b.e(num6 != null ? String.valueOf(num6) : null);
                        textView4.setText(context3.getString(R.string.n_content_live_watched, objArr2));
                    }
                }
            }
            o0.b(imageView2.getContext(), indexLive.coverImageUrl, imageView2, 8.0f, imageView2.getContext().getResources().getColor(R.color.baseColorPrimarySeparator), 0.5f);
            IndexLive.SpeakerListDTO speakerListDTO2 = indexLive.speakerListX.get(0);
            if (speakerListDTO2 == null || (str = speakerListDTO2.f73199b) == null) {
                str = "";
            }
            textView2.setText(str);
            textView3.setText(DateUtils.g(textView3.getContext(), indexLive.startTime.longValue(), indexLive.finishTime.longValue()));
            ((ConstraintLayout) e11.b(R.id.item_root)).setOnClickListener(new z(this, indexLive, homeFeedInfoItem2));
        }
        this.f74413b = true;
    }

    public final void e(Context context, int i11, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("liveStatus", i11);
        bundle.putString("liveId", str);
        HbgRouter.i(context, "/live/room", bundle);
    }

    public int getResId() {
        return R.layout.item_home_news_live;
    }
}
