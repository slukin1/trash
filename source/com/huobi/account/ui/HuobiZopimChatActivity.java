package com.huobi.account.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.huobi.utils.d1;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import com.zopim.android.sdk.api.Chat;
import com.zopim.android.sdk.api.ZopimChat;
import com.zopim.android.sdk.api.ZopimChatApi;
import com.zopim.android.sdk.chatlog.ZopimChatLogFragment;
import com.zopim.android.sdk.data.LivechatDepartmentsPath;
import com.zopim.android.sdk.data.observers.ChatItemsObserver;
import com.zopim.android.sdk.data.observers.ChatLogObserver;
import com.zopim.android.sdk.model.ChatLog;
import com.zopim.android.sdk.model.Department;
import com.zopim.android.sdk.model.items.AgentMessage;
import com.zopim.android.sdk.model.items.ChatEvent;
import com.zopim.android.sdk.model.items.ChatRating;
import com.zopim.android.sdk.model.items.RowItem;
import com.zopim.android.sdk.prechat.EmailTranscript;
import com.zopim.android.sdk.prechat.PreChatForm;
import com.zopim.android.sdk.prechat.ZopimChatActivity;
import com.zopim.android.sdk.prechat.ZopimChatFragment;
import com.zopim.android.sdk.prechat.ZopimPreChatFragment;
import i6.i;
import i6.k;
import i6.m;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import pro.huobi.R;
import zendesk.configurations.Configuration;
import zendesk.support.requestlist.RequestListActivity;

public class HuobiZopimChatActivity extends ZopimChatActivity {

    /* renamed from: g  reason: collision with root package name */
    public static final Object f41183g = new Object();

    /* renamed from: b  reason: collision with root package name */
    public Menu f41184b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentManager.FragmentLifecycleCallbacks f41185c;

    /* renamed from: d  reason: collision with root package name */
    public Chat f41186d;

    /* renamed from: e  reason: collision with root package name */
    public e f41187e;

    /* renamed from: f  reason: collision with root package name */
    public c f41188f = new c(this);

    public class a extends ClickableSpan {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f41189b;

        public a(TextView textView) {
            this.f41189b = textView;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (HuobiZopimChatActivity.this.f41186d != null) {
                HuobiZopimChatActivity.this.f41186d.endChat();
            }
            HuobiZopimChatActivity.this.onChatEnded();
            HuobiZopimChatActivity.this.finish();
            if (p.e()) {
                RequestListActivity.builder().show(this.f41189b.getContext(), new Configuration[0]);
            } else {
                HBBaseWebActivity.showWebView(this.f41189b.getContext(), d1.t(), "", "", false);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(HuobiZopimChatActivity.this.getResources().getColor(R.color.balance_exchange));
            textPaint.setUnderlineText(false);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41191a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.zopim.android.sdk.model.ChatLog$Rating[] r0 = com.zopim.android.sdk.model.ChatLog.Rating.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f41191a = r0
                com.zopim.android.sdk.model.ChatLog$Rating r1 = com.zopim.android.sdk.model.ChatLog.Rating.GOOD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f41191a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zopim.android.sdk.model.ChatLog$Rating r1 = com.zopim.android.sdk.model.ChatLog.Rating.BAD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.account.ui.HuobiZopimChatActivity.b.<clinit>():void");
        }
    }

    public class c extends ChatItemsObserver {
        public c(Context context) {
            super(context);
        }

        public ChatRating a(TreeMap<String, RowItem> treeMap) {
            long j11;
            ChatLog.Rating rating;
            ChatRating chatRating = null;
            if (treeMap != null && !treeMap.isEmpty()) {
                Iterator<Map.Entry<String, RowItem>> it2 = treeMap.entrySet().iterator();
                long j12 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        j11 = 0;
                        break;
                    }
                    Map.Entry next = it2.next();
                    if (!(next == null || next.getValue() == null)) {
                        if ((next.getValue() instanceof ChatRating) && RowItem.Type.CHAT_RATING == ((RowItem) next.getValue()).getType()) {
                            chatRating = (ChatRating) next.getValue();
                            j11 = m.m0((String) next.getKey());
                            break;
                        }
                        j12 = m.m0((String) next.getKey());
                    }
                }
                if (chatRating != null && ((rating = ChatLog.Rating.GOOD) == chatRating.getRating() || ChatLog.Rating.BAD == chatRating.getRating())) {
                    ChatEvent chatEvent = new ChatEvent();
                    chatEvent.setDisplayName("");
                    chatEvent.setMessage(HuobiZopimChatActivity.this.getResources().getString(rating == chatRating.getRating() ? R.string.rate_this_chat_event_good : R.string.rate_this_chat_event_bad));
                    chatEvent.setParticipantId("agent:trigger");
                    long currentTimeMillis = System.currentTimeMillis();
                    if (j11 <= 0 || j11 - j12 <= 1) {
                        long j13 = j11 + 1;
                        if (treeMap.get(String.valueOf(j13)) == null) {
                            currentTimeMillis = j13;
                        } else {
                            long m02 = m.m0(treeMap.lastKey());
                            if (m02 != 0) {
                                currentTimeMillis = m02 + 1;
                            }
                        }
                    } else {
                        currentTimeMillis = j11 - 1;
                    }
                    chatEvent.setTimestamp(Long.valueOf(currentTimeMillis));
                    chatEvent.setId(String.valueOf(currentTimeMillis));
                    treeMap.put(String.valueOf(currentTimeMillis), chatEvent);
                }
            }
            return chatRating;
        }

        public boolean b(TreeMap<String, RowItem> treeMap) {
            if (treeMap != null && !treeMap.isEmpty()) {
                for (Map.Entry next : treeMap.entrySet()) {
                    if (next != null && next.getValue() != null && ((RowItem) next.getValue()).getDisplayName() != null && RowItem.Type.AGENT_MESSAGE == ((RowItem) next.getValue()).getType()) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean c(TreeMap<String, RowItem> treeMap) {
            if (treeMap != null && !treeMap.isEmpty()) {
                for (Map.Entry next : treeMap.entrySet()) {
                    if (next != null && next.getValue() != null && RowItem.Type.AGENT_MESSAGE == ((RowItem) next.getValue()).getType() && !((AgentMessage) next.getValue()).getDisplayName().equals("火币牛牛")) {
                        return true;
                    }
                }
            }
            return false;
        }

        public synchronized void updateChatItems(TreeMap<String, RowItem> treeMap) {
            if (HuobiZopimChatActivity.this.f41187e != null) {
                synchronized (HuobiZopimChatActivity.f41183g) {
                    HuobiZopimChatActivity.this.f41187e.e(treeMap);
                    HuobiZopimChatActivity.this.f41187e.b(b(treeMap));
                    HuobiZopimChatActivity.this.f41187e.c(c(treeMap));
                    HuobiZopimChatActivity.this.f41187e.d(a(treeMap));
                }
                i.b().h(HuobiZopimChatActivity.this.f41187e);
                i.b().f(HuobiZopimChatActivity.this.f41187e);
            }
        }
    }

    public class d extends FragmentManager.FragmentLifecycleCallbacks {

        public class a implements View.OnClickListener {
            public a() {
            }

            @SensorsDataInstrumented
            public void onClick(View view) {
                RequestListActivity.builder().show(view.getContext(), new Configuration[0]);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }

        public d() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void f(View view) {
            try {
                HuobiZopimChatActivity.this.f41184b.performIdentifierAction(R.id.start_chat, 0);
            } catch (Exception e11) {
                e11.printStackTrace();
                k.e("HuobiZopimChatActivity-->onFragmentViewCreated-->" + e11);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ boolean h(RecyclerView recyclerView) {
            HuobiZopimChatActivity.this.Og(recyclerView);
            return true;
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void i(RadioGroup radioGroup, View view) {
            if (HuobiZopimChatActivity.this.f41187e == null || HuobiZopimChatActivity.this.f41187e.a() != ChatLog.Rating.BAD) {
                if (radioGroup != null) {
                    radioGroup.check(R.id.rate_negative_button);
                }
                if (HuobiZopimChatActivity.this.f41186d != null) {
                    HuobiZopimChatActivity.this.f41186d.sendChatRating(ChatLog.Rating.BAD);
                }
            } else {
                if (radioGroup != null) {
                    radioGroup.clearCheck();
                }
                if (HuobiZopimChatActivity.this.f41186d != null) {
                    HuobiZopimChatActivity.this.f41186d.sendChatRating(ChatLog.Rating.UNRATED);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void j(RadioGroup radioGroup, View view) {
            if (HuobiZopimChatActivity.this.f41187e == null || HuobiZopimChatActivity.this.f41187e.a() != ChatLog.Rating.GOOD) {
                if (radioGroup != null) {
                    radioGroup.check(R.id.rate_positive_button);
                }
                if (HuobiZopimChatActivity.this.f41186d != null) {
                    HuobiZopimChatActivity.this.f41186d.sendChatRating(ChatLog.Rating.GOOD);
                }
            } else {
                if (radioGroup != null) {
                    radioGroup.clearCheck();
                }
                if (HuobiZopimChatActivity.this.f41186d != null) {
                    HuobiZopimChatActivity.this.f41186d.sendChatRating(ChatLog.Rating.UNRATED);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public final void k(RadioGroup radioGroup, RadioButton radioButton, RadioButton radioButton2) {
            radioButton.setOnClickListener(new x(this, radioGroup));
            radioButton2.setOnClickListener(new w(this, radioGroup));
        }

        public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
            super.onFragmentAttached(fragmentManager, fragment, context);
        }

        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
            if (fragment instanceof ZopimPreChatFragment) {
                boolean contains = AppLanguageHelper.getInstance().getCurAppLocale().toString().contains(Locale.CHINA.toString());
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : LivechatDepartmentsPath.getInstance().getData().entrySet()) {
                    if (!((Department) entry.getValue()).getName().contains("---")) {
                        if (!contains && ((Department) entry.getValue()).getName().contains("--")) {
                            linkedHashMap.put((String) entry.getKey(), (Department) entry.getValue());
                        } else if (contains && !((Department) entry.getValue()).getName().contains("--") && ((Department) entry.getValue()).getName().contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                            linkedHashMap.put((String) entry.getKey(), (Department) entry.getValue());
                        }
                    }
                }
                try {
                    LivechatDepartmentsPath instance = LivechatDepartmentsPath.getInstance();
                    Class<?> cls = instance.getClass();
                    Method declaredMethod = cls.getDeclaredMethod("clear", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(instance, new Object[0]);
                    Method declaredMethod2 = cls.getDeclaredMethod("updateInternal", new Class[]{LinkedHashMap.class});
                    declaredMethod2.setAccessible(true);
                    declaredMethod2.invoke(instance, new Object[]{linkedHashMap});
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            } else if (fragment instanceof ZopimChatLogFragment) {
                e unused = HuobiZopimChatActivity.this.f41187e = new e((ZopimChatLogFragment) fragment);
            }
            super.onFragmentCreated(fragmentManager, fragment, bundle);
        }

        public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
            super.onFragmentStarted(fragmentManager, fragment);
            if (fragment instanceof ZopimChatLogFragment) {
                try {
                    Class<?> cls = fragment.getClass();
                    Field declaredField = cls.getDeclaredField("chat");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(fragment);
                    if (obj != null) {
                        Chat unused = HuobiZopimChatActivity.this.f41186d = (Chat) obj;
                    }
                    Field declaredField2 = cls.getDeclaredField("chatObserver");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(fragment);
                    if (obj2 instanceof ChatLogObserver) {
                        ZopimChatApi.getDataSource().deleteChatLogObserver((ChatLogObserver) obj2);
                        ZopimChatApi.getDataSource().addChatLogObserver(HuobiZopimChatActivity.this.f41188f);
                    }
                } catch (NoSuchFieldException e11) {
                    e11.printStackTrace();
                } catch (IllegalAccessException e12) {
                    e12.printStackTrace();
                }
            }
        }

        public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
            super.onFragmentStopped(fragmentManager, fragment);
            if (fragment instanceof ZopimChatLogFragment) {
                i.b().h(HuobiZopimChatActivity.this.f41187e);
                ZopimChatApi.getDataSource().deleteChatLogObserver(HuobiZopimChatActivity.this.f41188f);
            }
        }

        public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
            View findViewById;
            super.onFragmentViewCreated(fragmentManager, fragment, view, bundle);
            if (fragment instanceof ZopimPreChatFragment) {
                View findViewById2 = view.findViewById(R.id.tv_chat_next);
                if (findViewById2 != null) {
                    findViewById2.setVisibility(0);
                    findViewById2.setOnClickListener(new v(this));
                }
            } else if (fragment instanceof ZopimChatLogFragment) {
                i.b().g(new z(view), 2000);
                k((RadioGroup) view.findViewById(R.id.rating_top_group), (RadioButton) view.findViewById(R.id.rate_negative_button), (RadioButton) view.findViewById(R.id.rate_positive_button));
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                if (recyclerView != null) {
                    view.getViewTreeObserver().addOnPreDrawListener(new y(this, recyclerView));
                }
            } else if ((fragment instanceof ZopimChatFragment) && (findViewById = view.findViewById(R.id.no_agents_button)) != null) {
                findViewById.setOnClickListener(new a());
            }
        }
    }

    public static class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public SoftReference<ZopimChatLogFragment> f41195b;

        /* renamed from: c  reason: collision with root package name */
        public Method f41196c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f41197d = false;

        /* renamed from: e  reason: collision with root package name */
        public ChatRating f41198e;

        /* renamed from: f  reason: collision with root package name */
        public TreeMap<String, RowItem> f41199f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f41200g;

        public e(ZopimChatLogFragment zopimChatLogFragment) {
            this.f41195b = new SoftReference<>(zopimChatLogFragment);
            if (zopimChatLogFragment != null) {
                try {
                    Method declaredMethod = zopimChatLogFragment.getClass().getDeclaredMethod("updateChatLogAdapter", new Class[]{TreeMap.class});
                    this.f41196c = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e11) {
                    e11.printStackTrace();
                }
            }
        }

        public ChatLog.Rating a() {
            ChatRating chatRating = this.f41198e;
            return chatRating == null ? ChatLog.Rating.UNRATED : chatRating.getRating();
        }

        public void b(boolean z11) {
            this.f41197d = z11;
        }

        public void c(boolean z11) {
            this.f41200g = z11;
        }

        public void d(ChatRating chatRating) {
            this.f41198e = chatRating;
        }

        public void e(TreeMap<String, RowItem> treeMap) {
            this.f41199f = treeMap;
        }

        public void run() {
            ZopimChatLogFragment zopimChatLogFragment = this.f41195b.get();
            if (zopimChatLogFragment != null) {
                try {
                    if (zopimChatLogFragment.getView() != null) {
                        View findViewById = zopimChatLogFragment.getView().findViewById(R.id.top_func_container);
                        RadioGroup radioGroup = (RadioGroup) zopimChatLogFragment.getView().findViewById(R.id.rating_top_group);
                        if (findViewById != null) {
                            ViewUtil.m(findViewById, this.f41200g);
                            int i11 = b.f41191a[a().ordinal()];
                            if (i11 == 1) {
                                radioGroup.check(R.id.rate_positive_button);
                            } else if (i11 != 2) {
                                radioGroup.clearCheck();
                            } else {
                                radioGroup.check(R.id.rate_negative_button);
                            }
                        }
                    }
                    TreeMap<String, RowItem> treeMap = this.f41199f;
                    i6.d.j("testMain", treeMap == null ? "" : treeMap.toString());
                    synchronized (HuobiZopimChatActivity.f41183g) {
                        Method method = this.f41196c;
                        if (method != null) {
                            method.invoke(zopimChatLogFragment, new Object[]{this.f41199f});
                        }
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public static ZopimChat.SessionConfig gg() {
        PreChatForm.Builder builder = new PreChatForm.Builder();
        PreChatForm.Field field = PreChatForm.Field.REQUIRED_EDITABLE;
        return new ZopimChat.SessionConfig().preChatForm(builder.email(field).department(field).message(field).build()).emailTranscript(EmailTranscript.DISABLED).fileSending(true);
    }

    public static void startActivity(Context context, ZopimChat.SessionConfig sessionConfig) {
        Intent intent = new Intent(context, HuobiZopimChatActivity.class);
        intent.putExtra("CHAT_CONFIG", sessionConfig);
        context.startActivity(intent);
    }

    public final void Og(RecyclerView recyclerView) {
        for (int i11 = 0; i11 < recyclerView.getChildCount(); i11++) {
            View findViewById = recyclerView.getChildAt(i11).findViewById(R.id.message_text);
            if (findViewById instanceof TextView) {
                TextView textView = (TextView) findViewById;
                String charSequence = textView.getText().toString();
                if (charSequence.startsWith(getString(R.string.chat_please_wait)) && !charSequence.endsWith(getString(R.string.chat_submit_problem))) {
                    Pg(textView, charSequence + getString(R.string.chat_order_tip), getString(R.string.chat_submit_problem));
                    return;
                }
            }
        }
    }

    public final void Pg(TextView textView, String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        spannableString.setSpan(new a(textView), spannableString.length() - str2.length(), spannableString.length(), 17);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(AppLanguageHelper.getInstance().attachBaseContext(context));
    }

    public void onChatEnded() {
        super.onChatEnded();
    }

    public void onChatInitialized() {
        super.onChatInitialized();
    }

    public void onChatLoaded(Chat chat) {
        super.onChatLoaded(chat);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle((CharSequence) "");
        if (p.d()) {
            toolbar.setTitleTextColor(getResources().getColor(R.color.transparent));
        }
        this.f41185c = new d();
        getSupportFragmentManager().r1(this.f41185c, false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.f41184b = menu;
        return super.onCreateOptionsMenu(menu);
    }

    public void onDestroy() {
        super.onDestroy();
        getSupportFragmentManager().O1(this.f41185c);
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return onOptionsItemSelected;
    }

    public void startSubmit(View view) {
        if (p.e()) {
            RequestListActivity.builder().show((Context) this, new Configuration[0]);
        } else {
            HBBaseWebActivity.showWebView(this, d1.t(), "", "", false);
        }
    }

    public void startActivity(Intent intent) {
        ComponentName component;
        if (!(intent == null || (component = intent.getComponent()) == null || component.getClassName() == null || !component.getClassName().contains("ZopimCommentActivity"))) {
            intent.setClass(this, HuobiZopimCommentActivity.class);
        }
        super.startActivity(intent);
    }
}
