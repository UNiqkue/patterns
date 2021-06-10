package nik.behavior.chain_of_responsibility;

import nik.behavior.model.ChainResult;

public interface Chain<T> {

    ChainResult start(T t);

    default Chain<T> addNext(Chain<T> nextValidator) {
        return (t) ->
                start(t).concat(nextValidator.start(t));
    }

}
