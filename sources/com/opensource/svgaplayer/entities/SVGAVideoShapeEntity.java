package com.opensource.svgaplayer.entities;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.opensource.svgaplayer.proto.ShapeEntity;
import com.opensource.svgaplayer.proto.Transform;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.json.JSONArray;
import org.json.JSONObject;
import yx.b;
import yx.d;
import yx.e;

@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0002;<B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b8\u00109B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0007¢\u0006\u0004\b8\u0010:J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H\u0002R$\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR@\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001d2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001d8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b \u0010!R(\u0010'\u001a\u0004\u0018\u00010#2\b\u0010\u0018\u001a\u0004\u0018\u00010#8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010&R(\u0010,\u001a\u0004\u0018\u00010(2\b\u0010\u0018\u001a\u0004\u0018\u00010(8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b*\u0010+R$\u00103\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0011\u00107\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b5\u00106¨\u0006="}, d2 = {"Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity;", "", "", "a", "Lorg/json/JSONObject;", "obj", "q", "Lcom/opensource/svgaplayer/proto/ShapeEntity;", "p", "k", "j", "Lorg/json/JSONArray;", "", "e", "c", "m", "Lcom/opensource/svgaplayer/proto/ShapeEntity$ShapeStyle$RGBAColor;", "color", "d", "b", "l", "o", "n", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "<set-?>", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "getType", "()Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "type", "", "", "Ljava/util/Map;", "getArgs", "()Ljava/util/Map;", "args", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Styles;", "Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Styles;", "g", "()Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Styles;", "styles", "Landroid/graphics/Matrix;", "Landroid/graphics/Matrix;", "h", "()Landroid/graphics/Matrix;", "transform", "Landroid/graphics/Path;", "Landroid/graphics/Path;", "f", "()Landroid/graphics/Path;", "setShapePath", "(Landroid/graphics/Path;)V", "shapePath", "", "i", "()Z", "isKeep", "<init>", "(Lorg/json/JSONObject;)V", "(Lcom/opensource/svgaplayer/proto/ShapeEntity;)V", "Styles", "Type", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class SVGAVideoShapeEntity {

    /* renamed from: a  reason: collision with root package name */
    public Type f28590a = Type.shape;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, ? extends Object> f28591b;

    /* renamed from: c  reason: collision with root package name */
    public Styles f28592c;

    /* renamed from: d  reason: collision with root package name */
    public Matrix f28593d;

    /* renamed from: e  reason: collision with root package name */
    public Path f28594e;

    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)R*\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@@X\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@@X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR*\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e8\u0006@@X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00168\u0006@@X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\n\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00168\u0006@@X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001e\u0010\u001bR*\u0010!\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@@X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b \u0010\bR*\u0010'\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8\u0006@@X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010#\u001a\u0004\b\u000f\u0010$\"\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Styles;", "", "", "<set-?>", "a", "I", "()I", "h", "(I)V", "fill", "b", "f", "m", "stroke", "", "c", "F", "g", "()F", "n", "(F)V", "strokeWidth", "", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "lineCap", "e", "k", "lineJoin", "l", "miterLimit", "", "[F", "()[F", "j", "([F)V", "lineDash", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public static final class Styles {

        /* renamed from: a  reason: collision with root package name */
        public int f28595a;

        /* renamed from: b  reason: collision with root package name */
        public int f28596b;

        /* renamed from: c  reason: collision with root package name */
        public float f28597c;

        /* renamed from: d  reason: collision with root package name */
        public String f28598d = "butt";

        /* renamed from: e  reason: collision with root package name */
        public String f28599e = "miter";

        /* renamed from: f  reason: collision with root package name */
        public int f28600f;

        /* renamed from: g  reason: collision with root package name */
        public float[] f28601g = new float[0];

        public final int a() {
            return this.f28595a;
        }

        public final String b() {
            return this.f28598d;
        }

        public final float[] c() {
            return this.f28601g;
        }

        public final String d() {
            return this.f28599e;
        }

        public final int e() {
            return this.f28600f;
        }

        public final int f() {
            return this.f28596b;
        }

        public final float g() {
            return this.f28597c;
        }

        public final void h(int i11) {
            this.f28595a = i11;
        }

        public final void i(String str) {
            this.f28598d = str;
        }

        public final void j(float[] fArr) {
            this.f28601g = fArr;
        }

        public final void k(String str) {
            this.f28599e = str;
        }

        public final void l(int i11) {
            this.f28600f = i11;
        }

        public final void m(int i11) {
            this.f28596b = i11;
        }

        public final void n(float f11) {
            this.f28597c = f11;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/opensource/svgaplayer/entities/SVGAVideoShapeEntity$Type;", "", "(Ljava/lang/String;I)V", "shape", "rect", "ellipse", "keep", "com.opensource.svgaplayer"}, k = 1, mv = {1, 1, 15})
    public enum Type {
        shape,
        rect,
        ellipse,
        keep
    }

    public SVGAVideoShapeEntity(JSONObject jSONObject) {
        q(jSONObject);
        k(jSONObject);
        m(jSONObject);
        o(jSONObject);
    }

    public final void a() {
        if (this.f28594e == null) {
            e.a().reset();
            Type type = this.f28590a;
            String str = null;
            if (type == Type.shape) {
                Map<String, ? extends Object> map = this.f28591b;
                Object obj = map != null ? map.get(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG) : null;
                if (obj instanceof String) {
                    str = obj;
                }
                String str2 = str;
                if (str2 != null) {
                    new b(str2).a(e.a());
                }
            } else if (type == Type.ellipse) {
                Map<String, ? extends Object> map2 = this.f28591b;
                Object obj2 = map2 != null ? map2.get("x") : null;
                if (!(obj2 instanceof Number)) {
                    obj2 = null;
                }
                Number number = (Number) obj2;
                if (number != null) {
                    Map<String, ? extends Object> map3 = this.f28591b;
                    Object obj3 = map3 != null ? map3.get("y") : null;
                    if (!(obj3 instanceof Number)) {
                        obj3 = null;
                    }
                    Number number2 = (Number) obj3;
                    if (number2 != null) {
                        Map<String, ? extends Object> map4 = this.f28591b;
                        Object obj4 = map4 != null ? map4.get("radiusX") : null;
                        if (!(obj4 instanceof Number)) {
                            obj4 = null;
                        }
                        Number number3 = (Number) obj4;
                        if (number3 != null) {
                            Map<String, ? extends Object> map5 = this.f28591b;
                            Object obj5 = map5 != null ? map5.get("radiusY") : null;
                            if (obj5 instanceof Number) {
                                str = obj5;
                            }
                            Number number4 = (Number) str;
                            if (number4 != null) {
                                float floatValue = number.floatValue();
                                float floatValue2 = number2.floatValue();
                                float floatValue3 = number3.floatValue();
                                float floatValue4 = number4.floatValue();
                                e.a().addOval(new RectF(floatValue - floatValue3, floatValue2 - floatValue4, floatValue + floatValue3, floatValue2 + floatValue4), Path.Direction.CW);
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else if (type == Type.rect) {
                Map<String, ? extends Object> map6 = this.f28591b;
                Object obj6 = map6 != null ? map6.get("x") : null;
                if (!(obj6 instanceof Number)) {
                    obj6 = null;
                }
                Number number5 = (Number) obj6;
                if (number5 != null) {
                    Map<String, ? extends Object> map7 = this.f28591b;
                    Object obj7 = map7 != null ? map7.get("y") : null;
                    if (!(obj7 instanceof Number)) {
                        obj7 = null;
                    }
                    Number number6 = (Number) obj7;
                    if (number6 != null) {
                        Map<String, ? extends Object> map8 = this.f28591b;
                        Object obj8 = map8 != null ? map8.get("width") : null;
                        if (!(obj8 instanceof Number)) {
                            obj8 = null;
                        }
                        Number number7 = (Number) obj8;
                        if (number7 != null) {
                            Map<String, ? extends Object> map9 = this.f28591b;
                            Object obj9 = map9 != null ? map9.get("height") : null;
                            if (!(obj9 instanceof Number)) {
                                obj9 = null;
                            }
                            Number number8 = (Number) obj9;
                            if (number8 != null) {
                                Map<String, ? extends Object> map10 = this.f28591b;
                                Object obj10 = map10 != null ? map10.get("cornerRadius") : null;
                                if (obj10 instanceof Number) {
                                    str = obj10;
                                }
                                Number number9 = str;
                                if (number9 != null) {
                                    float floatValue5 = number5.floatValue();
                                    float floatValue6 = number6.floatValue();
                                    float floatValue7 = number7.floatValue();
                                    float floatValue8 = number8.floatValue();
                                    float floatValue9 = number9.floatValue();
                                    e.a().addRoundRect(new RectF(floatValue5, floatValue6, floatValue7 + floatValue5, floatValue8 + floatValue6), floatValue9, floatValue9, Path.Direction.CW);
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            Path path = new Path();
            this.f28594e = path;
            path.set(e.a());
        }
    }

    public final float b(ShapeEntity.ShapeStyle.RGBAColor rGBAColor) {
        return rGBAColor.f28665a.floatValue() <= 1.0f ? 255.0f : 1.0f;
    }

    public final float c(JSONArray jSONArray) {
        return jSONArray.optDouble(3) <= ((double) 1) ? 255.0f : 1.0f;
    }

    public final float d(ShapeEntity.ShapeStyle.RGBAColor rGBAColor) {
        Float f11 = rGBAColor.f28668r;
        float f12 = 0.0f;
        float f13 = (float) 1;
        if ((f11 != null ? f11.floatValue() : 0.0f) <= f13) {
            Float f14 = rGBAColor.f28667g;
            if ((f14 != null ? f14.floatValue() : 0.0f) <= f13) {
                Float f15 = rGBAColor.f28666b;
                if (f15 != null) {
                    f12 = f15.floatValue();
                }
                if (f12 <= f13) {
                    return 255.0f;
                }
            }
        }
        return 1.0f;
    }

    public final float e(JSONArray jSONArray) {
        double d11 = (double) 1;
        return (jSONArray.optDouble(0) > d11 || jSONArray.optDouble(1) > d11 || jSONArray.optDouble(2) > d11) ? 1.0f : 255.0f;
    }

    public final Path f() {
        return this.f28594e;
    }

    public final Styles g() {
        return this.f28592c;
    }

    public final Matrix h() {
        return this.f28593d;
    }

    public final boolean i() {
        return this.f28590a == Type.keep;
    }

    public final void j(ShapeEntity shapeEntity) {
        String str;
        HashMap hashMap = new HashMap();
        ShapeEntity.ShapeArgs shapeArgs = shapeEntity.shape;
        if (!(shapeArgs == null || (str = shapeArgs.f28654d) == null)) {
            hashMap.put(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, str);
        }
        ShapeEntity.EllipseArgs ellipseArgs = shapeEntity.ellipse;
        if (ellipseArgs != null) {
            Float f11 = ellipseArgs.f28641x;
            if (f11 == null) {
                f11 = Float.valueOf(0.0f);
            }
            hashMap.put("x", f11);
            Float f12 = ellipseArgs.f28642y;
            if (f12 == null) {
                f12 = Float.valueOf(0.0f);
            }
            hashMap.put("y", f12);
            Float f13 = ellipseArgs.radiusX;
            if (f13 == null) {
                f13 = Float.valueOf(0.0f);
            }
            hashMap.put("radiusX", f13);
            Float f14 = ellipseArgs.radiusY;
            if (f14 == null) {
                f14 = Float.valueOf(0.0f);
            }
            hashMap.put("radiusY", f14);
        }
        ShapeEntity.RectArgs rectArgs = shapeEntity.rect;
        if (rectArgs != null) {
            Float f15 = rectArgs.f28647x;
            if (f15 == null) {
                f15 = Float.valueOf(0.0f);
            }
            hashMap.put("x", f15);
            Float f16 = rectArgs.f28648y;
            if (f16 == null) {
                f16 = Float.valueOf(0.0f);
            }
            hashMap.put("y", f16);
            Float f17 = rectArgs.width;
            if (f17 == null) {
                f17 = Float.valueOf(0.0f);
            }
            hashMap.put("width", f17);
            Float f18 = rectArgs.height;
            if (f18 == null) {
                f18 = Float.valueOf(0.0f);
            }
            hashMap.put("height", f18);
            Float f19 = rectArgs.cornerRadius;
            if (f19 == null) {
                f19 = Float.valueOf(0.0f);
            }
            hashMap.put("cornerRadius", f19);
        }
        this.f28591b = hashMap;
    }

    public final void k(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        JSONObject optJSONObject = jSONObject.optJSONObject("args");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = optJSONObject.get(next);
                if (obj != null) {
                    hashMap.put(next, obj);
                }
            }
            this.f28591b = hashMap;
        }
    }

    public final void l(ShapeEntity shapeEntity) {
        ShapeEntity.ShapeStyle shapeStyle = shapeEntity.styles;
        if (shapeStyle != null) {
            Styles styles = new Styles();
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor = shapeStyle.fill;
            float f11 = 0.0f;
            if (rGBAColor != null) {
                float d11 = d(rGBAColor);
                float b11 = b(rGBAColor);
                Float f12 = rGBAColor.f28665a;
                int floatValue = (int) ((f12 != null ? f12.floatValue() : 0.0f) * b11);
                Float f13 = rGBAColor.f28668r;
                int floatValue2 = (int) ((f13 != null ? f13.floatValue() : 0.0f) * d11);
                Float f14 = rGBAColor.f28667g;
                int floatValue3 = (int) ((f14 != null ? f14.floatValue() : 0.0f) * d11);
                Float f15 = rGBAColor.f28666b;
                styles.h(Color.argb(floatValue, floatValue2, floatValue3, (int) ((f15 != null ? f15.floatValue() : 0.0f) * d11)));
            }
            ShapeEntity.ShapeStyle.RGBAColor rGBAColor2 = shapeStyle.stroke;
            if (rGBAColor2 != null) {
                float d12 = d(rGBAColor2);
                float b12 = b(rGBAColor2);
                Float f16 = rGBAColor2.f28665a;
                int floatValue4 = (int) ((f16 != null ? f16.floatValue() : 0.0f) * b12);
                Float f17 = rGBAColor2.f28668r;
                int floatValue5 = (int) ((f17 != null ? f17.floatValue() : 0.0f) * d12);
                Float f18 = rGBAColor2.f28667g;
                int floatValue6 = (int) ((f18 != null ? f18.floatValue() : 0.0f) * d12);
                Float f19 = rGBAColor2.f28666b;
                styles.m(Color.argb(floatValue4, floatValue5, floatValue6, (int) ((f19 != null ? f19.floatValue() : 0.0f) * d12)));
            }
            Float f21 = shapeStyle.strokeWidth;
            styles.n(f21 != null ? f21.floatValue() : 0.0f);
            ShapeEntity.ShapeStyle.LineCap lineCap = shapeStyle.lineCap;
            if (lineCap != null) {
                int i11 = d.f29423b[lineCap.ordinal()];
                if (i11 == 1) {
                    styles.i("butt");
                } else if (i11 == 2) {
                    styles.i("round");
                } else if (i11 == 3) {
                    styles.i(MessengerShareContentUtility.IMAGE_RATIO_SQUARE);
                }
            }
            ShapeEntity.ShapeStyle.LineJoin lineJoin = shapeStyle.lineJoin;
            if (lineJoin != null) {
                int i12 = d.f29424c[lineJoin.ordinal()];
                if (i12 == 1) {
                    styles.k("bevel");
                } else if (i12 == 2) {
                    styles.k("miter");
                } else if (i12 == 3) {
                    styles.k("round");
                }
            }
            Float f22 = shapeStyle.miterLimit;
            if (f22 != null) {
                f11 = f22.floatValue();
            }
            styles.l((int) f11);
            styles.j(new float[3]);
            Float f23 = shapeStyle.lineDashI;
            if (f23 != null) {
                styles.c()[0] = f23.floatValue();
            }
            Float f24 = shapeStyle.lineDashII;
            if (f24 != null) {
                styles.c()[1] = f24.floatValue();
            }
            Float f25 = shapeStyle.lineDashIII;
            if (f25 != null) {
                styles.c()[2] = f25.floatValue();
            }
            this.f28592c = styles;
        }
    }

    public final void m(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("styles");
        if (optJSONObject != null) {
            Styles styles = new Styles();
            JSONArray optJSONArray = optJSONObject.optJSONArray("fill");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                float e11 = e(optJSONArray);
                double d11 = (double) e11;
                styles.h(Color.argb((int) (optJSONArray.optDouble(3) * ((double) c(optJSONArray))), (int) (optJSONArray.optDouble(0) * d11), (int) (optJSONArray.optDouble(1) * d11), (int) (optJSONArray.optDouble(2) * d11)));
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("stroke");
            if (optJSONArray2 != null && optJSONArray2.length() == 4) {
                float e12 = e(optJSONArray2);
                double d12 = (double) e12;
                styles.m(Color.argb((int) (optJSONArray2.optDouble(3) * ((double) c(optJSONArray2))), (int) (optJSONArray2.optDouble(0) * d12), (int) (optJSONArray2.optDouble(1) * d12), (int) (optJSONArray2.optDouble(2) * d12)));
            }
            styles.n((float) optJSONObject.optDouble("strokeWidth", 0.0d));
            styles.i(optJSONObject.optString("lineCap", "butt"));
            styles.k(optJSONObject.optString("lineJoin", "miter"));
            styles.l(optJSONObject.optInt("miterLimit", 0));
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("lineDash");
            if (optJSONArray3 != null) {
                styles.j(new float[optJSONArray3.length()]);
                int length = optJSONArray3.length();
                for (int i11 = 0; i11 < length; i11++) {
                    styles.c()[i11] = (float) optJSONArray3.optDouble(i11, 0.0d);
                }
            }
            this.f28592c = styles;
        }
    }

    public final void n(ShapeEntity shapeEntity) {
        Transform transform = shapeEntity.transform;
        if (transform != null) {
            Matrix matrix = new Matrix();
            float[] fArr = new float[9];
            Float f11 = transform.f28676a;
            float floatValue = f11 != null ? f11.floatValue() : 1.0f;
            Float f12 = transform.f28677b;
            float floatValue2 = f12 != null ? f12.floatValue() : 0.0f;
            Float f13 = transform.f28678c;
            float floatValue3 = f13 != null ? f13.floatValue() : 0.0f;
            Float f14 = transform.f28679d;
            float floatValue4 = f14 != null ? f14.floatValue() : 1.0f;
            Float f15 = transform.f28680tx;
            float floatValue5 = f15 != null ? f15.floatValue() : 0.0f;
            Float f16 = transform.f28681ty;
            float floatValue6 = f16 != null ? f16.floatValue() : 0.0f;
            fArr[0] = floatValue;
            fArr[1] = floatValue3;
            fArr[2] = floatValue5;
            fArr[3] = floatValue2;
            fArr[4] = floatValue4;
            fArr[5] = floatValue6;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            matrix.setValues(fArr);
            this.f28593d = matrix;
        }
    }

    public final void o(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("transform");
        if (optJSONObject != null) {
            Matrix matrix = new Matrix();
            double optDouble = optJSONObject.optDouble("a", 1.0d);
            double optDouble2 = optJSONObject.optDouble("b", 0.0d);
            double optDouble3 = optJSONObject.optDouble("c", 0.0d);
            double optDouble4 = optJSONObject.optDouble(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, 1.0d);
            Matrix matrix2 = matrix;
            float f11 = (float) 0.0d;
            float[] fArr = {(float) optDouble, (float) optDouble3, (float) optJSONObject.optDouble("tx", 0.0d), (float) optDouble2, (float) optDouble4, (float) optJSONObject.optDouble("ty", 0.0d), f11, f11, (float) 1.0d};
            Matrix matrix3 = matrix2;
            matrix3.setValues(fArr);
            this.f28593d = matrix3;
            return;
        }
    }

    public final void p(ShapeEntity shapeEntity) {
        Type type;
        ShapeEntity.ShapeType shapeType = shapeEntity.type;
        if (shapeType != null) {
            int i11 = d.f29422a[shapeType.ordinal()];
            if (i11 == 1) {
                type = Type.shape;
            } else if (i11 == 2) {
                type = Type.rect;
            } else if (i11 == 3) {
                type = Type.ellipse;
            } else if (i11 == 4) {
                type = Type.keep;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.f28590a = type;
        }
    }

    public final void q(JSONObject jSONObject) {
        String optString = jSONObject.optString("type");
        if (optString == null) {
            return;
        }
        if (StringsKt__StringsJVMKt.w(optString, "shape", true)) {
            this.f28590a = Type.shape;
        } else if (StringsKt__StringsJVMKt.w(optString, "rect", true)) {
            this.f28590a = Type.rect;
        } else if (StringsKt__StringsJVMKt.w(optString, "ellipse", true)) {
            this.f28590a = Type.ellipse;
        } else if (StringsKt__StringsJVMKt.w(optString, "keep", true)) {
            this.f28590a = Type.keep;
        }
    }

    public SVGAVideoShapeEntity(ShapeEntity shapeEntity) {
        p(shapeEntity);
        j(shapeEntity);
        l(shapeEntity);
        n(shapeEntity);
    }
}
