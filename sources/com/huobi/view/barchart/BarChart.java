package com.huobi.view.barchart;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.hbg.lib.widgets.R$styleable;
import com.huobi.utils.b0;
import com.huobi.view.barchart.BarChartBean;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BarChart extends View {
    private BarChartBean barChartBean;
    private int barChartRadius;
    private int barChartStrokeRadius;
    private final List<BarChartItemShape> barCharts;
    private int[] colors;
    private int defaultCircleColor;
    private int extendedHorizontalLineLength;
    private int extendedLineLength;
    private b0 formatter;
    private final Paint labelTextPaint;
    private int lineEndRadius;
    private int lineTextMargin;
    private int lineWidth;
    private final Paint paint;
    private final Paint percentTextPaint;
    public RectF rectF;
    private int viewHeight;
    private int viewWidth;

    public BarChart(Context context) {
        this(context, (AttributeSet) null);
    }

    private void calcChartValue() {
        List<BarChartBean.BarChartItem> amounts;
        double[] dArr;
        int i11;
        double[] dArr2;
        int i12;
        List<BarChartBean.BarChartItem> list;
        this.barCharts.clear();
        BarChartBean barChartBean2 = this.barChartBean;
        if (barChartBean2 != null && (amounts = barChartBean2.getAmounts()) != null && amounts.size() > 0) {
            float f11 = 0.0f;
            int size = amounts.size();
            double totalAmount = this.barChartBean.getTotalAmount();
            double[] dArr3 = new double[size];
            double[] dArr4 = new double[size];
            double d11 = 0.0d;
            double d12 = 0.0d;
            for (int i13 = 0; i13 < size; i13++) {
                double amount = amounts.get(i13).getAmount();
                if (amount != 0.0d) {
                    double d13 = amount / totalAmount;
                    dArr4[i13] = d13;
                    if (d13 < 0.09d) {
                        d13 = 0.09d;
                    }
                    dArr3[i13] = d13;
                    d12 += d13;
                }
            }
            for (int i14 = 0; i14 < size; i14++) {
                dArr3[i14] = dArr3[i14] / d12;
            }
            int i15 = 1;
            while (i15 <= size) {
                int i16 = i15 - 1;
                BarChartBean.BarChartItem barChartItem = amounts.get(i16);
                if (barChartItem.getAmount() == d11) {
                    list = amounts;
                    i12 = size;
                    i11 = i15;
                    dArr2 = dArr3;
                    dArr = dArr4;
                } else {
                    BarChartItemShape barChartItemShape = new BarChartItemShape(this.lineEndRadius, this.labelTextPaint, this.percentTextPaint, this.lineWidth, this.lineTextMargin);
                    float f12 = (float) ((dArr3[i16] * 360.0d) + 0.05000000074505806d);
                    float f13 = (f12 / 2.0f) + f11;
                    double d14 = (double) f13;
                    double sin = Math.sin(Math.toRadians(d14));
                    double cos = Math.cos(Math.toRadians(d14));
                    int i17 = this.barChartRadius;
                    list = amounts;
                    int[] iArr = new int[6];
                    i12 = size;
                    int i18 = this.viewWidth;
                    dArr2 = dArr3;
                    float f14 = f12;
                    i11 = i15;
                    dArr = dArr4;
                    iArr[0] = (int) (((double) (i18 / 2)) + (((double) i17) * sin));
                    int i19 = this.viewHeight;
                    int i21 = i16;
                    iArr[1] = (int) (((double) (i19 / 2)) - (((double) i17) * cos));
                    double d15 = (double) (this.extendedLineLength + i17);
                    iArr[2] = (int) (((double) (i18 / 2)) + (sin * d15));
                    iArr[3] = (int) (((double) (i19 / 2)) - (d15 * cos));
                    if (f13 > 180.0f) {
                        int i22 = this.extendedHorizontalLineLength;
                        if (i22 != 0) {
                            iArr[4] = iArr[2] - i22;
                        } else {
                            iArr[4] = 0;
                        }
                        iArr[5] = iArr[3];
                        barChartItemShape.setTextAlign(Paint.Align.LEFT);
                    } else {
                        int i23 = this.extendedHorizontalLineLength;
                        if (i23 != 0) {
                            iArr[4] = iArr[2] + i23;
                        } else {
                            iArr[4] = i18;
                        }
                        iArr[5] = iArr[3];
                        barChartItemShape.setTextAlign(Paint.Align.RIGHT);
                    }
                    barChartItemShape.setLabel(barChartItem.getLabel());
                    barChartItemShape.setPercentText(getFormatter().formatPercent(dArr[i21] * 100.0d));
                    barChartItemShape.setChartColor(this.colors[Math.abs(i21) % this.colors.length]);
                    barChartItemShape.setStarAngel(f11 - 90.0f);
                    float f15 = f14;
                    barChartItemShape.setSweepAngel(f15);
                    barChartItemShape.setLinePathPoints(iArr);
                    f11 += f15;
                    this.barCharts.add(barChartItemShape);
                }
                i15 = i11 + 1;
                amounts = list;
                size = i12;
                dArr3 = dArr2;
                dArr4 = dArr;
                d11 = 0.0d;
            }
        }
    }

    public static float fixTextY(Paint paint2, float f11, boolean z11) {
        Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
        float f12 = fontMetrics.bottom - fontMetrics.top;
        if (z11) {
            f11 -= fontMetrics.ascent;
        }
        return f11 - ((f12 - (fontMetrics.descent - fontMetrics.ascent)) / 2.0f);
    }

    private void setLineWidth(int i11) {
        this.lineWidth = i11;
    }

    public void addChartData(BarChartBean barChartBean2) {
        this.barChartBean = barChartBean2;
        invalidate();
    }

    public b0 getFormatter() {
        return this.formatter;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.paint.setColor(this.defaultCircleColor);
        canvas.drawArc(this.rectF, 0.0f, 360.0f, true, this.paint);
        calcChartValue();
        if (this.barChartBean != null) {
            int size = this.barCharts.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.barCharts.get(i11).draw(canvas, this.rectF, this.paint);
            }
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.viewHeight = i12;
        this.viewWidth = i11;
        int i15 = i11 / 2;
        int i16 = i12 / 2;
        RectF rectF2 = this.rectF;
        int i17 = this.barChartRadius;
        rectF2.left = (float) (i15 - i17);
        rectF2.right = (float) (i15 + i17);
        rectF2.top = (float) (i16 - i17);
        rectF2.bottom = (float) (i16 + i17);
    }

    public void setBarChartRadius(int i11) {
        this.barChartRadius = i11;
    }

    public void setBarChartStrokeRadius(int i11) {
        this.barChartStrokeRadius = i11;
    }

    public void setColors(int[] iArr) {
        this.colors = iArr;
    }

    public void setDefaultCircleColor(int i11) {
        this.defaultCircleColor = i11;
    }

    public void setExtendedHorizontalLineLength(int i11) {
        this.extendedHorizontalLineLength = i11;
    }

    public void setExtendedLineLength(int i11) {
        this.extendedLineLength = i11;
    }

    public void setFormatter(b0 b0Var) {
        this.formatter = b0Var;
    }

    public void setLabelTextColor(int i11) {
        this.labelTextPaint.setColor(i11);
    }

    public void setLabelTextSize(int i11) {
        this.labelTextPaint.setTextSize((float) i11);
    }

    public void setLineEndRadius(int i11) {
        this.lineEndRadius = i11;
    }

    public void setLineTextMargin(int i11) {
        this.lineTextMargin = i11;
    }

    public void setPercentTextColor(int i11) {
        this.percentTextPaint.setColor(i11);
    }

    public void setPercentTextSize(int i11) {
        this.percentTextPaint.setTextSize((float) i11);
    }

    public BarChart(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BarChart(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Paint paint2 = new Paint(1);
        this.paint = paint2;
        this.labelTextPaint = new Paint(1);
        this.percentTextPaint = new Paint(1);
        this.barCharts = new ArrayList();
        this.rectF = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BarChart);
        this.colors = new int[]{obtainStyledAttributes.getColor(R$styleable.BarChart_chart_color_1, -256), obtainStyledAttributes.getColor(R$styleable.BarChart_chart_color_2, -16711936), obtainStyledAttributes.getColor(R$styleable.BarChart_chart_color_3, -16776961), obtainStyledAttributes.getColor(R$styleable.BarChart_chart_color_4, -65281), obtainStyledAttributes.getColor(R$styleable.BarChart_chart_color_5, -16711681), obtainStyledAttributes.getColor(R$styleable.BarChart_chart_color_6, -3355444)};
        setDefaultCircleColor(obtainStyledAttributes.getColor(R$styleable.BarChart_default_circle_color, -12303292));
        setExtendedLineLength(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BarChart_extended_line_length, 100));
        setExtendedHorizontalLineLength(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BarChart_horizontal_extended_line_length, 0));
        setBarChartRadius(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BarChart_chart_radius, 200));
        setBarChartStrokeRadius(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BarChart_stroke_radius, 120));
        setLabelTextColor(obtainStyledAttributes.getColor(R$styleable.BarChart_label_text_color, -16776961));
        setPercentTextColor(obtainStyledAttributes.getColor(R$styleable.BarChart_percent_text_color, -16776961));
        setLabelTextSize(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BarChart_label_text_size, 30));
        setPercentTextSize(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BarChart_percent_text_size, 25));
        setLineTextMargin(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BarChart_line_text_margin, 10));
        setLineEndRadius(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.BarChart_horizontal_extended_line_end_radius, 5));
        setLineWidth(obtainStyledAttributes.getDimensionPixelSize(R$styleable.BarChart_extended_line_width, 3));
        obtainStyledAttributes.recycle();
        paint2.setStrokeWidth((float) (this.barChartRadius - this.barChartStrokeRadius));
        paint2.setStyle(Paint.Style.STROKE);
        this.formatter = new b0() {
            @SuppressLint({"SimpleDateFormat"})
            public String formatDate(long j11) {
                return new SimpleDateFormat("hh:mm").format(new Date(j11));
            }

            @SuppressLint({"DefaultLocale"})
            public String formatPercent(double d11) {
                return String.format("%.02f", new Object[]{Double.valueOf(d11)}) + "%";
            }

            @SuppressLint({"DefaultLocale"})
            public String formatValue(double d11) {
                return String.format("%.0f", new Object[]{Double.valueOf(d11)});
            }
        };
        invalidate();
    }
}
