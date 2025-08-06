package yy;

import com.tekartik.sqflite.operation.BaseOperation;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class c extends BaseOperation {

    /* renamed from: a  reason: collision with root package name */
    public final MethodCall f40677a;

    /* renamed from: b  reason: collision with root package name */
    public final a f40678b;

    public class a implements e {

        /* renamed from: a  reason: collision with root package name */
        public final MethodChannel.Result f40679a;

        public a(MethodChannel.Result result) {
            this.f40679a = result;
        }

        public void error(String str, String str2, Object obj) {
            this.f40679a.error(str, str2, obj);
        }

        public void success(Object obj) {
            this.f40679a.success(obj);
        }
    }

    public c(MethodCall methodCall, MethodChannel.Result result) {
        this.f40677a = methodCall;
        this.f40678b = new a(result);
    }

    public <T> T a(String str) {
        return this.f40677a.argument(str);
    }

    public e i() {
        return this.f40678b;
    }
}
