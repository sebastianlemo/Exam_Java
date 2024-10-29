package com.jhoanlemos.ideas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jhoanlemos.ideas.models.Idea;
import com.jhoanlemos.ideas.models.User;
import com.jhoanlemos.ideas.repositories.IdeaRepository;

@Service
public class IdeaService {
    private final IdeaRepository ideaRepository;

    public IdeaService(IdeaRepository ideaRepository) {
        this.ideaRepository = ideaRepository;
    }

    public List<Idea> findAll(){
        return ideaRepository.findAll();
    }

    public boolean save( Idea idea, User user) {
        user.getId();
        idea.setUser(user);
        return ideaRepository.save(idea)!=null;
    }

    public Idea findById(Long id) {
        Optional<Idea> idea = ideaRepository.findById(id);
        return idea.isPresent() ? idea.get() : null;
    }
    
    public boolean update(Long ideaId, Idea ideaUpdate, User user){
        Idea oldIdea = findById(ideaId);
        if (oldIdea == null) {
            return false;
        }
        ideaUpdate.setId(oldIdea.getId());
        save(ideaUpdate, user);
        return true;
    }
}
