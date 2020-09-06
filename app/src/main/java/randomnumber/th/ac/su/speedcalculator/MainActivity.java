package randomnumber.th.ac.su.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calculateButton = findViewById(R.id.cal_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText meterText = findViewById(R.id.meter_text);
                String meter = meterText.getText().toString();
                double  meterVar = Double.parseDouble(meter);
                EditText timeText = findViewById(R.id.second_text);
                String time = timeText.getText().toString();
                double timeVar = Double.parseDouble(time);
                TextView textResult = findViewById(R.id.showspeed);
                meterText.setText("");
                timeText.setText("");
                textResult.setText("");
                if(meter.length()==0&&time.length()==0){
                    Toast t =Toast.makeText(MainActivity.this, R.string.distance_time_required,Toast.LENGTH_LONG);
                    t.show();
                }
                else if(meter.length()>0&&time.length()>0){
                    if(time.length()==0){
                        Toast t = Toast.makeText(MainActivity.this, R.string.time_must_zero,Toast.LENGTH_LONG);
                        t.show();
                    }else{
                        double result =(meterVar/1000)/(timeVar/1000);
                        String str = String.format(
                                Locale.getDefault(), "%.2f", result);
                        textResult.setText(str);



                        if(result>=80){
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("SPEED CALCULATOR");
                            dialog.setMessage("Speed is over limit!!!");
                            dialog.setPositiveButton("yes",null);
                            dialog.show();
                        }


                    }



                }
            }
        });
        Button clearButton = findViewById(R.id.clear_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setNegativeButton("clear",null);
                dialog.show();
            }
        });
    }
}