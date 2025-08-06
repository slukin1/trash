package junit.extensions;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;

public class ActiveTestSuite extends TestSuite {

    /* renamed from: c  reason: collision with root package name */
    public volatile int f56520c;

    public class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Test f56521b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TestResult f56522c;

        public a(Test test, TestResult testResult) {
            this.f56521b = test;
            this.f56522c = testResult;
        }

        public void run() {
            try {
                this.f56521b.run(this.f56522c);
            } finally {
                ActiveTestSuite.this.p();
            }
        }
    }

    public void k(Test test, TestResult testResult) {
        new a(test, testResult).start();
    }

    public synchronized void p() {
        this.f56520c++;
        notifyAll();
    }

    public synchronized void q() {
        while (this.f56520c < n()) {
            try {
                wait();
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public void run(TestResult testResult) {
        this.f56520c = 0;
        super.run(testResult);
        q();
    }
}
