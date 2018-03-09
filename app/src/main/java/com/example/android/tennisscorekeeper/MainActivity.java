package com.example.android.tennisscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int pointsPlayerA;
    int gamesPlayerA;
    int setsPlayerA;
    int pointsPlayerB;
    int gamesPlayerB;
    int setsPlayerB;
    int setNumber;
    int doubleFaultsA;
    int acesA;
    int unenforcedA;
    int enforcedA;
    int doubleFaultsB;
    int acesB;
    int unenforcedB;
    int enforcedB;
    boolean tieBreak;

    TextView pointsA_view;
    TextView gamesA_view;
    TextView setsA_view;
    TextView set1A_view;
    TextView set2A_view;
    TextView set3A_view;
    TextView doublefaultsA_view;
    TextView acesA_view;
    TextView unenforcedA_view;
    TextView enforcedA_view;
    TextView pointsB_view;
    TextView gamesB_view;
    TextView setsB_view;
    TextView set1B_view;
    TextView set2B_view;
    TextView set3B_view;
    TextView doublefaultsB_view;
    TextView acesB_view;
    TextView unenforcedB_view;
    TextView enforcedB_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pointsA_view = (TextView)findViewById(R.id.points_player_a);
        gamesA_view = (TextView)findViewById(R.id.games_player_a);
        setsA_view = (TextView)findViewById(R.id.sets_player_a);
        set1A_view = (TextView)findViewById(R.id.set1_player_a);
        set2A_view = (TextView)findViewById(R.id.set2_player_a);
        set3A_view = (TextView)findViewById(R.id.set3_player_a);
        doublefaultsA_view = (TextView)findViewById(R.id.double_faults_a);
        acesA_view = (TextView)findViewById(R.id.aces_a);
        unenforcedA_view = (TextView)findViewById(R.id.unenforced_a);
        enforcedA_view = (TextView)findViewById(R.id.enforced_a);
        pointsB_view = (TextView)findViewById(R.id.points_player_b);
        gamesB_view = (TextView)findViewById(R.id.games_player_b);
        setsB_view = (TextView)findViewById(R.id.sets_player_b);
        set1B_view = (TextView)findViewById(R.id.set1_player_b);
        set2B_view = (TextView)findViewById(R.id.set2_player_b);
        set3B_view = (TextView)findViewById(R.id.set3_player_b);
        doublefaultsB_view = (TextView)findViewById(R.id.double_faults_b);
        acesB_view = (TextView)findViewById(R.id.aces_b);
        unenforcedB_view = (TextView)findViewById(R.id.unenforced_b);
        enforcedB_view = (TextView)findViewById(R.id.enforced_b);

        if (savedInstanceState == null) {
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
        } else {
            pointsPlayerA = savedInstanceState.getInt("pointsA");
            gamesPlayerA = savedInstanceState.getInt("gamesA");
            setsPlayerA = savedInstanceState.getInt("setsA");
            pointsPlayerB = savedInstanceState.getInt("pointsB");
            gamesPlayerB = savedInstanceState.getInt("gamesB");
            setsPlayerB = savedInstanceState.getInt("setsB");
            setNumber = savedInstanceState.getInt("setnr");
            doubleFaultsA = savedInstanceState.getInt("doubleA");
            acesA = savedInstanceState.getInt("aceA");
            unenforcedA = savedInstanceState.getInt("unenfA");
            enforcedA = savedInstanceState.getInt("enfA");
            doubleFaultsB = savedInstanceState.getInt("doubleB");
            acesB = savedInstanceState.getInt("aceB");
            unenforcedB = savedInstanceState.getInt("unenfB");
            enforcedB = savedInstanceState.getInt("enfB");
            tieBreak = savedInstanceState.getBoolean("tiebr");
            set1A_view.setText(savedInstanceState.getString("set1A"));
            set2A_view.setText(savedInstanceState.getString("set2A"));
            set3A_view.setText(savedInstanceState.getString("set3A"));
            set1B_view.setText(savedInstanceState.getString("set1B"));
            set2B_view.setText(savedInstanceState.getString("set2B"));
            set3B_view.setText(savedInstanceState.getString("set3B"));
        }

        if (pointsPlayerA == 50 && !tieBreak) pointsA_view.setText(R.string.advantage);
        else pointsA_view.setText(String.valueOf(pointsPlayerA));
        setsA_view.setText(String.valueOf(setsPlayerA));
        gamesA_view.setText(String.valueOf(gamesPlayerA));
        doublefaultsA_view.setText(String.valueOf(doubleFaultsA));
        acesA_view.setText(String.valueOf(acesA));
        unenforcedA_view.setText(String.valueOf(unenforcedA));
        enforcedA_view.setText(String.valueOf(enforcedA));
        if (pointsPlayerB == 50 && !tieBreak) pointsB_view.setText(R.string.advantage);
        else pointsB_view.setText(String.valueOf(pointsPlayerB));
        setsB_view.setText(String.valueOf(setsPlayerB));
        gamesB_view.setText(String.valueOf(gamesPlayerB));
        doublefaultsB_view.setText(String.valueOf(doubleFaultsB));
        acesB_view.setText(String.valueOf(acesB));
        unenforcedB_view.setText(String.valueOf(unenforcedB));
        enforcedB_view.setText(String.valueOf(enforcedB));
    }

    /**
     * It saves the activity state for orientation change.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("pointsA", pointsPlayerA);
        savedInstanceState.putInt("gamesA", gamesPlayerA);
        savedInstanceState.putInt("setsA", setsPlayerA);
        savedInstanceState.putInt("doubleA", doubleFaultsA);
        savedInstanceState.putInt("aceA", acesA);
        savedInstanceState.putInt("unenfA", unenforcedA);
        savedInstanceState.putInt("enfA", enforcedA);
        savedInstanceState.putInt("pointsB", pointsPlayerB);
        savedInstanceState.putInt("gamesB", gamesPlayerB);
        savedInstanceState.putInt("setsB", setsPlayerB);
        savedInstanceState.putInt("doubleB", doubleFaultsB);
        savedInstanceState.putInt("aceB", acesB);
        savedInstanceState.putInt("unenfB", unenforcedB);
        savedInstanceState.putInt("enfB", enforcedB);
        savedInstanceState.putInt("setnr", setNumber);
        savedInstanceState.putBoolean("tiebr", tieBreak);
        savedInstanceState.putString("set1A", set1A_view.getText().toString());
        savedInstanceState.putString("set2A", set2A_view.getText().toString());
        savedInstanceState.putString("set3A", set3A_view.getText().toString());
        savedInstanceState.putString("set1B", set1B_view.getText().toString());
        savedInstanceState.putString("set2B", set2B_view.getText().toString());
        savedInstanceState.putString("set3B", set3B_view.getText().toString());
        super.onSaveInstanceState(savedInstanceState);
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
                    set1A_view.setText(String.valueOf(gamesPlayerA));
                    set1B_view.setText(String.valueOf(gamesPlayerB));
                }
                if (setNumber == 2) {
                    set2A_view.setText(String.valueOf(gamesPlayerA));
                    set2B_view.setText(String.valueOf(gamesPlayerB));
                }
                if (setNumber == 3) {
                    set3A_view.setText(String.valueOf(gamesPlayerA));
                    set2B_view.setText(String.valueOf(gamesPlayerB));
                }
                setNumber = setNumber + 1;
                tieBreak = false;
                gamesPlayerA = 0;
                gamesPlayerB = 0;
            } else if (gamesPlayerA - gamesPlayerB == 0) {
                tieBreak = true;
            }
        }

        if (pointsPlayerA == 50 && !tieBreak) pointsA_view.setText(R.string.advantage);
        else pointsA_view.setText(String.valueOf(pointsPlayerA));
        pointsB_view.setText(String.valueOf(pointsPlayerB));
        gamesA_view.setText(String.valueOf(gamesPlayerA));
        gamesB_view.setText(String.valueOf(gamesPlayerB));
        setsA_view.setText(String.valueOf(setsPlayerA));
        setsB_view.setText(String.valueOf(setsPlayerB));
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
                    set1A_view.setText(String.valueOf(gamesPlayerA));
                    set1B_view.setText(String.valueOf(gamesPlayerB));
                }
                if (setNumber == 2) {
                    set2A_view.setText(String.valueOf(gamesPlayerA));
                    set2B_view.setText(String.valueOf(gamesPlayerB));
                }
                if (setNumber == 3) {
                    set3A_view.setText(String.valueOf(gamesPlayerA));
                    set2B_view.setText(String.valueOf(gamesPlayerB));
                }
                setNumber = setNumber + 1;
                tieBreak = false;
                gamesPlayerA = 0;
                gamesPlayerB = 0;
            } else if (gamesPlayerB - gamesPlayerA == 0) {
                tieBreak = true;
            }
        }

        pointsA_view.setText(String.valueOf(pointsPlayerA));
        if (pointsPlayerB == 50 && !tieBreak) pointsB_view.setText(R.string.advantage);
        else pointsB_view.setText(String.valueOf(pointsPlayerB));
        gamesA_view.setText(String.valueOf(gamesPlayerA));
        gamesB_view.setText(String.valueOf(gamesPlayerB));
        setsA_view.setText(String.valueOf(setsPlayerA));
        setsB_view.setText(String.valueOf(setsPlayerB));
    }

    /**
     * This method counts and displays double faults for Player A
     */
    public void doubleFaultA(View view) {
        doubleFaultsA = doubleFaultsA + 1;
        doublefaultsA_view.setText(String.valueOf(doubleFaultsA));
    }

    /**
     * This method counts and displays aces for Player A
     */
    public void aceA(View view) {
        acesA = acesA + 1;
        acesA_view.setText(String.valueOf(acesA));
    }

    /**
     * This method counts and displays unenforced errors for Player A
     */
    public void unenforcedA(View view) {
        unenforcedA = unenforcedA + 1;
        unenforcedA_view.setText(String.valueOf(unenforcedA));
    }

    /**
     * This method counts and displays enforced errors for Player A
     */
    public void enforcedA(View view) {
        enforcedA = enforcedA + 1;
        enforcedA_view.setText(String.valueOf(enforcedA));
    }

    /**
     * This method counts and displays double faults for Player B
     */
    public void doubleFaultB(View view) {
        doubleFaultsB = doubleFaultsB + 1;
        doublefaultsB_view.setText(String.valueOf(doubleFaultsB));
    }

    /**
     * This method counts and displays aces for Player B
     */
    public void aceB(View view) {
        acesB = acesB + 1;
        acesB_view.setText(String.valueOf(acesB));
    }

    /**
     * This method counts and displays unenforced errors for Player B
     */
    public void unenforcedB(View view) {
        unenforcedB = unenforcedB + 1;
        unenforcedB_view.setText(String.valueOf(unenforcedB));
    }

    /**
     * This method counts and displays enforced errors for Player B
     */
    public void enforcedB(View view) {
        enforcedB = enforcedB + 1;
        enforcedB_view.setText(String.valueOf(enforcedB));
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
        pointsA_view.setText(String.valueOf(pointsPlayerA));
        setsA_view.setText(String.valueOf(setsPlayerA));
        set1A_view.setText("");
        set2A_view.setText("");
        set3A_view.setText("");
        gamesA_view.setText(String.valueOf(gamesPlayerA));
        doublefaultsA_view.setText(String.valueOf(doubleFaultsA));
        acesA_view.setText(String.valueOf(acesA));
        unenforcedA_view.setText(String.valueOf(unenforcedA));
        enforcedA_view.setText(String.valueOf(enforcedA));
        pointsB_view.setText(String.valueOf(pointsPlayerB));
        setsB_view.setText(String.valueOf(setsPlayerB));
        set1B_view.setText("");
        set2B_view.setText("");
        set3B_view.setText("");
        gamesB_view.setText(String.valueOf(gamesPlayerB));
        doublefaultsB_view.setText(String.valueOf(doubleFaultsB));
        acesB_view.setText(String.valueOf(acesB));
        unenforcedB_view.setText(String.valueOf(unenforcedB));
        enforcedB_view.setText(String.valueOf(enforcedB));
    }
}
