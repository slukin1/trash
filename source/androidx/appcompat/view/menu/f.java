package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R$layout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.i;

public class f implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, i.a {

    /* renamed from: b  reason: collision with root package name */
    public e f4137b;

    /* renamed from: c  reason: collision with root package name */
    public AlertDialog f4138c;

    /* renamed from: d  reason: collision with root package name */
    public c f4139d;

    /* renamed from: e  reason: collision with root package name */
    public i.a f4140e;

    public f(e eVar) {
        this.f4137b = eVar;
    }

    public boolean a(e eVar) {
        i.a aVar = this.f4140e;
        if (aVar != null) {
            return aVar.a(eVar);
        }
        return false;
    }

    public void b() {
        AlertDialog alertDialog = this.f4138c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void c(IBinder iBinder) {
        e eVar = this.f4137b;
        AlertDialog.a aVar = new AlertDialog.a(eVar.getContext());
        c cVar = new c(aVar.getContext(), R$layout.abc_list_menu_item_layout);
        this.f4139d = cVar;
        cVar.setCallback(this);
        this.f4137b.addMenuPresenter(this.f4139d);
        aVar.setAdapter(this.f4139d.a(), this);
        View headerView = eVar.getHeaderView();
        if (headerView != null) {
            aVar.setCustomTitle(headerView);
        } else {
            aVar.setIcon(eVar.getHeaderIcon()).setTitle(eVar.getHeaderTitle());
        }
        aVar.setOnKeyListener(this);
        AlertDialog create = aVar.create();
        this.f4138c = create;
        create.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f4138c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f4138c.show();
    }

    public void onClick(DialogInterface dialogInterface, int i11) {
        this.f4137b.performItemAction((g) this.f4139d.a().getItem(i11), 0);
    }

    public void onCloseMenu(e eVar, boolean z11) {
        if (z11 || eVar == this.f4137b) {
            b();
        }
        i.a aVar = this.f4140e;
        if (aVar != null) {
            aVar.onCloseMenu(eVar, z11);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f4139d.onCloseMenu(this.f4137b, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i11 == 82 || i11 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f4138c.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f4138c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f4137b.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f4137b.performShortcut(i11, keyEvent, 0);
    }
}
