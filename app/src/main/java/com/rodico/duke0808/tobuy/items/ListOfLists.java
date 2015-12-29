package com.rodico.duke0808.tobuy.items;

import com.rodico.duke0808.tobuy.R;

import java.util.ArrayList;

/**
 * Created by duke0808 on 26.11.15.
 */
public class ListOfLists extends ArrayList<ItemList> {
    private static ListOfLists ourInstance = new ListOfLists();

    public static ListOfLists getInstance() {
        return ourInstance;
    }

    public static void setListOfLists(ListOfLists ourInstance) {
        ListOfLists.ourInstance = ourInstance;
        String s = String.valueOf(R.string.app_name);
    }

    private ListOfLists() {
    }
}
