package yx;

import android.graphics.Matrix;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.Layout;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;
import zx.d;

@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020*¢\u0006\u0004\b(\u0010+R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006,"}, d2 = {"Lyx/g;", "", "", "alpha", "D", "a", "()D", "setAlpha", "(D)V", "Lzx/d;", "layout", "Lzx/d;", "b", "()Lzx/d;", "setLayout", "(Lzx/d;)V", "Landroid/graphics/Matrix;", "transform", "Landroid/graphics/Matrix;", "e", "()Landroid/graphics/Matrix;", "setTransform", "(Landroid/graphics/Matrix;)V", "Lyx/b;", "maskPath", "Lyx/b;", "c", "()Lyx/b;", "setMaskPath", "(Lyx/b;)V", "", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity;", "shapes", "Ljava/util/List;", "d", "()Ljava/util/List;", "f", "(Ljava/util/List;)V", "Lorg/json/JSONObject;", "obj", "<init>", "(Lorg/json/JSONObject;)V", "Lcom/opensource/svgaplayer/proto/FrameEntity;", "(Lcom/opensource/svgaplayer/proto/FrameEntity;)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public double f29429a;

    /* renamed from: b  reason: collision with root package name */
    public d f29430b;

    /* renamed from: c  reason: collision with root package name */
    public Matrix f29431c;

    /* renamed from: d  reason: collision with root package name */
    public b f29432d;

    /* renamed from: e  reason: collision with root package name */
    public List<SVGAVideoShapeEntity> f29433e;

    public g(JSONObject jSONObject) {
        int i11;
        int i12;
        g gVar = this;
        JSONObject jSONObject2 = jSONObject;
        gVar.f29430b = new d(0.0d, 0.0d, 0.0d, 0.0d);
        gVar.f29431c = new Matrix();
        gVar.f29433e = CollectionsKt__CollectionsKt.k();
        gVar.f29429a = jSONObject2.optDouble("alpha", 0.0d);
        JSONObject optJSONObject = jSONObject2.optJSONObject(TtmlNode.TAG_LAYOUT);
        if (optJSONObject != null) {
            gVar.f29430b = new d(optJSONObject.optDouble("x", 0.0d), optJSONObject.optDouble("y", 0.0d), optJSONObject.optDouble("width", 0.0d), optJSONObject.optDouble("height", 0.0d));
        }
        JSONObject optJSONObject2 = jSONObject2.optJSONObject("transform");
        if (optJSONObject2 != null) {
            double optDouble = optJSONObject2.optDouble("a", 1.0d);
            double optDouble2 = optJSONObject2.optDouble("b", 0.0d);
            double optDouble3 = optJSONObject2.optDouble("c", 0.0d);
            double optDouble4 = optJSONObject2.optDouble(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, 1.0d);
            double optDouble5 = optJSONObject2.optDouble("tx", 0.0d);
            double d11 = optDouble4;
            double optDouble6 = optJSONObject2.optDouble("ty", 0.0d);
            i11 = 0;
            float f11 = (float) optDouble3;
            i12 = 1;
            float f12 = (float) 0.0d;
            float[] fArr = {(float) optDouble, f11, (float) optDouble5, (float) optDouble2, (float) d11, (float) optDouble6, f12, f12, (float) 1.0d};
            gVar = this;
            gVar.f29431c.setValues(fArr);
        } else {
            i12 = 1;
            i11 = 0;
        }
        JSONObject jSONObject3 = jSONObject;
        String optString = jSONObject3.optString("clipPath");
        if (optString != null) {
            if ((optString.length() <= 0 ? i11 : i12) != 0) {
                gVar.f29432d = new b(optString);
            }
        }
        JSONArray optJSONArray = jSONObject3.optJSONArray("shapes");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i13 = i11; i13 < length; i13++) {
                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i13);
                if (optJSONObject3 != null) {
                    arrayList.add(new SVGAVideoShapeEntity(optJSONObject3));
                }
            }
            gVar.f29433e = CollectionsKt___CollectionsKt.I0(arrayList);
        }
    }

    public final double a() {
        return this.f29429a;
    }

    public final d b() {
        return this.f29430b;
    }

    public final b c() {
        return this.f29432d;
    }

    public final List<SVGAVideoShapeEntity> d() {
        return this.f29433e;
    }

    public final Matrix e() {
        return this.f29431c;
    }

    public final void f(List<SVGAVideoShapeEntity> list) {
        this.f29433e = list;
    }

    public g(FrameEntity frameEntity) {
        this.f29430b = new d(0.0d, 0.0d, 0.0d, 0.0d);
        this.f29431c = new Matrix();
        this.f29433e = CollectionsKt__CollectionsKt.k();
        Float f11 = frameEntity.alpha;
        this.f29429a = (double) (f11 != null ? f11.floatValue() : 0.0f);
        Layout layout = frameEntity.layout;
        if (layout != null) {
            Float f12 = layout.f28619x;
            double floatValue = (double) (f12 != null ? f12.floatValue() : 0.0f);
            Float f13 = layout.f28620y;
            double floatValue2 = (double) (f13 != null ? f13.floatValue() : 0.0f);
            Float f14 = layout.width;
            double floatValue3 = (double) (f14 != null ? f14.floatValue() : 0.0f);
            Float f15 = layout.height;
            this.f29430b = new d(floatValue, floatValue2, floatValue3, (double) (f15 != null ? f15.floatValue() : 0.0f));
        }
        Transform transform = frameEntity.transform;
        boolean z11 = true;
        if (transform != null) {
            float[] fArr = new float[9];
            Float f16 = transform.f28676a;
            float floatValue4 = f16 != null ? f16.floatValue() : 1.0f;
            Float f17 = transform.f28677b;
            float floatValue5 = f17 != null ? f17.floatValue() : 0.0f;
            Float f18 = transform.f28678c;
            float floatValue6 = f18 != null ? f18.floatValue() : 0.0f;
            Float f19 = transform.f28679d;
            float floatValue7 = f19 != null ? f19.floatValue() : 1.0f;
            Float f21 = transform.f28680tx;
            float floatValue8 = f21 != null ? f21.floatValue() : 0.0f;
            Float f22 = transform.f28681ty;
            float floatValue9 = f22 != null ? f22.floatValue() : 0.0f;
            fArr[0] = floatValue4;
            fArr[1] = floatValue6;
            fArr[2] = floatValue8;
            fArr[3] = floatValue5;
            fArr[4] = floatValue7;
            fArr[5] = floatValue9;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            this.f29431c.setValues(fArr);
        }
        String str = frameEntity.clipPath;
        if (str != null) {
            str = !(str.length() <= 0 ? false : z11) ? null : str;
            if (str != null) {
                this.f29432d = new b(str);
            }
        }
        List<ShapeEntity> list = frameEntity.shapes;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
        for (ShapeEntity sVGAVideoShapeEntity : list) {
            arrayList.add(new SVGAVideoShapeEntity(sVGAVideoShapeEntity));
        }
        this.f29433e = arrayList;
    }
}
