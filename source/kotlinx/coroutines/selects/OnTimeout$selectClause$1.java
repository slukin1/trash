package kotlinx.coroutines.selects;

import com.xiaomi.mipush.sdk.MiPushClient;
import d10.q;
import kotlin.Unit;
import kotlin.jvm.internal.FunctionReferenceImpl;

public /* synthetic */ class OnTimeout$selectClause$1 extends FunctionReferenceImpl implements q<OnTimeout, k<?>, Object, Unit> {
    public static final OnTimeout$selectClause$1 INSTANCE = new OnTimeout$selectClause$1();

    public OnTimeout$selectClause$1() {
        super(3, OnTimeout.class, MiPushClient.COMMAND_REGISTER, "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((OnTimeout) obj, (k<?>) (k) obj2, obj3);
        return Unit.f56620a;
    }

    public final void invoke(OnTimeout onTimeout, k<?> kVar, Object obj) {
        onTimeout.c(kVar, obj);
    }
}
