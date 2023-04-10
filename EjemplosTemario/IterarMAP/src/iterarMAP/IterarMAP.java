package iterarMAP;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class IterarMAP {

	public static void main(String[] args) {

		Map<String, Integer> mapa = new HashMap<>();
		mapa.put("Jose", 10);
		mapa.put("Miguel", 5);
		mapa.put("Manuel", 0);
		mapa.put("Miguel", 8);

		Set<String> claves = mapa.keySet();

		for (String clave : claves) {
			System.out.println(clave + ": " + mapa.get(clave));
		}

		Iterator<String> it = claves.iterator();
		while (it.hasNext()) {
			String clave = it.next();
			System.out.println(clave + ": " + mapa.get(clave));
		}

		// Map<String, Integer> m = Map.of("Jose", 1, "Pepe", 9);
		mapa.values().forEach(System.out::println);

		for (Entry<String, Integer> e : mapa.entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}

	}

}
