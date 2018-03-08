package com.example.android.tennisscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int pointsPlayerA = 0;
    int gamesPlayerA = 0;
    int setsPlayerA = 0;
    int pointsPlayerB = 0;
    int gamesPlayerB = 0;
    int setsPlayerB = 0;
    int setNumber = 1;
    int doubleFaultsA = 0;
    int acesA = 0;
    int unenforcedA = 0;
    int enforcedA = 0;
    int doubleFaultsB = 0;
    int acesB = 0;
    int unenforcedB = 0;
    int enforcedB = 0;
    boolean tieBreak = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayPointsA(String.valueOf(pointsPlayerA));
        displaySetA(setsPlayerA);
        displaySet1A(0);
        displaySet2A(0);
        displaySet3A(0);
        displayGamesA(gamesPlayerA);
        displayDoubleFaultA(doubleFaultsA);
        displayAceA(acesA);
        displayUnenforcedA(unenforcedA);
        displayEnforcedA(enforcedA);
        displayPointsB(String.valueOf(pointsPlayerB));
        displaySetB(setsPlayerB);
        displaySet1B(0);
        displaySet2B(0);
        displaySet3B(0);
        displayGamesB(gamesPlayerB);
        displayDoubleFaultB(doubleFaultsB);
        displayAceB(acesB);
        displayUnenforcedB(unenforcedB);
        displayEnforcedB(enforcedB);
    }

    /**
     * This method counts and displays points, games and sets for Player A
     */
    public void pointPlayerA(View view) {
        if (pointsPlayerA <= 15 && !tieBreak) {
            pointsPlayerA = pointsPlayerA + 15;
        } else if (!tieBreak) pointsPlayerA = pointsPlayerA + 10;
        else pointsPlayerA = pointsPlayerA + 1;
        if (pointsPlayerA >= 50 && !tieBreak || pointsPlayerA >= 7 && tieBreak) {
            if (pointsPlayerA - pointsPlayerB >= 20 && !tieBreak || pointsPlayerA - pointsPlayerB >= 2 && tieBreak) {
                gamesPlayerA = gamesPlayerA + 1;
                pointsPlayerA = 0;
                pointsPlayerB = 0;
            } else if (pointsPlayerA - pointsPlayerB == 0 && !tieBreak) {
                pointsPlayerA = pointsPlayerA - 10;
                pointsPlayerB = pointsPlayerB - 10;
            }
        }

        if (gamesPlayerA >= 6) {
            if (gamesPlayerA - gamesPlayerB >= 2 || gamesPlayerA - gamesPlayerB == 1 && tieBreak) {
                setsPlayerA = setsPlayerA + 1;
                if (setNumber == 1) {
                    displaySet1A(gamesPlayerA);
                    displaySet1B(gamesPlayerB);
                }
                if (setNumber == 2) {
                    displaySet2A(gamesPlayerA);
                    displaySet2B(gamesPlayerB);
                }
                if (setNumber == 3) {
                    displaySet3A(gamesPlayerA);
                    displaySet3B(gamesPlayerB);
                }
                setNumber = setNumber + 1;
                tieBreak = false;
                gamesPlayerA = 0;
                gamesPlayerB = 0;
            } else if (gamesPlayerA - gamesPlayerB == 0) {
                tieBreak = true;
            }
        }

        if (pointsPlayerA == 50 && !tieBreak) displayPointsA("AD");
        else displayPointsA(String.valueOf(pointsPlayerA));
        displayPointsB(String.valueOf(pointsPlayerB));
        displayGamesA(gamesPlayerA);
        displayGamesB(gamesPlayerB);
        displaySetA(setsPlayerA);
        displaySetB(setsPlayerB);
    }

    /**
     * This method counts and displays points, games and sets for Player B
     */
    public void pointPlayerB(View view) {
        if (pointsPlayerB <= 15 && !tieBreak) {
            pointsPlayerB = pointsPlayerB + 15;
        } else if (!tieBreak) pointsPlayerB = pointsPlayerB + 10;
        else pointsPlayerB = pointsPlayerB + 1;
        if (pointsPlayerB >= 50 && !tieBreak || pointsPlayerB >= 7 && tieBreak) {
            if (pointsPlayerB - pointsPlayerA >= 20 && !tieBreak || pointsPlayerB - pointsPlayerA >= 2 && tieBreak) {
                gamesPlayerB = gamesPlayerB + 1;
                pointsPlayerA = 0;
                pointsPlayerB = 0;
            } else if (pointsPlayerB - pointsPlayerA == 0 && !tieBreak) {
                pointsPlayerA = pointsPlayerA - 10;
                pointsPlayerB = pointsPlayerB - 10;
            }
        }

        if (gamesPlayerB >= 6) {
            if (gamesPlayerB - gamesPlayerA >= 2 || gamesPlayerB - gamesPlayerA == 1 && tieBreak) {
                setsPlayerB = setsPlayerB + 1;
                if (setNumber == 1) {
                    displaySet1A(gamesPlayerA);
                    displaySet1B(gamesPlayerB);
                }
                if (setNumber == 2) {
                    displaySet2A(gamesPlayerA);
                    displaySet2B(gamesPlayerB);
                }
                if (setNumber == 3) {
                    displaySet3A(gamesPlayerA);
                    displaySet3B(gamesPlayerB);
                }
                setNumber = setNumber + 1;
                tieBreak = false;
                gamesPlayerA = 0;
                gamesPlayerB = 0;
            } else if (gamesPlayerB - gamesPlayerA == 0) {
                tieBreak = true;
            }
        }

        displayPointsA(String.valueOf(pointsPlayerA));
        if (pointsPlayerB == 50 && !tieBreak) displayPointsB("AD");
        else displayPointsB(String.valueOf(pointsPlayerB));
        displayGamesA(gamesPlayerA);
        displayGamesB(gamesPlayerB);
        displaySetA(setsPlayerA);
        displaySetB(setsPlayerB);
    }

    /**
     * This method counts and displays double faults for Player A
     */
    public void doubleFaultA(View view) {
        doubleFaultsA = doubleFaultsA + 1;
        displayDoubleFaultA(doubleFaultsA);
    }

    /**
     * This method counts and displays aces for Player A
     */
    public void aceA(View view) {
        acesA = acesA + 1;
        displayAceA(acesA);
    }

    /**
     * This method counts and displays unenforced errors for Player A
     */
    public void unenforcedA(View view) {
        unenforcedA = unenforcedA + 1;
        displayUnenforcedA(unenforcedA);
    }

    /**
     * This method counts and displays enforced errors for Player A
     */
    public void enforcedA(View view) {
        enforcedA = enforcedA + 1;
        displayEnforcedA(enforcedA);
    }

    /**
     * This method counts and displays double faults for Player B
     */
    public void doubleFaultB(View view) {
        doubleFaultsB = doubleFaultsB + 1;
        displayDoubleFaultB(doubleFaultsB);
    }

    /**
     * This method counts and displays aces for Player B
     */
    public void aceB(View view) {
        acesB = acesB + 1;
        displayAceB(acesB);
    }

    /**
     * This method counts and displays unenforced errors for Player B
     */
    public void unenforcedB(View view) {
        unenforcedB = unenforcedB + 1;
        displayUnenforcedB(unenforcedB);
    }

    /**
     * This method counts and displays enforced errors for Player B
     */
    public void enforcedB(View view) {
        enforcedB = enforcedB + 1;
        displayEnforcedB(enforcedB);
    }

    /**
     * This method resets all counters
     */
    public void reset(View view) {
        pointsPlayerA = 0;
        gamesPlayerA = 0;
        setsPlayerA = 0;
        pointsPlayerB = 0;
        gamesPlayerB = 0;
        setsPlayerB = 0;
        setNumber = 1;
        doubleFaultsA = 0;
        acesA = 0;
        unenforcedA = 0;
        enforcedA = 0;
        doubleFaultsB = 0;
        acesB = 0;
        unenforcedB = 0;
        enforcedB = 0;
        tieBreak = false;
        displayPointsA(String.valueOf(pointsPlayerA));
        displaySetA(setsPlayerA);
        displaySet1A(0);
        displaySet2A(0);
        displaySet3A(0);
        displayGamesA(gamesPlayerA);
        displayDoubleFaultA(doubleFaultsA);
        displayAceA(acesA);
        displayUnenforcedA(unenforcedA);
        displayEnforcedA(enforcedA);
        displayPointsB(String.valueOf(pointsPlayerB));
        displaySetB(setsPlayerB);
        displaySet1B(0);
        displaySet2B(0);
        displaySet3B(0);
        displayGamesB(gamesPlayerB);
        displayDoubleFaultB(doubleFaultsB);
        displayAceB(acesB);
        displayUnenforcedB(unenforcedB);
        displayEnforcedB(enforcedB);
    }

    /**
     * This method displays points for Player A.
     */
    private void displayPointsA(String score) {
        TextView scoreView = (TextView) findViewById(R.id.points_player_a);
        scoreView.setText(score);
    }

    /**
     * This method displays games for Player A
     */
    private void displayGamesA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.games_player_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays sets for Player A
     */
    private void displaySetA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.sets_player_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays set 1 for Player A
     */
    private void displaySet1A(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set1_player_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays set 2 for Player A
     */
    private void displaySet2A(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set2_player_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays set 3 for Player A
     */
    private void displaySet3A(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set3_player_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays double faults for Player A
     */
    private void displayDoubleFaultA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.double_faults_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays aces for Player A
     */
    private void displayAceA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.aces_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays unenforced errors for Player A
     */
    private void displayUnenforcedA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.unenforced_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays enforced errors for Player A
     */
    private void displayEnforcedA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.enforced_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays points for Player B.
     */
    private void displayPointsB(String score) {
        TextView scoreView = (TextView) findViewById(R.id.points_player_b);
        scoreView.setText(score);
    }

    /**
     * This method displays games for Player B
     */
    private void displayGamesB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.games_player_b);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays sets for Player B
     */
    private void displaySetB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.sets_player_b);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays set 1 for Player B
     */
    private void displaySet1B(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set1_player_b);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays set 2 for Player B
     */
    private void displaySet2B(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set2_player_b);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays set 3 for Player B
     */
    private void displaySet3B(int score) {
        TextView scoreView = (TextView) findViewById(R.id.set3_player_b);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays double faults for Player B
     */
    private void displayDoubleFaultB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.double_faults_b);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays aces for Player B
     */
    private void displayAceB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.aces_b);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays unenforced errors for Player B
     */
    private void displayUnenforcedB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.unenforced_b);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays enforced errors for Player B
     */
    private void displayEnforcedB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.enforced_b);
        scoreView.setText(String.valueOf(score));
    }

}
