package com.streams.katas;

import java.util.Comparator;
import java.util.List;

public class OldestPerson {

    public static Person getOldestPerson(final List<Person> collection) {
        //        return collection.stream().max(new Comparator<Person>() {
        //
        //            @Override
        //            public int compare(final Person p1, final Person p2) {
        //                if (p1.getAge() > p2.getAge())
        //                    return 1;
        //                return -1;
        //            }
        //
        //        }).get();

        // Simple statement lambda
        //        return collection.stream().max((p1, p2) -> {
        //            if (p1.getAge() > p2.getAge())
        //                return 1;
        //            return -1;
        //        }).get();

        return collection.stream().max(Comparator.comparingInt(person -> person.getAge())).get();
    }
}
