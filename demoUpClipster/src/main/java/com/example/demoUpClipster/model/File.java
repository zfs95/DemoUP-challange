package com.example.demoUpClipster.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class File implements Comparable<File>{
    private int number;

    @Override
    public int compareTo(File o) {
        if(this.getNumber() == o.getNumber()) return 0;
        else if(this.getNumber() < o.getNumber()) return 1;
        return -1;
    }
}
