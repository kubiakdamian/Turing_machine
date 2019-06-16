package pl.qbsapps;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum State {

    Q0("Q0", new Transition(1, State.Q1, Direction.LEFT),
            new Transition(0, State.Q2, Direction.LEFT), new Transition(1, State.Q1, Direction.LEFT)),

    Q1("Q1", new Transition(1, State.Q3, Direction.LEFT),
            new Transition(0, State.Q4, Direction.LEFT), new Transition(1, State.Q3, Direction.LEFT)),

    Q2("Q2", new Transition(0, State.Q4, Direction.LEFT),
            new Transition(1, State.Q4, Direction.LEFT), new Transition(0, State.Q4, Direction.LEFT)),

    Q3("Q3", new Transition(0, State.Q3, Direction.LEFT),
            new Transition(1, State.Q3, Direction.LEFT), new Transition(-1, State.Q3, Direction.STOP)),

    Q4("Q4", new Transition(1, State.Q3, Direction.LEFT),
            new Transition(0, State.Q4, Direction.LEFT), new Transition(1, State.Q3, Direction.STOP));

    private String name;
    private Transition transitionFor0;
    private Transition transitionFor1;
    private Transition transitionForEmpty;
}
