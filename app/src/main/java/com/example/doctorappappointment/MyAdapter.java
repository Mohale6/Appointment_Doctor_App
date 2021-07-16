package com.example.doctorappappointment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Patient> list;
    Context context;



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);

    }
    public MyAdapter(Context context, ArrayList<Patient> list){

        this.list = list;
        this.context = context;
    }


    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {

        Patient patient = list.get(position);
        holder.name.setText(patient.getEditTextTextPersonName());
        holder.surname.setText(patient.getEditTextTextPersonName2());
        holder.agee.setText(patient.getEditTextTextPersonName3());
        holder.gend.setText(patient.getEditTextTextPersonName4());
        holder.datee.setText(patient.getEditTextDate());
        holder.emaily.setText(patient.getEditTextTextEmailAddress());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, surname, agee, gend, datee, emaily;


        public MyViewHolder( View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.firstName);
            surname = itemView.findViewById(R.id.lastName);
            agee = itemView.findViewById(R.id.Age);
            gend = itemView.findViewById(R.id.Gender);
            datee = itemView.findViewById(R.id.Date);
            emaily = itemView.findViewById(R.id.Email);
        }
    }

}