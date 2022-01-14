package c0921g1.service;

import c0921g1.model.Setting;

import java.util.List;

public interface ISettingService {
    public List<Setting> findAll();
    public void save(Setting setting);
    public void edit(Setting setting);
    public Setting selectSetting(int index);
    public List<String> showLanguage();
    public List<Integer> showPage();
}
