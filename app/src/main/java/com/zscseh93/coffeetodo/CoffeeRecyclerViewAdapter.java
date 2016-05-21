package com.zscseh93.coffeetodo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zscseh93.coffeetodo.coffee.Coffee;

import java.util.List;

public class CoffeeRecyclerViewAdapter extends RecyclerView.Adapter<CoffeeRecyclerViewAdapter.ViewHolder> {

    private List<Coffee> mCoffees;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mCoffees.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView mNameView;
        public Coffee mCoffee;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.tv_coffee_name);
        }
    }
}
