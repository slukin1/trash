package com.huawei.secure.android.common.ssl.hostname;

import com.huawei.secure.android.common.ssl.util.e;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import kg.a;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f38653a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f38654b;

    static {
        String[] strArr = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        f38654b = strArr;
        Arrays.sort(strArr);
    }

    public static final void a(String str, X509Certificate x509Certificate, boolean z11) throws SSLException {
        String[] d11 = d(x509Certificate);
        String[] f11 = f(x509Certificate);
        e.b("", "cn is : " + Arrays.toString(d11));
        e.b("", "san is : " + Arrays.toString(f11));
        b(str, d11, f11, z11);
    }

    public static final void b(String str, String[] strArr, String[] strArr2, boolean z11) throws SSLException {
        LinkedList linkedList = new LinkedList();
        if (!(strArr == null || strArr.length <= 0 || strArr[0] == null)) {
            linkedList.add(strArr[0]);
        }
        if (strArr2 != null) {
            for (String str2 : strArr2) {
                if (str2 != null) {
                    linkedList.add(str2);
                }
            }
        }
        if (!linkedList.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
            Iterator it2 = linkedList.iterator();
            boolean z12 = false;
            while (it2.hasNext()) {
                String lowerCase2 = ((String) it2.next()).toLowerCase(Locale.ENGLISH);
                stringBuffer.append(" <");
                stringBuffer.append(lowerCase2);
                stringBuffer.append('>');
                if (it2.hasNext()) {
                    stringBuffer.append(" OR");
                }
                if (lowerCase2.startsWith("*.") && lowerCase2.indexOf(46, 2) != -1 && c(lowerCase2) && !g(str)) {
                    boolean endsWith = lowerCase.endsWith(lowerCase2.substring(1));
                    if (!endsWith || !z11) {
                        z12 = endsWith;
                        continue;
                    } else if (e(lowerCase) == e(lowerCase2)) {
                        z12 = true;
                        continue;
                    } else {
                        z12 = false;
                        continue;
                    }
                } else {
                    z12 = lowerCase.equals(lowerCase2);
                    continue;
                }
                if (z12) {
                    break;
                }
            }
            if (!z12) {
                throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + stringBuffer);
            }
            return;
        }
        throw new SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
    }

    public static boolean c(String str) {
        int length = str.length();
        if (length < 7 || length > 9) {
            return true;
        }
        int i11 = length - 3;
        if (str.charAt(i11) != '.') {
            return true;
        }
        if (Arrays.binarySearch(f38654b, str.substring(2, i11)) < 0) {
            return true;
        }
        return false;
    }

    public static String[] d(X509Certificate x509Certificate) {
        List<String> d11 = new a(x509Certificate.getSubjectX500Principal()).d("cn");
        if (d11.isEmpty()) {
            return null;
        }
        String[] strArr = new String[d11.size()];
        d11.toArray(strArr);
        return strArr;
    }

    public static int e(String str) {
        int i11 = 0;
        for (int i12 = 0; i12 < str.length(); i12++) {
            if (str.charAt(i12) == '.') {
                i11++;
            }
        }
        return i11;
    }

    public static String[] f(X509Certificate x509Certificate) {
        Collection<List<?>> collection;
        LinkedList linkedList = new LinkedList();
        try {
            collection = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException e11) {
            e.c("", "Error parsing certificate.", e11);
            collection = null;
        }
        if (collection != null) {
            for (List next : collection) {
                if (((Integer) next.get(0)).intValue() == 2) {
                    linkedList.add((String) next.get(1));
                }
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    public static boolean g(String str) {
        return f38653a.matcher(str).matches();
    }
}
