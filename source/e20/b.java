package e20;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;
import org.cybergarage.util.Debug;

public class b {

    /* renamed from: c  reason: collision with root package name */
    public static int f54268c = 1024;

    /* renamed from: a  reason: collision with root package name */
    public String f54269a;

    /* renamed from: b  reason: collision with root package name */
    public String f54270b;

    public b(String str, String str2) {
        h(str);
        i(str2);
    }

    public static final int a(byte[] bArr, String str) {
        try {
            return Integer.parseInt(f(bArr, str));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static final String d(LineNumberReader lineNumberReader, String str) {
        String upperCase = str.toUpperCase();
        try {
            String readLine = lineNumberReader.readLine();
            while (true) {
                if (readLine == null) {
                    break;
                } else if (readLine.length() <= 0) {
                    break;
                } else {
                    b bVar = new b(readLine);
                    if (!bVar.g()) {
                        readLine = lineNumberReader.readLine();
                    } else if (bVar.b().toUpperCase().equals(upperCase)) {
                        return bVar.c();
                    } else {
                        readLine = lineNumberReader.readLine();
                    }
                }
            }
            return "";
        } catch (IOException e11) {
            Debug.d(e11);
            return "";
        }
    }

    public static final String e(String str, String str2) {
        return d(new LineNumberReader(new StringReader(str), Math.min(str.length(), f54268c)), str2);
    }

    public static final String f(byte[] bArr, String str) {
        return e(new String(bArr), str);
    }

    public String b() {
        return this.f54269a;
    }

    public String c() {
        return this.f54270b;
    }

    public boolean g() {
        String str = this.f54269a;
        return str != null && str.length() > 0;
    }

    public void h(String str) {
        this.f54269a = str;
    }

    public void i(String str) {
        this.f54270b = str;
    }

    public b(String str) {
        int indexOf;
        h("");
        i("");
        if (str != null && (indexOf = str.indexOf(58)) >= 0) {
            String str2 = new String(str.getBytes(), 0, indexOf);
            String str3 = new String(str.getBytes(), indexOf + 1, (str.length() - indexOf) - 1);
            h(str2.trim());
            i(str3.trim());
        }
    }
}
