package org.opencv.core;

public class Core {
    public static final int BORDER_CONSTANT = 0;
    public static final int BORDER_DEFAULT = 4;
    public static final int BORDER_ISOLATED = 16;
    public static final int BORDER_REFLECT = 2;
    public static final int BORDER_REFLECT101 = 4;
    public static final int BORDER_REFLECT_101 = 4;
    public static final int BORDER_REPLICATE = 1;
    public static final int BORDER_TRANSPARENT = 5;
    public static final int BORDER_WRAP = 3;
    public static final int BadAlign = -21;
    public static final int BadAlphaChannel = -18;
    public static final int BadCOI = -24;
    public static final int BadCallBack = -22;
    public static final int BadDataPtr = -12;
    public static final int BadDepth = -17;
    public static final int BadImageSize = -10;
    public static final int BadModelOrChSeq = -14;
    public static final int BadNumChannel1U = -16;
    public static final int BadNumChannels = -15;
    public static final int BadOffset = -11;
    public static final int BadOrder = -19;
    public static final int BadOrigin = -20;
    public static final int BadROISize = -25;
    public static final int BadStep = -13;
    public static final int BadTileSize = -23;
    public static final int CMP_EQ = 0;
    public static final int CMP_GE = 2;
    public static final int CMP_GT = 1;
    public static final int CMP_LE = 4;
    public static final int CMP_LT = 3;
    public static final int CMP_NE = 5;
    public static final int COVAR_COLS = 16;
    public static final int COVAR_NORMAL = 1;
    public static final int COVAR_ROWS = 8;
    public static final int COVAR_SCALE = 4;
    public static final int COVAR_SCRAMBLED = 0;
    public static final int COVAR_USE_AVG = 2;
    private static final int CV_16S = 3;
    private static final int CV_16U = 2;
    private static final int CV_32F = 5;
    private static final int CV_32S = 4;
    private static final int CV_64F = 6;
    private static final int CV_8S = 1;
    private static final int CV_8U = 0;
    private static final int CV_USRTYPE1 = 7;
    public static final int DCT_INVERSE = 1;
    public static final int DCT_ROWS = 4;
    public static final int DECOMP_CHOLESKY = 3;
    public static final int DECOMP_EIG = 2;
    public static final int DECOMP_LU = 0;
    public static final int DECOMP_NORMAL = 16;
    public static final int DECOMP_QR = 4;
    public static final int DECOMP_SVD = 1;
    public static final int DFT_COMPLEX_INPUT = 64;
    public static final int DFT_COMPLEX_OUTPUT = 16;
    public static final int DFT_INVERSE = 1;
    public static final int DFT_REAL_OUTPUT = 32;
    public static final int DFT_ROWS = 4;
    public static final int DFT_SCALE = 2;
    public static final int FILLED = -1;
    public static final int FONT_HERSHEY_COMPLEX = 3;
    public static final int FONT_HERSHEY_COMPLEX_SMALL = 5;
    public static final int FONT_HERSHEY_DUPLEX = 2;
    public static final int FONT_HERSHEY_PLAIN = 1;
    public static final int FONT_HERSHEY_SCRIPT_COMPLEX = 7;
    public static final int FONT_HERSHEY_SCRIPT_SIMPLEX = 6;
    public static final int FONT_HERSHEY_SIMPLEX = 0;
    public static final int FONT_HERSHEY_TRIPLEX = 4;
    public static final int FONT_ITALIC = 16;
    public static final int Formatter_FMT_C = 5;
    public static final int Formatter_FMT_CSV = 2;
    public static final int Formatter_FMT_DEFAULT = 0;
    public static final int Formatter_FMT_MATLAB = 1;
    public static final int Formatter_FMT_NUMPY = 4;
    public static final int Formatter_FMT_PYTHON = 3;
    public static final int GEMM_1_T = 1;
    public static final int GEMM_2_T = 2;
    public static final int GEMM_3_T = 4;
    public static final int GpuApiCallError = -217;
    public static final int GpuNotSupported = -216;
    public static final int Hamming_normType = 6;
    public static final int HeaderIsNull = -9;
    public static final int KMEANS_PP_CENTERS = 2;
    public static final int KMEANS_RANDOM_CENTERS = 0;
    public static final int KMEANS_USE_INITIAL_LABELS = 1;
    public static final int LINE_4 = 4;
    public static final int LINE_8 = 8;
    public static final int LINE_AA = 16;
    public static final int MaskIsTiled = -26;
    public static final String NATIVE_LIBRARY_NAME = getNativeLibraryName();
    public static final int NORM_HAMMING = 6;
    public static final int NORM_HAMMING2 = 7;
    public static final int NORM_INF = 1;
    public static final int NORM_L1 = 2;
    public static final int NORM_L2 = 4;
    public static final int NORM_L2SQR = 5;
    public static final int NORM_MINMAX = 32;
    public static final int NORM_RELATIVE = 8;
    public static final int NORM_TYPE_MASK = 7;
    public static final int OpenCLApiCallError = -220;
    public static final int OpenCLDoubleNotSupported = -221;
    public static final int OpenCLInitError = -222;
    public static final int OpenCLNoAMDBlasFft = -223;
    public static final int OpenGlApiCallError = -219;
    public static final int OpenGlNotSupported = -218;
    public static final int PCA_DATA_AS_COL = 1;
    public static final int PCA_DATA_AS_ROW = 0;
    public static final int PCA_USE_AVG = 2;
    public static final int Param_ALGORITHM = 6;
    public static final int Param_BOOLEAN = 1;
    public static final int Param_FLOAT = 7;
    public static final int Param_INT = 0;
    public static final int Param_MAT = 4;
    public static final int Param_MAT_VECTOR = 5;
    public static final int Param_REAL = 2;
    public static final int Param_SCALAR = 12;
    public static final int Param_STRING = 3;
    public static final int Param_UCHAR = 11;
    public static final int Param_UINT64 = 9;
    public static final int Param_UNSIGNED_INT = 8;
    public static final int REDUCE_AVG = 1;
    public static final int REDUCE_MAX = 2;
    public static final int REDUCE_MIN = 3;
    public static final int REDUCE_SUM = 0;
    public static final int RNG_NORMAL = 1;
    public static final int RNG_UNIFORM = 0;
    public static final int ROTATE_180 = 1;
    public static final int ROTATE_90_CLOCKWISE = 0;
    public static final int ROTATE_90_COUNTERCLOCKWISE = 2;
    public static final int SORT_ASCENDING = 0;
    public static final int SORT_DESCENDING = 16;
    public static final int SORT_EVERY_COLUMN = 1;
    public static final int SORT_EVERY_ROW = 0;
    public static final int SVD_FULL_UV = 4;
    public static final int SVD_MODIFY_A = 1;
    public static final int SVD_NO_UV = 2;
    public static final int StsAssert = -215;
    public static final int StsAutoTrace = -8;
    public static final int StsBackTrace = -1;
    public static final int StsBadArg = -5;
    public static final int StsBadFlag = -206;
    public static final int StsBadFunc = -6;
    public static final int StsBadMask = -208;
    public static final int StsBadMemBlock = -214;
    public static final int StsBadPoint = -207;
    public static final int StsBadSize = -201;
    public static final int StsDivByZero = -202;
    public static final int StsError = -2;
    public static final int StsFilterOffsetErr = -31;
    public static final int StsFilterStructContentErr = -29;
    public static final int StsInplaceNotSupported = -203;
    public static final int StsInternal = -3;
    public static final int StsKernelStructContentErr = -30;
    public static final int StsNoConv = -7;
    public static final int StsNoMem = -4;
    public static final int StsNotImplemented = -213;
    public static final int StsNullPtr = -27;
    public static final int StsObjectNotFound = -204;
    public static final int StsOk = 0;
    public static final int StsOutOfRange = -211;
    public static final int StsParseError = -212;
    public static final int StsUnmatchedFormats = -205;
    public static final int StsUnmatchedSizes = -209;
    public static final int StsUnsupportedFormat = -210;
    public static final int StsVecLengthErr = -28;
    public static final String VERSION = getVersion();
    public static final int VERSION_MAJOR = getVersionMajorJ();
    public static final int VERSION_MINOR = getVersionMinorJ();
    public static final int VERSION_REVISION = getVersionRevisionJ();
    public static final String VERSION_STATUS = getVersionStatusJ();

    public static class MinMaxLocResult {
        public Point maxLoc = new Point();
        public double maxVal = 0.0d;
        public Point minLoc = new Point();
        public double minVal = 0.0d;
    }

    public static void LUT(Mat mat, Mat mat2, Mat mat3) {
        LUT_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void LUT_0(long j11, long j12, long j13);

    public static double Mahalanobis(Mat mat, Mat mat2, Mat mat3) {
        return Mahalanobis_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native double Mahalanobis_0(long j11, long j12, long j13);

    public static void PCABackProject(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        PCABackProject_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    private static native void PCABackProject_0(long j11, long j12, long j13, long j14);

    public static void PCACompute(Mat mat, Mat mat2, Mat mat3, double d11) {
        PCACompute_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d11);
    }

    public static void PCACompute2(Mat mat, Mat mat2, Mat mat3, Mat mat4, double d11) {
        PCACompute2_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, d11);
    }

    private static native void PCACompute2_0(long j11, long j12, long j13, long j14, double d11);

    private static native void PCACompute2_1(long j11, long j12, long j13, long j14, int i11);

    private static native void PCACompute2_2(long j11, long j12, long j13, long j14);

    private static native void PCACompute_0(long j11, long j12, long j13, double d11);

    private static native void PCACompute_1(long j11, long j12, long j13, int i11);

    private static native void PCACompute_2(long j11, long j12, long j13);

    public static void PCAProject(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        PCAProject_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    private static native void PCAProject_0(long j11, long j12, long j13, long j14);

    public static double PSNR(Mat mat, Mat mat2) {
        return PSNR_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native double PSNR_0(long j11, long j12);

    public static void SVBackSubst(Mat mat, Mat mat2, Mat mat3, Mat mat4, Mat mat5) {
        SVBackSubst_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, mat5.nativeObj);
    }

    private static native void SVBackSubst_0(long j11, long j12, long j13, long j14, long j15);

    public static void SVDecomp(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i11) {
        SVDecomp_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i11);
    }

    private static native void SVDecomp_0(long j11, long j12, long j13, long j14, int i11);

    private static native void SVDecomp_1(long j11, long j12, long j13, long j14);

    public static void absdiff(Mat mat, Mat mat2, Mat mat3) {
        absdiff_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void absdiff_0(long j11, long j12, long j13);

    private static native void absdiff_1(long j11, double d11, double d12, double d13, double d14, long j12);

    public static void add(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i11) {
        add_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i11);
    }

    public static void addSamplesDataSearchPath(String str) {
        addSamplesDataSearchPath_0(str);
    }

    private static native void addSamplesDataSearchPath_0(String str);

    public static void addSamplesDataSearchSubDirectory(String str) {
        addSamplesDataSearchSubDirectory_0(str);
    }

    private static native void addSamplesDataSearchSubDirectory_0(String str);

    public static void addWeighted(Mat mat, double d11, Mat mat2, double d12, double d13, Mat mat3, int i11) {
        addWeighted_0(mat.nativeObj, d11, mat2.nativeObj, d12, d13, mat3.nativeObj, i11);
    }

    private static native void addWeighted_0(long j11, double d11, long j12, double d12, double d13, long j13, int i11);

    private static native void addWeighted_1(long j11, double d11, long j12, double d12, double d13, long j13);

    private static native void add_0(long j11, long j12, long j13, long j14, int i11);

    private static native void add_1(long j11, long j12, long j13, long j14);

    private static native void add_2(long j11, long j12, long j13);

    private static native void add_3(long j11, double d11, double d12, double d13, double d14, long j12, long j13, int i11);

    private static native void add_4(long j11, double d11, double d12, double d13, double d14, long j12, long j13);

    private static native void add_5(long j11, double d11, double d12, double d13, double d14, long j12);

    public static void batchDistance(Mat mat, Mat mat2, Mat mat3, int i11, Mat mat4, int i12, int i13, Mat mat5, int i14, boolean z11) {
        batchDistance_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i11, mat4.nativeObj, i12, i13, mat5.nativeObj, i14, z11);
    }

    private static native void batchDistance_0(long j11, long j12, long j13, int i11, long j14, int i12, int i13, long j15, int i14, boolean z11);

    private static native void batchDistance_1(long j11, long j12, long j13, int i11, long j14, int i12, int i13, long j15, int i14);

    private static native void batchDistance_2(long j11, long j12, long j13, int i11, long j14, int i12, int i13, long j15);

    private static native void batchDistance_3(long j11, long j12, long j13, int i11, long j14, int i12, int i13);

    private static native void batchDistance_4(long j11, long j12, long j13, int i11, long j14, int i12);

    private static native void batchDistance_5(long j11, long j12, long j13, int i11, long j14);

    public static void bitwise_and(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        bitwise_and_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    private static native void bitwise_and_0(long j11, long j12, long j13, long j14);

    private static native void bitwise_and_1(long j11, long j12, long j13);

    public static void bitwise_not(Mat mat, Mat mat2, Mat mat3) {
        bitwise_not_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void bitwise_not_0(long j11, long j12, long j13);

    private static native void bitwise_not_1(long j11, long j12);

    public static void bitwise_or(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        bitwise_or_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    private static native void bitwise_or_0(long j11, long j12, long j13, long j14);

    private static native void bitwise_or_1(long j11, long j12, long j13);

    public static void bitwise_xor(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        bitwise_xor_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    private static native void bitwise_xor_0(long j11, long j12, long j13, long j14);

    private static native void bitwise_xor_1(long j11, long j12, long j13);

    public static int borderInterpolate(int i11, int i12, int i13) {
        return borderInterpolate_0(i11, i12, i13);
    }

    private static native int borderInterpolate_0(int i11, int i12, int i13);

    public static void calcCovarMatrix(Mat mat, Mat mat2, Mat mat3, int i11, int i12) {
        calcCovarMatrix_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i11, i12);
    }

    private static native void calcCovarMatrix_0(long j11, long j12, long j13, int i11, int i12);

    private static native void calcCovarMatrix_1(long j11, long j12, long j13, int i11);

    public static void cartToPolar(Mat mat, Mat mat2, Mat mat3, Mat mat4, boolean z11) {
        cartToPolar_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, z11);
    }

    private static native void cartToPolar_0(long j11, long j12, long j13, long j14, boolean z11);

    private static native void cartToPolar_1(long j11, long j12, long j13, long j14);

    public static boolean checkRange(Mat mat, boolean z11, double d11, double d12) {
        return checkRange_0(mat.nativeObj, z11, d11, d12);
    }

    private static native boolean checkRange_0(long j11, boolean z11, double d11, double d12);

    private static native boolean checkRange_1(long j11, boolean z11, double d11);

    private static native boolean checkRange_2(long j11, boolean z11);

    private static native boolean checkRange_4(long j11);

    public static void compare(Mat mat, Mat mat2, Mat mat3, int i11) {
        compare_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i11);
    }

    private static native void compare_0(long j11, long j12, long j13, int i11);

    private static native void compare_1(long j11, double d11, double d12, double d13, double d14, long j12, int i11);

    public static void completeSymm(Mat mat, boolean z11) {
        completeSymm_0(mat.nativeObj, z11);
    }

    private static native void completeSymm_0(long j11, boolean z11);

    private static native void completeSymm_1(long j11);

    public static void convertFp16(Mat mat, Mat mat2) {
        convertFp16_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native void convertFp16_0(long j11, long j12);

    public static void convertScaleAbs(Mat mat, Mat mat2, double d11, double d12) {
        convertScaleAbs_0(mat.nativeObj, mat2.nativeObj, d11, d12);
    }

    private static native void convertScaleAbs_0(long j11, long j12, double d11, double d12);

    private static native void convertScaleAbs_1(long j11, long j12, double d11);

    private static native void convertScaleAbs_2(long j11, long j12);

    public static void copyMakeBorder(Mat mat, Mat mat2, int i11, int i12, int i13, int i14, int i15, Scalar scalar) {
        long j11 = mat.nativeObj;
        long j12 = mat2.nativeObj;
        double[] dArr = scalar.val;
        copyMakeBorder_0(j11, j12, i11, i12, i13, i14, i15, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    private static native void copyMakeBorder_0(long j11, long j12, int i11, int i12, int i13, int i14, int i15, double d11, double d12, double d13, double d14);

    private static native void copyMakeBorder_1(long j11, long j12, int i11, int i12, int i13, int i14, int i15);

    public static int countNonZero(Mat mat) {
        return countNonZero_0(mat.nativeObj);
    }

    private static native int countNonZero_0(long j11);

    public static float cubeRoot(float f11) {
        return cubeRoot_0(f11);
    }

    private static native float cubeRoot_0(float f11);

    public static void dct(Mat mat, Mat mat2, int i11) {
        dct_0(mat.nativeObj, mat2.nativeObj, i11);
    }

    private static native void dct_0(long j11, long j12, int i11);

    private static native void dct_1(long j11, long j12);

    public static double determinant(Mat mat) {
        return determinant_0(mat.nativeObj);
    }

    private static native double determinant_0(long j11);

    public static void dft(Mat mat, Mat mat2, int i11, int i12) {
        dft_0(mat.nativeObj, mat2.nativeObj, i11, i12);
    }

    private static native void dft_0(long j11, long j12, int i11, int i12);

    private static native void dft_1(long j11, long j12, int i11);

    private static native void dft_2(long j11, long j12);

    public static void divide(Mat mat, Mat mat2, Mat mat3, double d11, int i11) {
        divide_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d11, i11);
    }

    private static native void divide_0(long j11, long j12, long j13, double d11, int i11);

    private static native void divide_1(long j11, long j12, long j13, double d11);

    private static native void divide_2(long j11, long j12, long j13);

    private static native void divide_3(long j11, double d11, double d12, double d13, double d14, long j12, double d15, int i11);

    private static native void divide_4(long j11, double d11, double d12, double d13, double d14, long j12, double d15);

    private static native void divide_5(long j11, double d11, double d12, double d13, double d14, long j12);

    private static native void divide_6(double d11, long j11, long j12, int i11);

    private static native void divide_7(double d11, long j11, long j12);

    public static boolean eigen(Mat mat, Mat mat2, Mat mat3) {
        return eigen_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void eigenNonSymmetric(Mat mat, Mat mat2, Mat mat3) {
        eigenNonSymmetric_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void eigenNonSymmetric_0(long j11, long j12, long j13);

    private static native boolean eigen_0(long j11, long j12, long j13);

    private static native boolean eigen_1(long j11, long j12);

    public static void exp(Mat mat, Mat mat2) {
        exp_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native void exp_0(long j11, long j12);

    public static void extractChannel(Mat mat, Mat mat2, int i11) {
        extractChannel_0(mat.nativeObj, mat2.nativeObj, i11);
    }

    private static native void extractChannel_0(long j11, long j12, int i11);

    public static float fastAtan2(float f11, float f12) {
        return fastAtan2_0(f11, f12);
    }

    private static native float fastAtan2_0(float f11, float f12);

    public static String findFile(String str, boolean z11, boolean z12) {
        return findFile_0(str, z11, z12);
    }

    public static String findFileOrKeep(String str, boolean z11) {
        return findFileOrKeep_0(str, z11);
    }

    private static native String findFileOrKeep_0(String str, boolean z11);

    private static native String findFileOrKeep_1(String str);

    private static native String findFile_0(String str, boolean z11, boolean z12);

    private static native String findFile_1(String str, boolean z11);

    private static native String findFile_2(String str);

    public static void findNonZero(Mat mat, Mat mat2) {
        findNonZero_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native void findNonZero_0(long j11, long j12);

    public static void flip(Mat mat, Mat mat2, int i11) {
        flip_0(mat.nativeObj, mat2.nativeObj, i11);
    }

    private static native void flip_0(long j11, long j12, int i11);

    public static void gemm(Mat mat, Mat mat2, double d11, Mat mat3, double d12, Mat mat4, int i11) {
        gemm_0(mat.nativeObj, mat2.nativeObj, d11, mat3.nativeObj, d12, mat4.nativeObj, i11);
    }

    private static native void gemm_0(long j11, long j12, double d11, long j13, double d12, long j14, int i11);

    private static native void gemm_1(long j11, long j12, double d11, long j13, double d12, long j14);

    public static String getBuildInformation() {
        return getBuildInformation_0();
    }

    private static native String getBuildInformation_0();

    public static long getCPUTickCount() {
        return getCPUTickCount_0();
    }

    private static native long getCPUTickCount_0();

    public static String getHardwareFeatureName(int i11) {
        return getHardwareFeatureName_0(i11);
    }

    private static native String getHardwareFeatureName_0(int i11);

    public static String getIppVersion() {
        return getIppVersion_0();
    }

    private static native String getIppVersion_0();

    private static String getNativeLibraryName() {
        return "opencv_java3411";
    }

    public static int getNumThreads() {
        return getNumThreads_0();
    }

    private static native int getNumThreads_0();

    public static int getNumberOfCPUs() {
        return getNumberOfCPUs_0();
    }

    private static native int getNumberOfCPUs_0();

    public static int getOptimalDFTSize(int i11) {
        return getOptimalDFTSize_0(i11);
    }

    private static native int getOptimalDFTSize_0(int i11);

    @Deprecated
    public static int getThreadNum() {
        return getThreadNum_0();
    }

    private static native int getThreadNum_0();

    public static long getTickCount() {
        return getTickCount_0();
    }

    private static native long getTickCount_0();

    public static double getTickFrequency() {
        return getTickFrequency_0();
    }

    private static native double getTickFrequency_0();

    private static String getVersion() {
        return "3.4.11";
    }

    public static int getVersionMajor() {
        return getVersionMajor_0();
    }

    private static int getVersionMajorJ() {
        return 3;
    }

    private static native int getVersionMajor_0();

    public static int getVersionMinor() {
        return getVersionMinor_0();
    }

    private static int getVersionMinorJ() {
        return 4;
    }

    private static native int getVersionMinor_0();

    public static int getVersionRevision() {
        return getVersionRevision_0();
    }

    private static int getVersionRevisionJ() {
        return 11;
    }

    private static native int getVersionRevision_0();

    private static String getVersionStatusJ() {
        return "";
    }

    public static String getVersionString() {
        return getVersionString_0();
    }

    private static native String getVersionString_0();

    public static void idct(Mat mat, Mat mat2, int i11) {
        idct_0(mat.nativeObj, mat2.nativeObj, i11);
    }

    private static native void idct_0(long j11, long j12, int i11);

    private static native void idct_1(long j11, long j12);

    public static void idft(Mat mat, Mat mat2, int i11, int i12) {
        idft_0(mat.nativeObj, mat2.nativeObj, i11, i12);
    }

    private static native void idft_0(long j11, long j12, int i11, int i12);

    private static native void idft_1(long j11, long j12, int i11);

    private static native void idft_2(long j11, long j12);

    public static void inRange(Mat mat, Scalar scalar, Scalar scalar2, Mat mat2) {
        long j11 = mat.nativeObj;
        double[] dArr = scalar.val;
        double[] dArr2 = scalar2.val;
        long j12 = j11;
        inRange_0(j12, dArr[0], dArr[1], dArr[2], dArr[3], dArr2[0], dArr2[1], dArr2[2], dArr2[3], mat2.nativeObj);
    }

    private static native void inRange_0(long j11, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, long j12);

    public static void insertChannel(Mat mat, Mat mat2, int i11) {
        insertChannel_0(mat.nativeObj, mat2.nativeObj, i11);
    }

    private static native void insertChannel_0(long j11, long j12, int i11);

    public static double invert(Mat mat, Mat mat2, int i11) {
        return invert_0(mat.nativeObj, mat2.nativeObj, i11);
    }

    private static native double invert_0(long j11, long j12, int i11);

    private static native double invert_1(long j11, long j12);

    private static native double kmeans_0(long j11, int i11, long j12, int i12, int i13, double d11, int i14, int i15, long j13);

    private static native double kmeans_1(long j11, int i11, long j12, int i12, int i13, double d11, int i14, int i15);

    public static void log(Mat mat, Mat mat2) {
        log_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native void log_0(long j11, long j12);

    public static void magnitude(Mat mat, Mat mat2, Mat mat3) {
        magnitude_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void magnitude_0(long j11, long j12, long j13);

    public static void max(Mat mat, Mat mat2, Mat mat3) {
        max_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void max_0(long j11, long j12, long j13);

    private static native void max_1(long j11, double d11, double d12, double d13, double d14, long j12);

    public static Scalar mean(Mat mat, Mat mat2) {
        return new Scalar(mean_0(mat.nativeObj, mat2.nativeObj));
    }

    public static void meanStdDev(Mat mat, MatOfDouble matOfDouble, MatOfDouble matOfDouble2, Mat mat2) {
        meanStdDev_0(mat.nativeObj, matOfDouble.nativeObj, matOfDouble2.nativeObj, mat2.nativeObj);
    }

    private static native void meanStdDev_0(long j11, long j12, long j13, long j14);

    private static native void meanStdDev_1(long j11, long j12, long j13);

    private static native double[] mean_0(long j11, long j12);

    private static native double[] mean_1(long j11);

    public static void min(Mat mat, Mat mat2, Mat mat3) {
        min_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static MinMaxLocResult minMaxLoc(Mat mat, Mat mat2) {
        MinMaxLocResult minMaxLocResult = new MinMaxLocResult();
        double[] n_minMaxLocManual = n_minMaxLocManual(mat.nativeObj, mat2 != null ? mat2.nativeObj : 0);
        minMaxLocResult.minVal = n_minMaxLocManual[0];
        minMaxLocResult.maxVal = n_minMaxLocManual[1];
        Point point = minMaxLocResult.minLoc;
        point.f25587x = n_minMaxLocManual[2];
        point.f25588y = n_minMaxLocManual[3];
        Point point2 = minMaxLocResult.maxLoc;
        point2.f25587x = n_minMaxLocManual[4];
        point2.f25588y = n_minMaxLocManual[5];
        return minMaxLocResult;
    }

    private static native void min_0(long j11, long j12, long j13);

    private static native void min_1(long j11, double d11, double d12, double d13, double d14, long j12);

    public static void mulSpectrums(Mat mat, Mat mat2, Mat mat3, int i11, boolean z11) {
        mulSpectrums_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i11, z11);
    }

    private static native void mulSpectrums_0(long j11, long j12, long j13, int i11, boolean z11);

    private static native void mulSpectrums_1(long j11, long j12, long j13, int i11);

    public static void mulTransposed(Mat mat, Mat mat2, boolean z11, Mat mat3, double d11, int i11) {
        mulTransposed_0(mat.nativeObj, mat2.nativeObj, z11, mat3.nativeObj, d11, i11);
    }

    private static native void mulTransposed_0(long j11, long j12, boolean z11, long j13, double d11, int i11);

    private static native void mulTransposed_1(long j11, long j12, boolean z11, long j13, double d11);

    private static native void mulTransposed_2(long j11, long j12, boolean z11, long j13);

    private static native void mulTransposed_3(long j11, long j12, boolean z11);

    public static void multiply(Mat mat, Mat mat2, Mat mat3, double d11, int i11) {
        multiply_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d11, i11);
    }

    private static native void multiply_0(long j11, long j12, long j13, double d11, int i11);

    private static native void multiply_1(long j11, long j12, long j13, double d11);

    private static native void multiply_2(long j11, long j12, long j13);

    private static native void multiply_3(long j11, double d11, double d12, double d13, double d14, long j12, double d15, int i11);

    private static native void multiply_4(long j11, double d11, double d12, double d13, double d14, long j12, double d15);

    private static native void multiply_5(long j11, double d11, double d12, double d13, double d14, long j12);

    private static native double[] n_minMaxLocManual(long j11, long j12);

    public static double norm(Mat mat, Mat mat2, int i11, Mat mat3) {
        return norm_0(mat.nativeObj, mat2.nativeObj, i11, mat3.nativeObj);
    }

    private static native double norm_0(long j11, long j12, int i11, long j13);

    private static native double norm_1(long j11, long j12, int i11);

    private static native double norm_2(long j11, long j12);

    private static native double norm_3(long j11, int i11, long j12);

    private static native double norm_4(long j11, int i11);

    private static native double norm_5(long j11);

    public static void normalize(Mat mat, Mat mat2, double d11, double d12, int i11, int i12, Mat mat3) {
        normalize_0(mat.nativeObj, mat2.nativeObj, d11, d12, i11, i12, mat3.nativeObj);
    }

    private static native void normalize_0(long j11, long j12, double d11, double d12, int i11, int i12, long j13);

    private static native void normalize_1(long j11, long j12, double d11, double d12, int i11, int i12);

    private static native void normalize_2(long j11, long j12, double d11, double d12, int i11);

    private static native void normalize_3(long j11, long j12, double d11, double d12);

    private static native void normalize_4(long j11, long j12, double d11);

    private static native void normalize_5(long j11, long j12);

    public static void patchNaNs(Mat mat, double d11) {
        patchNaNs_0(mat.nativeObj, d11);
    }

    private static native void patchNaNs_0(long j11, double d11);

    private static native void patchNaNs_1(long j11);

    public static void perspectiveTransform(Mat mat, Mat mat2, Mat mat3) {
        perspectiveTransform_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void perspectiveTransform_0(long j11, long j12, long j13);

    public static void phase(Mat mat, Mat mat2, Mat mat3, boolean z11) {
        phase_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, z11);
    }

    private static native void phase_0(long j11, long j12, long j13, boolean z11);

    private static native void phase_1(long j11, long j12, long j13);

    public static void polarToCart(Mat mat, Mat mat2, Mat mat3, Mat mat4, boolean z11) {
        polarToCart_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, z11);
    }

    private static native void polarToCart_0(long j11, long j12, long j13, long j14, boolean z11);

    private static native void polarToCart_1(long j11, long j12, long j13, long j14);

    public static void pow(Mat mat, double d11, Mat mat2) {
        pow_0(mat.nativeObj, d11, mat2.nativeObj);
    }

    private static native void pow_0(long j11, double d11, long j12);

    public static void randShuffle(Mat mat, double d11) {
        randShuffle_0(mat.nativeObj, d11);
    }

    private static native void randShuffle_0(long j11, double d11);

    private static native void randShuffle_2(long j11);

    public static void randn(Mat mat, double d11, double d12) {
        randn_0(mat.nativeObj, d11, d12);
    }

    private static native void randn_0(long j11, double d11, double d12);

    public static void randu(Mat mat, double d11, double d12) {
        randu_0(mat.nativeObj, d11, d12);
    }

    private static native void randu_0(long j11, double d11, double d12);

    public static void reduce(Mat mat, Mat mat2, int i11, int i12, int i13) {
        reduce_0(mat.nativeObj, mat2.nativeObj, i11, i12, i13);
    }

    private static native void reduce_0(long j11, long j12, int i11, int i12, int i13);

    private static native void reduce_1(long j11, long j12, int i11, int i12);

    public static void repeat(Mat mat, int i11, int i12, Mat mat2) {
        repeat_0(mat.nativeObj, i11, i12, mat2.nativeObj);
    }

    private static native void repeat_0(long j11, int i11, int i12, long j12);

    public static void rotate(Mat mat, Mat mat2, int i11) {
        rotate_0(mat.nativeObj, mat2.nativeObj, i11);
    }

    private static native void rotate_0(long j11, long j12, int i11);

    public static void scaleAdd(Mat mat, double d11, Mat mat2, Mat mat3) {
        scaleAdd_0(mat.nativeObj, d11, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void scaleAdd_0(long j11, double d11, long j12, long j13);

    public static void setErrorVerbosity(boolean z11) {
        setErrorVerbosity_0(z11);
    }

    private static native void setErrorVerbosity_0(boolean z11);

    public static void setIdentity(Mat mat, Scalar scalar) {
        long j11 = mat.nativeObj;
        double[] dArr = scalar.val;
        setIdentity_0(j11, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    private static native void setIdentity_0(long j11, double d11, double d12, double d13, double d14);

    private static native void setIdentity_1(long j11);

    public static void setNumThreads(int i11) {
        setNumThreads_0(i11);
    }

    private static native void setNumThreads_0(int i11);

    public static void setRNGSeed(int i11) {
        setRNGSeed_0(i11);
    }

    private static native void setRNGSeed_0(int i11);

    public static void setUseIPP(boolean z11) {
        setUseIPP_0(z11);
    }

    private static native void setUseIPP_0(boolean z11);

    public static void setUseIPP_NE(boolean z11) {
        setUseIPP_NE_0(z11);
    }

    private static native void setUseIPP_NE_0(boolean z11);

    public static void setUseIPP_NotExact(boolean z11) {
        setUseIPP_NotExact_0(z11);
    }

    private static native void setUseIPP_NotExact_0(boolean z11);

    public static boolean solve(Mat mat, Mat mat2, Mat mat3, int i11) {
        return solve_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i11);
    }

    public static int solveCubic(Mat mat, Mat mat2) {
        return solveCubic_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native int solveCubic_0(long j11, long j12);

    public static double solvePoly(Mat mat, Mat mat2, int i11) {
        return solvePoly_0(mat.nativeObj, mat2.nativeObj, i11);
    }

    private static native double solvePoly_0(long j11, long j12, int i11);

    private static native double solvePoly_1(long j11, long j12);

    private static native boolean solve_0(long j11, long j12, long j13, int i11);

    private static native boolean solve_1(long j11, long j12, long j13);

    public static void sort(Mat mat, Mat mat2, int i11) {
        sort_0(mat.nativeObj, mat2.nativeObj, i11);
    }

    public static void sortIdx(Mat mat, Mat mat2, int i11) {
        sortIdx_0(mat.nativeObj, mat2.nativeObj, i11);
    }

    private static native void sortIdx_0(long j11, long j12, int i11);

    private static native void sort_0(long j11, long j12, int i11);

    public static void sqrt(Mat mat, Mat mat2) {
        sqrt_0(mat.nativeObj, mat2.nativeObj);
    }

    private static native void sqrt_0(long j11, long j12);

    public static void subtract(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i11) {
        subtract_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i11);
    }

    private static native void subtract_0(long j11, long j12, long j13, long j14, int i11);

    private static native void subtract_1(long j11, long j12, long j13, long j14);

    private static native void subtract_2(long j11, long j12, long j13);

    private static native void subtract_3(long j11, double d11, double d12, double d13, double d14, long j12, long j13, int i11);

    private static native void subtract_4(long j11, double d11, double d12, double d13, double d14, long j12, long j13);

    private static native void subtract_5(long j11, double d11, double d12, double d13, double d14, long j12);

    public static Scalar sumElems(Mat mat) {
        return new Scalar(sumElems_0(mat.nativeObj));
    }

    private static native double[] sumElems_0(long j11);

    public static Scalar trace(Mat mat) {
        return new Scalar(trace_0(mat.nativeObj));
    }

    private static native double[] trace_0(long j11);

    public static void transform(Mat mat, Mat mat2, Mat mat3) {
        transform_0(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    private static native void transform_0(long j11, long j12, long j13);

    public static boolean useIPP() {
        return useIPP_0();
    }

    private static native boolean useIPP_0();

    public static boolean useIPP_NE() {
        return useIPP_NE_0();
    }

    private static native boolean useIPP_NE_0();

    public static boolean useIPP_NotExact() {
        return useIPP_NotExact_0();
    }

    private static native boolean useIPP_NotExact_0();

    public static void PCACompute(Mat mat, Mat mat2, Mat mat3, int i11) {
        PCACompute_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i11);
    }

    public static void PCACompute2(Mat mat, Mat mat2, Mat mat3, Mat mat4, int i11) {
        PCACompute2_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj, i11);
    }

    public static void SVDecomp(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        SVDecomp_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void absdiff(Mat mat, Scalar scalar, Mat mat2) {
        long j11 = mat.nativeObj;
        double[] dArr = scalar.val;
        absdiff_1(j11, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj);
    }

    public static void add(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        add_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void addWeighted(Mat mat, double d11, Mat mat2, double d12, double d13, Mat mat3) {
        addWeighted_1(mat.nativeObj, d11, mat2.nativeObj, d12, d13, mat3.nativeObj);
    }

    public static void batchDistance(Mat mat, Mat mat2, Mat mat3, int i11, Mat mat4, int i12, int i13, Mat mat5, int i14) {
        batchDistance_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i11, mat4.nativeObj, i12, i13, mat5.nativeObj, i14);
    }

    public static void bitwise_and(Mat mat, Mat mat2, Mat mat3) {
        bitwise_and_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void bitwise_not(Mat mat, Mat mat2) {
        bitwise_not_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void bitwise_or(Mat mat, Mat mat2, Mat mat3) {
        bitwise_or_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void bitwise_xor(Mat mat, Mat mat2, Mat mat3) {
        bitwise_xor_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void calcCovarMatrix(Mat mat, Mat mat2, Mat mat3, int i11) {
        calcCovarMatrix_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i11);
    }

    public static void cartToPolar(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        cartToPolar_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static boolean checkRange(Mat mat, boolean z11, double d11) {
        return checkRange_1(mat.nativeObj, z11, d11);
    }

    public static void compare(Mat mat, Scalar scalar, Mat mat2, int i11) {
        long j11 = mat.nativeObj;
        double[] dArr = scalar.val;
        compare_1(j11, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj, i11);
    }

    public static void completeSymm(Mat mat) {
        completeSymm_1(mat.nativeObj);
    }

    public static void convertScaleAbs(Mat mat, Mat mat2, double d11) {
        convertScaleAbs_1(mat.nativeObj, mat2.nativeObj, d11);
    }

    public static void copyMakeBorder(Mat mat, Mat mat2, int i11, int i12, int i13, int i14, int i15) {
        copyMakeBorder_1(mat.nativeObj, mat2.nativeObj, i11, i12, i13, i14, i15);
    }

    public static void dct(Mat mat, Mat mat2) {
        dct_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void dft(Mat mat, Mat mat2, int i11) {
        dft_1(mat.nativeObj, mat2.nativeObj, i11);
    }

    public static void divide(Mat mat, Mat mat2, Mat mat3, double d11) {
        divide_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d11);
    }

    public static boolean eigen(Mat mat, Mat mat2) {
        return eigen_1(mat.nativeObj, mat2.nativeObj);
    }

    public static String findFile(String str, boolean z11) {
        return findFile_1(str, z11);
    }

    public static String findFileOrKeep(String str) {
        return findFileOrKeep_1(str);
    }

    public static void gemm(Mat mat, Mat mat2, double d11, Mat mat3, double d12, Mat mat4) {
        gemm_1(mat.nativeObj, mat2.nativeObj, d11, mat3.nativeObj, d12, mat4.nativeObj);
    }

    public static void idct(Mat mat, Mat mat2) {
        idct_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void idft(Mat mat, Mat mat2, int i11) {
        idft_1(mat.nativeObj, mat2.nativeObj, i11);
    }

    public static double invert(Mat mat, Mat mat2) {
        return invert_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void max(Mat mat, Scalar scalar, Mat mat2) {
        long j11 = mat.nativeObj;
        double[] dArr = scalar.val;
        max_1(j11, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj);
    }

    public static Scalar mean(Mat mat) {
        return new Scalar(mean_1(mat.nativeObj));
    }

    public static void meanStdDev(Mat mat, MatOfDouble matOfDouble, MatOfDouble matOfDouble2) {
        meanStdDev_1(mat.nativeObj, matOfDouble.nativeObj, matOfDouble2.nativeObj);
    }

    public static void min(Mat mat, Scalar scalar, Mat mat2) {
        long j11 = mat.nativeObj;
        double[] dArr = scalar.val;
        min_1(j11, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj);
    }

    public static void mulSpectrums(Mat mat, Mat mat2, Mat mat3, int i11) {
        mulSpectrums_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i11);
    }

    public static void mulTransposed(Mat mat, Mat mat2, boolean z11, Mat mat3, double d11) {
        mulTransposed_1(mat.nativeObj, mat2.nativeObj, z11, mat3.nativeObj, d11);
    }

    public static void multiply(Mat mat, Mat mat2, Mat mat3, double d11) {
        multiply_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, d11);
    }

    public static double norm(Mat mat, Mat mat2, int i11) {
        return norm_1(mat.nativeObj, mat2.nativeObj, i11);
    }

    public static void normalize(Mat mat, Mat mat2, double d11, double d12, int i11, int i12) {
        normalize_1(mat.nativeObj, mat2.nativeObj, d11, d12, i11, i12);
    }

    public static void patchNaNs(Mat mat) {
        patchNaNs_1(mat.nativeObj);
    }

    public static void phase(Mat mat, Mat mat2, Mat mat3) {
        phase_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void polarToCart(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        polarToCart_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void randShuffle(Mat mat) {
        randShuffle_2(mat.nativeObj);
    }

    public static void reduce(Mat mat, Mat mat2, int i11, int i12) {
        reduce_1(mat.nativeObj, mat2.nativeObj, i11, i12);
    }

    public static void setIdentity(Mat mat) {
        setIdentity_1(mat.nativeObj);
    }

    public static boolean solve(Mat mat, Mat mat2, Mat mat3) {
        return solve_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static double solvePoly(Mat mat, Mat mat2) {
        return solvePoly_1(mat.nativeObj, mat2.nativeObj);
    }

    public static void subtract(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        subtract_1(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void PCACompute(Mat mat, Mat mat2, Mat mat3) {
        PCACompute_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void PCACompute2(Mat mat, Mat mat2, Mat mat3, Mat mat4) {
        PCACompute2_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, mat4.nativeObj);
    }

    public static void add(Mat mat, Mat mat2, Mat mat3) {
        add_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void batchDistance(Mat mat, Mat mat2, Mat mat3, int i11, Mat mat4, int i12, int i13, Mat mat5) {
        batchDistance_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i11, mat4.nativeObj, i12, i13, mat5.nativeObj);
    }

    public static boolean checkRange(Mat mat, boolean z11) {
        return checkRange_2(mat.nativeObj, z11);
    }

    public static void convertScaleAbs(Mat mat, Mat mat2) {
        convertScaleAbs_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void dft(Mat mat, Mat mat2) {
        dft_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void divide(Mat mat, Mat mat2, Mat mat3) {
        divide_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static String findFile(String str) {
        return findFile_2(str);
    }

    public static void idft(Mat mat, Mat mat2) {
        idft_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void mulTransposed(Mat mat, Mat mat2, boolean z11, Mat mat3) {
        mulTransposed_2(mat.nativeObj, mat2.nativeObj, z11, mat3.nativeObj);
    }

    public static void multiply(Mat mat, Mat mat2, Mat mat3) {
        multiply_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static double norm(Mat mat, Mat mat2) {
        return norm_2(mat.nativeObj, mat2.nativeObj);
    }

    public static void normalize(Mat mat, Mat mat2, double d11, double d12, int i11) {
        normalize_2(mat.nativeObj, mat2.nativeObj, d11, d12, i11);
    }

    public static void subtract(Mat mat, Mat mat2, Mat mat3) {
        subtract_2(mat.nativeObj, mat2.nativeObj, mat3.nativeObj);
    }

    public static void add(Mat mat, Scalar scalar, Mat mat2, Mat mat3, int i11) {
        long j11 = mat.nativeObj;
        double[] dArr = scalar.val;
        add_3(j11, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj, mat3.nativeObj, i11);
    }

    public static void batchDistance(Mat mat, Mat mat2, Mat mat3, int i11, Mat mat4, int i12, int i13) {
        batchDistance_3(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i11, mat4.nativeObj, i12, i13);
    }

    public static boolean checkRange(Mat mat) {
        return checkRange_4(mat.nativeObj);
    }

    public static void divide(Mat mat, Scalar scalar, Mat mat2, double d11, int i11) {
        long j11 = mat.nativeObj;
        double[] dArr = scalar.val;
        divide_3(j11, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj, d11, i11);
    }

    public static void mulTransposed(Mat mat, Mat mat2, boolean z11) {
        mulTransposed_3(mat.nativeObj, mat2.nativeObj, z11);
    }

    public static void multiply(Mat mat, Scalar scalar, Mat mat2, double d11, int i11) {
        long j11 = mat.nativeObj;
        double[] dArr = scalar.val;
        multiply_3(j11, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj, d11, i11);
    }

    public static double norm(Mat mat, int i11, Mat mat2) {
        return norm_3(mat.nativeObj, i11, mat2.nativeObj);
    }

    public static void normalize(Mat mat, Mat mat2, double d11, double d12) {
        normalize_3(mat.nativeObj, mat2.nativeObj, d11, d12);
    }

    public static void subtract(Mat mat, Scalar scalar, Mat mat2, Mat mat3, int i11) {
        long j11 = mat.nativeObj;
        double[] dArr = scalar.val;
        subtract_3(j11, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj, mat3.nativeObj, i11);
    }

    public static void add(Mat mat, Scalar scalar, Mat mat2, Mat mat3) {
        long j11 = mat.nativeObj;
        double[] dArr = scalar.val;
        add_4(j11, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj, mat3.nativeObj);
    }

    public static void batchDistance(Mat mat, Mat mat2, Mat mat3, int i11, Mat mat4, int i12) {
        batchDistance_4(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i11, mat4.nativeObj, i12);
    }

    public static void divide(Mat mat, Scalar scalar, Mat mat2, double d11) {
        long j11 = mat.nativeObj;
        double[] dArr = scalar.val;
        divide_4(j11, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj, d11);
    }

    public static void multiply(Mat mat, Scalar scalar, Mat mat2, double d11) {
        long j11 = mat.nativeObj;
        double[] dArr = scalar.val;
        multiply_4(j11, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj, d11);
    }

    public static double norm(Mat mat, int i11) {
        return norm_4(mat.nativeObj, i11);
    }

    public static void normalize(Mat mat, Mat mat2, double d11) {
        normalize_4(mat.nativeObj, mat2.nativeObj, d11);
    }

    public static void subtract(Mat mat, Scalar scalar, Mat mat2, Mat mat3) {
        long j11 = mat.nativeObj;
        double[] dArr = scalar.val;
        subtract_4(j11, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj, mat3.nativeObj);
    }

    public static void add(Mat mat, Scalar scalar, Mat mat2) {
        long j11 = mat.nativeObj;
        double[] dArr = scalar.val;
        add_5(j11, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj);
    }

    public static void batchDistance(Mat mat, Mat mat2, Mat mat3, int i11, Mat mat4) {
        batchDistance_5(mat.nativeObj, mat2.nativeObj, mat3.nativeObj, i11, mat4.nativeObj);
    }

    public static void divide(Mat mat, Scalar scalar, Mat mat2) {
        long j11 = mat.nativeObj;
        double[] dArr = scalar.val;
        divide_5(j11, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj);
    }

    public static void multiply(Mat mat, Scalar scalar, Mat mat2) {
        long j11 = mat.nativeObj;
        double[] dArr = scalar.val;
        multiply_5(j11, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj);
    }

    public static double norm(Mat mat) {
        return norm_5(mat.nativeObj);
    }

    public static void normalize(Mat mat, Mat mat2) {
        normalize_5(mat.nativeObj, mat2.nativeObj);
    }

    public static void subtract(Mat mat, Scalar scalar, Mat mat2) {
        long j11 = mat.nativeObj;
        double[] dArr = scalar.val;
        subtract_5(j11, dArr[0], dArr[1], dArr[2], dArr[3], mat2.nativeObj);
    }

    public static void divide(double d11, Mat mat, Mat mat2, int i11) {
        divide_6(d11, mat.nativeObj, mat2.nativeObj, i11);
    }

    public static void divide(double d11, Mat mat, Mat mat2) {
        divide_7(d11, mat.nativeObj, mat2.nativeObj);
    }

    public static MinMaxLocResult minMaxLoc(Mat mat) {
        return minMaxLoc(mat, (Mat) null);
    }
}
