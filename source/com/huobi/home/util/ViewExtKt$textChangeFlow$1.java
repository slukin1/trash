package com.huobi.home.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.k;

@d(c = "com.huobi.home.util.ViewExtKt$textChangeFlow$1", f = "ViewExt.kt", l = {566}, m = "invokeSuspend")
final class ViewExtKt$textChangeFlow$1 extends SuspendLambda implements p<k<? super CharSequence>, c<? super Unit>, Object> {
    public final /* synthetic */ EditText $this_textChangeFlow;
    private /* synthetic */ Object L$0;
    public int label;

    public static final class a implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k<CharSequence> f72573b;

        public a(k<? super CharSequence> kVar) {
            this.f72573b = kVar;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            if (charSequence != null) {
                ChannelResult.b(this.f72573b.q(charSequence));
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewExtKt$textChangeFlow$1(EditText editText, c<? super ViewExtKt$textChangeFlow$1> cVar) {
        super(2, cVar);
        this.$this_textChangeFlow = editText;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ViewExtKt$textChangeFlow$1 viewExtKt$textChangeFlow$1 = new ViewExtKt$textChangeFlow$1(this.$this_textChangeFlow, cVar);
        viewExtKt$textChangeFlow$1.L$0 = obj;
        return viewExtKt$textChangeFlow$1;
    }

    public final Object invoke(k<? super CharSequence> kVar, c<? super Unit> cVar) {
        return ((ViewExtKt$textChangeFlow$1) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            kotlin.k.b(obj);
            k kVar = (k) this.L$0;
            final a aVar = new a(kVar);
            this.$this_textChangeFlow.addTextChangedListener(aVar);
            final EditText editText = this.$this_textChangeFlow;
            AnonymousClass1 r32 = new d10.a<Unit>() {
                public final void invoke() {
                    editText.removeTextChangedListener(aVar);
                }
            };
            this.label = 1;
            if (ProduceKt.a(kVar, r32, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            kotlin.k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
