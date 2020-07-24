package net.hkzlab.devices;

public class PAL16R4Specs implements PALSpecsInterface {

    @Override
    public int getNumINPins() {
        return 8;
    }

    @Override
    public int getNumIOPins() {
        return 4;
    }

    @Override
    public int getNumOUTPins() {
        return 0;
    }

    @Override
    public int getNumROUTPins() {
        return 4;
    }

    @Override
    public int getCLKPin() {
        return 1;
    }

    @Override
    public int getOEPin() {
        return 11;
    }

}