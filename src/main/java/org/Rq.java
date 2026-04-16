package org;

public class Rq {
    private String cmd;
    private String[] cmdBits;

    public Rq(String cmd) {
        this.cmd = cmd;
        this.cmdBits = cmd.split(" ", 2);
    }

    public String getActionName() {
        return cmdBits[0];
    }

    public boolean hasArg() {
        return (cmdBits.length > 1 && !cmdBits[1].isBlank());
    }

    public String getArg() {
        return hasArg() ? cmdBits[1].trim() : "";
    }

    public int getArgAsInt() {
        try {
            return Integer.parseInt(getArg().split(" ")[0]);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
