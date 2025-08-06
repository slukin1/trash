package org.junit.experimental.max;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class MaxHistory implements Serializable {
    private static final long serialVersionUID = 1;
    private final Map<String, Long> fDurations = new HashMap();
    private final Map<String, Long> fFailureTimestamps = new HashMap();
    private final File fHistoryStore;

    public final class b extends RunListener {

        /* renamed from: a  reason: collision with root package name */
        public long f25424a;

        /* renamed from: b  reason: collision with root package name */
        public Map<Description, Long> f25425b;

        public b() {
            this.f25424a = System.currentTimeMillis();
            this.f25425b = new HashMap();
        }

        public void b(Failure failure) throws Exception {
            MaxHistory.this.putTestFailureTimestamp(failure.getDescription(), this.f25424a);
        }

        public void c(Description description) throws Exception {
            MaxHistory.this.putTestDuration(description, System.nanoTime() - this.f25425b.get(description).longValue());
        }

        public void e(Result result) throws Exception {
            MaxHistory.this.save();
        }

        public void g(Description description) throws Exception {
            this.f25425b.put(description, Long.valueOf(System.nanoTime()));
        }
    }

    public class c implements Comparator<Description> {
        public c() {
        }

        /* renamed from: a */
        public int compare(Description description, Description description2) {
            if (MaxHistory.this.isNewTest(description)) {
                return -1;
            }
            if (MaxHistory.this.isNewTest(description2)) {
                return 1;
            }
            int compareTo = b(description2).compareTo(b(description));
            return compareTo != 0 ? compareTo : MaxHistory.this.getTestDuration(description).compareTo(MaxHistory.this.getTestDuration(description2));
        }

        public final Long b(Description description) {
            Long failureTimestamp = MaxHistory.this.getFailureTimestamp(description);
            if (failureTimestamp == null) {
                return 0L;
            }
            return failureTimestamp;
        }
    }

    private MaxHistory(File file) {
        this.fHistoryStore = file;
    }

    public static MaxHistory forFolder(File file) {
        if (file.exists()) {
            try {
                return readHistory(file);
            } catch (CouldNotReadCoreException e11) {
                e11.printStackTrace();
                file.delete();
            }
        }
        return new MaxHistory(file);
    }

    private static MaxHistory readHistory(File file) throws CouldNotReadCoreException {
        ObjectInputStream objectInputStream;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
                MaxHistory maxHistory = (MaxHistory) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
                return maxHistory;
            } catch (Throwable th2) {
                fileInputStream.close();
                throw th2;
            }
        } catch (Exception e11) {
            throw new CouldNotReadCoreException(e11);
        }
    }

    /* access modifiers changed from: private */
    public void save() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.fHistoryStore));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    public Long getFailureTimestamp(Description description) {
        return this.fFailureTimestamps.get(description.toString());
    }

    public Long getTestDuration(Description description) {
        return this.fDurations.get(description.toString());
    }

    public boolean isNewTest(Description description) {
        return !this.fDurations.containsKey(description.toString());
    }

    public RunListener listener() {
        return new b();
    }

    public void putTestDuration(Description description, long j11) {
        this.fDurations.put(description.toString(), Long.valueOf(j11));
    }

    public void putTestFailureTimestamp(Description description, long j11) {
        this.fFailureTimestamps.put(description.toString(), Long.valueOf(j11));
    }

    public Comparator<Description> testComparator() {
        return new c();
    }
}
