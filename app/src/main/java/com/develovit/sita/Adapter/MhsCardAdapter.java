package com.develovit.sita.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.develovit.sita.R;
import com.develovit.sita.Models.ListMhsTa;

public class MhsCardAdapter extends RecyclerView.Adapter<MhsCardAdapter.CardViewHolder> {

    ArrayList<ListMhsTa> listAgenda = new ArrayList<>();

    //itemAgendaClickListener listener;
    listMhsOnClickListener listener;

    public MhsCardAdapter(ArrayList<ListMhsTa> listAgenda) {
        this.listAgenda = listAgenda;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_mhs_ta_class, parent, false);
        return new CardViewHolder(view);
    }

    public void setListener(listMhsOnClickListener listener) {
        this.listener = listener;
    }

    public MhsCardAdapter(ArrayList<ListMhsTa> listAgenda, listMhsOnClickListener listener) {
        this.listAgenda = listAgenda;
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull MhsCardAdapter.CardViewHolder holder, int position) {
        ListMhsTa agenda = listAgenda.get(position);
        holder.namaMhs.setText(agenda.getNamaMhs());
        holder.judulTa.setText(agenda.getJudulTa());
        holder.pembimbing.setText(agenda.getPembimbing());
    }

    public interface listMhsOnClickListener{
        void listMhsClick(ArrayList<ListMhsTa> listAgenda);

    }

    @Override
    public int getItemCount() {
        return listAgenda.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView namaMhs, judulTa, pembimbing;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            namaMhs = itemView.findViewById(R.id.namaMhs);
            judulTa = itemView.findViewById(R.id.judulTa);
            pembimbing = itemView.findViewById(R.id.Pembimbing);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ListMhsTa ListAgenda = listAgenda.get(getAdapterPosition());
            listener.listMhsClick(listAgenda);
        }
    }

}
