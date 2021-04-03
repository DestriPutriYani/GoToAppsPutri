package com.example.gotoappsputri;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSUmum extends ListActivity {
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] listAct = new String[]{"Call Center", "SMS Center", "Driving Direction", "Website", "Info Google", "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listAct));
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
            if (pilihan.equals("Call Center")) {
                String nomortel = "tel: 0852-6357-7752";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(nomortel));
            } else if (pilihan.equals("Rumah Sakit Umum")) {
                a = new Intent(this, RSUmum.class);
                startActivity(a);
            } else if (pilihan.equals("SMS Center")) {
                String smsText = "Destri Putri Yani/P";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:085363577752"));
                a.putExtra("sms_body", smsText);
            } else if (pilihan.equals("Driving Direction")) {
                String lokasihospital = "https://goo.gl/maps/7YF4e7xhhKBp3Wvs8";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(lokasihospital));
            } else if (pilihan.equals("Website")) {
                String website = "http://rsudarifinachmad.riau.go.id/";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
            } else if (pilihan.equals("Info Google")) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY, "Rumah Sakit Umum");
            }
            startActivity(a);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
