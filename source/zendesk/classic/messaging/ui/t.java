package zendesk.classic.messaging.ui;

import android.text.Editable;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.z;
import g30.a0;
import java.util.List;
import mz.f;
import zendesk.belvedere.ImageStream;
import zendesk.belvedere.MediaResult;
import zendesk.classic.messaging.BelvedereMediaHolder;
import zendesk.classic.messaging.R$string;
import zendesk.classic.messaging.l;
import zendesk.commonui.TextWatcherAdapter;

public class t {

    /* renamed from: i  reason: collision with root package name */
    public static final int f62856i = R$string.zui_hint_type_message;

    /* renamed from: a  reason: collision with root package name */
    public final AppCompatActivity f62857a;

    /* renamed from: b  reason: collision with root package name */
    public final l f62858b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageStream f62859c;

    /* renamed from: d  reason: collision with root package name */
    public final BelvedereMediaHolder f62860d;

    /* renamed from: e  reason: collision with root package name */
    public final l f62861e;

    /* renamed from: f  reason: collision with root package name */
    public final j f62862f;

    /* renamed from: g  reason: collision with root package name */
    public final a0 f62863g;

    /* renamed from: h  reason: collision with root package name */
    public c f62864h;

    public class a extends TextWatcherAdapter {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            t.this.f62863g.a();
        }
    }

    public class b implements z<MessagingState> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ InputBox f62866b;

        public b(InputBox inputBox) {
            this.f62866b = inputBox;
        }

        /* renamed from: a */
        public void onChanged(MessagingState messagingState) {
            t.this.c(messagingState, this.f62866b);
        }
    }

    public static final class c implements ImageStream.b {

        /* renamed from: a  reason: collision with root package name */
        public final BelvedereMediaHolder f62868a;

        /* renamed from: b  reason: collision with root package name */
        public final InputBox f62869b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageStream f62870c;

        public c(BelvedereMediaHolder belvedereMediaHolder, InputBox inputBox, ImageStream imageStream) {
            this.f62868a = belvedereMediaHolder;
            this.f62869b = inputBox;
            this.f62870c = imageStream;
        }

        public void onDismissed() {
            if (this.f62870c.sh().getInputTrap().hasFocus()) {
                this.f62869b.requestFocus();
            }
        }

        public void onMediaDeselected(List<MediaResult> list) {
            this.f62868a.e(list);
            this.f62869b.setAttachmentsCount(this.f62868a.d());
        }

        public void onMediaSelected(List<MediaResult> list) {
            this.f62868a.a(list);
            this.f62869b.setAttachmentsCount(this.f62868a.d());
        }

        public void onVisible() {
        }
    }

    public t(AppCompatActivity appCompatActivity, l lVar, ImageStream imageStream, BelvedereMediaHolder belvedereMediaHolder, l lVar2, j jVar, a0 a0Var) {
        this.f62857a = appCompatActivity;
        this.f62858b = lVar;
        this.f62859c = imageStream;
        this.f62860d = belvedereMediaHolder;
        this.f62861e = lVar2;
        this.f62862f = jVar;
        this.f62863g = a0Var;
    }

    public void b(InputBox inputBox) {
        inputBox.setInputTextConsumer(this.f62861e);
        inputBox.setInputTextWatcher(new a());
        c cVar = new c(this.f62860d, inputBox, this.f62859c);
        this.f62864h = cVar;
        this.f62859c.qh(cVar);
        this.f62858b.k0().observe(this.f62857a, new b(inputBox));
    }

    public void c(MessagingState messagingState, InputBox inputBox) {
        if (messagingState != null) {
            inputBox.setHint(f.c(messagingState.f62714f) ? messagingState.f62714f : this.f62857a.getString(f62856i));
            inputBox.setEnabled(messagingState.f62711c);
            inputBox.setInputType(Integer.valueOf(messagingState.f62716h));
            g30.b bVar = messagingState.f62715g;
            if (bVar == null || !bVar.b()) {
                inputBox.setAttachmentsIndicatorClickListener((View.OnClickListener) null);
                return;
            }
            inputBox.setAttachmentsIndicatorClickListener(this.f62862f);
            inputBox.setAttachmentsCount(this.f62860d.d());
        }
    }
}
