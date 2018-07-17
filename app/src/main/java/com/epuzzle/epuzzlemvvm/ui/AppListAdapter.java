package com.epuzzle.epuzzlemvvm.ui;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.epuzzle.epuzzlemvvm.R;
import com.epuzzle.epuzzlemvvm.databinding.OneApplicationItemBinding;
import com.epuzzle.epuzzlemvvm.models.AppModel;
import com.epuzzle.epuzzlemvvm.ui.base.BaseAdapter;

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
