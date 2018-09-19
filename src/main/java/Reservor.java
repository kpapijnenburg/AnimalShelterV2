import java.util.Date;

public class Reservor {

    public String name;
    public Date reservedAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(Date reservedAt) {
        this.reservedAt = reservedAt;
    }

    public Reservor(String name, Date reservedAt) {
        this.name = name;
        this.reservedAt = reservedAt;
    }
}
