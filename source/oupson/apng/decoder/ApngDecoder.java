package oupson.apng.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.widget.ImageView;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.CRC32;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.i;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;
import oupson.apng.exceptions.BadApngException;
import oupson.apng.exceptions.BadCRCException;
import oupson.apng.utils.Utils;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00042\u00020\u0001:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Loupson/apng/decoder/ApngDecoder;", "", "<init>", "()V", "c", "a", "Companion", "apng_library_release"}, k = 1, mv = {1, 4, 2})
public final class ApngDecoder {

    /* renamed from: a  reason: collision with root package name */
    public static final List<Byte> f52960a;

    /* renamed from: b  reason: collision with root package name */
    public static final i f52961b = LazyKt__LazyJVMKt.a(ApngDecoder$Companion$clearPaint$2.INSTANCE);

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f52962c = new Companion((r) null);

    @Metadata(bv = {}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0005\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b*\u0010+J \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J,\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007J@\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007J@\u0010\u001c\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007R\u001b\u0010\"\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010$\u001a\u00020#8\u0002XT¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Loupson/apng/decoder/ApngDecoder$Companion;", "", "", "ihdrOfApng", "", "width", "height", "e", "Landroid/content/Context;", "context", "Ljava/io/InputStream;", "inStream", "", "speed", "Landroid/graphics/Bitmap$Config;", "config", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/net/Uri;", "uri", "Landroid/widget/ImageView;", "imageView", "Loupson/apng/decoder/ApngDecoder$a;", "callback", "", "b", "Ljava/net/URL;", "url", "c", "Landroid/graphics/Paint;", "clearPaint$delegate", "Lkotlin/i;", "f", "()Landroid/graphics/Paint;", "clearPaint", "", "TAG", "Ljava/lang/String;", "", "", "zeroLength", "Ljava/util/List;", "<init>", "()V", "apng_library_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ void d(Companion companion, Context context, URL url, ImageView imageView, float f11, a aVar, Bitmap.Config config, int i11, Object obj) {
            if ((i11 & 8) != 0) {
                f11 = 1.0f;
            }
            float f12 = f11;
            if ((i11 & 16) != 0) {
                aVar = null;
            }
            a aVar2 = aVar;
            if ((i11 & 32) != 0) {
                config = Bitmap.Config.ARGB_8888;
            }
            companion.c(context, url, imageView, f12, aVar2, config);
        }

        public final Drawable a(Context context, InputStream inputStream, float f11, Bitmap.Config config) {
            BufferedInputStream bufferedInputStream;
            int i11;
            float f12;
            Utils.Companion.BlendOp blendOp;
            int i12;
            int i13;
            Companion companion;
            int i14;
            int i15;
            Bitmap bitmap;
            char c11;
            byte[] bArr;
            Bitmap bitmap2;
            Companion companion2;
            Bitmap bitmap3;
            byte[] bArr2;
            byte[] bArr3;
            Companion companion3;
            byte[] bArr4;
            Bitmap bitmap4;
            int i16;
            int i17;
            Companion companion4 = this;
            Bitmap.Config config2 = config;
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            byte[] bArr5 = new byte[8];
            bufferedInputStream2.mark(8);
            bufferedInputStream2.read(bArr5);
            if (Utils.f52981j.m(bArr5)) {
                float f13 = -1.0f;
                Utils.Companion.BlendOp blendOp2 = Utils.Companion.BlendOp.APNG_BLEND_OP_SOURCE;
                Utils.Companion.DisposeOp disposeOp = Utils.Companion.DisposeOp.APNG_DISPOSE_OP_NONE;
                byte[] bArr6 = new byte[0];
                AnimationDrawable animationDrawable = new AnimationDrawable();
                animationDrawable.setOneShot(false);
                Unit unit = Unit.f56620a;
                int i18 = 4;
                byte[] bArr7 = new byte[4];
                int i19 = -1;
                int i21 = 0;
                boolean z11 = false;
                int i22 = 0;
                int i23 = -1;
                int i24 = -1;
                ArrayList arrayList = null;
                ArrayList arrayList2 = null;
                Bitmap bitmap5 = null;
                byte[] bArr8 = null;
                byte[] bArr9 = null;
                while (true) {
                    if (bufferedInputStream2.read(bArr7) == i19) {
                        Companion companion5 = companion4;
                        bufferedInputStream = bufferedInputStream2;
                        break;
                    }
                    Utils.Companion companion6 = Utils.f52981j;
                    ArrayList arrayList3 = new ArrayList(i18);
                    int i25 = 0;
                    while (i25 < i18) {
                        arrayList3.add(Integer.valueOf(bArr7[i25]));
                        i25++;
                        i18 = 4;
                    }
                    byte[] bArr10 = new byte[(companion6.n(arrayList3) + 8)];
                    int read = bufferedInputStream2.read(bArr10);
                    byte[] q11 = ArraysKt___ArraysJvmKt.q(bArr7, bArr10);
                    Utils.Companion companion7 = Utils.f52981j;
                    byte[] bArr11 = bArr7;
                    byte[] i26 = ArraysKt___ArraysJvmKt.i(q11, q11.length - 4, q11.length);
                    int i27 = read;
                    ArrayList arrayList4 = new ArrayList(i26.length);
                    bufferedInputStream = bufferedInputStream2;
                    int i28 = 0;
                    for (int length = i26.length; i28 < length; length = length) {
                        arrayList4.add(Integer.valueOf(i26[i28]));
                        i28++;
                    }
                    int n11 = companion7.n(arrayList4);
                    CRC32 crc32 = new CRC32();
                    crc32.update(ArraysKt___ArraysJvmKt.i(q11, 4, q11.length - 4));
                    if (n11 == ((int) crc32.getValue())) {
                        byte[] i29 = ArraysKt___ArraysJvmKt.i(q11, 4, 8);
                        Utils.Companion companion8 = Utils.f52981j;
                        if (!Arrays.equals(i29, companion8.d())) {
                            Companion companion9 = companion4;
                            ArrayList arrayList5 = arrayList;
                            int i30 = i22;
                            int i31 = i23;
                            i12 = i24;
                            if (Arrays.equals(i29, companion8.g())) {
                                if (!z11 || arrayList2 == null) {
                                    i11 = i31;
                                    byte[] bArr12 = bArr6;
                                    bitmap2 = bitmap5;
                                    blendOp = blendOp2;
                                    if (arrayList5 != null) {
                                        ArrayList arrayList6 = arrayList5;
                                        arrayList6.addAll(ApngDecoder.f52960a);
                                        CRC32 crc322 = new CRC32();
                                        crc322.update(companion8.g(), 0, companion8.g().length);
                                        arrayList6.addAll(ArraysKt___ArraysJvmKt.c(companion8.g()));
                                        arrayList6.addAll(ArraysKt___ArraysJvmKt.c(companion8.o((int) crc322.getValue())));
                                        bufferedInputStream.close();
                                        return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray(CollectionsKt___CollectionsKt.E0(arrayList6), 0, arrayList6.size()));
                                    }
                                    arrayList = arrayList5;
                                    companion2 = this;
                                    bArr = bArr12;
                                } else {
                                    arrayList2.addAll(ApngDecoder.f52960a);
                                    CRC32 crc323 = new CRC32();
                                    crc323.update(companion8.g(), 0, companion8.g().length);
                                    arrayList2.addAll(ArraysKt___ArraysJvmKt.c(companion8.g()));
                                    arrayList2.addAll(ArraysKt___ArraysJvmKt.c(companion8.o((int) crc323.getValue())));
                                    bitmap = Bitmap.createBitmap(i21, i30, Bitmap.Config.ARGB_8888);
                                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(CollectionsKt___CollectionsKt.E0(arrayList2), 0, arrayList2.size());
                                    Canvas canvas = new Canvas(bitmap);
                                    byte[] bArr13 = bArr6;
                                    bitmap2 = bitmap5;
                                    canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                                    if (blendOp2 == Utils.Companion.BlendOp.APNG_BLEND_OP_SOURCE) {
                                        float f14 = (float) i31;
                                        float f15 = (float) i12;
                                        blendOp = blendOp2;
                                        canvas.drawRect(f14, f15, f14 + ((float) decodeByteArray.getWidth()), f15 + ((float) decodeByteArray.getHeight()), f());
                                    } else {
                                        blendOp = blendOp2;
                                    }
                                    float f16 = (float) i31;
                                    float f17 = (float) i12;
                                    canvas.drawBitmap(decodeByteArray, f16, f17, (Paint) null);
                                    i11 = i31;
                                    animationDrawable.addFrame(new BitmapDrawable(context.getResources(), bitmap.getConfig() != config2 ? bitmap.copy(config2, bitmap.isMutable()) : bitmap), (int) (f13 / f11));
                                    int i32 = a.f52964b[disposeOp.ordinal()];
                                    if (i32 != 1) {
                                        if (i32 != 2) {
                                            companion = this;
                                        } else {
                                            Bitmap createBitmap = Bitmap.createBitmap(i21, i30, Bitmap.Config.ARGB_8888);
                                            Canvas canvas2 = new Canvas(createBitmap);
                                            canvas2.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                                            canvas2.drawRect(f16, f17, f16 + ((float) decodeByteArray.getWidth()), f17 + ((float) decodeByteArray.getHeight()), f());
                                            companion = this;
                                            bitmap = createBitmap;
                                        }
                                        i22 = i30;
                                        bArr6 = bArr13;
                                        i15 = i27;
                                        arrayList = arrayList5;
                                        c11 = 8;
                                        i13 = -1;
                                        f12 = f13;
                                        i14 = 4;
                                    } else {
                                        companion2 = this;
                                        bArr = bArr13;
                                        arrayList = arrayList5;
                                    }
                                }
                                c11 = 8;
                                f12 = f13;
                            } else {
                                i11 = i31;
                                byte[] bArr14 = bArr6;
                                bitmap2 = bitmap5;
                                arrayList = arrayList5;
                                blendOp = blendOp2;
                                if (!Arrays.equals(i29, companion8.f())) {
                                    companion2 = this;
                                    byte[] bArr15 = bArr14;
                                    f12 = f13;
                                    if (Arrays.equals(i29, companion8.e())) {
                                        byte[] i33 = ArraysKt___ArraysJvmKt.i(q11, 0, 4);
                                        ArrayList arrayList7 = new ArrayList(i33.length);
                                        int length2 = i33.length;
                                        int i34 = 0;
                                        while (i34 < length2) {
                                            arrayList7.add(Integer.valueOf(i33[i34]));
                                            i34++;
                                            bArr15 = bArr15;
                                        }
                                        bArr2 = bArr15;
                                        int n12 = companion8.n(arrayList7);
                                        if (arrayList2 != null) {
                                            arrayList2.addAll(ArraysKt___ArraysJvmKt.c(Utils.f52981j.o(n12 - 4)));
                                        }
                                        ArrayList arrayList8 = new ArrayList();
                                        Utils.Companion companion10 = Utils.f52981j;
                                        arrayList8.addAll(ArraysKt___ArraysJvmKt.c(companion10.f()));
                                        arrayList8.addAll(ArraysKt___ArraysJvmKt.c(ArraysKt___ArraysJvmKt.i(q11, 12, n12 + 8)));
                                        CRC32 crc324 = new CRC32();
                                        crc324.update(CollectionsKt___CollectionsKt.E0(arrayList8), 0, arrayList8.size());
                                        if (arrayList2 != null) {
                                            arrayList2.addAll(arrayList8);
                                        }
                                        if (arrayList2 != null) {
                                            arrayList2.addAll(ArraysKt___ArraysJvmKt.c(companion10.o((int) crc324.getValue())));
                                        }
                                    } else {
                                        bArr = bArr15;
                                        if (Arrays.equals(i29, companion8.i())) {
                                            bArr8 = q11;
                                        } else if (Arrays.equals(i29, companion8.k())) {
                                            bArr9 = q11;
                                        } else if (Arrays.equals(i29, companion8.h())) {
                                            byte[] i35 = ArraysKt___ArraysJvmKt.i(q11, 0, 4);
                                            ArrayList arrayList9 = new ArrayList(i35.length);
                                            for (byte valueOf : i35) {
                                                arrayList9.add(Integer.valueOf(valueOf));
                                            }
                                            int n13 = companion8.n(arrayList9);
                                            Utils.Companion companion11 = Utils.f52981j;
                                            byte[] i36 = ArraysKt___ArraysJvmKt.i(q11, 8, 12);
                                            ArrayList arrayList10 = new ArrayList(i36.length);
                                            for (byte valueOf2 : i36) {
                                                arrayList10.add(Integer.valueOf(valueOf2));
                                            }
                                            i21 = companion11.n(arrayList10);
                                            Utils.Companion companion12 = Utils.f52981j;
                                            byte[] i37 = ArraysKt___ArraysJvmKt.i(q11, 12, 16);
                                            ArrayList arrayList11 = new ArrayList(i37.length);
                                            for (byte valueOf3 : i37) {
                                                arrayList11.add(Integer.valueOf(valueOf3));
                                            }
                                            int n14 = companion12.n(arrayList11);
                                            i14 = 4;
                                            c11 = 8;
                                            i22 = n14;
                                            bArr6 = ArraysKt___ArraysJvmKt.i(q11, 8, 4 + n13 + 4);
                                            bitmap3 = Bitmap.createBitmap(i21, n14, Bitmap.Config.ARGB_8888);
                                            i15 = i27;
                                            i13 = -1;
                                        } else {
                                            c11 = 8;
                                            i14 = 4;
                                            if (Arrays.equals(i29, companion8.c())) {
                                                z11 = true;
                                            }
                                            bitmap3 = bitmap2;
                                            i22 = i30;
                                            i15 = i27;
                                            bArr6 = bArr;
                                            i13 = -1;
                                        }
                                        bitmap3 = bitmap2;
                                        i22 = i30;
                                        i15 = i27;
                                        bArr6 = bArr;
                                        c11 = 8;
                                        i14 = 4;
                                        i13 = -1;
                                    }
                                } else if (arrayList2 == null) {
                                    if (arrayList == null) {
                                        ArrayList arrayList12 = new ArrayList();
                                        arrayList12.addAll(ArraysKt___ArraysJvmKt.c(companion8.j()));
                                        companion3 = this;
                                        bArr3 = bArr14;
                                        arrayList12.addAll(ArraysKt___ArraysJvmKt.c(companion3.e(bArr3, i21, i30)));
                                        arrayList = arrayList12;
                                    } else {
                                        companion3 = this;
                                        bArr3 = bArr14;
                                    }
                                    byte[] i38 = ArraysKt___ArraysJvmKt.i(q11, 0, 4);
                                    ArrayList arrayList13 = new ArrayList(i38.length);
                                    int length3 = i38.length;
                                    f12 = f13;
                                    int i39 = 0;
                                    while (i39 < length3) {
                                        arrayList13.add(Integer.valueOf(i38[i39]));
                                        i39++;
                                        i38 = i38;
                                    }
                                    int n15 = companion8.n(arrayList13);
                                    arrayList.addAll(ArraysKt___ArraysJvmKt.c(ArraysKt___ArraysJvmKt.i(q11, 0, 4)));
                                    ArrayList arrayList14 = new ArrayList();
                                    Utils.Companion companion13 = Utils.f52981j;
                                    arrayList14.addAll(ArraysKt___ArraysJvmKt.c(companion13.f()));
                                    arrayList14.addAll(ArraysKt___ArraysJvmKt.c(ArraysKt___ArraysJvmKt.i(q11, 8, n15 + 8)));
                                    CRC32 crc325 = new CRC32();
                                    crc325.update(CollectionsKt___CollectionsKt.E0(arrayList14), 0, arrayList14.size());
                                    arrayList.addAll(arrayList14);
                                    arrayList.addAll(ArraysKt___ArraysJvmKt.c(companion13.o((int) crc325.getValue())));
                                    bitmap3 = bitmap2;
                                    i22 = i30;
                                    i15 = i27;
                                    c11 = 8;
                                    i14 = 4;
                                    bArr6 = bArr3;
                                    i13 = -1;
                                } else {
                                    companion2 = this;
                                    byte[] bArr16 = bArr14;
                                    f12 = f13;
                                    byte[] i40 = ArraysKt___ArraysJvmKt.i(q11, 0, 4);
                                    ArrayList arrayList15 = new ArrayList(i40.length);
                                    int length4 = i40.length;
                                    int i41 = 0;
                                    while (i41 < length4) {
                                        arrayList15.add(Integer.valueOf(i40[i41]));
                                        i41++;
                                        i40 = i40;
                                    }
                                    int n16 = companion8.n(arrayList15);
                                    arrayList2.addAll(ArraysKt___ArraysJvmKt.c(ArraysKt___ArraysJvmKt.i(q11, 0, 4)));
                                    ArrayList arrayList16 = new ArrayList();
                                    Utils.Companion companion14 = Utils.f52981j;
                                    arrayList16.addAll(ArraysKt___ArraysJvmKt.c(companion14.f()));
                                    arrayList16.addAll(ArraysKt___ArraysJvmKt.c(ArraysKt___ArraysJvmKt.i(q11, 8, n16 + 8)));
                                    CRC32 crc326 = new CRC32();
                                    crc326.update(CollectionsKt___CollectionsKt.E0(arrayList16), 0, arrayList16.size());
                                    arrayList2.addAll(arrayList16);
                                    arrayList2.addAll(ArraysKt___ArraysJvmKt.c(companion14.o((int) crc326.getValue())));
                                    bArr2 = bArr16;
                                }
                                c11 = 8;
                            }
                            i14 = 4;
                            bitmap3 = bitmap2;
                            i22 = i30;
                            i15 = i27;
                            bArr6 = bArr;
                            i13 = -1;
                        } else if (arrayList2 == null) {
                            if (arrayList != null) {
                                arrayList.addAll(ApngDecoder.f52960a);
                                CRC32 crc327 = new CRC32();
                                crc327.update(companion8.g(), 0, companion8.g().length);
                                arrayList.addAll(ArraysKt___ArraysJvmKt.c(companion8.g()));
                                arrayList.addAll(ArraysKt___ArraysJvmKt.c(companion8.o((int) crc327.getValue())));
                            }
                            arrayList2 = new ArrayList();
                            byte[] i42 = ArraysKt___ArraysJvmKt.i(q11, 12, 16);
                            ArrayList arrayList17 = new ArrayList(i42.length);
                            for (byte valueOf4 : i42) {
                                arrayList17.add(Integer.valueOf(valueOf4));
                            }
                            int n17 = companion8.n(arrayList17);
                            Utils.Companion companion15 = Utils.f52981j;
                            byte[] i43 = ArraysKt___ArraysJvmKt.i(q11, 16, 20);
                            ArrayList arrayList18 = new ArrayList(i43.length);
                            for (byte valueOf5 : i43) {
                                arrayList18.add(Integer.valueOf(valueOf5));
                            }
                            int n18 = companion15.n(arrayList18);
                            Utils.Companion companion16 = Utils.f52981j;
                            byte[] i44 = ArraysKt___ArraysJvmKt.i(q11, 28, 30);
                            ArrayList arrayList19 = new ArrayList(i44.length);
                            for (byte valueOf6 : i44) {
                                arrayList19.add(Integer.valueOf(valueOf6));
                            }
                            float p11 = (float) companion16.p(arrayList19);
                            Utils.Companion companion17 = Utils.f52981j;
                            byte[] i45 = ArraysKt___ArraysJvmKt.i(q11, 30, 32);
                            ArrayList arrayList20 = new ArrayList(i45.length);
                            int length5 = i45.length;
                            int i46 = 0;
                            while (i46 < length5) {
                                arrayList20.add(Integer.valueOf(i45[i46]));
                                i46++;
                                i45 = i45;
                            }
                            float p12 = (float) companion17.p(arrayList20);
                            float f18 = (p11 / (p12 == 0.0f ? 100.0f : p12)) * ((float) 1000);
                            Utils.Companion companion18 = Utils.f52981j;
                            byte[] i47 = ArraysKt___ArraysJvmKt.i(q11, 20, 24);
                            ArrayList arrayList21 = new ArrayList(i47.length);
                            int length6 = i47.length;
                            int i48 = 0;
                            while (i48 < length6) {
                                arrayList21.add(Integer.valueOf(i47[i48]));
                                i48++;
                                f18 = f18;
                            }
                            float f19 = f18;
                            int n19 = companion18.n(arrayList21);
                            Utils.Companion companion19 = Utils.f52981j;
                            byte[] i49 = ArraysKt___ArraysJvmKt.i(q11, 24, 28);
                            ArrayList arrayList22 = new ArrayList(i49.length);
                            for (byte valueOf7 : i49) {
                                arrayList22.add(Integer.valueOf(valueOf7));
                            }
                            int n21 = companion19.n(arrayList22);
                            Utils.Companion companion20 = Utils.f52981j;
                            Utils.Companion.BlendOp a11 = companion20.a(q11[33]);
                            Utils.Companion.DisposeOp b11 = companion20.b(q11[32]);
                            if (n19 + n17 <= i21) {
                                int i50 = i22;
                                if (n21 + n18 <= i50) {
                                    arrayList2.addAll(ArraysKt___ArraysJvmKt.c(companion20.j()));
                                    arrayList2.addAll(ArraysKt___ArraysJvmKt.c(companion4.e(bArr6, n17, n18)));
                                    if (bArr8 != null) {
                                        arrayList2.addAll(ArraysKt___ArraysJvmKt.c(bArr8));
                                    }
                                    if (bArr9 != null) {
                                        arrayList2.addAll(ArraysKt___ArraysJvmKt.c(bArr9));
                                    }
                                    disposeOp = b11;
                                    i12 = n21;
                                    i22 = i50;
                                    bitmap = bitmap5;
                                    i15 = i27;
                                    c11 = 8;
                                    i14 = 4;
                                    companion = companion4;
                                    blendOp = a11;
                                    i13 = -1;
                                    float f21 = f19;
                                    i11 = n19;
                                    f12 = f21;
                                } else {
                                    throw new BadApngException("`yOffset` + `height` must be <= `IHDR` height");
                                }
                            } else {
                                throw new BadApngException("`xOffset` + `width` must be <= `IHDR` width");
                            }
                        } else {
                            int i51 = i22;
                            arrayList2.addAll(ApngDecoder.f52960a);
                            CRC32 crc328 = new CRC32();
                            ArrayList arrayList23 = arrayList;
                            crc328.update(companion8.g(), 0, companion8.g().length);
                            arrayList2.addAll(ArraysKt___ArraysJvmKt.c(companion8.g()));
                            byte[] bArr17 = bArr6;
                            arrayList2.addAll(ArraysKt___ArraysJvmKt.c(companion8.o((int) crc328.getValue())));
                            Bitmap createBitmap2 = Bitmap.createBitmap(i21, i51, Bitmap.Config.ARGB_8888);
                            Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(CollectionsKt___CollectionsKt.E0(arrayList2), 0, arrayList2.size());
                            Canvas canvas3 = new Canvas(createBitmap2);
                            Bitmap bitmap6 = bitmap5;
                            canvas3.drawBitmap(bitmap6, 0.0f, 0.0f, (Paint) null);
                            if (blendOp2 == Utils.Companion.BlendOp.APNG_BLEND_OP_SOURCE) {
                                i17 = i23;
                                float f22 = (float) i17;
                                bitmap4 = bitmap6;
                                i16 = i24;
                                float f23 = (float) i16;
                                bArr4 = bArr17;
                                canvas3.drawRect(f22, f23, f22 + ((float) decodeByteArray2.getWidth()), f23 + ((float) decodeByteArray2.getHeight()), f());
                            } else {
                                bitmap4 = bitmap6;
                                i17 = i23;
                                i16 = i24;
                                bArr4 = bArr17;
                            }
                            float f24 = (float) i17;
                            float f25 = (float) i16;
                            canvas3.drawBitmap(decodeByteArray2, f24, f25, (Paint) null);
                            animationDrawable.addFrame(new BitmapDrawable(context.getResources(), createBitmap2.getConfig() != config2 ? createBitmap2.copy(config2, createBitmap2.isMutable()) : createBitmap2), (int) (f13 / f11));
                            int i52 = a.f52963a[disposeOp.ordinal()];
                            if (i52 != 1) {
                                if (i52 != 2) {
                                    bitmap4 = createBitmap2;
                                } else {
                                    Bitmap createBitmap3 = Bitmap.createBitmap(i21, i51, Bitmap.Config.ARGB_8888);
                                    Canvas canvas4 = new Canvas(createBitmap3);
                                    canvas4.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
                                    canvas4.drawRect(f24, f25, f24 + ((float) decodeByteArray2.getWidth()), f25 + ((float) decodeByteArray2.getHeight()), f());
                                    bitmap4 = createBitmap3;
                                }
                            }
                            arrayList2 = new ArrayList();
                            byte[] i53 = ArraysKt___ArraysJvmKt.i(q11, 12, 16);
                            ArrayList arrayList24 = new ArrayList(i53.length);
                            for (byte valueOf8 : i53) {
                                arrayList24.add(Integer.valueOf(valueOf8));
                            }
                            int n22 = companion8.n(arrayList24);
                            Utils.Companion companion21 = Utils.f52981j;
                            byte[] i54 = ArraysKt___ArraysJvmKt.i(q11, 16, 20);
                            ArrayList arrayList25 = new ArrayList(i54.length);
                            for (byte valueOf9 : i54) {
                                arrayList25.add(Integer.valueOf(valueOf9));
                            }
                            int n23 = companion21.n(arrayList25);
                            Utils.Companion companion22 = Utils.f52981j;
                            byte[] i55 = ArraysKt___ArraysJvmKt.i(q11, 28, 30);
                            ArrayList arrayList26 = new ArrayList(i55.length);
                            for (byte valueOf10 : i55) {
                                arrayList26.add(Integer.valueOf(valueOf10));
                            }
                            float p13 = (float) companion22.p(arrayList26);
                            Utils.Companion companion23 = Utils.f52981j;
                            byte[] i56 = ArraysKt___ArraysJvmKt.i(q11, 30, 32);
                            ArrayList arrayList27 = new ArrayList(i56.length);
                            for (byte valueOf11 : i56) {
                                arrayList27.add(Integer.valueOf(valueOf11));
                            }
                            float p14 = (float) companion23.p(arrayList27);
                            float f26 = (p13 / (p14 == 0.0f ? 100.0f : p14)) * ((float) 1000);
                            Utils.Companion companion24 = Utils.f52981j;
                            byte[] i57 = ArraysKt___ArraysJvmKt.i(q11, 20, 24);
                            ArrayList arrayList28 = new ArrayList(i57.length);
                            for (byte valueOf12 : i57) {
                                arrayList28.add(Integer.valueOf(valueOf12));
                            }
                            int n24 = companion24.n(arrayList28);
                            Utils.Companion companion25 = Utils.f52981j;
                            byte[] i58 = ArraysKt___ArraysJvmKt.i(q11, 24, 28);
                            ArrayList arrayList29 = new ArrayList(i58.length);
                            for (byte valueOf13 : i58) {
                                arrayList29.add(Integer.valueOf(valueOf13));
                            }
                            int n25 = companion25.n(arrayList29);
                            Utils.Companion companion26 = Utils.f52981j;
                            Utils.Companion.BlendOp a12 = companion26.a(q11[33]);
                            Utils.Companion.DisposeOp b12 = companion26.b(q11[32]);
                            arrayList2.addAll(ArraysKt___ArraysJvmKt.c(companion26.j()));
                            bArr6 = bArr4;
                            arrayList2.addAll(ArraysKt___ArraysJvmKt.c(e(bArr6, n22, n23)));
                            if (bArr8 != null) {
                                arrayList2.addAll(ArraysKt___ArraysJvmKt.c(bArr8));
                            }
                            if (bArr9 != null) {
                                arrayList2.addAll(ArraysKt___ArraysJvmKt.c(bArr9));
                            }
                            f12 = f26;
                            companion = this;
                            i22 = i51;
                            bitmap = bitmap4;
                            i12 = n25;
                            c11 = 8;
                            i14 = 4;
                            i13 = -1;
                            i11 = n24;
                            blendOp = a12;
                            arrayList = arrayList23;
                            disposeOp = b12;
                            i15 = i27;
                        }
                        if (i15 == i13) {
                            break;
                        }
                        char c12 = c11;
                        i18 = i14;
                        companion4 = companion;
                        blendOp2 = blendOp;
                        f13 = f12;
                        i23 = i11;
                        bArr7 = bArr11;
                        config2 = config;
                        bitmap5 = bitmap;
                        i24 = i12;
                        bufferedInputStream2 = bufferedInputStream;
                        i19 = i13;
                    } else {
                        Companion companion27 = companion4;
                        throw new BadCRCException();
                    }
                }
                bufferedInputStream.close();
                return animationDrawable;
            }
            Companion companion28 = companion4;
            BufferedInputStream bufferedInputStream3 = bufferedInputStream2;
            bufferedInputStream3.reset();
            if (Build.VERSION.SDK_INT >= 28) {
                byte[] c13 = kotlin.io.a.c(bufferedInputStream3);
                bufferedInputStream3.close();
                return ImageDecoder.decodeDrawable(ImageDecoder.createSource(ByteBuffer.wrap(c13)));
            }
            BufferedInputStream bufferedInputStream4 = bufferedInputStream3;
            Drawable createFromStream = Drawable.createFromStream(bufferedInputStream4, (String) null);
            bufferedInputStream4.close();
            return createFromStream;
        }

        public final void b(Context context, Uri uri, ImageView imageView, float f11, a aVar, Bitmap.Config config) {
            Uri uri2 = uri;
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            n1 unused = kotlinx.coroutines.i.d(g1.f57277b, v0.b(), (CoroutineStart) null, new ApngDecoder$Companion$decodeApngAsyncInto$2(context, openInputStream, f11, config, imageView, aVar, (c) null), 2, (Object) null);
        }

        public final void c(Context context, URL url, ImageView imageView, float f11, a aVar, Bitmap.Config config) {
            n1 unused = kotlinx.coroutines.i.d(g1.f57277b, v0.b(), (CoroutineStart) null, new ApngDecoder$Companion$decodeApngAsyncInto$4(context, url, f11, config, imageView, aVar, (c) null), 2, (Object) null);
        }

        public final byte[] e(byte[] bArr, int i11, int i12) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Utils.Companion companion = Utils.f52981j;
            arrayList.addAll(ArraysKt___ArraysJvmKt.c(companion.o(bArr.length)));
            boolean unused = CollectionsKt__MutableCollectionsKt.B(arrayList2, new Byte[]{Byte.valueOf((byte) 73), Byte.valueOf((byte) 72), Byte.valueOf((byte) 68), Byte.valueOf((byte) 82)});
            arrayList2.addAll(ArraysKt___ArraysJvmKt.c(companion.o(i11)));
            arrayList2.addAll(ArraysKt___ArraysJvmKt.c(companion.o(i12)));
            arrayList2.addAll(ArraysKt___ArraysJvmKt.c(ArraysKt___ArraysJvmKt.i(bArr, 8, 13)));
            CRC32 crc32 = new CRC32();
            crc32.update(CollectionsKt___CollectionsKt.E0(arrayList2), 0, arrayList2.size());
            arrayList.addAll(arrayList2);
            arrayList.addAll(ArraysKt___ArraysJvmKt.c(companion.o((int) crc32.getValue())));
            return CollectionsKt___CollectionsKt.E0(arrayList);
        }

        public final Paint f() {
            i a11 = ApngDecoder.f52961b;
            Companion companion = ApngDecoder.f52962c;
            return (Paint) a11.getValue();
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0014\u0010\t\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H&¨\u0006\n"}, d2 = {"Loupson/apng/decoder/ApngDecoder$a;", "", "Landroid/graphics/drawable/Drawable;", "drawable", "", "a", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "onError", "apng_library_release"}, k = 1, mv = {1, 4, 2})
    public interface a {
        void a(Drawable drawable);

        void onError(Exception exc);
    }

    static {
        Integer[] numArr = {0, 0, 0, 0};
        ArrayList arrayList = new ArrayList(4);
        for (int i11 = 0; i11 < 4; i11++) {
            arrayList.add(Byte.valueOf((byte) numArr[i11].intValue()));
        }
        f52960a = arrayList;
    }

    public static final void c(Context context, URL url, ImageView imageView) {
        Companion.d(f52962c, context, url, imageView, 0.0f, (a) null, (Bitmap.Config) null, 56, (Object) null);
    }
}
