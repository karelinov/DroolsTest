package com.sample;

import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.data.AtomType;
import com.sample.data.CheckResult;

/**
 * This is a sample class to launch a rule.
 */
public class DRLTest {

    public static final void main(String[] args) {
    	KieRuntimeLogger kieLogger = null;
    	
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	kieLogger = ks.getLoggers().newConsoleLogger(kSession);
        	
        	InsertData.Insert1(kSession);
        	
        	// Результаты проверки корректности ЛК
            CheckResult checkResult = new CheckResult(null, AtomType.BENEFIT_CATEGORY, "1001");
            kSession.setGlobal("checkResult", checkResult);
        	

            // go !
            kSession.fireAllRules();
            kieLogger.close();
            
            // Смотрим результаты
            System.out.println("checkResult.result = "+checkResult.result);
            
            
        } catch (Throwable t) {
            t.printStackTrace();
        }
        finally {
        	if (kieLogger != null) kieLogger.close();
        }
    }


}
