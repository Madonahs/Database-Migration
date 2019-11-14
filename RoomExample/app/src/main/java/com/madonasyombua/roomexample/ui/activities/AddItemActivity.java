package com.madonasyombua.roomexample.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.madonasyombua.roomexample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddItemActivity extends AppCompatActivity {

    public static final String EXTRA_REPLAY = "one";
    public static final String EXTRA_REPLAY2 = "two";
    public static final String EXTRA_REPLAY3 = "three";


    @BindView(R.id.item_one)
    EditText itemOne;
    @BindView(R.id.item_two)
    EditText itemTwo;
    @BindView(R.id.item_three)
    EditText itemThree;
    @BindView(R.id.item_button)
    Button itemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        ButterKnife.bind(this);


        itemButton.setOnClickListener(v -> {
            Intent intentReply = new Intent();
            if (TextUtils.isEmpty(itemOne.getText()) &&
                    TextUtils.isEmpty(itemTwo.getText())
                    && TextUtils.isEmpty(itemThree.getText())) {
                //you can run the below code or return;
               // setResult(RESULT_CANCELED, intentReply);
                return;
            }else{
                String item1 = itemOne.getText().toString();
                String item2 = itemTwo.getText().toString();
                String item3 = itemThree.getText().toString();
                intentReply.putExtra(EXTRA_REPLAY,item1);
                intentReply.putExtra(EXTRA_REPLAY2,item2);
                intentReply.putExtra(EXTRA_REPLAY3,item3);
                setResult(RESULT_OK,intentReply);
            }
            finish();
        });
    }
}
