package pt.mf.aoc.day2;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Grab {
    private Map<Cube, Integer> cubes = new HashMap<>();
}
