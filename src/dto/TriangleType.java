package dto;

public enum TriangleType {

    EQUILATERAL("Equilateral"), ISOSCELES("Isosceles"), SCALENE("Scalene");

    private final String name;

    TriangleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
