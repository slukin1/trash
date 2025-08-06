package com.huobi.account.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.AccountNewComerTask;
import com.hbg.lib.network.hbg.core.bean.AccountTaskResp;
import com.hbg.lib.network.hbg.core.bean.TaskDrawInfo;
import com.hbg.lib.network.hbg.core.bean.TaskPrizeResp;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huochat.community.util.ToastTool;
import f6.c;
import gs.g;
import i6.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rx.Observable;
import v7.b;
import wg.r;
import wg.s;

public class BoxNewcomerView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public AppCompatTextView f41922b;

    /* renamed from: c  reason: collision with root package name */
    public TaskBoxButtonView f41923c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayoutCompat f41924d;

    /* renamed from: e  reason: collision with root package name */
    public AppCompatTextView f41925e;

    public class a extends BaseSubscriber<TaskPrizeResp> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccountNewComerTask f41926b;

        public a(AccountNewComerTask accountNewComerTask) {
            this.f41926b = accountNewComerTask;
        }

        /* renamed from: a */
        public void onNext(TaskPrizeResp taskPrizeResp) {
            super.onNext(taskPrizeResp);
            BoxNewcomerView.this.f41923c.setButtonUIState(4);
            this.f41926b.setStatus(7);
            ToastTool.show(BoxNewcomerView.this.getResources().getString(R.string.n_uc_task_received), 0);
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }
    }

    public BoxNewcomerView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(AccountNewComerTask accountNewComerTask, Void voidR) {
        if (accountNewComerTask.getStatus() < 5) {
            g(accountNewComerTask.getH5Url());
        } else if (accountNewComerTask.getStatus() == 5) {
            e(accountNewComerTask);
        } else {
            g(accountNewComerTask.getUrl());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(AccountNewComerTask accountNewComerTask, Void voidR) {
        g(accountNewComerTask.getUrl());
    }

    public void d() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "新手任务");
        hashMap.put("business_category", "Rewards");
        g.i("box_Me_click", hashMap);
    }

    public final void e(AccountNewComerTask accountNewComerTask) {
        ArrayList arrayList = new ArrayList();
        TaskDrawInfo taskDrawInfo = new TaskDrawInfo();
        taskDrawInfo.setUserTaskId(Long.valueOf(accountNewComerTask.getId()));
        arrayList.add(taskDrawInfo);
        b.a().J(arrayList).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new a(accountNewComerTask));
    }

    public final void f(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.part_home_account_newcomer_task, this, true);
        this.f41922b = (AppCompatTextView) inflate.findViewById(R.id.atvTaskTitle);
        this.f41923c = (TaskBoxButtonView) inflate.findViewById(R.id.llTaskAction);
        this.f41924d = (LinearLayoutCompat) inflate.findViewById(R.id.llIcons);
        this.f41925e = (AppCompatTextView) inflate.findViewById(R.id.atvRewards);
    }

    public final void g(String str) {
        d();
        d.b("BoxNewcomerView:jumpUrl = " + str);
        if (!TextUtils.isEmpty(str)) {
            BaseModuleConfig.a().k0(str);
        }
    }

    public LinearLayoutCompat getIconsContainer() {
        return this.f41924d;
    }

    @SuppressLint({"SetTextI18n"})
    public void setData(AccountNewComerTask accountNewComerTask) {
        List<AccountTaskResp.TaskAwardResp> taskAwards = accountNewComerTask.getTaskAwards();
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        while (i11 < taskAwards.size() && i11 < 4) {
            AccountTaskResp.TaskAwardResp taskAwardResp = taskAwards.get(i11);
            if (!TextUtils.isEmpty(taskAwardResp.getIcon())) {
                LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-2, -1);
                if (this.f41924d.getChildCount() != 0) {
                    layoutParams.setMarginStart(PixelUtils.a(-6.0f));
                }
                ImageView imageView = new ImageView(getContext());
                imageView.setAdjustViewBounds(true);
                imageView.setLayoutParams(layoutParams);
                c.a().e(imageView, taskAwardResp.getIcon());
                this.f41924d.addView(imageView);
            }
            if (taskAwardResp.getType() == 1) {
                sb2.append(" +");
                sb2.append(taskAwardResp.getCount());
                sb2.append(" ");
                sb2.append(taskAwardResp.getCurrency());
            } else {
                sb2.append(" +");
                sb2.append(taskAwardResp.getCount());
            }
            i11++;
        }
        if (this.f41924d.getChildCount() == 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f41925e.getLayoutParams();
            layoutParams2.topMargin = 0;
            this.f41925e.setLayoutParams(layoutParams2);
        }
        this.f41925e.setText(sb2);
        this.f41922b.setText(accountNewComerTask.getTitle());
        if (accountNewComerTask.getStatus() == 5) {
            this.f41923c.setButtonUIState(2);
        } else if (accountNewComerTask.getStatus() > 5) {
            this.f41923c.setButtonUIState(4);
        } else {
            this.f41923c.setButtonUIState(1);
        }
        Observable<Void> a11 = dw.a.a(this.f41923c);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new s(this, accountNewComerTask));
        dw.a.a(this).throttleFirst(1, timeUnit).subscribe(new r(this, accountNewComerTask));
    }

    public BoxNewcomerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public BoxNewcomerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        f(context);
    }
}
