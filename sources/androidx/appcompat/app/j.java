package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.ActionBar;

public class j implements AdapterView.OnItemSelectedListener {

    /* renamed from: b  reason: collision with root package name */
    public final ActionBar.b f3934b;

    public j(ActionBar.b bVar) {
        this.f3934b = bVar;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i11, long j11) {
        ActionBar.b bVar = this.f3934b;
        if (bVar != null) {
            bVar.a(i11, j11);
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
