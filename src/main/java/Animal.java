import java.util.Date;

public class Animal {

    public String name;
    public Gender gender;
    public Reservor reservedBy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Reservor getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(Reservor reservedBy) {
        this.reservedBy = reservedBy;
    }

    public Animal(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public boolean reserve(String reservedBy) {
        if (this.reservedBy == null) {
            this.reservedBy = new Reservor
                    (reservedBy, new Date());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String reserved = "not reserved";
        if (this.reservedBy != null) {
            reserved = "reserved by " + this.reservedBy.name;
        }
        return this.name + ", " + this.gender.toString() + ", " + reserved + ", ";
    }
}
