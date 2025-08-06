package zendesk.classic.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.z;
import com.google.android.material.snackbar.Snackbar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.squareup.picasso.Picasso;
import com.zendesk.logger.Logger;
import g30.g;
import java.util.List;
import zendesk.classic.messaging.Banner;
import zendesk.classic.messaging.MessagingConfiguration;
import zendesk.classic.messaging.Update;
import zendesk.classic.messaging.ui.InputBox;
import zendesk.classic.messaging.ui.MessagingState;
import zendesk.classic.messaging.ui.MessagingView;
import zendesk.classic.messaging.ui.p;
import zendesk.classic.messaging.ui.t;
import zendesk.commonui.CacheFragment;
import zendesk.configurations.ConfigurationHelper;

public class MessagingActivity extends AppCompatActivity {

    /* renamed from: b  reason: collision with root package name */
    public l f62352b;

    /* renamed from: c  reason: collision with root package name */
    public p f62353c;

    /* renamed from: d  reason: collision with root package name */
    public Picasso f62354d;

    /* renamed from: e  reason: collision with root package name */
    public e f62355e;

    /* renamed from: f  reason: collision with root package name */
    public t f62356f;

    /* renamed from: g  reason: collision with root package name */
    public i f62357g;

    /* renamed from: h  reason: collision with root package name */
    public MessagingView f62358h;

    public class a implements View.OnClickListener {
        public a() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            MessagingActivity.this.finish();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements z<MessagingState> {
        public b() {
        }

        /* renamed from: a */
        public void onChanged(MessagingState messagingState) {
            MessagingView nf2 = MessagingActivity.this.f62358h;
            MessagingActivity messagingActivity = MessagingActivity.this;
            nf2.a(messagingState, messagingActivity.f62353c, messagingActivity.f62354d, messagingActivity.f62352b, messagingActivity.f62355e);
        }
    }

    public class c implements z<Update.a.C0685a> {
        public c() {
        }

        /* renamed from: a */
        public void onChanged(Update.a.C0685a aVar) {
            if (aVar != null) {
                aVar.b(MessagingActivity.this);
            }
        }
    }

    public class d implements z<Banner> {
        public d() {
        }

        /* renamed from: a */
        public void onChanged(Banner banner) {
            if (banner != null && banner.b() == Banner.Position.BOTTOM) {
                Snackbar.make(MessagingActivity.this.findViewById(R$id.zui_recycler_view), (CharSequence) banner.a(), 0).show();
            }
        }
    }

    public class e implements z<List<g>> {
        public e() {
        }

        /* renamed from: a */
        public void onChanged(List<g> list) {
            MessagingActivity.this.invalidateOptionsMenu();
        }
    }

    public static MessagingConfiguration.Builder Af() {
        return new MessagingConfiguration.Builder();
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        l lVar = this.f62352b;
        if (lVar != null) {
            lVar.a(this.f62355e.g(i11, i12, intent));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getTheme().applyStyle(R$style.ZendeskActivityDefaultTheme, true);
        MessagingConfiguration messagingConfiguration = (MessagingConfiguration) new ConfigurationHelper().f(getIntent().getExtras(), MessagingConfiguration.class);
        if (messagingConfiguration == null) {
            Logger.d("MessagingActivity", "No configuration found. Please use MessagingActivity.builder()", new Object[0]);
            finish();
            return;
        }
        CacheFragment ph2 = CacheFragment.ph(this);
        h hVar = (h) ph2.qh("messaging_component");
        if (hVar == null) {
            List<c> engines = messagingConfiguration.getEngines();
            if (mz.a.g(engines)) {
                Logger.d("MessagingActivity", "No Engines found in MessagingConfiguration. Please use MessagingActivity.builder()", new Object[0]);
                finish();
                return;
            }
            hVar = b.a().c(getApplicationContext()).a(engines).b(messagingConfiguration).build();
            hVar.d().m0();
            ph2.rh("messaging_component", hVar);
        }
        a.a().a(hVar).b(this).build().a(this);
        setContentView(R$layout.zui_activity_messaging);
        this.f62358h = (MessagingView) findViewById(R$id.zui_view_messaging);
        Toolbar toolbar = (Toolbar) findViewById(R$id.zui_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new a());
        toolbar.setTitle((CharSequence) messagingConfiguration.getToolbarTitle(getResources()));
        this.f62356f.b((InputBox) findViewById(R$id.zui_input_box));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        if (this.f62352b == null) {
            return false;
        }
        menu.clear();
        List<g> value = this.f62352b.j0().getValue();
        if (mz.a.g(value)) {
            Logger.b("MessagingActivity", "Menu: no items, hiding...", new Object[0]);
            return false;
        }
        for (g gVar : value) {
            menu.add(0, gVar.a(), 0, gVar.b());
        }
        Logger.b("MessagingActivity", "Menu: items updated.", new Object[0]);
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        if (!isChangingConfigurations() && this.f62352b != null) {
            Logger.b("MessagingActivity", "onDestroy() called, clearing...", new Object[0]);
            this.f62352b.onCleared();
        }
    }

    @SensorsDataInstrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        this.f62352b.a(this.f62355e.f(menuItem.getItemId()));
        SensorsDataAutoTrackHelper.trackMenuItem(this, menuItem);
        return true;
    }

    public void onStart() {
        super.onStart();
        l lVar = this.f62352b;
        if (lVar != null) {
            lVar.k0().observe(this, new b());
            this.f62352b.l0().observe(this, new c());
            this.f62352b.i0().observe(this, new d());
            this.f62352b.j0().observe(this, new e());
            this.f62352b.h0().observe(this, this.f62357g);
        }
    }
}
