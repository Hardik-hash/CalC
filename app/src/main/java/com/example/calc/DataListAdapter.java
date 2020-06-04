package com.example.calc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calc.database.DataEntry;

import java.util.List;

public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.DataViewHolder> {

           private final LayoutInflater layoutInflater;
           private Context mContext;

           private List<DataEntry> mDataEntries;

         public DataListAdapter(Context context)
         {
              mContext=context;
              layoutInflater = LayoutInflater.from(mContext);
            //  mcontext =context;
         }
    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.list_item,parent,false);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DataListAdapter.DataViewHolder holder, int position) {
             DataEntry dataEntry = mDataEntries.get(position);
             String data=dataEntry.getData();

             holder.text.setText(data);

    }

    @Override
    public int getItemCount() {
             if(mDataEntries == null) {
                 return 0;
             }
             return mDataEntries.size();
    }

    public void setData(List<DataEntry> dataEntries)
    {
        mDataEntries = dataEntries;
        notifyDataSetChanged();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder{

        TextView text;

        public DataViewHolder(View itemView) {
            super(itemView);

            text=itemView.findViewById(R.id.Dataval);

        }
    }
}
