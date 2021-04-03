package com.example.gotoappsputri;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.nio.channels.ScatteringByteChannel;

public class hospital extends ListActivity {
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] Listhospital = new String[]{"Rumah Sakit Awal Bross", "Rumah Sakit Umum", "Rumah Sakit Jiwa Tampan","Rumah Sakit Prima"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Listhospital));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }

    private void tampilkanpilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Rumah Sakit Awal Bross"))
            {
                a = new Intent(this,RSAwalbros.class);
                startActivity(a);
            }else if (pilihan.equals("Rumah Sakit Umum"))
            {
                a = new Intent(this,RSUmum.class);
                startActivity(a);
            }else if (pilihan.equals("Rumah Sakit Jiwa Tampan"))
            {
                a = new Intent(this,RSJiwatampan.class);
                startActivity(a);
            }else if (pilihan.equals("Rumah Sakit Prima"))
            {
                a = new Intent(this,RSPrima.class);
                startActivity(a);
            }
            startActivity(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}