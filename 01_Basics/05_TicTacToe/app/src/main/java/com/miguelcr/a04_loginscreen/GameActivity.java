package com.miguelcr.a04_loginscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    TextView welcome, playerTurn;
    String p1Name, p2Name;
    int[] cellsClicked = {0,0,0,0,0,0,0,0,0};
    int currentPlayer = 1;
    ImageView c1, c2, c3, c4, c5, c6, c7, c8, c9;

    // cellsClicked[0], cellsClicked[1], cellsClicked[2],..
    // cellsClicked[0] = 1; > cell1

    /*

    cell1 |  cell2  |  cell3
    --------------------------
    cell4 |  cell5  |  cell6
    --------------------------
    cell7 |  cell8  |  cell9

    To say that player1 clicked on cell1
    we write: cellsClicked[0] = 1;

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        welcome = (TextView) findViewById(R.id.textViewWelcome);
        playerTurn = (TextView) findViewById(R.id.textViewPlayer);
        c1 = (ImageView) findViewById(R.id.cell1);
        c2 = (ImageView) findViewById(R.id.cell2);
        c3 = (ImageView) findViewById(R.id.cell3);
        c4 = (ImageView) findViewById(R.id.cell4);
        c5 = (ImageView) findViewById(R.id.cell5);
        c6 = (ImageView) findViewById(R.id.cell6);
        c7 = (ImageView) findViewById(R.id.cell7);
        c8 = (ImageView) findViewById(R.id.cell8);
        c9 = (ImageView) findViewById(R.id.cell9);

        // get the extra values
        Bundle data = getIntent().getExtras();
        p1Name = data.getString("player1");
        p2Name = data.getString("player2");

        // Set the email value into the textViewWelocome
        welcome.setText(p1Name+" VS "+p2Name);

        playerTurn.setText("Now is playing "+p1Name);

    }

    public void cellClicked(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.cell1:
                if(cellsClicked[0]==0) {
                    cellsClicked[0] = currentPlayer;
                    if (currentPlayer == 1) {
                        c1.setImageResource(R.drawable.ic_player1);
                    } else {
                        c1.setImageResource(R.drawable.ic_player2);
                    }

                    changeTurn();
                } else {
                    Toast.makeText(this, "Cell is not empty", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cell2: cellsClicked[1] = currentPlayer;
                if(currentPlayer==1) {
                    c2.setImageResource(R.drawable.ic_player1);
                } else {
                    c2.setImageResource(R.drawable.ic_player2);
                }
                break;
            case R.id.cell3: cellsClicked[2] = currentPlayer; break;
            case R.id.cell4: cellsClicked[3] = currentPlayer; break;
            case R.id.cell5: cellsClicked[4] = currentPlayer; break;
            case R.id.cell6: cellsClicked[5] = currentPlayer; break;
            case R.id.cell7: cellsClicked[6] = currentPlayer; break;
            case R.id.cell8: cellsClicked[7] = currentPlayer; break;
            case R.id.cell9: cellsClicked[8] = currentPlayer; break;
        }

    }

    public void changeTurn() {
        if(existSolution()) {
            if(currentPlayer==1) {
                playerTurn.setText("The winner is " + p1Name);
            } else {
                playerTurn.setText("The winner is " + p2Name);
            }
        } else { // if not exist solution

            if(currentPlayer==1) {
                currentPlayer = 2;
                playerTurn.setText("Now is playing "+p2Name);
            } else {
                currentPlayer = 1;
                playerTurn.setText("Now is playing "+p1Name);
            }
        }

    }

    private boolean existSolution() {
        /*
        cell1 |  cell2  |  cell3
       --------------------------
        cell4 |  cell5  |  cell6
       --------------------------
        cell7 |  cell8  |  cell9
         */

        // cell1 > 0, cella4 > 3, cell7 > 6
        if(cellsClicked[0]!=0
                && cellsClicked[0]==cellsClicked[3]
                && cellsClicked[0]==cellsClicked[6]) {
            return true;
        } else if(...) { //cell2, cell5, cell8

            return true;
        } else if(...) {

        } else if() {

        } else if() {

        } ...

        return false;


    }
}
