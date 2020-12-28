package com.muath.tawseelaapp.yasser.ui.ui.adapter.adabter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.muath.tawseelaapp.R;
import com.muath.tawseelaapp.yasser.model.Message;
import com.muath.tawseelaapp.yasser.repository.local.Session;

import java.util.ArrayList;



public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Message> messages;

    public ChatAdapter(Context context, ArrayList<Message> messages) {
        this.context = context;
        this.messages = messages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(viewType,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Message message = messages.get(position);
        holder.tvMessage.setText(message.getMessage());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvMessage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.tv_msg);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(messages.get(position).getSender_id()== Session.getInstance(context).getLocalSave().userProfile().getId()){
            return R.layout.res_msg_item;
        }else {
            return R.layout.des_msg_item;
        }
    }
}
