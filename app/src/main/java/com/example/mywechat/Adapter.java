package com.example.mywechat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class  Adapter extends RecyclerView.Adapter<Adapter.myviewholder> {

    private List<String>list;
    private Context context;
    private View inflater;


    public Adapter(List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override



    public Adapter.myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //压缩的inflater
        inflater = LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
        myviewholder myviewholder = new myviewholder(inflater);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.myviewholder myviewholder, int j) {

        myviewholder.textView.setText(list.get(j));


    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView textView;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView5);
        }
    }
}
