package id.ac.ugm.blog.tejo_suharyono.listjson.model.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.ac.ugm.blog.tejo_suharyono.listjson.R;
import id.ac.ugm.blog.tejo_suharyono.listjson.model.data.ItemDataModel;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.viewItemRow>  {


    public static String TAG = ItemAdapter.class.getSimpleName();

    private List<ItemDataModel> mItemDataModels;

    public ItemAdapter(List<ItemDataModel> itemDataModels) {
        mItemDataModels = itemDataModels;
    }


    public void addItemAdapter(ItemDataModel itemdata) {
        mItemDataModels.add(itemdata);
        notifyDataSetChanged();
    }


    @Override
    public viewItemRow onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);

        return new viewItemRow(row);
    }

    @Override
    public void onBindViewHolder(viewItemRow view, int position) {

        ItemDataModel currentItemDataModel = mItemDataModels.get(position);

        view.message.setText(currentItemDataModel.message);
        view.sender.setText(currentItemDataModel.sender);
        view.is_from_me.setText(currentItemDataModel.is_from_me);
        view.time.setText(currentItemDataModel.time);
    }

    public class viewItemRow extends RecyclerView.ViewHolder {

        public TextView message, sender, is_from_me, time;

        public viewItemRow(View itemView) {
            super(itemView);
            message     = (TextView) itemView.findViewById(R.id.message);
            sender      = (TextView) itemView.findViewById(R.id.sender);
            is_from_me  = (TextView) itemView.findViewById(R.id.is_from_me);
            time        = (TextView) itemView.findViewById(R.id.time);
        }
    }

    @Override
    public int getItemCount() {
        return mItemDataModels.size();
    }

}
