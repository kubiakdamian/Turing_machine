package pl.qbsapps;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum State {

    Q0("Q0"), Q1("Q1"), Q2("Q2"), Q3("Q3"), Q4("Q4");
    private String name;
}
