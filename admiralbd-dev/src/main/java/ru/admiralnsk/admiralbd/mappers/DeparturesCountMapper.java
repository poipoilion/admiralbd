package ru.admiralnsk.admiralbd.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.admiralnsk.admiralbd.models.DeparturesCount;

import java.sql.ResultSet;
import java.sql.SQLException;

@Deprecated
public class DeparturesCountMapper implements RowMapper<DeparturesCount> {
    @Override
    public DeparturesCount mapRow(ResultSet resultSet, int i) throws SQLException {
        DeparturesCount departuresCount = new DeparturesCount();

        departuresCount.setName(resultSet.getString(1));
        departuresCount.setValue(resultSet.getInt(2));

        return departuresCount;
    }
}
