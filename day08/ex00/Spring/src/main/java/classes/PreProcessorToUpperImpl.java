package classes;

import interfaces.PrePocessor;

public class PreProcessorToUpperImpl implements PrePocessor {
    @Override
    public String process(String message) {
        return (message.toUpperCase());
    }
}
