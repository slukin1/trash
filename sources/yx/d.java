package yx;

import com.opensource.svgaplayer.proto.ShapeEntity;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
public final /* synthetic */ class d {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f29422a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f29423b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int[] f29424c;

    static {
        int[] iArr = new int[ShapeEntity.ShapeType.values().length];
        f29422a = iArr;
        iArr[ShapeEntity.ShapeType.SHAPE.ordinal()] = 1;
        iArr[ShapeEntity.ShapeType.RECT.ordinal()] = 2;
        iArr[ShapeEntity.ShapeType.ELLIPSE.ordinal()] = 3;
        iArr[ShapeEntity.ShapeType.KEEP.ordinal()] = 4;
        int[] iArr2 = new int[ShapeEntity.ShapeStyle.LineCap.values().length];
        f29423b = iArr2;
        iArr2[ShapeEntity.ShapeStyle.LineCap.LineCap_BUTT.ordinal()] = 1;
        iArr2[ShapeEntity.ShapeStyle.LineCap.LineCap_ROUND.ordinal()] = 2;
        iArr2[ShapeEntity.ShapeStyle.LineCap.LineCap_SQUARE.ordinal()] = 3;
        int[] iArr3 = new int[ShapeEntity.ShapeStyle.LineJoin.values().length];
        f29424c = iArr3;
        iArr3[ShapeEntity.ShapeStyle.LineJoin.LineJoin_BEVEL.ordinal()] = 1;
        iArr3[ShapeEntity.ShapeStyle.LineJoin.LineJoin_MITER.ordinal()] = 2;
        iArr3[ShapeEntity.ShapeStyle.LineJoin.LineJoin_ROUND.ordinal()] = 3;
    }
}
