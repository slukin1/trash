package com.airbnb.lottie.animation.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

public class RoundedCornersContent implements ShapeModifierContent, BaseKeyframeAnimation.AnimationListener {
    private static final float ROUNDED_CORNER_MAGIC_NUMBER = 0.5519f;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<Float, Float> roundedCorners;
    private ShapeData shapeData;

    public RoundedCornersContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, RoundedCorners roundedCorners2) {
        this.lottieDrawable = lottieDrawable2;
        this.name = roundedCorners2.getName();
        BaseKeyframeAnimation<Float, Float> createAnimation = roundedCorners2.getCornerRadius().createAnimation();
        this.roundedCorners = createAnimation;
        baseLayer.addAnimation(createAnimation);
        createAnimation.addUpdateListener(this);
    }

    private static int floorDiv(int i11, int i12) {
        int i13 = i11 / i12;
        return ((i11 ^ i12) >= 0 || i12 * i13 == i11) ? i13 : i13 - 1;
    }

    private static int floorMod(int i11, int i12) {
        return i11 - (floorDiv(i11, i12) * i12);
    }

    private ShapeData getShapeData(ShapeData shapeData2) {
        PointF pointF;
        List<CubicCurveData> curves = shapeData2.getCurves();
        boolean isClosed = shapeData2.isClosed();
        int size = curves.size() - 1;
        int i11 = 0;
        while (size >= 0) {
            CubicCurveData cubicCurveData = curves.get(size);
            CubicCurveData cubicCurveData2 = curves.get(floorMod(size - 1, curves.size()));
            PointF vertex = (size != 0 || isClosed) ? cubicCurveData2.getVertex() : shapeData2.getInitialPoint();
            if (size != 0 || isClosed) {
                pointF = cubicCurveData2.getControlPoint2();
            } else {
                pointF = vertex;
            }
            i11 = (!pointF.equals(vertex) || !cubicCurveData.getControlPoint1().equals(vertex) || (!shapeData2.isClosed() && size == 0 && size == curves.size() - 1)) ? i11 + 1 : i11 + 2;
            size--;
        }
        ShapeData shapeData3 = this.shapeData;
        if (shapeData3 == null || shapeData3.getCurves().size() != i11) {
            ArrayList arrayList = new ArrayList(i11);
            for (int i12 = 0; i12 < i11; i12++) {
                arrayList.add(new CubicCurveData());
            }
            this.shapeData = new ShapeData(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.shapeData.setClosed(isClosed);
        return this.shapeData;
    }

    public String getName() {
        return this.name;
    }

    public BaseKeyframeAnimation<Float, Float> getRoundedCorners() {
        return this.roundedCorners;
    }

    public ShapeData modifyShape(ShapeData shapeData2) {
        PointF pointF;
        List<CubicCurveData> list;
        List<CubicCurveData> curves = shapeData2.getCurves();
        if (curves.size() <= 2) {
            return shapeData2;
        }
        float floatValue = this.roundedCorners.getValue().floatValue();
        if (floatValue == 0.0f) {
            return shapeData2;
        }
        ShapeData shapeData3 = getShapeData(shapeData2);
        shapeData3.setInitialPoint(shapeData2.getInitialPoint().x, shapeData2.getInitialPoint().y);
        List<CubicCurveData> curves2 = shapeData3.getCurves();
        boolean isClosed = shapeData2.isClosed();
        int i11 = 0;
        int i12 = 0;
        while (i11 < curves.size()) {
            CubicCurveData cubicCurveData = curves.get(i11);
            CubicCurveData cubicCurveData2 = curves.get(floorMod(i11 - 1, curves.size()));
            CubicCurveData cubicCurveData3 = curves.get(floorMod(i11 - 2, curves.size()));
            PointF vertex = (i11 != 0 || isClosed) ? cubicCurveData2.getVertex() : shapeData2.getInitialPoint();
            if (i11 != 0 || isClosed) {
                pointF = cubicCurveData2.getControlPoint2();
            } else {
                pointF = vertex;
            }
            PointF controlPoint1 = cubicCurveData.getControlPoint1();
            PointF vertex2 = cubicCurveData3.getVertex();
            PointF vertex3 = cubicCurveData.getVertex();
            boolean z11 = !shapeData2.isClosed() && i11 == 0 && i11 == curves.size() + -1;
            if (!pointF.equals(vertex) || !controlPoint1.equals(vertex) || z11) {
                list = curves;
                CubicCurveData cubicCurveData4 = curves2.get(floorMod(i12 - 1, curves2.size()));
                cubicCurveData4.setControlPoint2(cubicCurveData2.getVertex().x, cubicCurveData2.getVertex().y);
                cubicCurveData4.setVertex(cubicCurveData2.getVertex().x, cubicCurveData2.getVertex().y);
                curves2.get(i12).setControlPoint1(cubicCurveData.getVertex().x, cubicCurveData.getVertex().y);
            } else {
                float f11 = vertex.x;
                float f12 = f11 - vertex2.x;
                float f13 = vertex.y;
                float f14 = vertex3.x - f11;
                list = curves;
                float min = Math.min(floatValue / ((float) Math.hypot((double) f12, (double) (f13 - vertex2.y))), 0.5f);
                float min2 = Math.min(floatValue / ((float) Math.hypot((double) f14, (double) (vertex3.y - f13))), 0.5f);
                float f15 = vertex.x;
                float f16 = ((vertex2.x - f15) * min) + f15;
                float f17 = vertex.y;
                float f18 = ((vertex2.y - f17) * min) + f17;
                float f19 = ((vertex3.x - f15) * min2) + f15;
                float f21 = ((vertex3.y - f17) * min2) + f17;
                float f22 = f16 - ((f16 - f15) * ROUNDED_CORNER_MAGIC_NUMBER);
                float f23 = f18 - ((f18 - f17) * ROUNDED_CORNER_MAGIC_NUMBER);
                float f24 = f19 - ((f19 - f15) * ROUNDED_CORNER_MAGIC_NUMBER);
                float f25 = f21 - ((f21 - f17) * ROUNDED_CORNER_MAGIC_NUMBER);
                CubicCurveData cubicCurveData5 = curves2.get(floorMod(i12 - 1, curves2.size()));
                CubicCurveData cubicCurveData6 = curves2.get(i12);
                cubicCurveData5.setControlPoint2(f16, f18);
                cubicCurveData5.setVertex(f16, f18);
                if (i11 == 0) {
                    shapeData3.setInitialPoint(f16, f18);
                }
                cubicCurveData6.setControlPoint1(f22, f23);
                i12++;
                cubicCurveData6.setControlPoint2(f24, f25);
                cubicCurveData6.setVertex(f19, f21);
                curves2.get(i12).setControlPoint1(f19, f21);
            }
            i12++;
            i11++;
            curves = list;
        }
        return shapeData3;
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public void setContents(List<Content> list, List<Content> list2) {
    }
}
