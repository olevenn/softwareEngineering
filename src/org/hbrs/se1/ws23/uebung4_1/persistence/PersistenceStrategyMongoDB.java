package org.hbrs.se1.ws23.uebung4_1.persistence;

import java.io.IOException;
import java.util.List;

public class PersistenceStrategyMongoDB<E> implements PersistenceStrategy<E> {
    @Override
    public void openConnection() throws PersistenceException {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void closeConnection() throws PersistenceException {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void save(List<E> member) {
        throw new UnsupportedOperationException("Not implemented!");

    }

    @Override
    public List<E> load() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void loadd() throws IOException {
        throw new UnsupportedOperationException("Not implemented!");
    }
}
