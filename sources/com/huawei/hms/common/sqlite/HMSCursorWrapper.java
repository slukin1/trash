package com.huawei.hms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

public class HMSCursorWrapper extends CursorWrapper implements CrossProcessCursor {

    /* renamed from: a  reason: collision with root package name */
    private AbstractWindowedCursor f37958a;

    public HMSCursorWrapper(Cursor cursor) {
        super(cursor);
        if (cursor == null) {
            throw new IllegalArgumentException("cursor cannot be null");
        } else if (cursor instanceof CursorWrapper) {
            Cursor wrappedCursor = ((CursorWrapper) cursor).getWrappedCursor();
            if (wrappedCursor == null) {
                throw new IllegalArgumentException("getWrappedCursor cannot be null");
            } else if (wrappedCursor instanceof AbstractWindowedCursor) {
                this.f37958a = (AbstractWindowedCursor) wrappedCursor;
            } else {
                throw new IllegalArgumentException("getWrappedCursor:" + wrappedCursor + " is not a subclass for CursorWrapper");
            }
        } else {
            throw new IllegalArgumentException("cursor:" + cursor + " is not a subclass for CursorWrapper");
        }
    }

    public void fillWindow(int i11, CursorWindow cursorWindow) {
        this.f37958a.fillWindow(i11, cursorWindow);
    }

    public CursorWindow getWindow() {
        return this.f37958a.getWindow();
    }

    public Cursor getWrappedCursor() {
        return this.f37958a;
    }

    public boolean onMove(int i11, int i12) {
        return this.f37958a.onMove(i11, i12);
    }

    public void setWindow(CursorWindow cursorWindow) {
        this.f37958a.setWindow(cursorWindow);
    }
}
