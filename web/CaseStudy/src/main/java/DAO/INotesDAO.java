package DAO;

import DTO.NoteDTO;

import java.sql.Connection;
import java.util.List;

public interface INotesDAO {
    List<NoteDTO> selectAllNote();
}
