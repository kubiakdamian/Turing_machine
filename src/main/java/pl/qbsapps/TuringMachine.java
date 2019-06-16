package pl.qbsapps;

import java.util.ArrayList;

public class TuringMachine {
    private State currentState = State.Q0;

    private ArrayList<Character> increasedNumber;

    public String increaseBinaryNumberBy3(String number) {
        int i = 0;

        while (i < number.length()) {
            if (number.charAt(i) == '0') {
                increasedNumber.add(Character.valueOf(currentState.getTransitionFor0().getValue()));
            }

            i++;
        }
    }
}
