package com.example.hoho;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<category> categories;
    private OnCategoryClickListener onCategoryClickListener;

    public CategoryAdapter(List<category> categories, OnCategoryClickListener listener) {
        this.categories = categories;
        this.onCategoryClickListener = listener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        category category = categories.get(position);
        holder.catId.setText(String.valueOf(category.getId()));
        holder.catName.setText(category.getCatname());
        holder.catDesc.setText(category.getSdesc());

        holder.itemView.setOnClickListener(v -> {
            if (onCategoryClickListener != null) {
                onCategoryClickListener.onCategoryClick(category);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public interface OnCategoryClickListener {
        void onCategoryClick(category category);
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView catId;
        TextView catName;
        TextView catDesc;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            catId = itemView.findViewById(R.id.catId);
            catName = itemView.findViewById(R.id.catName);
            catDesc = itemView.findViewById(R.id.catDesc);
        }
    }
}
