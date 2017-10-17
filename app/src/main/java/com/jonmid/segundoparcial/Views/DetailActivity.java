package com.jonmid.segundoparcial.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonmid.segundoparcial.R;

public class DetailActivity extends AppCompatActivity {

        ImageView imageView;
    TextView texviewname ,textViewcode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        imageView  =(ImageView) findViewById(R.id.id_img_item_detail);

        textViewcode =(TextView) findViewById(R.id.id_tv_codedetail);


        texviewname.setText("name");
        textViewcode.setText("code");


    }
}
