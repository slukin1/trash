package com.google.android.exoplayer2.text.dvb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.math.DoubleMath;
import com.huobi.view.roundimg.RoundedDrawable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.sf.scuba.smartcards.ISO7816;

final class DvbParser {
    private static final int DATA_TYPE_24_TABLE_DATA = 32;
    private static final int DATA_TYPE_28_TABLE_DATA = 33;
    private static final int DATA_TYPE_2BP_CODE_STRING = 16;
    private static final int DATA_TYPE_48_TABLE_DATA = 34;
    private static final int DATA_TYPE_4BP_CODE_STRING = 17;
    private static final int DATA_TYPE_8BP_CODE_STRING = 18;
    private static final int DATA_TYPE_END_LINE = 240;
    private static final int OBJECT_CODING_PIXELS = 0;
    private static final int OBJECT_CODING_STRING = 1;
    private static final int PAGE_STATE_NORMAL = 0;
    private static final int REGION_DEPTH_4_BIT = 2;
    private static final int REGION_DEPTH_8_BIT = 3;
    private static final int SEGMENT_TYPE_CLUT_DEFINITION = 18;
    private static final int SEGMENT_TYPE_DISPLAY_DEFINITION = 20;
    private static final int SEGMENT_TYPE_OBJECT_DATA = 19;
    private static final int SEGMENT_TYPE_PAGE_COMPOSITION = 16;
    private static final int SEGMENT_TYPE_REGION_COMPOSITION = 17;
    private static final String TAG = "DvbParser";
    private static final byte[] defaultMap2To4 = {0, 7, 8, 15};
    private static final byte[] defaultMap2To8 = {0, 119, -120, -1};
    private static final byte[] defaultMap4To8 = {0, 17, ISO7816.INS_MSE, 51, ISO7816.INS_REHABILITATE_CHV, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private Bitmap bitmap;
    private final Canvas canvas = new Canvas();
    private final ClutDefinition defaultClutDefinition = new ClutDefinition(0, generateDefault2BitClutEntries(), generateDefault4BitClutEntries(), generateDefault8BitClutEntries());
    private final DisplayDefinition defaultDisplayDefinition = new DisplayDefinition(719, 575, 0, 719, 0, 575);
    private final Paint defaultPaint;
    private final Paint fillRegionPaint;
    private final SubtitleService subtitleService;

    public static final class ClutDefinition {
        public final int[] clutEntries2Bit;
        public final int[] clutEntries4Bit;
        public final int[] clutEntries8Bit;

        /* renamed from: id  reason: collision with root package name */
        public final int f66060id;

        public ClutDefinition(int i11, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f66060id = i11;
            this.clutEntries2Bit = iArr;
            this.clutEntries4Bit = iArr2;
            this.clutEntries8Bit = iArr3;
        }
    }

    public static final class DisplayDefinition {
        public final int height;
        public final int horizontalPositionMaximum;
        public final int horizontalPositionMinimum;
        public final int verticalPositionMaximum;
        public final int verticalPositionMinimum;
        public final int width;

        public DisplayDefinition(int i11, int i12, int i13, int i14, int i15, int i16) {
            this.width = i11;
            this.height = i12;
            this.horizontalPositionMinimum = i13;
            this.horizontalPositionMaximum = i14;
            this.verticalPositionMinimum = i15;
            this.verticalPositionMaximum = i16;
        }
    }

    public static final class ObjectData {
        public final byte[] bottomFieldData;

        /* renamed from: id  reason: collision with root package name */
        public final int f66061id;
        public final boolean nonModifyingColorFlag;
        public final byte[] topFieldData;

        public ObjectData(int i11, boolean z11, byte[] bArr, byte[] bArr2) {
            this.f66061id = i11;
            this.nonModifyingColorFlag = z11;
            this.topFieldData = bArr;
            this.bottomFieldData = bArr2;
        }
    }

    public static final class PageComposition {
        public final SparseArray<PageRegion> regions;
        public final int state;
        public final int timeOutSecs;
        public final int version;

        public PageComposition(int i11, int i12, int i13, SparseArray<PageRegion> sparseArray) {
            this.timeOutSecs = i11;
            this.version = i12;
            this.state = i13;
            this.regions = sparseArray;
        }
    }

    public static final class PageRegion {
        public final int horizontalAddress;
        public final int verticalAddress;

        public PageRegion(int i11, int i12) {
            this.horizontalAddress = i11;
            this.verticalAddress = i12;
        }
    }

    public static final class RegionComposition {
        public final int clutId;
        public final int depth;
        public final boolean fillFlag;
        public final int height;

        /* renamed from: id  reason: collision with root package name */
        public final int f66062id;
        public final int levelOfCompatibility;
        public final int pixelCode2Bit;
        public final int pixelCode4Bit;
        public final int pixelCode8Bit;
        public final SparseArray<RegionObject> regionObjects;
        public final int width;

        public RegionComposition(int i11, boolean z11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, SparseArray<RegionObject> sparseArray) {
            this.f66062id = i11;
            this.fillFlag = z11;
            this.width = i12;
            this.height = i13;
            this.levelOfCompatibility = i14;
            this.depth = i15;
            this.clutId = i16;
            this.pixelCode8Bit = i17;
            this.pixelCode4Bit = i18;
            this.pixelCode2Bit = i19;
            this.regionObjects = sparseArray;
        }

        public void mergeFrom(RegionComposition regionComposition) {
            SparseArray<RegionObject> sparseArray = regionComposition.regionObjects;
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                this.regionObjects.put(sparseArray.keyAt(i11), sparseArray.valueAt(i11));
            }
        }
    }

    public static final class RegionObject {
        public final int backgroundPixelCode;
        public final int foregroundPixelCode;
        public final int horizontalPosition;
        public final int provider;
        public final int type;
        public final int verticalPosition;

        public RegionObject(int i11, int i12, int i13, int i14, int i15, int i16) {
            this.type = i11;
            this.provider = i12;
            this.horizontalPosition = i13;
            this.verticalPosition = i14;
            this.foregroundPixelCode = i15;
            this.backgroundPixelCode = i16;
        }
    }

    public static final class SubtitleService {
        public final SparseArray<ClutDefinition> ancillaryCluts = new SparseArray<>();
        public final SparseArray<ObjectData> ancillaryObjects = new SparseArray<>();
        public final int ancillaryPageId;
        public final SparseArray<ClutDefinition> cluts = new SparseArray<>();
        public DisplayDefinition displayDefinition;
        public final SparseArray<ObjectData> objects = new SparseArray<>();
        public PageComposition pageComposition;
        public final SparseArray<RegionComposition> regions = new SparseArray<>();
        public final int subtitlePageId;

        public SubtitleService(int i11, int i12) {
            this.subtitlePageId = i11;
            this.ancillaryPageId = i12;
        }

        public void reset() {
            this.regions.clear();
            this.cluts.clear();
            this.objects.clear();
            this.ancillaryCluts.clear();
            this.ancillaryObjects.clear();
            this.displayDefinition = null;
            this.pageComposition = null;
        }
    }

    public DvbParser(int i11, int i12) {
        Paint paint = new Paint();
        this.defaultPaint = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect((PathEffect) null);
        Paint paint2 = new Paint();
        this.fillRegionPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect((PathEffect) null);
        this.subtitleService = new SubtitleService(i11, i12);
    }

    private static byte[] buildClutMapTable(int i11, int i12, ParsableBitArray parsableBitArray) {
        byte[] bArr = new byte[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            bArr[i13] = (byte) parsableBitArray.readBits(i12);
        }
        return bArr;
    }

    private static int[] generateDefault2BitClutEntries() {
        return new int[]{0, -1, RoundedDrawable.DEFAULT_BORDER_COLOR, -8421505};
    }

    private static int[] generateDefault4BitClutEntries() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i11 = 1; i11 < 16; i11++) {
            if (i11 < 8) {
                iArr[i11] = getColor(255, (i11 & 1) != 0 ? 255 : 0, (i11 & 2) != 0 ? 255 : 0, (i11 & 4) != 0 ? 255 : 0);
            } else {
                int i12 = 127;
                int i13 = (i11 & 1) != 0 ? 127 : 0;
                int i14 = (i11 & 2) != 0 ? 127 : 0;
                if ((i11 & 4) == 0) {
                    i12 = 0;
                }
                iArr[i11] = getColor(255, i13, i14, i12);
            }
        }
        return iArr;
    }

    private static int[] generateDefault8BitClutEntries() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i11 = 0; i11 < 256; i11++) {
            int i12 = 255;
            if (i11 < 8) {
                int i13 = (i11 & 1) != 0 ? 255 : 0;
                int i14 = (i11 & 2) != 0 ? 255 : 0;
                if ((i11 & 4) == 0) {
                    i12 = 0;
                }
                iArr[i11] = getColor(63, i13, i14, i12);
            } else {
                int i15 = i11 & 136;
                int i16 = DoubleMath.MAX_FACTORIAL;
                int i17 = 85;
                if (i15 == 0) {
                    int i18 = ((i11 & 1) != 0 ? 85 : 0) + ((i11 & 16) != 0 ? 170 : 0);
                    int i19 = ((i11 & 2) != 0 ? 85 : 0) + ((i11 & 32) != 0 ? 170 : 0);
                    if ((i11 & 4) == 0) {
                        i17 = 0;
                    }
                    if ((i11 & 64) == 0) {
                        i16 = 0;
                    }
                    iArr[i11] = getColor(255, i18, i19, i17 + i16);
                } else if (i15 != 8) {
                    int i21 = 43;
                    if (i15 == 128) {
                        int i22 = ((i11 & 1) != 0 ? 43 : 0) + 127 + ((i11 & 16) != 0 ? 85 : 0);
                        int i23 = ((i11 & 2) != 0 ? 43 : 0) + 127 + ((i11 & 32) != 0 ? 85 : 0);
                        if ((i11 & 4) == 0) {
                            i21 = 0;
                        }
                        int i24 = i21 + 127;
                        if ((i11 & 64) == 0) {
                            i17 = 0;
                        }
                        iArr[i11] = getColor(255, i22, i23, i24 + i17);
                    } else if (i15 == 136) {
                        int i25 = ((i11 & 1) != 0 ? 43 : 0) + ((i11 & 16) != 0 ? 85 : 0);
                        int i26 = ((i11 & 2) != 0 ? 43 : 0) + ((i11 & 32) != 0 ? 85 : 0);
                        if ((i11 & 4) == 0) {
                            i21 = 0;
                        }
                        if ((i11 & 64) == 0) {
                            i17 = 0;
                        }
                        iArr[i11] = getColor(255, i25, i26, i21 + i17);
                    }
                } else {
                    int i27 = ((i11 & 1) != 0 ? 85 : 0) + ((i11 & 16) != 0 ? 170 : 0);
                    int i28 = ((i11 & 2) != 0 ? 85 : 0) + ((i11 & 32) != 0 ? 170 : 0);
                    if ((i11 & 4) == 0) {
                        i17 = 0;
                    }
                    if ((i11 & 64) == 0) {
                        i16 = 0;
                    }
                    iArr[i11] = getColor(127, i27, i28, i17 + i16);
                }
            }
        }
        return iArr;
    }

    private static int getColor(int i11, int i12, int i13, int i14) {
        return (i11 << 24) | (i12 << 16) | (i13 << 8) | i14;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int paint2BitPixelCodeString(com.google.android.exoplayer2.util.ParsableBitArray r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = r9
        L_0x0009:
            r3 = 2
            int r4 = r13.readBits(r3)
            r5 = 1
            if (r4 == 0) goto L_0x0014
            r11 = r2
            r12 = r5
            goto L_0x0060
        L_0x0014:
            boolean r4 = r13.readBit()
            r6 = 3
            if (r4 == 0) goto L_0x0028
            int r4 = r13.readBits(r6)
            int r4 = r4 + r6
            int r3 = r13.readBits(r3)
        L_0x0024:
            r11 = r2
            r12 = r4
            r4 = r3
            goto L_0x0060
        L_0x0028:
            boolean r4 = r13.readBit()
            if (r4 == 0) goto L_0x0032
            r11 = r2
            r12 = r5
        L_0x0030:
            r4 = r9
            goto L_0x0060
        L_0x0032:
            int r4 = r13.readBits(r3)
            if (r4 == 0) goto L_0x005e
            if (r4 == r5) goto L_0x005b
            if (r4 == r3) goto L_0x004f
            if (r4 == r6) goto L_0x0042
            r11 = r2
        L_0x003f:
            r4 = r9
            r12 = r4
            goto L_0x0060
        L_0x0042:
            r4 = 8
            int r4 = r13.readBits(r4)
            int r4 = r4 + 29
            int r3 = r13.readBits(r3)
            goto L_0x0024
        L_0x004f:
            r4 = 4
            int r4 = r13.readBits(r4)
            int r4 = r4 + 12
            int r3 = r13.readBits(r3)
            goto L_0x0024
        L_0x005b:
            r11 = r2
            r12 = r3
            goto L_0x0030
        L_0x005e:
            r11 = r5
            goto L_0x003f
        L_0x0060:
            if (r12 == 0) goto L_0x007e
            if (r8 == 0) goto L_0x007e
            if (r15 == 0) goto L_0x0068
            byte r4 = r15[r4]
        L_0x0068:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x007e:
            int r10 = r10 + r12
            if (r11 == 0) goto L_0x0082
            return r10
        L_0x0082:
            r2 = r11
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.dvb.DvbParser.paint2BitPixelCodeString(com.google.android.exoplayer2.util.ParsableBitArray, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int paint4BitPixelCodeString(com.google.android.exoplayer2.util.ParsableBitArray r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = r9
        L_0x0009:
            r3 = 4
            int r4 = r13.readBits(r3)
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x0016
            r11 = r2
            r12 = r6
            goto L_0x0069
        L_0x0016:
            boolean r4 = r13.readBit()
            r7 = 3
            if (r4 != 0) goto L_0x002b
            int r3 = r13.readBits(r7)
            if (r3 == 0) goto L_0x0029
            int r5 = r3 + 2
        L_0x0025:
            r11 = r2
            r12 = r5
        L_0x0027:
            r4 = r9
            goto L_0x0069
        L_0x0029:
            r11 = r6
            goto L_0x004b
        L_0x002b:
            boolean r4 = r13.readBit()
            if (r4 != 0) goto L_0x003e
            int r4 = r13.readBits(r5)
            int r5 = r4 + 4
            int r4 = r13.readBits(r3)
        L_0x003b:
            r11 = r2
            r12 = r5
            goto L_0x0069
        L_0x003e:
            int r4 = r13.readBits(r5)
            if (r4 == 0) goto L_0x0066
            if (r4 == r6) goto L_0x0025
            if (r4 == r5) goto L_0x005b
            if (r4 == r7) goto L_0x004e
            r11 = r2
        L_0x004b:
            r4 = r9
            r12 = r4
            goto L_0x0069
        L_0x004e:
            r4 = 8
            int r4 = r13.readBits(r4)
            int r5 = r4 + 25
            int r4 = r13.readBits(r3)
            goto L_0x003b
        L_0x005b:
            int r4 = r13.readBits(r3)
            int r5 = r4 + 9
            int r4 = r13.readBits(r3)
            goto L_0x003b
        L_0x0066:
            r11 = r2
            r12 = r6
            goto L_0x0027
        L_0x0069:
            if (r12 == 0) goto L_0x0085
            if (r8 == 0) goto L_0x0085
            if (r15 == 0) goto L_0x0071
            byte r4 = r15[r4]
        L_0x0071:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r5 = (float) r2
            int r2 = r1 + 1
            float r6 = (float) r2
            r2 = r19
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x0085:
            int r10 = r10 + r12
            if (r11 == 0) goto L_0x0089
            return r10
        L_0x0089:
            r2 = r11
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.dvb.DvbParser.paint4BitPixelCodeString(com.google.android.exoplayer2.util.ParsableBitArray, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int paint8BitPixelCodeString(com.google.android.exoplayer2.util.ParsableBitArray r13, int[] r14, byte[] r15, int r16, int r17, android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = r9
        L_0x0009:
            r3 = 8
            int r4 = r13.readBits(r3)
            r5 = 1
            if (r4 == 0) goto L_0x0015
            r11 = r2
            r12 = r5
            goto L_0x0035
        L_0x0015:
            boolean r4 = r13.readBit()
            r6 = 7
            if (r4 != 0) goto L_0x002a
            int r3 = r13.readBits(r6)
            if (r3 == 0) goto L_0x0026
            r11 = r2
            r12 = r3
            r4 = r9
            goto L_0x0035
        L_0x0026:
            r11 = r5
            r4 = r9
            r12 = r4
            goto L_0x0035
        L_0x002a:
            int r4 = r13.readBits(r6)
            int r3 = r13.readBits(r3)
            r11 = r2
            r12 = r4
            r4 = r3
        L_0x0035:
            if (r12 == 0) goto L_0x0053
            if (r8 == 0) goto L_0x0053
            if (r15 == 0) goto L_0x003d
            byte r4 = r15[r4]
        L_0x003d:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x0053:
            int r10 = r10 + r12
            if (r11 == 0) goto L_0x0057
            return r10
        L_0x0057:
            r2 = r11
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.dvb.DvbParser.paint8BitPixelCodeString(com.google.android.exoplayer2.util.ParsableBitArray, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    private static void paintPixelDataSubBlock(byte[] bArr, int[] iArr, int i11, int i12, int i13, Paint paint, Canvas canvas2) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        int i14 = i11;
        byte[] bArr5 = bArr;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        int i15 = i12;
        int i16 = i13;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        byte[] bArr8 = null;
        while (parsableBitArray.bitsLeft() != 0) {
            int readBits = parsableBitArray.readBits(8);
            if (readBits != 240) {
                switch (readBits) {
                    case 16:
                        if (i14 != 3) {
                            if (i14 != 2) {
                                bArr2 = null;
                                i15 = paint2BitPixelCodeString(parsableBitArray, iArr, bArr2, i15, i16, paint, canvas2);
                                parsableBitArray.byteAlign();
                                break;
                            } else {
                                bArr3 = bArr8 == null ? defaultMap2To4 : bArr8;
                            }
                        } else {
                            bArr3 = bArr6 == null ? defaultMap2To8 : bArr6;
                        }
                        bArr2 = bArr3;
                        i15 = paint2BitPixelCodeString(parsableBitArray, iArr, bArr2, i15, i16, paint, canvas2);
                        parsableBitArray.byteAlign();
                    case 17:
                        if (i14 == 3) {
                            bArr4 = bArr7 == null ? defaultMap4To8 : bArr7;
                        } else {
                            bArr4 = null;
                        }
                        i15 = paint4BitPixelCodeString(parsableBitArray, iArr, bArr4, i15, i16, paint, canvas2);
                        parsableBitArray.byteAlign();
                        break;
                    case 18:
                        i15 = paint8BitPixelCodeString(parsableBitArray, iArr, (byte[]) null, i15, i16, paint, canvas2);
                        break;
                    default:
                        switch (readBits) {
                            case 32:
                                bArr8 = buildClutMapTable(4, 4, parsableBitArray);
                                break;
                            case 33:
                                bArr6 = buildClutMapTable(4, 8, parsableBitArray);
                                break;
                            case 34:
                                bArr7 = buildClutMapTable(16, 8, parsableBitArray);
                                break;
                        }
                }
            } else {
                i16 += 2;
                i15 = i12;
            }
        }
    }

    private static void paintPixelDataSubBlocks(ObjectData objectData, ClutDefinition clutDefinition, int i11, int i12, int i13, Paint paint, Canvas canvas2) {
        int[] iArr;
        if (i11 == 3) {
            iArr = clutDefinition.clutEntries8Bit;
        } else if (i11 == 2) {
            iArr = clutDefinition.clutEntries4Bit;
        } else {
            iArr = clutDefinition.clutEntries2Bit;
        }
        int[] iArr2 = iArr;
        int i14 = i11;
        int i15 = i12;
        Paint paint2 = paint;
        Canvas canvas3 = canvas2;
        paintPixelDataSubBlock(objectData.topFieldData, iArr2, i14, i15, i13, paint2, canvas3);
        paintPixelDataSubBlock(objectData.bottomFieldData, iArr2, i14, i15, i13 + 1, paint2, canvas3);
    }

    private static ClutDefinition parseClutDefinition(ParsableBitArray parsableBitArray, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int i17 = 8;
        int readBits = parsableBitArray2.readBits(8);
        parsableBitArray2.skipBits(8);
        int i18 = 2;
        int i19 = i11 - 2;
        int[] generateDefault2BitClutEntries = generateDefault2BitClutEntries();
        int[] generateDefault4BitClutEntries = generateDefault4BitClutEntries();
        int[] generateDefault8BitClutEntries = generateDefault8BitClutEntries();
        while (i19 > 0) {
            int readBits2 = parsableBitArray2.readBits(i17);
            int readBits3 = parsableBitArray2.readBits(i17);
            int i21 = i19 - 2;
            int[] iArr = (readBits3 & 128) != 0 ? generateDefault2BitClutEntries : (readBits3 & 64) != 0 ? generateDefault4BitClutEntries : generateDefault8BitClutEntries;
            if ((readBits3 & 1) != 0) {
                i15 = parsableBitArray2.readBits(i17);
                i14 = parsableBitArray2.readBits(i17);
                i13 = parsableBitArray2.readBits(i17);
                i12 = parsableBitArray2.readBits(i17);
                i16 = i21 - 4;
            } else {
                i13 = parsableBitArray2.readBits(4) << 4;
                i16 = i21 - 2;
                int readBits4 = parsableBitArray2.readBits(4) << 4;
                i12 = parsableBitArray2.readBits(i18) << 6;
                i15 = parsableBitArray2.readBits(6) << i18;
                i14 = readBits4;
            }
            if (i15 == 0) {
                i12 = 255;
                i14 = 0;
                i13 = 0;
            }
            double d11 = (double) i15;
            double d12 = (double) (i14 - 128);
            double d13 = (double) (i13 - 128);
            iArr[readBits2] = getColor((byte) (255 - (i12 & 255)), Util.constrainValue((int) (d11 + (1.402d * d12)), 0, 255), Util.constrainValue((int) ((d11 - (0.34414d * d13)) - (d12 * 0.71414d)), 0, 255), Util.constrainValue((int) (d11 + (d13 * 1.772d)), 0, 255));
            i19 = i16;
            readBits = readBits;
            i17 = 8;
            i18 = 2;
        }
        return new ClutDefinition(readBits, generateDefault2BitClutEntries, generateDefault4BitClutEntries, generateDefault8BitClutEntries);
    }

    private static DisplayDefinition parseDisplayDefinition(ParsableBitArray parsableBitArray) {
        int i11;
        int i12;
        int i13;
        int i14;
        parsableBitArray.skipBits(4);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(3);
        int readBits = parsableBitArray.readBits(16);
        int readBits2 = parsableBitArray.readBits(16);
        if (readBit) {
            int readBits3 = parsableBitArray.readBits(16);
            int readBits4 = parsableBitArray.readBits(16);
            int readBits5 = parsableBitArray.readBits(16);
            i11 = parsableBitArray.readBits(16);
            i13 = readBits4;
            i12 = readBits5;
            i14 = readBits3;
        } else {
            i14 = 0;
            i12 = 0;
            i13 = readBits;
            i11 = readBits2;
        }
        return new DisplayDefinition(readBits, readBits2, i14, i13, i12, i11);
    }

    private static ObjectData parseObjectData(ParsableBitArray parsableBitArray) {
        byte[] bArr;
        int readBits = parsableBitArray.readBits(16);
        parsableBitArray.skipBits(4);
        int readBits2 = parsableBitArray.readBits(2);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(1);
        byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
        if (readBits2 == 1) {
            parsableBitArray.skipBits(parsableBitArray.readBits(8) * 16);
        } else if (readBits2 == 0) {
            int readBits3 = parsableBitArray.readBits(16);
            int readBits4 = parsableBitArray.readBits(16);
            if (readBits3 > 0) {
                bArr2 = new byte[readBits3];
                parsableBitArray.readBytes(bArr2, 0, readBits3);
            }
            if (readBits4 > 0) {
                bArr = new byte[readBits4];
                parsableBitArray.readBytes(bArr, 0, readBits4);
                return new ObjectData(readBits, readBit, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new ObjectData(readBits, readBit, bArr2, bArr);
    }

    private static PageComposition parsePageComposition(ParsableBitArray parsableBitArray, int i11) {
        int readBits = parsableBitArray.readBits(8);
        int readBits2 = parsableBitArray.readBits(4);
        int readBits3 = parsableBitArray.readBits(2);
        parsableBitArray.skipBits(2);
        int i12 = i11 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i12 > 0) {
            int readBits4 = parsableBitArray.readBits(8);
            parsableBitArray.skipBits(8);
            i12 -= 6;
            sparseArray.put(readBits4, new PageRegion(parsableBitArray.readBits(16), parsableBitArray.readBits(16)));
        }
        return new PageComposition(readBits, readBits2, readBits3, sparseArray);
    }

    private static RegionComposition parseRegionComposition(ParsableBitArray parsableBitArray, int i11) {
        int i12;
        int i13;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int readBits = parsableBitArray2.readBits(8);
        parsableBitArray2.skipBits(4);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray2.skipBits(3);
        int i14 = 16;
        int readBits2 = parsableBitArray2.readBits(16);
        int readBits3 = parsableBitArray2.readBits(16);
        int readBits4 = parsableBitArray2.readBits(3);
        int readBits5 = parsableBitArray2.readBits(3);
        int i15 = 2;
        parsableBitArray2.skipBits(2);
        int readBits6 = parsableBitArray2.readBits(8);
        int readBits7 = parsableBitArray2.readBits(8);
        int readBits8 = parsableBitArray2.readBits(4);
        int readBits9 = parsableBitArray2.readBits(2);
        parsableBitArray2.skipBits(2);
        int i16 = i11 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i16 > 0) {
            int readBits10 = parsableBitArray2.readBits(i14);
            int readBits11 = parsableBitArray2.readBits(i15);
            int readBits12 = parsableBitArray2.readBits(i15);
            int readBits13 = parsableBitArray2.readBits(12);
            int i17 = readBits9;
            parsableBitArray2.skipBits(4);
            int readBits14 = parsableBitArray2.readBits(12);
            i16 -= 6;
            if (readBits11 == 1 || readBits11 == 2) {
                i16 -= 2;
                i13 = parsableBitArray2.readBits(8);
                i12 = parsableBitArray2.readBits(8);
            } else {
                i13 = 0;
                i12 = 0;
            }
            sparseArray.put(readBits10, new RegionObject(readBits11, readBits12, readBits13, readBits14, i13, i12));
            readBits9 = i17;
            i15 = 2;
            i14 = 16;
        }
        return new RegionComposition(readBits, readBit, readBits2, readBits3, readBits4, readBits5, readBits6, readBits7, readBits8, readBits9, sparseArray);
    }

    private static void parseSubtitlingSegment(ParsableBitArray parsableBitArray, SubtitleService subtitleService2) {
        RegionComposition regionComposition;
        int readBits = parsableBitArray.readBits(8);
        int readBits2 = parsableBitArray.readBits(16);
        int readBits3 = parsableBitArray.readBits(16);
        int bytePosition = parsableBitArray.getBytePosition() + readBits3;
        if (readBits3 * 8 > parsableBitArray.bitsLeft()) {
            Log.w(TAG, "Data field length exceeds limit");
            parsableBitArray.skipBits(parsableBitArray.bitsLeft());
            return;
        }
        switch (readBits) {
            case 16:
                if (readBits2 == subtitleService2.subtitlePageId) {
                    PageComposition pageComposition = subtitleService2.pageComposition;
                    PageComposition parsePageComposition = parsePageComposition(parsableBitArray, readBits3);
                    if (parsePageComposition.state == 0) {
                        if (!(pageComposition == null || pageComposition.version == parsePageComposition.version)) {
                            subtitleService2.pageComposition = parsePageComposition;
                            break;
                        }
                    } else {
                        subtitleService2.pageComposition = parsePageComposition;
                        subtitleService2.regions.clear();
                        subtitleService2.cluts.clear();
                        subtitleService2.objects.clear();
                        break;
                    }
                }
                break;
            case 17:
                PageComposition pageComposition2 = subtitleService2.pageComposition;
                if (readBits2 == subtitleService2.subtitlePageId && pageComposition2 != null) {
                    RegionComposition parseRegionComposition = parseRegionComposition(parsableBitArray, readBits3);
                    if (pageComposition2.state == 0 && (regionComposition = subtitleService2.regions.get(parseRegionComposition.f66062id)) != null) {
                        parseRegionComposition.mergeFrom(regionComposition);
                    }
                    subtitleService2.regions.put(parseRegionComposition.f66062id, parseRegionComposition);
                    break;
                }
            case 18:
                if (readBits2 != subtitleService2.subtitlePageId) {
                    if (readBits2 == subtitleService2.ancillaryPageId) {
                        ClutDefinition parseClutDefinition = parseClutDefinition(parsableBitArray, readBits3);
                        subtitleService2.ancillaryCluts.put(parseClutDefinition.f66060id, parseClutDefinition);
                        break;
                    }
                } else {
                    ClutDefinition parseClutDefinition2 = parseClutDefinition(parsableBitArray, readBits3);
                    subtitleService2.cluts.put(parseClutDefinition2.f66060id, parseClutDefinition2);
                    break;
                }
                break;
            case 19:
                if (readBits2 != subtitleService2.subtitlePageId) {
                    if (readBits2 == subtitleService2.ancillaryPageId) {
                        ObjectData parseObjectData = parseObjectData(parsableBitArray);
                        subtitleService2.ancillaryObjects.put(parseObjectData.f66061id, parseObjectData);
                        break;
                    }
                } else {
                    ObjectData parseObjectData2 = parseObjectData(parsableBitArray);
                    subtitleService2.objects.put(parseObjectData2.f66061id, parseObjectData2);
                    break;
                }
                break;
            case 20:
                if (readBits2 == subtitleService2.subtitlePageId) {
                    subtitleService2.displayDefinition = parseDisplayDefinition(parsableBitArray);
                    break;
                }
                break;
        }
        parsableBitArray.skipBytes(bytePosition - parsableBitArray.getBytePosition());
    }

    public List<Cue> decode(byte[] bArr, int i11) {
        int i12;
        int i13;
        SparseArray<RegionObject> sparseArray;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr, i11);
        while (parsableBitArray.bitsLeft() >= 48 && parsableBitArray.readBits(8) == 15) {
            parseSubtitlingSegment(parsableBitArray, this.subtitleService);
        }
        SubtitleService subtitleService2 = this.subtitleService;
        PageComposition pageComposition = subtitleService2.pageComposition;
        if (pageComposition == null) {
            return Collections.emptyList();
        }
        DisplayDefinition displayDefinition = subtitleService2.displayDefinition;
        if (displayDefinition == null) {
            displayDefinition = this.defaultDisplayDefinition;
        }
        Bitmap bitmap2 = this.bitmap;
        if (!(bitmap2 != null && displayDefinition.width + 1 == bitmap2.getWidth() && displayDefinition.height + 1 == this.bitmap.getHeight())) {
            Bitmap createBitmap = Bitmap.createBitmap(displayDefinition.width + 1, displayDefinition.height + 1, Bitmap.Config.ARGB_8888);
            this.bitmap = createBitmap;
            this.canvas.setBitmap(createBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<PageRegion> sparseArray2 = pageComposition.regions;
        for (int i14 = 0; i14 < sparseArray2.size(); i14++) {
            this.canvas.save();
            PageRegion valueAt = sparseArray2.valueAt(i14);
            RegionComposition regionComposition = this.subtitleService.regions.get(sparseArray2.keyAt(i14));
            int i15 = valueAt.horizontalAddress + displayDefinition.horizontalPositionMinimum;
            int i16 = valueAt.verticalAddress + displayDefinition.verticalPositionMinimum;
            this.canvas.clipRect(i15, i16, Math.min(regionComposition.width + i15, displayDefinition.horizontalPositionMaximum), Math.min(regionComposition.height + i16, displayDefinition.verticalPositionMaximum));
            ClutDefinition clutDefinition = this.subtitleService.cluts.get(regionComposition.clutId);
            if (clutDefinition == null && (clutDefinition = this.subtitleService.ancillaryCluts.get(regionComposition.clutId)) == null) {
                clutDefinition = this.defaultClutDefinition;
            }
            SparseArray<RegionObject> sparseArray3 = regionComposition.regionObjects;
            int i17 = 0;
            while (i17 < sparseArray3.size()) {
                int keyAt = sparseArray3.keyAt(i17);
                RegionObject valueAt2 = sparseArray3.valueAt(i17);
                ObjectData objectData = this.subtitleService.objects.get(keyAt);
                ObjectData objectData2 = objectData == null ? this.subtitleService.ancillaryObjects.get(keyAt) : objectData;
                if (objectData2 != null) {
                    Paint paint = objectData2.nonModifyingColorFlag ? null : this.defaultPaint;
                    i13 = i17;
                    sparseArray = sparseArray3;
                    paintPixelDataSubBlocks(objectData2, clutDefinition, regionComposition.depth, valueAt2.horizontalPosition + i15, i16 + valueAt2.verticalPosition, paint, this.canvas);
                } else {
                    i13 = i17;
                    sparseArray = sparseArray3;
                }
                i17 = i13 + 1;
                sparseArray3 = sparseArray;
            }
            if (regionComposition.fillFlag) {
                int i18 = regionComposition.depth;
                if (i18 == 3) {
                    i12 = clutDefinition.clutEntries8Bit[regionComposition.pixelCode8Bit];
                } else if (i18 == 2) {
                    i12 = clutDefinition.clutEntries4Bit[regionComposition.pixelCode4Bit];
                } else {
                    i12 = clutDefinition.clutEntries2Bit[regionComposition.pixelCode2Bit];
                }
                this.fillRegionPaint.setColor(i12);
                this.canvas.drawRect((float) i15, (float) i16, (float) (regionComposition.width + i15), (float) (regionComposition.height + i16), this.fillRegionPaint);
            }
            arrayList.add(new Cue.Builder().setBitmap(Bitmap.createBitmap(this.bitmap, i15, i16, regionComposition.width, regionComposition.height)).setPosition(((float) i15) / ((float) displayDefinition.width)).setPositionAnchor(0).setLine(((float) i16) / ((float) displayDefinition.height), 0).setLineAnchor(0).setSize(((float) regionComposition.width) / ((float) displayDefinition.width)).setBitmapHeight(((float) regionComposition.height) / ((float) displayDefinition.height)).build());
            this.canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            this.canvas.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void reset() {
        this.subtitleService.reset();
    }
}
