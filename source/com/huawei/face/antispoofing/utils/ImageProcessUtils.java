package com.huawei.face.antispoofing.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import java.nio.ByteBuffer;

public class ImageProcessUtils {

    /* renamed from: a  reason: collision with root package name */
    private RenderScript f37604a;

    /* renamed from: b  reason: collision with root package name */
    private ScriptIntrinsicYuvToRGB f37605b;

    /* renamed from: c  reason: collision with root package name */
    private Type.Builder f37606c;

    /* renamed from: d  reason: collision with root package name */
    private Allocation f37607d;

    /* renamed from: e  reason: collision with root package name */
    private Allocation f37608e;

    public ImageProcessUtils(Context context) {
        RenderScript create = RenderScript.create(context);
        this.f37604a = create;
        this.f37605b = ScriptIntrinsicYuvToRGB.create(create, Element.U8_4(create));
    }

    public byte[] bitmapToBgr(Bitmap bitmap) {
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(allocate);
        byte[] array = allocate.array();
        byte[] bArr = new byte[((array.length / 4) * 3)];
        int length = array.length / 4;
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i11 * 3;
            int i13 = i11 * 4;
            bArr[i12] = array[i13 + 2];
            bArr[i12 + 1] = array[i13 + 1];
            bArr[i12 + 2] = array[i13];
        }
        return bArr;
    }

    public Bitmap convertYuvToRgb(byte[] bArr, int i11, int i12) {
        if (this.f37606c == null) {
            RenderScript renderScript = this.f37604a;
            Type.Builder x11 = new Type.Builder(renderScript, Element.U8(renderScript)).setX(bArr.length);
            this.f37606c = x11;
            this.f37607d = Allocation.createTyped(this.f37604a, x11.create(), 1);
            RenderScript renderScript2 = this.f37604a;
            this.f37608e = Allocation.createTyped(this.f37604a, new Type.Builder(renderScript2, Element.RGBA_8888(renderScript2)).setX(i11).setY(i12).create(), 1);
        }
        this.f37607d.copyFrom(bArr);
        this.f37605b.setInput(this.f37607d);
        this.f37605b.forEach(this.f37608e);
        Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
        this.f37608e.copyTo(createBitmap);
        return createBitmap;
    }

    public Bitmap preProcess(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(270.0f);
        matrix.postScale(-1.0f, 1.0f);
        matrix.postScale(0.5f, 0.5f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
