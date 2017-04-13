package id.ac.ugm.blog.tejo_suharyono.listjson;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import id.ac.ugm.blog.tejo_suharyono.listjson.controller.Controller;
import id.ac.ugm.blog.tejo_suharyono.listjson.model.adapter.ItemAdapter;
import id.ac.ugm.blog.tejo_suharyono.listjson.model.data.ItemDataModel;

public class MainActivity extends AppCompatActivity implements Controller.CallListener {

    private RecyclerView mRecyclerView;
    private List<ItemDataModel> mItemDataModelList = new ArrayList<>();
    private ItemAdapter mItemAdapter;
    private Controller mController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mController = new Controller(MainActivity.this);
        configViews();
        mController.startFetching();
    }

    private void configViews() {
        mRecyclerView = (RecyclerView) this.findViewById(R.id.list);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        mItemAdapter = new ItemAdapter(mItemDataModelList);
        mRecyclerView.setAdapter(mItemAdapter);

    }

    @Override
    public void onFetchComplete() {

    }

    @Override
    public void onFetchFailed() {

    }

    @Override
    public void onFetchProgress(ItemDataModel itemDataModel) {
        mItemAdapter.addItemAdapter(itemDataModel);
    }
}
