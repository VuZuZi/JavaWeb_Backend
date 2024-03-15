package DAO;

import model.ModelSource;

import java.sql.SQLException;
import java.util.List;

public class DAO implements IDAO {
    @Override
    public void insert(ModelSource modelSource) throws SQLException {

    }

    @Override
    public ModelSource selectModel(int id) {
        return null;
    }

    @Override
    public boolean deleteModel(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateModel(ModelSource modelSource) throws SQLException {
        return false;
    }

    @Override
    public List<ModelSource> searchByName(String key) {
        return null;
    }

    @Override
    public ModelSource getModelById(String id) {
        return null;
    }
}
