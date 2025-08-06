package com.huobi.webcache;

import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class LogCollectionService {

    /* renamed from: b  reason: collision with root package name */
    public static ConcurrentHashMap<String, H5Url> f20647b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static Vector<String> f20648c = new Vector<>();

    /* renamed from: d  reason: collision with root package name */
    public static final SimpleDateFormat f20649d = new SimpleDateFormat("MM-dd HH:mm:ss.SS");

    /* renamed from: e  reason: collision with root package name */
    public static final SimpleDateFormat f20650e = new SimpleDateFormat("HH:mm:ss.SS");

    /* renamed from: a  reason: collision with root package name */
    public boolean f20651a;

    public class a implements Comparator<H5Url> {
        public a() {
        }

        /* renamed from: a */
        public int compare(H5Url h5Url, H5Url h5Url2) {
            int i11 = ((h5Url.startTime - h5Url2.startTime) > 0 ? 1 : ((h5Url.startTime - h5Url2.startTime) == 0 ? 0 : -1));
            if (i11 == 0) {
                return 0;
            }
            return i11 > 0 ? 1 : -1;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static LogCollectionService f20653a = new LogCollectionService((a) null);
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public long f20654a;

        /* renamed from: b  reason: collision with root package name */
        public int f20655b;

        /* renamed from: c  reason: collision with root package name */
        public String f20656c;

        public c(long j11, int i11, String str) {
            this.f20654a = j11;
            this.f20655b = i11;
            this.f20656c = str;
        }

        public boolean a() {
            int i11 = this.f20655b;
            return i11 == 3 || i11 == 5 || i11 == 9;
        }

        public String toString() {
            return LogCollectionService.f20650e.format(Long.valueOf(this.f20654a)) + ", type=" + this.f20655b + "\n" + this.f20656c;
        }
    }

    public /* synthetic */ LogCollectionService(a aVar) {
        this();
    }

    public static LogCollectionService e() {
        return b.f20653a;
    }

    public void a() {
        f20647b.clear();
    }

    public List<H5Url> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(f20647b.values());
        h(arrayList);
        return arrayList;
    }

    public List<H5Url> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return b();
        }
        ArrayList arrayList = new ArrayList();
        for (H5Url next : f20647b.values()) {
            if (next.url.contains(str)) {
                arrayList.add(next);
            }
        }
        h(arrayList);
        return arrayList;
    }

    public H5Url d(String str) {
        return f20647b.get(str);
    }

    public List<H5Url> f() {
        ArrayList arrayList = new ArrayList();
        for (H5Url next : f20647b.values()) {
            if (next.urlType == 1) {
                arrayList.add(next);
            }
        }
        h(arrayList);
        return arrayList;
    }

    public List<H5Url> g() {
        ArrayList arrayList = new ArrayList();
        for (H5Url next : f20647b.values()) {
            if (next.urlType == 0) {
                arrayList.add(next);
            }
        }
        h(arrayList);
        return arrayList;
    }

    public final void h(List<H5Url> list) {
        Collections.sort(list, new a());
    }

    public LogCollectionService() {
        this.f20651a = false;
    }

    public class H5Url implements Serializable {
        public long endTime;
        public List<c> pairs = new LinkedList();
        public long startTime = System.currentTimeMillis();
        public int state = 0;
        public String url;
        public int urlType = 0;

        public H5Url(String str, int i11) {
            if (TextUtils.isEmpty(str)) {
                new IllegalArgumentException("H5Url() called with: url = [" + str + "]");
            }
            this.url = str;
            this.urlType = i11;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x00f4, code lost:
            r0 = r13.pairs;
            r2 = java.lang.System.currentTimeMillis();
            r0.add(new com.huobi.webcache.LogCollectionService.c(r2, r14, "\trequest=" + r15));
            r13.startTime = java.lang.System.currentTimeMillis();
            r14 = r13.pairs;
            r0 = java.lang.System.currentTimeMillis();
            r14.add(new com.huobi.webcache.LogCollectionService.c(r0, 8, "\tcost=" + (r13.endTime - r13.startTime)));
            r13.state = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0061, code lost:
            r0 = r13.pairs;
            r6 = java.lang.System.currentTimeMillis();
            r0.add(new com.huobi.webcache.LogCollectionService.c(r6, r14, "\tresponse=" + r15));
            r13.endTime = java.lang.System.currentTimeMillis();
            r14 = r13.pairs;
            r5 = java.lang.System.currentTimeMillis();
            r14.add(new com.huobi.webcache.LogCollectionService.c(r5, 8, "\t request cost=" + (r13.endTime - r13.startTime)));
            r13.state = 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void add(int r14, java.lang.String r15) {
            /*
                r13 = this;
                if (r14 >= 0) goto L_0x0006
                r0 = 9
                if (r14 > r0) goto L_0x01cf
            L_0x0006:
                boolean r0 = android.text.TextUtils.isEmpty(r15)
                if (r0 != 0) goto L_0x01cf
                java.lang.String r0 = "\tload cost="
                java.lang.String r1 = "\t request cost="
                java.lang.String r2 = "\tresponse="
                r3 = 1
                r4 = 8
                switch(r14) {
                    case 2: goto L_0x01af;
                    case 3: goto L_0x018c;
                    case 4: goto L_0x0142;
                    case 5: goto L_0x00aa;
                    case 6: goto L_0x00f4;
                    case 7: goto L_0x001a;
                    case 8: goto L_0x0018;
                    case 9: goto L_0x0061;
                    default: goto L_0x0018;
                }
            L_0x0018:
                goto L_0x01ce
            L_0x001a:
                java.util.List<com.huobi.webcache.LogCollectionService$c> r0 = r13.pairs
                com.huobi.webcache.LogCollectionService$c r5 = new com.huobi.webcache.LogCollectionService$c
                long r6 = java.lang.System.currentTimeMillis()
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                r8.append(r2)
                r8.append(r15)
                java.lang.String r8 = r8.toString()
                r5.<init>(r6, r14, r8)
                r0.add(r5)
                long r5 = java.lang.System.currentTimeMillis()
                r13.endTime = r5
                java.util.List<com.huobi.webcache.LogCollectionService$c> r0 = r13.pairs
                com.huobi.webcache.LogCollectionService$c r5 = new com.huobi.webcache.LogCollectionService$c
                long r6 = java.lang.System.currentTimeMillis()
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                r8.append(r1)
                long r9 = r13.endTime
                long r11 = r13.startTime
                long r9 = r9 - r11
                r8.append(r9)
                java.lang.String r8 = r8.toString()
                r5.<init>(r6, r4, r8)
                r0.add(r5)
                r13.state = r3
            L_0x0061:
                java.util.List<com.huobi.webcache.LogCollectionService$c> r0 = r13.pairs
                com.huobi.webcache.LogCollectionService$c r5 = new com.huobi.webcache.LogCollectionService$c
                long r6 = java.lang.System.currentTimeMillis()
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                r8.append(r2)
                r8.append(r15)
                java.lang.String r15 = r8.toString()
                r5.<init>(r6, r14, r15)
                r0.add(r5)
                long r14 = java.lang.System.currentTimeMillis()
                r13.endTime = r14
                java.util.List<com.huobi.webcache.LogCollectionService$c> r14 = r13.pairs
                com.huobi.webcache.LogCollectionService$c r15 = new com.huobi.webcache.LogCollectionService$c
                long r5 = java.lang.System.currentTimeMillis()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r1)
                long r1 = r13.endTime
                long r7 = r13.startTime
                long r1 = r1 - r7
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r15.<init>(r5, r4, r0)
                r14.add(r15)
                r13.state = r3
                goto L_0x01ce
            L_0x00aa:
                java.util.List<com.huobi.webcache.LogCollectionService$c> r1 = r13.pairs
                com.huobi.webcache.LogCollectionService$c r2 = new com.huobi.webcache.LogCollectionService$c
                long r5 = java.lang.System.currentTimeMillis()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r7 = "\tloadFail="
                r3.append(r7)
                r3.append(r15)
                java.lang.String r3 = r3.toString()
                r2.<init>(r5, r14, r3)
                r1.add(r2)
                long r1 = java.lang.System.currentTimeMillis()
                r13.endTime = r1
                java.util.List<com.huobi.webcache.LogCollectionService$c> r1 = r13.pairs
                com.huobi.webcache.LogCollectionService$c r2 = new com.huobi.webcache.LogCollectionService$c
                long r5 = java.lang.System.currentTimeMillis()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r0)
                long r7 = r13.endTime
                long r9 = r13.startTime
                long r7 = r7 - r9
                r3.append(r7)
                java.lang.String r0 = r3.toString()
                r2.<init>(r5, r4, r0)
                r1.add(r2)
                r0 = 2
                r13.state = r0
            L_0x00f4:
                java.util.List<com.huobi.webcache.LogCollectionService$c> r0 = r13.pairs
                com.huobi.webcache.LogCollectionService$c r1 = new com.huobi.webcache.LogCollectionService$c
                long r2 = java.lang.System.currentTimeMillis()
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "\trequest="
                r5.append(r6)
                r5.append(r15)
                java.lang.String r15 = r5.toString()
                r1.<init>(r2, r14, r15)
                r0.add(r1)
                long r14 = java.lang.System.currentTimeMillis()
                r13.startTime = r14
                java.util.List<com.huobi.webcache.LogCollectionService$c> r14 = r13.pairs
                com.huobi.webcache.LogCollectionService$c r15 = new com.huobi.webcache.LogCollectionService$c
                long r0 = java.lang.System.currentTimeMillis()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "\tcost="
                r2.append(r3)
                long r5 = r13.endTime
                long r7 = r13.startTime
                long r5 = r5 - r7
                r2.append(r5)
                java.lang.String r2 = r2.toString()
                r15.<init>(r0, r4, r2)
                r14.add(r15)
                r14 = 0
                r13.state = r14
                goto L_0x01ce
            L_0x0142:
                java.util.List<com.huobi.webcache.LogCollectionService$c> r1 = r13.pairs
                com.huobi.webcache.LogCollectionService$c r2 = new com.huobi.webcache.LogCollectionService$c
                long r5 = java.lang.System.currentTimeMillis()
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = "\tloadFinish="
                r7.append(r8)
                r7.append(r15)
                java.lang.String r15 = r7.toString()
                r2.<init>(r5, r14, r15)
                r1.add(r2)
                long r14 = java.lang.System.currentTimeMillis()
                r13.endTime = r14
                java.util.List<com.huobi.webcache.LogCollectionService$c> r14 = r13.pairs
                com.huobi.webcache.LogCollectionService$c r15 = new com.huobi.webcache.LogCollectionService$c
                long r1 = java.lang.System.currentTimeMillis()
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                r5.append(r0)
                long r6 = r13.endTime
                long r8 = r13.startTime
                long r6 = r6 - r8
                r5.append(r6)
                java.lang.String r0 = r5.toString()
                r15.<init>(r1, r4, r0)
                r14.add(r15)
                r13.state = r3
                goto L_0x01ce
            L_0x018c:
                java.util.List<com.huobi.webcache.LogCollectionService$c> r0 = r13.pairs
                com.huobi.webcache.LogCollectionService$c r1 = new com.huobi.webcache.LogCollectionService$c
                long r2 = java.lang.System.currentTimeMillis()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "\terror="
                r4.append(r5)
                r4.append(r15)
                java.lang.String r15 = r4.toString()
                r1.<init>(r2, r14, r15)
                r0.add(r1)
                r14 = 3
                r13.state = r14
                goto L_0x01ce
            L_0x01af:
                java.util.List<com.huobi.webcache.LogCollectionService$c> r0 = r13.pairs
                com.huobi.webcache.LogCollectionService$c r1 = new com.huobi.webcache.LogCollectionService$c
                long r2 = java.lang.System.currentTimeMillis()
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "\ttitle="
                r4.append(r5)
                r4.append(r15)
                java.lang.String r15 = r4.toString()
                r1.<init>(r2, r14, r15)
                r0.add(r1)
            L_0x01ce:
                return
            L_0x01cf:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "H5Url() called with: url = ["
                r1.append(r2)
                java.lang.String r2 = r13.url
                r1.append(r2)
                java.lang.String r2 = "], type = ["
                r1.append(r2)
                r1.append(r14)
                java.lang.String r14 = "], content = ["
                r1.append(r14)
                r1.append(r15)
                java.lang.String r14 = "]"
                r1.append(r14)
                java.lang.String r14 = r1.toString()
                r0.<init>(r14)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.webcache.LogCollectionService.H5Url.add(int, java.lang.String):void");
        }

        public String getDetailTitle() {
            String str;
            String str2;
            StringBuilder sb2 = new StringBuilder();
            SimpleDateFormat simpleDateFormat = LogCollectionService.f20649d;
            sb2.append(simpleDateFormat.format(Long.valueOf(this.startTime)));
            sb2.append("\n");
            sb2.append(this.url);
            sb2.append("\ntype='");
            sb2.append(getTypeString());
            sb2.append('\'');
            sb2.append("\nstate='");
            sb2.append(getStateString());
            sb2.append('\'');
            sb2.append("\nstart=");
            long j11 = this.startTime;
            if (j11 <= 0) {
                str = "未开始";
            } else {
                str = simpleDateFormat.format(Long.valueOf(j11));
            }
            sb2.append(str);
            sb2.append("\nend=");
            long j12 = this.endTime;
            if (j12 <= 0) {
                str2 = "未完成";
            } else {
                str2 = simpleDateFormat.format(Long.valueOf(j12));
            }
            sb2.append(str2);
            sb2.append("\ncost=");
            sb2.append(this.endTime - this.startTime);
            sb2.append("\nsub.log.size='");
            sb2.append(this.pairs.size());
            sb2.append('\'');
            return sb2.toString();
        }

        public String getEndTimeText() {
            long j11 = this.endTime;
            return j11 <= 0 ? "未结束" : LogCollectionService.f20649d.format(Long.valueOf(j11));
        }

        public List<c> getPairs() {
            return this.pairs;
        }

        public String getStartTimeText() {
            long j11 = this.startTime;
            return j11 <= 0 ? "未开始" : LogCollectionService.f20649d.format(Long.valueOf(j11));
        }

        public String getStateString() {
            int i11 = this.state;
            if (i11 == 0) {
                return "开始";
            }
            if (i11 == 1) {
                return "完成";
            }
            if (i11 != 2) {
                return i11 != 3 ? OptionsBridge.EMPTY_VALUE : "完成-部分失败";
            }
            return "完成-失败";
        }

        public String getTypeString() {
            return this.urlType == 0 ? AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB : "okhttp";
        }

        public String getUrl() {
            return this.url;
        }

        public String toString() {
            String str;
            String str2;
            StringBuilder sb2 = new StringBuilder();
            SimpleDateFormat simpleDateFormat = LogCollectionService.f20649d;
            sb2.append(simpleDateFormat.format(Long.valueOf(this.startTime)));
            sb2.append("H5Url{\nurl='");
            sb2.append(this.url);
            sb2.append('\'');
            sb2.append("type='");
            sb2.append(getTypeString());
            sb2.append('\'');
            sb2.append("state='");
            sb2.append(getStateString());
            sb2.append('\'');
            sb2.append("start='");
            long j11 = this.startTime;
            if (j11 <= 0) {
                str = "未开始";
            } else {
                str = simpleDateFormat.format(Long.valueOf(j11));
            }
            sb2.append(str);
            sb2.append('\'');
            sb2.append("end='");
            long j12 = this.endTime;
            if (j12 <= 0) {
                str2 = "未完成";
            } else {
                str2 = simpleDateFormat.format(Long.valueOf(j12));
            }
            sb2.append(str2);
            sb2.append('\'');
            sb2.append("cost='");
            sb2.append(this.endTime - this.startTime);
            sb2.append('\'');
            sb2.append("pairs.size='");
            sb2.append(this.pairs.size());
            sb2.append('\'');
            sb2.append("\n, pairs=");
            sb2.append(this.pairs);
            sb2.append('}');
            return sb2.toString();
        }

        public H5Url(String str, int i11, String str2) {
            if (!TextUtils.isEmpty(str)) {
                this.url = str;
                this.startTime = System.currentTimeMillis();
                add(i11, str2);
                return;
            }
            throw new IllegalArgumentException("H5Url() called with: url = [" + str + "], type = [" + i11 + "], content = [" + str2 + "]");
        }
    }
}
