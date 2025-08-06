package f2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.TypeUtils;
import g2.f;
import g2.g;
import g2.h;
import g2.i;
import g2.j;
import g2.k;
import g2.l;
import g2.p;
import java.io.Closeable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class a implements Closeable {

    /* renamed from: q  reason: collision with root package name */
    public static final Set<Class<?>> f15695q = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public final Object f15696b;

    /* renamed from: c  reason: collision with root package name */
    public final g f15697c;

    /* renamed from: d  reason: collision with root package name */
    public ParserConfig f15698d;

    /* renamed from: e  reason: collision with root package name */
    public String f15699e;

    /* renamed from: f  reason: collision with root package name */
    public DateFormat f15700f;

    /* renamed from: g  reason: collision with root package name */
    public final b f15701g;

    /* renamed from: h  reason: collision with root package name */
    public f f15702h;

    /* renamed from: i  reason: collision with root package name */
    public f[] f15703i;

    /* renamed from: j  reason: collision with root package name */
    public int f15704j;

    /* renamed from: k  reason: collision with root package name */
    public List<C0078a> f15705k;

    /* renamed from: l  reason: collision with root package name */
    public int f15706l;

    /* renamed from: m  reason: collision with root package name */
    public List<h> f15707m;

    /* renamed from: n  reason: collision with root package name */
    public List<g> f15708n;

    /* renamed from: o  reason: collision with root package name */
    public j f15709o;

    /* renamed from: p  reason: collision with root package name */
    public String[] f15710p;

    /* renamed from: f2.a$a  reason: collision with other inner class name */
    public static class C0078a {

        /* renamed from: a  reason: collision with root package name */
        public final f f15711a;

        /* renamed from: b  reason: collision with root package name */
        public final String f15712b;

        /* renamed from: c  reason: collision with root package name */
        public i f15713c;

        /* renamed from: d  reason: collision with root package name */
        public f f15714d;

        public C0078a(f fVar, String str) {
            this.f15711a = fVar;
            this.f15712b = str;
        }
    }

    static {
        Class[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class};
        for (int i11 = 0; i11 < 17; i11++) {
            f15695q.add(clsArr[i11]);
        }
    }

    public a(String str, ParserConfig parserConfig) {
        this((Object) str, (b) new e(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r11 = r10.f15698d.j(r2);
        r10.f15701g.f(16);
        V(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01d1, code lost:
        if (r0 == null) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01d5, code lost:
        if ((r12 instanceof java.lang.Integer) != false) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01d7, code lost:
        Q();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01da, code lost:
        r11 = (java.util.Map) r11.e(r10, r2, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01e0, code lost:
        T(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01e3, code lost:
        return r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object A(g2.n r11, java.lang.Object r12) {
        /*
            r10 = this;
            f2.b r0 = r10.f15701g
            int r0 = r0.J()
            r1 = 0
            r2 = 12
            if (r0 == r2) goto L_0x008c
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "syntax error, expect {, actual "
            r11.append(r0)
            f2.b r0 = r10.f15701g
            java.lang.String r0 = r0.b()
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            boolean r0 = r12 instanceof java.lang.String
            if (r0 == 0) goto L_0x0046
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            java.lang.String r11 = ", fieldName "
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            r0.append(r12)
            java.lang.String r11 = r0.toString()
        L_0x0046:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            java.lang.String r11 = ", "
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            f2.b r11 = r10.f15701g
            java.lang.String r11 = r11.t()
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            com.alibaba.fastjson.JSONArray r0 = new com.alibaba.fastjson.JSONArray
            r0.<init>()
            r10.G(r0, r12)
            int r12 = r0.size()
            r2 = 1
            if (r12 != r2) goto L_0x0086
            java.lang.Object r12 = r0.get(r1)
            boolean r0 = r12 instanceof com.alibaba.fastjson.JSONObject
            if (r0 == 0) goto L_0x0086
            com.alibaba.fastjson.JSONObject r12 = (com.alibaba.fastjson.JSONObject) r12
            return r12
        L_0x0086:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException
            r12.<init>(r11)
            throw r12
        L_0x008c:
            f2.f r0 = r10.f15702h
        L_0x008e:
            f2.b r2 = r10.f15701g     // Catch:{ all -> 0x025a }
            r2.p()     // Catch:{ all -> 0x025a }
            f2.b r2 = r10.f15701g     // Catch:{ all -> 0x025a }
            char r2 = r2.A()     // Catch:{ all -> 0x025a }
            f2.b r3 = r10.f15701g     // Catch:{ all -> 0x025a }
            com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x025a }
            boolean r3 = r3.a(r4)     // Catch:{ all -> 0x025a }
            if (r3 == 0) goto L_0x00b8
        L_0x00a3:
            r3 = 44
            if (r2 != r3) goto L_0x00b8
            f2.b r2 = r10.f15701g     // Catch:{ all -> 0x025a }
            r2.next()     // Catch:{ all -> 0x025a }
            f2.b r2 = r10.f15701g     // Catch:{ all -> 0x025a }
            r2.p()     // Catch:{ all -> 0x025a }
            f2.b r2 = r10.f15701g     // Catch:{ all -> 0x025a }
            char r2 = r2.A()     // Catch:{ all -> 0x025a }
            goto L_0x00a3
        L_0x00b8:
            java.lang.String r3 = "expect ':' at "
            r4 = 58
            r5 = 34
            r6 = 16
            if (r2 != r5) goto L_0x00f4
            f2.b r2 = r10.f15701g     // Catch:{ all -> 0x025a }
            f2.g r7 = r10.f15697c     // Catch:{ all -> 0x025a }
            java.lang.String r2 = r2.o(r7, r5)     // Catch:{ all -> 0x025a }
            f2.b r7 = r10.f15701g     // Catch:{ all -> 0x025a }
            r7.p()     // Catch:{ all -> 0x025a }
            f2.b r7 = r10.f15701g     // Catch:{ all -> 0x025a }
            char r7 = r7.A()     // Catch:{ all -> 0x025a }
            if (r7 != r4) goto L_0x00d9
            goto L_0x0171
        L_0x00d9:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x025a }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x025a }
            r12.<init>()     // Catch:{ all -> 0x025a }
            r12.append(r3)     // Catch:{ all -> 0x025a }
            f2.b r1 = r10.f15701g     // Catch:{ all -> 0x025a }
            int r1 = r1.s()     // Catch:{ all -> 0x025a }
            r12.append(r1)     // Catch:{ all -> 0x025a }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x025a }
            r11.<init>(r12)     // Catch:{ all -> 0x025a }
            throw r11     // Catch:{ all -> 0x025a }
        L_0x00f4:
            r7 = 125(0x7d, float:1.75E-43)
            if (r2 != r7) goto L_0x010b
            f2.b r12 = r10.f15701g     // Catch:{ all -> 0x025a }
            r12.next()     // Catch:{ all -> 0x025a }
            f2.b r12 = r10.f15701g     // Catch:{ all -> 0x025a }
            r12.K()     // Catch:{ all -> 0x025a }
            f2.b r12 = r10.f15701g     // Catch:{ all -> 0x025a }
            r12.f(r6)     // Catch:{ all -> 0x025a }
            r10.T(r0)
            return r11
        L_0x010b:
            java.lang.String r7 = "syntax error"
            r8 = 39
            if (r2 != r8) goto L_0x0152
            f2.b r2 = r10.f15701g     // Catch:{ all -> 0x025a }
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.AllowSingleQuotes     // Catch:{ all -> 0x025a }
            boolean r2 = r2.a(r9)     // Catch:{ all -> 0x025a }
            if (r2 == 0) goto L_0x014c
            f2.b r2 = r10.f15701g     // Catch:{ all -> 0x025a }
            f2.g r7 = r10.f15697c     // Catch:{ all -> 0x025a }
            java.lang.String r2 = r2.o(r7, r8)     // Catch:{ all -> 0x025a }
            f2.b r7 = r10.f15701g     // Catch:{ all -> 0x025a }
            r7.p()     // Catch:{ all -> 0x025a }
            f2.b r7 = r10.f15701g     // Catch:{ all -> 0x025a }
            char r7 = r7.A()     // Catch:{ all -> 0x025a }
            if (r7 != r4) goto L_0x0131
            goto L_0x0171
        L_0x0131:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x025a }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x025a }
            r12.<init>()     // Catch:{ all -> 0x025a }
            r12.append(r3)     // Catch:{ all -> 0x025a }
            f2.b r1 = r10.f15701g     // Catch:{ all -> 0x025a }
            int r1 = r1.s()     // Catch:{ all -> 0x025a }
            r12.append(r1)     // Catch:{ all -> 0x025a }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x025a }
            r11.<init>(r12)     // Catch:{ all -> 0x025a }
            throw r11     // Catch:{ all -> 0x025a }
        L_0x014c:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x025a }
            r11.<init>(r7)     // Catch:{ all -> 0x025a }
            throw r11     // Catch:{ all -> 0x025a }
        L_0x0152:
            f2.b r2 = r10.f15701g     // Catch:{ all -> 0x025a }
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.AllowUnQuotedFieldNames     // Catch:{ all -> 0x025a }
            boolean r2 = r2.a(r8)     // Catch:{ all -> 0x025a }
            if (r2 == 0) goto L_0x0254
            f2.b r2 = r10.f15701g     // Catch:{ all -> 0x025a }
            f2.g r7 = r10.f15697c     // Catch:{ all -> 0x025a }
            java.lang.String r2 = r2.C(r7)     // Catch:{ all -> 0x025a }
            f2.b r7 = r10.f15701g     // Catch:{ all -> 0x025a }
            r7.p()     // Catch:{ all -> 0x025a }
            f2.b r7 = r10.f15701g     // Catch:{ all -> 0x025a }
            char r7 = r7.A()     // Catch:{ all -> 0x025a }
            if (r7 != r4) goto L_0x0231
        L_0x0171:
            f2.b r3 = r10.f15701g     // Catch:{ all -> 0x025a }
            r3.next()     // Catch:{ all -> 0x025a }
            f2.b r3 = r10.f15701g     // Catch:{ all -> 0x025a }
            r3.p()     // Catch:{ all -> 0x025a }
            f2.b r3 = r10.f15701g     // Catch:{ all -> 0x025a }
            r3.A()     // Catch:{ all -> 0x025a }
            f2.b r3 = r10.f15701g     // Catch:{ all -> 0x025a }
            r3.K()     // Catch:{ all -> 0x025a }
            java.lang.String r3 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x025a }
            r4 = 13
            r7 = 0
            if (r2 != r3) goto L_0x01e4
            f2.b r3 = r10.f15701g     // Catch:{ all -> 0x025a }
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x025a }
            boolean r3 = r3.a(r8)     // Catch:{ all -> 0x025a }
            if (r3 != 0) goto L_0x01e4
            f2.b r2 = r10.f15701g     // Catch:{ all -> 0x025a }
            f2.g r3 = r10.f15697c     // Catch:{ all -> 0x025a }
            java.lang.String r2 = r2.o(r3, r5)     // Catch:{ all -> 0x025a }
            com.alibaba.fastjson.parser.ParserConfig r3 = r10.f15698d     // Catch:{ all -> 0x025a }
            java.lang.Class r2 = r3.e(r2, r7)     // Catch:{ all -> 0x025a }
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            boolean r3 = r3.isAssignableFrom(r2)     // Catch:{ all -> 0x025a }
            if (r3 == 0) goto L_0x01c2
            f2.b r2 = r10.f15701g     // Catch:{ all -> 0x025a }
            r2.f(r6)     // Catch:{ all -> 0x025a }
            f2.b r2 = r10.f15701g     // Catch:{ all -> 0x025a }
            int r2 = r2.J()     // Catch:{ all -> 0x025a }
            if (r2 != r4) goto L_0x0229
            f2.b r12 = r10.f15701g     // Catch:{ all -> 0x025a }
            r12.f(r6)     // Catch:{ all -> 0x025a }
            r10.T(r0)
            return r11
        L_0x01c2:
            com.alibaba.fastjson.parser.ParserConfig r11 = r10.f15698d     // Catch:{ all -> 0x025a }
            g2.l r11 = r11.j(r2)     // Catch:{ all -> 0x025a }
            f2.b r1 = r10.f15701g     // Catch:{ all -> 0x025a }
            r1.f(r6)     // Catch:{ all -> 0x025a }
            r1 = 2
            r10.V(r1)     // Catch:{ all -> 0x025a }
            if (r0 == 0) goto L_0x01da
            boolean r1 = r12 instanceof java.lang.Integer     // Catch:{ all -> 0x025a }
            if (r1 != 0) goto L_0x01da
            r10.Q()     // Catch:{ all -> 0x025a }
        L_0x01da:
            java.lang.Object r11 = r11.e(r10, r2, r12)     // Catch:{ all -> 0x025a }
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ all -> 0x025a }
            r10.T(r0)
            return r11
        L_0x01e4:
            f2.b r3 = r10.f15701g     // Catch:{ all -> 0x025a }
            r3.nextToken()     // Catch:{ all -> 0x025a }
            if (r1 == 0) goto L_0x01ee
            r10.T(r0)     // Catch:{ all -> 0x025a }
        L_0x01ee:
            java.lang.reflect.Type r3 = r11.getType(r2)     // Catch:{ all -> 0x025a }
            f2.b r5 = r10.f15701g     // Catch:{ all -> 0x025a }
            int r5 = r5.J()     // Catch:{ all -> 0x025a }
            r6 = 8
            if (r5 != r6) goto L_0x0202
            f2.b r3 = r10.f15701g     // Catch:{ all -> 0x025a }
            r3.nextToken()     // Catch:{ all -> 0x025a }
            goto L_0x0206
        L_0x0202:
            java.lang.Object r7 = r10.M(r3, r2)     // Catch:{ all -> 0x025a }
        L_0x0206:
            r11.b(r2, r7)     // Catch:{ all -> 0x025a }
            r10.R(r0, r7, r2)     // Catch:{ all -> 0x025a }
            r10.T(r0)     // Catch:{ all -> 0x025a }
            f2.b r2 = r10.f15701g     // Catch:{ all -> 0x025a }
            int r2 = r2.J()     // Catch:{ all -> 0x025a }
            r3 = 20
            if (r2 == r3) goto L_0x022d
            r3 = 15
            if (r2 != r3) goto L_0x021e
            goto L_0x022d
        L_0x021e:
            if (r2 != r4) goto L_0x0229
            f2.b r12 = r10.f15701g     // Catch:{ all -> 0x025a }
            r12.nextToken()     // Catch:{ all -> 0x025a }
            r10.T(r0)
            return r11
        L_0x0229:
            int r1 = r1 + 1
            goto L_0x008e
        L_0x022d:
            r10.T(r0)
            return r11
        L_0x0231:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x025a }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x025a }
            r12.<init>()     // Catch:{ all -> 0x025a }
            r12.append(r3)     // Catch:{ all -> 0x025a }
            f2.b r1 = r10.f15701g     // Catch:{ all -> 0x025a }
            int r1 = r1.s()     // Catch:{ all -> 0x025a }
            r12.append(r1)     // Catch:{ all -> 0x025a }
            java.lang.String r1 = ", actual "
            r12.append(r1)     // Catch:{ all -> 0x025a }
            r12.append(r7)     // Catch:{ all -> 0x025a }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x025a }
            r11.<init>(r12)     // Catch:{ all -> 0x025a }
            throw r11     // Catch:{ all -> 0x025a }
        L_0x0254:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x025a }
            r11.<init>(r7)     // Catch:{ all -> 0x025a }
            throw r11     // Catch:{ all -> 0x025a }
        L_0x025a:
            r11 = move-exception
            r10.T(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.a.A(g2.n, java.lang.Object):java.lang.Object");
    }

    public Object B(Object obj) {
        b bVar = this.f15701g;
        int J = bVar.J();
        if (J == 2) {
            Number I = bVar.I();
            bVar.nextToken();
            return I;
        } else if (J == 3) {
            Number M = bVar.M(bVar.a(Feature.UseBigDecimal));
            bVar.nextToken();
            return M;
        } else if (J == 4) {
            String H = bVar.H();
            bVar.f(16);
            if (bVar.a(Feature.AllowISO8601DateFormat)) {
                e eVar = new e(H);
                try {
                    if (eVar.C0()) {
                        return eVar.U().getTime();
                    }
                    eVar.close();
                } finally {
                    eVar.close();
                }
            }
            return H;
        } else if (J == 12) {
            return O(new JSONObject(bVar.a(Feature.OrderedField)), obj);
        } else {
            if (J == 14) {
                JSONArray jSONArray = new JSONArray();
                G(jSONArray, obj);
                return bVar.a(Feature.UseObjectArray) ? jSONArray.toArray() : jSONArray;
            } else if (J != 26) {
                switch (J) {
                    case 6:
                        bVar.nextToken();
                        return Boolean.TRUE;
                    case 7:
                        bVar.nextToken();
                        return Boolean.FALSE;
                    case 8:
                        bVar.nextToken();
                        return null;
                    case 9:
                        bVar.f(18);
                        if (bVar.J() == 18) {
                            bVar.f(10);
                            a(10);
                            long longValue = bVar.I().longValue();
                            a(2);
                            a(11);
                            return new Date(longValue);
                        }
                        throw new JSONException("syntax error");
                    default:
                        switch (J) {
                            case 20:
                                if (bVar.E()) {
                                    return null;
                                }
                                throw new JSONException("unterminated json string, " + bVar.t());
                            case 21:
                                bVar.nextToken();
                                HashSet hashSet = new HashSet();
                                G(hashSet, obj);
                                return hashSet;
                            case 22:
                                bVar.nextToken();
                                TreeSet treeSet = new TreeSet();
                                G(treeSet, obj);
                                return treeSet;
                            case 23:
                                bVar.nextToken();
                                return null;
                            default:
                                throw new JSONException("syntax error, " + bVar.t());
                        }
                }
            } else {
                byte[] j11 = bVar.j();
                bVar.nextToken();
                return j11;
            }
        }
    }

    public void C(Class<?> cls, Collection collection) {
        D(cls, collection);
    }

    public void D(Type type, Collection collection) {
        E(type, collection, (Object) null);
    }

    /* JADX INFO: finally extract failed */
    public void E(Type type, Collection collection, Object obj) {
        l lVar;
        Class<String> cls = String.class;
        int J = this.f15701g.J();
        if (J == 21 || J == 22) {
            this.f15701g.nextToken();
            J = this.f15701g.J();
        }
        if (J == 14) {
            if (Integer.TYPE == type) {
                lVar = IntegerCodec.f14273a;
                this.f15701g.f(2);
            } else if (cls == type) {
                lVar = StringCodec.f14336a;
                this.f15701g.f(4);
            } else {
                lVar = this.f15698d.j(type);
                this.f15701g.f(lVar.b());
            }
            f fVar = this.f15702h;
            S(collection, obj);
            int i11 = 0;
            while (true) {
                try {
                    if (this.f15701g.a(Feature.AllowArbitraryCommas)) {
                        while (this.f15701g.J() == 16) {
                            this.f15701g.nextToken();
                        }
                    }
                    if (this.f15701g.J() == 15) {
                        T(fVar);
                        this.f15701g.f(16);
                        return;
                    }
                    Object obj2 = null;
                    if (Integer.TYPE == type) {
                        collection.add(IntegerCodec.f14273a.e(this, (Type) null, (Object) null));
                    } else if (cls == type) {
                        if (this.f15701g.J() == 4) {
                            obj2 = this.f15701g.H();
                            this.f15701g.f(16);
                        } else {
                            Object z11 = z();
                            if (z11 != null) {
                                obj2 = z11.toString();
                            }
                        }
                        collection.add(obj2);
                    } else {
                        if (this.f15701g.J() == 8) {
                            this.f15701g.nextToken();
                        } else {
                            obj2 = lVar.e(this, type, Integer.valueOf(i11));
                        }
                        collection.add(obj2);
                        g(collection);
                    }
                    if (this.f15701g.J() == 16) {
                        this.f15701g.f(lVar.b());
                    }
                    i11++;
                } catch (Throwable th2) {
                    T(fVar);
                    throw th2;
                }
            }
        } else {
            throw new JSONException("exepct '[', but " + JSONToken.a(J) + ", " + this.f15701g.t());
        }
    }

    public final void F(Collection collection) {
        G(collection, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: com.alibaba.fastjson.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void G(java.util.Collection r10, java.lang.Object r11) {
        /*
            r9 = this;
            f2.b r0 = r9.f15701g
            int r1 = r0.J()
            r2 = 21
            if (r1 == r2) goto L_0x0012
            int r1 = r0.J()
            r2 = 22
            if (r1 != r2) goto L_0x0015
        L_0x0012:
            r0.nextToken()
        L_0x0015:
            int r1 = r0.J()
            r2 = 14
            if (r1 != r2) goto L_0x011a
            r1 = 4
            r0.f(r1)
            f2.f r3 = r9.f15702h
            r9.S(r10, r11)
            r11 = 0
            r4 = r11
        L_0x0028:
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x0115 }
            boolean r5 = r0.a(r5)     // Catch:{ all -> 0x0115 }
            r6 = 16
            if (r5 == 0) goto L_0x003c
        L_0x0032:
            int r5 = r0.J()     // Catch:{ all -> 0x0115 }
            if (r5 != r6) goto L_0x003c
            r0.nextToken()     // Catch:{ all -> 0x0115 }
            goto L_0x0032
        L_0x003c:
            int r5 = r0.J()     // Catch:{ all -> 0x0115 }
            r7 = 2
            r8 = 0
            if (r5 == r7) goto L_0x00fb
            r7 = 3
            if (r5 == r7) goto L_0x00e4
            if (r5 == r1) goto L_0x00bd
            r7 = 6
            if (r5 == r7) goto L_0x00b7
            r7 = 7
            if (r5 == r7) goto L_0x00b1
            r7 = 8
            if (r5 == r7) goto L_0x00ad
            r7 = 12
            if (r5 == r7) goto L_0x0099
            r7 = 20
            if (r5 == r7) goto L_0x0091
            r7 = 23
            if (r5 == r7) goto L_0x008c
            if (r5 == r2) goto L_0x0072
            r7 = 15
            if (r5 == r7) goto L_0x006b
            java.lang.Object r8 = r9.z()     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x006b:
            r0.f(r6)     // Catch:{ all -> 0x0115 }
            r9.T(r3)
            return
        L_0x0072:
            com.alibaba.fastjson.JSONArray r8 = new com.alibaba.fastjson.JSONArray     // Catch:{ all -> 0x0115 }
            r8.<init>()     // Catch:{ all -> 0x0115 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0115 }
            r9.G(r8, r5)     // Catch:{ all -> 0x0115 }
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.UseObjectArray     // Catch:{ all -> 0x0115 }
            boolean r5 = r0.a(r5)     // Catch:{ all -> 0x0115 }
            if (r5 == 0) goto L_0x0102
            java.lang.Object[] r8 = r8.toArray()     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x008c:
            r0.f(r1)     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x0091:
            com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0115 }
            java.lang.String r11 = "unclosed jsonArray"
            r10.<init>(r11)     // Catch:{ all -> 0x0115 }
            throw r10     // Catch:{ all -> 0x0115 }
        L_0x0099:
            com.alibaba.fastjson.JSONObject r5 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x0115 }
            com.alibaba.fastjson.parser.Feature r7 = com.alibaba.fastjson.parser.Feature.OrderedField     // Catch:{ all -> 0x0115 }
            boolean r7 = r0.a(r7)     // Catch:{ all -> 0x0115 }
            r5.<init>((boolean) r7)     // Catch:{ all -> 0x0115 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0115 }
            java.lang.Object r8 = r9.O(r5, r7)     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x00ad:
            r0.f(r1)     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x00b1:
            java.lang.Boolean r8 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0115 }
            r0.f(r6)     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x00b7:
            java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0115 }
            r0.f(r6)     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x00bd:
            java.lang.String r8 = r0.H()     // Catch:{ all -> 0x0115 }
            r0.f(r6)     // Catch:{ all -> 0x0115 }
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat     // Catch:{ all -> 0x0115 }
            boolean r5 = r0.a(r5)     // Catch:{ all -> 0x0115 }
            if (r5 == 0) goto L_0x0102
            f2.e r5 = new f2.e     // Catch:{ all -> 0x0115 }
            r5.<init>(r8)     // Catch:{ all -> 0x0115 }
            boolean r7 = r5.C0()     // Catch:{ all -> 0x0115 }
            if (r7 == 0) goto L_0x00e0
            java.util.Calendar r7 = r5.U()     // Catch:{ all -> 0x0115 }
            java.util.Date r7 = r7.getTime()     // Catch:{ all -> 0x0115 }
            r8 = r7
        L_0x00e0:
            r5.close()     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x00e4:
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.UseBigDecimal     // Catch:{ all -> 0x0115 }
            boolean r5 = r0.a(r5)     // Catch:{ all -> 0x0115 }
            if (r5 == 0) goto L_0x00f2
            r5 = 1
            java.lang.Number r5 = r0.M(r5)     // Catch:{ all -> 0x0115 }
            goto L_0x00f6
        L_0x00f2:
            java.lang.Number r5 = r0.M(r11)     // Catch:{ all -> 0x0115 }
        L_0x00f6:
            r8 = r5
            r0.f(r6)     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x00fb:
            java.lang.Number r8 = r0.I()     // Catch:{ all -> 0x0115 }
            r0.f(r6)     // Catch:{ all -> 0x0115 }
        L_0x0102:
            r10.add(r8)     // Catch:{ all -> 0x0115 }
            r9.g(r10)     // Catch:{ all -> 0x0115 }
            int r5 = r0.J()     // Catch:{ all -> 0x0115 }
            if (r5 != r6) goto L_0x0111
            r0.f(r1)     // Catch:{ all -> 0x0115 }
        L_0x0111:
            int r4 = r4 + 1
            goto L_0x0028
        L_0x0115:
            r10 = move-exception
            r9.T(r3)
            throw r10
        L_0x011a:
            com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "syntax error, expect [, actual "
            r11.append(r1)
            int r1 = r0.J()
            java.lang.String r1 = com.alibaba.fastjson.parser.JSONToken.a(r1)
            r11.append(r1)
            java.lang.String r1 = ", pos "
            r11.append(r1)
            int r0 = r0.s()
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.a.G(java.util.Collection, java.lang.Object):void");
    }

    public Object[] H(Type[] typeArr) {
        Object obj;
        boolean z11;
        Class<?> cls;
        Type[] typeArr2 = typeArr;
        int i11 = 8;
        if (this.f15701g.J() == 8) {
            this.f15701g.f(16);
            return null;
        }
        int i12 = 14;
        if (this.f15701g.J() == 14) {
            Object[] objArr = new Object[typeArr2.length];
            if (typeArr2.length == 0) {
                this.f15701g.f(15);
                if (this.f15701g.J() == 15) {
                    this.f15701g.f(16);
                    return new Object[0];
                }
                throw new JSONException("syntax error");
            }
            this.f15701g.f(2);
            int i13 = 0;
            while (i13 < typeArr2.length) {
                if (this.f15701g.J() == i11) {
                    this.f15701g.f(16);
                    obj = null;
                } else {
                    Type type = typeArr2[i13];
                    if (type == Integer.TYPE || type == Integer.class) {
                        if (this.f15701g.J() == 2) {
                            obj = Integer.valueOf(this.f15701g.w());
                            this.f15701g.f(16);
                        } else {
                            obj = TypeUtils.f(z(), type, this.f15698d);
                        }
                    } else if (type != String.class) {
                        if (i13 != typeArr2.length - 1 || !(type instanceof Class)) {
                            cls = null;
                            z11 = false;
                        } else {
                            Class cls2 = (Class) type;
                            z11 = cls2.isArray();
                            cls = cls2.getComponentType();
                        }
                        if (!z11 || this.f15701g.J() == i12) {
                            obj = this.f15698d.j(type).e(this, type, (Object) null);
                        } else {
                            ArrayList arrayList = new ArrayList();
                            l j11 = this.f15698d.j(cls);
                            int b11 = j11.b();
                            if (this.f15701g.J() != 15) {
                                while (true) {
                                    arrayList.add(j11.e(this, type, (Object) null));
                                    if (this.f15701g.J() != 16) {
                                        break;
                                    }
                                    this.f15701g.f(b11);
                                }
                                if (this.f15701g.J() != 15) {
                                    throw new JSONException("syntax error :" + JSONToken.a(this.f15701g.J()));
                                }
                            }
                            obj = TypeUtils.f(arrayList, type, this.f15698d);
                        }
                    } else if (this.f15701g.J() == 4) {
                        obj = this.f15701g.H();
                        this.f15701g.f(16);
                    } else {
                        obj = TypeUtils.f(z(), type, this.f15698d);
                    }
                }
                objArr[i13] = obj;
                if (this.f15701g.J() == 15) {
                    break;
                } else if (this.f15701g.J() == 16) {
                    if (i13 == typeArr2.length - 1) {
                        this.f15701g.f(15);
                    } else {
                        this.f15701g.f(2);
                    }
                    i13++;
                    i11 = 8;
                    i12 = 14;
                } else {
                    throw new JSONException("syntax error :" + JSONToken.a(this.f15701g.J()));
                }
            }
            if (this.f15701g.J() == 15) {
                this.f15701g.f(16);
                return objArr;
            }
            throw new JSONException("syntax error");
        }
        throw new JSONException("syntax error : " + this.f15701g.b());
    }

    public void I(Object obj, String str) {
        Object obj2;
        this.f15701g.B();
        List<h> list = this.f15707m;
        Type type = null;
        if (list != null) {
            for (h c11 : list) {
                type = c11.c(obj, str);
            }
        }
        if (type == null) {
            obj2 = z();
        } else {
            obj2 = L(type);
        }
        if (obj instanceof f) {
            ((f) obj).a(str, obj2);
            return;
        }
        List<g> list2 = this.f15708n;
        if (list2 != null) {
            for (g a11 : list2) {
                a11.a(obj, str, obj2);
            }
        }
        if (this.f15706l == 1) {
            this.f15706l = 0;
        }
    }

    public JSONObject J() {
        return (JSONObject) N(new JSONObject(this.f15701g.a(Feature.OrderedField)));
    }

    public <T> T K(Class<T> cls) {
        return M(cls, (Object) null);
    }

    public <T> T L(Type type) {
        return M(type, (Object) null);
    }

    public <T> T M(Type type, Object obj) {
        int J = this.f15701g.J();
        if (J == 8) {
            this.f15701g.nextToken();
            return null;
        }
        if (J == 4) {
            if (type == byte[].class) {
                Object j11 = this.f15701g.j();
                this.f15701g.nextToken();
                return j11;
            } else if (type == char[].class) {
                String H = this.f15701g.H();
                this.f15701g.nextToken();
                return H.toCharArray();
            }
        }
        try {
            return this.f15698d.j(type).e(this, type, obj);
        } catch (JSONException e11) {
            throw e11;
        } catch (Throwable th2) {
            throw new JSONException(th2.getMessage(), th2);
        }
    }

    public Object N(Map map) {
        return O(map, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: com.alibaba.fastjson.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v39, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v24, resolved type: com.alibaba.fastjson.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v25, resolved type: com.alibaba.fastjson.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v42, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v43, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v44, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v45, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v46, resolved type: java.util.Date} */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x020d, code lost:
        r5.f(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0218, code lost:
        if (r5.J() != 13) goto L_0x0259;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x021a, code lost:
        r5.f(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:?, code lost:
        r0 = r1.f15698d.j(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0225, code lost:
        if ((r0 instanceof g2.k) == false) goto L_0x022e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0227, code lost:
        r0 = ((g2.k) r0).d(r1, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x022e, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x022f, code lost:
        if (r0 != null) goto L_0x024c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0233, code lost:
        if (r8 != java.lang.Cloneable.class) goto L_0x023b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0235, code lost:
        r0 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0241, code lost:
        if ("java.util.Collections$EmptyMap".equals(r7) == false) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0243, code lost:
        r0 = java.util.Collections.emptyMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0248, code lost:
        r0 = r8.newInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x024c, code lost:
        T(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x024f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0259, code lost:
        V(2);
        r3 = r1.f15702h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x025f, code lost:
        if (r3 == null) goto L_0x026e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0263, code lost:
        if ((r2 instanceof java.lang.Integer) != false) goto L_0x026e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0269, code lost:
        if ((r3.f15741c instanceof java.lang.Integer) != false) goto L_0x026e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x026b, code lost:
        Q();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0272, code lost:
        if (r17.size() <= 0) goto L_0x0281;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0274, code lost:
        r0 = com.alibaba.fastjson.util.TypeUtils.d(r0, r8, r1.f15698d);
        P(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x027d, code lost:
        T(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0280, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:?, code lost:
        r0 = r1.f15698d.j(r8).e(r1, r8, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x028b, code lost:
        T(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x028e, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x029e, code lost:
        r5.f(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02a6, code lost:
        if (r5.J() != 4) goto L_0x032d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02a8, code lost:
        r0 = r5.H();
        r5.f(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x02b7, code lost:
        if (com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText.TIM_MENTION_TAG.equals(r0) == false) goto L_0x02cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x02b9, code lost:
        r0 = r1.f15702h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x02bb, code lost:
        if (r0 == null) goto L_0x0315;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x02bd, code lost:
        r2 = r0.f15739a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x02c1, code lost:
        if ((r2 instanceof java.lang.Object[]) != false) goto L_0x02db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02c5, code lost:
        if ((r2 instanceof java.util.Collection) == false) goto L_0x02c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x02c8, code lost:
        r0 = r0.f15740b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x02ca, code lost:
        if (r0 == null) goto L_0x0315;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02cc, code lost:
        r7 = r0.f15739a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02d5, code lost:
        if ("..".equals(r0) == false) goto L_0x02e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02d7, code lost:
        r2 = r6.f15739a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x02d9, code lost:
        if (r2 == null) goto L_0x02dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x02db, code lost:
        r7 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02dd, code lost:
        f(new f2.a.C0078a(r6, r0));
        V(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x02ef, code lost:
        if ("$".equals(r0) == false) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x02f1, code lost:
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x02f2, code lost:
        r3 = r2.f15740b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x02f4, code lost:
        if (r3 == null) goto L_0x02f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x02f6, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x02f8, code lost:
        r3 = r2.f15739a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x02fa, code lost:
        if (r3 == null) goto L_0x02fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x02fc, code lost:
        r7 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x02fe, code lost:
        f(new f2.a.C0078a(r2, r0));
        V(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x030a, code lost:
        f(new f2.a.C0078a(r6, r0));
        V(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0315, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x031c, code lost:
        if (r5.J() != 13) goto L_0x0327;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x031e, code lost:
        r5.f(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x0323, code lost:
        T(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0326, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x032c, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x034b, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.a(r5.J()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x03df, code lost:
        if (r9 != '}') goto L_0x03f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x03e1, code lost:
        r5.next();
        r5.K();
        r5.nextToken();
        S(r8, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x03ed, code lost:
        T(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x03f0, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0411, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, position at " + r5.s() + ", name " + r12);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01f0 A[Catch:{ Exception -> 0x0250, NumberFormatException -> 0x016b, all -> 0x056d }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x04a5 A[Catch:{ Exception -> 0x0250, NumberFormatException -> 0x016b, all -> 0x056d }] */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x04be A[Catch:{ Exception -> 0x0250, NumberFormatException -> 0x016b, all -> 0x056d }] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x04c6 A[Catch:{ Exception -> 0x0250, NumberFormatException -> 0x016b, all -> 0x056d }] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x04cb A[Catch:{ Exception -> 0x0250, NumberFormatException -> 0x016b, all -> 0x056d }] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x04e0 A[SYNTHETIC, Splitter:B:298:0x04e0] */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x04d6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01d7 A[Catch:{ Exception -> 0x0250, NumberFormatException -> 0x016b, all -> 0x056d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object O(java.util.Map r17, java.lang.Object r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            java.lang.Class<java.lang.Integer> r3 = java.lang.Integer.class
            java.lang.String r4 = "parse number key error"
            f2.b r5 = r1.f15701g
            int r6 = r5.J()
            r7 = 0
            r8 = 8
            if (r6 != r8) goto L_0x0019
            r5.nextToken()
            return r7
        L_0x0019:
            int r6 = r5.J()
            r8 = 13
            if (r6 != r8) goto L_0x0025
            r5.nextToken()
            return r0
        L_0x0025:
            int r6 = r5.J()
            r9 = 12
            r10 = 16
            if (r6 == r9) goto L_0x005d
            int r6 = r5.J()
            if (r6 != r10) goto L_0x0036
            goto L_0x005d
        L_0x0036:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "syntax error, expect {, actual "
            r2.append(r3)
            java.lang.String r3 = r5.b()
            r2.append(r3)
            java.lang.String r3 = ", "
            r2.append(r3)
            java.lang.String r3 = r5.t()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x005d:
            f2.f r6 = r1.f15702h
            r11 = 0
        L_0x0060:
            r5.p()     // Catch:{ all -> 0x056d }
            char r12 = r5.A()     // Catch:{ all -> 0x056d }
            com.alibaba.fastjson.parser.Feature r13 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x056d }
            boolean r13 = r5.a(r13)     // Catch:{ all -> 0x056d }
            r14 = 44
            if (r13 == 0) goto L_0x007e
        L_0x0071:
            if (r12 != r14) goto L_0x007e
            r5.next()     // Catch:{ all -> 0x056d }
            r5.p()     // Catch:{ all -> 0x056d }
            char r12 = r5.A()     // Catch:{ all -> 0x056d }
            goto L_0x0071
        L_0x007e:
            r7 = 125(0x7d, float:1.75E-43)
            java.lang.String r13 = ", name "
            java.lang.String r15 = "expect ':' at "
            r8 = 58
            r9 = 34
            java.lang.String r10 = "syntax error"
            r14 = 1
            if (r12 != r9) goto L_0x00be
            f2.g r12 = r1.f15697c     // Catch:{ all -> 0x056d }
            java.lang.String r12 = r5.o(r12, r9)     // Catch:{ all -> 0x056d }
            r5.p()     // Catch:{ all -> 0x056d }
            char r9 = r5.A()     // Catch:{ all -> 0x056d }
            if (r9 != r8) goto L_0x009f
        L_0x009c:
            r8 = 0
            goto L_0x01d5
        L_0x009f:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x056d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x056d }
            r2.<init>()     // Catch:{ all -> 0x056d }
            r2.append(r15)     // Catch:{ all -> 0x056d }
            int r3 = r5.s()     // Catch:{ all -> 0x056d }
            r2.append(r3)     // Catch:{ all -> 0x056d }
            r2.append(r13)     // Catch:{ all -> 0x056d }
            r2.append(r12)     // Catch:{ all -> 0x056d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x056d }
            r0.<init>(r2)     // Catch:{ all -> 0x056d }
            throw r0     // Catch:{ all -> 0x056d }
        L_0x00be:
            if (r12 != r7) goto L_0x00e4
            r5.next()     // Catch:{ all -> 0x056d }
            r5.K()     // Catch:{ all -> 0x056d }
            r5.nextToken()     // Catch:{ all -> 0x056d }
            if (r11 != 0) goto L_0x00e0
            f2.f r3 = r1.f15702h     // Catch:{ all -> 0x056d }
            if (r3 == 0) goto L_0x00d9
            java.lang.Object r4 = r3.f15741c     // Catch:{ all -> 0x056d }
            if (r2 != r4) goto L_0x00d9
            java.lang.Object r4 = r3.f15739a     // Catch:{ all -> 0x056d }
            if (r0 != r4) goto L_0x00d9
            r6 = r3
            goto L_0x00e0
        L_0x00d9:
            f2.f r2 = r16.S(r17, r18)     // Catch:{ all -> 0x056d }
            if (r6 != 0) goto L_0x00e0
            r6 = r2
        L_0x00e0:
            r1.T(r6)
            return r0
        L_0x00e4:
            r9 = 39
            if (r12 != r9) goto L_0x011f
            com.alibaba.fastjson.parser.Feature r12 = com.alibaba.fastjson.parser.Feature.AllowSingleQuotes     // Catch:{ all -> 0x056d }
            boolean r12 = r5.a(r12)     // Catch:{ all -> 0x056d }
            if (r12 == 0) goto L_0x0119
            f2.g r12 = r1.f15697c     // Catch:{ all -> 0x056d }
            java.lang.String r12 = r5.o(r12, r9)     // Catch:{ all -> 0x056d }
            r5.p()     // Catch:{ all -> 0x056d }
            char r9 = r5.A()     // Catch:{ all -> 0x056d }
            if (r9 != r8) goto L_0x0100
            goto L_0x009c
        L_0x0100:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x056d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x056d }
            r2.<init>()     // Catch:{ all -> 0x056d }
            r2.append(r15)     // Catch:{ all -> 0x056d }
            int r3 = r5.s()     // Catch:{ all -> 0x056d }
            r2.append(r3)     // Catch:{ all -> 0x056d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x056d }
            r0.<init>(r2)     // Catch:{ all -> 0x056d }
            throw r0     // Catch:{ all -> 0x056d }
        L_0x0119:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x056d }
            r0.<init>(r10)     // Catch:{ all -> 0x056d }
            throw r0     // Catch:{ all -> 0x056d }
        L_0x011f:
            r9 = 26
            if (r12 == r9) goto L_0x0567
            r9 = 44
            if (r12 == r9) goto L_0x0561
            r9 = 48
            if (r12 < r9) goto L_0x012f
            r9 = 57
            if (r12 <= r9) goto L_0x0133
        L_0x012f:
            r9 = 45
            if (r12 != r9) goto L_0x0184
        L_0x0133:
            r5.K()     // Catch:{ all -> 0x056d }
            r5.x()     // Catch:{ all -> 0x056d }
            int r9 = r5.J()     // Catch:{ NumberFormatException -> 0x016b }
            r12 = 2
            if (r9 != r12) goto L_0x0145
            java.lang.Number r9 = r5.I()     // Catch:{ NumberFormatException -> 0x016b }
            goto L_0x0149
        L_0x0145:
            java.lang.Number r9 = r5.M(r14)     // Catch:{ NumberFormatException -> 0x016b }
        L_0x0149:
            r12 = r9
            char r9 = r5.A()     // Catch:{ all -> 0x056d }
            if (r9 != r8) goto L_0x0152
            goto L_0x009c
        L_0x0152:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x056d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x056d }
            r2.<init>()     // Catch:{ all -> 0x056d }
            r2.append(r4)     // Catch:{ all -> 0x056d }
            java.lang.String r3 = r5.t()     // Catch:{ all -> 0x056d }
            r2.append(r3)     // Catch:{ all -> 0x056d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x056d }
            r0.<init>(r2)     // Catch:{ all -> 0x056d }
            throw r0     // Catch:{ all -> 0x056d }
        L_0x016b:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x056d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x056d }
            r2.<init>()     // Catch:{ all -> 0x056d }
            r2.append(r4)     // Catch:{ all -> 0x056d }
            java.lang.String r3 = r5.t()     // Catch:{ all -> 0x056d }
            r2.append(r3)     // Catch:{ all -> 0x056d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x056d }
            r0.<init>(r2)     // Catch:{ all -> 0x056d }
            throw r0     // Catch:{ all -> 0x056d }
        L_0x0184:
            r9 = 123(0x7b, float:1.72E-43)
            if (r12 == r9) goto L_0x01cd
            r9 = 91
            if (r12 != r9) goto L_0x018d
            goto L_0x01cd
        L_0x018d:
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.AllowUnQuotedFieldNames     // Catch:{ all -> 0x056d }
            boolean r9 = r5.a(r9)     // Catch:{ all -> 0x056d }
            if (r9 == 0) goto L_0x01c7
            f2.g r9 = r1.f15697c     // Catch:{ all -> 0x056d }
            java.lang.String r12 = r5.C(r9)     // Catch:{ all -> 0x056d }
            r5.p()     // Catch:{ all -> 0x056d }
            char r9 = r5.A()     // Catch:{ all -> 0x056d }
            if (r9 != r8) goto L_0x01a6
            goto L_0x009c
        L_0x01a6:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x056d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x056d }
            r2.<init>()     // Catch:{ all -> 0x056d }
            r2.append(r15)     // Catch:{ all -> 0x056d }
            int r3 = r5.s()     // Catch:{ all -> 0x056d }
            r2.append(r3)     // Catch:{ all -> 0x056d }
            java.lang.String r3 = ", actual "
            r2.append(r3)     // Catch:{ all -> 0x056d }
            r2.append(r9)     // Catch:{ all -> 0x056d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x056d }
            r0.<init>(r2)     // Catch:{ all -> 0x056d }
            throw r0     // Catch:{ all -> 0x056d }
        L_0x01c7:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x056d }
            r0.<init>(r10)     // Catch:{ all -> 0x056d }
            throw r0     // Catch:{ all -> 0x056d }
        L_0x01cd:
            r5.nextToken()     // Catch:{ all -> 0x056d }
            java.lang.Object r12 = r16.z()     // Catch:{ all -> 0x056d }
            r8 = r14
        L_0x01d5:
            if (r8 != 0) goto L_0x01dd
            r5.next()     // Catch:{ all -> 0x056d }
            r5.p()     // Catch:{ all -> 0x056d }
        L_0x01dd:
            char r8 = r5.A()     // Catch:{ all -> 0x056d }
            r5.K()     // Catch:{ all -> 0x056d }
            java.lang.String r9 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x056d }
            if (r12 != r9) goto L_0x028f
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x056d }
            boolean r9 = r5.a(r9)     // Catch:{ all -> 0x056d }
            if (r9 != 0) goto L_0x028f
            f2.g r7 = r1.f15697c     // Catch:{ all -> 0x056d }
            r8 = 34
            java.lang.String r7 = r5.o(r7, r8)     // Catch:{ all -> 0x056d }
            com.alibaba.fastjson.parser.ParserConfig r8 = r1.f15698d     // Catch:{ all -> 0x056d }
            r9 = 0
            java.lang.Class r8 = r8.e(r7, r9)     // Catch:{ all -> 0x056d }
            if (r8 != 0) goto L_0x020d
            java.lang.String r8 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x056d }
            r0.put(r8, r7)     // Catch:{ all -> 0x056d }
            r7 = r9
            r8 = 13
            r10 = 16
            goto L_0x0060
        L_0x020d:
            r3 = 16
            r5.f(r3)     // Catch:{ all -> 0x056d }
            int r4 = r5.J()     // Catch:{ all -> 0x056d }
            r10 = 13
            if (r4 != r10) goto L_0x0259
            r5.f(r3)     // Catch:{ all -> 0x056d }
            com.alibaba.fastjson.parser.ParserConfig r0 = r1.f15698d     // Catch:{ Exception -> 0x0250 }
            g2.l r0 = r0.j(r8)     // Catch:{ Exception -> 0x0250 }
            boolean r2 = r0 instanceof g2.k     // Catch:{ Exception -> 0x0250 }
            if (r2 == 0) goto L_0x022e
            g2.k r0 = (g2.k) r0     // Catch:{ Exception -> 0x0250 }
            java.lang.Object r0 = r0.d(r1, r8)     // Catch:{ Exception -> 0x0250 }
            goto L_0x022f
        L_0x022e:
            r0 = r9
        L_0x022f:
            if (r0 != 0) goto L_0x024c
            java.lang.Class<java.lang.Cloneable> r0 = java.lang.Cloneable.class
            if (r8 != r0) goto L_0x023b
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0250 }
            r0.<init>()     // Catch:{ Exception -> 0x0250 }
            goto L_0x024c
        L_0x023b:
            java.lang.String r0 = "java.util.Collections$EmptyMap"
            boolean r0 = r0.equals(r7)     // Catch:{ Exception -> 0x0250 }
            if (r0 == 0) goto L_0x0248
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ Exception -> 0x0250 }
            goto L_0x024c
        L_0x0248:
            java.lang.Object r0 = r8.newInstance()     // Catch:{ Exception -> 0x0250 }
        L_0x024c:
            r1.T(r6)
            return r0
        L_0x0250:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x056d }
            java.lang.String r3 = "create instance error"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x056d }
            throw r2     // Catch:{ all -> 0x056d }
        L_0x0259:
            r3 = 2
            r1.V(r3)     // Catch:{ all -> 0x056d }
            f2.f r3 = r1.f15702h     // Catch:{ all -> 0x056d }
            if (r3 == 0) goto L_0x026e
            boolean r4 = r2 instanceof java.lang.Integer     // Catch:{ all -> 0x056d }
            if (r4 != 0) goto L_0x026e
            java.lang.Object r3 = r3.f15741c     // Catch:{ all -> 0x056d }
            boolean r3 = r3 instanceof java.lang.Integer     // Catch:{ all -> 0x056d }
            if (r3 != 0) goto L_0x026e
            r16.Q()     // Catch:{ all -> 0x056d }
        L_0x026e:
            int r3 = r17.size()     // Catch:{ all -> 0x056d }
            if (r3 <= 0) goto L_0x0281
            com.alibaba.fastjson.parser.ParserConfig r2 = r1.f15698d     // Catch:{ all -> 0x056d }
            java.lang.Object r0 = com.alibaba.fastjson.util.TypeUtils.d(r0, r8, r2)     // Catch:{ all -> 0x056d }
            r1.P(r0)     // Catch:{ all -> 0x056d }
            r1.T(r6)
            return r0
        L_0x0281:
            com.alibaba.fastjson.parser.ParserConfig r0 = r1.f15698d     // Catch:{ all -> 0x056d }
            g2.l r0 = r0.j(r8)     // Catch:{ all -> 0x056d }
            java.lang.Object r0 = r0.e(r1, r8, r2)     // Catch:{ all -> 0x056d }
            r1.T(r6)
            return r0
        L_0x028f:
            r9 = 0
            java.lang.String r15 = "$ref"
            if (r12 != r15) goto L_0x034c
            if (r6 == 0) goto L_0x034c
            com.alibaba.fastjson.parser.Feature r15 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x056d }
            boolean r15 = r5.a(r15)     // Catch:{ all -> 0x056d }
            if (r15 != 0) goto L_0x034c
            r0 = 4
            r5.f(r0)     // Catch:{ all -> 0x056d }
            int r2 = r5.J()     // Catch:{ all -> 0x056d }
            if (r2 != r0) goto L_0x032d
            java.lang.String r0 = r5.H()     // Catch:{ all -> 0x056d }
            r2 = 13
            r5.f(r2)     // Catch:{ all -> 0x056d }
            java.lang.String r2 = "@"
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x056d }
            if (r2 == 0) goto L_0x02cf
            f2.f r0 = r1.f15702h     // Catch:{ all -> 0x056d }
            if (r0 == 0) goto L_0x0315
            java.lang.Object r2 = r0.f15739a     // Catch:{ all -> 0x056d }
            boolean r3 = r2 instanceof java.lang.Object[]     // Catch:{ all -> 0x056d }
            if (r3 != 0) goto L_0x02db
            boolean r3 = r2 instanceof java.util.Collection     // Catch:{ all -> 0x056d }
            if (r3 == 0) goto L_0x02c8
            goto L_0x02db
        L_0x02c8:
            f2.f r0 = r0.f15740b     // Catch:{ all -> 0x056d }
            if (r0 == 0) goto L_0x0315
            java.lang.Object r7 = r0.f15739a     // Catch:{ all -> 0x056d }
            goto L_0x0316
        L_0x02cf:
            java.lang.String r2 = ".."
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x056d }
            if (r2 == 0) goto L_0x02e9
            java.lang.Object r2 = r6.f15739a     // Catch:{ all -> 0x056d }
            if (r2 == 0) goto L_0x02dd
        L_0x02db:
            r7 = r2
            goto L_0x0316
        L_0x02dd:
            f2.a$a r2 = new f2.a$a     // Catch:{ all -> 0x056d }
            r2.<init>(r6, r0)     // Catch:{ all -> 0x056d }
            r1.f(r2)     // Catch:{ all -> 0x056d }
            r1.V(r14)     // Catch:{ all -> 0x056d }
            goto L_0x0315
        L_0x02e9:
            java.lang.String r2 = "$"
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x056d }
            if (r2 == 0) goto L_0x030a
            r2 = r6
        L_0x02f2:
            f2.f r3 = r2.f15740b     // Catch:{ all -> 0x056d }
            if (r3 == 0) goto L_0x02f8
            r2 = r3
            goto L_0x02f2
        L_0x02f8:
            java.lang.Object r3 = r2.f15739a     // Catch:{ all -> 0x056d }
            if (r3 == 0) goto L_0x02fe
            r7 = r3
            goto L_0x0316
        L_0x02fe:
            f2.a$a r3 = new f2.a$a     // Catch:{ all -> 0x056d }
            r3.<init>(r2, r0)     // Catch:{ all -> 0x056d }
            r1.f(r3)     // Catch:{ all -> 0x056d }
            r1.V(r14)     // Catch:{ all -> 0x056d }
            goto L_0x0315
        L_0x030a:
            f2.a$a r2 = new f2.a$a     // Catch:{ all -> 0x056d }
            r2.<init>(r6, r0)     // Catch:{ all -> 0x056d }
            r1.f(r2)     // Catch:{ all -> 0x056d }
            r1.V(r14)     // Catch:{ all -> 0x056d }
        L_0x0315:
            r7 = r9
        L_0x0316:
            int r0 = r5.J()     // Catch:{ all -> 0x056d }
            r2 = 13
            if (r0 != r2) goto L_0x0327
            r0 = 16
            r5.f(r0)     // Catch:{ all -> 0x056d }
            r1.T(r6)
            return r7
        L_0x0327:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x056d }
            r0.<init>(r10)     // Catch:{ all -> 0x056d }
            throw r0     // Catch:{ all -> 0x056d }
        L_0x032d:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x056d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x056d }
            r2.<init>()     // Catch:{ all -> 0x056d }
            java.lang.String r3 = "illegal ref, "
            r2.append(r3)     // Catch:{ all -> 0x056d }
            int r3 = r5.J()     // Catch:{ all -> 0x056d }
            java.lang.String r3 = com.alibaba.fastjson.parser.JSONToken.a(r3)     // Catch:{ all -> 0x056d }
            r2.append(r3)     // Catch:{ all -> 0x056d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x056d }
            r0.<init>(r2)     // Catch:{ all -> 0x056d }
            throw r0     // Catch:{ all -> 0x056d }
        L_0x034c:
            if (r11 != 0) goto L_0x0364
            f2.f r15 = r1.f15702h     // Catch:{ all -> 0x056d }
            if (r15 == 0) goto L_0x035c
            java.lang.Object r9 = r15.f15741c     // Catch:{ all -> 0x056d }
            if (r2 != r9) goto L_0x035c
            java.lang.Object r9 = r15.f15739a     // Catch:{ all -> 0x056d }
            if (r0 != r9) goto L_0x035c
            r6 = r15
            goto L_0x0364
        L_0x035c:
            f2.f r9 = r16.S(r17, r18)     // Catch:{ all -> 0x056d }
            if (r6 != 0) goto L_0x0363
            r6 = r9
        L_0x0363:
            r11 = r14
        L_0x0364:
            java.lang.Class r9 = r17.getClass()     // Catch:{ all -> 0x056d }
            java.lang.Class<com.alibaba.fastjson.JSONObject> r15 = com.alibaba.fastjson.JSONObject.class
            if (r9 != r15) goto L_0x0376
            if (r12 != 0) goto L_0x0371
            java.lang.String r9 = "null"
            goto L_0x0375
        L_0x0371:
            java.lang.String r9 = r12.toString()     // Catch:{ all -> 0x056d }
        L_0x0375:
            r12 = r9
        L_0x0376:
            r9 = 34
            if (r8 != r9) goto L_0x03a3
            r5.e()     // Catch:{ all -> 0x056d }
            java.lang.String r8 = r5.H()     // Catch:{ all -> 0x056d }
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat     // Catch:{ all -> 0x056d }
            boolean r9 = r5.a(r9)     // Catch:{ all -> 0x056d }
            if (r9 == 0) goto L_0x039f
            f2.e r9 = new f2.e     // Catch:{ all -> 0x056d }
            r9.<init>(r8)     // Catch:{ all -> 0x056d }
            boolean r10 = r9.C0()     // Catch:{ all -> 0x056d }
            if (r10 == 0) goto L_0x039c
            java.util.Calendar r8 = r9.U()     // Catch:{ all -> 0x056d }
            java.util.Date r8 = r8.getTime()     // Catch:{ all -> 0x056d }
        L_0x039c:
            r9.close()     // Catch:{ all -> 0x056d }
        L_0x039f:
            r0.put(r12, r8)     // Catch:{ all -> 0x056d }
            goto L_0x03cb
        L_0x03a3:
            r9 = 48
            if (r8 < r9) goto L_0x03ab
            r9 = 57
            if (r8 <= r9) goto L_0x03af
        L_0x03ab:
            r9 = 45
            if (r8 != r9) goto L_0x0412
        L_0x03af:
            r5.x()     // Catch:{ all -> 0x056d }
            int r8 = r5.J()     // Catch:{ all -> 0x056d }
            r9 = 2
            if (r8 != r9) goto L_0x03be
            java.lang.Number r8 = r5.I()     // Catch:{ all -> 0x056d }
            goto L_0x03c8
        L_0x03be:
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.UseBigDecimal     // Catch:{ all -> 0x056d }
            boolean r8 = r5.a(r8)     // Catch:{ all -> 0x056d }
            java.lang.Number r8 = r5.M(r8)     // Catch:{ all -> 0x056d }
        L_0x03c8:
            r0.put(r12, r8)     // Catch:{ all -> 0x056d }
        L_0x03cb:
            r5.p()     // Catch:{ all -> 0x056d }
            char r9 = r5.A()     // Catch:{ all -> 0x056d }
            r10 = 44
            if (r9 != r10) goto L_0x03df
            r5.next()     // Catch:{ all -> 0x056d }
        L_0x03d9:
            r8 = 13
            r9 = 16
            goto L_0x053c
        L_0x03df:
            if (r9 != r7) goto L_0x03f1
            r5.next()     // Catch:{ all -> 0x056d }
            r5.K()     // Catch:{ all -> 0x056d }
            r5.nextToken()     // Catch:{ all -> 0x056d }
            r1.S(r8, r12)     // Catch:{ all -> 0x056d }
            r1.T(r6)
            return r0
        L_0x03f1:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x056d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x056d }
            r2.<init>()     // Catch:{ all -> 0x056d }
            java.lang.String r3 = "syntax error, position at "
            r2.append(r3)     // Catch:{ all -> 0x056d }
            int r3 = r5.s()     // Catch:{ all -> 0x056d }
            r2.append(r3)     // Catch:{ all -> 0x056d }
            r2.append(r13)     // Catch:{ all -> 0x056d }
            r2.append(r12)     // Catch:{ all -> 0x056d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x056d }
            r0.<init>(r2)     // Catch:{ all -> 0x056d }
            throw r0     // Catch:{ all -> 0x056d }
        L_0x0412:
            r7 = 91
            if (r8 != r7) goto L_0x045d
            r5.nextToken()     // Catch:{ all -> 0x056d }
            com.alibaba.fastjson.JSONArray r7 = new com.alibaba.fastjson.JSONArray     // Catch:{ all -> 0x056d }
            r7.<init>()     // Catch:{ all -> 0x056d }
            if (r2 == 0) goto L_0x0424
            java.lang.Class r8 = r18.getClass()     // Catch:{ all -> 0x056d }
        L_0x0424:
            if (r2 != 0) goto L_0x0429
            r1.T(r6)     // Catch:{ all -> 0x056d }
        L_0x0429:
            r1.G(r7, r12)     // Catch:{ all -> 0x056d }
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.UseObjectArray     // Catch:{ all -> 0x056d }
            boolean r8 = r5.a(r8)     // Catch:{ all -> 0x056d }
            if (r8 == 0) goto L_0x0438
            java.lang.Object[] r7 = r7.toArray()     // Catch:{ all -> 0x056d }
        L_0x0438:
            r0.put(r12, r7)     // Catch:{ all -> 0x056d }
            int r7 = r5.J()     // Catch:{ all -> 0x056d }
            r8 = 13
            if (r7 != r8) goto L_0x044a
            r5.nextToken()     // Catch:{ all -> 0x056d }
            r1.T(r6)
            return r0
        L_0x044a:
            int r7 = r5.J()     // Catch:{ all -> 0x056d }
            r8 = 16
            if (r7 != r8) goto L_0x0457
            r9 = r8
            r8 = 13
            goto L_0x053c
        L_0x0457:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x056d }
            r0.<init>(r10)     // Catch:{ all -> 0x056d }
            throw r0     // Catch:{ all -> 0x056d }
        L_0x045d:
            r7 = 123(0x7b, float:1.72E-43)
            if (r8 != r7) goto L_0x050f
            r5.nextToken()     // Catch:{ all -> 0x056d }
            if (r2 == 0) goto L_0x046e
            java.lang.Class r7 = r18.getClass()     // Catch:{ all -> 0x056d }
            if (r7 != r3) goto L_0x046e
            r7 = r14
            goto L_0x046f
        L_0x046e:
            r7 = 0
        L_0x046f:
            com.alibaba.fastjson.JSONObject r8 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x056d }
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.OrderedField     // Catch:{ all -> 0x056d }
            boolean r9 = r5.a(r9)     // Catch:{ all -> 0x056d }
            r8.<init>((boolean) r9)     // Catch:{ all -> 0x056d }
            if (r7 != 0) goto L_0x0481
            f2.f r9 = r1.R(r6, r8, r12)     // Catch:{ all -> 0x056d }
            goto L_0x0482
        L_0x0481:
            r9 = 0
        L_0x0482:
            g2.j r10 = r1.f15709o     // Catch:{ all -> 0x056d }
            if (r10 == 0) goto L_0x04a1
            if (r12 == 0) goto L_0x048d
            java.lang.String r10 = r12.toString()     // Catch:{ all -> 0x056d }
            goto L_0x048e
        L_0x048d:
            r10 = 0
        L_0x048e:
            g2.j r13 = r1.f15709o     // Catch:{ all -> 0x056d }
            java.lang.reflect.Type r10 = r13.d(r0, r10)     // Catch:{ all -> 0x056d }
            if (r10 == 0) goto L_0x04a1
            com.alibaba.fastjson.parser.ParserConfig r13 = r1.f15698d     // Catch:{ all -> 0x056d }
            g2.l r13 = r13.j(r10)     // Catch:{ all -> 0x056d }
            java.lang.Object r10 = r13.e(r1, r10, r12)     // Catch:{ all -> 0x056d }
            goto L_0x04a3
        L_0x04a1:
            r10 = 0
            r14 = 0
        L_0x04a3:
            if (r14 != 0) goto L_0x04a9
            java.lang.Object r10 = r1.O(r8, r12)     // Catch:{ all -> 0x056d }
        L_0x04a9:
            if (r9 == 0) goto L_0x04af
            if (r8 == r10) goto L_0x04af
            r9.f15739a = r0     // Catch:{ all -> 0x056d }
        L_0x04af:
            java.lang.String r8 = r12.toString()     // Catch:{ all -> 0x056d }
            r1.j(r0, r8)     // Catch:{ all -> 0x056d }
            java.lang.Class r8 = r17.getClass()     // Catch:{ all -> 0x056d }
            java.lang.Class<com.alibaba.fastjson.JSONObject> r9 = com.alibaba.fastjson.JSONObject.class
            if (r8 != r9) goto L_0x04c6
            java.lang.String r8 = r12.toString()     // Catch:{ all -> 0x056d }
            r0.put(r8, r10)     // Catch:{ all -> 0x056d }
            goto L_0x04c9
        L_0x04c6:
            r0.put(r12, r10)     // Catch:{ all -> 0x056d }
        L_0x04c9:
            if (r7 == 0) goto L_0x04ce
            r1.S(r10, r12)     // Catch:{ all -> 0x056d }
        L_0x04ce:
            int r8 = r5.J()     // Catch:{ all -> 0x056d }
            r9 = 13
            if (r8 != r9) goto L_0x04e0
            r5.nextToken()     // Catch:{ all -> 0x056d }
            r1.T(r6)     // Catch:{ all -> 0x056d }
            r1.T(r6)
            return r0
        L_0x04e0:
            int r8 = r5.J()     // Catch:{ all -> 0x056d }
            r9 = 16
            if (r8 != r9) goto L_0x04f4
            if (r7 == 0) goto L_0x04ef
            r16.Q()     // Catch:{ all -> 0x056d }
            goto L_0x03d9
        L_0x04ef:
            r1.T(r6)     // Catch:{ all -> 0x056d }
            goto L_0x03d9
        L_0x04f4:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x056d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x056d }
            r2.<init>()     // Catch:{ all -> 0x056d }
            java.lang.String r3 = "syntax error, "
            r2.append(r3)     // Catch:{ all -> 0x056d }
            java.lang.String r3 = r5.b()     // Catch:{ all -> 0x056d }
            r2.append(r3)     // Catch:{ all -> 0x056d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x056d }
            r0.<init>(r2)     // Catch:{ all -> 0x056d }
            throw r0     // Catch:{ all -> 0x056d }
        L_0x050f:
            r5.nextToken()     // Catch:{ all -> 0x056d }
            java.lang.Object r7 = r16.z()     // Catch:{ all -> 0x056d }
            java.lang.Class r8 = r17.getClass()     // Catch:{ all -> 0x056d }
            java.lang.Class<com.alibaba.fastjson.JSONObject> r9 = com.alibaba.fastjson.JSONObject.class
            if (r8 != r9) goto L_0x0522
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x056d }
        L_0x0522:
            r0.put(r12, r7)     // Catch:{ all -> 0x056d }
            int r7 = r5.J()     // Catch:{ all -> 0x056d }
            r8 = 13
            if (r7 != r8) goto L_0x0534
            r5.nextToken()     // Catch:{ all -> 0x056d }
            r1.T(r6)
            return r0
        L_0x0534:
            int r7 = r5.J()     // Catch:{ all -> 0x056d }
            r9 = 16
            if (r7 != r9) goto L_0x0540
        L_0x053c:
            r10 = r9
            r7 = 0
            goto L_0x0060
        L_0x0540:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x056d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x056d }
            r2.<init>()     // Catch:{ all -> 0x056d }
            java.lang.String r3 = "syntax error, position at "
            r2.append(r3)     // Catch:{ all -> 0x056d }
            int r3 = r5.s()     // Catch:{ all -> 0x056d }
            r2.append(r3)     // Catch:{ all -> 0x056d }
            r2.append(r13)     // Catch:{ all -> 0x056d }
            r2.append(r12)     // Catch:{ all -> 0x056d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x056d }
            r0.<init>(r2)     // Catch:{ all -> 0x056d }
            throw r0     // Catch:{ all -> 0x056d }
        L_0x0561:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x056d }
            r0.<init>(r10)     // Catch:{ all -> 0x056d }
            throw r0     // Catch:{ all -> 0x056d }
        L_0x0567:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x056d }
            r0.<init>(r10)     // Catch:{ all -> 0x056d }
            throw r0     // Catch:{ all -> 0x056d }
        L_0x056d:
            r0 = move-exception
            r1.T(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.a.O(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public void P(Object obj) {
        Object obj2;
        Class<?> cls = obj.getClass();
        l j11 = this.f15698d.j(cls);
        k kVar = j11 instanceof k ? (k) j11 : null;
        if (this.f15701g.J() == 12 || this.f15701g.J() == 16) {
            while (true) {
                String L = this.f15701g.L(this.f15697c);
                if (L == null) {
                    if (this.f15701g.J() == 13) {
                        this.f15701g.f(16);
                        return;
                    } else if (this.f15701g.J() == 16 && this.f15701g.a(Feature.AllowArbitraryCommas)) {
                    }
                }
                i j12 = kVar != null ? kVar.j(L) : null;
                if (j12 != null) {
                    i2.a aVar = j12.f15808a;
                    Class<?> cls2 = aVar.f15966f;
                    Type type = aVar.f15967g;
                    if (cls2 == Integer.TYPE) {
                        this.f15701g.y(2);
                        obj2 = IntegerCodec.f14273a.e(this, type, (Object) null);
                    } else if (cls2 == String.class) {
                        this.f15701g.y(4);
                        obj2 = StringCodec.f(this);
                    } else if (cls2 == Long.TYPE) {
                        this.f15701g.y(2);
                        obj2 = LongCodec.f14287a.e(this, type, (Object) null);
                    } else {
                        l i11 = this.f15698d.i(cls2, type);
                        this.f15701g.y(i11.b());
                        obj2 = i11.e(this, type, (Object) null);
                    }
                    j12.e(obj, obj2);
                    if (this.f15701g.J() != 16 && this.f15701g.J() == 13) {
                        this.f15701g.f(16);
                        return;
                    }
                } else if (this.f15701g.a(Feature.IgnoreNotMatch)) {
                    this.f15701g.B();
                    z();
                    if (this.f15701g.J() == 13) {
                        this.f15701g.nextToken();
                        return;
                    }
                } else {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + L);
                }
            }
        } else {
            throw new JSONException("syntax error, expect {, actual " + this.f15701g.b());
        }
    }

    public void Q() {
        if (!this.f15701g.a(Feature.DisableCircularReferenceDetect)) {
            this.f15702h = this.f15702h.f15740b;
            int i11 = this.f15704j;
            if (i11 > 0) {
                int i12 = i11 - 1;
                this.f15704j = i12;
                this.f15703i[i12] = null;
            }
        }
    }

    public f R(f fVar, Object obj, Object obj2) {
        if (this.f15701g.a(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        f fVar2 = new f(fVar, obj, obj2);
        this.f15702h = fVar2;
        e(fVar2);
        return this.f15702h;
    }

    public f S(Object obj, Object obj2) {
        if (this.f15701g.a(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return R(this.f15702h, obj, obj2);
    }

    public void T(f fVar) {
        if (!this.f15701g.a(Feature.DisableCircularReferenceDetect)) {
            this.f15702h = fVar;
        }
    }

    public void U(j jVar) {
        this.f15709o = jVar;
    }

    public void V(int i11) {
        this.f15706l = i11;
    }

    public final void a(int i11) {
        b bVar = this.f15701g;
        if (bVar.J() == i11) {
            bVar.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.a(i11) + ", actual " + JSONToken.a(bVar.J()));
    }

    public void b(String str) {
        b bVar = this.f15701g;
        bVar.B();
        if (bVar.J() != 4) {
            throw new JSONException("type not match error");
        } else if (str.equals(bVar.H())) {
            bVar.nextToken();
            if (bVar.J() == 16) {
                bVar.nextToken();
            }
        } else {
            throw new JSONException("type not match error");
        }
    }

    public void close() {
        b bVar = this.f15701g;
        try {
            if (bVar.a(Feature.AutoCloseSource)) {
                if (bVar.J() != 20) {
                    throw new JSONException("not close json text, token : " + JSONToken.a(bVar.J()));
                }
            }
        } finally {
            bVar.close();
        }
    }

    public final void e(f fVar) {
        int i11 = this.f15704j;
        this.f15704j = i11 + 1;
        f[] fVarArr = this.f15703i;
        if (fVarArr == null) {
            this.f15703i = new f[8];
        } else if (i11 >= fVarArr.length) {
            f[] fVarArr2 = new f[((fVarArr.length * 3) / 2)];
            System.arraycopy(fVarArr, 0, fVarArr2, 0, fVarArr.length);
            this.f15703i = fVarArr2;
        }
        this.f15703i[i11] = fVar;
    }

    public void f(C0078a aVar) {
        if (this.f15705k == null) {
            this.f15705k = new ArrayList(2);
        }
        this.f15705k.add(aVar);
    }

    public void g(Collection collection) {
        if (this.f15706l != 1) {
            return;
        }
        if (collection instanceof List) {
            C0078a s11 = s();
            s11.f15713c = new p(this, (List) collection, collection.size() - 1);
            s11.f15714d = this.f15702h;
            V(0);
            return;
        }
        C0078a s12 = s();
        s12.f15713c = new p(collection);
        s12.f15714d = this.f15702h;
        V(0);
    }

    public void j(Map map, Object obj) {
        if (this.f15706l == 1) {
            p pVar = new p(map, obj);
            C0078a s11 = s();
            s11.f15713c = pVar;
            s11.f15714d = this.f15702h;
            V(0);
        }
    }

    public ParserConfig k() {
        return this.f15698d;
    }

    public f l() {
        return this.f15702h;
    }

    public String m() {
        return this.f15699e;
    }

    public DateFormat n() {
        if (this.f15700f == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f15699e, this.f15701g.getLocale());
            this.f15700f = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.f15701g.k());
        }
        return this.f15700f;
    }

    public List<g> o() {
        if (this.f15708n == null) {
            this.f15708n = new ArrayList(2);
        }
        return this.f15708n;
    }

    public List<h> p() {
        if (this.f15707m == null) {
            this.f15707m = new ArrayList(2);
        }
        return this.f15707m;
    }

    public j r() {
        return this.f15709o;
    }

    public C0078a s() {
        List<C0078a> list = this.f15705k;
        return list.get(list.size() - 1);
    }

    public b t() {
        return this.f15701g;
    }

    public Object u(String str) {
        for (int i11 = 0; i11 < this.f15704j; i11++) {
            if (str.equals(this.f15703i[i11].toString())) {
                return this.f15703i[i11].f15739a;
            }
        }
        return null;
    }

    public int v() {
        return this.f15706l;
    }

    public g w() {
        return this.f15697c;
    }

    public void x(Object obj) {
        i2.a aVar;
        List<C0078a> list = this.f15705k;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                C0078a aVar2 = this.f15705k.get(i11);
                String str = aVar2.f15712b;
                Object obj2 = null;
                f fVar = aVar2.f15714d;
                if (fVar != null) {
                    obj2 = fVar.f15739a;
                }
                Object u11 = str.startsWith("$") ? u(str) : aVar2.f15711a.f15739a;
                i iVar = aVar2.f15713c;
                if (iVar != null) {
                    if (u11 != null && u11.getClass() == JSONObject.class && (aVar = iVar.f15808a) != null && !Map.class.isAssignableFrom(aVar.f15966f)) {
                        u11 = JSONPath.d(this.f15703i[0].f15739a, str);
                    }
                    iVar.e(obj2, u11);
                }
            }
        }
    }

    public boolean y(Feature feature) {
        return this.f15701g.a(feature);
    }

    public Object z() {
        return B((Object) null);
    }

    public a(String str, ParserConfig parserConfig, int i11) {
        this((Object) str, (b) new e(str, i11), parserConfig);
    }

    public a(char[] cArr, int i11, ParserConfig parserConfig, int i12) {
        this((Object) cArr, (b) new e(cArr, i11, i12), parserConfig);
    }

    public a(Object obj, b bVar, ParserConfig parserConfig) {
        this.f15699e = JSON.DEFFAULT_DATE_FORMAT;
        this.f15704j = 0;
        this.f15706l = 0;
        this.f15707m = null;
        this.f15708n = null;
        this.f15709o = null;
        this.f15710p = null;
        this.f15701g = bVar;
        this.f15696b = obj;
        this.f15698d = parserConfig;
        this.f15697c = parserConfig.f14185c;
        char A = bVar.A();
        if (A == '{') {
            bVar.next();
            ((c) bVar).f15718b = 12;
        } else if (A == '[') {
            bVar.next();
            ((c) bVar).f15718b = 14;
        } else {
            bVar.nextToken();
        }
    }
}
