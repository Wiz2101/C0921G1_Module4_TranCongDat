package c0921g1.service;

import c0921g1.model.Setting;
import c0921g1.repository.ISettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingService implements ISettingService {
    @Autowired
    ISettingRepository settingRepository;

    @Override
    public List<Setting> findAll() {
        return settingRepository.findAll();
    }

    @Override
    public void save(Setting setting) {
        settingRepository.save(setting);
    }

    @Override
    public void edit(Setting setting) {
        settingRepository.edit(setting);
    }

    @Override
    public Setting selectSetting(int index) {
        return settingRepository.selectSetting(index);
    }

    public List<String> showLanguage() {
        return settingRepository.showLanguage();
    }

    public List<Integer> showPage() {
        return settingRepository.showPage();
    }
}
