package com.jumio.jvision.jvcorejava.swig;

public class JVCoreJavaJNI {
    static {
        swig_module_init();
    }

    public static final native int Color_getA(long j11, Color color);

    public static final native int Color_getB(long j11, Color color);

    public static final native int Color_getG(long j11, Color color);

    public static final native int Color_getR(long j11, Color color);

    public static final native void Color_setA(long j11, Color color, int i11);

    public static final native void Color_setB(long j11, Color color, int i11);

    public static final native void Color_setG(long j11, Color color, int i11);

    public static final native void Color_setR(long j11, Color color, int i11);

    public static final native String FrameProcessorException_what(long j11, FrameProcessorException frameProcessorException);

    public static final native void FrameProcessor_change_ownership(FrameProcessor frameProcessor, long j11, boolean z11);

    public static final native void FrameProcessor_director_connect(FrameProcessor frameProcessor, long j11, boolean z11, boolean z12);

    public static final native void FrameProcessor_processFrame(long j11, FrameProcessor frameProcessor);

    public static final native void FrameProcessor_processFrameSwigExplicitFrameProcessor(long j11, FrameProcessor frameProcessor);

    public static final native void FrameProcessor_pushFrame(long j11, FrameProcessor frameProcessor, int i11, long j12, ImageSource imageSource);

    public static final native void FrameProcessor_pushFrameSwigExplicitFrameProcessor(long j11, FrameProcessor frameProcessor, int i11, long j12, ImageSource imageSource);

    public static final native void FrameProcessor_reset(long j11, FrameProcessor frameProcessor);

    public static final native void FrameProcessor_resetState(long j11, FrameProcessor frameProcessor);

    public static final native void FrameProcessor_resetStateSwigExplicitFrameProcessor(long j11, FrameProcessor frameProcessor);

    public static final native void FrameQueue_clear(long j11, FrameQueue frameQueue);

    public static final native void FrameQueue_getAllFrames(long j11, FrameQueue frameQueue, long j12, ImageSourceVector imageSourceVector);

    public static final native long FrameQueue_getFrameByID(long j11, FrameQueue frameQueue, int i11);

    public static final native void FrameQueue_getFramesInRange(long j11, FrameQueue frameQueue, int i11, int i12, long j12, ImageSourceVector imageSourceVector);

    public static final native long FrameQueue_lastFrame(long j11, FrameQueue frameQueue);

    public static final native void FrameQueue_pushFrame(long j11, FrameQueue frameQueue, int i11, long j12, ImageSource imageSource);

    public static final native boolean FrameQueue_removeFrameByID(long j11, FrameQueue frameQueue, int i11);

    public static final native long FrameQueue_size(long j11, FrameQueue frameQueue);

    public static final native int ImageFormat_BGRA_get();

    public static final native int ImageFormat_BGR_get();

    public static final native int ImageFormat_GRAY_get();

    public static final native int ImageFormat_RGBA_get();

    public static final native int ImageFormat_RGB_get();

    public static final native int ImageFormat_YUVNV21_get();

    public static final native int ImageFormat_YUVYV12_get();

    public static final native long ImageSourceVector_capacity(long j11, ImageSourceVector imageSourceVector);

    public static final native void ImageSourceVector_clear(long j11, ImageSourceVector imageSourceVector);

    public static final native void ImageSourceVector_doAdd__SWIG_0(long j11, ImageSourceVector imageSourceVector, long j12, ImageSource imageSource);

    public static final native void ImageSourceVector_doAdd__SWIG_1(long j11, ImageSourceVector imageSourceVector, int i11, long j12, ImageSource imageSource);

    public static final native long ImageSourceVector_doGet(long j11, ImageSourceVector imageSourceVector, int i11);

    public static final native long ImageSourceVector_doRemove(long j11, ImageSourceVector imageSourceVector, int i11);

    public static final native void ImageSourceVector_doRemoveRange(long j11, ImageSourceVector imageSourceVector, int i11, int i12);

    public static final native long ImageSourceVector_doSet(long j11, ImageSourceVector imageSourceVector, int i11, long j12, ImageSource imageSource);

    public static final native int ImageSourceVector_doSize(long j11, ImageSourceVector imageSourceVector);

    public static final native boolean ImageSourceVector_isEmpty(long j11, ImageSourceVector imageSourceVector);

    public static final native void ImageSourceVector_reserve(long j11, ImageSourceVector imageSourceVector, long j12);

    public static final native long ImageSource_CreateFromEncodedByteArray(byte[] bArr);

    public static final native long ImageSource_CreateFromFileSystem(String str);

    public static final native long ImageSource_CreateFromUncompressedByteArray(byte[] bArr, int i11, int i12, int i13, int i14);

    public static final native long ImageSource_Crop(long j11, ImageSource imageSource, long j12, Rect2i rect2i);

    public static final native long ImageSource_CropRotate(long j11, ImageSource imageSource, long j12, Rect2i rect2i, int i11);

    public static final native long ImageSource_CropRotateScale(long j11, ImageSource imageSource, long j12, Rect2i rect2i, int i11, long j13, Size2i size2i);

    public static final native int ImageSource_Height(long j11, ImageSource imageSource);

    public static final native int ImageSource_Length(long j11, ImageSource imageSource);

    public static final native long ImageSource_Rotate(long j11, ImageSource imageSource, int i11);

    public static final native int ImageSource_Stride(long j11, ImageSource imageSource);

    public static final native long ImageSource_Warp__SWIG_0(long j11, ImageSource imageSource, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, long j12, Size2i size2i);

    public static final native long ImageSource_Warp__SWIG_1(long j11, ImageSource imageSource, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, float f22, float f23, long j12, Size2i size2i);

    public static final native int ImageSource_Width(long j11, ImageSource imageSource);

    public static final native boolean ImageSource_empty(long j11, ImageSource imageSource);

    public static final native long ImageSource_getGray(long j11, ImageSource imageSource);

    public static final native long ImageSource_getImage(long j11, ImageSource imageSource);

    public static final native long ImageSource_getRGB(long j11, ImageSource imageSource);

    public static final native int Image_channelDepth(long j11, Image image);

    public static final native int Image_channels(long j11, Image image);

    public static final native boolean Image_empty(long j11, Image image);

    public static final native int Image_format(long j11, Image image);

    public static final native void Image_getBytes(long j11, Image image, byte[] bArr);

    public static final native int Image_height(long j11, Image image);

    public static final native int Image_length(long j11, Image image);

    public static final native int Image_stride(long j11, Image image);

    public static final native int Image_width(long j11, Image image);

    public static final native float KeyPoint_angle_get(long j11, KeyPoint keyPoint);

    public static final native void KeyPoint_angle_set(long j11, KeyPoint keyPoint, float f11);

    public static final native int KeyPoint_class_id_get(long j11, KeyPoint keyPoint);

    public static final native void KeyPoint_class_id_set(long j11, KeyPoint keyPoint, int i11);

    public static final native int KeyPoint_octave_get(long j11, KeyPoint keyPoint);

    public static final native void KeyPoint_octave_set(long j11, KeyPoint keyPoint, int i11);

    public static final native long KeyPoint_pt_get(long j11, KeyPoint keyPoint);

    public static final native void KeyPoint_pt_set(long j11, KeyPoint keyPoint, long j12, Point2f point2f);

    public static final native float KeyPoint_response_get(long j11, KeyPoint keyPoint);

    public static final native void KeyPoint_response_set(long j11, KeyPoint keyPoint, float f11);

    public static final native float KeyPoint_size_get(long j11, KeyPoint keyPoint);

    public static final native void KeyPoint_size_set(long j11, KeyPoint keyPoint, float f11);

    public static final native long Line_getP1(long j11, Line line);

    public static final native long Line_getP2(long j11, Line line);

    public static final native void Line_setP1(long j11, Line line, long j12, Point2f point2f);

    public static final native void Line_setP2(long j11, Line line, long j12, Point2f point2f);

    public static final native float Point2f_getX(long j11, Point2f point2f);

    public static final native float Point2f_getY(long j11, Point2f point2f);

    public static final native void Point2f_setX(long j11, Point2f point2f, float f11);

    public static final native void Point2f_setY(long j11, Point2f point2f, float f11);

    public static final native int Point2i_getX(long j11, Point2i point2i);

    public static final native int Point2i_getY(long j11, Point2i point2i);

    public static final native void Point2i_setX(long j11, Point2i point2i, int i11);

    public static final native void Point2i_setY(long j11, Point2i point2i, int i11);

    public static final native long Quadrangle_getBottomLeft(long j11, Quadrangle quadrangle);

    public static final native long Quadrangle_getBottomRight(long j11, Quadrangle quadrangle);

    public static final native long Quadrangle_getTopLeft(long j11, Quadrangle quadrangle);

    public static final native long Quadrangle_getTopRight(long j11, Quadrangle quadrangle);

    public static final native void Quadrangle_setBottomLeft(long j11, Quadrangle quadrangle, long j12, Point2f point2f);

    public static final native void Quadrangle_setBottomRight(long j11, Quadrangle quadrangle, long j12, Point2f point2f);

    public static final native void Quadrangle_setTopLeft(long j11, Quadrangle quadrangle, long j12, Point2f point2f);

    public static final native void Quadrangle_setTopRight(long j11, Quadrangle quadrangle, long j12, Point2f point2f);

    public static final native int Rect2i_area(long j11, Rect2i rect2i);

    public static final native int Rect2i_getHeight(long j11, Rect2i rect2i);

    public static final native int Rect2i_getWidth(long j11, Rect2i rect2i);

    public static final native int Rect2i_getX(long j11, Rect2i rect2i);

    public static final native int Rect2i_getY(long j11, Rect2i rect2i);

    public static final native void Rect2i_setHeight(long j11, Rect2i rect2i, int i11);

    public static final native void Rect2i_setWidth(long j11, Rect2i rect2i, int i11);

    public static final native void Rect2i_setX(long j11, Rect2i rect2i, int i11);

    public static final native void Rect2i_setY(long j11, Rect2i rect2i, int i11);

    public static final native int Size2i_getHeight(long j11, Size2i size2i);

    public static final native int Size2i_getWidth(long j11, Size2i size2i);

    public static final native void Size2i_setHeight(long j11, Size2i size2i, int i11);

    public static final native void Size2i_setWidth(long j11, Size2i size2i, int i11);

    public static void SwigDirector_FrameProcessor_processFrame(FrameProcessor frameProcessor) {
        frameProcessor.processFrame();
    }

    public static void SwigDirector_FrameProcessor_pushFrame(FrameProcessor frameProcessor, int i11, long j11) {
        frameProcessor.pushFrame(i11, new ImageSource(j11, false));
    }

    public static void SwigDirector_FrameProcessor_resetState(FrameProcessor frameProcessor) {
        frameProcessor.resetState();
    }

    public static final native long channelsCount(int i11);

    public static final native void delete_Color(long j11);

    public static final native void delete_FrameProcessor(long j11);

    public static final native void delete_FrameProcessorException(long j11);

    public static final native void delete_FrameQueue(long j11);

    public static final native void delete_Image(long j11);

    public static final native void delete_ImageSource(long j11);

    public static final native void delete_ImageSourceVector(long j11);

    public static final native void delete_KeyPoint(long j11);

    public static final native void delete_Line(long j11);

    public static final native void delete_Point2f(long j11);

    public static final native void delete_Point2i(long j11);

    public static final native void delete_Quadrangle(long j11);

    public static final native void delete_Rect2i(long j11);

    public static final native void delete_Size2i(long j11);

    public static final native long new_Color__SWIG_0();

    public static final native long new_Color__SWIG_1(int i11, int i12, int i13, int i14);

    public static final native long new_FrameProcessor(int i11);

    public static final native long new_FrameProcessorException__SWIG_0(String str);

    public static final native long new_FrameQueue(long j11);

    public static final native long new_Image();

    public static final native long new_ImageSourceVector__SWIG_0();

    public static final native long new_ImageSourceVector__SWIG_1(long j11, ImageSourceVector imageSourceVector);

    public static final native long new_ImageSourceVector__SWIG_2(int i11, long j11, ImageSource imageSource);

    public static final native long new_ImageSource__SWIG_0();

    public static final native long new_ImageSource__SWIG_1(long j11, ImageSource imageSource);

    public static final native long new_KeyPoint__SWIG_0();

    public static final native long new_KeyPoint__SWIG_1(long j11, Point2f point2f, float f11, float f12, float f13, int i11, int i12);

    public static final native long new_KeyPoint__SWIG_10(float f11, float f12, float f13);

    public static final native long new_KeyPoint__SWIG_2(long j11, Point2f point2f, float f11, float f12, float f13, int i11);

    public static final native long new_KeyPoint__SWIG_3(long j11, Point2f point2f, float f11, float f12, float f13);

    public static final native long new_KeyPoint__SWIG_4(long j11, Point2f point2f, float f11, float f12);

    public static final native long new_KeyPoint__SWIG_5(long j11, Point2f point2f, float f11);

    public static final native long new_KeyPoint__SWIG_6(float f11, float f12, float f13, float f14, float f15, int i11, int i12);

    public static final native long new_KeyPoint__SWIG_7(float f11, float f12, float f13, float f14, float f15, int i11);

    public static final native long new_KeyPoint__SWIG_8(float f11, float f12, float f13, float f14, float f15);

    public static final native long new_KeyPoint__SWIG_9(float f11, float f12, float f13, float f14);

    public static final native long new_Line__SWIG_0();

    public static final native long new_Line__SWIG_1(long j11, Point2f point2f, long j12, Point2f point2f2);

    public static final native long new_Point2f__SWIG_0();

    public static final native long new_Point2f__SWIG_1(float f11, float f12);

    public static final native long new_Point2i__SWIG_0();

    public static final native long new_Point2i__SWIG_1(int i11, int i12);

    public static final native long new_Quadrangle__SWIG_0();

    public static final native long new_Quadrangle__SWIG_1(long j11, Point2f point2f, long j12, Point2f point2f2, long j13, Point2f point2f3, long j14, Point2f point2f4);

    public static final native long new_Rect2i__SWIG_0();

    public static final native long new_Rect2i__SWIG_1(int i11, int i12, int i13, int i14);

    public static final native long new_Size2i__SWIG_0();

    public static final native long new_Size2i__SWIG_1(int i11, int i12);

    private static final native void swig_module_init();
}
