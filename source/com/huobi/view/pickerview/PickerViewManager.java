package com.huobi.view.pickerview;

import android.app.Activity;
import android.view.View;
import com.huobi.view.pickerview.listener.OnTimeSelectListener;
import com.tencent.rtmp.TXVodConstants;
import java.util.Calendar;
import java.util.Date;
import pro.huobi.R;

public class PickerViewManager implements OnTimeSelectListener {
    private Callback mCallback;
    private TimePickerView mDatePickerView;

    public interface Callback {
        void onTimeSelect(Date date);
    }

    public PickerViewManager(Activity activity) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.set(TXVodConstants.VOD_PLAY_EVT_DNS_RESOLVED, 2, 1);
        Calendar instance3 = Calendar.getInstance();
        instance3.set(instance.get(1), instance.get(2), instance.get(5));
        this.mDatePickerView = new TimePickerBuilder(activity, this).setDate(instance).setRangDate(instance2, instance3).setGravity(new int[]{5, 3, 0, 0, 0, 0}).setContentTextSize(activity.getResources().getDimensionPixelOffset(R.dimen.picker_view_center_text_size)).setType(new boolean[]{true, true, false, false, false, false}).setLabel("", "", "", "", "", "").setLineSpacingMultiplier(1.8f).setBgColor(activity.getResources().getColor(R.color.app_bg)).setTitleBgColor(activity.getResources().getColor(R.color.app_bg)).setTitleColor(activity.getResources().getColor(R.color.global_main_text_color)).setSubmitColor(activity.getResources().getColor(R.color.global_jump_btn_color)).setCancelColor(activity.getResources().getColor(R.color.global_secondary_text_color)).setCancelText(activity.getString(R.string.picker_view_title_btn_cancel)).setSubmitText(activity.getString(R.string.picker_view_title_btn_confirm)).setTitleText(activity.getString(R.string.picker_view_title_select_time)).setTextColorCenter(activity.getResources().getColor(R.color.global_main_text_color)).setTextColorOut(activity.getResources().getColor(R.color.global_default_sub_text_color)).setTextXOffset(-135, 135, 0, 0, 0, 0).isCenterLabel(true).setDividerColor(0).build();
    }

    public void onTimeSelect(Date date, View view) {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onTimeSelect(date);
        }
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void show() {
        TimePickerView timePickerView = this.mDatePickerView;
        if (timePickerView != null) {
            timePickerView.show();
        }
    }
}
