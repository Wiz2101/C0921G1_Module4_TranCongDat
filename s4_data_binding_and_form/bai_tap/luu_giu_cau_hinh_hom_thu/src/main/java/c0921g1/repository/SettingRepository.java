package c0921g1.repository;

import c0921g1.model.Setting;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class SettingRepository implements ISettingRepository {
    static List<Setting> settingList = new ArrayList<>();
    static {
        settingList.add(new Setting("English",5,true,"ABC"));
        settingList.add(new Setting("Chinese",10,false,"XYZ"));
        settingList.add(new Setting("Vietnamese",50,true,"QWERTY"));
    }

    @Override
    public List<Setting> findAll() {
        return settingList;
    }

    @Override
    public void save(Setting setting) {
        settingList.add(setting);
    }

    @Override
    public void edit(Setting setting) {
        int index = settingList.indexOf(setting);
        if (index >= 0){
            settingList.set(index,setting);
        }
    }

    @Override
    public Setting selectSetting(int index) {
        for (int i = 0; i < settingList.size(); i++) {
            if (i == index){
                return settingList.get(i);
            }
        }
        return null;
    }

    public List<String> showLanguage() {
        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        return languageList;
    }


    public List<Integer> showPage() {
        List<Integer> pageList = new ArrayList<>();
        pageList.add(5);
        pageList.add(10);
        pageList.add(15);
        pageList.add(25);
        pageList.add(50);
        pageList.add(100);
        return pageList;
    }
}
