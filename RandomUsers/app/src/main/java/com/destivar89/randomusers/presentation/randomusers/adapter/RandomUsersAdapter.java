package com.destivar89.randomusers.presentation.randomusers.adapter;


import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.destivar89.randomusers.BR;
import com.destivar89.randomusers.R;
import com.destivar89.randomusers.presentation.randomusers.model.RandomUserItemModel;
import com.destivar89.randomusers.presentation.randomusers.viewmodel.RandomUsersItemViewmodel;

import java.util.ArrayList;
import java.util.List;

public class RandomUsersAdapter extends RecyclerView.Adapter<RandomUsersAdapter.RandomUsersViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(RandomUserItemModel model);
    }

    private Activity activityContext;
    private List<RandomUserItemModel> items = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public RandomUsersAdapter(Activity activityContext) {
        this.activityContext = activityContext;
    }

    public void addItems(List<RandomUserItemModel> items) {
        this.items.addAll(items);
    }

    public void removeItem(int adapterPosition) {
        items.remove(adapterPosition);
    }

    public RandomUserItemModel getItem(int adapterPosition) {
        return items.get(adapterPosition);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RandomUsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_randomusers, parent, false);
        RandomUsersViewHolder holder = new RandomUsersViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RandomUsersViewHolder holder, int position) {

        RandomUserItemModel model = items.get(position);
        holder.getBinding().setVariable(BR.viewmodel, new RandomUsersItemViewmodel(model));
        holder.getBinding().executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class RandomUsersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ViewDataBinding binding;

        public RandomUsersViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            itemView.setOnClickListener(this);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(items.get(getAdapterPosition()));
        }
    }
}
