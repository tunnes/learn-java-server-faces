package beans;

import java.util.Random;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "numberGenerator")
@RequestScoped
public class NumberGenerator{

    private int number;
    private int range;

    public NumberGenerator() {
        range = 100;
        number = new Random().nextInt(range);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String randomize() {
        number = new Random().nextInt(range);
        return null;
    }
}
