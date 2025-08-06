package a1;

import android.os.Build;
import android.text.Spannable;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import androidx.core.util.d;
import com.huochat.community.network.domain.DomainTool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f3473a = new String[0];

    /* renamed from: b  reason: collision with root package name */
    public static final Comparator<a> f3474b = b.f3472b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public URLSpan f3475a;

        /* renamed from: b  reason: collision with root package name */
        public String f3476b;

        /* renamed from: c  reason: collision with root package name */
        public int f3477c;

        /* renamed from: d  reason: collision with root package name */
        public int f3478d;
    }

    public static boolean b(Spannable spannable, int i11) {
        if (j()) {
            return Linkify.addLinks(spannable, i11);
        }
        if (i11 == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        if ((i11 & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        ArrayList arrayList = new ArrayList();
        if ((i11 & 1) != 0) {
            e(arrayList, spannable, d.f8477h, new String[]{DomainTool.DOMAIN_PREFIX_HTTP, DomainTool.DOMAIN_PREFIX, "rtsp://"}, Linkify.sUrlMatchFilter, (Linkify.TransformFilter) null);
        }
        if ((i11 & 2) != 0) {
            e(arrayList, spannable, d.f8478i, new String[]{"mailto:"}, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
        }
        if ((i11 & 8) != 0) {
            f(arrayList, spannable);
        }
        i(arrayList, spannable);
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            a aVar = (a) it2.next();
            if (aVar.f3475a == null) {
                c(aVar.f3476b, aVar.f3477c, aVar.f3478d, spannable);
            }
        }
        return true;
    }

    public static void c(String str, int i11, int i12, Spannable spannable) {
        spannable.setSpan(new URLSpan(str), i11, i12, 33);
    }

    public static String d(String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            return WebView.findAddress(str);
        }
        return a.c(str);
    }

    public static void e(ArrayList<a> arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group(0);
            if ((matchFilter == null || matchFilter.acceptMatch(spannable, start, end)) && group != null) {
                a aVar = new a();
                aVar.f3476b = h(group, strArr, matcher, transformFilter);
                aVar.f3477c = start;
                aVar.f3478d = end;
                arrayList.add(aVar);
            }
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0005 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0005 A[LOOP:0: B:1:0x0005->B:14:0x0005, LOOP_START, PHI: r0 r6 
      PHI: (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:0:0x0000, B:14:0x0005] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r6v2 java.lang.String) = (r6v1 java.lang.String), (r6v3 java.lang.String) binds: [B:0:0x0000, B:14:0x0005] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void f(java.util.ArrayList<a1.c.a> r5, android.text.Spannable r6) {
        /*
            java.lang.String r6 = r6.toString()
            r0 = 0
        L_0x0005:
            java.lang.String r1 = d(r6)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            if (r1 == 0) goto L_0x0043
            int r2 = r6.indexOf(r1)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            if (r2 >= 0) goto L_0x0012
            goto L_0x0043
        L_0x0012:
            a1.c$a r3 = new a1.c$a     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r3.<init>()     // Catch:{ UnsupportedOperationException -> 0x0043 }
            int r4 = r1.length()     // Catch:{ UnsupportedOperationException -> 0x0043 }
            int r4 = r4 + r2
            int r2 = r2 + r0
            r3.f3477c = r2     // Catch:{ UnsupportedOperationException -> 0x0043 }
            int r0 = r0 + r4
            r3.f3478d = r0     // Catch:{ UnsupportedOperationException -> 0x0043 }
            java.lang.String r6 = r6.substring(r4)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            java.lang.String r2 = "UTF-8"
            java.lang.String r1 = java.net.URLEncoder.encode(r1, r2)     // Catch:{ UnsupportedEncodingException -> 0x0005 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r2.<init>()     // Catch:{ UnsupportedOperationException -> 0x0043 }
            java.lang.String r4 = "geo:0,0?q="
            r2.append(r4)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r2.append(r1)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            java.lang.String r1 = r2.toString()     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r3.f3476b = r1     // Catch:{ UnsupportedOperationException -> 0x0043 }
            r5.add(r3)     // Catch:{ UnsupportedOperationException -> 0x0043 }
            goto L_0x0005
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.c.f(java.util.ArrayList, android.text.Spannable):void");
    }

    public static /* synthetic */ int g(a aVar, a aVar2) {
        int i11 = aVar.f3477c;
        int i12 = aVar2.f3477c;
        if (i11 < i12) {
            return -1;
        }
        if (i11 > i12) {
            return 1;
        }
        return Integer.compare(aVar2.f3478d, aVar.f3478d);
    }

    public static String h(String str, String[] strArr, Matcher matcher, Linkify.TransformFilter transformFilter) {
        boolean z11;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int length = strArr.length;
        int i11 = 0;
        while (true) {
            z11 = true;
            if (i11 >= length) {
                z11 = false;
                break;
            }
            String str2 = strArr[i11];
            if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                if (!str.regionMatches(false, 0, str2, 0, str2.length())) {
                    str = str2 + str.substring(str2.length());
                }
            } else {
                i11++;
            }
        }
        if (z11 || strArr.length <= 0) {
            return str;
        }
        return strArr[0] + str;
    }

    public static void i(ArrayList<a> arrayList, Spannable spannable) {
        int i11;
        int i12 = 0;
        for (URLSpan uRLSpan : (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class)) {
            a aVar = new a();
            aVar.f3475a = uRLSpan;
            aVar.f3477c = spannable.getSpanStart(uRLSpan);
            aVar.f3478d = spannable.getSpanEnd(uRLSpan);
            arrayList.add(aVar);
        }
        Collections.sort(arrayList, f3474b);
        int size = arrayList.size();
        while (i12 < size - 1) {
            a aVar2 = arrayList.get(i12);
            int i13 = i12 + 1;
            a aVar3 = arrayList.get(i13);
            int i14 = aVar2.f3477c;
            int i15 = aVar3.f3477c;
            if (i14 <= i15 && (i11 = aVar2.f3478d) > i15) {
                int i16 = aVar3.f3478d;
                int i17 = (i16 > i11 && i11 - i14 <= i16 - i15) ? i11 - i14 < i16 - i15 ? i12 : -1 : i13;
                if (i17 != -1) {
                    URLSpan uRLSpan2 = arrayList.get(i17).f3475a;
                    if (uRLSpan2 != null) {
                        spannable.removeSpan(uRLSpan2);
                    }
                    arrayList.remove(i17);
                    size--;
                }
            }
            i12 = i13;
        }
    }

    public static boolean j() {
        return Build.VERSION.SDK_INT >= 28;
    }
}
