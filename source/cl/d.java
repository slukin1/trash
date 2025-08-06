package cl;

import android.content.Context;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.view.DatePickerDialog;
import i6.k;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import pro.huobi.R;

public final class d {

    public class a implements DatePickerDialog.ResultListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f66754a = false;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f66755b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f66756c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ MethodCall f66757d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f66758e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f66759f;

        public a(boolean z11, long j11, MethodCall methodCall, MethodChannel.Result result, long j12) {
            this.f66755b = z11;
            this.f66756c = j11;
            this.f66757d = methodCall;
            this.f66758e = result;
            this.f66759f = j12;
        }

        public void onCancel() {
            if (!this.f66754a) {
                try {
                    this.f66758e.success((Object) null);
                } catch (Exception e11) {
                    k.k(e11);
                }
            }
        }

        public void onResult(DatePickerDialog datePickerDialog, long j11) {
            if (this.f66755b) {
                long currentTimeMillis = System.currentTimeMillis();
                if (d.c(currentTimeMillis, j11)) {
                    HuobiToastUtil.j(R.string.n_order_filter_start_time_error_tip);
                } else if (d.c(this.f66756c, j11)) {
                    HuobiToastUtil.j(R.string.n_order_filter_end_time_early_tip);
                } else if (Boolean.TRUE.equals(this.f66757d.argument("lifting120dayLimit")) || !d.c(j11, currentTimeMillis - 10281600000L)) {
                    this.f66754a = true;
                    try {
                        this.f66758e.success(Long.valueOf(j11));
                    } catch (Exception e11) {
                        k.k(e11);
                    }
                    datePickerDialog.dismiss();
                } else {
                    HuobiToastUtil.j(R.string.n_order_filter_four_months_ahead_tip2);
                }
            } else if (d.c(System.currentTimeMillis(), j11)) {
                HuobiToastUtil.j(R.string.n_order_filter_end_time_error_tip);
            } else if (d.c(j11, this.f66759f)) {
                HuobiToastUtil.j(R.string.n_order_filter_end_time_early_tip);
            } else {
                this.f66754a = true;
                try {
                    this.f66758e.success(Long.valueOf(j11));
                } catch (Exception e12) {
                    k.k(e12);
                }
                datePickerDialog.dismiss();
            }
        }
    }

    public static String b(long j11) {
        return DateTimeUtils.m(j11 / 1000);
    }

    public static boolean c(long j11, long j12) {
        return j11 < j12 && !b(j11).equals(b(j12));
    }

    public static void d(Context context, MethodCall methodCall, MethodChannel.Result result) {
        MethodCall methodCall2 = methodCall;
        MethodChannel.Result result2 = result;
        try {
            long longValue = methodCall2.hasArgument("startDate") ? ((Long) methodCall2.argument("startDate")).longValue() : 0;
            long longValue2 = methodCall2.hasArgument("endDate") ? ((Long) methodCall2.argument("endDate")).longValue() : 0;
            boolean booleanValue = methodCall2.hasArgument("isSelectedStartDate") ? ((Boolean) methodCall2.argument("isSelectedStartDate")).booleanValue() : false;
            if (booleanValue && longValue == 0) {
                i6.d.d(methodCall2.method + "startDate is 0");
                result2.success((Object) null);
            } else if (booleanValue || longValue2 != 0) {
                Context context2 = context;
                new DatePickerDialog.Builder().setInitDate(booleanValue ? longValue : longValue2).setTitle(booleanValue ? R.string.n_order_filter_start_time : R.string.n_order_filter_end_time).setResultListener(new a(booleanValue, longValue2, methodCall, result, longValue)).show(context);
            } else {
                i6.d.d(methodCall2.method + "endDate is 0");
                result2.success((Object) null);
            }
        } catch (Exception e11) {
            k.k(e11);
            result2.error("-1", methodCall2.method + "has error", (Object) null);
        }
    }
}
