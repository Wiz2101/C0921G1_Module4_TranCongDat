package com.codegym.repository;

import com.codegym.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository implements IPersonRepository {
    static List<Person> personList = new ArrayList<>();

    static {
        personList.add(new Person("NGUYEN VAN A","1996","Nam","Viet Nam","0201231321","TauThuyen","92C1-14212","1","2022/01/13","2022/01/14","Khong","Quang Nam","Thanh Pho Hoi An","Minh An","37 Tran Phu","0935666493","dattran2101@gmail.com",false,true,true,false,true,true,false,false,false,false));
        personList.add(new Person("TRAN THANH B","1994","Nu","Viet Nam","0201123221","Oto","92A-22211","5","2022/01/13","2022/01/14","Khong","Quang Nam","Thanh Pho Hoi An","Minh An","212 Phan Chu Trinh","0935666493","dattran2101@gmail.com",false,true,true,false,true,true,false,false,false,false));
    }
    @Override
    public List<Person> findAll() {
        return personList;
    }

    @Override
    public void createPerson(Person person) {
        personList.add(person);
    }
}
