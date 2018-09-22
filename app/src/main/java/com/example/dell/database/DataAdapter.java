package com.example.dell.database;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private List<NoteData> noteDataList;
    private Context mcontext;
    NoteData noteData;

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
    final  NoteData noteData = noteDataList.get(position);
    holder.titletime.setText(noteData.getDatatime());
    holder.titlebody.setText(noteData.getDatabody());
    holder.titlebody.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mcontext,edit.class);
            intent.putExtra("position",position);
            mcontext.startActivity(intent);
        }
    });
    holder.delete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            noteDataList.remove(position);
            notifyDataSetChanged();
        }
    });
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
    TextView titlebody;
    TextView titletime;
    Button delete;

        public ViewHolder(View itemView) {
            super(itemView);
            titlebody = (TextView)itemView.findViewById(R.id.titlebody);
            titletime = (TextView)itemView.findViewById(R.id.titletime);
            delete = (Button)itemView.findViewById(R.id.delete);
        }
    }

    @Override
    public int getItemCount() {
        return noteDataList.size();
    }
    public DataAdapter(List<NoteData> noteList, Context context)
    {
        mcontext = context;
        noteDataList = noteList;
    }
}
