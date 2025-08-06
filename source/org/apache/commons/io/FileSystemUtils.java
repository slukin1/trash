package org.apache.commons.io;

import com.eclipsesource.v8.Platform;
import java.io.IOException;
import java.util.Locale;

@Deprecated
public class FileSystemUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final FileSystemUtils f58925a = new FileSystemUtils();

    /* renamed from: b  reason: collision with root package name */
    public static final int f58926b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f58927c;

    static {
        int i11;
        String str = "df";
        try {
            String property = System.getProperty("os.name");
            if (property != null) {
                String lowerCase = property.toLowerCase(Locale.ENGLISH);
                i11 = 3;
                if (lowerCase.contains(Platform.WINDOWS)) {
                    i11 = 1;
                } else {
                    if (!lowerCase.contains(Platform.LINUX) && !lowerCase.contains("mpe/ix") && !lowerCase.contains("freebsd") && !lowerCase.contains("openbsd") && !lowerCase.contains("irix") && !lowerCase.contains("digital unix") && !lowerCase.contains("unix")) {
                        if (!lowerCase.contains("mac os x")) {
                            if (!lowerCase.contains("sun os") && !lowerCase.contains("sunos")) {
                                if (!lowerCase.contains("solaris")) {
                                    if (!lowerCase.contains("hp-ux")) {
                                        if (!lowerCase.contains("aix")) {
                                            i11 = 0;
                                        }
                                    }
                                }
                            }
                            str = "/usr/xpg4/bin/df";
                        }
                    }
                    i11 = 2;
                }
                f58926b = i11;
                f58927c = str;
                return;
            }
            throw new IOException("os.name not found");
        } catch (Exception unused) {
            i11 = -1;
        }
    }
}
