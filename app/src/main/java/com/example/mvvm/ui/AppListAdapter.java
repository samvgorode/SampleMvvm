package com.example.mvvm.ui;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mvvm.R;
import com.example.mvvm.databinding.OneApplicationItemBinding;
import com.example.mvvm.models.AppModel;
import com.example.mvvm.ui.base.BaseAdapter;

public class AppListAdapter extends BaseAdapter<AppModel, OneApplicationItemBinding> {

    @Override
    protected OneApplicationItemBinding createBinding(ViewGroup parent) {
        return DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.one_application_item, parent, false);
    }

    @Override
    protected void bind(OneApplicationItemBinding binding, AppModel item) {
        binding.applicationIcon.setImageDrawable(item.getIcon());
        binding.itemTitle.setText(item.getName());
    }
}
