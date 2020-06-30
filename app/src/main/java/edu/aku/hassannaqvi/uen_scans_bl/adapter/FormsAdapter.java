package edu.aku.hassannaqvi.uen_scans_bl.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import edu.aku.hassannaqvi.uen_scans_bl.R;
import edu.aku.hassannaqvi.uen_scans_bl.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_scans_bl.core.DatabaseHelper;


/**
 * Created by hassan.naqvi on 8/1/2016.
 */
public class FormsAdapter extends RecyclerView.Adapter<FormsAdapter.ViewHolder> {
    Context c;
    DatabaseHelper db;
    private List<FormsContract> fc = Collections.emptyList();

    // Provide a suitable constructor (depends on the kind of dataset)
    public FormsAdapter(List<FormsContract> fc, Context c) {
        this.fc = fc;
        this.c = c;
        Log.d("TAG:count", String.valueOf(getItemCount()));
    }

    // Create new views (invoked by the layout manager)
    @Override
    public FormsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.form_list_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        db = new DatabaseHelper(c);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        int childCount = 0;
        childCount = db.getChildByUUID(fc.get(position).get_UID());
        int motherCount = 0;
        motherCount = db.getMotherByUUID(fc.get(position).get_UID());


        String iStatus = "Status  Unknown";
        int iColor = 0;
        switch (fc.get(position).getIstatus()) {
            case "1":
                iStatus = "Complete";
                iColor = Color.GREEN;
                break;

            case "2":
                iStatus = "No Respondent ";
                iColor = Color.RED;

                break;
            case "3":
                iStatus = "Absent ";
                iColor = Color.RED;

                break;
            case "4":
                iStatus = "Refused ";
                iColor = Color.RED;

                break;
            case "5":
                iStatus = "Empty ";
                iColor = Color.RED;

                break;
            case "6":
                iStatus = "Not Found ";
                iColor = Color.RED;

                break;
            case "7":
                iStatus = "No Child ";
                iColor = Color.RED;

                break;
            case "8":
                iStatus = "Terminally Ill ";
                iColor = Color.RED;

                break;
            case "9":
                iStatus = "Already Enrolled";
                iColor = Color.RED;
                break;

            default:
                iStatus = "Open Form";
                iColor = Color.RED;
                break;

        }

        holder.hhno.setText(fc.get(position).getHhno() + " \t\t(" + fc.get(position).getFormDate() + ")");
        holder.cluster.setText(fc.get(position).getClusterCode());
        holder.istatus.setText(iStatus);
        holder.sysdate.setText("  Mother Count: " + motherCount + " \t\t\t Child Count: " + childCount);
        holder.istatus.setTextColor(iColor);


    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return fc.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView rv;
        public TextView sysdate;
        public TextView cluster;
        public TextView hhno;
        public TextView istatus;
        // each data item is just a string in this case

        public ViewHolder(View v) {
            super(v);
//            rv = v.findViewById(R.id.FormsList);
            sysdate = v.findViewById(R.id.sysdate);
            cluster = v.findViewById(R.id.cluster);
            hhno = v.findViewById(R.id.hhno);
            istatus = v.findViewById(R.id.istatus);

        }


    }
}