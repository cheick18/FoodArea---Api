package com.example.demo.Service;

import com.example.demo.mapper.TagMapper;
import com.example.demo.repository.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    private  TagRepository tagRepository;
    private TagMapper tagMapper;

    public TagService(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }
}
