package org.raflab.studsluzbadesktopclient.utils;

import java.util.Collections;
import java.util.List;

import org.raflab.studsluzbadesktopclient.datamodel.SkolskaGodina;

public class SortUtils {
	
	/*
	 * sortira skolske godine od najnovije do najstarije
	 */
	public static void sortSkolskeGodineDSC(List<SkolskaGodina> skolskeGodine) {
		Collections.sort(skolskeGodine,(s1, s2)-> s2.getPocetna()-s1.getPocetna());
	}

}
