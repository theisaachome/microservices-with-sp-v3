package com.isaachome.services;
import com.isaachome.dto.AuthorDTO;
import com.isaachome.entity.Author;
import com.isaachome.repos.AuthorRepos;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl  implements  AuthorService{

    private  final AuthorRepos authorRepos;
    private  final ModelMapper modelMapper;

    public AuthorServiceImpl(AuthorRepos authorRepos, ModelMapper modelMapper) {
        this.authorRepos = authorRepos;
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO dto) {
        var savedBook = authorRepos.save(modelMapper.map(dto, Author.class));
        return modelMapper.map(savedBook, AuthorDTO.class);
    }

    @Override
    public List<AuthorDTO> getAll() {
        return authorRepos.findAll().stream().map(it-> modelMapper.map(it,AuthorDTO.class)).collect(Collectors.toList());
    }

    @Override
    public AuthorDTO updateAuthor(Long author_id, AuthorDTO dto) {
        return null;
    }

    @Override
    public AuthorDTO getAuthor(Long author_id) {
        var author =  authorRepos.findById(author_id).orElseThrow(()->new RuntimeException("Author : Not Found"));
        return  modelMapper.map(author, AuthorDTO.class);
    }
}
