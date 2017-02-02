package com.miguelcr.a04_loginscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    boolean gameOver = false;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_restart:

                // Restart the array cellsClicked:
                for(int i=0; i<cellsClicked.length; i++) {
                    cellsClicked[i] = 0;
                }

                // Restart the images
                c1.setImageResource(R.drawable.ic_box_empty);
                c2.setImageResource(R.drawable.ic_box_empty);
                c3.setImageResource(R.drawable.ic_box_empty);
                c4.setImageResource(R.drawable.ic_box_empty);
                c5.setImageResource(R.drawable.ic_box_empty);
                c6.setImageResource(R.drawable.ic_box_empty);
                c7.setImageResource(R.drawable.ic_box_empty);
                c8.setImageResource(R.drawable.ic_box_empty);
                c9.setImageResource(R.drawable.ic_box_empty);

                // Game over restart
                gameOver = false;

                // Restart player turn
                currentPlayer = 1;
                playerTurn.setText("Now is playing "+p1Name);

                return true;
            case R.id.action_exit:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void cellClicked(View view) {
        int id = view.getId();

        if(gameOver) {
            Toast.makeText(this, "Game over! Restart to continue", Toast.LENGTH_SHORT).show();
        } else {
            switch (id) {
                case R.id.cell1:
                    if (cellsClicked[0] == 0) {
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
                case R.id.cell2:
                    if (cellsClicked[1] == 0) {
                        cellsClicked[1] = currentPlayer;
                        if (currentPlayer == 1) {
                            c2.setImageResource(R.drawable.ic_player1);
                        } else {
                            c2.setImageResource(R.drawable.ic_player2);
                        }

                        changeTurn();
                    } else {
                        Toast.makeText(this, "Cell is not empty", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.cell3:
                    if (cellsClicked[2] == 0) {
                        cellsClicked[2] = currentPlayer;
                        if (currentPlayer == 1) {
                            c3.setImageResource(R.drawable.ic_player1);
                        } else {
                            c3.setImageResource(R.drawable.ic_player2);
                        }

                        changeTurn();
                    } else {
                        Toast.makeText(this, "Cell is not empty", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.cell4:
                    if (cellsClicked[3] == 0) {
                        cellsClicked[3] = currentPlayer;
                        if (currentPlayer == 1) {
                            c4.setImageResource(R.drawable.ic_player1);
                        } else {
                            c4.setImageResource(R.drawable.ic_player2);
                        }

                        changeTurn();
                    } else {
                        Toast.makeText(this, "Cell is not empty", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.cell5:
                    if (cellsClicked[4] == 0) {
                        cellsClicked[4] = currentPlayer;
                        if (currentPlayer == 1) {
                            c5.setImageResource(R.drawable.ic_player1);
                        } else {
                            c5.setImageResource(R.drawable.ic_player2);
                        }

                        changeTurn();
                    } else {
                        Toast.makeText(this, "Cell is not empty", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.cell6:
                    if (cellsClicked[5] == 0) {
                        cellsClicked[5] = currentPlayer;
                        if (currentPlayer == 1) {
                            c6.setImageResource(R.drawable.ic_player1);
                        } else {
                            c6.setImageResource(R.drawable.ic_player2);
                        }

                        changeTurn();
                    } else {
                        Toast.makeText(this, "Cell is not empty", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.cell7:
                    if (cellsClicked[6] == 0) {
                        cellsClicked[6] = currentPlayer;
                        if (currentPlayer == 1) {
                            c7.setImageResource(R.drawable.ic_player1);
                        } else {
                            c7.setImageResource(R.drawable.ic_player2);
                        }

                        changeTurn();
                    } else {
                        Toast.makeText(this, "Cell is not empty", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.cell8:
                    if (cellsClicked[7] == 0) {
                        cellsClicked[7] = currentPlayer;
                        if (currentPlayer == 1) {
                            c8.setImageResource(R.drawable.ic_player1);
                        } else {
                            c8.setImageResource(R.drawable.ic_player2);
                        }

                        changeTurn();
                    } else {
                        Toast.makeText(this, "Cell is not empty", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.cell9:
                    if (cellsClicked[8] == 0) {
                        cellsClicked[8] = currentPlayer;
                        if (currentPlayer == 1) {
                            c9.setImageResource(R.drawable.ic_player1);
                        } else {
                            c9.setImageResource(R.drawable.ic_player2);
                        }

                        changeTurn();
                    } else {
                        Toast.makeText(this, "Cell is not empty", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
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
        cell1 / 0 |  cell2 / 1  |  cell3 / 2
       -------------------------------------
        cell4 / 3 |  cell5 / 4  |  cell6 / 5
       -------------------------------------
        cell7 / 6 |  cell8 / 7  |  cell9 / 8
         */

        // cell1 > 0, cella4 > 3, cell7 > 6
        if(cellsClicked[0]!=0
                && cellsClicked[0]==cellsClicked[3]
                && cellsClicked[0]==cellsClicked[6]) {
            gameOver = true;
            return true;
        } else if(cellsClicked[1]!=0
                && cellsClicked[1]==cellsClicked[4]
                && cellsClicked[1]==cellsClicked[7]) { // 1,4,7
            gameOver = true;
            return true;
        } else if(cellsClicked[2]!=0
                && cellsClicked[2]==cellsClicked[5]
                && cellsClicked[2]==cellsClicked[8]) { // 2,5,8
            gameOver = true;
            return true;
        } else if(cellsClicked[0]!=0
                && cellsClicked[0]==cellsClicked[1]
                && cellsClicked[0]==cellsClicked[2]) { // 0,1,2
            gameOver = true;
            return true;
        } else if(cellsClicked[3]!=0
                && cellsClicked[3]==cellsClicked[4]
                && cellsClicked[3]==cellsClicked[5]) { // 3,4,5
            gameOver = true;
            return true;
        } else if(cellsClicked[6]!=0
                && cellsClicked[6]==cellsClicked[7]
                && cellsClicked[6]==cellsClicked[8]) { // 6,7,8
            gameOver = true;
            return true;
        } else if(cellsClicked[0]!=0
                && cellsClicked[0]==cellsClicked[4]
                && cellsClicked[0]==cellsClicked[8]) { // 0,4,8
            gameOver = true;
            return true;
        } else if(cellsClicked[2]!=0
                && cellsClicked[2]==cellsClicked[4]
                && cellsClicked[2]==cellsClicked[6]) { // 2,4,6
            gameOver = true;
            return true;
        }

        return false;


    }
}
