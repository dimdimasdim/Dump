package com.android.beginner.dump.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by root on 30/01/17.
 */

public class DumpData {

    private static final String[] title ={
            "Nothingness cannot be defined",
            "Time is like a river made up of the events which happen, and a violent stream; " +
                    "for as soon as a thing has been seen, it is carried away, and another comes" +
                    " in its place, and this will be carried away too,",
            "But when I know that the glass is already broken, every minute with it is precious.",
            "For me, it is far better to grasp the Universe as it really is than to persist in" +
                    " delusion, however satisfying and reassuring.",
            "The seeker after the truth is not one who studies the writings of the ancients and," +
                    " following his natural disposition, puts his trust in them, but rather the" +
                    " one who suspects his faith in them and questions what he gathers from them," +
                    " the one who submits to argument and demonstration, and not to the " +
                    "sayings of a human being whose nature is fraught with all kinds " +
                    "of imperfection and deficiency.",
            "You must take personal responsibility. You cannot change the circumstances, the" +
                    " seasons, or the wind, but you can change yourself. That is something you" +
                    " have charge of."};

    private static final int icon = android.R.drawable.ic_menu_add;

    private static final String[] subTitles={"Anonnymous","Anonnymous","Anonnymous","Anonnymous","Anonnymous","Anonnymous","Anonnymous"};


    public static List<ListItem> getListData(){
        List<ListItem> data = new ArrayList<>();

        //ulangi proses sebanyak 4 kali, sehingga kita punya data yang cukup untuk di scroll
        //recyclerview

        for (int x=0; x<4; x++){
            //buat listitem dari dummy data yang ada, kemudian tampilkan di list

            for (int i = 0; i <title.length; i++){
                ListItem item = new ListItem();
                //gunakan setter dan getter yang ada di class list item untuk menampilkan data
                item.setTitle(title[i]);
                item.setSubTitle(subTitles[i]);
                data.add(item);
            }
        }
        return data;
    }

    public static ListItem getRandomListItem(){
        int rand = new Random().nextInt(2);

        ListItem item = new ListItem();

        item.setTitle(title[rand]);
        item.setSubTitle(subTitles[rand]);

        return item;
    }
}
