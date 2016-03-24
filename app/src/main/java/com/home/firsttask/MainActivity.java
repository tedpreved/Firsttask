package com.home.firsttask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRvGallery;
    private GalleryAdapter mGalleryAdapter;
    private List<String> mImagesUrls;
    private Toolbar mToolBar;

    private TextView mTvCreatedDate, mTvRegisteredDate, mTvResolveDate, mTvResponsibleName;
    private TextView mTvOrderType, mTvLabelCreated, mTvLabelRegistered, mTvLabelResolved,
            mTvLabelResponsibleName;
    private TextView mTvDescription, mTvFilter;

    private ImageButton mBtnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolBar();
        setImagesUrls();
        setGallery();
        initView();
        setListeners();
    }

    private View.OnClickListener onViewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view != null) {
                Toast.makeText(getApplicationContext(),
                               view.getClass().getSimpleName(),
                               Toast.LENGTH_SHORT).show();
            }
        }
    };

    private View.OnClickListener onBackClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view!=null){
                onBackPressed();
            }
        }
    };

    private void setImagesUrls(){
        mImagesUrls = new ArrayList<>();
        mImagesUrls.add("https://stv.maps.yandex.net/images/?v=3.08.0&oid=1297679222_673949761_23_1430985844&z=3&x=3&y=1");
        mImagesUrls.add("https://stv.maps.yandex.net/images/?v=3.10.1&oid=1254588712_626488848_23_1371900264&z=2&x=4&y=2");
        mImagesUrls.add("https://stv.maps.yandex.net/images/?v=3.10.1&oid=1254596655_626631839_23_1371919747&z=2&x=8&y=2");
    }

    private void setToolBar() {
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(mToolBar);
    }

    private void setGallery() {
        mRvGallery = (RecyclerView) findViewById(R.id.recycle_view_gallery);
        mRvGallery.setHasFixedSize(true);
        mRvGallery.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mGalleryAdapter = new GalleryAdapter(this, mImagesUrls, onViewClickListener);
        mRvGallery.setAdapter(mGalleryAdapter);
    }

    private void initView() {
        mTvDescription = (TextView) findViewById(R.id.tv_description);
        mTvFilter = (TextView) findViewById(R.id.tv_filter_work);
        mTvCreatedDate = (TextView) findViewById(R.id.tv_created_date);
        mTvRegisteredDate = (TextView) findViewById(R.id.tv_registered_date);
        mTvResolveDate = (TextView) findViewById(R.id.tv_resolve_date);
        mTvResponsibleName = (TextView) findViewById(R.id.tv_responsible_name);
        mTvOrderType = (TextView) findViewById(R.id.tv_order_type);
        mTvLabelCreated = (TextView) findViewById(R.id.tv_label_created);
        mTvLabelRegistered = (TextView) findViewById(R.id.tv_label_registered);
        mTvLabelResolved = (TextView) findViewById(R.id.tv_label_resolved);
        mTvLabelResponsibleName = (TextView) findViewById(R.id.tv_label_responsible);
        mBtnBack=(ImageButton)findViewById(R.id.toolbar_btn_back);
    }

    private void setListeners() {
        mTvDescription.setOnClickListener(onViewClickListener);
        mTvFilter.setOnClickListener(onViewClickListener);
        mTvCreatedDate.setOnClickListener(onViewClickListener);
        mTvRegisteredDate.setOnClickListener(onViewClickListener);
        mTvResolveDate.setOnClickListener(onViewClickListener);
        mTvResponsibleName.setOnClickListener(onViewClickListener);
        mTvOrderType.setOnClickListener(onViewClickListener);
        mTvLabelCreated.setOnClickListener(onViewClickListener);
        mTvLabelRegistered.setOnClickListener(onViewClickListener);
        mTvLabelResolved.setOnClickListener(onViewClickListener);
        mTvLabelResponsibleName.setOnClickListener(onViewClickListener);
        mBtnBack.setOnClickListener(onBackClickListener);
    }


}
