package c0921g1.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    Map<String,String> dictionaryList = new HashMap<>();
    {
        dictionaryList.put("hello","Xin Chao");
        dictionaryList.put("dog","Con Cho");
        dictionaryList.put("cat","Con Meo");
        dictionaryList.put("house","Ngoi Nha");
    }
    @Override
    public String translate(String keyword) {
        return dictionaryList.get(keyword.toLowerCase());
    }
}
