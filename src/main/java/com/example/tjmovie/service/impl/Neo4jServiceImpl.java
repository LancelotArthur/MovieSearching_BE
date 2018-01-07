package com.example.tjmovie.service.impl;

import com.example.tjmovie.service.Neo4jService;
import com.example.tjmovie.util.ResJsonTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class Neo4jServiceImpl implements Neo4jService{

    @Override
    public ResJsonTemplate findActorsByDirector(String tag) {
        List<String> strings = new ArrayList<>();
        try {
            Class.forName("org.neo4j.jdbc.Driver");
            // Connect
            Connection con = DriverManager.getConnection("jdbc:neo4j:http://localhost:7474/","neo4j", "admin");
            String sql = "MATCH (actor:actor)-[act:act]->(movie:movie)<-[direct:direct]-(director{director: \"" + tag + "\"})\n" +
                    "RETURN actor, COUNT(actor) as actorNumber;";
            Statement stmt = con.createStatement();
            long startTime = System.currentTimeMillis();
            ResultSet rs = stmt.executeQuery(sql);
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            while (rs.next()) {
                strings.add(rs.getString("actor") + " Number : " + rs.getString("actorNumber"));
            }
            strings.add("Time : " + runTime);
        }
        catch (Exception e){
            System.out.print(e);
        }
        return new ResJsonTemplate<>("200", strings);
    }

    @Override
    public ResJsonTemplate findMoviesByActor(String tag) {
        List<String> strings = new ArrayList<>();
        try {
            Class.forName("org.neo4j.jdbc.Driver");
            // Connect
            Connection con = DriverManager.getConnection("jdbc:neo4j:http://localhost:7474/","neo4j", "admin");
            String sql = "MATCH (actor{actor:\"" + tag + "\"})-[act:act]->(movie:movie)" +
                    "RETURN COUNT (movie) as movieNumber;";
            Statement stmt = con.createStatement();
            long startTime = System.currentTimeMillis();
            ResultSet rs = stmt.executeQuery(sql);
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            while (rs.next()) {
                strings.add(" Number : " + rs.getString("movieNumber"));
            }
            strings.add("Time : " + runTime);
        }
        catch (Exception e){
            System.out.print(e);
        }
        return new ResJsonTemplate<>("200", strings);
    }

    @Override
    public ResJsonTemplate findMoviesByDirector(String tag) {
        List<String> strings = new ArrayList<>();
        try {
            Class.forName("org.neo4j.jdbc.Driver");
            // Connect
            Connection con = DriverManager.getConnection("jdbc:neo4j:http://localhost:7474/","neo4j", "admin");
            String sql = "MATCH (director{director:\"" + tag + "\"})-[direct:direct]->(movie:movie)" +
                    "RETURN COUNT(movie) as movieNumber;";
            Statement stmt = con.createStatement();
            long startTime = System.currentTimeMillis();
            ResultSet rs = stmt.executeQuery(sql);
            long endTime = System.currentTimeMillis();
            long runTime = endTime - startTime;
            while (rs.next()) {
                strings.add(" Number : " + rs.getString("movieNumber"));
            }
            strings.add("Time : " + runTime);
        }
        catch (Exception e){
            System.out.print(e);
        }
        return new ResJsonTemplate<>("200", strings);
    }
}
