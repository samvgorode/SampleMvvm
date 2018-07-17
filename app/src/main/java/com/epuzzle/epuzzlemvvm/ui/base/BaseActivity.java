package com.epuzzle.epuzzlemvvm.ui.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.epuzzle.epuzzlemvvm.BR;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

@SuppressLint("Registered")
public class BaseActivity<B extends ViewDataBinding, V extends ViewModel> extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject Class<V> viewModelClass;
    @Inject ViewModelProvider.Factory viewModelFactory;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    protected B binding;
    protected V viewModel;


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }

    /**
     * Call this method in child activity's onCreate() below super.onCreate(savedInstanceState);
     * Don't forget to wrap layout xml into <layout></layout>
     */
    protected final void setBindView(@NonNull Activity activity, @LayoutRes int layoutResID) {
        AndroidInjection.inject(this);
        setContentView(layoutResID);
        binding = DataBindingUtil.setContentView(activity, layoutResID);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass);
        binding.setVariable(BR.vm, viewModel);
    }

    public void showToast(@StringRes int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_LONG).show();
    }
}