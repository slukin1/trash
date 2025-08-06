package g2;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.ParserConfig;
import d2.b;
import i2.a;

public class d extends i {

    /* renamed from: c  reason: collision with root package name */
    public l f15803c;

    public d(ParserConfig parserConfig, Class<?> cls, a aVar) {
        super(cls, aVar);
    }

    public int a() {
        l lVar = this.f15803c;
        if (lVar != null) {
            return lVar.b();
        }
        return 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        r10 = r7.f15808a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(f2.a r8, java.lang.Object r9, java.lang.reflect.Type r10, java.util.Map<java.lang.String, java.lang.Object> r11) {
        /*
            r7 = this;
            g2.l r0 = r7.f15803c
            if (r0 != 0) goto L_0x000b
            com.alibaba.fastjson.parser.ParserConfig r0 = r8.k()
            r7.h(r0)
        L_0x000b:
            g2.l r0 = r7.f15803c
            i2.a r1 = r7.f15808a
            java.lang.reflect.Type r1 = r1.f15967g
            boolean r2 = r10 instanceof java.lang.reflect.ParameterizedType
            if (r2 == 0) goto L_0x002b
            f2.f r0 = r8.l()
            if (r0 == 0) goto L_0x001d
            r0.f15742d = r10
        L_0x001d:
            java.lang.Class<?> r0 = r7.f15809b
            java.lang.reflect.Type r1 = i2.a.h(r0, r10, r1)
            com.alibaba.fastjson.parser.ParserConfig r10 = r8.k()
            g2.l r0 = r10.j(r1)
        L_0x002b:
            r3 = r1
            boolean r10 = r0 instanceof g2.k
            if (r10 == 0) goto L_0x003f
            i2.a r10 = r7.f15808a
            int r1 = r10.f15971k
            if (r1 == 0) goto L_0x003f
            g2.k r0 = (g2.k) r0
            java.lang.String r10 = r10.f15962b
            java.lang.Object r10 = r0.g(r8, r3, r10, r1)
            goto L_0x005c
        L_0x003f:
            i2.a r10 = r7.f15808a
            java.lang.String r5 = r10.f15981u
            if (r5 == 0) goto L_0x0056
            boolean r1 = r0 instanceof com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer
            if (r1 == 0) goto L_0x0056
            r1 = r0
            com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer r1 = (com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer) r1
            java.lang.String r4 = r10.f15962b
            int r6 = r10.f15971k
            r2 = r8
            java.lang.Object r10 = r1.f(r2, r3, r4, r5, r6)
            goto L_0x005c
        L_0x0056:
            java.lang.String r10 = r10.f15962b
            java.lang.Object r10 = r0.e(r8, r3, r10)
        L_0x005c:
            boolean r0 = r10 instanceof byte[]
            r1 = 0
            if (r0 == 0) goto L_0x00a9
            i2.a r0 = r7.f15808a
            java.lang.String r0 = r0.f15981u
            java.lang.String r2 = "gzip"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0079
            i2.a r0 = r7.f15808a
            java.lang.String r0 = r0.f15981u
            java.lang.String r2 = "gzip,base64"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00a9
        L_0x0079:
            byte[] r10 = (byte[]) r10
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x00a0 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x00a0 }
            r2.<init>(r10)     // Catch:{ IOException -> 0x00a0 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x00a0 }
            java.io.ByteArrayOutputStream r10 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00a0 }
            r10.<init>()     // Catch:{ IOException -> 0x00a0 }
        L_0x008a:
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x00a0 }
            int r3 = r0.read(r2)     // Catch:{ IOException -> 0x00a0 }
            r4 = -1
            if (r3 != r4) goto L_0x009a
            byte[] r10 = r10.toByteArray()     // Catch:{ IOException -> 0x00a0 }
            goto L_0x00a9
        L_0x009a:
            if (r3 <= 0) goto L_0x008a
            r10.write(r2, r1, r3)     // Catch:{ IOException -> 0x00a0 }
            goto L_0x008a
        L_0x00a0:
            r8 = move-exception
            com.alibaba.fastjson.JSONException r9 = new com.alibaba.fastjson.JSONException
            java.lang.String r10 = "unzip bytes error."
            r9.<init>(r10, r8)
            throw r9
        L_0x00a9:
            int r0 = r8.v()
            r2 = 1
            if (r0 != r2) goto L_0x00c0
            f2.a$a r9 = r8.s()
            r9.f15713c = r7
            f2.f r10 = r8.l()
            r9.f15714d = r10
            r8.V(r1)
            goto L_0x00cd
        L_0x00c0:
            if (r9 != 0) goto L_0x00ca
            i2.a r8 = r7.f15808a
            java.lang.String r8 = r8.f15962b
            r11.put(r8, r10)
            goto L_0x00cd
        L_0x00ca:
            r7.e(r9, r10)
        L_0x00cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.d.b(f2.a, java.lang.Object, java.lang.reflect.Type, java.util.Map):void");
    }

    public l h(ParserConfig parserConfig) {
        if (this.f15803c == null) {
            b e11 = this.f15808a.e();
            if (e11 == null || e11.deserializeUsing() == Void.class) {
                a aVar = this.f15808a;
                this.f15803c = parserConfig.i(aVar.f15966f, aVar.f15967g);
            } else {
                try {
                    this.f15803c = (l) e11.deserializeUsing().newInstance();
                } catch (Exception e12) {
                    throw new JSONException("create deserializeUsing ObjectDeserializer error", e12);
                }
            }
        }
        return this.f15803c;
    }
}
