package com.rodico.duke0808.tobuy.recyclerview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rodico.duke0808.tobuy.MainActivity;
import com.rodico.duke0808.tobuy.R;
import com.rodico.duke0808.tobuy.items.Item;
import com.rodico.duke0808.tobuy.items.ItemList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerFragment extends Fragment {
    public RecyclerView recyclerView;
    ItemList currentList;


    public RecyclerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initCurrentList();
    }

    private void initCurrentList() {
        currentList = new ItemList();
        currentList.add(new Item("Item 1",false,currentList));
        currentList.add(new Item("Item 2",false,currentList));
        currentList.add(new Item("Item 3",true,currentList));
        currentList.add(new Item("Item 4",false,currentList));
        currentList.add(new Item("Item 5",false,currentList));
        currentList.add(new Item("Item 5",false,currentList));
        currentList.add(new Item("Item 5",false,currentList));
        currentList.add(new Item("Item 5",false,currentList));
        currentList.add(new Item("Item 5",false,currentList));
        currentList.add(new Item("Item 5",false,currentList));
        currentList.add(new Item("Item 5",false,currentList));
        currentList.add(new Item("Item 5",false,currentList));
        currentList.add(new Item("Item 5",false,currentList));
        currentList.add(new Item("Item 5",false,currentList));
        currentList.add(new Item("Item 5",false,currentList));
        currentList.add(new Item("Item 5",false,currentList));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.list_view);


        return view;
    }

}
