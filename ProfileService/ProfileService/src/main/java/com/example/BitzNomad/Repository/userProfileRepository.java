package com.example.BitzNomad.Repository;



import com.example.BitzNomad.Entity.UserProfile;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface userProfileRepository extends Neo4jRepository<UserProfile,String> {
}
