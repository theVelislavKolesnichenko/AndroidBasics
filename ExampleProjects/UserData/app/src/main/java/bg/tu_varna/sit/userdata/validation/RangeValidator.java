package bg.tu_varna.sit.userdata.validation;

public class RangeValidator {

    private double min, max;

    public RangeValidator(double min,
                          double max) {
        this.min = min;
        this.max = max;
    }

    public boolean validate(double number) {
        return min <= number &&
                number <= max;
    }
}
