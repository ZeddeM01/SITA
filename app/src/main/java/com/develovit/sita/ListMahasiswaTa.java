package com.develovit.sita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import com.develovit.sita.Adapter.MhsCardAdapter;
import com.develovit.sita.Models.ListMhsTa;

public class ListMahasiswaTa extends AppCompatActivity implements MhsCardAdapter.listMhsOnClickListener{

    private RecyclerView rview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa_ta);

        rview = findViewById(R.id.rView);

        MhsCardAdapter mhsCardAdapter = new MhsCardAdapter(getListMhstTA());
        mhsCardAdapter.setListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rview.setLayoutManager(layoutManager);
        rview.setAdapter(mhsCardAdapter);
    }

    public ArrayList<ListMhsTa> getListMhstTA() {
        ArrayList<ListMhsTa> listMhsTA = new ArrayList<>();
        listMhsTA.add(new ListMhsTa(
                "Raidha Qatrunnada",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Muhammad Zaim Milzam",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Raditya Romero",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Thomas Akram",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Raidha Qatrunnada",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Muhammad Zaim Milzam",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Raditya Romero",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Thomas Akram",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Raidha Qatrunnada",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Muhammad Zaim Milzam",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Raditya Romero",
                "SPK....",
                "Ricky Akbar"
        ));
        listMhsTA.add(new ListMhsTa(
                "Thomas Akram",
                "SPK....",
                "Ricky Akbar"
        ));
        return listMhsTA;
    }

    @Override
    public void listMhsClick(ArrayList<ListMhsTa> listAgenda) {
        Intent logbook = new Intent(this, ListLogbook.class);
        //logbook.putExtra("LIST LOGBOOK",listAgenda.getNamaMhs());
        startActivity(logbook);
    }

}
