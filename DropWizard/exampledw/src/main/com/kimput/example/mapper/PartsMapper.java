package main.com.kimput.example.mapper;

import main.com.kimput.example.model.Part;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PartsMapper implements ResultSetMapper<Part> {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CODE = "code";

    @Override
    public Part map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Part(resultSet.getInt(ID), resultSet.getString(NAME), resultSet.getString(CODE));
    }
}
