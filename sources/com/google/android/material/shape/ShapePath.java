package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.List;

public class ShapePath {
    public static final float ANGLE_LEFT = 180.0f;
    private static final float ANGLE_UP = 270.0f;
    private boolean containsIncompatibleShadowOp;
    @Deprecated
    public float currentShadowAngle;
    @Deprecated
    public float endShadowAngle;
    @Deprecated
    public float endX;
    @Deprecated
    public float endY;
    private final List<PathOperation> operations = new ArrayList();
    private final List<ShadowCompatOperation> shadowCompatOperations = new ArrayList();
    @Deprecated
    public float startX;
    @Deprecated
    public float startY;

    public static class ArcShadowOperation extends ShadowCompatOperation {
        private final PathArcOperation operation;

        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            this.operation = pathArcOperation;
        }

        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i11, Canvas canvas) {
            float access$800 = this.operation.getStartAngle();
            float access$900 = this.operation.getSweepAngle();
            shadowRenderer.drawCornerShadow(canvas, matrix, new RectF(this.operation.getLeft(), this.operation.getTop(), this.operation.getRight(), this.operation.getBottom()), i11, access$800, access$900);
        }
    }

    public static class LineShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation;
        private final float startX;
        private final float startY;

        public LineShadowOperation(PathLineOperation pathLineOperation, float f11, float f12) {
            this.operation = pathLineOperation;
            this.startX = f11;
            this.startY = f12;
        }

        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i11, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (this.operation.f66763y - this.startY), (double) (this.operation.f66762x - this.startX)), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.startX, this.startY);
            matrix2.preRotate(getAngle());
            shadowRenderer.drawEdgeShadow(canvas, matrix2, rectF, i11);
        }

        public float getAngle() {
            return (float) Math.toDegrees(Math.atan((double) ((this.operation.f66763y - this.startY) / (this.operation.f66762x - this.startX))));
        }
    }

    public static class PathArcOperation extends PathOperation {
        private static final RectF rectF = new RectF();
        @Deprecated
        public float bottom;
        @Deprecated
        public float left;
        @Deprecated
        public float right;
        @Deprecated
        public float startAngle;
        @Deprecated
        public float sweepAngle;
        @Deprecated
        public float top;

        public PathArcOperation(float f11, float f12, float f13, float f14) {
            setLeft(f11);
            setTop(f12);
            setRight(f13);
            setBottom(f14);
        }

        /* access modifiers changed from: private */
        public float getBottom() {
            return this.bottom;
        }

        /* access modifiers changed from: private */
        public float getLeft() {
            return this.left;
        }

        /* access modifiers changed from: private */
        public float getRight() {
            return this.right;
        }

        /* access modifiers changed from: private */
        public float getStartAngle() {
            return this.startAngle;
        }

        /* access modifiers changed from: private */
        public float getSweepAngle() {
            return this.sweepAngle;
        }

        /* access modifiers changed from: private */
        public float getTop() {
            return this.top;
        }

        private void setBottom(float f11) {
            this.bottom = f11;
        }

        private void setLeft(float f11) {
            this.left = f11;
        }

        private void setRight(float f11) {
            this.right = f11;
        }

        /* access modifiers changed from: private */
        public void setStartAngle(float f11) {
            this.startAngle = f11;
        }

        /* access modifiers changed from: private */
        public void setSweepAngle(float f11) {
            this.sweepAngle = f11;
        }

        private void setTop(float f11) {
            this.top = f11;
        }

        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF2 = rectF;
            rectF2.set(getLeft(), getTop(), getRight(), getBottom());
            path.arcTo(rectF2, getStartAngle(), getSweepAngle(), false);
            path.transform(matrix);
        }
    }

    public static class PathCubicOperation extends PathOperation {
        private float controlX1;
        private float controlX2;
        private float controlY1;
        private float controlY2;
        private float endX;
        private float endY;

        public PathCubicOperation(float f11, float f12, float f13, float f14, float f15, float f16) {
            setControlX1(f11);
            setControlY1(f12);
            setControlX2(f13);
            setControlY2(f14);
            setEndX(f15);
            setEndY(f16);
        }

        private float getControlX1() {
            return this.controlX1;
        }

        private float getControlX2() {
            return this.controlX2;
        }

        private float getControlY1() {
            return this.controlY1;
        }

        private float getControlY2() {
            return this.controlY1;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setControlX1(float f11) {
            this.controlX1 = f11;
        }

        private void setControlX2(float f11) {
            this.controlX2 = f11;
        }

        private void setControlY1(float f11) {
            this.controlY1 = f11;
        }

        private void setControlY2(float f11) {
            this.controlY2 = f11;
        }

        private void setEndX(float f11) {
            this.endX = f11;
        }

        private void setEndY(float f11) {
            this.endY = f11;
        }

        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(this.controlX1, this.controlY1, this.controlX2, this.controlY2, this.endX, this.endY);
            path.transform(matrix);
        }
    }

    public static class PathLineOperation extends PathOperation {
        /* access modifiers changed from: private */

        /* renamed from: x  reason: collision with root package name */
        public float f66762x;
        /* access modifiers changed from: private */

        /* renamed from: y  reason: collision with root package name */
        public float f66763y;

        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f66762x, this.f66763y);
            path.transform(matrix);
        }
    }

    public static abstract class PathOperation {
        public final Matrix matrix = new Matrix();

        public abstract void applyToPath(Matrix matrix2, Path path);
    }

    public static class PathQuadOperation extends PathOperation {
        @Deprecated
        public float controlX;
        @Deprecated
        public float controlY;
        @Deprecated
        public float endX;
        @Deprecated
        public float endY;

        private float getControlX() {
            return this.controlX;
        }

        private float getControlY() {
            return this.controlY;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        /* access modifiers changed from: private */
        public void setControlX(float f11) {
            this.controlX = f11;
        }

        /* access modifiers changed from: private */
        public void setControlY(float f11) {
            this.controlY = f11;
        }

        /* access modifiers changed from: private */
        public void setEndX(float f11) {
            this.endX = f11;
        }

        /* access modifiers changed from: private */
        public void setEndY(float f11) {
            this.endY = f11;
        }

        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(getControlX(), getControlY(), getEndX(), getEndY());
            path.transform(matrix);
        }
    }

    public static abstract class ShadowCompatOperation {
        public static final Matrix IDENTITY_MATRIX = new Matrix();

        public abstract void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i11, Canvas canvas);

        public final void draw(ShadowRenderer shadowRenderer, int i11, Canvas canvas) {
            draw(IDENTITY_MATRIX, shadowRenderer, i11, canvas);
        }
    }

    public ShapePath() {
        reset(0.0f, 0.0f);
    }

    private void addConnectingShadowIfNecessary(float f11) {
        if (getCurrentShadowAngle() != f11) {
            float currentShadowAngle2 = ((f11 - getCurrentShadowAngle()) + 360.0f) % 360.0f;
            if (currentShadowAngle2 <= 180.0f) {
                PathArcOperation pathArcOperation = new PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
                pathArcOperation.setStartAngle(getCurrentShadowAngle());
                pathArcOperation.setSweepAngle(currentShadowAngle2);
                this.shadowCompatOperations.add(new ArcShadowOperation(pathArcOperation));
                setCurrentShadowAngle(f11);
            }
        }
    }

    private void addShadowCompatOperation(ShadowCompatOperation shadowCompatOperation, float f11, float f12) {
        addConnectingShadowIfNecessary(f11);
        this.shadowCompatOperations.add(shadowCompatOperation);
        setCurrentShadowAngle(f12);
    }

    private float getCurrentShadowAngle() {
        return this.currentShadowAngle;
    }

    private float getEndShadowAngle() {
        return this.endShadowAngle;
    }

    private void setCurrentShadowAngle(float f11) {
        this.currentShadowAngle = f11;
    }

    private void setEndShadowAngle(float f11) {
        this.endShadowAngle = f11;
    }

    private void setEndX(float f11) {
        this.endX = f11;
    }

    private void setEndY(float f11) {
        this.endY = f11;
    }

    private void setStartX(float f11) {
        this.startX = f11;
    }

    private void setStartY(float f11) {
        this.startY = f11;
    }

    public void addArc(float f11, float f12, float f13, float f14, float f15, float f16) {
        PathArcOperation pathArcOperation = new PathArcOperation(f11, f12, f13, f14);
        pathArcOperation.setStartAngle(f15);
        pathArcOperation.setSweepAngle(f16);
        this.operations.add(pathArcOperation);
        ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
        float f17 = f15 + f16;
        boolean z11 = f16 < 0.0f;
        if (z11) {
            f15 = (f15 + 180.0f) % 360.0f;
        }
        addShadowCompatOperation(arcShadowOperation, f15, z11 ? (180.0f + f17) % 360.0f : f17);
        double d11 = (double) f17;
        setEndX(((f11 + f13) * 0.5f) + (((f13 - f11) / 2.0f) * ((float) Math.cos(Math.toRadians(d11)))));
        setEndY(((f12 + f14) * 0.5f) + (((f14 - f12) / 2.0f) * ((float) Math.sin(Math.toRadians(d11)))));
    }

    public void applyToPath(Matrix matrix, Path path) {
        int size = this.operations.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.operations.get(i11).applyToPath(matrix, path);
        }
    }

    public boolean containsIncompatibleShadowOp() {
        return this.containsIncompatibleShadowOp;
    }

    public ShadowCompatOperation createShadowCompatOperation(Matrix matrix) {
        addConnectingShadowIfNecessary(getEndShadowAngle());
        final Matrix matrix2 = new Matrix(matrix);
        final ArrayList arrayList = new ArrayList(this.shadowCompatOperations);
        return new ShadowCompatOperation() {
            public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i11, Canvas canvas) {
                for (ShadowCompatOperation draw : arrayList) {
                    draw.draw(matrix2, shadowRenderer, i11, canvas);
                }
            }
        };
    }

    public void cubicToPoint(float f11, float f12, float f13, float f14, float f15, float f16) {
        this.operations.add(new PathCubicOperation(f11, f12, f13, f14, f15, f16));
        this.containsIncompatibleShadowOp = true;
        setEndX(f15);
        setEndY(f16);
    }

    public float getEndX() {
        return this.endX;
    }

    public float getEndY() {
        return this.endY;
    }

    public float getStartX() {
        return this.startX;
    }

    public float getStartY() {
        return this.startY;
    }

    public void lineTo(float f11, float f12) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        float unused = pathLineOperation.f66762x = f11;
        float unused2 = pathLineOperation.f66763y = f12;
        this.operations.add(pathLineOperation);
        LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, getEndX(), getEndY());
        addShadowCompatOperation(lineShadowOperation, lineShadowOperation.getAngle() + ANGLE_UP, lineShadowOperation.getAngle() + ANGLE_UP);
        setEndX(f11);
        setEndY(f12);
    }

    public void quadToPoint(float f11, float f12, float f13, float f14) {
        PathQuadOperation pathQuadOperation = new PathQuadOperation();
        pathQuadOperation.setControlX(f11);
        pathQuadOperation.setControlY(f12);
        pathQuadOperation.setEndX(f13);
        pathQuadOperation.setEndY(f14);
        this.operations.add(pathQuadOperation);
        this.containsIncompatibleShadowOp = true;
        setEndX(f13);
        setEndY(f14);
    }

    public void reset(float f11, float f12) {
        reset(f11, f12, ANGLE_UP, 0.0f);
    }

    public void reset(float f11, float f12, float f13, float f14) {
        setStartX(f11);
        setStartY(f12);
        setEndX(f11);
        setEndY(f12);
        setCurrentShadowAngle(f13);
        setEndShadowAngle((f13 + f14) % 360.0f);
        this.operations.clear();
        this.shadowCompatOperations.clear();
        this.containsIncompatibleShadowOp = false;
    }

    public ShapePath(float f11, float f12) {
        reset(f11, f12);
    }
}
