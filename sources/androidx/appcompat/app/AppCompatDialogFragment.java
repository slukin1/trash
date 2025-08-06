package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

public class AppCompatDialogFragment extends DialogFragment {
    public AppCompatDialogFragment() {
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new e(getContext(), getTheme());
    }

    public void setupDialog(Dialog dialog, int i11) {
        if (dialog instanceof e) {
            e eVar = (e) dialog;
            if (!(i11 == 1 || i11 == 2)) {
                if (i11 == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            eVar.supportRequestWindowFeature(1);
            return;
        }
        super.setupDialog(dialog, i11);
    }

    public AppCompatDialogFragment(int i11) {
        super(i11);
    }
}
