package jumio.core;

import com.huobi.coupon.bean.CouponReturn;
import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.CredentialsModel;
import com.jumio.core.util.ConcurrentMutableList;
import com.jumio.core.util.ConcurrentMutableListKt;
import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.enums.JumioScanStep;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.x;

@PersistWith("ReportingModel")
public final class l2 implements StaticModel {

    /* renamed from: a  reason: collision with root package name */
    public final TreeMap<String, a> f56243a = new TreeMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentMutableList<d2> f56244b = ConcurrentMutableListKt.concurrentMutableListOf();

    /* renamed from: c  reason: collision with root package name */
    public String f56245c = "";

    /* renamed from: d  reason: collision with root package name */
    public JumioCredentialPart f56246d;

    /* renamed from: e  reason: collision with root package name */
    public JumioScanStep f56247e;

    /* renamed from: f  reason: collision with root package name */
    public long f56248f;

    public final class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final b f56249a = new b();

        /* renamed from: b  reason: collision with root package name */
        public final HashMap<JumioCredentialPart, b> f56250b = new HashMap<>();

        public a(l2 l2Var) {
        }
    }

    public final class b implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public long f56251a;

        /* renamed from: b  reason: collision with root package name */
        public long f56252b;
    }

    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f56253a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f56254b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f56255c;

        /* JADX WARNING: Can't wrap try/catch for region: R(57:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|33|34|35|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|(2:69|70)|71|73) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|(2:21|22)|23|(2:25|26)|27|29|30|31|33|34|35|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|73) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|17|18|19|(2:21|22)|23|(2:25|26)|27|29|30|31|33|34|35|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|73) */
        /* JADX WARNING: Can't wrap try/catch for region: R(61:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|17|18|19|(2:21|22)|23|25|26|27|29|30|31|33|34|35|(2:37|38)|39|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|73) */
        /* JADX WARNING: Can't wrap try/catch for region: R(64:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|73) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x008a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x009a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00a2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00b2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00ba */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00c4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00e2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x00ec */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x00f6 */
        static {
            /*
                com.jumio.core.data.ScanMode[] r0 = com.jumio.core.data.ScanMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.jumio.core.data.ScanMode r2 = com.jumio.core.data.ScanMode.JUMIO_LIVENESS     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.jumio.core.data.ScanMode r3 = com.jumio.core.data.ScanMode.FACE_MANUAL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.jumio.core.data.ScanMode r4 = com.jumio.core.data.ScanMode.FACE_IPROOV     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f56253a = r0
                com.jumio.sdk.enums.JumioCredentialPart[] r0 = com.jumio.sdk.enums.JumioCredentialPart.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.sdk.enums.JumioCredentialPart r4 = com.jumio.sdk.enums.JumioCredentialPart.FRONT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.jumio.sdk.enums.JumioCredentialPart r4 = com.jumio.sdk.enums.JumioCredentialPart.BACK     // Catch:{ NoSuchFieldError -> 0x003b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.jumio.sdk.enums.JumioCredentialPart r4 = com.jumio.sdk.enums.JumioCredentialPart.MULTIPART     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                r4 = 4
                com.jumio.sdk.enums.JumioCredentialPart r5 = com.jumio.sdk.enums.JumioCredentialPart.NFC     // Catch:{ NoSuchFieldError -> 0x004c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                r5 = 5
                com.jumio.sdk.enums.JumioCredentialPart r6 = com.jumio.sdk.enums.JumioCredentialPart.FACE     // Catch:{ NoSuchFieldError -> 0x0055 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x0055 }
            L_0x0055:
                r6 = 6
                com.jumio.sdk.enums.JumioCredentialPart r7 = com.jumio.sdk.enums.JumioCredentialPart.DEVICE_RISK     // Catch:{ NoSuchFieldError -> 0x005e }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r0[r7] = r6     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                r7 = 7
                com.jumio.sdk.enums.JumioCredentialPart r8 = com.jumio.sdk.enums.JumioCredentialPart.DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r0[r8] = r7     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                r8 = 8
                com.jumio.sdk.enums.JumioCredentialPart r9 = com.jumio.sdk.enums.JumioCredentialPart.DIGITAL     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r0[r9] = r8     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                f56254b = r0
                com.jumio.sdk.enums.JumioScanStep[] r0 = com.jumio.sdk.enums.JumioScanStep.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.sdk.enums.JumioScanStep r9 = com.jumio.sdk.enums.JumioScanStep.PREPARE     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r0[r9] = r1     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.STARTED     // Catch:{ NoSuchFieldError -> 0x008a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008a }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008a }
            L_0x008a:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.ATTACH_ACTIVITY     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.ATTACH_FILE     // Catch:{ NoSuchFieldError -> 0x009a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009a }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x009a }
            L_0x009a:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.DIGITAL_IDENTITY_VIEW     // Catch:{ NoSuchFieldError -> 0x00a2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a2 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00a2 }
            L_0x00a2:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.SCAN_VIEW     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.THIRD_PARTY_VERIFICATION     // Catch:{ NoSuchFieldError -> 0x00b2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b2 }
                r0[r1] = r7     // Catch:{ NoSuchFieldError -> 0x00b2 }
            L_0x00b2:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.IMAGE_TAKEN     // Catch:{ NoSuchFieldError -> 0x00ba }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ba }
                r0[r1] = r8     // Catch:{ NoSuchFieldError -> 0x00ba }
            L_0x00ba:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.NEXT_PART     // Catch:{ NoSuchFieldError -> 0x00c4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c4 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c4 }
            L_0x00c4:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.PROCESSING     // Catch:{ NoSuchFieldError -> 0x00ce }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ce }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ce }
            L_0x00ce:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.CONFIRMATION_VIEW     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.REJECT_VIEW     // Catch:{ NoSuchFieldError -> 0x00e2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e2 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e2 }
            L_0x00e2:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.RETRY     // Catch:{ NoSuchFieldError -> 0x00ec }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ec }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ec }
            L_0x00ec:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.CAN_FINISH     // Catch:{ NoSuchFieldError -> 0x00f6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f6 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f6 }
            L_0x00f6:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.ADDON_SCAN_PART     // Catch:{ NoSuchFieldError -> 0x0100 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0100 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0100 }
            L_0x0100:
                f56255c = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jumio.core.l2.c.<clinit>():void");
        }
    }

    public final void a(JumioCredentialPart jumioCredentialPart, String str) {
        HashMap<JumioCredentialPart, b> hashMap;
        b bVar;
        a aVar = this.f56243a.get(str);
        if (aVar != null && (hashMap = aVar.f56250b) != null && (bVar = hashMap.get(jumioCredentialPart)) != null) {
            if (bVar.f56251a != 0) {
                bVar.f56252b = (System.currentTimeMillis() - bVar.f56251a) + bVar.f56252b;
            }
            bVar.f56251a = 0;
        }
    }

    public final void b(JumioCredentialPart jumioCredentialPart, String str) {
        HashMap<JumioCredentialPart, b> hashMap;
        this.f56245c = str;
        this.f56246d = jumioCredentialPart;
        this.f56247e = null;
        a aVar = this.f56243a.get(str);
        if (aVar != null && (hashMap = aVar.f56250b) != null) {
            b bVar = hashMap.get(jumioCredentialPart);
            if (bVar == null) {
                bVar = new b();
                hashMap.put(jumioCredentialPart, bVar);
            }
            bVar.f56251a = System.currentTimeMillis();
        }
    }

    public final String a(CredentialsModel credentialsModel) {
        Object obj;
        String str;
        int i11;
        String str2;
        Iterator it2 = credentialsModel.c().iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (x.b(((JumioCredentialInfo) obj).getId(), this.f56245c)) {
                break;
            }
        }
        JumioCredentialInfo jumioCredentialInfo = (JumioCredentialInfo) obj;
        String str3 = "";
        int i12 = -1;
        boolean z11 = false;
        if (jumioCredentialInfo != null) {
            str3 = jumioCredentialInfo.getCategory().toString();
            d0 d0Var = d0.f56774a;
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[1];
            Iterator it3 = credentialsModel.c().iterator();
            int i13 = 0;
            while (true) {
                if (!it3.hasNext()) {
                    i13 = -1;
                    break;
                } else if (x.b(((JumioCredentialInfo) it3.next()).getId(), jumioCredentialInfo.getId())) {
                    break;
                } else {
                    i13++;
                }
            }
            objArr[0] = Integer.valueOf(i13 + 1);
            str = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(objArr, 1));
        } else {
            str = str3;
        }
        JumioCredentialPart jumioCredentialPart = this.f56246d;
        if (jumioCredentialPart != null) {
            str3 = str3 + " | " + jumioCredentialPart;
        }
        JumioCredentialPart jumioCredentialPart2 = this.f56246d;
        if (jumioCredentialPart2 == null) {
            i11 = -1;
        } else {
            i11 = c.f56254b[jumioCredentialPart2.ordinal()];
        }
        String str4 = "70";
        switch (i11) {
            case -1:
                str2 = "00";
                break;
            case 1:
                str2 = CouponReturn.TYPE_EXPERIENCE;
                break;
            case 2:
                str2 = "20";
                break;
            case 3:
                str2 = "0";
                break;
            case 4:
                str2 = "30";
                break;
            case 5:
                str2 = "40";
                break;
            case 6:
                str2 = "50";
                break;
            case 7:
                str2 = "60";
                break;
            case 8:
                str2 = str4;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        String str5 = str + str2;
        JumioScanStep jumioScanStep = this.f56247e;
        if (jumioScanStep != null) {
            str3 = str3 + " | " + jumioScanStep;
        }
        JumioScanStep jumioScanStep2 = this.f56247e;
        if (jumioScanStep2 != null) {
            i12 = c.f56255c[jumioScanStep2.ordinal()];
        }
        switch (i12) {
            case -1:
                str4 = "00";
                break;
            case 1:
                str4 = "07";
                break;
            case 2:
                str4 = "14";
                break;
            case 3:
                str4 = "21";
                break;
            case 4:
                str4 = "28";
                break;
            case 5:
                str4 = "32";
                break;
            case 6:
                str4 = "35";
                break;
            case 7:
                str4 = "38";
                break;
            case 8:
                str4 = "42";
                break;
            case 9:
                str4 = "49";
                break;
            case 10:
                str4 = "56";
                break;
            case 11:
                str4 = "63";
                break;
            case 12:
                break;
            case 13:
                str4 = "77";
                break;
            case 14:
                str4 = "84";
                break;
            case 15:
                str4 = "91";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        String str6 = str5 + str4;
        List<c0> b11 = credentialsModel.b();
        ArrayList arrayList = new ArrayList();
        for (T next : b11) {
            if (!((c0) next).c()) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            str3 = "SUBMISSION";
            str6 = "990000";
        } else {
            if (str3.length() == 0) {
                z11 = true;
            }
            if (z11) {
                str3 = "SDK INIT";
                str6 = "000000";
            }
        }
        return str6 + " " + str3;
    }
}
