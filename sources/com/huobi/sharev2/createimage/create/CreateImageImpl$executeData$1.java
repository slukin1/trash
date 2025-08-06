package com.huobi.sharev2.createimage.create;

import com.blankj.utilcode.util.a;
import d10.l;
import java.util.concurrent.CountDownLatch;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class CreateImageImpl$executeData$1 extends Lambda implements l<f, Unit> {
    public final /* synthetic */ CountDownLatch $cdl;
    public final /* synthetic */ f $element;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CreateImageImpl$executeData$1(f fVar, CountDownLatch countDownLatch) {
        super(1);
        this.$element = fVar;
        this.$cdl = countDownLatch;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((f) obj);
        return Unit.f56620a;
    }

    public final void invoke(f fVar) {
        CountDownLatch countDownLatch;
        try {
            new CanvasImageReady().f(this.$element, a.c());
            countDownLatch = this.$cdl;
            if (countDownLatch == null) {
                return;
            }
        } catch (Exception unused) {
            countDownLatch = this.$cdl;
            if (countDownLatch == null) {
                return;
            }
        } catch (Throwable th2) {
            CountDownLatch countDownLatch2 = this.$cdl;
            if (countDownLatch2 != null) {
                countDownLatch2.countDown();
            }
            throw th2;
        }
        countDownLatch.countDown();
    }
}
