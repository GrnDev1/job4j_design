package ru.job4j.question;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int changed = 0;
        int deleted = 0;
        Map<Integer, String> map1 = previous.stream().collect(Collectors.toMap(User::getId, User::getName));
        Map<Integer, String> map2 = current.stream().collect(Collectors.toMap(User::getId, User::getName));
        Info result = new Info(0, changed, deleted);
        for (Integer key : map1.keySet()) {
            if (map2.containsKey(key)) {
                if (!Objects.equals(map1.get(key), map2.get(key))) {
                    result.setChanged(++changed);
                }
            } else {
                result.setDeleted(++deleted);
            }
        }
        int size = map1.size();
        map1.putAll(map2);
        result.setAdded(map1.size() - size);
        return result;
    }
}