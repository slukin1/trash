package com.huobi.account.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.AccountChallengeTask;
import com.hbg.lib.network.hbg.core.bean.AccountTaskResp;
import com.hbg.lib.network.hbg.core.bean.TaskDrawInfo;
import com.hbg.lib.network.hbg.core.bean.TaskPrizeResp;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huochat.community.util.ToastTool;
import f6.c;
import gs.g;
import i6.d;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import v7.b;
import wg.p;
import wg.q;

public class BoxChallengeTaskView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public LinearLayoutCompat f41909b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f41910c;

    /* renamed from: d  reason: collision with root package name */
    public AppCompatTextView f41911d;

    /* renamed from: e  reason: collision with root package name */
    public AppCompatImageView f41912e;

    /* renamed from: f  reason: collision with root package name */
    public TaskBoxButtonView f41913f;

    /* renamed from: g  reason: collision with root package name */
    public AppCompatTextView f41914g;

    /* renamed from: h  reason: collision with root package name */
    public AppCompatTextView f41915h;

    /* renamed from: i  reason: collision with root package name */
    public SemicircleProgressView f41916i;

    /* renamed from: j  reason: collision with root package name */
    public String f41917j;

    /* renamed from: k  reason: collision with root package name */
    public LottieAnimationView f41918k;

    /* renamed from: l  reason: collision with root package name */
    public int f41919l;

    public class a extends BaseSubscriber<TaskPrizeResp> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f41920b;

        public a(boolean z11) {
            this.f41920b = z11;
        }

        /* renamed from: a */
        public void onNext(TaskPrizeResp taskPrizeResp) {
            super.onNext(taskPrizeResp);
            BoxChallengeTaskView boxChallengeTaskView = BoxChallengeTaskView.this;
            boxChallengeTaskView.f41919l = 0;
            if (this.f41920b) {
                boxChallengeTaskView.f41913f.setButtonUIState(1);
            } else {
                boxChallengeTaskView.f41913f.setButtonUIState(4);
                BoxChallengeTaskView.this.f41912e.setImageResource(R.drawable.ic_treasure_box_opened);
                BoxChallengeTaskView.this.f41912e.setVisibility(0);
                BoxChallengeTaskView.this.f41918k.setVisibility(8);
            }
            ToastTool.show(BoxChallengeTaskView.this.getResources().getString(R.string.n_uc_task_received), 0);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }
    }

    public BoxChallengeTaskView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(AccountChallengeTask.ChallengeChildTask challengeChildTask, AccountChallengeTask.TaskStageInfoResp taskStageInfoResp, Void voidR) {
        if (this.f41919l > 0) {
            g(challengeChildTask);
        } else if (taskStageInfoResp.getStageState() < 5) {
            i(challengeChildTask.getH5Url());
        } else {
            i(challengeChildTask.getUrl());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(AccountChallengeTask.ChallengeChildTask challengeChildTask, Void voidR) {
        i(challengeChildTask.getUrl());
    }

    public void f() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "挑战任务");
        hashMap.put("business_category", "Rewards");
        g.i("box_Me_click", hashMap);
    }

    public final void g(AccountChallengeTask.ChallengeChildTask challengeChildTask) {
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        for (AccountChallengeTask.TaskStageInfoResp next : challengeChildTask.getStageList()) {
            if (next.getStageState() == 5) {
                TaskDrawInfo taskDrawInfo = new TaskDrawInfo();
                taskDrawInfo.setUserTaskId(Long.valueOf(challengeChildTask.getUserTaskId()));
                taskDrawInfo.setStageId((long) next.getStageId());
                arrayList.add(taskDrawInfo);
            } else if (next.getStageState() < 5) {
                z11 = true;
            }
        }
        b.a().J(arrayList).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new a(z11));
    }

    public String getBubbleTitle() {
        return this.f41917j;
    }

    public final void h(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.part_home_account_challenge_task, this, true);
        this.f41909b = (LinearLayoutCompat) inflate.findViewById(R.id.llRewardsContainer);
        this.f41910c = (RelativeLayout) inflate.findViewById(R.id.llChallengeTaskTopProgress);
        this.f41912e = (AppCompatImageView) inflate.findViewById(R.id.aivChallengeTaskTopImage);
        this.f41911d = (AppCompatTextView) inflate.findViewById(R.id.atvTaskTitle);
        this.f41913f = (TaskBoxButtonView) inflate.findViewById(R.id.llTaskAction);
        this.f41914g = (AppCompatTextView) inflate.findViewById(R.id.atvStartAmount);
        this.f41915h = (AppCompatTextView) inflate.findViewById(R.id.atvEndAmount);
        this.f41916i = (SemicircleProgressView) inflate.findViewById(R.id.challengeTaskProgressView);
        this.f41918k = (LottieAnimationView) inflate.findViewById(R.id.lottieBoxUnLock);
    }

    public final void i(String str) {
        f();
        if (!TextUtils.isEmpty(str)) {
            d.b("BoxChallengeTaskView:jumpUrl = " + str);
            BaseModuleConfig.a().k0(str);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void setData(AccountChallengeTask.ChallengeChildTask challengeChildTask) {
        List<AccountChallengeTask.TaskStageInfoResp> stageList = challengeChildTask.getStageList();
        AccountChallengeTask.TaskStageInfoResp taskStageInfoResp = null;
        for (int size = stageList.size() - 1; size >= 0; size--) {
            int stageState = stageList.get(size).getStageState();
            if (stageState < 5) {
                taskStageInfoResp = stageList.get(size);
            } else if (stageState == 5) {
                this.f41919l++;
            }
        }
        if (taskStageInfoResp == null) {
            taskStageInfoResp = stageList.get(stageList.size() - 1);
        }
        this.f41917j = taskStageInfoResp.getBubbleTitle();
        List<AccountTaskResp.TaskAwardResp> taskAwards = taskStageInfoResp.getTaskAwards();
        int i11 = 0;
        while (i11 < taskAwards.size() && i11 < 4) {
            AccountTaskResp.TaskAwardResp taskAwardResp = taskAwards.get(i11);
            if (!TextUtils.isEmpty(taskAwardResp.getIcon())) {
                LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(PixelUtils.a(12.0f), PixelUtils.a(12.0f));
                AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                appCompatImageView.setLayoutParams(layoutParams);
                c.a().e(appCompatImageView, taskAwardResp.getIcon());
                this.f41909b.addView(appCompatImageView);
            }
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            appCompatTextView.setTextSize(1, 10.0f);
            appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
            appCompatTextView.setMaxLines(1);
            appCompatTextView.setSingleLine();
            appCompatTextView.setTextColor(getContext().getResources().getColor(R.color.baseColorPrimaryText));
            if (taskAwardResp.getType() != 1) {
                appCompatTextView.setText("+" + taskAwardResp.getCount() + " ");
            } else {
                appCompatTextView.setText("+" + taskAwardResp.getCount() + " " + taskAwardResp.getCurrency() + " ");
            }
            this.f41909b.addView(appCompatTextView);
            i11++;
        }
        this.f41911d.setText(taskStageInfoResp.getTitle());
        if (taskStageInfoResp.getStageState() == 5) {
            this.f41910c.setVisibility(8);
            this.f41912e.setVisibility(8);
            this.f41918k.setVisibility(0);
        } else if (taskStageInfoResp.getStageState() > 5) {
            this.f41910c.setVisibility(8);
            this.f41912e.setVisibility(0);
            this.f41912e.setImageResource(R.drawable.ic_treasure_box_opened);
            this.f41918k.setVisibility(8);
        } else {
            this.f41910c.setVisibility(0);
            this.f41912e.setVisibility(8);
            this.f41918k.setVisibility(8);
            this.f41914g.setText(taskStageInfoResp.getStartPeriod().toString());
            this.f41915h.setText(taskStageInfoResp.getEndPeriod().toString());
            this.f41916i.setCurrentStep((int) (taskStageInfoResp.getFinishAmount().divide(taskStageInfoResp.getEndPeriod().subtract(taskStageInfoResp.getStartPeriod()), 2, RoundingMode.HALF_UP).floatValue() * 100.0f));
        }
        int i12 = this.f41919l;
        if (i12 > 0) {
            if (i12 > 1) {
                this.f41913f.b(3, i12);
            } else {
                this.f41913f.setButtonUIState(2);
            }
        } else if (taskStageInfoResp.getStageState() < 5) {
            this.f41913f.setButtonUIState(1);
        } else {
            this.f41913f.setButtonUIState(4);
        }
        Observable<Void> a11 = dw.a.a(this.f41913f);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new q(this, challengeChildTask, taskStageInfoResp));
        dw.a.a(this).throttleFirst(1, timeUnit).subscribe(new p(this, challengeChildTask));
    }

    public BoxChallengeTaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public BoxChallengeTaskView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f41919l = 0;
        h(context);
    }
}
