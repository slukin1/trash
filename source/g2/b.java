package g2;

import com.alibaba.fastjson.parser.ParserConfig;
import f2.f;
import i2.a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Map;

public class b extends i {

    /* renamed from: c  reason: collision with root package name */
    public final Type f15800c;

    /* renamed from: d  reason: collision with root package name */
    public int f15801d;

    /* renamed from: e  reason: collision with root package name */
    public l f15802e;

    public b(ParserConfig parserConfig, Class<?> cls, a aVar) {
        super(cls, aVar);
        Type type = aVar.f15967g;
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                if (upperBounds.length == 1) {
                    type2 = upperBounds[0];
                }
            }
            this.f15800c = type2;
            return;
        }
        this.f15800c = Object.class;
    }

    public int a() {
        return 14;
    }

    public void b(f2.a aVar, Object obj, Type type, Map<String, Object> map) {
        f2.b bVar = aVar.f15701g;
        int J = bVar.J();
        if (J == 8 || (J == 4 && bVar.H().length() == 0)) {
            f(obj, (String) null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f l11 = aVar.l();
        aVar.R(l11, obj, this.f15808a.f15962b);
        h(aVar, type, arrayList);
        aVar.T(l11);
        if (obj == null) {
            map.put(this.f15808a.f15962b, arrayList);
        } else {
            e(obj, arrayList);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(f2.a r13, java.lang.reflect.Type r14, java.util.Collection r15) {
        /*
            r12 = this;
            java.lang.reflect.Type r0 = r12.f15800c
            g2.l r1 = r12.f15802e
            boolean r2 = r14 instanceof java.lang.reflect.ParameterizedType
            r3 = 0
            if (r2 == 0) goto L_0x00c1
            boolean r2 = r0 instanceof java.lang.reflect.TypeVariable
            r4 = 0
            r5 = -1
            if (r2 == 0) goto L_0x005e
            r2 = r0
            java.lang.reflect.TypeVariable r2 = (java.lang.reflect.TypeVariable) r2
            java.lang.reflect.ParameterizedType r14 = (java.lang.reflect.ParameterizedType) r14
            java.lang.reflect.Type r6 = r14.getRawType()
            boolean r6 = r6 instanceof java.lang.Class
            if (r6 == 0) goto L_0x0022
            java.lang.reflect.Type r4 = r14.getRawType()
            java.lang.Class r4 = (java.lang.Class) r4
        L_0x0022:
            if (r4 == 0) goto L_0x0044
            java.lang.reflect.TypeVariable[] r6 = r4.getTypeParameters()
            int r6 = r6.length
            r7 = r3
        L_0x002a:
            if (r7 >= r6) goto L_0x0044
            java.lang.reflect.TypeVariable[] r8 = r4.getTypeParameters()
            r8 = r8[r7]
            java.lang.String r8 = r8.getName()
            java.lang.String r9 = r2.getName()
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x0041
            goto L_0x0045
        L_0x0041:
            int r7 = r7 + 1
            goto L_0x002a
        L_0x0044:
            r7 = r5
        L_0x0045:
            if (r7 == r5) goto L_0x00c1
            java.lang.reflect.Type[] r14 = r14.getActualTypeArguments()
            r0 = r14[r7]
            java.lang.reflect.Type r14 = r12.f15800c
            boolean r14 = r0.equals(r14)
            if (r14 != 0) goto L_0x00c1
            com.alibaba.fastjson.parser.ParserConfig r14 = r13.k()
            g2.l r1 = r14.j(r0)
            goto L_0x00c1
        L_0x005e:
            boolean r2 = r0 instanceof java.lang.reflect.ParameterizedType
            if (r2 == 0) goto L_0x00c1
            r2 = r0
            java.lang.reflect.ParameterizedType r2 = (java.lang.reflect.ParameterizedType) r2
            java.lang.reflect.Type[] r6 = r2.getActualTypeArguments()
            int r7 = r6.length
            r8 = 1
            if (r7 != r8) goto L_0x00c1
            r7 = r6[r3]
            boolean r7 = r7 instanceof java.lang.reflect.TypeVariable
            if (r7 == 0) goto L_0x00c1
            r7 = r6[r3]
            java.lang.reflect.TypeVariable r7 = (java.lang.reflect.TypeVariable) r7
            java.lang.reflect.ParameterizedType r14 = (java.lang.reflect.ParameterizedType) r14
            java.lang.reflect.Type r8 = r14.getRawType()
            boolean r8 = r8 instanceof java.lang.Class
            if (r8 == 0) goto L_0x0087
            java.lang.reflect.Type r4 = r14.getRawType()
            java.lang.Class r4 = (java.lang.Class) r4
        L_0x0087:
            if (r4 == 0) goto L_0x00a9
            java.lang.reflect.TypeVariable[] r8 = r4.getTypeParameters()
            int r8 = r8.length
            r9 = r3
        L_0x008f:
            if (r9 >= r8) goto L_0x00a9
            java.lang.reflect.TypeVariable[] r10 = r4.getTypeParameters()
            r10 = r10[r9]
            java.lang.String r10 = r10.getName()
            java.lang.String r11 = r7.getName()
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x00a6
            goto L_0x00aa
        L_0x00a6:
            int r9 = r9 + 1
            goto L_0x008f
        L_0x00a9:
            r9 = r5
        L_0x00aa:
            if (r9 == r5) goto L_0x00c1
            java.lang.reflect.Type[] r14 = r14.getActualTypeArguments()
            r14 = r14[r9]
            r6[r3] = r14
            i2.c r0 = new i2.c
            java.lang.reflect.Type r14 = r2.getOwnerType()
            java.lang.reflect.Type r2 = r2.getRawType()
            r0.<init>(r6, r14, r2)
        L_0x00c1:
            f2.b r14 = r13.f15701g
            int r2 = r14.J()
            r4 = 14
            if (r2 != r4) goto L_0x011f
            if (r1 != 0) goto L_0x00dd
            com.alibaba.fastjson.parser.ParserConfig r1 = r13.k()
            g2.l r1 = r1.j(r0)
            r12.f15802e = r1
            int r2 = r1.b()
            r12.f15801d = r2
        L_0x00dd:
            r2 = r1
            int r1 = r12.f15801d
            r14.f(r1)
        L_0x00e3:
            com.alibaba.fastjson.parser.Feature r1 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas
            boolean r1 = r14.a(r1)
            r4 = 16
            if (r1 == 0) goto L_0x00f7
        L_0x00ed:
            int r1 = r14.J()
            if (r1 != r4) goto L_0x00f7
            r14.nextToken()
            goto L_0x00ed
        L_0x00f7:
            int r1 = r14.J()
            r5 = 15
            if (r1 != r5) goto L_0x0103
            r14.f(r4)
            goto L_0x0139
        L_0x0103:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            java.lang.Object r1 = r2.e(r13, r0, r1)
            r15.add(r1)
            r13.g(r15)
            int r1 = r14.J()
            if (r1 != r4) goto L_0x011c
            int r1 = r12.f15801d
            r14.f(r1)
        L_0x011c:
            int r3 = r3 + 1
            goto L_0x00e3
        L_0x011f:
            if (r1 != 0) goto L_0x012b
            com.alibaba.fastjson.parser.ParserConfig r14 = r13.k()
            g2.l r1 = r14.j(r0)
            r12.f15802e = r1
        L_0x012b:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r3)
            java.lang.Object r14 = r1.e(r13, r0, r14)
            r15.add(r14)
            r13.g(r15)
        L_0x0139:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.b.h(f2.a, java.lang.reflect.Type, java.util.Collection):void");
    }
}
