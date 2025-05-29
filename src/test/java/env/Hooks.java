package env;

import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void beforeHook(){
        System.out.println("Before Hooks");
    }
}
