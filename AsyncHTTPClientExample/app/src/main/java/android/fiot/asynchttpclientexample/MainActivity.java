package android.fiot.asynchttpclientexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FioTRestApi.postAsychronous(this, "https://filament.fiot.vn/api/login");
    }
}
