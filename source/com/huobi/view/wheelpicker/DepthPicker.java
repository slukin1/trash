package com.huobi.view.wheelpicker;

import android.app.Activity;
import com.huobi.trade.bean.DepthItem;
import com.huobi.view.wheelpicker.SinglePicker;
import java.util.List;

public class DepthPicker extends SinglePicker<DepthItem> {

    public static abstract class OnOptionPickListener implements SinglePicker.OnItemPickListener<DepthItem> {
        public abstract void onOptionPicked(int i11, DepthItem depthItem);

        public final void onItemPicked(int i11, DepthItem depthItem) {
            onOptionPicked(i11, depthItem);
        }
    }

    public DepthPicker(Activity activity, DepthItem[] depthItemArr) {
        super(activity, (T[]) depthItemArr);
    }

    public void setOnOptionPickListener(OnOptionPickListener onOptionPickListener) {
        super.setOnItemPickListener(onOptionPickListener);
    }

    public DepthPicker(Activity activity, List<DepthItem> list) {
        super(activity, list);
    }
}
