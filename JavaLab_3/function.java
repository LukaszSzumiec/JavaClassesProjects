public class function {
    String name;
    String shortcut;
    function(String name, String shortcut){
        this.name=name;
        this.shortcut=shortcut;
    }
    public String toString() {
        return name;
    }
    public String getShortcut(){
        return shortcut;
    }
}
