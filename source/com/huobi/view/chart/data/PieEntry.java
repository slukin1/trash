package com.huobi.view.chart.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import com.huobi.finance.viewhandler.PieChartItemViewAdapter;
import s9.a;

@SuppressLint({"ParcelCreator"})
public class PieEntry extends Entry implements a {
    private Integer color;
    private boolean isSelected;
    private String label;
    private PieChartHandleCallback pieChartHandleCallback;
    private String title;

    public interface PieChartHandleCallback {
        void onPieItemClick(int i11, PieEntry pieEntry);
    }

    public PieEntry(float f11, String str, String str2, Integer num, PieChartHandleCallback pieChartHandleCallback2) {
        super(0.0f, f11);
        this.title = str;
        this.label = str2;
        this.color = num;
        this.pieChartHandleCallback = pieChartHandleCallback2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PieEntry)) {
            return false;
        }
        if (Float.compare(((PieEntry) obj).getY(), getY()) == 0) {
            return true;
        }
        return false;
    }

    public Integer getColor() {
        return this.color;
    }

    public String getLabel() {
        return this.label;
    }

    public PieChartHandleCallback getPieChartHandleCallback() {
        return this.pieChartHandleCallback;
    }

    public String getTitle() {
        return this.title;
    }

    public float getValue() {
        return getY();
    }

    public String getViewHandlerName() {
        return PieChartItemViewAdapter.class.getName();
    }

    @Deprecated
    public float getX() {
        return super.getX();
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setColor(Integer num) {
        this.color = num;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setPieChartHandleCallback(PieChartHandleCallback pieChartHandleCallback2) {
        this.pieChartHandleCallback = pieChartHandleCallback2;
    }

    public void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Deprecated
    public void setX(float f11) {
        super.setX(f11);
    }

    public PieEntry copy() {
        return new PieEntry(getY(), this.label, getData());
    }

    public PieEntry(float f11, String str, String str2, PieChartHandleCallback pieChartHandleCallback2) {
        this(f11, str, str2, 0, pieChartHandleCallback2);
    }

    public PieEntry(float f11, String str, Object obj) {
        super(0.0f, f11, obj);
        this.label = str;
    }

    public PieEntry(float f11, String str, Drawable drawable) {
        super(0.0f, f11, drawable);
        this.label = str;
    }

    public PieEntry(float f11, String str, Drawable drawable, Object obj) {
        super(0.0f, f11, drawable, obj);
        this.label = str;
    }
}
