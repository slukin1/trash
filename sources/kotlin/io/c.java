package kotlin.io;

import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.File;

public final class c {
    public static final String b(File file, File file2, String str) {
        StringBuilder sb2 = new StringBuilder(file.toString());
        if (file2 != null) {
            sb2.append(" -> " + file2);
        }
        if (str != null) {
            sb2.append(l.f34627b + str);
        }
        return sb2.toString();
    }
}
