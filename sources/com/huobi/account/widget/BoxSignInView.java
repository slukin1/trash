package com.huobi.account.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.AccountChallengeTask;
import com.hbg.lib.network.hbg.core.bean.AccountTaskResp;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huochat.community.util.ToastTool;
import f6.c;
import gs.g;
import i6.d;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import v7.b;
import wg.t;
import wg.u;

public class BoxSignInView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public AppCompatImageView f41928b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayoutCompat f41929c;

    /* renamed from: d  reason: collision with root package name */
    public AppCompatTextView f41930d;

    /* renamed from: e  reason: collision with root package name */
    public TaskBoxButtonView f41931e;

    /* renamed from: f  reason: collision with root package name */
    public String f41932f;

    public class a extends BaseSubscriber<AccountChallengeTask.SignInResp> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccountChallengeTask.CheckInBean f41933b;

        public a(AccountChallengeTask.CheckInBean checkInBean) {
            this.f41933b = checkInBean;
        }

        /* renamed from: a */
        public void onNext(AccountChallengeTask.SignInResp signInResp) {
            super.onNext(signInResp);
            BoxSignInView.this.f41931e.setButtonUIState(4);
            BoxSignInView.this.j(this.f41933b.getSignNum() + 1, this.f41933b.getTotalNum());
            this.f41933b.setStatus(7);
            ToastTool.show(BoxSignInView.this.getResources().getString(R.string.n_uc_task_received), 0);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }
    }

    public BoxSignInView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(AccountChallengeTask.CheckInBean checkInBean, Void voidR) {
        if (checkInBean.getStatus() < 5) {
            k(checkInBean);
        } else {
            g(checkInBean.getUrl());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(AccountChallengeTask.CheckInBean checkInBean, Void voidR) {
        g(checkInBean.getUrl());
    }

    public void e() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "挑战任务");
        hashMap.put("business_category", "Rewards");
        g.i("box_Me_click", hashMap);
    }

    public final void f(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.part_home_account_signin_task, this, true);
        this.f41928b = (AppCompatImageView) inflate.findViewById(R.id.aivSignInImage);
        this.f41929c = (LinearLayoutCompat) inflate.findViewById(R.id.llRewardsContainer);
        this.f41930d = (AppCompatTextView) inflate.findViewById(R.id.atvTaskTitle);
        this.f41931e = (TaskBoxButtonView) inflate.findViewById(R.id.llTaskAction);
    }

    public final void g(String str) {
        e();
        if (!TextUtils.isEmpty(str)) {
            d.b("BoxSignInView:jumpUrl = " + str);
            BaseModuleConfig.a().k0(str);
        }
    }

    public String getBubbleTitle() {
        return this.f41932f;
    }

    public final void j(int i11, int i12) {
        if (i11 > i12) {
            i11 = i12;
        }
        String string = getContext().getString(R.string.n_uc_task_checkin, new Object[]{" " + i11 + "/" + i12});
        int indexOf = string.indexOf(i11 + "");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.baseColorMajorTheme100)), indexOf, String.valueOf(i11).length() + indexOf, 33);
        this.f41930d.setText(spannableStringBuilder);
    }

    public final void k(AccountChallengeTask.CheckInBean checkInBean) {
        b.a().q0(checkInBean.getActivityId(), checkInBean.getUserTaskId()).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new a(checkInBean));
    }

    @SuppressLint({"SetTextI18n"})
    public void setData(AccountChallengeTask.CheckInBean checkInBean) {
        this.f41932f = checkInBean.getBubbleTitle();
        c.a().e(this.f41928b, checkInBean.getIcon());
        List<AccountTaskResp.TaskAwardResp> taskAwards = checkInBean.getTaskAwards();
        int i11 = 0;
        while (i11 < taskAwards.size() && i11 < 4) {
            AccountTaskResp.TaskAwardResp taskAwardResp = taskAwards.get(i11);
            if (!TextUtils.isEmpty(taskAwardResp.getIcon())) {
                LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(PixelUtils.a(12.0f), PixelUtils.a(12.0f));
                AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                appCompatImageView.setLayoutParams(layoutParams);
                c.a().e(appCompatImageView, taskAwardResp.getIcon());
                this.f41929c.addView(appCompatImageView);
            }
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            appCompatTextView.setTextSize(1, 10.0f);
            appCompatTextView.setTextColor(getContext().getResources().getColor(R.color.baseColorPrimaryText));
            if (taskAwardResp.getType() != 1) {
                appCompatTextView.setText("+" + taskAwardResp.getCount() + " ");
            } else {
                appCompatTextView.setText("+" + taskAwardResp.getCount() + " " + taskAwardResp.getCurrency() + " ");
            }
            this.f41929c.addView(appCompatTextView);
            i11++;
        }
        j(checkInBean.getSignNum(), checkInBean.getTotalNum());
        if (checkInBean.getStatus() > 5) {
            this.f41931e.setButtonUIState(4);
        } else {
            this.f41931e.setButtonUIState(1);
            if (checkInBean.getTotalNum() - checkInBean.getSignNum() == 1) {
                this.f41931e.setText(R.string.n_uc_task_receive);
            } else {
                this.f41931e.setText(R.string.n_user_center_signin);
            }
        }
        Observable<Void> a11 = dw.a.a(this.f41931e);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new u(this, checkInBean));
        dw.a.a(this).throttleFirst(1, timeUnit).subscribe(new t(this, checkInBean));
    }

    public BoxSignInView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public BoxSignInView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        f(context);
    }
}
