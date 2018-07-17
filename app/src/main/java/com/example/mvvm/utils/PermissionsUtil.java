package com.example.mvvm.utils;

import android.Manifest;
import android.app.Activity;

import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.disposables.Disposable;

@Singleton
public class PermissionsUtil {

    private RxPermissions rxPermissions;
    private Disposable disposableRx;
    private Runnable enabledAction;
    private Runnable disabledAction;

    @Inject
    public PermissionsUtil() {
    }

    public PermissionsUtil setActivity(Activity activity) {
        rxPermissions = new RxPermissions(activity);
        return this;
    }

    public PermissionsUtil setEnabledAction(Runnable action) {
        enabledAction = action;
        return this;
    }

    public PermissionsUtil setDisabledAction(Runnable action) {
        disabledAction = action;
        return this;
    }

    public void checkLocationEnabled() {
        if (rxPermissions != null)
            disposableRx = rxPermissions
                    .request(Manifest.permission.ACCESS_COARSE_LOCATION)
                    .subscribe(granted -> {
                        if (enabledAction != null && disabledAction != null) {
                            if (granted) enabledAction.run();
                            else disabledAction.run();
                        }
                    });
    }

    public void disposeRx() {
        if (disposableRx != null && !disposableRx.isDisposed()) disposableRx.dispose();
    }
}
