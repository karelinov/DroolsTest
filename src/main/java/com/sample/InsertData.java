package com.sample;

import java.time.Period;

import org.kie.api.runtime.KieSession;

import com.sample.data.AtomType;
import com.sample.data.CheckResult;
import com.sample.data.Person;
import com.sample.data.PersonData;

/**
 * This is a sample class to launch a rule.
 */
public class InsertData {

    public static final void Insert1(KieSession kSession) {

            // Проверяемое ФЛ
        	Person person = new Person(1);
            kSession.insert(person);
            // Атом ЛК 1001
            PersonData personData = new PersonData(person.person_pk);
            personData.atom_type = AtomType.BENEFIT_CATEGORY;
            personData.atom_id = "1001";
            personData.atom_state = true;
            personData.atom_value = true;
            kSession.insert(personData);
            
            // Другие ФЛ семьи
            Person person2 = new Person(2);
            kSession.insert(person2);
            // Атом ЛК 1002
            PersonData personData2 = new PersonData(person2.person_pk);
            personData2.atom_type = AtomType.BENEFIT_CATEGORY;
            personData2.atom_id = "1002";
            personData2.atom_state = true;
            personData2.atom_value = true;
            kSession.insert(personData2);
            // Атом 010012 Возраст
            personData2 = new PersonData(person2.person_pk);
            personData2.atom_type = AtomType.UZSFO;
            personData2.atom_id = "010012";
            personData2.atom_state = true;
            personData2.atom_value = Period.parse("P12Y");
            kSession.insert(personData2);
            
    }

}
