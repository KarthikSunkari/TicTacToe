package com.example.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private int currentPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentPlayer = 0;
    }

    private int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    private int[] buttonState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    public void resetMethod(View view) {
    resetMethod();
    }

    public void resetMethod() {
        int IDvalue = findViewById(R.id.button0).getId();
        currentPlayer = 0;
        for (int i = 0; i < 9; i++) {
            buttonState[i] = 2;
            Button v = findViewById(IDvalue + i);
            v.setText("");
            Log.i("id", getResources().getResourceEntryName(IDvalue + i));
        }
    }

    public void onClickB(View v){
        int i = 0;
        Button view = (Button) v;
        //Log.i("Info","outsideif " + view.getText().toString() +"dj");
        String str = view.getText().toString();
        Log.i("getid", Integer.toString(view.getId()));
        int pos = view.getId() - findViewById(R.id.button0).getId();
        buttonState[pos] = currentPlayer;
        if (str != "O" && str != "X") {
            Log.i("Info","inside");
            if (currentPlayer == 0) {
                view.setText("O");
                currentPlayer = 1;
            } else {
                view.setText("X");
                currentPlayer = 0;
            }
        }
        for (int[] winningPosition : winningPositions) {
            //if(s = view.getId();)
            if (buttonState[winningPosition[0]] == 0 &&
                    buttonState[winningPosition[2]] == 0 &&
                    buttonState[winningPosition[1]] == 0) {
                Toast.makeText(MainActivity.this, "Player O wins!", Toast.LENGTH_SHORT).show();
                Log.i("id", "o wins");
                resetMethod();
            } else if (buttonState[winningPosition[0]] == 1 &&
                    buttonState[winningPosition[2]] == 1 &&
                    buttonState[winningPosition[1]] == 1) {
                Toast.makeText(MainActivity.this, "Player X wins!", Toast.LENGTH_SHORT).show();
                Log.i("id", "x wins");
                resetMethod();
            }
        }

        for (i = 0; i < 9 && buttonState[i] != 2; i++) { }

        if (i == 9) {
            Toast.makeText(MainActivity.this, "It's a Draw!", Toast.LENGTH_SHORT).show();
            resetMethod();
        }
    }
}


