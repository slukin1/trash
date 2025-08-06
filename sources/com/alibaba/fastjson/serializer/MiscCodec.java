package com.alibaba.fastjson.serializer;

import cn.sharesdk.framework.InnerShareParams;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.c;
import com.alibaba.fastjson.util.TypeUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.android.tpush.XGServerInfo;
import com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.TPReportParams;
import f2.a;
import f2.b;
import g2.l;
import h2.k;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

public class MiscCodec implements k, l {

    /* renamed from: a  reason: collision with root package name */
    public static final MiscCodec f14289a = new MiscCodec();

    /* renamed from: b  reason: collision with root package name */
    public static Method f14290b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f14291c = false;

    public int b() {
        return 4;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        String str;
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        if (obj == null) {
            serializeWriter.H();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == SimpleDateFormat.class) {
            str = ((SimpleDateFormat) obj).toPattern();
            if (serializeWriter.n(SerializerFeature.WriteClassName) && obj.getClass() != type) {
                serializeWriter.write(123);
                serializeWriter.v(JSON.DEFAULT_TYPE_KEY);
                jSONSerializer.F(obj.getClass().getName());
                serializeWriter.A(',', TPReportParams.JSON_KEY_VAL, str);
                serializeWriter.write(125);
                return;
            }
        } else if (cls == Class.class) {
            str = ((Class) obj).getName();
        } else if (cls == InetSocketAddress.class) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
            InetAddress address = inetSocketAddress.getAddress();
            serializeWriter.write(123);
            if (address != null) {
                serializeWriter.v(InnerShareParams.ADDRESS);
                jSONSerializer.E(address);
                serializeWriter.write(44);
            }
            serializeWriter.v(XGServerInfo.TAG_PORT);
            serializeWriter.E(inetSocketAddress.getPort());
            serializeWriter.write(125);
            return;
        } else if (obj instanceof File) {
            str = ((File) obj).getPath();
        } else if (obj instanceof InetAddress) {
            str = ((InetAddress) obj).getHostAddress();
        } else if (obj instanceof TimeZone) {
            str = ((TimeZone) obj).getID();
        } else if (obj instanceof Currency) {
            str = ((Currency) obj).getCurrencyCode();
        } else if (obj instanceof c) {
            ((c) obj).writeJSONString(serializeWriter);
            return;
        } else if (obj instanceof Iterator) {
            f(jSONSerializer, serializeWriter, (Iterator) obj);
            return;
        } else if (obj instanceof Iterable) {
            f(jSONSerializer, serializeWriter, ((Iterable) obj).iterator());
            return;
        } else if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key instanceof String) {
                String str2 = (String) key;
                if (value instanceof String) {
                    serializeWriter.B('{', str2, (String) value);
                } else {
                    serializeWriter.write(123);
                    serializeWriter.v(str2);
                    jSONSerializer.E(value);
                }
            } else {
                serializeWriter.write(123);
                jSONSerializer.E(key);
                serializeWriter.write(58);
                jSONSerializer.E(value);
            }
            serializeWriter.write(125);
            return;
        } else if (obj.getClass().getName().equals("net.sf.json.JSONNull")) {
            serializeWriter.H();
            return;
        } else {
            throw new JSONException("not support class : " + cls);
        }
        serializeWriter.K(str);
    }

    public <T> T e(a aVar, Type type, Object obj) {
        Object obj2;
        String str;
        b bVar = aVar.f15701g;
        InetAddress inetAddress = null;
        int i11 = 0;
        if (type != InetSocketAddress.class) {
            if (aVar.f15706l == 2) {
                aVar.f15706l = 0;
                aVar.a(16);
                if (bVar.J() != 4) {
                    throw new JSONException("syntax error");
                } else if (TPReportParams.JSON_KEY_VAL.equals(bVar.H())) {
                    bVar.nextToken();
                    aVar.a(17);
                    obj2 = aVar.z();
                    aVar.a(13);
                } else {
                    throw new JSONException("syntax error");
                }
            } else {
                obj2 = aVar.z();
            }
            if (obj2 == null) {
                str = null;
            } else if (obj2 instanceof String) {
                str = (String) obj2;
            } else {
                if (obj2 instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) obj2;
                    if (type == Currency.class) {
                        String string = jSONObject.getString(FirebaseAnalytics.Param.CURRENCY);
                        if (string != null) {
                            return Currency.getInstance(string);
                        }
                        String string2 = jSONObject.getString("symbol");
                        if (string2 != null) {
                            return Currency.getInstance(string2);
                        }
                    }
                    if (type == Map.Entry.class) {
                        return jSONObject.entrySet().iterator().next();
                    }
                }
                throw new JSONException("expect string");
            }
            if (str == null || str.length() == 0) {
                return null;
            }
            if (type == UUID.class) {
                return UUID.fromString(str);
            }
            if (type == URI.class) {
                return URI.create(str);
            }
            if (type == URL.class) {
                try {
                    return new URL(str);
                } catch (MalformedURLException e11) {
                    throw new JSONException("create url error", e11);
                }
            } else if (type == Pattern.class) {
                return Pattern.compile(str);
            } else {
                if (type == Locale.class) {
                    return TypeUtils.Z(str);
                }
                if (type == SimpleDateFormat.class) {
                    T simpleDateFormat = new SimpleDateFormat(str, bVar.getLocale());
                    simpleDateFormat.setTimeZone(bVar.k());
                    return simpleDateFormat;
                } else if (type == InetAddress.class || type == Inet4Address.class || type == Inet6Address.class) {
                    try {
                        return InetAddress.getByName(str);
                    } catch (UnknownHostException e12) {
                        throw new JSONException("deserialize inet adress error", e12);
                    }
                } else if (type == File.class) {
                    return new File(str);
                } else {
                    if (type == TimeZone.class) {
                        return TimeZone.getTimeZone(str);
                    }
                    if (type instanceof ParameterizedType) {
                        type = ((ParameterizedType) type).getRawType();
                    }
                    if (type == Class.class) {
                        return TypeUtils.X(str, aVar.k().h());
                    }
                    if (type == Charset.class) {
                        return Charset.forName(str);
                    }
                    if (type == Currency.class) {
                        return Currency.getInstance(str);
                    }
                    if (type == JSONPath.class) {
                        return new JSONPath(str);
                    }
                    if (type instanceof Class) {
                        String name = ((Class) type).getName();
                        if (name.equals("java.nio.file.Path")) {
                            try {
                                if (f14290b == null && !f14291c) {
                                    f14290b = TypeUtils.W("java.nio.file.Paths").getMethod("get", new Class[]{String.class, String[].class});
                                }
                                Method method = f14290b;
                                if (method != null) {
                                    return method.invoke((Object) null, new Object[]{str, new String[0]});
                                }
                                throw new JSONException("Path deserialize erorr");
                            } catch (NoSuchMethodException unused) {
                                f14291c = true;
                            } catch (IllegalAccessException e13) {
                                throw new JSONException("Path deserialize erorr", e13);
                            } catch (InvocationTargetException e14) {
                                throw new JSONException("Path deserialize erorr", e14);
                            }
                        }
                        throw new JSONException("MiscCodec not support " + name);
                    }
                    throw new JSONException("MiscCodec not support " + type.toString());
                }
            }
        } else if (bVar.J() == 8) {
            bVar.nextToken();
            return null;
        } else {
            aVar.a(12);
            while (true) {
                String H = bVar.H();
                bVar.f(17);
                if (H.equals(InnerShareParams.ADDRESS)) {
                    aVar.a(17);
                    inetAddress = (InetAddress) aVar.K(InetAddress.class);
                } else if (H.equals(XGServerInfo.TAG_PORT)) {
                    aVar.a(17);
                    if (bVar.J() == 2) {
                        int w11 = bVar.w();
                        bVar.nextToken();
                        i11 = w11;
                    } else {
                        throw new JSONException("port is not int");
                    }
                } else {
                    aVar.a(17);
                    aVar.z();
                }
                if (bVar.J() == 16) {
                    bVar.nextToken();
                } else {
                    aVar.a(13);
                    return new InetSocketAddress(inetAddress, i11);
                }
            }
        }
    }

    public void f(JSONSerializer jSONSerializer, SerializeWriter serializeWriter, Iterator<?> it2) {
        serializeWriter.write(91);
        int i11 = 0;
        while (it2.hasNext()) {
            if (i11 != 0) {
                serializeWriter.write(44);
            }
            jSONSerializer.E(it2.next());
            i11++;
        }
        serializeWriter.write(93);
    }
}
