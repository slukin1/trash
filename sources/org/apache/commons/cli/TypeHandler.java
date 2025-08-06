package org.apache.commons.cli;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class TypeHandler {
    public static Class a(String str) throws ParseException {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unable to find the class: ");
            stringBuffer.append(str);
            throw new ParseException(stringBuffer.toString());
        }
    }

    public static Date b(String str) throws ParseException {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static File c(String str) throws ParseException {
        return new File(str);
    }

    public static File[] d(String str) throws ParseException {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static Number e(String str) throws ParseException {
        try {
            if (str.indexOf(46) != -1) {
                return Double.valueOf(str);
            }
            return Long.valueOf(str);
        } catch (NumberFormatException e11) {
            throw new ParseException(e11.getMessage());
        }
    }

    public static Object f(String str) throws ParseException {
        try {
            try {
                return Class.forName(str).newInstance();
            } catch (Exception e11) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(e11.getClass().getName());
                stringBuffer.append("; Unable to create an instance of: ");
                stringBuffer.append(str);
                throw new ParseException(stringBuffer.toString());
            }
        } catch (ClassNotFoundException unused) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Unable to find the class: ");
            stringBuffer2.append(str);
            throw new ParseException(stringBuffer2.toString());
        }
    }

    public static URL g(String str) throws ParseException {
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unable to parse the URL: ");
            stringBuffer.append(str);
            throw new ParseException(stringBuffer.toString());
        }
    }

    public static Object h(String str, Class cls) throws ParseException {
        if (PatternOptionBuilder.f58892a == cls) {
            return str;
        }
        if (PatternOptionBuilder.f58893b == cls) {
            return f(str);
        }
        if (PatternOptionBuilder.f58894c == cls) {
            return e(str);
        }
        if (PatternOptionBuilder.f58895d == cls) {
            return b(str);
        }
        if (PatternOptionBuilder.f58896e == cls) {
            return a(str);
        }
        if (PatternOptionBuilder.f58898g == cls) {
            return c(str);
        }
        if (PatternOptionBuilder.f58897f == cls) {
            return c(str);
        }
        if (PatternOptionBuilder.f58899h == cls) {
            return d(str);
        }
        if (PatternOptionBuilder.f58900i == cls) {
            return g(str);
        }
        return null;
    }

    public static Object i(String str, Object obj) throws ParseException {
        return h(str, (Class) obj);
    }
}
