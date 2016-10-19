package stevenzafrani.ringersilent;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RingerHelper.performToggle(audioManager);
                updateUi();
            }
        });
    }
    private void updateUi() {
        ImageView imageView =  (ImageView) findViewById(R.id.imageView);
        int phoneImage = RingerHelper.isPhoneSilent(audioManager)
            ? R.drawable.ic_volume_off_black_24dp
            : R.drawable.ic_volume_up_black_24dp;

        imageView.setImageResource(phoneImage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUi();

    }


}
