package com.geetest.captcha;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0002\n\u000bB'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/geetest/captcha/utils/HttpUrl;", "", "baseUrl", "", "params", "", "(Ljava/lang/String;Ljava/util/Map;)V", "newBuilder", "Lcom/geetest/captcha/utils/HttpUrl$Builder;", "toString", "Builder", "Companion", "captcha_release"}, k = 1, mv = {1, 1, 16})
public final class ae {

    /* renamed from: a  reason: collision with root package name */
    public static final b f65171a = new b((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final String f65172b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f65173c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/geetest/captcha/utils/HttpUrl$Builder;", "", "baseUrl", "", "params", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getParams", "()Ljava/util/Map;", "addQueryParameter", "name", "value", "build", "Lcom/geetest/captcha/utils/HttpUrl;", "captcha_release"}, k = 1, mv = {1, 1, 16})
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f65174a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<String, String> f65175b;

        public a(String str, Map<String, String> map) {
            this.f65174a = str;
            this.f65175b = map;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/geetest/captcha/utils/HttpUrl$Companion;", "", "()V", "parse", "Lcom/geetest/captcha/utils/HttpUrl;", "url", "", "captcha_release"}, k = 1, mv = {1, 1, 16})
    public static final class b {
        private b() {
        }

        public static ae a(String str) {
            try {
                if (StringsKt__StringsJVMKt.z(str)) {
                    return null;
                }
                Object[] array = StringsKt__StringsKt.L0(StringsKt__StringsKt.i1(str).toString(), new String[]{"?"}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    HashMap hashMap = new HashMap();
                    if (strArr.length == 1) {
                        return new ae(strArr[0], hashMap, (byte) 0);
                    }
                    if (strArr.length == 2) {
                        Object[] array2 = StringsKt__StringsKt.L0(strArr[1], new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null).toArray(new String[0]);
                        if (array2 != null) {
                            String[] strArr2 = (String[]) array2;
                            int length = strArr2.length;
                            int i11 = 0;
                            while (i11 < length) {
                                Object[] array3 = StringsKt__StringsKt.L0(strArr2[i11], new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null).toArray(new String[0]);
                                if (array3 != null) {
                                    String[] strArr3 = (String[]) array3;
                                    if (strArr3.length == 2) {
                                        hashMap.put(strArr3[0], strArr3[1]);
                                    }
                                    i11++;
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                            }
                            return new ae(strArr[0], hashMap, (byte) 0);
                        }
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    return null;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public /* synthetic */ b(byte b11) {
            this();
        }
    }

    private ae(String str, Map<String, String> map) {
        this.f65172b = str;
        this.f65173c = map;
    }

    public final a a() {
        return new a(this.f65172b, this.f65173c);
    }

    public final String toString() {
        Map<String, String> map = this.f65173c;
        if (map == null || map.isEmpty()) {
            return this.f65172b;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f65172b);
        stringBuffer.append('?');
        for (Map.Entry next : this.f65173c.entrySet()) {
            stringBuffer.append((String) next.getKey());
            stringBuffer.append('=');
            stringBuffer.append((String) next.getValue());
            stringBuffer.append('&');
        }
        return stringBuffer.deleteCharAt(stringBuffer.length() - 1).toString();
    }

    public /* synthetic */ ae(String str, Map map, byte b11) {
        this(str, map);
    }
}
