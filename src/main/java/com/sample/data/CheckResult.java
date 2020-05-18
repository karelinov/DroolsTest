package com.sample.data;

import java.util.HashMap;

/**
 * 
 * @author Helg
 * Класс для фиксации результатов проверок
 *
 */
public class CheckResult {

	/**
	 * ФЛ
	 */
	public Person person;
	
	
	/**
	 * Тип проверяемого атома
	 * 
	 */
	public AtomType atom_type;
	
	/**
	 * ID данных
	 * - Для ЛК - это citizen_benefit_cat.benefit_cat_pk
	 */
	public String atom_id;
	
	
	/**
	 * Результат
	 */
	public Boolean result = false;
	
	
	
	
	/**
	 * Накапливаемый список проверок
	 */
	public HashMap<String,RuleResult> RuleResults = new HashMap<String,RuleResult>(); 
	
	/**
	 * Вычисляет результат
	 */
	public Boolean ConsiderResult() {
		this.result = true;
				
		return this.result;
	}
	
	/**
	 * Конструктор
	 */
	public CheckResult(Person person, AtomType atom_type, String atom_id) {
		this.person = person;
		this.atom_type = atom_type;
		this.atom_id = atom_id;
	}
	
	/**
	 * Запись результата выполнения условия
	 * @param rule
	 * @param level
	 * @param result
	 */
	public void setRuleResult(String rule, int level, Boolean result) {
		RuleResults.merge(rule, new RuleResult(level, rule, result), (k,v) -> v);
	}
	

	/**
	 * 
	 * @author Helg
	 * Класс для фиксации результатов отдельной проверки
	 *
	 */
	public class RuleResult {
		/**
		 * Условный уровень вложенности проверки
		 */
		public int level;
		/**
		 * Описание проверки
		 */
		public String description;
		/**
		 * Результат
		 */
		public Boolean result;
		
		public RuleResult(int level, String description, Boolean result) {
			this.level = level;
			this.description = description;
			this.result = result;
		}
	}

}
