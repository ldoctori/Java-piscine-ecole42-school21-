package classes;

import interfaces.PrePocessor;

public class PreProcessorToLowerImpl implements PrePocessor {

    @Override
    public String process(String message) {
        return message.toLowerCase();
    }
}
