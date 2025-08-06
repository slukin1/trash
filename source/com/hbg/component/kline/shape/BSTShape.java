package com.hbg.component.kline.shape;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.network.hbg.core.bean.BSTInfo;
import java.io.Serializable;

public class BSTShape implements Serializable {
    public BSTInfo.BSTInfoBean bstInfoBean;
    private Drawable buyDrawable;
    public Rect buyRect = new Rect();
    private float marginBottom = ((float) PixelUtils.a(2.0f));
    private float[] points = new float[2];
    private Drawable sellDrawable;
    public Rect sellRect = new Rect();

    public BSTShape(String str, BSTInfo.BSTInfoBean bSTInfoBean) {
        this.bstInfoBean = bSTInfoBean;
    }

    public void drawBottomBuy(Canvas canvas) {
        float[] fArr = this.points;
        fArr[1] = fArr[1] + this.marginBottom;
        Drawable drawable = this.buyDrawable;
        if (drawable != null) {
            Rect rect = this.buyRect;
            int i11 = (int) fArr[1];
            rect.top = i11;
            rect.bottom = i11 + drawable.getIntrinsicHeight();
            this.buyRect.right = (int) (this.points[0] + ((float) (this.buyDrawable.getIntrinsicWidth() / 2)));
            Rect rect2 = this.buyRect;
            rect2.left = rect2.right - this.buyDrawable.getIntrinsicWidth();
            this.buyDrawable.setBounds(this.buyRect);
            this.buyDrawable.draw(canvas);
        }
    }

    public void drawTopSell(Canvas canvas) {
        float[] fArr = this.points;
        fArr[1] = fArr[1] - this.marginBottom;
        Drawable drawable = this.sellDrawable;
        if (drawable != null) {
            Rect rect = this.sellRect;
            int i11 = (int) fArr[1];
            rect.bottom = i11;
            rect.top = i11 - drawable.getIntrinsicHeight();
            this.sellRect.right = (int) (this.points[0] + ((float) (this.sellDrawable.getIntrinsicWidth() / 2)));
            Rect rect2 = this.sellRect;
            rect2.left = rect2.right - this.sellDrawable.getIntrinsicWidth();
            this.sellDrawable.setBounds(this.sellRect);
            this.sellDrawable.draw(canvas);
        }
    }

    public float[] getPoints() {
        return this.points;
    }

    public long getTime() {
        return this.bstInfoBean.getId() / 1000;
    }

    public void setBuySellDrawable(Drawable drawable, Drawable drawable2) {
        this.buyDrawable = drawable;
        this.sellDrawable = drawable2;
    }
}
