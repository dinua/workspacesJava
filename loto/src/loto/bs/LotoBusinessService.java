package loto.bs;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import loto.ps.LotoPersistenceService;
import loto.psconf.Extragere6;

public class LotoBusinessService {
 
	private LotoPersistenceService lotoPersistenceService=new LotoPersistenceService();
	private Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	private TreeMap<Integer,Integer> sorted_map;
	
	public Map<Integer,Integer> generateMap(){
		final int n=49;
	      for(int i=1;i<=n;i++){
	    	  map.put(i, 0);
	      }
	 	 Iterator<Extragere6> ita=lotoPersistenceService.selectAllExtrageri6().iterator();
		 while(ita.hasNext()){
			 Extragere6 e=ita.next();
			updateValueMap(e.getNumar1());
			updateValueMap(e.getNumar2());
			updateValueMap(e.getNumar3());
			updateValueMap(e.getNumar4());
			updateValueMap(e.getNumar5());
			updateValueMap(e.getNumar6());
			 
		 }
		sortMap();
		return map;
	}


	private void updateValueMap(int key) {
		 int a= map.get(key);
		 map.put(key, a+1);
	}

	private void sortMap(){
		ValueComparator bvc =  new ValueComparator(map);
        sorted_map = new TreeMap<Integer,Integer>(bvc);
        sorted_map.putAll(map);
	}
	
	public  Set<Map.Entry<Integer,Integer>> big6(){
		generateMap();
		sortMap();
		int limit=getValueLow6(sorted_map.values());
    Set<Map.Entry<Integer,Integer>>set=	sorted_map.entrySet();
    Set<Map.Entry<Integer,Integer>>result=	new LinkedHashSet<Map.Entry<Integer,Integer>>();
    for (Entry<Integer, Integer> entry : set) {
    	if(entry.getValue()>=limit)
    		result.add(entry);
	}
    afiseaza(result);
    
    
    return result;
	}
	
	private int getValueLow6(Collection<Integer> values) {
          int ct=0;
          int first=0;
          Iterator<Integer> it=values.iterator();
          while(it.hasNext() && ct <6){
        	  int nr=it.next();
        	  if(nr!=first) 
        		   ct++;
        	       first=nr;
          }
          return first;
	}

private void afiseaza(Set<Map.Entry<Integer,Integer>> set){
	int first=0;
	for (Entry<Integer, Integer> entry : set) {
		
		int value=entry.getValue();
		if(value!=first){
			first=value;
			System.out.println();
			System.out.print(" Value  "+value+" : ");
		}
		System.out.print(entry.getKey()+" , ");
		
	}
}
}
