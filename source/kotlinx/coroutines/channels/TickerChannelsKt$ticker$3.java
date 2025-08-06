package kotlinx.coroutines.channels;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;

@d(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", l = {72, 73}, m = "invokeSuspend")
final class TickerChannelsKt$ticker$3 extends SuspendLambda implements p<k<? super Unit>, c<? super Unit>, Object> {
    public final /* synthetic */ long $delayMillis;
    public final /* synthetic */ long $initialDelayMillis;
    public final /* synthetic */ TickerMode $mode;
    private /* synthetic */ Object L$0;
    public int label;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57043a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                kotlinx.coroutines.channels.TickerMode[] r0 = kotlinx.coroutines.channels.TickerMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.coroutines.channels.TickerMode r1 = kotlinx.coroutines.channels.TickerMode.FIXED_PERIOD     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.coroutines.channels.TickerMode r1 = kotlinx.coroutines.channels.TickerMode.FIXED_DELAY     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f57043a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt$ticker$3.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TickerChannelsKt$ticker$3(TickerMode tickerMode, long j11, long j12, c<? super TickerChannelsKt$ticker$3> cVar) {
        super(2, cVar);
        this.$mode = tickerMode;
        this.$delayMillis = j11;
        this.$initialDelayMillis = j12;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        TickerChannelsKt$ticker$3 tickerChannelsKt$ticker$3 = new TickerChannelsKt$ticker$3(this.$mode, this.$delayMillis, this.$initialDelayMillis, cVar);
        tickerChannelsKt$ticker$3.L$0 = obj;
        return tickerChannelsKt$ticker$3;
    }

    public final Object invoke(k<? super Unit> kVar, c<? super Unit> cVar) {
        return ((TickerChannelsKt$ticker$3) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            k kVar = (k) this.L$0;
            int i12 = a.f57043a[this.$mode.ordinal()];
            if (i12 == 1) {
                long j11 = this.$delayMillis;
                long j12 = this.$initialDelayMillis;
                m channel = kVar.getChannel();
                this.label = 1;
                if (TickerChannelsKt.d(j11, j12, channel, this) == d11) {
                    return d11;
                }
            } else if (i12 == 2) {
                long j13 = this.$delayMillis;
                long j14 = this.$initialDelayMillis;
                m channel2 = kVar.getChannel();
                this.label = 2;
                if (TickerChannelsKt.c(j13, j14, channel2, this) == d11) {
                    return d11;
                }
            }
        } else if (i11 == 1 || i11 == 2) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
