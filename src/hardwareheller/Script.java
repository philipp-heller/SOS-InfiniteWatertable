package hardwareheller;

import script.SCRIPT;

public class Script implements SCRIPT {

    @Override
    public CharSequence desc() {
        return "Enables infinite canal digging.";
    }

    @Override
    public SCRIPT_INSTANCE initAfterGameCreated() {
        return new Instance();
    }

    @Override
    public void initBeforeGameCreated() {

    }

    @Override
    public CharSequence name() {
        return "Infinite Water Table";
    }
    
}
