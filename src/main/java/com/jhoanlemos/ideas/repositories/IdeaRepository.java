package com.jhoanlemos.ideas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jhoanlemos.ideas.models.Idea;



@Repository
public interface IdeaRepository extends CrudRepository <Idea, Long> {
    List<Idea> findAll();
}
