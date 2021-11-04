package be.intec;

import java.util.Objects;

public abstract class MightMonster extends Monster{
    private int ragePoints;
    private final int maxRP;

    public MightMonster(int maxHP, int maxRP) {
        super(maxHP);
        setRagePoints(maxRP);
        this.maxRP = maxRP;
    }

    public int getRagePoints() {
        return ragePoints;
    }

    public void setRagePoints(int ragePoints) {
        this.ragePoints = ragePoints;
    }

    public void restoreRp(int pointsToRestore){
        setRagePoints(getRagePoints() + pointsToRestore);
    }

    public boolean useRp(int rpToUse){
        return getRagePoints() > rpToUse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MightMonster that = (MightMonster) o;
        return ragePoints == that.ragePoints && maxRP == that.maxRP;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ragePoints, maxRP);
    }

    @Override
    public String toString() {
        return String.format("%sMax RP: %d, Current RP: %d%n", super.toString(), maxRP, getRagePoints());
    }
}
