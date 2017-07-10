package edu.ritwijsn.cs478.project4;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView i1, i2, i3, i4, i5, i6, i7, i8, i9; //Images in the layout
    private static ArrayList<Integer> numbersGenerated = new ArrayList<Integer>(); //To maintain the generated random numbers
    private Button button;
    private static String gameState [] = new String[9]; //To determine whether any player is winning
    private static boolean gameOver = false;
    private static int winPattern = 0;
    public static final int PLAYER_ONE = 1;
    public static final int PLAYER_TWO = 2;
    public static final int GAME_OVER = -1;
    public static final int PLAYER_ONE_WIN = 3;
    public static final int PLAYER_TWO_WIN = 4;
    public PlayerOneThread playerOne;
    public PlayerTwoThread playerTwo;

    //Handler for the UI thread to establish communication between Worker Threads
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            /*Switch to check which player has made the move and which player has to asked to make move next*/
            switch (msg.what){
                /*Case for thread one - The worker thread generates a random number and sends as arg,
                UI thread marks the move and calls the second thread*/
                case PLAYER_ONE:
                    setXImage(msg.arg1);
                    gameState[msg.arg1-1] = "x";
                    Toast.makeText(MainActivity.this, "Player One Made Move", Toast.LENGTH_SHORT).show();
                    Message playerTwoMsg = playerTwo.playerTwoHandler.obtainMessage(0);
                    playerTwo.playerTwoHandler.sendMessageDelayed(playerTwoMsg, 2500);
                    break;
                /*Same for thread 2*/
                case PLAYER_TWO:
                    setOImage(msg.arg1);
                    gameState[msg.arg1-1] = "o";
                    Toast.makeText(MainActivity.this, "Player Two Made Move", Toast.LENGTH_SHORT).show();
                    Message playerOneMsg = playerOne.playerOneHandler.obtainMessage(0);
                    playerOne.playerOneHandler.sendMessageDelayed(playerOneMsg, 2500);
                    break;
                /*Case to indicate Game Over and it was a Tie*/
                case GAME_OVER:
                    Toast.makeText(MainActivity.this, "Game Over - It was a Tie", Toast.LENGTH_LONG).show();
                    winPattern = 9; /*When its a tie and nobody won -  winning pattern to update UI*/
                    int colorTie = Color.rgb(205, 97, 85);
                    indicateWin(colorTie);
                    gameOver = true;
                    break;
                /*Case to indicate game over - player one won*/
                case PLAYER_ONE_WIN:
                    Toast.makeText(MainActivity.this, "Game Over - Player One Wins", Toast.LENGTH_LONG).show();
                    int colorOne = Color.rgb(133, 193, 233);
                    indicateWin(colorOne);
                    gameOver = true;
                    break;
                /*Case to indicate game over - player two won*/
                case PLAYER_TWO_WIN:
                    Toast.makeText(MainActivity.this, "Game Over - Player Two Wins", Toast.LENGTH_LONG).show();
                    int colorTwo = Color.rgb(245, 176, 65);
                    indicateWin(colorTwo);
                    gameOver = true;
                    break;
            }
        }
    };

    /*This is method to indicate the win: appropriate image backgrounds are changed based on the winner thread*/
    private void indicateWin(int color) {
        switch (winPattern){
            case 1: /*Case 1 - corresponds to the winning pattern 1*/
                i1.setBackgroundColor(color);
                i2.setBackgroundColor(color);
                i3.setBackgroundColor(color);
                break;
            case 2:
                i4.setBackgroundColor(color);
                i5.setBackgroundColor(color);
                i6.setBackgroundColor(color);
                break;
            case 3:
                i7.setBackgroundColor(color);
                i8.setBackgroundColor(color);
                i9.setBackgroundColor(color);
                break;
            case 4:
                i1.setBackgroundColor(color);
                i5.setBackgroundColor(color);
                i9.setBackgroundColor(color);
                break;
            case 5:
                i3.setBackgroundColor(color);
                i5.setBackgroundColor(color);
                i7.setBackgroundColor(color);
                break;
            case 6:
                i1.setBackgroundColor(color);
                i4.setBackgroundColor(color);
                i7.setBackgroundColor(color);
                break;
            case 7:
                i2.setBackgroundColor(color);
                i5.setBackgroundColor(color);
                i8.setBackgroundColor(color);
                break;
            case 8:
                i3.setBackgroundColor(color);
                i6.setBackgroundColor(color);
                i9.setBackgroundColor(color);
                break;
            case 9:
                i1.setBackgroundColor(color);
                i2.setBackgroundColor(color);
                i3.setBackgroundColor(color);
                i4.setBackgroundColor(color);
                i5.setBackgroundColor(color);
                i6.setBackgroundColor(color);
                i7.setBackgroundColor(color);
                i8.setBackgroundColor(color);
                i9.setBackgroundColor(color);
                break;
        }
    }
    /*Method to mark the player X mark*/
    public void setXImage(int n){

        switch (n){
            case 1:
                i1.setImageResource(R.drawable.play_x);
                break;
            case 2:
                i2.setImageResource(R.drawable.play_x);
                break;
            case 3:
                i3.setImageResource(R.drawable.play_x);
                break;
            case 4:
                i4.setImageResource(R.drawable.play_x);
                break;
            case 5:
                i5.setImageResource(R.drawable.play_x);
                break;
            case 6:
                i6.setImageResource(R.drawable.play_x);
                break;
            case 7:
                i7.setImageResource(R.drawable.play_x);
                break;
            case 8:
                i8.setImageResource(R.drawable.play_x);
                break;
            case 9:
                i9.setImageResource(R.drawable.play_x);
                break;
        }
    }

    /*Method to mark player O mark on the UI*/
    public void setOImage(int n){

        switch (n){
            case 1:
                i1.setImageResource(R.drawable.play_o);
                break;
            case 2:
                i2.setImageResource(R.drawable.play_o);
                break;
            case 3:
                i3.setImageResource(R.drawable.play_o);
                break;
            case 4:
                i4.setImageResource(R.drawable.play_o);
                break;
            case 5:
                i5.setImageResource(R.drawable.play_o);
                break;
            case 6:
                i6.setImageResource(R.drawable.play_o);
                break;
            case 7:
                i7.setImageResource(R.drawable.play_o);
                break;
            case 8:
                i8.setImageResource(R.drawable.play_o);
                break;
            case 9:
                i9.setImageResource(R.drawable.play_o);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        i1 = (ImageView) findViewById(R.id.i1);
        i2 = (ImageView) findViewById(R.id.i2);
        i3 = (ImageView) findViewById(R.id.i3);
        i4 = (ImageView) findViewById(R.id.i4);
        i5 = (ImageView) findViewById(R.id.i5);
        i6 = (ImageView) findViewById(R.id.i6);
        i7 = (ImageView) findViewById(R.id.i7);
        i8 = (ImageView) findViewById(R.id.i8);
        i9 = (ImageView) findViewById(R.id.i9);

        playerOne = new PlayerOneThread();/*Thread one is created*/
        playerTwo = new PlayerTwoThread();/*Thread two is created*/

        button.setBackgroundColor(Color.rgb(215, 219, 221));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Check if the threads are alive or not alive or game is over - based on that call appropriate funcs*/
                if (!playerOne.isAlive() && !playerTwo.isAlive()){/*If not alive start the threads*/
                    playerOne.start();
                    playerTwo.start();
                }else if (gameOver || (playerOne.isAlive() && playerTwo.isAlive())){/*If game over or are alive then reset the game on button click*/
                    resetGame();
                    playerOne.playerOneHandler.removeMessages(0); /*remove messages from thread one*/
                    playerTwo.playerTwoHandler.removeMessages(0); /*remove messages from thread two*/
                    Message message = playerOne.playerOneHandler.obtainMessage(0);
                    playerOne.playerOneHandler.sendMessage(message);
                }
            }
        });
    }
    /*Method to reset the game conditions - UI is reset*/
    private void resetGame() {
        numbersGenerated.clear();
        winPattern = 0;
        gameState = new String[9];
        i1.setImageResource(0);
        i1.setBackgroundColor(Color.WHITE);
        i2.setImageResource(0);
        i2.setBackgroundColor(Color.WHITE);
        i3.setImageResource(0);
        i3.setBackgroundColor(Color.WHITE);
        i4.setImageResource(0);
        i4.setBackgroundColor(Color.WHITE);
        i5.setImageResource(0);
        i5.setBackgroundColor(Color.WHITE);
        i6.setImageResource(0);
        i6.setBackgroundColor(Color.WHITE);
        i7.setImageResource(0);
        i7.setBackgroundColor(Color.WHITE);
        i8.setImageResource(0);
        i8.setBackgroundColor(Color.WHITE);
        i9.setImageResource(0);
        i9.setBackgroundColor(Color.WHITE);
    }

    /*Thread class for thread one*/
    private class PlayerOneThread extends Thread{
        private Handler playerOneHandler;
        @Override
        public void run() {
            while(!playerOne.isInterrupted()){
                /*Thread one makes the first move always.*/
                Looper.prepare();
                Message msg = mHandler.obtainMessage(PLAYER_ONE);
                msg.arg1 = generateRandom();
                mHandler.sendMessage(msg);
                playerOneHandler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        if (msg.what == 0){
                            Message message = null;
                            int n = 0;
                            String status = checkGameState("o");/*Before making a move check if other player has already won the game*/
                            if(status != null){
                                if (status.equals("win"))
                                    message = mHandler.obtainMessage(PLAYER_TWO_WIN); /*Inform the UI thread of win to UI*/

                            }else{
                                n = generateRandom(); /*Generate a random number for making a move*/
                                if(n > 0){
                                    message = mHandler.obtainMessage(PLAYER_ONE);
                                    message.arg1 = n;
                                }else{
                                    message = mHandler.obtainMessage(GAME_OVER);/*If game is a tie*/
                                }
                            }
                            mHandler.sendMessage(message);
                        }
                    }
                };
                Looper.loop();
            }
        }
    }
    /*Thread two class - similar to thread one class*/
    private class PlayerTwoThread extends Thread {
        private Handler playerTwoHandler;

        @Override
        public void run() {
            while (!playerTwo.isInterrupted()) {
                Looper.prepare();
                playerTwoHandler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        if (msg.what == 0) {
                            Message message = null;
                            int n = 0;
                            String status = checkGameState("x"); /*Check if other player has already won before making move*/
                            if (status != null) {
                                if (status.equals("win"))
                                    message = mHandler.obtainMessage(PLAYER_ONE_WIN); /*Inform the UI thread of win to UI*/
                            } else {
                                n = generateRandom();
                                if (n > 0) {
                                    message = mHandler.obtainMessage(PLAYER_TWO);
                                    message.arg1 = n;
                                } else {
                                    message = mHandler.obtainMessage(GAME_OVER); /*If game is a tie*/
                                }
                            }
                            mHandler.sendMessage(message);
                        }

                    }

                };
                Looper.loop();
            }
        }
    }
    /*Method to generate a random number */
    public static synchronized int generateRandom() {
        Random rand = new Random();
        int n = -1;
        do{
            n = rand.nextInt(9) + 1;
            if(!numbersGenerated.contains(n)){
                numbersGenerated.add(n); /*Generated random number is added to an arraylist to keep is distinct and not repeat*/
                break;
            }else if(numbersGenerated.size() == 9){
                n = -1;
                break;
            }
        }while (n >= 0);
        return n; /*Return the generated random number*/
    }
    /*Method to check the status of the game - See if a player has won*/
    public static String checkGameState(String player){
        String status = null;
        if(gameState[0] != null && gameState[1] != null && gameState[2] != null){
            if(gameState[0].equals(player) && gameState[1].equals(player) && gameState[2].equals(player)){
                status = "win";
                winPattern = 1; /*Winning pattern to update the UI - There are 8 ways in which a player can win - this is one of them*/
            }
        }
        if(gameState[3] != null && gameState[4] != null && gameState[5] != null){
            if(gameState[3].equals(player) && gameState[4].equals(player) && gameState[5].equals(player)){
                status = "win";
                winPattern = 2;
            }
        }
        if(gameState[6] != null && gameState[7] != null && gameState[8] != null){
            if(gameState[6].equals(player) && gameState[7].equals(player) && gameState[8].equals(player)){
                status = "win";
                winPattern = 3;
            }
        }
        if(gameState[0] != null && gameState[4] != null && gameState[8] != null){
            if(gameState[0].equals(player) && gameState[4].equals(player) && gameState[8].equals(player)){
                status = "win";
                winPattern = 4;
            }
        }
        if(gameState[2] != null && gameState[4] != null && gameState[6] != null){
            if(gameState[2].equals(player) && gameState[4].equals(player) && gameState[6].equals(player)){
                status = "win";
                winPattern = 5;
            }
        }
        if(gameState[0] != null && gameState[3] != null && gameState[6] != null){
            if(gameState[0].equals(player) && gameState[3].equals(player) && gameState[6].equals(player)){
                status = "win";
                winPattern = 6;
            }
        }
        if(gameState[1] != null && gameState[4] != null && gameState[7] != null){
            if(gameState[1].equals(player) && gameState[4].equals(player) && gameState[7].equals(player)){
                status = "win";
                winPattern = 7;
            }
        }
        if(gameState[2] != null && gameState[5] != null && gameState[8] != null){
            if(gameState[2].equals(player) && gameState[5].equals(player) && gameState[8].equals(player)){
                status = "win";
                winPattern = 8;
            }
        }
        return status;
    }
}
