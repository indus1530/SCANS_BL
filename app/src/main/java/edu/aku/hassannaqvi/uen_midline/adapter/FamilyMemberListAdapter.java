package edu.aku.hassannaqvi.uen_midline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_midline.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ItemMemListBinding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;

public class FamilyMemberListAdapter extends RecyclerView.Adapter<FamilyMemberListAdapter.ViewHolder> {


    private OnItemClicked itemClicked;
    private Context mContext;
    private List<FamilyMembersContract> mList;
    private DatabaseHelper db;

    public FamilyMemberListAdapter(Context mContext, List<FamilyMembersContract> mList) {
        this.mContext = mContext;
        this.mList = mList;
        db = new DatabaseHelper(mContext);

    }

    public void setItemClicked(OnItemClicked itemClicked) {
        this.itemClicked = itemClicked;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        ItemMemListBinding bi = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_mem_list, viewGroup, false);
        return new ViewHolder(bi);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {

        holder.bi.name.setText(mList.get(i).getName());
        holder.bi.realHead.setText(MainApp.relationHHLst[Integer.valueOf(mList.get(i).getRelHH()) - 1]);
        holder.bi.dob.setText("Age: " + mList.get(i).getAge() + " Year(s)");
        holder.bi.index.setText(String.format("%02d", Integer.valueOf(mList.get(i).getSerialno())));
        holder.bi.genderImage.setImageResource(Util.getMemberIcon(Integer.valueOf(mList.get(i).getGender()), mList.get(i).getAge()));
        holder.bi.motherName.setText(mList.get(i).getMother_name());

        ItemMemListBinding viewHolder = holder.bi;

        holder.bi.parentLayout.setOnClickListener(v -> itemClicked.onItemClick(mList.get(i), i, viewHolder));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setMList(List<FamilyMembersContract> members) {
        mList = members;
        notifyDataSetChanged();
    }

    public interface OnItemClicked {
        void onItemClick(FamilyMembersContract item, int position, ItemMemListBinding viewHolder);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ItemMemListBinding bi;

        ViewHolder(@NonNull ItemMemListBinding itemView) {
            super(itemView.getRoot());
            bi = itemView;
        }
    }
}
