package com.example.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.friend.MemberAdapter.*;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {

    private ArrayList<Person> member_list;
    private Context context;
    private View.OnClickListener onClickListener;

    public MemberAdapter(Context context, ArrayList<Person> member_list, View.OnClickListener onClickListener)
    {
        this.context = context;
        this.member_list = member_list;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public MemberAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_list, parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MemberAdapter.ViewHolder holder, int position) {
        Person name = member_list.get(position);

        holder.textView.setText(name.getPerson_name());
        holder.textView.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return member_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;

        public ViewHolder(View nameView){
            super(nameView);

            textView = nameView.findViewById(R.id.person_name);
        }
    }
}
