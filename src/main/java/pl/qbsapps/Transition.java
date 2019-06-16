package pl.qbsapps;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class Transition {
    private int value;

    private State nextState;

    private Direction direction;
}
