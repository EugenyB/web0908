package com.example.web0908.data;

import lombok.AllArgsConstructor;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
public class ArtistDao {
    private DataSource ds;

    public List<Artist> findAll() {
        try (Connection connection = ds.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from artist")) {
            List<Artist> artists = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("ArtistId");
                String name = resultSet.getString("Name");
                artists.add(new Artist(id, name));
            }
            return artists;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void add(Artist artist) {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement("insert into artist (Name) values (?)")
        ) {
            ps.setString(1, artist.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
