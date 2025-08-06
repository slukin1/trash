package org.opencv.core;

import a.a;
import java.nio.ByteBuffer;

public class Mat {
    public final long nativeObj;

    public Mat(long j11) {
        if (j11 != 0) {
            this.nativeObj = j11;
            return;
        }
        throw new UnsupportedOperationException("Native object address is NULL");
    }

    public static Mat eye(int i11, int i12, int i13) {
        return new Mat(n_eye(i11, i12, i13));
    }

    private static native void locateROI_0(long j11, double[] dArr, double[] dArr2);

    private static native String nDump(long j11);

    private static native double[] nGet(long j11, int i11, int i12);

    private static native int nGetB(long j11, int i11, int i12, int i13, byte[] bArr);

    private static native int nGetBIdx(long j11, int[] iArr, int i11, byte[] bArr);

    private static native int nGetD(long j11, int i11, int i12, int i13, double[] dArr);

    private static native int nGetDIdx(long j11, int[] iArr, int i11, double[] dArr);

    private static native int nGetF(long j11, int i11, int i12, int i13, float[] fArr);

    private static native int nGetFIdx(long j11, int[] iArr, int i11, float[] fArr);

    private static native int nGetI(long j11, int i11, int i12, int i13, int[] iArr);

    private static native int nGetIIdx(long j11, int[] iArr, int i11, int[] iArr2);

    private static native double[] nGetIdx(long j11, int[] iArr);

    private static native int nGetS(long j11, int i11, int i12, int i13, short[] sArr);

    private static native int nGetSIdx(long j11, int[] iArr, int i11, short[] sArr);

    private static native int nPutB(long j11, int i11, int i12, int i13, byte[] bArr);

    private static native int nPutBIdx(long j11, int[] iArr, int i11, byte[] bArr);

    private static native int nPutBwIdxOffset(long j11, int[] iArr, int i11, int i12, byte[] bArr);

    private static native int nPutBwOffset(long j11, int i11, int i12, int i13, int i14, byte[] bArr);

    private static native int nPutD(long j11, int i11, int i12, int i13, double[] dArr);

    private static native int nPutDIdx(long j11, int[] iArr, int i11, double[] dArr);

    private static native int nPutF(long j11, int i11, int i12, int i13, float[] fArr);

    private static native int nPutFIdx(long j11, int[] iArr, int i11, float[] fArr);

    private static native int nPutI(long j11, int i11, int i12, int i13, int[] iArr);

    private static native int nPutIIdx(long j11, int[] iArr, int i11, int[] iArr2);

    private static native int nPutS(long j11, int i11, int i12, int i13, short[] sArr);

    private static native int nPutSIdx(long j11, int[] iArr, int i11, short[] sArr);

    private static native long n_Mat();

    private static native long n_Mat(double d11, double d12, int i11);

    private static native long n_Mat(double d11, double d12, int i11, double d13, double d14, double d15, double d16);

    private static native long n_Mat(int i11, int i12, int i13);

    private static native long n_Mat(int i11, int i12, int i13, double d11, double d12, double d13, double d14);

    private static native long n_Mat(int i11, int i12, int i13, ByteBuffer byteBuffer);

    private static native long n_Mat(int i11, int i12, int i13, ByteBuffer byteBuffer, long j11);

    private static native long n_Mat(int i11, int[] iArr, int i12);

    private static native long n_Mat(int i11, int[] iArr, int i12, double d11, double d12, double d13, double d14);

    private static native long n_Mat(long j11, int i11, int i12);

    private static native long n_Mat(long j11, int i11, int i12, int i13, int i14);

    private static native long n_Mat(long j11, Range[] rangeArr);

    private static native long n_adjustROI(long j11, int i11, int i12, int i13, int i14);

    private static native void n_assignTo(long j11, long j12);

    private static native void n_assignTo(long j11, long j12, int i11);

    private static native int n_channels(long j11);

    private static native int n_checkVector(long j11, int i11);

    private static native int n_checkVector(long j11, int i11, int i12);

    private static native int n_checkVector(long j11, int i11, int i12, boolean z11);

    private static native long n_clone(long j11);

    private static native long n_col(long j11, int i11);

    private static native long n_colRange(long j11, int i11, int i12);

    private static native int n_cols(long j11);

    private static native void n_convertTo(long j11, long j12, int i11);

    private static native void n_convertTo(long j11, long j12, int i11, double d11);

    private static native void n_convertTo(long j11, long j12, int i11, double d11, double d12);

    private static native void n_copySize(long j11, long j12);

    private static native void n_copyTo(long j11, long j12);

    private static native void n_copyTo(long j11, long j12, long j13);

    private static native void n_create(long j11, double d11, double d12, int i11);

    private static native void n_create(long j11, int i11, int i12, int i13);

    private static native void n_create(long j11, int i11, int[] iArr, int i12);

    private static native long n_cross(long j11, long j12);

    private static native long n_dataAddr(long j11);

    private static native void n_delete(long j11);

    private static native int n_depth(long j11);

    private static native long n_diag(long j11);

    private static native long n_diag(long j11, int i11);

    private static native int n_dims(long j11);

    private static native double n_dot(long j11, long j12);

    private static native long n_elemSize(long j11);

    private static native long n_elemSize1(long j11);

    private static native boolean n_empty(long j11);

    private static native long n_eye(double d11, double d12, int i11);

    private static native long n_eye(int i11, int i12, int i13);

    private static native long n_inv(long j11);

    private static native long n_inv(long j11, int i11);

    private static native boolean n_isContinuous(long j11);

    private static native boolean n_isSubmatrix(long j11);

    private static native long n_mul(long j11, long j12);

    private static native long n_mul(long j11, long j12, double d11);

    private static native long n_ones(double d11, double d12, int i11);

    private static native long n_ones(int i11, int i12, int i13);

    private static native long n_ones(int i11, int[] iArr, int i12);

    private static native void n_push_back(long j11, long j12);

    private static native void n_release(long j11);

    private static native long n_reshape(long j11, int i11);

    private static native long n_reshape(long j11, int i11, int i12);

    private static native long n_reshape_1(long j11, int i11, int i12, int[] iArr);

    private static native long n_row(long j11, int i11);

    private static native long n_rowRange(long j11, int i11, int i12);

    private static native int n_rows(long j11);

    private static native long n_setTo(long j11, double d11, double d12, double d13, double d14);

    private static native long n_setTo(long j11, double d11, double d12, double d13, double d14, long j12);

    private static native long n_setTo(long j11, long j12);

    private static native long n_setTo(long j11, long j12, long j13);

    private static native double[] n_size(long j11);

    private static native int n_size_i(long j11, int i11);

    private static native long n_step1(long j11);

    private static native long n_step1(long j11, int i11);

    private static native long n_submat(long j11, int i11, int i12, int i13, int i14);

    private static native long n_submat_ranges(long j11, Range[] rangeArr);

    private static native long n_submat_rr(long j11, int i11, int i12, int i13, int i14);

    private static native long n_t(long j11);

    private static native long n_total(long j11);

    private static native int n_type(long j11);

    private static native long n_zeros(double d11, double d12, int i11);

    private static native long n_zeros(int i11, int i12, int i13);

    private static native long n_zeros(int i11, int[] iArr, int i12);

    public static Mat ones(int i11, int i12, int i13) {
        return new Mat(n_ones(i11, i12, i13));
    }

    public static Mat zeros(int i11, int i12, int i13) {
        return new Mat(n_zeros(i11, i12, i13));
    }

    public Mat adjustROI(int i11, int i12, int i13, int i14) {
        return new Mat(n_adjustROI(this.nativeObj, i11, i12, i13, i14));
    }

    public void assignTo(Mat mat, int i11) {
        n_assignTo(this.nativeObj, mat.nativeObj, i11);
    }

    public int channels() {
        return n_channels(this.nativeObj);
    }

    public int checkVector(int i11, int i12, boolean z11) {
        return n_checkVector(this.nativeObj, i11, i12, z11);
    }

    public Mat col(int i11) {
        return new Mat(n_col(this.nativeObj, i11));
    }

    public Mat colRange(int i11, int i12) {
        return new Mat(n_colRange(this.nativeObj, i11, i12));
    }

    public int cols() {
        return n_cols(this.nativeObj);
    }

    public void convertTo(Mat mat, int i11, double d11, double d12) {
        n_convertTo(this.nativeObj, mat.nativeObj, i11, d11, d12);
    }

    public void copySize(Mat mat) {
        n_copySize(this.nativeObj, mat.nativeObj);
    }

    public void copyTo(Mat mat) {
        n_copyTo(this.nativeObj, mat.nativeObj);
    }

    public void create(int i11, int i12, int i13) {
        n_create(this.nativeObj, i11, i12, i13);
    }

    public Mat cross(Mat mat) {
        return new Mat(n_cross(this.nativeObj, mat.nativeObj));
    }

    public long dataAddr() {
        return n_dataAddr(this.nativeObj);
    }

    public int depth() {
        return n_depth(this.nativeObj);
    }

    public Mat diag(int i11) {
        return new Mat(n_diag(this.nativeObj, i11));
    }

    public int dims() {
        return n_dims(this.nativeObj);
    }

    public double dot(Mat mat) {
        return n_dot(this.nativeObj, mat.nativeObj);
    }

    public String dump() {
        return nDump(this.nativeObj);
    }

    public long elemSize() {
        return n_elemSize(this.nativeObj);
    }

    public long elemSize1() {
        return n_elemSize1(this.nativeObj);
    }

    public boolean empty() {
        return n_empty(this.nativeObj);
    }

    public void finalize() throws Throwable {
        n_delete(this.nativeObj);
        super.finalize();
    }

    public int get(int i11, int i12, byte[] bArr) {
        int type = type();
        if (bArr == null || bArr.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(bArr == null ? 0 : bArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (CvType.depth(type) == 0 || CvType.depth(type) == 1) {
            return nGetB(this.nativeObj, i11, i12, bArr.length, bArr);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public int height() {
        return rows();
    }

    public Mat inv(int i11) {
        return new Mat(n_inv(this.nativeObj, i11));
    }

    public boolean isContinuous() {
        return n_isContinuous(this.nativeObj);
    }

    public boolean isSubmatrix() {
        return n_isSubmatrix(this.nativeObj);
    }

    public void locateROI(Size size, Point point) {
        double[] dArr = new double[2];
        double[] dArr2 = new double[2];
        locateROI_0(this.nativeObj, dArr, dArr2);
        if (size != null) {
            size.width = dArr[0];
            size.height = dArr[1];
        }
        if (point != null) {
            point.f25587x = dArr2[0];
            point.f25588y = dArr2[1];
        }
    }

    public Mat mul(Mat mat, double d11) {
        return new Mat(n_mul(this.nativeObj, mat.nativeObj, d11));
    }

    public void push_back(Mat mat) {
        n_push_back(this.nativeObj, mat.nativeObj);
    }

    public int put(int i11, int i12, double... dArr) {
        int type = type();
        if (dArr == null || dArr.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(dArr == null ? 0 : dArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        }
        return nPutD(this.nativeObj, i11, i12, dArr.length, dArr);
    }

    public void release() {
        n_release(this.nativeObj);
    }

    public Mat reshape(int i11, int i12) {
        return new Mat(n_reshape(this.nativeObj, i11, i12));
    }

    public Mat row(int i11) {
        return new Mat(n_row(this.nativeObj, i11));
    }

    public Mat rowRange(int i11, int i12) {
        return new Mat(n_rowRange(this.nativeObj, i11, i12));
    }

    public int rows() {
        return n_rows(this.nativeObj);
    }

    public Mat setTo(Scalar scalar) {
        long j11 = this.nativeObj;
        double[] dArr = scalar.val;
        return new Mat(n_setTo(j11, dArr[0], dArr[1], dArr[2], dArr[3]));
    }

    public Size size() {
        return new Size(n_size(this.nativeObj));
    }

    public long step1(int i11) {
        return n_step1(this.nativeObj, i11);
    }

    public Mat submat(int i11, int i12, int i13, int i14) {
        return new Mat(n_submat_rr(this.nativeObj, i11, i12, i13, i14));
    }

    public Mat t() {
        return new Mat(n_t(this.nativeObj));
    }

    public String toString() {
        String str = dims() > 0 ? "" : "-1*-1*";
        for (int i11 = 0; i11 < dims(); i11++) {
            StringBuilder c11 = a.c(str);
            c11.append(size(i11));
            c11.append("*");
            str = c11.toString();
        }
        return "Mat [ " + str + CvType.typeToString(type()) + ", isCont=" + isContinuous() + ", isSubmat=" + isSubmatrix() + ", nativeObj=0x" + Long.toHexString(this.nativeObj) + ", dataAddr=0x" + Long.toHexString(dataAddr()) + " ]";
    }

    public long total() {
        return n_total(this.nativeObj);
    }

    public int type() {
        return n_type(this.nativeObj);
    }

    public int width() {
        return cols();
    }

    public static Mat eye(Size size, int i11) {
        return new Mat(n_eye(size.width, size.height, i11));
    }

    public static Mat ones(Size size, int i11) {
        return new Mat(n_ones(size.width, size.height, i11));
    }

    public static Mat zeros(Size size, int i11) {
        return new Mat(n_zeros(size.width, size.height, i11));
    }

    public void assignTo(Mat mat) {
        n_assignTo(this.nativeObj, mat.nativeObj);
    }

    public int checkVector(int i11, int i12) {
        return n_checkVector(this.nativeObj, i11, i12);
    }

    public Mat clone() {
        return new Mat(n_clone(this.nativeObj));
    }

    public Mat colRange(Range range) {
        return new Mat(n_colRange(this.nativeObj, range.start, range.end));
    }

    public void convertTo(Mat mat, int i11, double d11) {
        n_convertTo(this.nativeObj, mat.nativeObj, i11, d11);
    }

    public void copyTo(Mat mat, Mat mat2) {
        n_copyTo(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public void create(Size size, int i11) {
        n_create(this.nativeObj, size.width, size.height, i11);
    }

    public Mat diag() {
        return new Mat(n_diag(this.nativeObj, 0));
    }

    public Mat inv() {
        return new Mat(n_inv(this.nativeObj));
    }

    public Mat mul(Mat mat) {
        return new Mat(n_mul(this.nativeObj, mat.nativeObj));
    }

    public Mat reshape(int i11) {
        return new Mat(n_reshape(this.nativeObj, i11));
    }

    public Mat rowRange(Range range) {
        return new Mat(n_rowRange(this.nativeObj, range.start, range.end));
    }

    public Mat setTo(Scalar scalar, Mat mat) {
        long j11 = this.nativeObj;
        double[] dArr = scalar.val;
        return new Mat(n_setTo(j11, dArr[0], dArr[1], dArr[2], dArr[3], mat.nativeObj));
    }

    public int size(int i11) {
        return n_size_i(this.nativeObj, i11);
    }

    public long step1() {
        return n_step1(this.nativeObj);
    }

    public Mat submat(Range range, Range range2) {
        return new Mat(n_submat_rr(this.nativeObj, range.start, range.end, range2.start, range2.end));
    }

    public static Mat diag(Mat mat) {
        return new Mat(n_diag(mat.nativeObj));
    }

    public static Mat ones(int[] iArr, int i11) {
        return new Mat(n_ones(iArr.length, iArr, i11));
    }

    public static Mat zeros(int[] iArr, int i11) {
        return new Mat(n_zeros(iArr.length, iArr, i11));
    }

    public int checkVector(int i11) {
        return n_checkVector(this.nativeObj, i11);
    }

    public void convertTo(Mat mat, int i11) {
        n_convertTo(this.nativeObj, mat.nativeObj, i11);
    }

    public void create(int[] iArr, int i11) {
        n_create(this.nativeObj, iArr.length, iArr, i11);
    }

    public Mat reshape(int i11, int[] iArr) {
        return new Mat(n_reshape_1(this.nativeObj, i11, iArr.length, iArr));
    }

    public Mat setTo(Mat mat, Mat mat2) {
        return new Mat(n_setTo(this.nativeObj, mat.nativeObj, mat2.nativeObj));
    }

    public Mat submat(Range[] rangeArr) {
        return new Mat(n_submat_ranges(this.nativeObj, rangeArr));
    }

    public Mat() {
        this.nativeObj = n_Mat();
    }

    public Mat setTo(Mat mat) {
        return new Mat(n_setTo(this.nativeObj, mat.nativeObj));
    }

    public Mat submat(Rect rect) {
        return new Mat(n_submat(this.nativeObj, rect.f25592x, rect.f25593y, rect.width, rect.height));
    }

    public Mat(int i11, int i12, int i13) {
        this.nativeObj = n_Mat(i11, i12, i13);
    }

    public int put(int[] iArr, double... dArr) {
        int type = type();
        if (dArr == null || dArr.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(dArr == null ? 0 : dArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (iArr.length == dims()) {
            return nPutDIdx(this.nativeObj, iArr, dArr.length, dArr);
        } else {
            throw new IllegalArgumentException("Incorrect number of indices");
        }
    }

    public Mat(int i11, int i12, int i13, ByteBuffer byteBuffer) {
        this.nativeObj = n_Mat(i11, i12, i13, byteBuffer);
    }

    public int get(int[] iArr, byte[] bArr) {
        int type = type();
        if (bArr == null || bArr.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(bArr == null ? 0 : bArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (iArr.length != dims()) {
            throw new IllegalArgumentException("Incorrect number of indices");
        } else if (CvType.depth(type) == 0 || CvType.depth(type) == 1) {
            return nGetBIdx(this.nativeObj, iArr, bArr.length, bArr);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public Mat(int i11, int i12, int i13, ByteBuffer byteBuffer, long j11) {
        this.nativeObj = n_Mat(i11, i12, i13, byteBuffer, j11);
    }

    public Mat(Size size, int i11) {
        this.nativeObj = n_Mat(size.width, size.height, i11);
    }

    public int put(int i11, int i12, float[] fArr) {
        int type = type();
        if (fArr == null || fArr.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(fArr == null ? 0 : fArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (CvType.depth(type) == 5) {
            return nPutF(this.nativeObj, i11, i12, fArr.length, fArr);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public Mat(int[] iArr, int i11) {
        this.nativeObj = n_Mat(iArr.length, iArr, i11);
    }

    public Mat(int i11, int i12, int i13, Scalar scalar) {
        double[] dArr = scalar.val;
        this.nativeObj = n_Mat(i11, i12, i13, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public int get(int i11, int i12, short[] sArr) {
        int type = type();
        if (sArr == null || sArr.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(sArr == null ? 0 : sArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (CvType.depth(type) == 2 || CvType.depth(type) == 3) {
            return nGetS(this.nativeObj, i11, i12, sArr.length, sArr);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public Mat(Size size, int i11, Scalar scalar) {
        Size size2 = size;
        double d11 = size2.width;
        double d12 = size2.height;
        double[] dArr = scalar.val;
        this.nativeObj = n_Mat(d11, d12, i11, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public Mat(int[] iArr, int i11, Scalar scalar) {
        int length = iArr.length;
        double[] dArr = scalar.val;
        this.nativeObj = n_Mat(length, iArr, i11, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public int put(int[] iArr, float[] fArr) {
        int type = type();
        if (fArr == null || fArr.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(fArr == null ? 0 : fArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (iArr.length != dims()) {
            throw new IllegalArgumentException("Incorrect number of indices");
        } else if (CvType.depth(type) == 5) {
            return nPutFIdx(this.nativeObj, iArr, fArr.length, fArr);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public Mat(Mat mat, Range range, Range range2) {
        this.nativeObj = n_Mat(mat.nativeObj, range.start, range.end, range2.start, range2.end);
    }

    public Mat(Mat mat, Range range) {
        this.nativeObj = n_Mat(mat.nativeObj, range.start, range.end);
    }

    public int get(int[] iArr, short[] sArr) {
        int type = type();
        if (sArr == null || sArr.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(sArr == null ? 0 : sArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (iArr.length != dims()) {
            throw new IllegalArgumentException("Incorrect number of indices");
        } else if (CvType.depth(type) == 2 || CvType.depth(type) == 3) {
            return nGetSIdx(this.nativeObj, iArr, sArr.length, sArr);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public Mat(Mat mat, Range[] rangeArr) {
        this.nativeObj = n_Mat(mat.nativeObj, rangeArr);
    }

    public Mat(Mat mat, Rect rect) {
        long j11 = mat.nativeObj;
        int i11 = rect.f25593y;
        int i12 = rect.f25592x;
        this.nativeObj = n_Mat(j11, i11, i11 + rect.height, i12, i12 + rect.width);
    }

    public int put(int i11, int i12, int[] iArr) {
        int type = type();
        if (iArr == null || iArr.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(iArr == null ? 0 : iArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (CvType.depth(type) == 4) {
            return nPutI(this.nativeObj, i11, i12, iArr.length, iArr);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public int get(int i11, int i12, int[] iArr) {
        int type = type();
        if (iArr == null || iArr.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(iArr == null ? 0 : iArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (CvType.depth(type) == 4) {
            return nGetI(this.nativeObj, i11, i12, iArr.length, iArr);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public int put(int[] iArr, int[] iArr2) {
        int type = type();
        if (iArr2 == null || iArr2.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(iArr2 == null ? 0 : iArr2.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (iArr.length != dims()) {
            throw new IllegalArgumentException("Incorrect number of indices");
        } else if (CvType.depth(type) == 4) {
            return nPutIIdx(this.nativeObj, iArr, iArr2.length, iArr2);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public int get(int[] iArr, int[] iArr2) {
        int type = type();
        if (iArr2 == null || iArr2.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(iArr2 == null ? 0 : iArr2.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (iArr.length != dims()) {
            throw new IllegalArgumentException("Incorrect number of indices");
        } else if (CvType.depth(type) == 4) {
            return nGetIIdx(this.nativeObj, iArr, iArr2.length, iArr2);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public int put(int i11, int i12, short[] sArr) {
        int type = type();
        if (sArr == null || sArr.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(sArr == null ? 0 : sArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (CvType.depth(type) == 2 || CvType.depth(type) == 3) {
            return nPutS(this.nativeObj, i11, i12, sArr.length, sArr);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public int get(int i11, int i12, float[] fArr) {
        int type = type();
        if (fArr == null || fArr.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(fArr == null ? 0 : fArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (CvType.depth(type) == 5) {
            return nGetF(this.nativeObj, i11, i12, fArr.length, fArr);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public int put(int[] iArr, short[] sArr) {
        int type = type();
        if (sArr == null || sArr.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(sArr == null ? 0 : sArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (iArr.length != dims()) {
            throw new IllegalArgumentException("Incorrect number of indices");
        } else if (CvType.depth(type) == 2 || CvType.depth(type) == 3) {
            return nPutSIdx(this.nativeObj, iArr, sArr.length, sArr);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public int get(int[] iArr, float[] fArr) {
        int type = type();
        if (fArr == null || fArr.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(fArr == null ? 0 : fArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (iArr.length != dims()) {
            throw new IllegalArgumentException("Incorrect number of indices");
        } else if (CvType.depth(type) == 5) {
            return nGetFIdx(this.nativeObj, iArr, fArr.length, fArr);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public int put(int i11, int i12, byte[] bArr) {
        int type = type();
        if (bArr == null || bArr.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(bArr == null ? 0 : bArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (CvType.depth(type) == 0 || CvType.depth(type) == 1) {
            return nPutB(this.nativeObj, i11, i12, bArr.length, bArr);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public int get(int i11, int i12, double[] dArr) {
        int type = type();
        if (dArr == null || dArr.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(dArr == null ? 0 : dArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (CvType.depth(type) == 6) {
            return nGetD(this.nativeObj, i11, i12, dArr.length, dArr);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public int put(int[] iArr, byte[] bArr) {
        int type = type();
        if (bArr == null || bArr.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(bArr == null ? 0 : bArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (iArr.length != dims()) {
            throw new IllegalArgumentException("Incorrect number of indices");
        } else if (CvType.depth(type) == 0 || CvType.depth(type) == 1) {
            return nPutBIdx(this.nativeObj, iArr, bArr.length, bArr);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public int get(int[] iArr, double[] dArr) {
        int type = type();
        if (dArr == null || dArr.length % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(dArr == null ? 0 : dArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (iArr.length != dims()) {
            throw new IllegalArgumentException("Incorrect number of indices");
        } else if (CvType.depth(type) == 6) {
            return nGetDIdx(this.nativeObj, iArr, dArr.length, dArr);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public int put(int i11, int i12, byte[] bArr, int i13, int i14) {
        int type = type();
        if (bArr == null || i14 % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(bArr == null ? 0 : bArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (CvType.depth(type) == 0 || CvType.depth(type) == 1) {
            return nPutBwOffset(this.nativeObj, i11, i12, i14, i13, bArr);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }

    public double[] get(int i11, int i12) {
        return nGet(this.nativeObj, i11, i12);
    }

    public double[] get(int[] iArr) {
        if (iArr.length == dims()) {
            return nGetIdx(this.nativeObj, iArr);
        }
        throw new IllegalArgumentException("Incorrect number of indices");
    }

    public int put(int[] iArr, byte[] bArr, int i11, int i12) {
        int type = type();
        if (bArr == null || i12 % CvType.channels(type) != 0) {
            StringBuilder c11 = a.c("Provided data element number (");
            c11.append(bArr == null ? 0 : bArr.length);
            c11.append(") should be multiple of the Mat channels count (");
            throw new UnsupportedOperationException(a.a(type, c11, ")"));
        } else if (iArr.length != dims()) {
            throw new IllegalArgumentException("Incorrect number of indices");
        } else if (CvType.depth(type) == 0 || CvType.depth(type) == 1) {
            return nPutBwIdxOffset(this.nativeObj, iArr, i12, i11, bArr);
        } else {
            throw new UnsupportedOperationException(a.b("Mat data type is not compatible: ", type));
        }
    }
}
