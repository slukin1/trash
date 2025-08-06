package cn.sharesdk.framework.utils;

import android.util.Base64;
import com.mob.tools.network.KVPair;
import com.twitter.sdk.android.core.internal.oauth.OAuthConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private C0063b f13506a = new C0063b();

    /* renamed from: b  reason: collision with root package name */
    private d f13507b = new d("-._~", false);

    /* renamed from: cn.sharesdk.framework.utils.b$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f13508a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                cn.sharesdk.framework.utils.b$a[] r0 = cn.sharesdk.framework.utils.b.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13508a = r0
                cn.sharesdk.framework.utils.b$a r1 = cn.sharesdk.framework.utils.b.a.HMAC_SHA1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f13508a     // Catch:{ NoSuchFieldError -> 0x001d }
                cn.sharesdk.framework.utils.b$a r1 = cn.sharesdk.framework.utils.b.a.PLAINTEXT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.framework.utils.b.AnonymousClass1.<clinit>():void");
        }
    }

    public enum a {
        HMAC_SHA1,
        PLAINTEXT
    }

    /* renamed from: cn.sharesdk.framework.utils.b$b  reason: collision with other inner class name */
    public static class C0063b {

        /* renamed from: a  reason: collision with root package name */
        public String f13512a;

        /* renamed from: b  reason: collision with root package name */
        public String f13513b;

        /* renamed from: c  reason: collision with root package name */
        public String f13514c;

        /* renamed from: d  reason: collision with root package name */
        public String f13515d;

        /* renamed from: e  reason: collision with root package name */
        public String f13516e;
    }

    public void a(String str, String str2, String str3) {
        C0063b bVar = this.f13506a;
        bVar.f13512a = str;
        bVar.f13513b = str2;
        bVar.f13516e = str3;
    }

    public ArrayList<KVPair<String>> b(String str, ArrayList<KVPair<String>> arrayList) throws Throwable {
        return b(str, arrayList, a.HMAC_SHA1);
    }

    public ArrayList<KVPair<String>> c(String str, ArrayList<KVPair<String>> arrayList, a aVar) throws Throwable {
        return a(str, "PUT", arrayList, aVar);
    }

    public ArrayList<KVPair<String>> b(String str, ArrayList<KVPair<String>> arrayList, a aVar) throws Throwable {
        return a(str, "GET", arrayList, aVar);
    }

    private String b(ArrayList<KVPair<String>> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        Iterator<KVPair<String>> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            KVPair next = it2.next();
            if (i11 > 0) {
                sb2.append('&');
            }
            sb2.append(next.name);
            sb2.append('=');
            sb2.append((String) next.value);
            i11++;
        }
        return sb2.toString();
    }

    public C0063b a() {
        return this.f13506a;
    }

    public ArrayList<KVPair<String>> a(String str, ArrayList<KVPair<String>> arrayList) throws Throwable {
        return a(str, arrayList, a.HMAC_SHA1);
    }

    public ArrayList<KVPair<String>> a(String str, ArrayList<KVPair<String>> arrayList, a aVar) throws Throwable {
        return a(str, "POST", arrayList, aVar);
    }

    public void a(String str, String str2) {
        C0063b bVar = this.f13506a;
        bVar.f13514c = str;
        bVar.f13515d = str2;
    }

    private ArrayList<KVPair<String>> a(String str, String str2, ArrayList<KVPair<String>> arrayList, a aVar) throws Throwable {
        String str3;
        long currentTimeMillis = System.currentTimeMillis();
        int i11 = AnonymousClass1.f13508a[aVar.ordinal()];
        String str4 = null;
        if (i11 == 1) {
            SecretKeySpec secretKeySpec = new SecretKeySpec((a(this.f13506a.f13513b) + '&' + a(this.f13506a.f13515d)).getBytes("utf-8"), "HMAC-SHA1");
            Mac instance = Mac.getInstance("HMAC-SHA1");
            instance.init(secretKeySpec);
            String b11 = b(a(currentTimeMillis, arrayList, "HMAC-SHA1"));
            str3 = new String(Base64.encode(instance.doFinal((str2 + '&' + a(str) + '&' + a(b11)).getBytes("utf-8")), 0)).trim();
            str4 = "HMAC-SHA1";
        } else if (i11 != 2) {
            str3 = null;
        } else {
            str4 = "PLAINTEXT";
            str3 = a(this.f13506a.f13513b) + '&' + a(this.f13506a.f13515d);
        }
        ArrayList<KVPair<String>> a11 = a(currentTimeMillis, str4);
        a11.add(new KVPair(OAuthConstants.PARAM_SIGNATURE, str3));
        return a11;
    }

    public String a(String str) {
        return str == null ? "" : this.f13507b.escape(str);
    }

    private ArrayList<KVPair<String>> a(long j11, ArrayList<KVPair<String>> arrayList, String str) {
        HashMap hashMap = new HashMap();
        if (arrayList != null) {
            Iterator<KVPair<String>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                KVPair next = it2.next();
                hashMap.put(a(next.name), a((String) next.value));
            }
        }
        ArrayList<KVPair<String>> a11 = a(j11, str);
        if (a11 != null) {
            Iterator<KVPair<String>> it3 = a11.iterator();
            while (it3.hasNext()) {
                KVPair next2 = it3.next();
                hashMap.put(a(next2.name), a((String) next2.value));
            }
        }
        int size = hashMap.size();
        String[] strArr = new String[size];
        int i11 = 0;
        for (Map.Entry key : hashMap.entrySet()) {
            strArr[i11] = (String) key.getKey();
            i11++;
        }
        Arrays.sort(strArr);
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        for (int i12 = 0; i12 < size; i12++) {
            String str2 = strArr[i12];
            arrayList2.add(new KVPair(str2, hashMap.get(str2)));
        }
        return arrayList2;
    }

    private ArrayList<KVPair<String>> a(long j11, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair(OAuthConstants.PARAM_CONSUMER_KEY, this.f13506a.f13512a));
        arrayList.add(new KVPair(OAuthConstants.PARAM_SIGNATURE_METHOD, str));
        arrayList.add(new KVPair(OAuthConstants.PARAM_TIMESTAMP, String.valueOf(j11 / 1000)));
        arrayList.add(new KVPair(OAuthConstants.PARAM_NONCE, String.valueOf(j11)));
        arrayList.add(new KVPair(OAuthConstants.PARAM_VERSION, "1.0"));
        String str2 = this.f13506a.f13514c;
        if (str2 != null && str2.length() > 0) {
            arrayList.add(new KVPair(OAuthConstants.PARAM_TOKEN, str2));
        }
        return arrayList;
    }

    public ArrayList<KVPair<String>> a(ArrayList<KVPair<String>> arrayList) {
        StringBuilder sb2 = new StringBuilder("OAuth ");
        Iterator<KVPair<String>> it2 = arrayList.iterator();
        int i11 = 0;
        while (it2.hasNext()) {
            KVPair next = it2.next();
            if (i11 > 0) {
                sb2.append(',');
            }
            String a11 = a((String) next.value);
            sb2.append(next.name);
            sb2.append("=\"");
            sb2.append(a11);
            sb2.append("\"");
            i11++;
        }
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair("Authorization", sb2.toString()));
        arrayList2.add(new KVPair("Content-Type", "application/x-www-form-urlencoded"));
        return arrayList2;
    }
}
