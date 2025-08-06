package androidx.test.internal.runner.junit4;

import androidx.test.internal.runner.junit4.statement.RunAfters;
import androidx.test.internal.runner.junit4.statement.RunBefores;
import androidx.test.internal.runner.junit4.statement.UiThreadStatement;
import androidx.test.internal.util.AndroidRunnerParams;
import java.util.List;
import o20.d;
import org.junit.Test;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import w20.a;
import x20.c;

public class AndroidJUnit4ClassRunner extends a {

    /* renamed from: g  reason: collision with root package name */
    public final AndroidRunnerParams f11544g;

    public AndroidJUnit4ClassRunner(Class<?> cls, AndroidRunnerParams androidRunnerParams) throws InitializationError {
        super(cls);
        this.f11544g = androidRunnerParams;
    }

    private long I(Test test) {
        if (test == null) {
            return 0;
        }
        return test.timeout();
    }

    public Statement M(c cVar, Object obj) {
        if (UiThreadStatement.e(cVar)) {
            return new UiThreadStatement(super.M(cVar, obj), true);
        }
        return super.M(cVar, obj);
    }

    public Statement Z(c cVar, Object obj, Statement statement) {
        List<c> i11 = p().i(o20.a.class);
        return i11.isEmpty() ? statement : new RunAfters(cVar, statement, i11, obj);
    }

    public Statement a0(c cVar, Object obj, Statement statement) {
        List<c> i11 = p().i(d.class);
        return i11.isEmpty() ? statement : new RunBefores(cVar, statement, i11, obj);
    }

    public Statement c0(c cVar, Object obj, Statement statement) {
        long I = I((Test) cVar.getAnnotation(Test.class));
        if (I <= 0 && this.f11544g.c() > 0) {
            I = this.f11544g.c();
        }
        if (I <= 0) {
            return statement;
        }
        return new t20.c(statement, I);
    }
}
