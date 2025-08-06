package jumio.core;

import com.jumio.core.plugins.Plugin;
import java.util.List;

public interface e2 {

    public static final class a {
        public static String a(e2 e2Var) {
            String str;
            String str2;
            d2[] values = d2.values();
            int length = values.length;
            String str3 = "";
            int i11 = 0;
            while (true) {
                str = "1";
                if (i11 >= length) {
                    break;
                }
                if (!e2Var.b(values[i11])) {
                    str = "0";
                }
                str3 = str3 + str;
                i11++;
            }
            for (c2 a11 : c2.values()) {
                if (e2Var.a(a11)) {
                    str2 = str;
                } else {
                    str2 = "0";
                }
                str3 = str3 + str2;
            }
            return str3;
        }
    }

    <T extends Plugin> T a(d2 d2Var);

    void a();

    boolean a(c2 c2Var);

    String b();

    boolean b(d2 d2Var);

    List<String> c();
}
