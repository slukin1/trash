package kotlinx.serialization.json.internal;

import d10.q;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.serialization.json.g;

@d(c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", l = {112}, m = "invokeSuspend")
public final class JsonTreeReader$readDeepRecursive$1 extends RestrictedSuspendLambda implements q<c<Unit, g>, Unit, kotlin.coroutines.c<? super g>, Object> {
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ JsonTreeReader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readDeepRecursive$1(JsonTreeReader jsonTreeReader, kotlin.coroutines.c<? super JsonTreeReader$readDeepRecursive$1> cVar) {
        super(3, cVar);
        this.this$0 = jsonTreeReader;
    }

    public final Object invoke(c<Unit, g> cVar, Unit unit, kotlin.coroutines.c<? super g> cVar2) {
        JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this.this$0, cVar2);
        jsonTreeReader$readDeepRecursive$1.L$0 = cVar;
        return jsonTreeReader$readDeepRecursive$1.invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            c cVar = (c) this.L$0;
            byte E = this.this$0.f57880a.E();
            if (E == 1) {
                return this.this$0.j(true);
            }
            if (E == 0) {
                return this.this$0.j(false);
            }
            if (E == 6) {
                JsonTreeReader jsonTreeReader = this.this$0;
                this.label = 1;
                obj = jsonTreeReader.h(cVar, this);
                if (obj == d11) {
                    return d11;
                }
            } else if (E == 8) {
                return this.this$0.f();
            } else {
                AbstractJsonLexer.y(this.this$0.f57880a, "Can't begin reading element, unexpected token", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return (g) obj;
    }
}
