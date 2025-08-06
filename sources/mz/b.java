package mz;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.Locale;

public class b {
    public static String a(String str) {
        int lastIndexOf;
        if (!f.c(str) || (lastIndexOf = str.lastIndexOf(InstructionFileId.DOT)) == -1) {
            return "";
        }
        return str.substring(lastIndexOf + 1).toLowerCase(Locale.US).trim();
    }

    public static String b(Long l11) {
        return c(l11, true);
    }

    public static String c(Long l11, boolean z11) {
        String str = "";
        if (l11 == null || l11.longValue() < 0) {
            return str;
        }
        int i11 = z11 ? 1000 : 1024;
        if (l11.longValue() < ((long) i11)) {
            return l11 + " B";
        }
        double d11 = (double) i11;
        int log = (int) (Math.log((double) l11.longValue()) / Math.log(d11));
        StringBuilder sb2 = new StringBuilder();
        sb2.append((z11 ? "kMGTPE" : "KMGTPE").charAt(log - 1));
        if (!z11) {
            str = "i";
        }
        sb2.append(str);
        return String.format(Locale.US, "%.1f %sB", new Object[]{Double.valueOf(((double) l11.longValue()) / Math.pow(d11, (double) log)), sb2.toString()});
    }
}
