package com.mob.tools.a;

import android.content.Context;
import com.mob.commons.m;
import java.io.File;
import java.lang.reflect.Method;

class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f27685a = m.a("0143bjdgfdfcdfhdfbfhPbMdgbafebbhd");

    /* renamed from: j  reason: collision with root package name */
    private static volatile boolean f27686j = false;

    /* renamed from: b  reason: collision with root package name */
    private Method f27687b = null;

    /* renamed from: c  reason: collision with root package name */
    private Method f27688c = null;

    /* renamed from: d  reason: collision with root package name */
    private Method f27689d = null;

    /* renamed from: e  reason: collision with root package name */
    private Method f27690e = null;

    /* renamed from: f  reason: collision with root package name */
    private Method f27691f = null;

    /* renamed from: g  reason: collision with root package name */
    private Method f27692g = null;

    /* renamed from: h  reason: collision with root package name */
    private Method f27693h = null;

    /* renamed from: i  reason: collision with root package name */
    private boolean f27694i = false;

    public static boolean b(Context context) {
        if (!f27686j) {
            try {
                File file = new File(context.getFilesDir(), f27685a);
                if (file.exists()) {
                    f27686j = file.delete();
                }
            } catch (Throwable unused) {
            }
        }
        return f27686j;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0131 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.content.Context r12) {
        /*
            r11 = this;
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0018 }
            java.io.File r4 = r12.getFilesDir()     // Catch:{ all -> 0x0018 }
            java.lang.String r5 = "0146bjdgfdfcdfhdfbfh.bIdgbafebbfd"
            java.lang.String r5 = com.mob.commons.m.a(r5)     // Catch:{ all -> 0x0018 }
            r3.<init>(r4, r5)     // Catch:{ all -> 0x0018 }
            com.mob.tools.utils.ResHelper.deleteFileAndFolder(r3)     // Catch:{ all -> 0x0018 }
        L_0x0018:
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0131 }
            java.io.File r12 = r12.getFilesDir()     // Catch:{ all -> 0x0131 }
            java.lang.String r5 = f27685a     // Catch:{ all -> 0x0131 }
            r4.<init>(r12, r5)     // Catch:{ all -> 0x0131 }
            boolean r12 = r4.exists()     // Catch:{ all -> 0x0131 }
            r5 = 0
            r6 = 2
            r7 = 1
            if (r12 != 0) goto L_0x0052
            java.lang.String r12 = "UEsDBBQACAgIAG2HfFYAAAAAAAAAAAAAAAAUAAQATUVUQS1JTkYvTUFOSUZFU1QuTUb+ygAA803My0xLLS7RDUstKs7Mz7NSMNQz4OVySa3Q9clPTiwBCyXnJBYXpxbrpaRW8HI5F6UmlqSm6DpVWimkVACVG5rxcvFyAQBQSwcI8N6zmEcAAABJAAAAUEsDBBQACAgIAG2HfFYAAAAAAAAAAAAAAAALAAAAY2xhc3Nlcy5kZXidV11sVEUUPnPn/uy9e3e7vWC3wEILW6H8yIKgAtsgpQrVbBWkaQwlxmX3Uq52d8vubcGfGDXgz4OJSkxIRKMPNTyY+BPiDw8mxN8HH9Qn9UXRaHzQRBMf0ETjNzN3t1tpYuIm3z1nzpzzzZk5c2fnlv0TzqYt15HfaYw/tO77Qw+en+UXjNXPnf+zu48u6qczCaIpIjoxttWj6Fd2iQZJ2TuAkBHBjV5n1PqlgIJGJEyfQm5yiH6GvMtCPBAAx4Bp4CTwBPAUcBp4HngX+BL4HbBiRMuAHLAHmAAeBV4EXgZmgXPAq8BrwPvAl8AvwGXgL4DbRBlgA7AF2AnsBcaAcaABnALOAG8AF4APgc+BH4BfgD8AhnkkgC5gM7AHOAQcB04BzwIvAOeAN4GLwFfAN8CPwG8AaAiC4gCWUq5dMlpLsW6dgFjsRcBVQDewBFgKGAAHfjWJMC3Sgcumsgs9hvUyIz1lzdnb/bvFmkZ6f5u+tc1/V8Qjch22VC5OVNvFkb4P9q5oHncKElg16eFST+S7Vj5NWiclo41SGpHU6XopLSk5RlsjrYrHQsY3SBmnvJgbrH1SqraNiGukVG01gsqfInkOk9jhqrbgfA/Jfh1X+ndt+t9tetKd01dFuuBVkkmdxRX/VMqW1euAVdTFhP1uUb+Et8Fb5jkZk9NSaxVl33Gx/wwasWNOdVOMZmJoy741lP1kri9ju0LGIx+WfSsBnxU0YpmIS9Jnpmv0GJyyHwn7gLRn30Z8LEkjMctBOy789psu78GmV37rpd9IotWn9WjoeyVBov2F6epinJGkGmPI7Ijb0XxymE9GzCftmRkN+XLMJcR4BvI1dFPkea3uMk/LNsAQ46ZgWMnFDuDYyQk8Bc+N4BE18myvO6ODxwDPY+CxDJGbLXhGkZenZ0+BxzFswbPbUDwqYvVCETx7Ev5xXfpzZNLDYlTtTdAjeLp0kVy9UxcVMmQeh+JqT3r9nuV1qRmhAidbM7IyGLN9ZtlHBb9mjbianNszmsjJBnsHKi0sLyVcrVMT77Eh358Gxuj932t27JBOT18QjE5Ug8fBt0HwdXtWhoNPB98psX/AZxqW4BsywKfWwtYtwbdZj9ZORtxA2WmXIk85rvDRuMs7ebNGZzHOrVGNtsUdWnl+m27RNteglR9sh3YsZeLNFOv5fyt4dRTh/kcFLaxuXFbQkRXs/7j5v2K1vef9XL2jQor8U1y9k+J/RtThshadhVzFZbiKM1rnqA7pyvO3eW5oUiYin7l+LtuG9FH6XFwiihM2Fp2HTJ4K+trR0TzxgdEdZA4E1SDcSdrOfkoMB7uDatmvb7ynOFMkrVAgXsBDL4inWZA/yhRKtUquUs6VimHusPTPNQPztLxQLk7OBPfmitVqLSyGQa2aOxBMVIvhdN3P09IFukeP1mvHG3nqLIhhc5PF6kRuaLLYgMlrM91++B6/FM63HQjrQXUiT1e12SRd8fAkRutpM9f9I5OIzw3Vqo2wPl0Ka8h2yQIOewJ/siwyvbJrxA+P1tDHxkgbO0jsIGkHC8TGyRu/MvdF4wskP8/YzN4uiYjbihWfeGnyftJLyJHSaqU2Nu5rhH5l49jIHdPVMIBP0j/hV6bE0jWGB/fdQsYRkTHZUkgW60itLpVEpKjEiU/4IXXhcZOPIet+uW0xKNVml2tAnW2WiCF9hSnqsNAxPITkbaGoeAdqM2kPemsKUYwZVGdq9/rkKCknY1ZUn6Okmo7SG7SkEh7du3D2i+Z3qQQWzzdGwwqWA0gyKJf96uBUcHNrOcmt+seHbwFrsVryKY5Wq2FPFevFSkNOUamoKcXqfskPZvw6JRp+OFgq+Y1GgL1HXY2FR9DDo0GDjJni5DQ4ZyqtorZUuX1woFlJ2suutW69xKnPYV6Ks7XO+9wY1NniFOfXO99x7Ron4Pou4wTtYhlrwyXO+pzznJbrtJ5nVuWFRYsslzjf6sxyttIeoLSxPL95+w4rz7wOzq4DKa7BA7TCyEhzO0/ffN5Zrm1zaCvPCLfZ/doDy+eNsEWMsCI2QBpjOzPxNEsn0jzt4plMpyHT0EjT0Me6zXk+yX/5iD6j1afaVqudbPnYLVsrVt4nH3lYf91kT7JPTGafiTH7W+Anm9mfOsw+G2f2SXH16mg7s5uy+f2g0dw3BKe57whx/ja/IUya+47gKdUWZzzrVXfaTQg0e5WPuO+xlDqDxZ1X61Vjie8OHvnLu1uv4hH3QYpi5T0xpXTxjfMPUEsHCKFWFIudBgAAHA0AAFBLAQIUABQACAgIAG2HfFbw3rOYRwAAAEkAAAAUAAQAAAAAAAAAAAAAAAAAAABNRVRBLUlORi9NQU5JRkVTVC5NRv7KAABQSwECFAAUAAgICABth3xWoVYUi50GAAAcDQAACwAAAAAAAAAAAAAAAACNAAAAY2xhc3Nlcy5kZXhQSwUGAAAAAAIAAgB/AAAAYwcAAAAA"
            byte[] r12 = android.util.Base64.decode(r12, r6)     // Catch:{ all -> 0x0131 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ all -> 0x0049 }
            r8.<init>(r4)     // Catch:{ all -> 0x0049 }
            r8.write(r12)     // Catch:{ all -> 0x0046 }
            java.io.Closeable[] r12 = new java.io.Closeable[r7]     // Catch:{ all -> 0x0131 }
            r12[r3] = r8     // Catch:{ all -> 0x0131 }
            com.mob.commons.v.a((java.io.Closeable[]) r12)     // Catch:{ all -> 0x0131 }
            r4.setReadOnly()     // Catch:{ all -> 0x0131 }
            goto L_0x0052
        L_0x0046:
            r12 = move-exception
            r5 = r8
            goto L_0x004a
        L_0x0049:
            r12 = move-exception
        L_0x004a:
            java.io.Closeable[] r0 = new java.io.Closeable[r7]     // Catch:{ all -> 0x0131 }
            r0[r3] = r5     // Catch:{ all -> 0x0131 }
            com.mob.commons.v.a((java.io.Closeable[]) r0)     // Catch:{ all -> 0x0131 }
            throw r12     // Catch:{ all -> 0x0131 }
        L_0x0052:
            java.lang.String r12 = "021BbaEbeSbbbgcfbjdgcadgEgd'bdbjdjOdWcgeabg;ed"
            java.lang.String r12 = com.mob.commons.m.a(r12)     // Catch:{ all -> 0x0131 }
            java.lang.String r12 = com.mob.tools.utils.ReflectHelper.importClass(r12)     // Catch:{ all -> 0x0131 }
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ all -> 0x0131 }
            r8[r3] = r4     // Catch:{ all -> 0x0131 }
            java.lang.Object r12 = com.mob.tools.utils.ReflectHelper.newInstance(r12, r8)     // Catch:{ all -> 0x0131 }
            java.lang.String r4 = "009e^biTbVbacb$ebJdgdg"
            java.lang.String r4 = com.mob.commons.m.a(r4)     // Catch:{ all -> 0x0131 }
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ all -> 0x0131 }
            java.lang.String r9 = "026a1bibdbjbdbabj1abg6bjddbgMc6ba@d7bhbjdibgdhbg7c_baIdFbh"
            java.lang.String r9 = com.mob.commons.m.a(r9)     // Catch:{ all -> 0x0131 }
            r8[r3] = r9     // Catch:{ all -> 0x0131 }
            r8[r7] = r5     // Catch:{ all -> 0x0131 }
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ all -> 0x0131 }
            r5[r3] = r2     // Catch:{ all -> 0x0131 }
            java.lang.Class<java.lang.ClassLoader> r9 = java.lang.ClassLoader.class
            r5[r7] = r9     // Catch:{ all -> 0x0131 }
            java.lang.Object r12 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r12, r4, r8, r5)     // Catch:{ all -> 0x0131 }
            java.lang.Class r12 = (java.lang.Class) r12     // Catch:{ all -> 0x0131 }
            java.lang.String r4 = "014d(cgEd6bdOhg=bgbi2c(dgdidbejcc"
            java.lang.String r4 = com.mob.commons.m.a(r4)     // Catch:{ all -> 0x0131 }
            java.lang.Class[] r5 = new java.lang.Class[r7]     // Catch:{ all -> 0x0131 }
            java.lang.Class<java.lang.String[]> r8 = java.lang.String[].class
            r5[r3] = r8     // Catch:{ all -> 0x0131 }
            java.lang.reflect.Method r4 = r12.getDeclaredMethod(r4, r5)     // Catch:{ all -> 0x0131 }
            r11.f27687b = r4     // Catch:{ all -> 0x0131 }
            r4.setAccessible(r7)     // Catch:{ all -> 0x0131 }
            java.lang.String r4 = "010Ibg3cNbbbicfHd*didbejcc"
            java.lang.String r4 = com.mob.commons.m.a(r4)     // Catch:{ all -> 0x0131 }
            r5 = 5
            java.lang.Class[] r8 = new java.lang.Class[r5]     // Catch:{ all -> 0x0131 }
            java.lang.Class<java.lang.Class> r9 = java.lang.Class.class
            r8[r3] = r9     // Catch:{ all -> 0x0131 }
            r8[r7] = r1     // Catch:{ all -> 0x0131 }
            r8[r6] = r2     // Catch:{ all -> 0x0131 }
            java.lang.Class<java.lang.Class[]> r9 = java.lang.Class[].class
            r10 = 3
            r8[r10] = r9     // Catch:{ all -> 0x0131 }
            r9 = 4
            r8[r9] = r0     // Catch:{ all -> 0x0131 }
            java.lang.reflect.Method r4 = r12.getDeclaredMethod(r4, r8)     // Catch:{ all -> 0x0131 }
            r11.f27688c = r4     // Catch:{ all -> 0x0131 }
            r4.setAccessible(r7)     // Catch:{ all -> 0x0131 }
            java.lang.String r4 = "010Rbg6c.bbbicfId9didbejcc"
            java.lang.String r4 = com.mob.commons.m.a(r4)     // Catch:{ all -> 0x0131 }
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch:{ all -> 0x0131 }
            r5[r3] = r2     // Catch:{ all -> 0x0131 }
            r5[r7] = r1     // Catch:{ all -> 0x0131 }
            r5[r6] = r2     // Catch:{ all -> 0x0131 }
            java.lang.Class<java.lang.Class[]> r8 = java.lang.Class[].class
            r5[r10] = r8     // Catch:{ all -> 0x0131 }
            r5[r9] = r0     // Catch:{ all -> 0x0131 }
            java.lang.reflect.Method r4 = r12.getDeclaredMethod(r4, r5)     // Catch:{ all -> 0x0131 }
            r11.f27689d = r4     // Catch:{ all -> 0x0131 }
            r4.setAccessible(r7)     // Catch:{ all -> 0x0131 }
            java.lang.String r4 = "012cd7dedicc:cKdgCgbcad"
            java.lang.String r4 = com.mob.commons.m.a(r4)     // Catch:{ all -> 0x0131 }
            java.lang.Class[] r5 = new java.lang.Class[r7]     // Catch:{ all -> 0x0131 }
            r5[r3] = r2     // Catch:{ all -> 0x0131 }
            java.lang.reflect.Method r4 = r12.getDeclaredMethod(r4, r5)     // Catch:{ all -> 0x0131 }
            r11.f27690e = r4     // Catch:{ all -> 0x0131 }
            r4.setAccessible(r7)     // Catch:{ all -> 0x0131 }
            java.lang.String r4 = "012cdIdedicc cTdg!gbcad"
            java.lang.String r4 = com.mob.commons.m.a(r4)     // Catch:{ all -> 0x0131 }
            java.lang.Class[] r5 = new java.lang.Class[r10]     // Catch:{ all -> 0x0131 }
            r5[r3] = r2     // Catch:{ all -> 0x0131 }
            java.lang.Class<java.lang.Class[]> r8 = java.lang.Class[].class
            r5[r7] = r8     // Catch:{ all -> 0x0131 }
            r5[r6] = r0     // Catch:{ all -> 0x0131 }
            java.lang.reflect.Method r0 = r12.getDeclaredMethod(r4, r5)     // Catch:{ all -> 0x0131 }
            r11.f27691f = r0     // Catch:{ all -> 0x0131 }
            r0.setAccessible(r7)     // Catch:{ all -> 0x0131 }
            java.lang.String r0 = "0092ch,dg,dieabgOde(ba"
            java.lang.String r0 = com.mob.commons.m.a(r0)     // Catch:{ all -> 0x0131 }
            java.lang.Class[] r4 = new java.lang.Class[r10]     // Catch:{ all -> 0x0131 }
            r4[r3] = r2     // Catch:{ all -> 0x0131 }
            r4[r7] = r2     // Catch:{ all -> 0x0131 }
            r4[r6] = r1     // Catch:{ all -> 0x0131 }
            java.lang.reflect.Method r0 = r12.getDeclaredMethod(r0, r4)     // Catch:{ all -> 0x0131 }
            r11.f27692g = r0     // Catch:{ all -> 0x0131 }
            r0.setAccessible(r7)     // Catch:{ all -> 0x0131 }
            java.lang.String r0 = "0070chAdg5dicb[e$eb"
            java.lang.String r0 = com.mob.commons.m.a(r0)     // Catch:{ all -> 0x0131 }
            java.lang.Class[] r1 = new java.lang.Class[r7]     // Catch:{ all -> 0x0131 }
            r1[r3] = r2     // Catch:{ all -> 0x0131 }
            java.lang.reflect.Method r12 = r12.getDeclaredMethod(r0, r1)     // Catch:{ all -> 0x0131 }
            r11.f27693h = r12     // Catch:{ all -> 0x0131 }
            r12.setAccessible(r7)     // Catch:{ all -> 0x0131 }
            r11.f27694i = r7     // Catch:{ all -> 0x0131 }
            goto L_0x0133
        L_0x0131:
            r11.f27694i = r3     // Catch:{ all -> 0x0136 }
        L_0x0133:
            boolean r12 = r11.f27694i
            return r12
        L_0x0136:
            r12 = move-exception
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.a.b.a(android.content.Context):boolean");
    }

    public <T> T a(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) throws Throwable {
        Method method = this.f27688c;
        if (method != null) {
            return method.invoke((Object) null, new Object[]{cls, obj, str, clsArr, objArr});
        }
        throw new Throwable("IHA is null");
    }

    public <T> T a(String str, Object obj, String str2, Class[] clsArr, Object[] objArr) throws Throwable {
        Method method = this.f27689d;
        if (method != null) {
            return method.invoke((Object) null, new Object[]{str, obj, str2, clsArr, objArr});
        }
        throw new Throwable("IHABC is null");
    }

    public <T> T a(String str) throws Throwable {
        Method method = this.f27690e;
        if (method != null) {
            return method.invoke((Object) null, new Object[]{str});
        }
        throw new Throwable("nHI is null");
    }

    public <T> T a(String str, String str2, Object obj) throws Throwable {
        Method method = this.f27692g;
        if (method != null) {
            return method.invoke((Object) null, new Object[]{str, str2, obj});
        }
        throw new Throwable("gHF is null");
    }

    public <T> T a(String str, Class[] clsArr, Object[] objArr) throws Throwable {
        Method method = this.f27691f;
        if (method != null) {
            return method.invoke((Object) null, new Object[]{str, clsArr, objArr});
        }
        throw new Throwable("nHIByParams is null");
    }
}
