package com.android.beginner.dump.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 30/01/17.
 */

public class DumpData {

    private static final String[] title ={"Om telolet Om", "Mantap Jiwa", "Apa aja deh "};
    private static final int[] icon = {android.R.drawable.ic_lock_lock, android.R.drawable.ic_menu_view, android.R.drawable.ic_dialog_info};


    public static List<ListItem> getListData(){
        List<ListItem> data = new ArrayList<>();

        //ulangi proses sebanyak 4 kali, sehingga kita punya data yang cukup untuk di scroll
        //recyclerview

        for (int x=0; x<4; x++){
            //buat listitem dari dummy data yang ada, kemudian tampilkan di list

            for (int i = 0; i <title.length && i < icon.length; i++){
                ListItem item = new ListItem();
                //gunakan setter dan getter yang ada di class list item untuk menampilkan data

                item.setImageResId(icon[i]);
                item.setTitle(title[i]);
                data.add(item);
            }
        }
        return data;
    }
}
