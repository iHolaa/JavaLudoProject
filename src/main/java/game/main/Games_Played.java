package game.main;

public class Games_Played {
        private String player1;
        private String player2;
        private String player3;
        private String player4;
        private String winner;
        private String date;

        public Games_Played(String player1, String player2, String player3, String player4 ,String winner , String date) {
            this.player1 = player1;
            this.player2 = player2;
            this.player3 = player3;
            this.player4 = player4;
            this.winner = winner;
            this.date = date;
        }

        public String getPlayer1() { return player1;}
        public String getPlayer2() { return player2;}
        public String getPlayer3() {
            return player3;
        }
        public String getPlayer4() {
            return player4;
        }
        public String getWinner() {
            return winner;
        }
        public String getDate() {
            return date;
        }

}


