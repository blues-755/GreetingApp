package net.greet;

public enum Languages {
    ISIXHOSA("Mholo "),
    ENGLISH("Hello "),
    ISIZULU("Sawubona ");

     String greet;

    Languages(String greet) {
        this.greet = greet;
    }
    public String getUsername(String name) {
        return greet + name;
    }
}


