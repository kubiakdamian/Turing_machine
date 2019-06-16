package pl.qbsapps;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Direction {
    LEFT("L"),
    RIGHT("R"),
    STOP("STOP");

    private String direction;
}
