package by.bsu.nik.behavior.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChainResult {

    private final List<String> messages;

    private boolean valid = true;

    private ChainResult() {
        messages = new ArrayList<>();
    }

    public static ChainResult withMessage(String message) {
        return new ChainResult().addMessage(message);
    }

    public static ChainResult withError(String error) {
        return new ChainResult().addError(error);
    }

    public static ChainResult ok() {
        return new ChainResult();
    }

    public ChainResult addMessage(String message) {
        messages.add(message);
        return this;
    }
    public ChainResult addError(String error) {
        valid = false;
        messages.add(error);
        return this;
    }

    public List<String> getAllMessages() {
        return Collections.unmodifiableList(messages);
    }

    public ChainResult concat(ChainResult chainResult) {
        valid &= chainResult.isValid();
        messages.addAll(chainResult.getAllMessages());
        return this;
    }


    public boolean isValid() {
        return valid;
    }

    public boolean isNotValid() {
        return !valid;
    }

    @Override
    public String toString() {
        return "ValidationResult{" +
                "messages=" + messages +
                ", valid=" + valid +
                '}';
    }
}