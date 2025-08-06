package com.huobi.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.module.huobi.im.utils.DateUtils;
import com.huobi.login.usercenter.data.source.bean.PasskeyListData;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.text.SimpleDateFormat;
import pro.huobi.R;
import tg.h;
import tg.r;
import u6.g;

public class SecurityPasskeyListActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f41327b;

    /* renamed from: c  reason: collision with root package name */
    public b f41328c;

    public class a extends EasySubscriber<PasskeyListData> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(PasskeyListData passkeyListData) {
            SecurityPasskeyListActivity.this.dismissProgressDialog();
            SecurityPasskeyListActivity.this.f41328c.d(passkeyListData);
            if (passkeyListData != null) {
                SecurityPasskeyListActivity.this.findViewById(R.id.btn_passkey_list_add).setVisibility(passkeyListData.getBind() == 1 ? 8 : 0);
                if (passkeyListData.getBind() == 1) {
                    h.c().g(r.x().s(), true);
                }
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            SecurityPasskeyListActivity.this.dismissProgressDialog();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            SecurityPasskeyListActivity.this.dismissProgressDialog();
        }
    }

    public static class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        public PasskeyListData f41330a;

        public class a extends RecyclerView.ViewHolder {
            public a(View view) {
                super(view);
            }
        }

        public b() {
        }

        @SensorsDataInstrumented
        public static /* synthetic */ void c(PasskeyListData.Passkey passkey, String str, View view) {
            Intent intent = new Intent(view.getContext(), SecurityPasskeyEditActivity.class);
            intent.putExtra("id", passkey.getId());
            intent.putExtra("remark", str);
            view.getContext().startActivity(intent);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void d(PasskeyListData passkeyListData) {
            this.f41330a = passkeyListData;
            notifyDataSetChanged();
        }

        public int getItemCount() {
            PasskeyListData passkeyListData = this.f41330a;
            if (passkeyListData == null || passkeyListData.getKeys() == null) {
                return 0;
            }
            return this.f41330a.getKeys().size();
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
            try {
                PasskeyListData.Passkey passkey = this.f41330a.getKeys().get(i11);
                String platformType = passkey.getPlatformType();
                long createTime = passkey.getCreateTime();
                long lastUseTime = passkey.getLastUseTime();
                String remark = passkey.getRemark();
                View view = viewHolder.itemView;
                String format = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(createTime));
                ((TextView) view.findViewById(R.id.tv_title_passkey_list_item)).setText(remark);
                ((TextView) view.findViewById(R.id.tv_second_title_passkey_list_item)).setText(view.getContext().getString(R.string.n_security_passkeys_time, new Object[]{format, platformType}));
                ((TextView) view.findViewById(R.id.tv_third_title_passkey_list_item)).setText(view.getContext().getString(R.string.n_security_passkeys_last, new Object[]{DateUtils.b(view.getContext(), lastUseTime, false)}));
                view.findViewById(R.id.iv_passkey_list_item_edit).setOnClickListener(new q1(passkey, remark));
            } catch (Throwable unused) {
            }
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_passkey_list, viewGroup, false));
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        startActivity(new Intent(this, SecurityPasskeyActivity.class));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Yf() {
        o9.a.a().passkeyList().b().compose(RxJavaHelper.t((g) null)).subscribe(new a());
    }

    public int getContentView() {
        return R.layout.activity_security_passkey_list;
    }

    public void initView() {
        super.initView();
        this.f41328c = new b((a) null);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.passkey_list);
        this.f41327b = recyclerView;
        recyclerView.setAdapter(this.f41328c);
        this.f41327b.setHasFixedSize(true);
        this.f41327b.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.btn_passkey_list_add).setOnClickListener(new p1(this));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onStart() {
        super.onStart();
        showProgressDialog();
        Yf();
    }
}
