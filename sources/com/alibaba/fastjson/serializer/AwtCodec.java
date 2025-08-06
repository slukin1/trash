package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import f2.a;
import f2.b;
import f2.f;
import fv.g;
import g2.l;
import h2.k;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.lang.reflect.Type;

public class AwtCodec implements k, l {

    /* renamed from: a  reason: collision with root package name */
    public static final AwtCodec f14253a = new AwtCodec();

    public static boolean k(Class<?> cls) {
        return cls == Point.class || cls == Rectangle.class || cls == Font.class || cls == Color.class;
    }

    public int b() {
        return 12;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        if (obj == null) {
            serializeWriter.H();
            return;
        }
        if (obj instanceof Point) {
            Point point = (Point) obj;
            serializeWriter.y(l(serializeWriter, Point.class, '{'), "x", point.x);
            serializeWriter.y(',', "y", point.y);
        } else if (obj instanceof Font) {
            Font font = (Font) obj;
            serializeWriter.A(l(serializeWriter, Font.class, '{'), "name", font.getName());
            serializeWriter.y(',', "style", font.getStyle());
            serializeWriter.y(',', "size", font.getSize());
        } else if (obj instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) obj;
            serializeWriter.y(l(serializeWriter, Rectangle.class, '{'), "x", rectangle.x);
            serializeWriter.y(',', "y", rectangle.y);
            serializeWriter.y(',', "width", rectangle.width);
            serializeWriter.y(',', "height", rectangle.height);
        } else if (obj instanceof Color) {
            Color color = (Color) obj;
            serializeWriter.y(l(serializeWriter, Color.class, '{'), "r", color.getRed());
            serializeWriter.y(',', g.f22793a, color.getGreen());
            serializeWriter.y(',', "b", color.getBlue());
            if (color.getAlpha() > 0) {
                serializeWriter.y(',', "alpha", color.getAlpha());
            }
        } else {
            throw new JSONException("not support awt class : " + obj.getClass().getName());
        }
        serializeWriter.write(125);
    }

    public <T> T e(a aVar, Type type, Object obj) {
        T t11;
        b bVar = aVar.f15701g;
        if (bVar.J() == 8) {
            bVar.f(16);
            return null;
        } else if (bVar.J() == 12 || bVar.J() == 16) {
            bVar.nextToken();
            if (type == Point.class) {
                t11 = h(aVar, obj);
            } else if (type == Rectangle.class) {
                t11 = i(aVar);
            } else if (type == Color.class) {
                t11 = f(aVar);
            } else if (type == Font.class) {
                t11 = g(aVar);
            } else {
                throw new JSONException("not support awt class : " + type);
            }
            f l11 = aVar.l();
            aVar.S(t11, obj);
            aVar.T(l11);
            return t11;
        } else {
            throw new JSONException("syntax error");
        }
    }

    public Color f(a aVar) {
        b bVar = aVar.f15701g;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (bVar.J() != 13) {
            if (bVar.J() == 4) {
                String H = bVar.H();
                bVar.y(2);
                if (bVar.J() == 2) {
                    int w11 = bVar.w();
                    bVar.nextToken();
                    if (H.equalsIgnoreCase("r")) {
                        i11 = w11;
                    } else if (H.equalsIgnoreCase(g.f22793a)) {
                        i12 = w11;
                    } else if (H.equalsIgnoreCase("b")) {
                        i13 = w11;
                    } else if (H.equalsIgnoreCase("alpha")) {
                        i14 = w11;
                    } else {
                        throw new JSONException("syntax error, " + H);
                    }
                    if (bVar.J() == 16) {
                        bVar.f(4);
                    }
                } else {
                    throw new JSONException("syntax error");
                }
            } else {
                throw new JSONException("syntax error");
            }
        }
        bVar.nextToken();
        return new Color(i11, i12, i13, i14);
    }

    public Font g(a aVar) {
        b bVar = aVar.f15701g;
        int i11 = 0;
        String str = null;
        int i12 = 0;
        while (bVar.J() != 13) {
            if (bVar.J() == 4) {
                String H = bVar.H();
                bVar.y(2);
                if (H.equalsIgnoreCase("name")) {
                    if (bVar.J() == 4) {
                        str = bVar.H();
                        bVar.nextToken();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (H.equalsIgnoreCase("style")) {
                    if (bVar.J() == 2) {
                        i11 = bVar.w();
                        bVar.nextToken();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (!H.equalsIgnoreCase("size")) {
                    throw new JSONException("syntax error, " + H);
                } else if (bVar.J() == 2) {
                    i12 = bVar.w();
                    bVar.nextToken();
                } else {
                    throw new JSONException("syntax error");
                }
                if (bVar.J() == 16) {
                    bVar.f(4);
                }
            } else {
                throw new JSONException("syntax error");
            }
        }
        bVar.nextToken();
        return new Font(str, i11, i12);
    }

    public Point h(a aVar, Object obj) {
        int i11;
        b bVar = aVar.f15701g;
        int i12 = 0;
        int i13 = 0;
        while (bVar.J() != 13) {
            if (bVar.J() == 4) {
                String H = bVar.H();
                if (JSON.DEFAULT_TYPE_KEY.equals(H)) {
                    aVar.b("java.awt.Point");
                } else if ("$ref".equals(H)) {
                    return (Point) j(aVar, obj);
                } else {
                    bVar.y(2);
                    int J = bVar.J();
                    if (J == 2) {
                        i11 = bVar.w();
                        bVar.nextToken();
                    } else if (J == 3) {
                        i11 = (int) bVar.l();
                        bVar.nextToken();
                    } else {
                        throw new JSONException("syntax error : " + bVar.b());
                    }
                    if (H.equalsIgnoreCase("x")) {
                        i12 = i11;
                    } else if (H.equalsIgnoreCase("y")) {
                        i13 = i11;
                    } else {
                        throw new JSONException("syntax error, " + H);
                    }
                    if (bVar.J() == 16) {
                        bVar.f(4);
                    }
                }
            } else {
                throw new JSONException("syntax error");
            }
        }
        bVar.nextToken();
        return new Point(i12, i13);
    }

    public Rectangle i(a aVar) {
        int i11;
        b bVar = aVar.f15701g;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (bVar.J() != 13) {
            if (bVar.J() == 4) {
                String H = bVar.H();
                bVar.y(2);
                int J = bVar.J();
                if (J == 2) {
                    i11 = bVar.w();
                    bVar.nextToken();
                } else if (J == 3) {
                    i11 = (int) bVar.l();
                    bVar.nextToken();
                } else {
                    throw new JSONException("syntax error");
                }
                if (H.equalsIgnoreCase("x")) {
                    i12 = i11;
                } else if (H.equalsIgnoreCase("y")) {
                    i13 = i11;
                } else if (H.equalsIgnoreCase("width")) {
                    i14 = i11;
                } else if (H.equalsIgnoreCase("height")) {
                    i15 = i11;
                } else {
                    throw new JSONException("syntax error, " + H);
                }
                if (bVar.J() == 16) {
                    bVar.f(4);
                }
            } else {
                throw new JSONException("syntax error");
            }
        }
        bVar.nextToken();
        return new Rectangle(i12, i13, i14, i15);
    }

    public final Object j(a aVar, Object obj) {
        b t11 = aVar.t();
        t11.y(4);
        String H = t11.H();
        aVar.S(aVar.l(), obj);
        aVar.f(new a.C0078a(aVar.l(), H));
        aVar.Q();
        aVar.V(1);
        t11.f(13);
        aVar.a(13);
        return null;
    }

    public char l(SerializeWriter serializeWriter, Class<?> cls, char c11) {
        if (!serializeWriter.n(SerializerFeature.WriteClassName)) {
            return c11;
        }
        serializeWriter.write(123);
        serializeWriter.v(JSON.DEFAULT_TYPE_KEY);
        serializeWriter.K(cls.getName());
        return ',';
    }
}
