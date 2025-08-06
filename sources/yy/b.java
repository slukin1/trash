package yy;

import com.tekartik.sqflite.operation.BaseReadOperation;
import io.flutter.plugin.common.MethodChannel;

public class b extends BaseReadOperation {

    /* renamed from: a  reason: collision with root package name */
    public final xy.b f40674a;

    /* renamed from: b  reason: collision with root package name */
    public final MethodChannel.Result f40675b;

    /* renamed from: c  reason: collision with root package name */
    public final Boolean f40676c;

    public b(MethodChannel.Result result, xy.b bVar, Boolean bool) {
        this.f40675b = result;
        this.f40674a = bVar;
        this.f40676c = bool;
    }

    public <T> T a(String str) {
        return null;
    }

    public xy.b b() {
        return this.f40674a;
    }

    public Boolean c() {
        return this.f40676c;
    }

    public void error(String str, String str2, Object obj) {
        this.f40675b.error(str, str2, obj);
    }

    public void success(Object obj) {
        this.f40675b.success(obj);
    }
}
