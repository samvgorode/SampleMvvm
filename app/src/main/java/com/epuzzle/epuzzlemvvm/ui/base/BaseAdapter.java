package com.epuzzle.epuzzlemvvm.ui.base;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

public abstract class BaseAdapter<T, V extends ViewDataBinding>
        extends RecyclerView.Adapter<BaseViewHolder<V>> {

    @Nullable
    protected List<T> items;

    @Override
    public final BaseViewHolder<V> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        V binding = createBinding(parent);
        return new BaseViewHolder<>(binding);
    }

    protected abstract V createBinding(ViewGroup parent);

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<V> holder, int position) {
        //noinspection ConstantConditions
        bind(holder.binding, items.get(position));
        holder.binding.executePendingBindings();
    }

    public void setItems(@Nullable List<T> update) {
        items = update;
        notifyDataSetChanged();
    }


    protected abstract void bind(V binding, T item);

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public List<T> getItems() {
        return items != null ? items : Collections.emptyList();
    }

    public T getItem(int pos) {
        return items.get(pos);
    }
}
