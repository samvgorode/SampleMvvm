package com.epuzzle.epuzzlemvvm.ui.base;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epuzzle.epuzzlemvvm.BR;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class BaseFragment<B extends ViewDataBinding, V extends ViewModel> extends Fragment {

    @Inject
    Class<V> viewModelClass;
    @Inject ViewModelProvider.Factory viewModelFactory;

    protected B binding;
    protected V viewModel;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass);
        binding.setVariable(BR.vm, viewModel);
    }

    /**
     * Return this method in child fragment's onCreateView() as root View
     * Don't forget to wrap layout xml into <layout></layout>
     */
    protected final View setBindView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @LayoutRes int layoutResID) {
        binding = DataBindingUtil.inflate(inflater, layoutResID, container, false);
        return binding.getRoot();
    }

    @BindingAdapter({"font"})
    public static void setFont(TextView textView, String fontName) {
        textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), "fonts/" + fontName));
    }


}