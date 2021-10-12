package com.fox.view;

import java.sql.SQLException;

@FunctionalInterface
public interface Printable {
    void print() throws SQLException;
}
