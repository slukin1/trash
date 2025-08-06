package tj;

import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\t\u001a\u00020\b2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002J\u001e\u0010\u000b\u001a\u00020\b2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002R(\u0010\f\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\f\u0010\r\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Ltj/b;", "", "", "a", "", "e", "Ljava/lang/Class;", "clazz", "", "c", "methodName", "d", "enabled", "Z", "b", "()Z", "f", "(Z)V", "getEnabled$annotations", "()V", "<init>", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f47901a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f47902b;

    public static final boolean b() {
        return f47902b;
    }

    public static final void f(boolean z11) {
        f47902b = z11;
    }

    public final String a() {
        String str;
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int length = stackTrace.length;
        int i11 = 0;
        while (true) {
            str = null;
            if (i11 >= length) {
                stackTraceElement = null;
                break;
            }
            stackTraceElement = stackTrace[i11];
            Class<?> cls = Class.forName(stackTraceElement.getClassName());
            b bVar = f47901a;
            if (bVar.c(cls) && bVar.d(cls, stackTraceElement.getMethodName())) {
                break;
            }
            i11++;
        }
        if (stackTraceElement != null) {
            str = stackTraceElement.getMethodName();
        }
        return str != null ? str : "";
    }

    public final boolean c(Class<?> cls) {
        return ChromeDevtoolsDomain.class.isAssignableFrom(cls);
    }

    public final boolean d(Class<?> cls, String str) {
        Method method;
        Method[] methods = cls.getMethods();
        int length = methods.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                method = null;
                break;
            }
            method = methods[i11];
            if (x.b(method.getName(), str)) {
                break;
            }
            i11++;
        }
        if (method == null) {
            return false;
        }
        return method.isAnnotationPresent(ChromeDevtoolsMethod.class);
    }

    public final void e() {
        if (f47902b) {
            try {
                c.a().d("Debugger", x.i("Calling ", a()));
            } catch (Exception e11) {
                c.a().b("Debugger", "Unable to log called method", e11);
            }
        }
    }
}
