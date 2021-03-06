package shake.android.mahmoud.learnshake;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class SensorForward extends Activity {

    private SeekBar seek;
    private TextView value;
    private SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensorf);
        value=(TextView)findViewById(R.id.valueSeekf);

        seek=(SeekBar)findViewById(R.id.seekBarf);
        float val= PreferenceManager
                .getDefaultSharedPreferences(getApplicationContext())
                .getFloat("seekbarf", 17);
        seek.setProgress((int)val);
        value.setText(seek.getProgress() + "");
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                value.setText(i + "");
                prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor prefEditor = prefs.edit();
                prefEditor.putFloat("seekbarf", i);
                prefEditor.commit();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        Button reset=(Button)findViewById(R.id.buttonf);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seek.setProgress(17);
            }
        });


    }
}
