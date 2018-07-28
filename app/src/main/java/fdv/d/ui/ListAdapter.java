package fdv.d.ui;

import java.util.List;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fdv.d.R;
import fdv.d.data.db.Drink;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Drink> list;

    public ListAdapter(List<Drink> list) { this.list = list; };

   @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Drink drink = list.get(position);
        holder.id.setText(drink.getId());
        holder.name.setText(drink.getName());
        holder.thumb.setText(drink.getThumb());
    }
    @Override
    public int getItemCount() {
        if (list == null)
            return 0;
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView name;
        TextView thumb;
        ViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tv_id);
            name = itemView.findViewById(R.id.tv_name);
            thumb = itemView.findViewById(R.id.tv_thumb);
        }
    }
}
