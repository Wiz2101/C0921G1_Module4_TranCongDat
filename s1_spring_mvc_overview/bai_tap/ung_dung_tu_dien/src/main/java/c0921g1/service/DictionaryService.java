package c0921g1.service;

import c0921g1.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {

    @Autowired
    IDictionaryRepository dictionaryRepository;


    @Override
    public String translate(String keyword) {
        return dictionaryRepository.translate(keyword);
    }
}
