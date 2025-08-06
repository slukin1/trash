package com.huochat.community.util;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huochat.community.R;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.r;

public final class MomentUtils {
    public static final Companion Companion = new Companion((r) null);
    /* access modifiers changed from: private */
    public static final long HOUR_TIME_MILLI = Period.MIN60_MILLS;
    /* access modifiers changed from: private */
    public static final SimpleDateFormat HourAndMinutesFormat = new SimpleDateFormat("HH:mm");
    /* access modifiers changed from: private */
    public static final long MINUTS_TIME_MILLI = 60000;
    /* access modifiers changed from: private */
    public static final int intTrue = 1;
    /* access modifiers changed from: private */
    public static final SimpleDateFormat monthDateFormatter = new SimpleDateFormat("MM/dd HH:mm");
    /* access modifiers changed from: private */
    public static final SimpleDateFormat otherYearDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        /* access modifiers changed from: private */
        public static final void showPopupWindow$lambda$0(View view) {
            view.setBackgroundColor(0);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public static final void showPopupWindow$lambda$1(String str, PopupWindow popupWindow, View view) {
            ClipManager.copyText(str);
            HuobiToastUtil.m(BaseApplication.c(R.string.bm_copy_success));
            popupWindow.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public final String formatMomentDate(long j11) {
            long time = new Date().getTime() - j11;
            if (time < MomentUtils.MINUTS_TIME_MILLI) {
                return BaseApplication.b().getResources().getString(R.string.just_now);
            }
            if (time < MomentUtils.HOUR_TIME_MILLI) {
                return (time / MomentUtils.MINUTS_TIME_MILLI) + BaseApplication.b().getResources().getString(R.string.minute_ago);
            }
            Date date = new Date(j11);
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(date);
            if (instance.get(1) != instance2.get(1)) {
                return MomentUtils.otherYearDateFormat.format(date);
            }
            int i11 = instance.get(6);
            int i12 = instance2.get(6);
            if (i11 == i12) {
                return (time / MomentUtils.HOUR_TIME_MILLI) + BaseApplication.b().getResources().getString(R.string.hour_ago);
            } else if (i11 != i12 + 1) {
                return MomentUtils.monthDateFormatter.format(date);
            } else {
                return BaseApplication.b().getResources().getString(R.string.yestoday) + ' ' + MomentUtils.HourAndMinutesFormat.format(date);
            }
        }

        public final boolean getBoolValue(int i11) {
            return MomentUtils.intTrue == i11;
        }

        public final PopupWindow showPopupWindow(Activity activity, View view, String str, AtomicReference<MotionEvent> atomicReference) {
            MotionEvent motionEvent = null;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return null;
            }
            View inflate = LayoutInflater.from(activity).inflate(R.layout.pop_community_lone_press, (ViewGroup) null);
            PopupWindow popupWindow = new PopupWindow(inflate, -2, -2, true);
            int i11 = 0;
            popupWindow.getContentView().measure(0, 0);
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            popupWindow.setTouchable(true);
            popupWindow.setOutsideTouchable(true);
            TextView textView = (TextView) inflate.findViewById(R.id.text_view_circle_delete);
            inflate.findViewById(R.id.view_line).setVisibility(8);
            textView.setVisibility(8);
            int height = view.getHeight();
            int measuredHeight = inflate.getMeasuredHeight();
            inflate.measure(0, 0);
            int width = (view.getWidth() - inflate.getWidth()) / 2;
            int i12 = -(measuredHeight + height);
            if (textView.getVisibility() != 0) {
                i11 = DisplayTool.dp2px(activity, 40.0f);
            }
            int i13 = i12 + i11 + ((height * 3) / 11);
            activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            if (atomicReference != null) {
                motionEvent = atomicReference.get();
            }
            if (motionEvent == null) {
                popupWindow.showAsDropDown(view, width, i13 - 20);
            } else {
                popupWindow.showAtLocation(view, 51, ((int) atomicReference.get().getX()) - 20, ((int) atomicReference.get().getY()) - 20);
            }
            popupWindow.setOnDismissListener(new b(view));
            ((TextView) inflate.findViewById(R.id.tv_copy)).setOnClickListener(new a(str, popupWindow));
            return popupWindow;
        }
    }
}
