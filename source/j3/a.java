package j3;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.bbc876219.lib.zlog.ZLog;
import com.bbc876219.runtimestatis.IRunTimeStatisHandler;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a implements IRunTimeStatisHandler {

    /* renamed from: a  reason: collision with root package name */
    public final String f66399a = "StacktraceBlockImpl";

    /* renamed from: b  reason: collision with root package name */
    public String f66400b = System.getProperty("line.separator");

    /* renamed from: c  reason: collision with root package name */
    public String f66401c = (this.f66400b + this.f66400b);

    /* renamed from: d  reason: collision with root package name */
    public List<c> f66402d = Collections.synchronizedList(new ArrayList());

    /* renamed from: e  reason: collision with root package name */
    public ExecutorService f66403e = Executors.newSingleThreadExecutor();

    /* renamed from: f  reason: collision with root package name */
    public final int f66404f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f66405g = true;

    /* renamed from: j3.a$a  reason: collision with other inner class name */
    public class C0720a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f66406b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ StackTraceElement f66407c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ StackTraceElement f66408d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f66409e;

        public C0720a(int i11, StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2, String str) {
            this.f66406b = i11;
            this.f66407c = stackTraceElement;
            this.f66408d = stackTraceElement2;
            this.f66409e = str;
        }

        public void run() {
            a aVar = a.this;
            int i11 = this.f66406b;
            String str = this.f66407c.getClassName() + InstructionFileId.DOT + this.f66407c.getMethodName();
            StringBuilder sb2 = new StringBuilder();
            StackTraceElement stackTraceElement = this.f66408d;
            String str2 = "";
            sb2.append(stackTraceElement != null ? stackTraceElement.getClassName() : str2);
            sb2.append(InstructionFileId.DOT);
            StackTraceElement stackTraceElement2 = this.f66408d;
            if (stackTraceElement2 != null) {
                str2 = stackTraceElement2.getMethodName();
            }
            sb2.append(str2);
            aVar.b(i11, str, sb2.toString(), this.f66409e);
        }
    }

    public class b implements Comparator<c> {
        public b() {
        }

        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            int i11 = cVar.f66414c;
            int i12 = cVar2.f66414c;
            if (i11 > i12) {
                return -1;
            }
            return i11 < i12 ? 1 : 0;
        }
    }

    public class c {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f66412a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<Integer> f66413b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public int f66414c = -1;

        /* renamed from: d  reason: collision with root package name */
        public String f66415d = FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT;

        public c() {
        }

        public String toString() {
            int size = this.f66412a.size();
            if (size <= 0) {
                return "BlockTrace length is " + size;
            }
            StringBuilder sb2 = new StringBuilder("");
            for (int i11 = 0; i11 < size; i11++) {
                if (i11 != size - 1) {
                    sb2.append(this.f66412a.get(i11));
                    sb2.append(" costed ");
                    sb2.append(this.f66413b.get(i11));
                    sb2.append("ms");
                    sb2.append("\n");
                } else {
                    sb2.append(this.f66412a.get(i11));
                    sb2.append(" is root   thread name= " + this.f66415d);
                }
            }
            return sb2.toString();
        }
    }

    public a(int i11) {
        this.f66404f = i11;
    }

    public final void b(int i11, String str, String str2, String str3) {
        boolean z11 = false;
        for (c next : this.f66402d) {
            ArrayList<String> arrayList = next.f66412a;
            ArrayList<Integer> arrayList2 = next.f66413b;
            int intValue = arrayList2.get(arrayList2.size() - 1).intValue();
            if (str.equals(arrayList.get(arrayList.size() - 1)) && intValue == -1) {
                ArrayList<Integer> arrayList3 = next.f66413b;
                arrayList3.set(arrayList3.size() - 1, Integer.valueOf(i11));
                if (next.f66414c < i11) {
                    next.f66414c = i11;
                }
                next.f66412a.add(str2);
                next.f66413b.add(-1);
                z11 = true;
            }
        }
        if (!z11) {
            c cVar = new c();
            cVar.f66412a.add(str);
            cVar.f66415d = str3;
            cVar.f66413b.add(Integer.valueOf(i11));
            cVar.f66412a.add(str2);
            cVar.f66413b.add(-1);
            this.f66402d.add(cVar);
        }
    }

    public String c() {
        ArrayList<c> arrayList = new ArrayList<>(this.f66402d);
        try {
            Collections.sort(arrayList, new b());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f66401c);
        sb2.append("----BlockStackTrace----Total ");
        sb2.append(arrayList.size());
        sb2.append(InternalFrame.ID);
        for (c cVar : arrayList) {
            sb2.append(this.f66400b);
            sb2.append("Block StackTrace ");
            sb2.append(arrayList.indexOf(cVar));
            sb2.append("  thread name=");
            sb2.append(cVar.f66415d);
            sb2.append(this.f66400b);
            sb2.append(cVar.toString());
            sb2.append(this.f66400b);
        }
        return sb2.toString();
    }

    public void clear() {
        this.f66402d.clear();
    }

    public final void d(String str, String str2) {
        if (str2.length() <= 3072) {
            ZLog.c(str, str2);
            return;
        }
        while (str2.length() > 3072) {
            String substring = str2.substring(0, 3072);
            str2 = str2.replace(substring, "");
            ZLog.c(str, substring);
        }
        ZLog.c(str, str2);
    }

    public String dump() {
        String c11 = c();
        d("StacktraceBlockImpl", c11);
        return c11;
    }

    public boolean isStatisticSubThread() {
        return this.f66405g;
    }

    public void setStatisticSubThread(boolean z11) {
        this.f66405g = z11;
    }

    public void statisticMethod(String str, int i11) {
        if (i11 >= threshold()) {
            ZLog.g("StacktraceBlockImpl", str + " costs " + i11);
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            StackTraceElement stackTraceElement = stackTrace[2];
            StackTraceElement stackTraceElement2 = stackTrace.length > 3 ? stackTrace[3] : null;
            this.f66403e.submit(new C0720a(i11, stackTraceElement, stackTraceElement2, Thread.currentThread().getName() + ":" + Thread.currentThread().getId() + ":" + Thread.currentThread().getPriority()));
        }
    }

    public int threshold() {
        return this.f66404f;
    }
}
