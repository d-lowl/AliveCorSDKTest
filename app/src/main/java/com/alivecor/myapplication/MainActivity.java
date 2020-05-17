package com.alivecor.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alivecor.alivecorkitlite.AliveCorKitLite;
import com.alivecor.api.AliveCorDevice;

import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_RECORD_EKG = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.start_recording)
    public void startRecording() {
        Intent intent = AliveCorKitLite.get().getRecordIntent(AliveCorDevice.TRIANGLE);
        startActivityForResult(intent, REQUEST_RECORD_EKG);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_RECORD_EKG) {
            Timber.i("Back from EKG Recording.  Result: %d/%s", resultCode, AliveCorKitLite.get().getRecordActivityResult(data));
        }
    }
}
