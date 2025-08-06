package jumio.dui;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.jumio.defaultui.JumioActivity;
import com.jumio.sdk.enums.JumioDataCenter;

public final class c extends AbstractSavedStateViewModelFactory {

    /* renamed from: a  reason: collision with root package name */
    public final String f56387a;

    /* renamed from: b  reason: collision with root package name */
    public final JumioDataCenter f56388b;

    /* renamed from: c  reason: collision with root package name */
    public final int f56389c;

    /* renamed from: d  reason: collision with root package name */
    public final Application f56390d;

    public c(JumioActivity jumioActivity, String str, JumioDataCenter jumioDataCenter, int i11, Application application) {
        super(jumioActivity, (Bundle) null);
        this.f56387a = str;
        this.f56388b = jumioDataCenter;
        this.f56389c = i11;
        this.f56390d = application;
    }

    public final <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        return new b(savedStateHandle, this.f56390d, this.f56387a, this.f56388b, this.f56389c);
    }
}
