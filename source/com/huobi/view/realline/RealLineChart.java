package com.huobi.view.realline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.hbg.lib.widgets.R$attr;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$styleable;
import com.huobi.utils.b0;
import com.huobi.utils.d0;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RealLineChart extends View {
    private int chartBottomPadding;
    private float chartLeftPadding;
    private float chartRightPadding;
    private int chartTopPadding;
    private b0 formatter;
    private int gridNum;
    private final Paint gridPaint;
    private boolean lineOverYLabel;
    private final Paint linePaint;
    private final Path linePath;
    /* access modifiers changed from: private */
    public DecimalFormat mNumFormat;
    private double maxValue;
    private double minValue;
    private int pointCount;
    private double scaleY;
    public RealLineBean[] totalInflows;
    private int viewHeight;
    private int viewWidth;
    private Drawable waterLogo;
    private int waterMarginBottom;
    private int waterMarginLeft;
    private int xLabelCount;
    private final Paint xLabelPaint;
    private boolean yLabelAlignLeft;
    private int yLabelMarginBottom;
    private final Paint yLabelPaint;

    public RealLineChart(Context context) {
        this(context, (AttributeSet) null);
    }

    private void calcValues() {
        RealLineBean[] realLineBeanArr = this.totalInflows;
        if (realLineBeanArr != null && realLineBeanArr.length > 0) {
            this.maxValue = realLineBeanArr[0].getAmount();
            this.minValue = this.totalInflows[0].getAmount();
            for (RealLineBean realLineBean : this.totalInflows) {
                if (this.maxValue < realLineBean.getAmount()) {
                    this.maxValue = realLineBean.getAmount();
                }
                if (this.minValue > realLineBean.getAmount()) {
                    this.minValue = realLineBean.getAmount();
                }
            }
            double d11 = this.maxValue;
            double d12 = this.minValue;
            if (d11 == d12) {
                this.maxValue = d11 + 3.0d;
                this.minValue = d12 - 3.0d;
            }
            this.scaleY = ((double) ((this.viewHeight - this.chartTopPadding) - this.chartBottomPadding)) / (this.maxValue - this.minValue);
        }
    }

    private void drawWaterLogo(Canvas canvas) {
        if (this.waterLogo != null) {
            canvas.save();
            canvas.translate((float) this.waterMarginLeft, (float) (((this.viewHeight - this.chartBottomPadding) - this.waterLogo.getIntrinsicHeight()) - this.waterMarginBottom));
            this.waterLogo.draw(canvas);
            canvas.restore();
        }
    }

    private float fixTextY(float f11, Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return f11 - (((fontMetrics.bottom - fontMetrics.top) / 2.0f) - ((fontMetrics.descent - fontMetrics.ascent) / 2.0f));
    }

    private float getRightX(double d11) {
        return (this.lineOverYLabel || !this.yLabelAlignLeft) ? (float) d11 : (float) (d11 + ((double) this.chartLeftPadding));
    }

    private int getXIndex(float f11) {
        float f12;
        int i11;
        if (!this.lineOverYLabel) {
            if (this.yLabelAlignLeft) {
                f11 -= this.chartLeftPadding;
            }
            f12 = f11 / ((((float) this.viewWidth) - this.chartLeftPadding) - this.chartRightPadding);
            i11 = this.pointCount;
        } else {
            f12 = f11 / ((float) this.viewWidth);
            i11 = this.pointCount;
        }
        int i12 = (int) ((f12 * ((float) i11)) + 0.5f);
        int i13 = this.pointCount;
        return i12 >= i13 ? i13 - 1 : i12;
    }

    private String getXLabelText(float f11) {
        int xIndex = getXIndex(f11);
        if (xIndex < 0 || xIndex >= this.pointCount) {
            return "";
        }
        return getFormatter().formatDate(this.totalInflows[xIndex].getId() * 1000);
    }

    private void renderGrid(Canvas canvas) {
        int i11 = 0;
        while (true) {
            int i12 = this.gridNum;
            if (i11 >= i12) {
                break;
            }
            int i13 = this.viewHeight - this.chartBottomPadding;
            int i14 = this.chartTopPadding;
            float f11 = ((float) i14) + (((((float) (i13 - i14)) / ((float) (i12 - 1))) + 0.5f) * ((float) i11));
            canvas.drawLine(0.0f, f11, (float) this.viewWidth, f11, this.gridPaint);
            String formatValue = getFormatter().formatValue(this.maxValue - (((this.maxValue - this.minValue) / ((double) (this.gridNum - 1))) * ((double) i11)));
            float measureText = this.yLabelPaint.measureText(formatValue);
            if (!this.lineOverYLabel) {
                if (this.yLabelAlignLeft) {
                    if (measureText > this.chartLeftPadding) {
                        this.chartLeftPadding = measureText;
                    }
                } else if (measureText > this.chartRightPadding) {
                    this.chartRightPadding = measureText;
                }
            }
            this.chartRightPadding += 10.0f;
            if (this.yLabelAlignLeft) {
                canvas.drawText(formatValue, 0.0f, fixTextY(f11, this.yLabelPaint) - ((float) this.yLabelMarginBottom), this.yLabelPaint);
            } else {
                canvas.drawText(formatValue, (float) this.viewWidth, fixTextY(f11, this.yLabelPaint) - ((float) this.yLabelMarginBottom), this.yLabelPaint);
            }
            i11++;
        }
        for (int i15 = this.xLabelCount; i15 > 0; i15--) {
            if (i15 == 1) {
                this.xLabelPaint.setTextAlign(Paint.Align.LEFT);
            } else if (i15 == this.xLabelCount) {
                this.xLabelPaint.setTextAlign(Paint.Align.RIGHT);
            } else {
                this.xLabelPaint.setTextAlign(Paint.Align.CENTER);
            }
            float charWidth = (getCharWidth() / (((float) this.xLabelCount) - 1.0f)) * ((float) (i15 - 1));
            canvas.drawText(getXLabelText(charWidth), getRightX((double) charWidth), fixTextY(((float) this.viewHeight) - (((float) this.chartBottomPadding) / 2.0f), this.xLabelPaint), this.xLabelPaint);
        }
    }

    private void renderLine(Canvas canvas) {
        this.linePath.reset();
        this.linePath.moveTo((float) xIndexToPosition(0.0f), getMainY(this.totalInflows[0].getAmount()));
        for (int i11 = 1; i11 < this.pointCount; i11++) {
            this.linePath.lineTo((float) xIndexToPosition((float) i11), getMainY(this.totalInflows[i11].getAmount()));
        }
        canvas.drawPath(this.linePath, this.linePaint);
    }

    private int xIndexToPosition(float f11) {
        int i11 = this.pointCount;
        if (i11 != 0) {
            return (int) getRightX(((double) ((f11 / ((float) i11)) * ((((float) this.viewWidth) - this.chartLeftPadding) - this.chartRightPadding))) + 0.5d);
        }
        return 0;
    }

    public float getCharWidth() {
        return (((float) this.viewWidth) - this.chartLeftPadding) - this.chartRightPadding;
    }

    public b0 getFormatter() {
        return this.formatter;
    }

    public float getMainY(double d11) {
        return (float) (((double) (this.viewHeight - this.chartBottomPadding)) - ((d11 - this.minValue) * this.scaleY));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        calcValues();
        renderGrid(canvas);
        drawWaterLogo(canvas);
        if (this.pointCount > 0) {
            renderLine(canvas);
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.viewHeight = i12;
        this.viewWidth = i11;
        this.chartTopPadding = getPaddingTop();
        this.chartBottomPadding = getPaddingBottom();
    }

    public void setFormatter(b0 b0Var) {
        this.formatter = b0Var;
    }

    public void setGridColor(int i11) {
        this.gridPaint.setColor(i11);
    }

    public void setGridNum(int i11) {
        this.gridNum = i11;
    }

    public void setLineColor(int i11) {
        this.linePaint.setColor(i11);
    }

    public void setLineOverYLabel(boolean z11) {
        this.lineOverYLabel = z11;
    }

    public void setLineWidth(int i11) {
        this.linePaint.setStrokeWidth((float) i11);
    }

    public void setTotalInflows(RealLineBean[] realLineBeanArr) {
        this.totalInflows = realLineBeanArr;
        if (realLineBeanArr == null) {
            this.pointCount = 0;
        } else {
            this.pointCount = realLineBeanArr.length;
        }
        invalidate();
    }

    public void setXLabelCount(int i11) {
        this.xLabelCount = i11;
    }

    public void setXLabelTextColor(int i11) {
        this.xLabelPaint.setColor(i11);
    }

    public void setXLabelTextSize(int i11) {
        this.xLabelPaint.setTextSize((float) i11);
    }

    public void setYLabelAlignLeft(boolean z11) {
        this.yLabelAlignLeft = z11;
    }

    public void setYLabelMarginBottom(int i11) {
        this.yLabelMarginBottom = i11;
    }

    public void setYLabelTextColor(int i11) {
        this.yLabelPaint.setColor(i11);
    }

    public void setYLabelTextSize(int i11) {
        this.yLabelPaint.setTextSize((float) i11);
    }

    public RealLineChart(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RealLineChart(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.linePath = new Path();
        Paint paint = new Paint(1);
        this.yLabelPaint = paint;
        this.xLabelPaint = new Paint(1);
        this.gridPaint = new Paint(1);
        Paint paint2 = new Paint(1);
        this.linePaint = paint2;
        this.chartBottomPadding = 80;
        this.mNumFormat = new DecimalFormat("#");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RealLineChart);
        setXLabelTextSize(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RealLineChart_x_label_text_size, 20));
        setYLabelTextSize(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RealLineChart_y_label_text_size, 20));
        setXLabelTextColor(obtainStyledAttributes.getColor(R$styleable.RealLineChart_x_label_color, -12303292));
        setYLabelTextColor(obtainStyledAttributes.getColor(R$styleable.RealLineChart_y_label_color, -12303292));
        setLineWidth(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RealLineChart_line_width, 2));
        setLineColor(obtainStyledAttributes.getColor(R$styleable.RealLineChart_line_color, -16776961));
        setGridColor(obtainStyledAttributes.getColor(R$styleable.RealLineChart_grid_color, -16776961));
        setYLabelAlignLeft(obtainStyledAttributes.getBoolean(R$styleable.RealLineChart_y_label_align_left, false));
        setGridNum(obtainStyledAttributes.getInteger(R$styleable.RealLineChart_grid_count, 4));
        setXLabelCount(obtainStyledAttributes.getInteger(R$styleable.RealLineChart_x_label_count, 3));
        setLineOverYLabel(obtainStyledAttributes.getBoolean(R$styleable.RealLineChart_line_over_y_label, true));
        setYLabelMarginBottom(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RealLineChart_y_label_bottom_margin, 5));
        paint2.setStyle(Paint.Style.STROKE);
        obtainStyledAttributes.recycle();
        this.waterMarginLeft = 0;
        this.waterMarginBottom = (int) ((getContext().getResources().getDisplayMetrics().density * 12.0f) + 0.5f);
        if (!d0.b(context) || d0.c(context)) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R$attr.kline_water_remark, typedValue, true);
            this.waterLogo = getResources().getDrawable(typedValue.resourceId);
        } else {
            this.waterLogo = getResources().getDrawable(R$drawable.kline_water_logo_zh_cn);
        }
        Drawable drawable = this.waterLogo;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.waterLogo.getIntrinsicHeight());
        }
        if (this.yLabelAlignLeft) {
            paint.setTextAlign(Paint.Align.LEFT);
        } else {
            paint.setTextAlign(Paint.Align.RIGHT);
        }
        this.mNumFormat.setRoundingMode(RoundingMode.DOWN);
        setFormatter(new b0() {
            @SuppressLint({"SimpleDateFormat"})
            public String formatDate(long j11) {
                return new SimpleDateFormat("HH:mm").format(new Date(j11));
            }

            @SuppressLint({"DefaultLocale"})
            public String formatPercent(double d11) {
                return String.format("%.2f", new Object[]{Double.valueOf(d11)}) + "%";
            }

            @SuppressLint({"DefaultLocale"})
            public String formatValue(double d11) {
                return RealLineChart.this.mNumFormat.format(d11);
            }
        });
    }
}
