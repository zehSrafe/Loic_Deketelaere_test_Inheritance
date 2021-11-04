package be.intec;

import java.util.Objects;

public class Bear extends MightMonster{
    private int holeNr;

    public Bear(){
        this(150);
    }

    public Bear(int hp){
        this(hp, 200);
    }

    public Bear(int hp, int rageP){
        this(hp, rageP, 911);
    }

    public Bear(int maxHP, int maxMP, int holeNr) {
        super(maxHP, maxMP);
        this.holeNr = holeNr;
    }

    public int bearClawAttack(){
        if (super.useRp(8)){
            super.setRagePoints(super.getRagePoints() - 8);
            System.out.println("Bear attacks! roar!!");
            return 10;
        } else {
            System.out.println("Bear attacks! out of Rage points");
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bear bear = (Bear) o;
        return holeNr == bear.holeNr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), holeNr);
    }

    @Override
    public String toString() {
        return String.format("Bear: %d%n%s", holeNr, super.toString());
    }
}
