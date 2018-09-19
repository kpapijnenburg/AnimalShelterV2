import java.util.Date;

public class Dog extends Animal {

    public Date lastWalk;
    public boolean needsWalk;

    public Date getLastWalk() {
        return lastWalk;
    }

    public void setLastWalk(Date lastWalk) {
        this.lastWalk = lastWalk;
    }


    public boolean isNeedsWalk() {
        return new Date().getDay() - this.lastWalk.getDay() > 0;
    }

    public void setNeedsWalk(boolean needsWalk) {
        this.needsWalk = needsWalk;
    }


    public Dog(String name, Gender gender) {
        super(name, gender);
        this.lastWalk = new Date();
    }

    @Override
    public String toString() {
        return super.toString() + "last walk :" + this.lastWalk.toString();
    }
}
