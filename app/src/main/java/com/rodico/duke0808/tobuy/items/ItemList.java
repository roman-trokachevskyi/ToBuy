package com.rodico.duke0808.tobuy.items;

import java.util.ArrayList;

/**
 * Created by duke0808 on 26.11.15.
 */
public class ItemList extends ArrayList<Item> {
    long IdS;

    /**
     * Constructs a new {@code ArrayList} instance with zero initial capacity.
     */
    public ItemList() {
        IdS=0;
    }

    public int getPositionById(long id){
        for(int i=0;i<this.size();i++){
            if (this.get(i).getId()==id){
                return i;
            }
        }
        return 0;
    }
}
