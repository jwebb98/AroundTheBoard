package app.webb.aroundtheboard;


import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {
    int scoreOn = 0;
    int doubleOn =1;
    Button Main_Menu;
    Dialog MyDialog;
    Button  Play_Again;
    Button Close_;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_sceen);
        Main_Menu = (Button) findViewById(R.id.menu_btn);


        Main_Menu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myMenuIntent = new Intent(GameScreen.this, ATB_MainActivity.class);
                finish();
                startActivity(myMenuIntent);
            }
        });
    }


    public void MyCustomAlertDialog(){
        MyDialog = new Dialog(GameScreen.this);
        MyDialog.setContentView(R.layout.customedialog);
        MyDialog.setTitle("My Dialog");
        MyDialog.show();
        new ATB_MainActivity();


        Play_Again = (Button)MyDialog.findViewById(R.id.Play_Again);
        Close_ = (Button)MyDialog.findViewById(R.id.Close_);
        Main_Menu = (Button) MyDialog.findViewById(R.id.menu_btn);


        Play_Again.setEnabled(true);
        Close_.setEnabled(true);
        Main_Menu.setEnabled(true);

        Play_Again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(GameScreen.this,GameScreen.class);
                finish();
                startActivity(myIntent);
            }
        });

        Close_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDialog.cancel();
            }
        });

        Main_Menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(GameScreen.this, ATB_MainActivity.class);
                finish();
                startActivity(myIntent);
            }
        });


    }

    public void newclass(){
        new GameScreen();
    }


    public void hitscore(View view) {
        scoreOn = scoreOn + 1;
        displayScore(scoreOn);

        doubleOn = doubleOn + 1;
        whatDouble(doubleOn);



    }
    public void MissScore(View view){

        doubleOn = doubleOn + 1;
        whatDouble(doubleOn);


    }

    public void ResetScore (View view){

        scoreOn = scoreOn =0;
    displayScore(scoreOn);

    doubleOn = doubleOn = 1;
    whatDouble(doubleOn);
}



    private void displayScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.txt_scoreOn);
        scoreView.setText("" + score);

    }
    private void emptyScore() {
        TextView scoreView = (TextView) findViewById(R.id.txt_scoreOn);
        scoreView.setText(null);
    }

    private void whatDouble(int doub) {
        TextView doubleView = (TextView) findViewById(R.id.txt_doubleon);
        doubleView.setText("" + doub);
        if (doub==21){
            doubleView.setText("BULLSEYE!");
        }
        if (doub==22){
            MyCustomAlertDialog();
            doubleView.setText(null);
            //emptyScore();

        }
        if (doub>=23){
            doubleView.setText(null);
            emptyScore();
        }
    }

}