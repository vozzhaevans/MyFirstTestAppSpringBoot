package ru.vozzhaeva.MyFirstTestAppSpringBoot.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ArrayListController {

    private List<String> arrayList = null;

    private Map<Integer, String> hashMap = null;

    private int counter = 0;

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam("s") String s) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(s);
        return "Текущий список: " + arrayList;
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {

        if (arrayList == null) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam("s") String s) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        counter++;
        hashMap.put(counter, s);

        return "Текущая карта: " + hashMap;
    }
    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        if (hashMap == null) {
            return new HashMap<>();
        }
        return hashMap;
    }
    @GetMapping("/show-all-lenght")
    public String showAllLenght() {
        int arraySize = (arrayList == null) ? 0 : arrayList.size();
        int mapSize   = (hashMap   == null) ? 0 : hashMap.size();

        return "Количество элементов в ArrayList: " + arraySize
                + ", в HashMap: " + mapSize;
    }
}
