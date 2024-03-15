package DAO;

import model.ModelSource;

import java.sql.SQLException;
import java.util.List;

public interface IDAO {
    void insert(ModelSource modelSource)throws SQLException;

    ModelSource selectModel (int id);

    boolean deleteModel(String id) throws SQLException;

    boolean updateModel(ModelSource modelSource) throws SQLException;

    List<ModelSource> searchByName(String key);

    ModelSource getModelById(String id);
}
