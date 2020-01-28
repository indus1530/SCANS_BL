package edu.aku.hassannaqvi.uen_midline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.aku.hassannaqvi.uen_midline.R;
import edu.aku.hassannaqvi.uen_midline.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_midline.core.MainApp;
import edu.aku.hassannaqvi.uen_midline.databinding.ItemMemListBinding;
import edu.aku.hassannaqvi.uen_midline.utils.Util;
import edu.aku.hassannaqvi.uen_midline.viewmodel.MainVModel;

public class FamilyMemberListAdapter extends RecyclerView.Adapter<FamilyMemberListAdapter.ViewHolder> {

    private OnItemClicked itemClicked;
    private Context mContext;
    private List<FamilyMembersContract> mList;
    private MainVModel vModel;
    RecyclerView recyclerView;

    public FamilyMemberListAdapter(Context mContext, List<FamilyMembersContract> mList, MainVModel vModel) {
        this.mContext = mContext;
        this.mList = mList;
        this.vModel = vModel;
    }

    public void setItemClicked(OnItemClicked itemClicked) {
        this.itemClicked = itemClicked;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        ItemMemListBinding bi = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_mem_list, viewGroup, false);
        recyclerView = (RecyclerView) viewGroup;
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
        holder.bi.parentLayout.setOnClickListener(v -> itemClicked.onItemClick(mList.get(i), i, recyclerView.getChildAt(holder.getAdapterPosition())));

        vModel.setHolderValues(Integer.valueOf(mList.get(i).getSerialno()), holder.getAdapterPosition());
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
        void onItemClick(FamilyMembersContract item, int position, View viewHolder);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ItemMemListBinding bi;

        ViewHolder(@NonNull ItemMemListBinding itemView) {
            super(itemView.getRoot());
            bi = itemView;
        }
    }
}
