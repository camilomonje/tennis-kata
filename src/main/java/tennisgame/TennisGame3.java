package tennisgame;

import java.util.Objects;

public class TennisGame3 implements TennisGame {

    private int playerScore1 = 0;
    private int playerScore2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, "player1"))
            playerScore1 += 1;
        else
            playerScore2 += 1;
    }

    private String equalsScorePlayer(int playerScore) {
        switch (playerScore) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private String winScore(int result) {
        return (result >= 2) ? "Win for player1" : "Win for player2";
    }

    private String scoreGreaterThan4(int playerScore1, int playerScore2) {
        int result = playerScore1 - playerScore2;
        switch (result) {
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                return winScore(result);
        }
    }

    public String playerScoreString(int playerScore1) {
        switch (playerScore1) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    public String getScoreWhenIsZeroToThree(int playerScore1, int playerScore2) {
        String score;
        score = playerScoreString(playerScore1);
        score += "-";
        score += playerScoreString(playerScore2);
        return score;
    }


    public String score() {
        String score;
        if (playerScore1 == playerScore2) {
            score = equalsScorePlayer(playerScore1);
        } else if (playerScore1 >= 4 || playerScore2 >= 4) {
            score = scoreGreaterThan4(playerScore1, playerScore2);
        } else {
            score = getScoreWhenIsZeroToThree(playerScore1, playerScore2);
        }
        return score;
    }

}
