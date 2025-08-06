package junit.framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import x00.b;
import x00.c;

public class JUnit4TestAdapterCache extends HashMap<Description, Test> {
    private static final JUnit4TestAdapterCache fInstance = new JUnit4TestAdapterCache();
    private static final long serialVersionUID = 1;

    public class a extends RunListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TestResult f56524a;

        public a(TestResult testResult) {
            this.f56524a = testResult;
        }

        public void b(Failure failure) throws Exception {
            this.f56524a.a(JUnit4TestAdapterCache.this.asTest(failure.getDescription()), failure.getException());
        }

        public void c(Description description) throws Exception {
            this.f56524a.e(JUnit4TestAdapterCache.this.asTest(description));
        }

        public void g(Description description) throws Exception {
            this.f56524a.i(JUnit4TestAdapterCache.this.asTest(description));
        }
    }

    public static JUnit4TestAdapterCache getDefault() {
        return fInstance;
    }

    public Test asTest(Description description) {
        if (description.isSuite()) {
            return createTest(description);
        }
        if (!containsKey(description)) {
            put(description, createTest(description));
        }
        return (Test) get(description);
    }

    public List<Test> asTestList(Description description) {
        if (description.isTest()) {
            return Arrays.asList(new Test[]{asTest(description)});
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Description> it2 = description.getChildren().iterator();
        while (it2.hasNext()) {
            arrayList.add(asTest(it2.next()));
        }
        return arrayList;
    }

    public Test createTest(Description description) {
        if (description.isTest()) {
            return new c(description);
        }
        TestSuite testSuite = new TestSuite(description.getDisplayName());
        Iterator<Description> it2 = description.getChildren().iterator();
        while (it2.hasNext()) {
            testSuite.b(asTest(it2.next()));
        }
        return testSuite;
    }

    public RunNotifier getNotifier(TestResult testResult, b bVar) {
        RunNotifier runNotifier = new RunNotifier();
        runNotifier.d(new a(testResult));
        return runNotifier;
    }
}
