package ig;

import android.annotation.SuppressLint;
import android.os.Build;
import com.huawei.secure.android.common.encrypt.utils.BaseKeyUtil;

public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final String f40505b = "RootKeyUtil";

    /* renamed from: a  reason: collision with root package name */
    public byte[] f40506a = null;

    public static b d(String str, String str2, String str3, String str4) {
        b bVar = new b();
        bVar.a(str, str2, str3, str4);
        return bVar;
    }

    public final void a(String str, String str2, String str3, String str4) {
        b(str, str2, str3, a.b(str4));
    }

    @SuppressLint({"NewApi"})
    public final void b(String str, String str2, String str3, byte[] bArr) {
        if (Build.VERSION.SDK_INT < 26) {
            com.huawei.secure.android.common.encrypt.utils.b.d(f40505b, "initRootKey: sha1");
            this.f40506a = BaseKeyUtil.h(str, str2, str3, bArr, false);
            return;
        }
        com.huawei.secure.android.common.encrypt.utils.b.d(f40505b, "initRootKey: sha256");
        this.f40506a = BaseKeyUtil.h(str, str2, str3, bArr, true);
    }

    public byte[] c() {
        return (byte[]) this.f40506a.clone();
    }
}
