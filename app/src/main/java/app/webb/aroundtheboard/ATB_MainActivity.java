package app.webb.aroundtheboard;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ATB_MainActivity extends AppCompatActivity   {

    Button Close_;
    Dialog HowGoodDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atb__main);
        getSupportActionBar().hide();


    }

    public void HowGood(){
        HowGoodDialog = new Dialog(ATB_MainActivity.this);
        HowGoodDialog.setContentView(R.layout.howgooddialog);
        HowGoodDialog.setTitle("Game Over");
        HowGoodDialog.show();
        new ATB_MainActivity();

        Close_ = (Button)HowGoodDialog.findViewById(R.id.Close_);

        Close_.setEnabled(true);

        Close_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HowGoodDialog.cancel();
            }
        });

    }

    public void HowToPlay(){
        HowGoodDialog = new Dialog(ATB_MainActivity.this);
        HowGoodDialog.setContentView(R.layout.howtodialog);
        HowGoodDialog.setTitle("Instructions");
        HowGoodDialog.show();
        new ATB_MainActivity();

        Close_ = (Button)HowGoodDialog.findViewById(R.id.Close_);

        Close_.setEnabled(true);

        Close_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HowGoodDialog.cancel();
            }
        });



    }
    public void onClickStart(View v) {
        Intent i = new Intent(this, GameScreen.class);
         finish();//Kill the activity from which you will go to next activity
        startActivity(i);

    }

    public void onClickHowGood(View v) {
       HowGood();

    }

    public void onClickInst(View v) {
     HowToPlay();


    }


}
