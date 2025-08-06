package com.huobi.view.wheelpicker;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.trade.bean.DepthItem;
import com.huobi.view.wheelpicker.WheelView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SinglePicker<T> extends WheelPicker {
    private static final int ITEM_WIDTH_UNKNOWN = -99;
    private List<String> itemStrings;
    private int itemWidth;
    private List<T> items;
    private String label;
    private OnItemPickListener<T> onItemPickListener;
    /* access modifiers changed from: private */
    public OnWheelListener onWheelListener;
    /* access modifiers changed from: private */
    public int selectedItemIndex;
    private WheelView wheelView;

    public interface OnItemPickListener<T> {
        void onItemPicked(int i11, T t11);
    }

    public interface OnWheelListener {
        void onWheeled(int i11, String str);
    }

    public SinglePicker(Activity activity, T[] tArr) {
        this(activity, Arrays.asList(tArr));
    }

    private String formatToString(T t11) {
        if ((t11 instanceof Float) || (t11 instanceof Double)) {
            return new DecimalFormat("0.00").format(t11);
        }
        if (t11 instanceof DepthItem) {
            return ((DepthItem) t11).e();
        }
        return t11.toString();
    }

    public void addItem(T t11) {
        this.items.add(t11);
        this.itemStrings.add(formatToString(t11));
    }

    public OnItemPickListener getOnItemPickListener() {
        return this.onItemPickListener;
    }

    public int getSelectedIndex() {
        return this.selectedItemIndex;
    }

    public T getSelectedItem() {
        return this.items.get(this.selectedItemIndex);
    }

    public WheelView getWheelView() {
        return this.wheelView;
    }

    public View makeCenterView() {
        if (this.items.size() != 0) {
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            WheelView wheelView2 = new WheelView(this.activity);
            this.wheelView = wheelView2;
            wheelView2.setTextSize(this.typeDimension, this.textSize);
            this.wheelView.setTextColor(this.textColorNormal, this.textColorFocus);
            this.wheelView.setLineConfig(this.lineConfig);
            this.wheelView.setOffset(this.offset);
            this.wheelView.setCycleDisable(this.cycleDisable);
            linearLayout.addView(this.wheelView);
            if (TextUtils.isEmpty(this.label)) {
                this.wheelView.setLayoutParams(new LinearLayout.LayoutParams(this.screenWidthPixels, -2));
            } else {
                this.wheelView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                TextView textView = new TextView(this.activity);
                textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                textView.setTextColor(this.textColorFocus);
                textView.setTextSize(this.typeDimension, (float) this.textSize);
                textView.setText(this.label);
                linearLayout.addView(textView);
            }
            this.wheelView.setItems(this.itemStrings, this.selectedItemIndex);
            this.wheelView.setOnWheelListener(new WheelView.OnWheelListener() {
                public void onSelected(boolean z11, int i11, String str) {
                    int unused = SinglePicker.this.selectedItemIndex = i11;
                    if (SinglePicker.this.onWheelListener != null) {
                        SinglePicker.this.onWheelListener.onWheeled(SinglePicker.this.selectedItemIndex, str);
                    }
                }
            });
            int i11 = this.itemWidth;
            if (i11 != -99) {
                this.wheelView.setLayoutParams(new LinearLayout.LayoutParams(PixelUtils.a((float) i11), this.wheelView.getLayoutParams().height));
            }
            return linearLayout;
        }
        throw new IllegalArgumentException("please initial items at first, can't be empty");
    }

    public void onSubmit() {
        OnItemPickListener<T> onItemPickListener2 = this.onItemPickListener;
        if (onItemPickListener2 != null) {
            onItemPickListener2.onItemPicked(this.selectedItemIndex, getSelectedItem());
        }
    }

    public void removeItem(T t11) {
        this.items.remove(t11);
        this.itemStrings.remove(formatToString(t11));
    }

    public void setItemWidth(int i11) {
        if (this.wheelView != null) {
            this.wheelView.setLayoutParams(new LinearLayout.LayoutParams(PixelUtils.a((float) i11), this.wheelView.getLayoutParams().height));
            return;
        }
        this.itemWidth = i11;
    }

    public void setItems(T[] tArr) {
        setItems(Arrays.asList(tArr));
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setOnItemPickListener(OnItemPickListener<T> onItemPickListener2) {
        this.onItemPickListener = onItemPickListener2;
    }

    public void setOnWheelListener(OnWheelListener onWheelListener2) {
        this.onWheelListener = onWheelListener2;
    }

    public void setSelectedIndex(int i11) {
        if (i11 >= 0 && i11 < this.items.size()) {
            this.selectedItemIndex = i11;
        }
    }

    public void setSelectedItem(T t11) {
        setSelectedIndex(this.itemStrings.indexOf(formatToString(t11)));
    }

    public SinglePicker(Activity activity, List<T> list) {
        super(activity);
        this.items = new ArrayList();
        this.itemStrings = new ArrayList();
        this.selectedItemIndex = 0;
        this.label = "";
        this.itemWidth = -99;
        setItems(list);
    }

    public void setItems(List<T> list) {
        if (list != null && list.size() != 0) {
            this.items = list;
            this.itemStrings.clear();
            for (T formatToString : list) {
                this.itemStrings.add(formatToString(formatToString));
            }
            WheelView wheelView2 = this.wheelView;
            if (wheelView2 != null) {
                wheelView2.setItems(this.itemStrings, this.selectedItemIndex);
            }
        }
    }

    public void setItems(List<T> list, int i11) {
        if (list != null && list.size() != 0 && i11 <= list.size() - 1) {
            this.items = list;
            this.itemStrings.clear();
            this.selectedItemIndex = i11;
            for (T formatToString : list) {
                this.itemStrings.add(formatToString(formatToString));
            }
            WheelView wheelView2 = this.wheelView;
            if (wheelView2 != null) {
                wheelView2.setItems(this.itemStrings, this.selectedItemIndex);
            }
        }
    }
}
