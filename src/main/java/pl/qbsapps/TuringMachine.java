package pl.qbsapps;

import java.util.ArrayList;
import java.util.Collections;

class TuringMachine {
    private State currentState;

    private ArrayList<Integer> increasedNumber;
    private ArrayList<State> statesHistory;

    void increaseBinaryNumberBy3(String number) {
        int i = 0;
        initialize();
        number = new StringBuilder(number).reverse().toString();

        while (i < number.length()) {
            statesHistory.add(currentState);
            TransitionTable transitionTable = getTransitionByState(currentState);
            Transition transition;

            printCurrentData(number, i, currentState);

            if (number.charAt(i) == '0') {
                transition = transitionTable.getTransitionFor0();
                increasedNumber.add(transition.getValue());
                currentState = transition.getNextState();
            } else if (number.charAt(i) == '1') {
                transition = transitionTable.getTransitionFor1();
                increasedNumber.add(transition.getValue());
                currentState = transition.getNextState();
            } else {
                transition = transitionTable.getTransitionForEmpty();
                increasedNumber.add(transition.getValue());
                currentState = transition.getNextState();
            }

            if (transition.getDirection().equals(Direction.LEFT)) {
                i++;
            } else if (transition.getDirection().equals(Direction.RIGHT)) {
                i--;
            } else if (transition.getDirection().equals(Direction.STOP)) {
                break;
            }
        }

        if (currentState.getName().equals("Q4")) {
            increasedNumber.add(1);
            statesHistory.add(State.Q4);
        }

        printNumber();
        printStatesHistory();
    }

    private TransitionTable getTransitionByState(State state) {
        switch (state.getName()) {
            case "Q0":
                return TransitionTable.Q0;
            case "Q1":
                return TransitionTable.Q1;
            case "Q2":
                return TransitionTable.Q2;
            case "Q3":
                return TransitionTable.Q3;
            case "Q4":
                return TransitionTable.Q4;
            default:
                return TransitionTable.Q0;
        }
    }

    private void printNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        Collections.reverse(increasedNumber);

        for (Integer number : increasedNumber) {
            stringBuilder.append(number);
        }

        System.out.println(stringBuilder.toString());
    }

    private void printStatesHistory() {
        StringBuilder stringBuilder = new StringBuilder();

        for (State state : statesHistory) {
            stringBuilder.append(state.getName()).append(" -> ");
        }

        stringBuilder.setLength(stringBuilder.length() - 3);

        System.out.println(stringBuilder.toString());
    }

    private void initialize() {
        increasedNumber = new ArrayList<>();
        statesHistory = new ArrayList<>();
        currentState = State.Q0;
    }

    private void printCurrentData(String number, int i, State currentState) {
        System.out.println("Current position: " + number.charAt(i) + " Current state: " + currentState.getName());
    }
}
