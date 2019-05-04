package net.greet;

public enum Languages {
    ISIXHOSA("Mholo "),
    ENGLISH("Hello "),
    ISIZULU("Sawubona ");

     String greetType;

    Languages(String greetType) {
        this.greetType = greetType;
    }
    public String getLang() {
        return greetType;
    }
}


