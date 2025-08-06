package org.tensorflow.lite;

import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import org.tensorflow.lite.Tensor;

final class TensorImpl implements Tensor {
    private final DataType dtype;
    private long nativeHandle;
    private final Tensor.QuantizationParams quantizationParamsCopy;
    private int[] shapeCopy;
    private final int[] shapeSignatureCopy;

    private TensorImpl(long j11) {
        this.nativeHandle = j11;
        this.dtype = DataTypeUtils.fromC(dtype(j11));
        this.shapeCopy = shape(j11);
        this.shapeSignatureCopy = shapeSignature(j11);
        this.quantizationParamsCopy = new Tensor.QuantizationParams(quantizationScale(j11), quantizationZeroPoint(j11));
    }

    private ByteBuffer buffer() {
        return buffer(this.nativeHandle).order(ByteOrder.nativeOrder());
    }

    private static native ByteBuffer buffer(long j11);

    public static int computeNumDimensions(Object obj) {
        if (obj == null || !obj.getClass().isArray()) {
            return 0;
        }
        if (Array.getLength(obj) != 0) {
            return computeNumDimensions(Array.get(obj, 0)) + 1;
        }
        throw new IllegalArgumentException("Array lengths cannot be 0.");
    }

    public static int computeNumElements(int[] iArr) {
        int i11 = 1;
        for (int i12 : iArr) {
            i11 *= i12;
        }
        return i11;
    }

    private int[] computeShapeOf(Object obj) {
        int computeNumDimensions = computeNumDimensions(obj);
        if (this.dtype == DataType.STRING) {
            Class<?> cls = obj.getClass();
            if (cls.isArray()) {
                while (cls.isArray()) {
                    cls = cls.getComponentType();
                }
                if (Byte.TYPE.equals(cls)) {
                    computeNumDimensions--;
                }
            }
        }
        int[] iArr = new int[computeNumDimensions];
        fillShape(obj, 0, iArr);
        return iArr;
    }

    private static native long create(long j11, int i11, int i12);

    private static native long createSignatureInputTensor(long j11, String str);

    private static native long createSignatureOutputTensor(long j11, String str);

    private static native void delete(long j11);

    private static native int dtype(long j11);

    public static void fillShape(Object obj, int i11, int[] iArr) {
        if (iArr != null && i11 != iArr.length) {
            int length = Array.getLength(obj);
            if (iArr[i11] == 0) {
                iArr[i11] = length;
            } else if (iArr[i11] != length) {
                throw new IllegalArgumentException(String.format("Mismatched lengths (%d and %d) in dimension %d", new Object[]{Integer.valueOf(iArr[i11]), Integer.valueOf(length), Integer.valueOf(i11)}));
            }
            int i12 = i11 + 1;
            if (i12 != iArr.length) {
                for (int i13 = 0; i13 < length; i13++) {
                    fillShape(Array.get(obj, i13), i12, iArr);
                }
            }
        }
    }

    public static TensorImpl fromIndex(long j11, int i11) {
        return new TensorImpl(create(j11, i11, 0));
    }

    public static TensorImpl fromSignatureInput(long j11, String str) {
        return new TensorImpl(createSignatureInputTensor(j11, str));
    }

    public static TensorImpl fromSignatureOutput(long j11, String str) {
        return new TensorImpl(createSignatureOutputTensor(j11, str));
    }

    private static native boolean hasDelegateBufferHandle(long j11);

    private static native int index(long j11);

    private static boolean isBuffer(Object obj) {
        return obj instanceof Buffer;
    }

    private static boolean isByteBuffer(Object obj) {
        return obj instanceof ByteBuffer;
    }

    private static native String name(long j11);

    private static native int numBytes(long j11);

    private static native float quantizationScale(long j11);

    private static native int quantizationZeroPoint(long j11);

    private static native void readMultiDimensionalArray(long j11, Object obj);

    private static native int[] shape(long j11);

    private static native int[] shapeSignature(long j11);

    private void throwIfDstShapeIsIncompatible(Object obj) {
        if (isBuffer(obj)) {
            Buffer buffer = (Buffer) obj;
            int numBytes = numBytes();
            int capacity = isByteBuffer(obj) ? buffer.capacity() : buffer.capacity() * this.dtype.byteSize();
            if (numBytes > capacity) {
                throw new IllegalArgumentException(String.format("Cannot copy from a TensorFlowLite tensor (%s) with %d bytes to a Java Buffer with %d bytes.", new Object[]{name(), Integer.valueOf(numBytes), Integer.valueOf(capacity)}));
            }
            return;
        }
        int[] computeShapeOf = computeShapeOf(obj);
        if (!Arrays.equals(computeShapeOf, this.shapeCopy)) {
            throw new IllegalArgumentException(String.format("Cannot copy from a TensorFlowLite tensor (%s) with shape %s to a Java object with shape %s.", new Object[]{name(), Arrays.toString(this.shapeCopy), Arrays.toString(computeShapeOf)}));
        }
    }

    private void throwIfSrcShapeIsIncompatible(Object obj) {
        if (isBuffer(obj)) {
            Buffer buffer = (Buffer) obj;
            int numBytes = numBytes();
            int capacity = isByteBuffer(obj) ? buffer.capacity() : buffer.capacity() * this.dtype.byteSize();
            if (numBytes != capacity) {
                throw new IllegalArgumentException(String.format("Cannot copy to a TensorFlowLite tensor (%s) with %d bytes from a Java Buffer with %d bytes.", new Object[]{name(), Integer.valueOf(numBytes), Integer.valueOf(capacity)}));
            }
            return;
        }
        int[] computeShapeOf = computeShapeOf(obj);
        if (!Arrays.equals(computeShapeOf, this.shapeCopy)) {
            throw new IllegalArgumentException(String.format("Cannot copy to a TensorFlowLite tensor (%s) with shape %s from a Java object with shape %s.", new Object[]{name(), Arrays.toString(this.shapeCopy), Arrays.toString(computeShapeOf)}));
        }
    }

    private void throwIfTypeIsIncompatible(Object obj) {
        DataType dataTypeOf;
        if (!isByteBuffer(obj) && (dataTypeOf = dataTypeOf(obj)) != this.dtype && !DataTypeUtils.toStringName(dataTypeOf).equals(DataTypeUtils.toStringName(this.dtype))) {
            throw new IllegalArgumentException(String.format("Cannot convert between a TensorFlowLite tensor with type %s and a Java object of type %s (which is compatible with the TensorFlowLite type %s).", new Object[]{this.dtype, obj.getClass().getName(), dataTypeOf}));
        }
    }

    private static native void writeDirectBuffer(long j11, Buffer buffer);

    private static native void writeMultiDimensionalArray(long j11, Object obj);

    private static native void writeScalar(long j11, Object obj);

    public ByteBuffer asReadOnlyBuffer() {
        return buffer().asReadOnlyBuffer().order(ByteOrder.nativeOrder());
    }

    public void close() {
        delete(this.nativeHandle);
        this.nativeHandle = 0;
    }

    public void copyTo(Object obj) {
        if (obj != null) {
            throwIfTypeIsIncompatible(obj);
            throwIfDstShapeIsIncompatible(obj);
            if (isBuffer(obj)) {
                copyTo((Buffer) obj);
            } else {
                readMultiDimensionalArray(this.nativeHandle, obj);
            }
        } else if (!hasDelegateBufferHandle(this.nativeHandle)) {
            throw new IllegalArgumentException("Null outputs are allowed only if the Tensor is bound to a buffer handle.");
        }
    }

    public DataType dataType() {
        return this.dtype;
    }

    public DataType dataTypeOf(Object obj) {
        Class<String> cls = String.class;
        Class<?> cls2 = obj.getClass();
        if (cls2.isArray()) {
            while (cls2.isArray()) {
                cls2 = cls2.getComponentType();
            }
            if (Float.TYPE.equals(cls2)) {
                return DataType.FLOAT32;
            }
            if (Integer.TYPE.equals(cls2)) {
                return DataType.INT32;
            }
            if (Short.TYPE.equals(cls2)) {
                return DataType.INT16;
            }
            if (Byte.TYPE.equals(cls2)) {
                DataType dataType = this.dtype;
                DataType dataType2 = DataType.STRING;
                if (dataType == dataType2) {
                    return dataType2;
                }
                return DataType.UINT8;
            } else if (Long.TYPE.equals(cls2)) {
                return DataType.INT64;
            } else {
                if (Boolean.TYPE.equals(cls2)) {
                    return DataType.BOOL;
                }
                if (cls.equals(cls2)) {
                    return DataType.STRING;
                }
            }
        } else if (Float.class.equals(cls2) || (obj instanceof FloatBuffer)) {
            return DataType.FLOAT32;
        } else {
            if (Integer.class.equals(cls2) || (obj instanceof IntBuffer)) {
                return DataType.INT32;
            }
            if (Short.class.equals(cls2) || (obj instanceof ShortBuffer)) {
                return DataType.INT16;
            }
            if (Byte.class.equals(cls2)) {
                return DataType.UINT8;
            }
            if (Long.class.equals(cls2) || (obj instanceof LongBuffer)) {
                return DataType.INT64;
            }
            if (Boolean.class.equals(cls2)) {
                return DataType.BOOL;
            }
            if (cls.equals(cls2)) {
                return DataType.STRING;
            }
        }
        throw new IllegalArgumentException("DataType error: cannot resolve DataType of " + obj.getClass().getName());
    }

    public int[] getInputShapeIfDifferent(Object obj) {
        if (obj == null || isBuffer(obj)) {
            return null;
        }
        throwIfTypeIsIncompatible(obj);
        int[] computeShapeOf = computeShapeOf(obj);
        if (Arrays.equals(this.shapeCopy, computeShapeOf)) {
            return null;
        }
        return computeShapeOf;
    }

    public int index() {
        return index(this.nativeHandle);
    }

    public String name() {
        return name(this.nativeHandle);
    }

    public int numBytes() {
        return numBytes(this.nativeHandle);
    }

    public int numDimensions() {
        return this.shapeCopy.length;
    }

    public int numElements() {
        return computeNumElements(this.shapeCopy);
    }

    public Tensor.QuantizationParams quantizationParams() {
        return this.quantizationParamsCopy;
    }

    public void refreshShape() {
        this.shapeCopy = shape(this.nativeHandle);
    }

    public void setTo(Object obj) {
        if (obj != null) {
            throwIfTypeIsIncompatible(obj);
            throwIfSrcShapeIsIncompatible(obj);
            if (isBuffer(obj)) {
                setTo((Buffer) obj);
            } else if (this.dtype == DataType.STRING && this.shapeCopy.length == 0) {
                writeScalar(this.nativeHandle, obj);
            } else if (obj.getClass().isArray()) {
                writeMultiDimensionalArray(this.nativeHandle, obj);
            } else {
                writeScalar(this.nativeHandle, obj);
            }
        } else if (!hasDelegateBufferHandle(this.nativeHandle)) {
            throw new IllegalArgumentException("Null inputs are allowed only if the Tensor is bound to a buffer handle.");
        }
    }

    public int[] shape() {
        return this.shapeCopy;
    }

    public int[] shapeSignature() {
        return this.shapeSignatureCopy;
    }

    private void copyTo(Buffer buffer) {
        if (buffer instanceof ByteBuffer) {
            ((ByteBuffer) buffer).put(buffer());
        } else if (buffer instanceof FloatBuffer) {
            ((FloatBuffer) buffer).put(buffer().asFloatBuffer());
        } else if (buffer instanceof LongBuffer) {
            ((LongBuffer) buffer).put(buffer().asLongBuffer());
        } else if (buffer instanceof IntBuffer) {
            ((IntBuffer) buffer).put(buffer().asIntBuffer());
        } else if (buffer instanceof ShortBuffer) {
            ((ShortBuffer) buffer).put(buffer().asShortBuffer());
        } else {
            throw new IllegalArgumentException("Unexpected output buffer type: " + buffer);
        }
    }

    private void setTo(Buffer buffer) {
        if (buffer instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) buffer;
            if (!byteBuffer.isDirect() || byteBuffer.order() != ByteOrder.nativeOrder()) {
                buffer().put(byteBuffer);
            } else {
                writeDirectBuffer(this.nativeHandle, buffer);
            }
        } else if (buffer instanceof LongBuffer) {
            LongBuffer longBuffer = (LongBuffer) buffer;
            if (!longBuffer.isDirect() || longBuffer.order() != ByteOrder.nativeOrder()) {
                buffer().asLongBuffer().put(longBuffer);
            } else {
                writeDirectBuffer(this.nativeHandle, buffer);
            }
        } else if (buffer instanceof FloatBuffer) {
            FloatBuffer floatBuffer = (FloatBuffer) buffer;
            if (!floatBuffer.isDirect() || floatBuffer.order() != ByteOrder.nativeOrder()) {
                buffer().asFloatBuffer().put(floatBuffer);
            } else {
                writeDirectBuffer(this.nativeHandle, buffer);
            }
        } else if (buffer instanceof IntBuffer) {
            IntBuffer intBuffer = (IntBuffer) buffer;
            if (!intBuffer.isDirect() || intBuffer.order() != ByteOrder.nativeOrder()) {
                buffer().asIntBuffer().put(intBuffer);
            } else {
                writeDirectBuffer(this.nativeHandle, buffer);
            }
        } else if (buffer instanceof ShortBuffer) {
            ShortBuffer shortBuffer = (ShortBuffer) buffer;
            if (!shortBuffer.isDirect() || shortBuffer.order() != ByteOrder.nativeOrder()) {
                buffer().asShortBuffer().put(shortBuffer);
            } else {
                writeDirectBuffer(this.nativeHandle, buffer);
            }
        } else {
            throw new IllegalArgumentException("Unexpected input buffer type: " + buffer);
        }
    }
}
