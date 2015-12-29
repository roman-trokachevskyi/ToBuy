package com.rodico.duke0808.tobuy.items;

/**
 * Created by duke0808 on 26.11.15.
 */
public class Item {
    String title;
    boolean checked;
    int viewType;
    long id;
    ItemList parent;

    public ItemList getParent() {
        return parent;
    }

    public void setParent(ItemList parent) {
        this.parent = parent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public Item(String title, boolean checked, ItemList parent) {
        this.title = title;
        this.checked = checked;
        this.parent = parent;
        this.id = parent.IdS++;
        viewType=0;
    }

    public Item() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
