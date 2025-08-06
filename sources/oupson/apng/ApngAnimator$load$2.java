package oupson.apng;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.ImageView;
import d10.p;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;
import oupson.apng.exceptions.NotPngException;
import oupson.apng.utils.ApngAnimatorOptions;
import oupson.apng.utils.Utils;

@d(c = "oupson.apng.ApngAnimator$load$2", f = "ApngAnimator.kt", l = {}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/h0;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ApngAnimator$load$2 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ ApngAnimatorOptions $apngAnimatorOptions;
    public final /* synthetic */ Float $speed;
    public final /* synthetic */ Uri $uri;
    public int label;
    public final /* synthetic */ ApngAnimator this$0;

    @d(c = "oupson.apng.ApngAnimator$load$2$2", f = "ApngAnimator.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/h0;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: oupson.apng.ApngAnimator$load$2$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
        public int label;
        public final /* synthetic */ ApngAnimator$load$2 this$0;

        {
            this.this$0 = r1;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.this$0, bArr, cVar);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create(obj, (c) obj2)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.label == 0) {
                k.b(obj);
                ImageView d11 = this.this$0.this$0.f52920c;
                if (d11 != null) {
                    ImageView.ScaleType e11 = this.this$0.this$0.f52926i;
                    if (e11 == null) {
                        e11 = ImageView.ScaleType.FIT_CENTER;
                    }
                    d11.setScaleType(e11);
                }
                ImageView d12 = this.this$0.this$0.f52920c;
                if (d12 != null) {
                    byte[] bArr = bArr;
                    d12.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApngAnimator$load$2(ApngAnimator apngAnimator, Uri uri, Float f11, ApngAnimatorOptions apngAnimatorOptions, c cVar) {
        super(2, cVar);
        this.this$0 = apngAnimator;
        this.$uri = uri;
        this.$speed = f11;
        this.$apngAnimatorOptions = apngAnimatorOptions;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new ApngAnimator$load$2(this.this$0, this.$uri, this.$speed, this.$apngAnimatorOptions, cVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ApngAnimator$load$2) create(obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            InputStream openInputStream = this.this$0.f52929l.getContentResolver().openInputStream(this.$uri);
            final byte[] bArr = new byte[8];
            openInputStream.read(bArr);
            openInputStream.close();
            if (Utils.f52981j.m(bArr)) {
                this.this$0.u(this.$speed);
                ApngAnimator apngAnimator = this.this$0;
                ApngAnimatorOptions apngAnimatorOptions = this.$apngAnimatorOptions;
                apngAnimator.f52926i = apngAnimatorOptions != null ? apngAnimatorOptions.a() : null;
                InputStream openInputStream2 = this.this$0.f52929l.getContentResolver().openInputStream(this.$uri);
                Apng a11 = new APNGDisassembler().a(openInputStream2);
                openInputStream2.close();
                if (a11.c()) {
                    this.this$0.t(true);
                    this.this$0.v(this.this$0.k(a11.b()));
                } else {
                    this.this$0.t(false);
                    n1 unused2 = i.d(g1.f57277b, v0.c(), (CoroutineStart) null, new ApngAnimator$load$2$invokeSuspend$$inlined$also$lambda$1(a11, (c) null, this, openInputStream2), 2, (Object) null);
                }
            } else if (this.this$0.m()) {
                n1 unused3 = i.d(g1.f57277b, v0.c(), (CoroutineStart) null, new AnonymousClass2(this, (c) null), 2, (Object) null);
            } else {
                throw new NotPngException();
            }
            return Unit.f56620a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
