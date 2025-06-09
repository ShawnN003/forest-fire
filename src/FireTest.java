import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class FireTest {
    @Test
    public void testTimeToBurnExample() {
        char[][] forest = {
            {'t','.','.','t','t','t','t','.','t'},
            {'.','.','t','t','.','.','.','.','t'},
            {'.','.','t','t','t','t','t','t','t'},
            {'t','t','t','t','.','.','.','.','.'}
        };

        int matchR = 2;
        int matchC = 6;

        int expected = 8;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeNormal() {
        char[][] forest = {
            {'t','t','t','t','t'},
            {'t','t','t','t','t'},
            {'t','t','t','.','.'}
        };

        int matchR = 1;
        int matchC = 2;

        int expected = 3;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeZero() {
        char[][] forest = {
            {'t','.','t','t','t'},
            {'.','.','t','t','t'},
            {'t','t','t','t','t'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 1;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    // @Test
    // public void testGetPossibleBurns() {
    //     char[][] forest = {
    //         {'t','.','.','t','t','t','t','.','t'},
    //         {'.','.','t','t','.','.','.','.','t'},
    //         {'.','.','t','t','t','t','t','t','t'},
    //         {'t','t','t','t','.','.','.','.','.'}
    //     };

    //     int matchR = 2;
    //     int matchC = 3;

    //     List<int[]> possibleBurn = Fire.possibleBurns(forest, matchR, matchC);
    //     Set<String> convertedSet = convertToSet(possibleBurn);

    //     assertEquals(4, convertedSet.size());
    //     assertTrue(convertedSet.contains("2, 2"));
    //     assertTrue(convertedSet.contains("1, 3"));
    //     assertTrue(convertedSet.contains("2, 4"));
    //     assertTrue(convertedSet.contains("3, 3"));
    //     assertFalse(convertedSet.contains("3, 0"));
    // }

    // Set method to convert list to set to check what it contains
    private Set<String> convertToSet(List<int[]> list) {
        Set<String> converted = new HashSet<String>();

        for (int[] arr : list) {
            converted.add(arr[0] + ", " + arr[1]);
        }

        return converted;
    }
}
