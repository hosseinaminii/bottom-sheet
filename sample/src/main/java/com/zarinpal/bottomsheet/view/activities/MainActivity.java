package com.zarinpal.bottomsheet.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zarinpal.bottomsheet.R;
import com.zarinpal.bottomsheet.model.PurseModel;
import com.zarinpal.bottomsheet.view.bottomSheet.BottomSheetTransparentModal;
import com.zarinpal.bottomsheet.view.bottomSheet.TestBottomSheetModal;
import com.zarinpal.libs.bottomsheet.OnListBottomSheetItemClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnListBottomSheet  = findViewById(R.id.btn_show_list);
        Button btnModalBottomSheet = findViewById(R.id.btn_show_modal);

        final TestBottomSheetModal testBottomSheetModal = new TestBottomSheetModal(getSupportFragmentManager());

        btnListBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testBottomSheetModal.show();
            }
        });

        btnModalBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BottomSheetTransparentModal(getSupportFragmentManager()).show();
            }
        });

        testBottomSheetModal.setOnItemClickListener(new OnListBottomSheetItemClickListener<PurseModel>() {
            @Override
            public void onListBottomSheetItemClick(PurseModel element, int position, int viewType) {
                Toast.makeText(MainActivity.this, element.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        testBottomSheetModal.addItems(getFakeItems());

    }

    private ArrayList<PurseModel> getFakeItems() {

        ArrayList<PurseModel> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            PurseModel purse = new PurseModel();
            purse.setName("item #" + i);
            purse.setBalance("Balance: " + i);

            items.add(purse);
        }
        return items;
    }
}
