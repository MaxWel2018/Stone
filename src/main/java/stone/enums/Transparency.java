package stone.enums;

public enum Transparency {
    FL(0),
    IF(1),
    VVS1(2),
    VVS2(3),
    VS1(4),
    VS2(5),
    SI1(6),
    SI2(7),
    I1(8),
    I2(9),
    I3(10);



    private final int rankingPosition;

    Transparency(int rankingPosition) {
        this.rankingPosition = rankingPosition;
    }

    public int getRankingPosition() {
        return rankingPosition;
    }
}
