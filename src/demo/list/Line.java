package demo.list;

import java.util.List;

public class Line {

    private List<String> people;

    public Line(List<String> people) {
        this.people = people;
    }

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }

    public Line() {
    }

    @Override
    public String toString() {
        return "Line{" +
                "people=" + people +
                '}';
    }
}
