package com.example.smartpantrymanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PantryAdapter extends RecyclerView.Adapter<PantryAdapter.ViewHolder> {

    private List<PantryItem> pantryItems;
    private PantryItemDao pantryItemDao;

    public PantryAdapter(List<PantryItem> pantryItems, PantryItemDao pantryItemDao) {
        this.pantryItems = pantryItems;
        this.pantryItemDao = pantryItemDao;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pantry_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PantryItem item = pantryItems.get(position);

        holder.txtName.setText(item.getName());
        holder.txtQuantity.setText(item.getQuantity() + " " + item.getUnit());
        holder.txtExpiry.setText("Expiry: " + item.getExpiryDate());

        holder.btnUpdate.setOnClickListener(v -> {
            item.setQuantity(item.getQuantity() + 1); // Example update
            pantryItemDao.updateItem(item);
            notifyItemChanged(position);
            Toast.makeText(v.getContext(), "Item updated!", Toast.LENGTH_SHORT).show();
        });

        holder.btnDelete.setOnClickListener(v -> {
            pantryItemDao.deleteItem(item);
            pantryItems.remove(position);
            notifyItemRemoved(position);
            Toast.makeText(v.getContext(), "Item deleted!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return pantryItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtQuantity, txtExpiry;
        Button btnUpdate, btnDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtQuantity = itemView.findViewById(R.id.txtQuantity);
            txtExpiry = itemView.findViewById(R.id.txtExpiry);
            btnUpdate = itemView.findViewById(R.id.btnUpdate);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}

