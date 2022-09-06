public enum Rim {
    I("1"), II("2"), III("3"), IV("4"), IX("9"), V("5"), VI("6"), VII("7"), VIII("8"), X("10"),
    XX("20"), XXX("30"), XL("40"), L("50"), LX("60"), LXX("70"), LXXX("80"), XC("90"), C("100");

    private String nu;

    Rim(String nu) {
        this.nu = nu;
    }
    public String getNu() {
        return nu;
    }
}
