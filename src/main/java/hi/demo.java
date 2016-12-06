package hi;


class Demo {

    final int demoNumber;

    Demo(int number) {
        this.demoNumber = number;
    }

    public String printedNumber() {
        int[] x = new int[12];
        int l = x.length;
        return "number is " + demoNumber;
    }
}
