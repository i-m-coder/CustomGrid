package com.lokesh.customgrid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toast toastObj = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            DrawDividers mDrawDividers = (DrawDividers) findViewById(R.id.custom_dividers);
            mDrawDividers.invalidateView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        try {
            String sMessage = null;
            switch (view.getId()) {
                case R.id.first_view:
                    sMessage = "Section 1: Onclick";
                    break;
                case R.id.second_view:
                    sMessage = "Section 2: Onclick";
                    break;
                case R.id.third_view:
                    sMessage = "Section 3: Onclick";
                    break;
                case R.id.fourth_view:
                    sMessage = "Section 4: Onclick";
                    break;
            }

            if (toastObj != null) {
                toastObj.cancel();
            }
            toastObj = Toast.makeText(this, sMessage, Toast.LENGTH_SHORT);
            toastObj.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}