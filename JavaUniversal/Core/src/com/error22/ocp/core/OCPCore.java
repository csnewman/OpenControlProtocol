package com.error22.ocp.core;

import gnu.io.CommPortIdentifier;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class OCPCore {

	public static List<String> getPorts() {
		List<String> ports = new ArrayList<String>();

		Enumeration portList = CommPortIdentifier.getPortIdentifiers();
		while (portList.hasMoreElements()) {
			ports.add(((CommPortIdentifier) portList.nextElement()).getName());
		}

		return ports;
	}

}
