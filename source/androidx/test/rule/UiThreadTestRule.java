package androidx.test.rule;

import android.test.UiThreadTest;
import android.util.Log;
import androidx.test.internal.runner.junit4.statement.UiThreadStatement;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import u20.c;

@Deprecated
public class UiThreadTestRule implements c {
    public Statement a(Statement statement, Description description) {
        return ((statement instanceof t20.c) || ((statement instanceof UiThreadStatement) && !((UiThreadStatement) statement).c())) ? statement : new UiThreadStatement(statement, b(description));
    }

    public boolean b(Description description) {
        if (description.getAnnotation(UiThreadTest.class) != null) {
            Log.w("UiThreadTestRule", "Deprecated android.test.UiThreadTest annotation is used! please switch to using androidx.test.annotation.UiThreadTest instead.");
            return true;
        } else if (description.getAnnotation(androidx.test.annotation.UiThreadTest.class) != null) {
            return true;
        } else {
            return false;
        }
    }
}
