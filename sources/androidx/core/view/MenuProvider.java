package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public interface MenuProvider {
    void a(Menu menu, MenuInflater menuInflater);

    void b(Menu menu);

    void c(Menu menu);

    boolean d(MenuItem menuItem);
}
