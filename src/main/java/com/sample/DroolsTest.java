package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 *  
 *  . Stateless session that forms the simplest use case, not utilizing inference. A stateless session can be called like a function, passing it some data and then receiving some results back. Stateful sessions are longer lived and allow iterative changes over time. Next we execute the same rule file in stateful and stateless session environment and understand the difference.
 **/
public class DroolsTest {

	public static final void main(String[] args) {
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			//get stateful session
			KieSession kSession = kContainer.newKieSession("ksession-rule");

			Counter counter1 = new Counter(1, "cnt1");
			Counter counter2 = new Counter(2, "cnt2");

			System.out.println("fire rules after inserting counter1");
			kSession.insert(counter1);
			//fire rules with counter1
			kSession.fireAllRules();

			System.out.println("fire rules after inserting counter2");
			kSession.insert(counter2);
			//fire rules with already existing counter1 and newly inserted counter2
			kSession.fireAllRules();

			//Dispose the session at the end.
			kSession.dispose();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}