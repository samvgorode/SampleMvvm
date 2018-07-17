package com.example.mvvm.utils;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import javax.inject.Inject;

public class Navigator {

    private final FragmentManager fragmentManager;
    private static final String APP_BACKSTACK_TAG = "APP_BACKSTACK_TAG";

    @Inject
    Navigator(FragmentActivity fragmentActivity) {
        this.fragmentManager = fragmentActivity.getSupportFragmentManager();
    }

    private void popBackStack() {
        if (fragmentManager != null && fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        }
    }

    private boolean isFragmentTheSame(Fragment current, Fragment newFragment) {
        return current != null && newFragment.getClass().equals(current.getClass());
    }

    private Fragment getCurrentFragment(String tag) {
        return fragmentManager.findFragmentByTag(tag);
    }

    public String getCurrentFragmentTag(@IdRes int container) {
        Fragment fragment = fragmentManager.findFragmentById(container);
        return fragment != null ? fragment.getTag() : "";
    }

    public void removeGragmentByTag(String tag) {
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) fragmentManager.beginTransaction().remove(fragment).commit();
    }

    public final void openFragmentWithTag(@IdRes int containerId, @NonNull Fragment fragment, @NonNull String fragmentTag, Bundle args) {
        replaceFragmentInternal(containerId, fragment, fragmentTag, args);
    }

    public void openFragment(@IdRes int containerId, @NonNull Fragment fragment, Bundle args) {
        replaceFragmentInternal(containerId, fragment, null, args);
    }

    private void replaceFragmentInternal(@IdRes int containerId, Fragment fragment, String fragmentTag, Bundle args) {
        if (fragmentTag != null) {
            if (isFragmentTheSame(getCurrentFragment(fragmentTag), fragment)) {
                return;
            }
        }
        if (args != null) {
            fragment.setArguments(args);
        }
        FragmentTransaction ft = fragmentManager.beginTransaction();
        if (fragmentTag == null) {
            ft.replace(containerId, fragment);
        } else {
            ft.replace(containerId, fragment, fragmentTag);
        }

        ft.addToBackStack(APP_BACKSTACK_TAG).commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
    }
}
