package com.junyu;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheTest {

    public static void main(String[] args) {

        // 1. create cache manager
        CacheManager cacheManager = CacheManager.create("./src/main/resources/ehcache.xml");

        // 2. get cache instance
        Cache cache = cacheManager.getCache("HelloWorldCache");

        // 3. create element
        Element element = new Element("key1", "value1");

        // 4. add element to cache
        cache.put(element);

        // 5. get cache
        Element value = cache.get("key1");
        System.out.println(value);
        System.out.println(value.getObjectValue());

        // 6. remove element
        cache.remove("key1");

        // value is a object
        Person person = new Person();
        person.setId(1);
        person.setName("junyu");
                
        // 3. create element
        Element element1 = new Element("person1", person);
        cache.put(element1);
        
        Element value1 = cache.get("person1");
        Person person1 =  (Person) value1.getObjectValue();
        System.out.println(person1);
        
        // 7. flush cache
        cache.flush();

        // 8. close cache manager
        cacheManager.shutdown();
    }
}
