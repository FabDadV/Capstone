package fdv.d.ui;

import java.util.List;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import fdv.d.R;
import fdv.d.data.db.Drink;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private List<Drink> list;
    private Context context;
    // An on-click handler that we've defined to make it easy for an Activity to interface with our RecyclerView
    private ItemClickListener itemClickListener;
    // The interface that receives onClick messages.
    public interface ItemClickListener {void onItemClickListener(String itemId, String itemPath);}
    /* Creates a RecyclerViewAdapter.
     * @param itemClickListener The on-click handler for this adapter. This single handler is called when an item is clicked.
     */
    public ListAdapter(ItemClickListener listener, List<Drink> list) {
//    public ListAdapter(Context context, List<Drink> list) {
//        this.context = context;
        this.itemClickListener = listener;
        this.list = list;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
/*
        TextView name;
        ImageView thumb;
*/
        @BindView(R.id.tv_name) TextView name;
        @BindView(R.id.imageView) ImageView thumb;

        public ListViewHolder(View itemView) {
            super(itemView);
/*
            name = itemView.findViewById(R.id.tv_name);
            thumb = itemView.findViewById(R.id.imageView);
*/
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }
        // This gets called by the child views during a click. @param v - the View that was clicked
        @Override
        public void onClick(View view) {
            String itemId = list.get(getAdapterPosition()).getIdDrink();
            String itemPath = list.get(getAdapterPosition()).getStrDrinkThumb();
            itemClickListener.onItemClickListener(itemId, itemPath);
        }
    }
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Drink drink = list.get(position);
        holder.name.setText(drink.getStrDrink());
        Picasso.get()
                .load(drink.getStrDrinkThumb())
                .error(R.drawable.err_drink)
                .into(holder.thumb);
    }
    @Override
    public int getItemCount() {
        if (list == null) return 0;
        return list.size();
    }

    public List<Drink> getDrinks() {return list;}

    public void setDrinks(List<Drink> drinks) {
        list = drinks;
        notifyDataSetChanged();
    }
}
