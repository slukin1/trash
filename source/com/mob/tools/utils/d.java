package com.mob.tools.utils;

import android.content.Context;
import android.text.TextUtils;
import com.mob.commons.l;
import com.mob.tools.MobLog;
import com.mob.tools.b.b;
import java.io.File;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f28172a;

    public d(Context context) {
        this.f28172a = context;
    }

    private boolean b() {
        try {
            String str = null;
            Object invokeStaticMethodNoThrow = ReflectHelper.invokeStaticMethodNoThrow(ReflectHelper.importClassNoThrow(l.a("027fg%feflfmfkfefnfmhkfngngehkJkh9fhinflfm_lhVfl4k0fk7h3hk"), (String) null), l.a("003WglYhk"), "", "ro.build.tags");
            if (invokeStaticMethodNoThrow != null) {
                str = String.valueOf(invokeStaticMethodNoThrow);
            }
            if ((str != null && str.contains(l.a("009khShk*k^jmgjGh>gehk"))) || g()) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean c() {
        return "0".equals(b.a(this.f28172a).a(l.a("020WflfmfnhhfmfmZk'fngh@ifUhk_j3fn@iDfmVe2gj!hVfe")));
    }

    private boolean d() {
        String a11 = b.a(this.f28172a).a(l.a("025$flfmfnhhfmfm)kSfnff$hWflfkghfkLh@fehhfmfm3k*hk<kfkh"));
        if (a11 == null) {
            return false;
        }
        if (TextUtils.equals(a11.toLowerCase(), "orange") || TextUtils.equals(a11.toLowerCase(), "red")) {
            return true;
        }
        return false;
    }

    private boolean e() {
        String a11 = b.a(this.f28172a).a(l.a("027GflfmfnhhfmfmOkAfnffhhfhHhkf5fnfe9h$fffk!ehXfjhkEkfkh"));
        return a11 != null && TextUtils.equals(l.a("008IfiAgi(fmGe_gj+hBfe"), a11.toLowerCase());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009c A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean f() {
        /*
            r11 = this;
            java.lang.String r0 = "007BfeHhQhk_kCflfmge"
            int r1 = android.os.Process.myPid()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 1
            r4 = 2
            r5 = 0
            r6 = 0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            r7.<init>()     // Catch:{ all -> 0x0086 }
            r7.append(r1)     // Catch:{ all -> 0x0086 }
            java.lang.String r1 = "007nTfhfmfiFgk,hk"
            java.lang.String r1 = com.mob.commons.l.a((java.lang.String) r1)     // Catch:{ all -> 0x0086 }
            r7.append(r1)     // Catch:{ all -> 0x0086 }
            java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x0086 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            r7.<init>()     // Catch:{ all -> 0x0086 }
            java.lang.String r8 = "010efkXkhUnlEflfmJen"
            java.lang.String r8 = com.mob.commons.l.a((java.lang.String) r8)     // Catch:{ all -> 0x0086 }
            r7.append(r8)     // Catch:{ all -> 0x0086 }
            r7.append(r1)     // Catch:{ all -> 0x0086 }
            java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x0086 }
            java.lang.Object r1 = com.mob.commons.v.c(r1)     // Catch:{ all -> 0x0086 }
            java.lang.String r7 = "0142gl^hk7gg-glIfi*k3gn*k8flQhfSfh"
            java.lang.String r7 = com.mob.commons.l.a((java.lang.String) r7)     // Catch:{ all -> 0x0083 }
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x0083 }
            java.lang.Object r7 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r1, r7, r6, r8)     // Catch:{ all -> 0x0083 }
            java.io.InputStream r7 = (java.io.InputStream) r7     // Catch:{ all -> 0x0083 }
            if (r7 == 0) goto L_0x006d
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ all -> 0x006a }
            java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ all -> 0x006a }
            java.lang.String r10 = "utf-8"
            r9.<init>(r7, r10)     // Catch:{ all -> 0x006a }
            r8.<init>(r9)     // Catch:{ all -> 0x006a }
        L_0x0059:
            java.lang.String r9 = r8.readLine()     // Catch:{ all -> 0x0068 }
            if (r9 == 0) goto L_0x006e
            r2.append(r9)     // Catch:{ all -> 0x0068 }
            java.lang.String r9 = "\n"
            r2.append(r9)     // Catch:{ all -> 0x0068 }
            goto L_0x0059
        L_0x0068:
            r9 = move-exception
            goto L_0x008a
        L_0x006a:
            r9 = move-exception
            r8 = r6
            goto L_0x008a
        L_0x006d:
            r8 = r6
        L_0x006e:
            java.io.Closeable[] r4 = new java.io.Closeable[r4]
            r4[r5] = r8
            r4[r3] = r7
            com.mob.commons.v.a((java.io.Closeable[]) r4)
            if (r1 == 0) goto L_0x00a5
            java.lang.String r0 = com.mob.commons.l.a((java.lang.String) r0)
            java.lang.Object[] r3 = new java.lang.Object[r5]
            com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r1, r0, r6, r3)
            goto L_0x00a5
        L_0x0083:
            r9 = move-exception
            r7 = r6
            goto L_0x0089
        L_0x0086:
            r9 = move-exception
            r1 = r6
            r7 = r1
        L_0x0089:
            r8 = r7
        L_0x008a:
            com.mob.tools.log.NLog r10 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x00b4 }
            r10.d(r9)     // Catch:{ all -> 0x00b4 }
            java.io.Closeable[] r4 = new java.io.Closeable[r4]
            r4[r5] = r8
            r4[r3] = r7
            com.mob.commons.v.a((java.io.Closeable[]) r4)
            if (r1 == 0) goto L_0x00a5
            java.lang.String r0 = com.mob.commons.l.a((java.lang.String) r0)
            java.lang.Object[] r3 = new java.lang.Object[r5]
            com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r1, r0, r6, r3)
        L_0x00a5:
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "006Ofh)fQglfkhkgj"
            java.lang.String r1 = com.mob.commons.l.a((java.lang.String) r1)
            boolean r0 = r0.contains(r1)
            return r0
        L_0x00b4:
            r2 = move-exception
            java.io.Closeable[] r4 = new java.io.Closeable[r4]
            r4[r5] = r8
            r4[r3] = r7
            com.mob.commons.v.a((java.io.Closeable[]) r4)
            if (r1 == 0) goto L_0x00c9
            java.lang.String r0 = com.mob.commons.l.a((java.lang.String) r0)
            java.lang.Object[] r3 = new java.lang.Object[r5]
            com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r1, r0, r6, r3)
        L_0x00c9:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.d.f():boolean");
    }

    private boolean g() {
        try {
            if (new File(l.a("025n_hkgehkJkhDfhVnfllnEgnfi:lh)flfihkBhFflfn@flUgj")).exists()) {
                return true;
            }
            String[] strArr = {l.a("012n>feTfkfniAfm$efin"), l.a("016nXfeDfkfni?fm=efinLhhfk9gn"), l.a("017n%feVfkfni^fm%efinVgkhhfk[gn"), l.a("006nLhkhhfk*gn"), l.a("008nJhkfi n>hhfkYgn"), l.a("012n3hkgehk=khVfh:nWhhfk!gn"), l.a("017nIhkgehk]khUfhPnBhhfk gnVfn3h]gk<kn"), l.a("021nBhkgehkTkhJfh.n_hhfkJgnSghJf?fk8iZhk'f*gh_hn"), l.a("016nUhkgehk*khLfh0n-hkfe_nPgkhhfk,gn"), l.a("025nVhkgehk?khHfh8n%fihkfl8n=hiSh8jm7ghh>fejmflfmfm8kn"), l.a("013n]hkgehk6kh%fhZn1gkhhfk<gn"), l.a("013n5hkgehk*kh+fhKn%hkhhfk3gn"), l.a("012nJff3hg(fefmfl%nBhhfk:gn"), l.a("006nefejh"), l.a("005nJfe:fkf"), l.a("004n*feRhCff")};
            for (int i11 = 0; i11 < 16; i11++) {
                if (new File(strArr[i11], l.a("002Uhkfi")).exists()) {
                    return true;
                }
            }
            for (int i12 = 0; i12 < 16; i12++) {
                if (new File(strArr[i12], l.a("007'hhfihkgehhfmgk")).exists()) {
                    return true;
                }
            }
            for (int i13 = 0; i13 < 16; i13++) {
                if (new File(strArr[i13], l.a("006BfhYf7glfkhkgj")).exists()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
        }
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder("");
        try {
            if (d()) {
                sb2.append("1");
            } else {
                sb2.append("0");
            }
            if (e()) {
                sb2.append("1");
            } else {
                sb2.append("0");
            }
            if (c()) {
                sb2.append("1");
            } else {
                sb2.append("0");
            }
            if (b()) {
                sb2.append("1");
            } else {
                sb2.append("0");
            }
            if (f()) {
                sb2.append("1");
            } else {
                sb2.append("0");
            }
        } catch (Throwable unused) {
        }
        return sb2.toString();
    }
}
