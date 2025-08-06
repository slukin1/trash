package com.huobi.message.ui;

import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import cn.sharesdk.framework.InnerShareParams;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.uc.retrofit.bean.MessageConfig;
import com.hbg.lib.network.uc.retrofit.bean.MessageConfigWrapper;
import com.hbg.module.huobi.im.event.MessageSwitchEvent;
import com.hbg.module.huobi.im.group.ui.ChatBlockListActivity;
import com.hbg.module.libkt.helper.SensorsDataHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ko.i;
import ko.j;
import ko.k;
import ko.l;
import ko.m;
import ko.n;
import ko.o;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import q6.d;
import u6.g;

public class MessageConfigActivity extends EmptyMVPActivity {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f77995b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f77996c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f77997d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f77998e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f77999f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f78000g;

    /* renamed from: h  reason: collision with root package name */
    public SwitchCompat f78001h;

    /* renamed from: i  reason: collision with root package name */
    public SwitchCompat f78002i;

    /* renamed from: j  reason: collision with root package name */
    public SwitchCompat f78003j;

    /* renamed from: k  reason: collision with root package name */
    public SwitchCompat f78004k;

    /* renamed from: l  reason: collision with root package name */
    public SwitchCompat f78005l;

    /* renamed from: m  reason: collision with root package name */
    public View f78006m;

    /* renamed from: n  reason: collision with root package name */
    public View f78007n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f78008o;

    /* renamed from: p  reason: collision with root package name */
    public ImageView f78009p;

    public class a extends BaseSubscriber<List<MessageConfigWrapper>> {
        public a() {
        }

        public void onNext(List<MessageConfigWrapper> list) {
            super.onNext(list);
            if (list != null && !list.isEmpty()) {
                for (MessageConfigWrapper next : list) {
                    if ("4".equals(next.c())) {
                        if (next.b() != null && !next.b().isEmpty()) {
                            for (MessageConfig next2 : next.b()) {
                                jo.a.e().a(next2.c(), next2);
                            }
                        }
                        MessageConfigActivity.this.oh();
                    }
                }
                jo.a.e().b();
            }
        }
    }

    public class b extends d<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f78011e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f78012f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g gVar, String str, boolean z11) {
            super(gVar);
            this.f78011e = str;
            this.f78012f = z11;
        }

        /* renamed from: f */
        public void onNext(String str) {
            super.onNext(str);
            MessageConfig messageConfig = jo.a.e().d().get(this.f78011e);
            if (messageConfig != null) {
                messageConfig.e(this.f78012f ? "2" : "1");
            }
            MessageSwitchEvent messageSwitchEvent = new MessageSwitchEvent();
            messageSwitchEvent.f19696a = this.f78011e;
            messageSwitchEvent.f19697b = this.f78012f;
            EventBus.d().k(messageSwitchEvent);
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "setting");
            String str2 = this.f78011e;
            str2.hashCode();
            char c11 = 65535;
            switch (str2.hashCode()) {
                case -981780028:
                    if (str2.equals("Push-Follow")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -818994631:
                    if (str2.equals("Push-Letter")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 1187707435:
                    if (str2.equals("Push-Chat")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1187976810:
                    if (str2.equals("Push-Like")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 1262989996:
                    if (str2.equals("Push-Comment")) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    hashMap.put("type", "follow");
                    HashMap hashMap2 = new HashMap(1);
                    if (this.f78012f) {
                        hashMap.put("state", "open");
                        hashMap2.put("open", 1);
                    } else {
                        hashMap.put("state", "close");
                        hashMap2.put("open", 0);
                    }
                    SensorsDataHelper.track("appclick_messagesetting_newfollowers", hashMap2);
                    break;
                case 1:
                    hashMap.put("type", "message");
                    HashMap hashMap3 = new HashMap(1);
                    if (this.f78012f) {
                        hashMap.put("state", "open");
                        hashMap3.put("open", 1);
                    } else {
                        hashMap.put("state", "close");
                        hashMap3.put("open", 0);
                    }
                    SensorsDataHelper.track("appclick_messagesetting_notice", hashMap3);
                    break;
                case 2:
                    hashMap.put("type", "chat");
                    HashMap hashMap4 = new HashMap(1);
                    if (this.f78012f) {
                        hashMap.put("state", "open");
                        hashMap4.put("open", 1);
                    } else {
                        hashMap.put("state", "close");
                        hashMap4.put("open", 0);
                    }
                    SensorsDataHelper.track("appclick_messagesetting_allchat", hashMap4);
                    break;
                case 3:
                    hashMap.put("type", "thumbup");
                    HashMap hashMap5 = new HashMap(1);
                    if (this.f78012f) {
                        hashMap.put("state", "open");
                        hashMap5.put("open", 1);
                    } else {
                        hashMap.put("state", "close");
                        hashMap5.put("open", 0);
                    }
                    SensorsDataHelper.track("appclick_messagesetting_like", hashMap5);
                    break;
                case 4:
                    hashMap.put("type", InnerShareParams.COMMENT);
                    HashMap hashMap6 = new HashMap(1);
                    if (this.f78012f) {
                        hashMap.put("state", "open");
                        hashMap6.put("open", 1);
                    } else {
                        hashMap.put("state", "close");
                        hashMap6.put("open", 0);
                    }
                    SensorsDataHelper.track("appclick_messagesetting_comment", hashMap6);
                    break;
            }
            SensorsDataHelper.track("appClick_messgeCenter", hashMap);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            MessageConfigActivity.this.oh();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            MessageConfigActivity.this.oh();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ph(View view) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("blacklist", "blacklist");
        SensorsDataHelper.track("appclick_messagesetting_blacklist", hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("module_name", "setting");
        hashMap2.put("type", "blacklists");
        SensorsDataHelper.track("appClick_messgeCenter", hashMap2);
        startActivity(new Intent(this, ChatBlockListActivity.class));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void qh(Map map, CompoundButton compoundButton, boolean z11) {
        MessageConfig messageConfig = (MessageConfig) map.get("Push-Chat");
        if (messageConfig != null) {
            vh("Push-Chat", messageConfig.b(), z11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void rh(Map map, CompoundButton compoundButton, boolean z11) {
        MessageConfig messageConfig = (MessageConfig) map.get("Push-Comment");
        if (messageConfig != null) {
            vh("Push-Comment", messageConfig.b(), z11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void sh(Map map, CompoundButton compoundButton, boolean z11) {
        MessageConfig messageConfig = (MessageConfig) map.get("Push-Like");
        if (messageConfig != null) {
            vh("Push-Like", messageConfig.b(), z11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void th(Map map, CompoundButton compoundButton, boolean z11) {
        MessageConfig messageConfig = (MessageConfig) map.get("Push-Follow");
        if (messageConfig != null) {
            vh("Push-Follow", messageConfig.b(), z11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void uh(Map map, CompoundButton compoundButton, boolean z11) {
        MessageConfig messageConfig = (MessageConfig) map.get("Push-Letter");
        if (messageConfig != null) {
            vh("Push-Letter", messageConfig.b(), z11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    public void addEvent() {
        super.addEvent();
        this.f77995b.setOnClickListener(new j(this));
        this.f78007n.setOnClickListener(new i(this));
    }

    public void afterInit() {
        super.afterInit();
        this.f77996c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.f77997d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.f77998e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.f77999f.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.f78000g.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.f77996c.setText(getResources().getString(R.string.n_im_chat_no_disturbing));
        this.f77997d.setText(getResources().getString(R.string.n_im_comment_no_disturbing));
        this.f77998e.setText(getResources().getString(R.string.n_im_like_no_disturbing));
        this.f77999f.setText(getResources().getString(R.string.n_im_fans_no_disturbing));
        this.f78000g.setText(getResources().getString(R.string.n_im_noti_not_disturbing));
        this.f78006m.setVisibility(8);
        this.f78008o.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.f78008o.setCompoundDrawablePadding(PixelUtils.a(10.0f));
        this.f78008o.setText(getResources().getString(R.string.n_im_black_list));
        this.f78009p.setVisibility(8);
        this.f78001h.setChecked(false);
        this.f78002i.setChecked(false);
        this.f78003j.setChecked(false);
        this.f78004k.setChecked(false);
        this.f78005l.setChecked(false);
    }

    public int getContentView() {
        return R.layout.activity_message_config;
    }

    public void initView() {
        super.initView();
        this.f77995b = (ImageView) findViewById(R.id.iv_group_list_back);
        View findViewById = findViewById(R.id.include_message_chat);
        this.f77996c = (TextView) findViewById.findViewById(R.id.id_setting_list_item_title);
        this.f78001h = (SwitchCompat) findViewById.findViewById(R.id.quickly_withdraw_cb);
        View findViewById2 = findViewById(R.id.include_message_comment);
        this.f77997d = (TextView) findViewById2.findViewById(R.id.id_setting_list_item_title);
        this.f78002i = (SwitchCompat) findViewById2.findViewById(R.id.quickly_withdraw_cb);
        View findViewById3 = findViewById(R.id.include_message_like);
        this.f77998e = (TextView) findViewById3.findViewById(R.id.id_setting_list_item_title);
        this.f78003j = (SwitchCompat) findViewById3.findViewById(R.id.quickly_withdraw_cb);
        View findViewById4 = findViewById(R.id.include_message_follow);
        this.f77999f = (TextView) findViewById4.findViewById(R.id.id_setting_list_item_title);
        this.f78004k = (SwitchCompat) findViewById4.findViewById(R.id.quickly_withdraw_cb);
        View findViewById5 = findViewById(R.id.include_message_letter);
        this.f78000g = (TextView) findViewById5.findViewById(R.id.id_setting_list_item_title);
        this.f78005l = (SwitchCompat) findViewById5.findViewById(R.id.quickly_withdraw_cb);
        this.f78006m = findViewById5.findViewById(R.id.setting_list_item_divider);
        View findViewById6 = findViewById(R.id.include_message_blacklist);
        this.f78007n = findViewById6;
        this.f78008o = (TextView) findViewById6.findViewById(R.id.id_setting_list_item_title);
        this.f78009p = (ImageView) findViewById6.findViewById(R.id.id_setting_list_item_dot);
    }

    public final void oh() {
        this.f78001h.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.f78002i.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.f78003j.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.f78004k.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        this.f78005l.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        Map<String, MessageConfig> d11 = jo.a.e().d();
        if (d11 == null || d11.isEmpty()) {
            this.f78001h.setChecked(false);
            this.f78002i.setChecked(false);
            this.f78003j.setChecked(false);
            this.f78004k.setChecked(false);
            this.f78005l.setChecked(false);
        } else {
            MessageConfig messageConfig = d11.get("Push-Chat");
            if (messageConfig == null || !"2".equals(messageConfig.d())) {
                this.f78001h.setChecked(false);
            } else {
                this.f78001h.setChecked(true);
            }
            MessageConfig messageConfig2 = d11.get("Push-Comment");
            if (messageConfig2 == null || !"2".equals(messageConfig2.d())) {
                this.f78002i.setChecked(false);
            } else {
                this.f78002i.setChecked(true);
            }
            MessageConfig messageConfig3 = d11.get("Push-Like");
            if (messageConfig3 == null || !"2".equals(messageConfig3.d())) {
                this.f78003j.setChecked(false);
            } else {
                this.f78003j.setChecked(true);
            }
            MessageConfig messageConfig4 = d11.get("Push-Follow");
            if (messageConfig4 == null || !"2".equals(messageConfig4.d())) {
                this.f78004k.setChecked(false);
            } else {
                this.f78004k.setChecked(true);
            }
            MessageConfig messageConfig5 = d11.get("Push-Letter");
            if (messageConfig5 == null || !"2".equals(messageConfig5.d())) {
                this.f78005l.setChecked(false);
            } else {
                this.f78005l.setChecked(true);
            }
        }
        this.f78001h.setOnCheckedChangeListener(new k(this, d11));
        this.f78002i.setOnCheckedChangeListener(new o(this, d11));
        this.f78003j.setOnCheckedChangeListener(new l(this, d11));
        this.f78004k.setOnCheckedChangeListener(new n(this, d11));
        this.f78005l.setOnCheckedChangeListener(new m(this, d11));
    }

    public void onResume() {
        super.onResume();
        wh();
    }

    public final void vh(String str, String str2, boolean z11) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("label_ids", Arrays.asList(new String[]{str2}));
        hashMap.put("type", z11 ? "2" : "1");
        o9.a.a().modifySwitchConfig(hashMap).b().compose(RxJavaHelper.t(getUI())).subscribe(new b(getUI(), str, z11));
    }

    public final void wh() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("type", "PRO_LETTER");
        o9.a.a().requestSwitchConfig(hashMap).b().compose(RxJavaHelper.t(getUI())).retry(3).subscribe(new a());
    }
}
