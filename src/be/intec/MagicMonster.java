package be.intec;

import java.util.Objects;

public abstract class MagicMonster extends Monster{
    private int magicPoints;
    private final int maxMP;

    public MagicMonster(int maxHP, int maxMP) {
        super(maxHP);
        setMagicPoints(maxMP);
        this.maxMP = maxMP;
    }

    public int getMagicPoints() {
        return magicPoints;
    }

    public void setMagicPoints(int magicPoints) {
        this.magicPoints = magicPoints;
    }

    public void restoreMp(int restoreMps){
        setMagicPoints(getMagicPoints() + restoreMps);
        if (getMagicPoints() > maxMP){
            setMagicPoints(getMagicPoints());
        }
    }

    public boolean useMP(int mpToUse){
        return getMagicPoints() > mpToUse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MagicMonster that = (MagicMonster) o;
        return magicPoints == that.magicPoints && maxMP == that.maxMP;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), magicPoints, maxMP);
    }

    @Override
    public String toString() {
        return String.format("%sMax MP: %d, Current MP: %d%n", super.toString(), maxMP, getMagicPoints());
    }
}
