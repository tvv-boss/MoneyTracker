package com.loftschool.android.moneytracker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 16.03.2018.
 */
class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.RecordViewHolder> {
    private static final String TAG = "ItemListAdapter";
    List<Item> data = new ArrayList<>();

    public void setData(List<Item> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addItem(Item item) {
        data.add(0, item);
        notifyItemInserted(0);
    }

    @Override
    public ItemListAdapter.RecordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ItemListAdapter.RecordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemListAdapter.RecordViewHolder holder, int position) {
        Item item = data.get(position);
        holder.applyData(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

//    public int getPosition(){
//        return position;
//    }

//    private void createData() {
//        Random random = new Random();
//        data.add(new Record("Молоко", 35));
//        data.add(new Record("Жизнь", 1));
//        data.add(new Record("Курсы", 50));
//        data.add(new Record("Хлеб", 26));
//        data.add(new Record("Тот самый ужин который я оплатил за всех потому что платил картой", 600000));
//        data.add(new Record("", 0));
//        data.add(new Record("Тот самый ужин", 604));
//        data.add(new Record("ракета Falcon Heavy", 1));
//        data.add(new Record("Лего Тысячелетний сокол", 100000000));
//        data.add(new Record("Монитор", 100));
//        data.add(new Record("MacBook Pro", 100));
//        data.add(new Record("Шоколадка", 100));
//        data.add(new Record("Шкаф", 100));
//        data.add(new Record("Молоко", 35));
//        data.add(new Record("Жизнь", 1));
//        data.add(new Record("Курсы", 50));
////        for (int i = 0; i < 15; i++) {
////            data.add(new Record("Продукт №" + i, random.nextInt(1000)));
//////            data.add(new Record("Продукт №" + i, (int)  (Math.random() * 1000)));
////        }
//    }

    static class RecordViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView price;

        public RecordViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }

        public void applyData(Item item) {
            title.setText(item.name);
            price.setText(item.price);
        }
    }
}
