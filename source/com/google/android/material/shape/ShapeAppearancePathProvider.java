package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;

public class ShapeAppearancePathProvider {
    private final Path boundsPath = new Path();
    private final Path cornerPath = new Path();
    private final ShapePath[] cornerPaths = new ShapePath[4];
    private final Matrix[] cornerTransforms = new Matrix[4];
    private boolean edgeIntersectionCheckEnabled = true;
    private final Path edgePath = new Path();
    private final Matrix[] edgeTransforms = new Matrix[4];
    private final Path overlappedEdgePath = new Path();
    private final PointF pointF = new PointF();
    private final float[] scratch = new float[2];
    private final float[] scratch2 = new float[2];
    private final ShapePath shapePath = new ShapePath();

    public static class Lazy {
        public static final ShapeAppearancePathProvider INSTANCE = new ShapeAppearancePathProvider();

        private Lazy() {
        }
    }

    public interface PathListener {
        void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i11);

        void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i11);
    }

    public static final class ShapeAppearancePathSpec {
        public final RectF bounds;
        public final float interpolation;
        public final Path path;
        public final PathListener pathListener;
        public final ShapeAppearanceModel shapeAppearanceModel;

        public ShapeAppearancePathSpec(ShapeAppearanceModel shapeAppearanceModel2, float f11, RectF rectF, PathListener pathListener2, Path path2) {
            this.pathListener = pathListener2;
            this.shapeAppearanceModel = shapeAppearanceModel2;
            this.interpolation = f11;
            this.bounds = rectF;
            this.path = path2;
        }
    }

    public ShapeAppearancePathProvider() {
        for (int i11 = 0; i11 < 4; i11++) {
            this.cornerPaths[i11] = new ShapePath();
            this.cornerTransforms[i11] = new Matrix();
            this.edgeTransforms[i11] = new Matrix();
        }
    }

    private float angleOfEdge(int i11) {
        return (float) ((i11 + 1) * 90);
    }

    private void appendCornerPath(ShapeAppearancePathSpec shapeAppearancePathSpec, int i11) {
        this.scratch[0] = this.cornerPaths[i11].getStartX();
        this.scratch[1] = this.cornerPaths[i11].getStartY();
        this.cornerTransforms[i11].mapPoints(this.scratch);
        if (i11 == 0) {
            Path path = shapeAppearancePathSpec.path;
            float[] fArr = this.scratch;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = shapeAppearancePathSpec.path;
            float[] fArr2 = this.scratch;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.cornerPaths[i11].applyToPath(this.cornerTransforms[i11], shapeAppearancePathSpec.path);
        PathListener pathListener = shapeAppearancePathSpec.pathListener;
        if (pathListener != null) {
            pathListener.onCornerPathCreated(this.cornerPaths[i11], this.cornerTransforms[i11], i11);
        }
    }

    private void appendEdgePath(ShapeAppearancePathSpec shapeAppearancePathSpec, int i11) {
        int i12 = (i11 + 1) % 4;
        this.scratch[0] = this.cornerPaths[i11].getEndX();
        this.scratch[1] = this.cornerPaths[i11].getEndY();
        this.cornerTransforms[i11].mapPoints(this.scratch);
        this.scratch2[0] = this.cornerPaths[i12].getStartX();
        this.scratch2[1] = this.cornerPaths[i12].getStartY();
        this.cornerTransforms[i12].mapPoints(this.scratch2);
        float[] fArr = this.scratch;
        float f11 = fArr[0];
        float[] fArr2 = this.scratch2;
        float max = Math.max(((float) Math.hypot((double) (f11 - fArr2[0]), (double) (fArr[1] - fArr2[1]))) - 0.001f, 0.0f);
        float edgeCenterForIndex = getEdgeCenterForIndex(shapeAppearancePathSpec.bounds, i11);
        this.shapePath.reset(0.0f, 0.0f);
        EdgeTreatment edgeTreatmentForIndex = getEdgeTreatmentForIndex(i11, shapeAppearancePathSpec.shapeAppearanceModel);
        edgeTreatmentForIndex.getEdgePath(max, edgeCenterForIndex, shapeAppearancePathSpec.interpolation, this.shapePath);
        this.edgePath.reset();
        this.shapePath.applyToPath(this.edgeTransforms[i11], this.edgePath);
        if (!this.edgeIntersectionCheckEnabled || Build.VERSION.SDK_INT < 19 || (!edgeTreatmentForIndex.forceIntersection() && !pathOverlapsCorner(this.edgePath, i11) && !pathOverlapsCorner(this.edgePath, i12))) {
            this.shapePath.applyToPath(this.edgeTransforms[i11], shapeAppearancePathSpec.path);
        } else {
            Path path = this.edgePath;
            path.op(path, this.boundsPath, Path.Op.DIFFERENCE);
            this.scratch[0] = this.shapePath.getStartX();
            this.scratch[1] = this.shapePath.getStartY();
            this.edgeTransforms[i11].mapPoints(this.scratch);
            Path path2 = this.overlappedEdgePath;
            float[] fArr3 = this.scratch;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.shapePath.applyToPath(this.edgeTransforms[i11], this.overlappedEdgePath);
        }
        PathListener pathListener = shapeAppearancePathSpec.pathListener;
        if (pathListener != null) {
            pathListener.onEdgePathCreated(this.shapePath, this.edgeTransforms[i11], i11);
        }
    }

    private void getCoordinatesOfCorner(int i11, RectF rectF, PointF pointF2) {
        if (i11 == 1) {
            pointF2.set(rectF.right, rectF.bottom);
        } else if (i11 == 2) {
            pointF2.set(rectF.left, rectF.bottom);
        } else if (i11 != 3) {
            pointF2.set(rectF.right, rectF.top);
        } else {
            pointF2.set(rectF.left, rectF.top);
        }
    }

    private CornerSize getCornerSizeForIndex(int i11, ShapeAppearanceModel shapeAppearanceModel) {
        if (i11 == 1) {
            return shapeAppearanceModel.getBottomRightCornerSize();
        }
        if (i11 == 2) {
            return shapeAppearanceModel.getBottomLeftCornerSize();
        }
        if (i11 != 3) {
            return shapeAppearanceModel.getTopRightCornerSize();
        }
        return shapeAppearanceModel.getTopLeftCornerSize();
    }

    private CornerTreatment getCornerTreatmentForIndex(int i11, ShapeAppearanceModel shapeAppearanceModel) {
        if (i11 == 1) {
            return shapeAppearanceModel.getBottomRightCorner();
        }
        if (i11 == 2) {
            return shapeAppearanceModel.getBottomLeftCorner();
        }
        if (i11 != 3) {
            return shapeAppearanceModel.getTopRightCorner();
        }
        return shapeAppearanceModel.getTopLeftCorner();
    }

    private float getEdgeCenterForIndex(RectF rectF, int i11) {
        float[] fArr = this.scratch;
        ShapePath[] shapePathArr = this.cornerPaths;
        fArr[0] = shapePathArr[i11].endX;
        fArr[1] = shapePathArr[i11].endY;
        this.cornerTransforms[i11].mapPoints(fArr);
        if (i11 == 1 || i11 == 3) {
            return Math.abs(rectF.centerX() - this.scratch[0]);
        }
        return Math.abs(rectF.centerY() - this.scratch[1]);
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int i11, ShapeAppearanceModel shapeAppearanceModel) {
        if (i11 == 1) {
            return shapeAppearanceModel.getBottomEdge();
        }
        if (i11 == 2) {
            return shapeAppearanceModel.getLeftEdge();
        }
        if (i11 != 3) {
            return shapeAppearanceModel.getRightEdge();
        }
        return shapeAppearanceModel.getTopEdge();
    }

    public static ShapeAppearancePathProvider getInstance() {
        return Lazy.INSTANCE;
    }

    private boolean pathOverlapsCorner(Path path, int i11) {
        this.cornerPath.reset();
        this.cornerPaths[i11].applyToPath(this.cornerTransforms[i11], this.cornerPath);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.cornerPath.computeBounds(rectF, true);
        path.op(this.cornerPath, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty()) {
            return true;
        }
        if (rectF.width() <= 1.0f || rectF.height() <= 1.0f) {
            return false;
        }
        return true;
    }

    private void setCornerPathAndTransform(ShapeAppearancePathSpec shapeAppearancePathSpec, int i11) {
        getCornerTreatmentForIndex(i11, shapeAppearancePathSpec.shapeAppearanceModel).getCornerPath(this.cornerPaths[i11], 90.0f, shapeAppearancePathSpec.interpolation, shapeAppearancePathSpec.bounds, getCornerSizeForIndex(i11, shapeAppearancePathSpec.shapeAppearanceModel));
        float angleOfEdge = angleOfEdge(i11);
        this.cornerTransforms[i11].reset();
        getCoordinatesOfCorner(i11, shapeAppearancePathSpec.bounds, this.pointF);
        Matrix matrix = this.cornerTransforms[i11];
        PointF pointF2 = this.pointF;
        matrix.setTranslate(pointF2.x, pointF2.y);
        this.cornerTransforms[i11].preRotate(angleOfEdge);
    }

    private void setEdgePathAndTransform(int i11) {
        this.scratch[0] = this.cornerPaths[i11].getEndX();
        this.scratch[1] = this.cornerPaths[i11].getEndY();
        this.cornerTransforms[i11].mapPoints(this.scratch);
        float angleOfEdge = angleOfEdge(i11);
        this.edgeTransforms[i11].reset();
        Matrix matrix = this.edgeTransforms[i11];
        float[] fArr = this.scratch;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.edgeTransforms[i11].preRotate(angleOfEdge);
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f11, RectF rectF, Path path) {
        calculatePath(shapeAppearanceModel, f11, rectF, (PathListener) null, path);
    }

    public void setEdgeIntersectionCheckEnable(boolean z11) {
        this.edgeIntersectionCheckEnabled = z11;
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f11, RectF rectF, PathListener pathListener, Path path) {
        path.rewind();
        this.overlappedEdgePath.rewind();
        this.boundsPath.rewind();
        this.boundsPath.addRect(rectF, Path.Direction.CW);
        ShapeAppearancePathSpec shapeAppearancePathSpec = new ShapeAppearancePathSpec(shapeAppearanceModel, f11, rectF, pathListener, path);
        for (int i11 = 0; i11 < 4; i11++) {
            setCornerPathAndTransform(shapeAppearancePathSpec, i11);
            setEdgePathAndTransform(i11);
        }
        for (int i12 = 0; i12 < 4; i12++) {
            appendCornerPath(shapeAppearancePathSpec, i12);
            appendEdgePath(shapeAppearancePathSpec, i12);
        }
        path.close();
        this.overlappedEdgePath.close();
        if (Build.VERSION.SDK_INT >= 19 && !this.overlappedEdgePath.isEmpty()) {
            path.op(this.overlappedEdgePath, Path.Op.UNION);
        }
    }
}
