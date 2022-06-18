
import java.util.Scanner;

class TTT_Runner {
    // TODO: Q1, Add in comments throughout the code to help you understand what
    // each method is used for |--->Done!!
    // These variables keeps track of the players pieces
    public static String ticker1 = "";
    public static String ticker2 = "";
    // This variable helps keep track of weather the AI player is going first
    static String maximizingPlayerFirst = "";

    // Random number generation --> from 1 to 2
    static int getRandomPosition() { // Generate Random number from 0 to 2
        return (int) ((Math.random() * (2)) + 0);
    }

    static boolean isMaxPlayer() {
        // Checks if the variable maximizingPlayerFirst is true
        return maximizingPlayerFirst.equals("Maximizing!");
    }

    static void findSymbols() {
        int ticker = getRandomPosition(); // Randomly choose between 0 and 1
        // Update the ticker variables based off of what is randomly choosen
        if (ticker == 1) {
            ticker1 += "X";
            ticker2 += "O";
        } else if (ticker == 0) {
            ticker2 += "X";
            ticker1 += "O";
        }
    }

    public static void main(String[] args) {
        TTT_board board = new TTT_board();
        // TODO: Q2, Randomize who is 'X' and 'O' |------>Done!!
        findSymbols(); // This function randomly picks who is X and O
        Player p1 = new Player(ticker1, "Player 1");
        AIplayer ai = new AIplayer(ticker2, "Allen Iverson");
        System.out.println("Welcome to Tic-Tac-Toe");
        System.out.println(p1.getName() + " is: " + p1.piece);
        System.out.println(ai.getName() + " is: " + ai.piece);
        // TODO: Q3, Randomize player order, who goes first and who goes second.
        // |------>Done!!
        int firstMove = getRandomPosition(); // This variable decides which player gets the first move
        Boolean gameOn = true;
        while (gameOn) {
            // Based off the value of firstMove choose which player goes first
            if (firstMove == 1) {
                maximizingPlayerFirst = "Maximizing!";
                System.out.println("YOUR move ....");
                /*
                 * First prompt the Player on where they would like to go
                 * --> Then grab those coordinates and return then into p1_move
                 */
                String[] p1_move = p1.turn(board); // Gets the coordinates
                board.placeMove(p1, p1_move); // Places the player + Coordinates on the board
                System.out.println(board.printBoard());
                /*
                 * Now, with every move it is necessary to check if you have a winner,
                 * This is where I will right the code that will determine this!!
                 */
                if (board.isThereWinner() || board.isFullNoWinner()) {
                    break;
                }
                // REPLACE WITH turn() method once you have one written.
                System.out.println("AI's move...");
                String[] ai_move = ai.turn(board);
                board.aiPlaceMove(ai, ai_move);
                // Again, after each turn, you must check if there is a winner!!
                if (board.isThereWinner() || board.isFullNoWinner()) {
                    break;
                }
                gameOn = !board.isThereWinner();
            } else {
                System.out.println("AI's move...");
                String[] ai_move = ai.turn(board);
                board.aiPlaceMove(ai, ai_move);
                System.out.println(board.printBoard());
                if (board.isThereWinner() || board.isFullNoWinner()) {
                    break;
                }
                System.out.println("YOUR move ....");
                String[] p1_move = p1.turn(board);
                board.placeMove(p1, p1_move);
                if (board.isThereWinner() || board.isFullNoWinner()) {
                    break;
                }
                gameOn = !board.isThereWinner();
            }
            System.out.println(board.printBoard());
        }
        // TODO: Q4, Output who won the game. |------>Done!!
        if (p1.getPiece().equals(board.winTicker)) {
            System.out.println(p1.name + " won!");
        } else if (ai.getPiece().equals(board.winTicker)) {
            System.out.println(ai.name + " won!");
        } else {
            System.out.println("Well played guys, it's a draw!!");
        }
        System.out.println("Thanks for playing!");
    }
}

class TTT_board {
    String[][] board = new String[3][3];
    String winTicker = "";

    TTT_board() {
        // Loop through the 2D array adding an empty space in each spot
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = " ";
            }
        }
    }

    String printBoard() {
        String b_string = "\n";
        for (int i = 0; i < board.length; i++) {
            b_string += " ";
            for (int j = 0; j < board[0].length; j++) {
                b_string += board[i][j];
                if (j != 2) {
                    b_string += " | ";
                }
            }
            if (i != 2) {
                b_string += "\n------------\n";
            }
        }
        return b_string + "\n";
    }

    // Used By Instructor For Debugging
    String rawPrint() {
        String b_string = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                b_string += board[i][j] + " ";
            }
        }
        return b_string;
    }

    // TODO: Q5, This method will determine if someone has won the game.
    // |------>Done!!
    Boolean isThereWinner() {
        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals(" ")) {
                winTicker += board[i][0];
                return true;
            }
        }
        // Column
        for (int j = 0; j < 3; j++) {
            if (board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j]) && !board[0][j].equals(" ")) {
                winTicker += board[0][j];
                return true;
            }
        }
        // Diagonals
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals(" ")) {
            winTicker += board[0][0];
            return true;
        }
        if (board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2]) && !board[2][0].equals(" ")) {
            winTicker += board[2][0];
            return true;
        }
        // Otherwise nobody has not won yet
        return false;
    }

    Boolean isFullNoWinner() {
        // Loop through board to see if there are no empty spaces left,
        // which would mean the game is finish
        if (isThereWinner()) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    void placeMove(Player p, String[] pMove) {
        // Grab the players (p) piece
        String value = p.getPiece();// --> just the Player's symbol
        // Turn the first and second value in the array into a number
        int row = Integer.parseInt(pMove[0]);
        int col = Integer.parseInt(pMove[1]);
        // Then place the Player's symbol in coordinates
        board[row][col] = value;
    } // Adds Players Move to the Board

    void aiPlaceMove(AIplayer p, String[] pMove) {
        String value = p.getPiece();
        int row = Integer.parseInt(pMove[0]);
        int col = Integer.parseInt(pMove[1]);
        board[row][col] = value;
    } // Adds AI's Move to the Board

    Boolean isValidMove(int r, int c) {
        // Make sure the coordinates the user enters are in bounds
        if (r > 2 || c > 2 || r < 0 || c < 0) {
            return false;
        }
        // Return boolean that checks if the space is already empty
        return board[r][c].equals(" ");
    } // Checks is the move is a val

    String getValue(int r, int c) {
        return board[r][c];
    }
}

class Player {
    String piece;
    String name;
    Scanner playerMove = new Scanner(System.in);

    Player(String s, String n) {
        piece = s;
        name = n;
    }

    String getPiece() {
        return piece;
    }

    void setPiece(String s) {
        this.piece = s;
    }

    String getName() {
        return name;
    }

    void setName(String s) {
        this.name = s;
    }

    String[] turn(TTT_board b) {
        System.out.println("Where would you like to go? (" + name + ")");
        System.out.println("(Type a row and a column, separated by a space, and hit enter.)");
        String userInput = playerMove.nextLine();
        String[] thisMove = userInput.split(" ");
        while (!b.isValidMove(Integer.parseInt(thisMove[0]), Integer.parseInt(thisMove[1]))) {
            System.out.println("NOT A VALID MOVE, TRY AGAIN");
            userInput = playerMove.nextLine();
            thisMove = userInput.split(" ");
        }
        return thisMove;
    }
}

class AIplayer {
    int numOfDraws = 0;
    String piece;
    String name;

    AIplayer(String s, String n) {
        piece = s;
        name = n;
    }

    String getPiece() {
        return piece;
    }

    String getName() {
        return name;
    }

    void setPiece(String s) {
        this.piece = s;
    }

    void setName(String s) {
        this.name = s;
    }

    String[] turn(TTT_board b) {
        String[] thisMove = new String[2];
        String myPiece = piece;
        String enemyPiece;
        /* Whatever the AI's piece is, adjust the enemyPiece accordingly */
        if (piece.equals("X")) {
            enemyPiece = "O";
        } else {
            enemyPiece = "X";
        }
        // TODO: Q6, This method should place a piece for the AI. |------>Done!!
        /*
         * What Implemented here is an algorithm called MiniMax. The Idea here is that
         * program will loop through all possible outcomes of the game with each move
         * that is taken.
         * The program will then rate each move. The result of 1 means that the move in
         * perspective has the
         * best chance of leading to a victory. The result of -1 one is the opposite of
         * this. Lastly,
         * the result of 0 signifies that the move in perspective leads to a draw.
         * If the algorithm sees that there are no moves left that will lead to a win,
         * it will try its best
         * to do moves that at least leads to a draw, inorder words pick moves that have
         * a value of 0.
         * It will always try to avoid moves that leads to -1, or moves that result in
         * it losing.
         */
        int highestVal = Integer.MIN_VALUE;
        // Loop through All the empty spots on the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b.board[i][j].equals(" ")) {
                    // If empty fill with fake piece
                    b.board[i][j] = myPiece;
                    /*
                     * Now, this boolean variable is important because the algorithm needs
                     * to be able to distinguish between who goes first.
                     * If the AI takes the very first move, then isMax must be false --> The
                     * algorithm will go straight into calculating the enemy's best options
                     * inorder to use this knowledge against it
                     */
                    boolean isMax = TTT_Runner.isMaxPlayer();
                    int score = minimax(b, 0, isMax, enemyPiece, myPiece);
                    b.board[i][j] = " "; // Clear broad from fake piece
                    // System.out.println(score + " <-- Score HighestVal --> " + highestVal);
                    // <--Worked Well for Debugging
                    // Now compare the score of the fake move with the current value
                    if (score > highestVal) {
                        // If score is greater than the current highest score,
                        // make that the best possible move to take
                        highestVal = score;
                        thisMove[0] = Integer.toString(i);
                        thisMove[1] = Integer.toString(j);
                    }
                }
            }
        }
        // Return the array that holds the move the AI wants to make
        return thisMove;
    }

    private int minimax(TTT_board b, int depth, boolean isMax, String enemyPiece, String myPiece) {
        /*
         * This Function will recursively check all the possible outcomes of the game.
         * Each final result of the game or end node will return a value of either 1
         * (best move for person
         * trying to maximize their chances of winning), - 1 (bad for player who wants
         * to
         * win, good for enemy), and 0 which means the final node is a draw
         */
        // Base Case for recursion! Checks if final node ends with win/lose/draw.
        if (b.isThereWinner()) {
            if (b.winTicker.equals(enemyPiece)) {
                // System.out.println("Best chance of Enemy winning");
                b.winTicker = "";
                return -1;
            }
            if (b.winTicker.equals(myPiece)) {
                // System.out.println("Best chance of AI winning");
                b.winTicker = "";
                return 1;
            }
        }
        if (b.isFullNoWinner()) {
            // System.out.println("ON It!");
            numOfDraws++;
            /*
             * System.out.println(b.printBoard()); --> This call was helpful in seeing all
             * the
             * possible outcomes of the game
             */
            return 0;
        }
        /* Return the score of the potential move the AI could make */
        if (isMax) {
            /*
             * Loop through all the available spots and place a fake piece there.
             * Then, check the value of that move by recursively calling miniMax
             */
            int highestVal = Integer.MIN_VALUE;
            // Loop through all the available spots and place a fake piece there.
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (b.board[row][col].equals(" ")) {
                        // place a fake piece ai piece if spot available
                        b.board[row][col] = enemyPiece;
                        /*
                         * Now find what score that particular move would give you (Remember
                         * want the highest attainable value)
                         */
                        int score = minimax(b, depth + 1,
                                false, enemyPiece, myPiece);
                        // After you get the score, clear board of initial piece
                        b.board[row][col] = " ";
                        // Compare the current highest score with the score variable
                        // Make the highest value the new highestVal.
                        highestVal = Math.max(score, highestVal);
                    }
                }
            }
            /* If it is the AI's time to place their piece, then do this... */
            return highestVal;
        }
        /* If it is the Enemy's time to place their piece, then do this... */
        else {
            /*
             * Now repeat the same process of figuring out the best move the enemy could
             * take
             * in an effort to use this knowledge against the opponent
             */
            int bestScore = Integer.MAX_VALUE;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (b.board[row][col].equals(" ")) {
                        b.board[row][col] = myPiece;
                        int score = minimax(b, depth + 1,
                                true, enemyPiece, myPiece);
                        b.board[row][col] = " ";
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

    String[] randoTurn(TTT_board b) {
        System.out.println(this.name + "'s turn.");
        int row = (int) (Math.random() * 3);
        int col = (int) (Math.random() * 3);
        String[] thisMove = { Integer.toString(row),
                Integer.toString(col) };
        while (!b.isValidMove(Integer.parseInt(thisMove[0]), Integer.parseInt(thisMove[1]))) {
            System.out.println("A.I. CHOSE INVALID SPOT");
            row = (int) (Math.random() * 3);
            col = (int) (Math.random() * 3);
            thisMove[0] = Integer.toString(row);
            thisMove[1] = Integer.toString(col);
        }
        return thisMove;
    }
}