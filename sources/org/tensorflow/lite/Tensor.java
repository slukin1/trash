package org.tensorflow.lite;

import java.nio.ByteBuffer;

public interface Tensor {

    public static class QuantizationParams {
        private final float scale;
        private final int zeroPoint;

        public QuantizationParams(float f11, int i11) {
            this.scale = f11;
            this.zeroPoint = i11;
        }

        public float getScale() {
            return this.scale;
        }

        public int getZeroPoint() {
            return this.zeroPoint;
        }
    }

    ByteBuffer asReadOnlyBuffer();

    DataType dataType();

    int index();

    String name();

    int numBytes();

    int numDimensions();

    int numElements();

    QuantizationParams quantizationParams();

    int[] shape();

    int[] shapeSignature();
}
